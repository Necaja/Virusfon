package javax.microedition.lcdui;

import javax.microedition.midlet.MIDlet;

/**
 * Единственный "дисплей" 240x320. Рисует Canvas.paint() в оффскрин-Image и отдаёт кадр
 * Android-поверхности через {@link Surface}. repaint() — асинхронно (поток-насос),
 * serviceRepaints() — синхронно в вызывающем потоке, как в J2ME.
 */
public class Display {
   public static final int WIDTH = 240;
   public static final int HEIGHT = 320;

   /** Куда выводить готовый кадр (реализует Android GameView). */
   public interface Surface {
      void present(Image frame);
   }

   private static final Display INSTANCE = new Display();
   private static volatile Displayable current;
   private static volatile Surface surface;
   private static volatile boolean dirty;
   private static final Object lock = new Object();
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
      synchronized (lock) {
         if (!dirty) {
            return;
         }
         dirty = false;
         if (back == null) {
            back = Image.createImage(WIDTH, HEIGHT);
            backG = back.getGraphics();
         }
         backG.reset();
         try {
            ((Canvas) d).hostPaint(backG);
         } catch (Throwable e) {
            e.printStackTrace();
         }
         Surface s = surface;
         if (s != null) {
            s.present(back);
         }
      }
   }

   /** Перерисовать последний кадр (например, после смены состояния кнопок оверлея). */
   public static void presentAgain() {
      synchronized (lock) {
         Surface s = surface;
         if (s != null && back != null) {
            s.present(back);
         }
      }
   }
}
