package javax.microedition.lcdui;

import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.midlet.MIDlet;

/**
 * Единственный "дисплей" 240x320. Рисует Canvas.paint() в оффскрин-Image и отдаёт кадр
 * Android-поверхности через {@link Surface}. repaint() — асинхронно (поток-насос),
 * serviceRepaints() — синхронно в вызывающем потоке, как в J2ME.
 */
public class Display {
   /** Базовая (исходная J2ME) ширина экрана — центральная область, в которой верстается весь интерфейс игры. */
   public static final int WIDTH = 240;
   public static final int HEIGHT = 320;
   /** Максимальная логическая ширина "широкого" кадра. */
   public static final int MAX_WIDTH = 720;

   private static volatile int logicalWidth = WIDTH;
   private static volatile boolean worldFrame;
   private static Image sideTmp;
   private static Graphics sideG;
   private static Image blur1, blur2;
   private static Graphics blur1G, blur2G;

   /** Игра сама дорисовала мир на всю ширину в этом кадре (иначе боковые поля достраиваются зеркалом). */
   public static void markWorld() {
      worldFrame = true;
   }

   /** Текущая логическая ширина кадра (>= 240, чётная разница с 240): центр 240 + по (w-240)/2 с боков. */
   public static int logicalWidth() {
      return logicalWidth;
   }

   /** Боковая добавка с каждой стороны, пикселей логического экрана. */
   public static int extra() {
      return (logicalWidth - WIDTH) / 2;
   }

   /** Задать ширину широкого кадра (высота всегда 320). Не блокирует UI-поток: буфер пересоздаётся при следующей отрисовке. */
   public static void setLogicalWidth(int w) {
      w = Math.max(WIDTH, Math.min(MAX_WIDTH, w));
      w = WIDTH + ((w - WIDTH) / 2) * 2;
      if (w != logicalWidth) {
         logicalWidth = w;
         dirty = true;
      }
   }

   /** Куда выводить готовый кадр (реализует Android GameView). */
   public interface Surface {
      void present(Image frame);
   }

   private static final Display INSTANCE = new Display();
   private static volatile Displayable current;
   private static volatile Surface surface;
   private static volatile boolean dirty;
   private static final ReentrantLock lock = new ReentrantLock();
   private static final Object pumpLock = new Object();
   private static Image back;
   private static Graphics backG;

   private Display() {
      Thread t = new Thread(new Runnable() {
         public void run() {
            while (true) {
               try {
                  synchronized (pumpLock) {
                     if (!dirty) {
                        pumpLock.wait(100);
                     }
                  }
                  if (dirty) {
                     renderNow();
                  }
               } catch (InterruptedException e) {
                  return;
               } catch (Throwable e) {
                  e.printStackTrace();
               }
            }
         }
      }, "lcdui-repaint");
      t.setDaemon(true);
      t.start();
   }

   public static Display getDisplay(MIDlet m) {
      return INSTANCE;
   }

   public static void setSurface(Surface s) {
      surface = s;
   }

   public Displayable getCurrent() {
      return current;
   }

   public void setCurrent(Displayable d) {
      Displayable old = current;
      if (old == d) {
         return;
      }
      if (old instanceof Canvas) {
         ((Canvas) old).hostHide();
      }
      current = d;
      if (d instanceof Canvas) {
         ((Canvas) d).hostShow();
         requestRepaint();
      }
   }

   public boolean vibrate(int millis) {
      return false;
   }

   public boolean flashBacklight(int millis) {
      return false;
   }

   /** Клавиша с хоста (-1..-7 = стрелки/софт-клавиши, 48..57 цифры, 42 '*', 35 '#'). */
   public static void key(boolean down, int code) {
      Displayable d = current;
      if (d instanceof Canvas) {
         ((Canvas) d).hostKey(down, code);
      }
   }

   static void requestRepaint() {
      dirty = true;
      synchronized (pumpLock) {
         pumpLock.notifyAll();
      }
   }

   static void renderNow() {
      Displayable d = current;
      if (!(d instanceof Canvas)) {
         return;
      }
      lock.lock();
      try {
         if (!dirty) {
            return;
         }
         dirty = false;
         if (back == null || back.getWidth() != logicalWidth) {
            back = Image.createImage(logicalWidth, HEIGHT);
            backG = back.getGraphics();
            backG.setWide(extra());
         }
         backG.reset();
         worldFrame = false;
         try {
            ((Canvas) d).hostPaint(backG);
            if (!worldFrame && extra() > 0) {
               extendSides();
            }
         } catch (Throwable e) {
            e.printStackTrace();
         }
         Surface s = surface;
         if (s != null) {
            s.present(back);
         }
      } finally {
         lock.unlock();
      }
   }

   /** Для экранов интерфейса (меню, заставки): поля по бокам = размытое затемнённое продолжение центра. */
   private static void extendSides() {
      if (sideTmp == null) {
         sideTmp = Image.createImage(WIDTH, HEIGHT);
         sideG = sideTmp.getGraphics();
         blur1 = Image.createImage(60, 80);
         blur1G = blur1.getGraphics();
         blur2 = Image.createImage(15, 20);
         blur2G = blur2.getGraphics();
      }
      int ex = extra();
      sideG.reset();
      sideG.drawImage(back, -ex, 0, Graphics.TOP | Graphics.LEFT);   // копия центра 240x320
      blur1G.drawScaled(sideTmp, 0, 0, 60, 80);
      blur2G.drawScaled(blur1, 0, 0, 15, 20);
      backG.reset();
      backG.setClip(-ex, 0, ex, HEIGHT);
      backG.drawScaled(blur2, -ex, 0, logicalWidth, HEIGHT);
      backG.setClip(240, 0, ex, HEIGHT);
      backG.drawScaled(blur2, -ex, 0, logicalWidth, HEIGHT);
      backG.setClip(-ex, 0, ex, HEIGHT);
      backG.fillRectArgb(-ex, 0, ex, HEIGHT, 0x88000000);
      backG.setClip(240, 0, ex, HEIGHT);
      backG.fillRectArgb(240, 0, ex, HEIGHT, 0x88000000);
      backG.setClip(-ex, 0, logicalWidth, HEIGHT);
   }

   /** Перерисовать последний кадр (например, после смены состояния кнопок оверлея). */
   public static void presentAgain() {
      // вызывается из UI-потока: НИКОГДА не ждём, пока игровой поток рисует/грузит уровень
      if (lock.tryLock()) {
         try {
            Surface s = surface;
            if (s != null && back != null) {
               s.present(back);
            }
         } finally {
            lock.unlock();
         }
      }
   }
}
