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

      /** Нарисовать последний кадр прямо на экране (на видеокарте) из записи команд; false - не вышло, используйте present(). */
      boolean presentReplay(float alpha);
   }

   /** Рисовать кадры на видеокарте прямо из записи команд (выставляет GameView, если телефон поддерживает). */
   public static volatile boolean gpu;
   /** Идёт экранный эффект (книга/свиток): кадры нужно выводить непрерывно, по сигналу вертикальной синхронизации. */
   public static volatile boolean animating;
   private static volatile boolean presFull, pubFull;

   /** Ширина (логическая) кадра, соответствующего последней опубликованной записи. */
   public static int replayWidth() {
      Image pb = pubBack;
      return pb == null ? 0 : pb.getWidth();
   }

   /** Есть ли полная запись последнего кадра для показа на видеокарте. */
   public static boolean replayReady() {
      synchronized (pubLock) {
         if (pubSeq != presSeq) {
            syncPres();
         }
      }
      return presFull;
   }

   /** Проиграть запись последнего кадра на g (alpha 1 = как есть, меньше - сдвиг движущихся групп назад). */
   public static boolean replayInto(Graphics g, float alpha) {
      synchronized (midLock) {
         if (!presFull) {
            return false;
         }
         presRec.replay(g, presDx, presDy, alpha);
         return true;
      }
   }

   // ---------- интерполяция кадров (логика игры ~20 кадров/с, показ ~60) ----------
   /** Включить плавную дорисовку промежуточных кадров. */
   public static volatile boolean interpolate = true;
   private static final int MAXT = 1024;
   private static final int[] tpx = new int[MAXT], tpy = new int[MAXT], tdx = new int[MAXT], tdy = new int[MAXT];
   private static final int[] tseen = new int[MAXT];
   private static int frameSeq = 1;
   private static boolean anyDelta;
   private static final Rec rec = new Rec();
   private static volatile boolean replayable;
   private static volatile boolean exactPending;
   private static volatile long frameNs;
   private static volatile long periodNs = 50000000L;
   private static Image mid;
   private static Graphics midG;
   private static final Object presLock = new Object();

   /**
    * Пометить следующие команды рисования как группу, которая движется как одно целое (карта, персонаж).
    * (x,y) — экранное положение группы в этом кадре; разность с прошлым кадром задаёт смещение для промежуточных кадров.
    * id 0 — снять пометку. Вызывается из paint().
    */
   public static void tag(int id, int x, int y) {
      Graphics g = backG;
      if (g == null) {
         return;
      }
      if (id <= 0 || id >= MAXT) {
         g.recTag(0);
         return;
      }
      if (tseen[id] != frameSeq) {
         int dx = 0, dy = 0;
         if (tseen[id] == frameSeq - 1) {
            dx = x - tpx[id];
            dy = y - tpy[id];
            if (Math.abs(dx) > 48 || Math.abs(dy) > 48) {
               dx = 0;
               dy = 0;
            }
         }
         tdx[id] = dx;
         tdy[id] = dy;
         tpx[id] = x;
         tpy[id] = y;
         tseen[id] = frameSeq;
         if (dx != 0 || dy != 0) {
            anyDelta = true;
         }
      }
      g.recTag(id);
   }

   // ----- опубликованный кадр: копия для потока показа, чтобы он никогда не задерживал игровой поток -----
   private static final Object pubLock = new Object();
   private static final Rec pubRec = new Rec(), presRec = new Rec();
   private static final int[] pubDx = new int[MAXT], pubDy = new int[MAXT], presDx = new int[MAXT], presDy = new int[MAXT];
   private static Image pubBack;
   private static Graphics pubG;
   private static boolean pubReplayable;
   private static int pubSeq, presSeq;
   private static final Object midLock = new Object();

   // ----- диагностика и синхронизация с кадровой частотой экрана -----
   private static final Object vsyncLock = new Object();
   private static long vsyncSeq;
   private static volatile boolean vsyncSeen;
   private static int stTicks, stShown, stReplay, stExact;
   private static long stPaintNs, stMaxGapNs, stLastShowNs, stWindowNs;
   private static volatile String statsText = "";

   /** Вызывается GameView по сигналу вертикальной синхронизации (Choreographer). */
   public static void vsync() {
      vsyncSeen = true;
      synchronized (vsyncLock) {
         vsyncSeq++;
         vsyncLock.notifyAll();
      }
   }

   /** Строка статистики: логических шагов/с, показанных кадров/с (из них интерполированных), время paint(), макс. пауза показа. */
   public static String stats() {
      return statsText;
   }

   private static synchronized void statShown(boolean replay) {
      long now = System.nanoTime();
      if (stLastShowNs != 0) {
         stMaxGapNs = Math.max(stMaxGapNs, now - stLastShowNs);
      }
      stLastShowNs = now;
      stShown++;
      if (replay) {
         stReplay++;
      } else {
         stExact++;
      }
      if (stWindowNs == 0) {
         stWindowNs = now;
      }
      if (now - stWindowNs >= 1000000000L) {
         double sec = (now - stWindowNs) / 1e9;
         statsText = String.format("tick %.0f/с  показ %.0f/с (интерп %.0f)  paint %.0fмс  пауза<=%.0fмс",
               stTicks / sec, stShown / sec, stReplay / sec, stTicks == 0 ? 0 : stPaintNs / 1e6 / stTicks, stMaxGapNs / 1e6);
         stTicks = 0;
         stShown = 0;
         stReplay = 0;
         stExact = 0;
         stPaintNs = 0;
         stMaxGapNs = 0;
         stWindowNs = now;
      }
   }


   /** Вызывается под lock в конце кадра: копирует результат для потока показа. */
   private static void publish() {
      synchronized (pubLock) {
         if (pubBack == null || pubBack.getWidth() != back.getWidth()) {
            pubBack = Image.createImage(back.getWidth(), HEIGHT);
            pubG = pubBack.getGraphics();
            pubG.setWide(extra());
         }
         pubG.reset();
         pubG.drawImage(back, -extra(), 0, Graphics.TOP | Graphics.LEFT);
         pubReplayable = replayable;
         pubFull = !rec.overflow && (worldFrame || extra() == 0);
         if (replayable || pubFull) {
            pubRec.copyFrom(rec);
            System.arraycopy(tdx, 0, pubDx, 0, MAXT);
            System.arraycopy(tdy, 0, pubDy, 0, MAXT);
         }
         pubNs = System.nanoTime();
         pubSeq++;
      }
   }

   /** Промежуточный кадр между прошлым (alpha=0) и последним (alpha=1) логическим кадром. Для отладки/тестов. */
   public static Image interpolated(float alpha) {
      synchronized (pubLock) {
         if (pubSeq != presSeq) {
            syncPres();
         }
      }
      return replayMid(alpha);
   }

   /** Под pubLock: забрать последний опубликованный кадр. */
   private static void syncPres() {
      // Непрерывность движения: фаза нового интервала продолжает фазу старого (избыток/недобор переносится),
      // иначе любая неточность оценки периода даёт рывок всего экрана раз в логический кадр.
      double aOld = alphaBase + (pubNs - arrivalNs) / (double) periodNs;
      alphaBase = (presReplayable && pubReplayable) ? Math.max(-0.5, Math.min(0.5, (aOld - 1.0) * 0.9)) : 0.0;
      arrivalNs = pubNs;
      if (pubReplayable || pubFull) {
         presRec.copyFrom(pubRec);
         System.arraycopy(pubDx, 0, presDx, 0, MAXT);
         System.arraycopy(pubDy, 0, presDy, 0, MAXT);
      }
      presReplayable = pubReplayable;
      presFull = pubFull;
      presSeq = pubSeq;
   }

   private static boolean presReplayable;
   private static double alphaBase;
   private static long arrivalNs, pubNs;

   private static Image replayMid(float alpha) {
      synchronized (midLock) {
         Image pb = pubBack;
         if (pb == null || !presReplayable) {
            return null;
         }
         if (mid == null || mid.getWidth() != pb.getWidth()) {
            mid = Image.createImage(pb.getWidth(), HEIGHT);
            midG = mid.getGraphics();
            midG.setWide((pb.getWidth() - WIDTH) / 2);
         }
         presRec.replay(midG, presDx, presDy, alpha);
         return mid;
      }
   }

   private static void presenterLoop() {
      while (true) {
         try {
            long t0 = System.nanoTime();
            boolean busy = false;
            if (animating) {
               exactPending = true;
               busy = true;
            }
            Surface s = surface;
            boolean gpuHandled = false;
            Image exact = null;
            boolean rep;
            synchronized (pubLock) {
               if (pubSeq != presSeq) {
                  syncPres();
               }
               rep = presReplayable;
               exact = pubBack;
            }
            if (s != null && exact != null) {
               float a = (float) (alphaBase + (t0 - arrivalNs) / (double) periodNs);
               if (gpu && presFull) {
                  boolean ok = false;
                  if (interpolate && rep && a <= 1.5f) {
                     ok = s.presentReplay(Math.max(-0.5f, a));
                     if (ok) {
                        statShown(true);
                        busy = true;
                     }
                  } else if (exactPending) {
                     exactPending = false;
                     ok = s.presentReplay(1f);
                     if (ok) {
                        statShown(false);
                     } else {
                        exactPending = true; // не вышло - отдадим кадр прежним способом
                     }
                  } else {
                     ok = true; // ничего нового показывать не нужно
                  }
                  if (ok) {
                     gpuHandled = true;
                  }
               }
               if (gpuHandled) {
                  gpuHandled = false;
               } else if (interpolate && rep && a <= 1.5f) {
                  Image m = replayMid(Math.max(-0.5f, a));
                  if (m != null) {
                     s.present(m);
                     statShown(true);
                     busy = true;
                  }
               } else if (exactPending) {
                  exactPending = false;
                  s.present(exact);
                  statShown(false);
               }
            }
            if (busy) {
               if (vsyncSeen) {
                  // ждём следующий сигнал экрана — кадры уходят ровно, без дрожи интервалов
                  synchronized (vsyncLock) {
                     long seq = vsyncSeq;
                     long end = System.nanoTime() + 40000000L;
                     while (vsyncSeq == seq) {
                        long left = end - System.nanoTime();
                        if (left <= 0) {
                           break;
                        }
                        vsyncLock.wait(left / 1000000L, (int) (left % 1000000L));
                     }
                  }
               } else {
                  long left = 16600000L - (System.nanoTime() - t0);
                  if (left > 0) {
                     Thread.sleep(left / 1000000L, (int) (left % 1000000L));
                  }
               }
            } else {
               synchronized (presLock) {
                  if (!exactPending) {
                     presLock.wait(40);
                  }
               }
            }
         } catch (InterruptedException e) {
            return;
         } catch (Throwable e) {
            e.printStackTrace();
            try {
               Thread.sleep(50);
            } catch (InterruptedException ie) {
               return;
            }
         }
      }
   }

   private static void wakePresenter() {
      exactPending = true;
      synchronized (presLock) {
         presLock.notifyAll();
      }
   }

   private static volatile Displayable current;
   private static volatile Surface surface;
   private static volatile boolean dirty;
   private static final ReentrantLock lock = new ReentrantLock();
   private static final Object pumpLock = new Object();
   private static Image back;
   private static Graphics backG;
   private static final Display INSTANCE = new Display();

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
      Thread pt = new Thread(new Runnable() {
         public void run() {
            presenterLoop();
         }
      }, "lcdui-present");
      pt.setDaemon(true);
      pt.setPriority(Thread.NORM_PRIORITY - 1);
      pt.start();
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
         frameSeq++;
         anyDelta = false;
         rec.clear();
         backG.setRec(rec);
         long pt0 = System.nanoTime();
         try {
            ((Canvas) d).hostPaint(backG);
         } catch (Throwable e) {
            e.printStackTrace();
         }
         stPaintNs += System.nanoTime() - pt0;
         stTicks++;
         backG.setRec(null);
         try {
            if (!worldFrame && extra() > 0) {
               extendSides();
            }
         } catch (Throwable e) {
            e.printStackTrace();
         }
         long now = System.nanoTime();
         long dt = now - frameNs;
         frameNs = now;
         if (dt > 20000000L && dt < 250000000L) {
            periodNs = Math.max(33000000L, Math.min(100000000L, (periodNs * 3 + dt) / 4));
         }
         replayable = worldFrame && rec.tagged && !rec.overflow && anyDelta;
         publish();
         wakePresenter();
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
      if (back != null) {
         wakePresenter();
      }
   }
}
