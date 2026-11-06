package compat;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.util.ArrayList;
import java.util.List;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

/**
 * Горизонтальный экран. Высота игры (320) растягивается на всю высоту экрана, а в стороны игра
 * дорисовывает мир (см. engine.View / Display.setLogicalWidth). Поверх кадра — полупрозрачные
 * сенсорные кнопки: слева ◄ ► ▲ ▼, справа большая АТАКА, ПРЫЖОК и навыки 1·3·7·9, сверху пауза.
 * Мультитач; палец можно переводить с кнопки на кнопку. Коды — как в J2ME (Nokia).
 */
public class GameView extends SurfaceView implements SurfaceHolder.Callback, Display.Surface {
   private static final class Btn {
      final String label;
      final int code;      // J2ME key code; 0 = служебная кнопка (переключатель цифровой панели)
      final boolean numpad; // видна только при включённой цифровой панели
      final boolean slot;  // кнопка навыка
      float cx, cy, r;
      boolean down;

      Btn(String label, int code, boolean slot, boolean numpad) {
         this.label = label;
         this.code = code;
         this.slot = slot;
         this.numpad = numpad;
      }

      boolean hit(float x, float y) {
         float dx = x - cx, dy = y - cy, rr = r * 1.15f; // чуть увеличенная зона касания
         return dx * dx + dy * dy <= rr * rr;
      }
   }

   private final List<Btn> buttons = new ArrayList<Btn>();
   private final UiSkin skin = new UiSkin();
   private final BookFx fx = new BookFx();
   private boolean sfxInit;
   private final Paint bgPaint = new Paint();
   private final Paint framePaint = new Paint();
   private final Paint fillPaint = new Paint();
   private final Paint ringPaint = new Paint();
   private final Paint textPaint = new Paint();
   private final Paint sp = new Paint(), ep = new Paint();
   private final Rect src = new Rect();
   private final Rect dst = new Rect();
   private volatile boolean surfaceReady;

   public GameView(Context ctx) {
      super(ctx);
      getHolder().addCallback(this);
      setFocusable(true);
      setFocusableInTouchMode(true);
      framePaint.setFilterBitmap(false);
      Display.gpu = android.os.Build.VERSION.SDK_INT >= 26;
      bgPaint.setColor(0xFF000000);
      fillPaint.setAntiAlias(true);
      ringPaint.setAntiAlias(true);
      ringPaint.setStyle(Paint.Style.STROKE);
      textPaint.setAntiAlias(true);
      textPaint.setTextAlign(Paint.Align.CENTER);
      textPaint.setFakeBoldText(true);

      buttons.add(new Btn("left", -3, false, false));   // 0 влево
      buttons.add(new Btn("right", -4, false, false));  // 1 вправо
      buttons.add(new Btn("up", -1, false, false));     // 2 вверх (в меню — вверх, в игре — прыжок)
      buttons.add(new Btn("down", -2, false, false));   // 3 вниз
      buttons.add(new Btn("atk", -5, false, false));    // 4 удар / «ОК»
      buttons.add(new Btn("jump", -1, false, false));   // 5 тот же код, что и «вверх»
      buttons.add(new Btn("pause", -6, false, false));  // 6 левая софт-клавиша: «Меню» (пауза)
      int[] sk = {1, 3, 7, 9};                          // 7..10 умения (как слоты внизу экрана игры)
      for (int i = 0; i < 4; i++) {
         buttons.add(new Btn("s" + i, 48 + sk[i], true, false));
      }
      buttons.add(new Btn("info", -7, false, false));   // 11 правая софт-клавиша: «Инфо» / назад
   }

   private static void place(Btn b, float cx, float cy, float r) {
      b.cx = cx;
      b.cy = cy;
      b.r = r;
   }

   @Override
   protected void onSizeChanged(int w, int h, int ow, int oh) {
      super.onSizeChanged(w, h, ow, oh);
      if (w <= 0 || h <= 0) {
         return;
      }
      // высота кадра = высота экрана; ширина кадра подбирается так, чтобы заполнить экран
      float scale = h / (float) Display.HEIGHT;
      Display.setLogicalWidth(Math.round(w / scale));
      int fw = Math.round(Display.logicalWidth() * scale);
      int fx = Math.max(0, (w - fw) / 2);
      dst.set(fx, 0, fx + Math.min(fw, w), h);

      float u = h / 10f; // базовая единица раскладки
      // --- левый большой палец ---
      place(buttons.get(0), 2.3f * u, h - 1.9f * u, 1.05f * u);
      place(buttons.get(1), 4.7f * u, h - 1.9f * u, 1.05f * u);
      place(buttons.get(2), 3.5f * u, h - 4.15f * u, 0.8f * u);
      place(buttons.get(3), 6.6f * u, h - 1.2f * u, 0.55f * u);
      // --- правый большой палец ---
      place(buttons.get(4), w - 2.4f * u, h - 2.1f * u, 1.35f * u);
      place(buttons.get(5), w - 5.7f * u, h - 1.5f * u, 0.95f * u);
      // навыки дугой над атакой
      float[][] arc = {{-6.4f, -3.9f}, {-4.9f, -5.2f}, {-2.9f, -5.7f}, {-1.1f, -4.9f}};
      for (int i = 0; i < 4; i++) {
         place(buttons.get(7 + i), w + arc[i][0] * u, h + arc[i][1] * u, 0.62f * u);
      }
      // пауза и инфо — вверху справа
      place(buttons.get(6), w - 1.0f * u, 0.95f * u, 0.55f * u);
      place(buttons.get(11), w - 2.5f * u, 0.95f * u, 0.55f * u);
      ringPaint.setStrokeWidth(Math.max(2f, u * 0.045f));
   }

   private boolean visible(Btn b) {
      return true;
   }

   // ---------------- сглаживающий апскейл (Scale2x/EPX + билинейный показ) ----------------
   /** Выключить, если телефон не успевает: тогда кадр масштабируется "пиксель в пиксель". */
   public static volatile boolean smoothScale = true;
   /** Строка диагностики внизу экрана (шаги логики/с, показ/с и т.д.). */
   public static void setShowStats(boolean on) {
      engine.Fx.showStats = on;
      try {
         Res.context().getSharedPreferences("settings", 0).edit().putBoolean("stats", on).apply();
      } catch (Throwable ignored) {
      }
   }

   public static void loadSettings() {
      try {
         engine.Fx.showStats = Res.context().getSharedPreferences("settings", 0).getBoolean("stats", false);
      } catch (Throwable ignored) {
      }
   }
   private int[] pxOut;
   private Bitmap upBmp;
   private float upMs;
   private int upFrames;
   private static final int UP_WARMUP = 180;
   private static final float UP_LIMIT_MS = 14f;
   private boolean hwFailed;

   // Конвейер: поток показа только копирует кадр (1 мс), а сглаживание и вывод идут в отдельном потоке.
   // Так проигрывание кадра и апскейл выполняются одновременно на разных ядрах, а не друг за другом.
   private final Object upLock = new Object();
   private boolean upReady;
   private int[] stageIn;
   private int stageW, stageH;
   private Thread upThread;
   private final Object drawLock = new Object();
   private final Paint smoothPaint = new Paint();
   private int outFrames;
   private long outWindow;
   private volatile int outPerSec;

   private void upWorker() {
      while (true) {
         int[] in;
         int w, h;
         synchronized (upLock) {
            while (!upReady) {
               try {
                  upLock.wait();
               } catch (InterruptedException e) {
                  return;
               }
            }
            in = stageIn;
            w = stageW;
            h = stageH;
         }
         long t = System.nanoTime();
         if (pxOut == null || pxOut.length != w * h * 4) {
            pxOut = new int[w * h * 4];
            upBmp = Bitmap.createBitmap(w * 2, h * 2, Bitmap.Config.ARGB_8888);
         }
         scale2xParallel(in, pxOut, w, h);
         upBmp.setPixels(pxOut, 0, w * 2, 0, 0, w * 2, h * 2);
         synchronized (upLock) {
            upReady = false; // вход использован: поток показа может готовить следующий кадр
         }
         float ms = (System.nanoTime() - t) / 1000000f;
         upFrames++;
         // первые кадры идут в интерпретаторе (JIT ещё не прогрелся) и всегда медленные - их не учитываем
         if (upFrames <= UP_WARMUP) {
            upMs = ms;
         } else {
            upMs = upMs * 0.97f + ms * 0.03f;
            if (upMs > UP_LIMIT_MS) {
               smoothScale = false; // реально слишком медленно для этого телефона (касание строки статистики включает обратно)
            }
         }
         drawFrame(upBmp, smoothPaint);
      }
   }

   /** Scale2x (EPX): углы и диагонали сглаживаются, плоские области и острые края сохраняются. */
   static void scale2x(int[] s, int[] d, int w, int h) {
      scale2xRows(s, d, w, h, 0, h);
   }

   private static final int UP_THREADS = Math.max(1, Math.min(4, Runtime.getRuntime().availableProcessors()));
   private java.util.concurrent.ExecutorService upPool;

   /** То же, но полосами по строкам на нескольких ядрах: на телефоне это в 2-3 раза быстрее одного потока. */
   private void scale2xParallel(final int[] s, final int[] d, final int w, final int h) {
      if (UP_THREADS < 2 || h < 64) {
         scale2xRows(s, d, w, h, 0, h);
         return;
      }
      if (upPool == null) {
         upPool = java.util.concurrent.Executors.newFixedThreadPool(UP_THREADS - 1, new java.util.concurrent.ThreadFactory() {
            public Thread newThread(Runnable r) {
               Thread t = new Thread(r, "upscale");
               t.setDaemon(true);
               return t;
            }
         });
      }
      int band = (h + UP_THREADS - 1) / UP_THREADS;
      java.util.List<java.util.concurrent.Future<?>> fs = new ArrayList<java.util.concurrent.Future<?>>();
      for (int i = 1; i < UP_THREADS; i++) {
         final int y0 = i * band, y1 = Math.min(h, y0 + band);
         if (y0 >= y1) {
            break;
         }
         fs.add(upPool.submit(new Runnable() {
            public void run() {
               scale2xRows(s, d, w, h, y0, y1);
            }
         }));
      }
      scale2xRows(s, d, w, h, 0, Math.min(h, band));
      for (java.util.concurrent.Future<?> f : fs) {
         try {
            f.get();
         } catch (Exception e) {
            scale2xRows(s, d, w, h, 0, h); // на всякий случай: пересчитать целиком в этом потоке
            break;
         }
      }
   }

   static void scale2xRows(int[] s, int[] d, int w, int h, int yFrom, int yTo) {
      PixelScale.x2Rows(s, d, w, h, yFrom, yTo);
   }

   // ---------------- Display.Surface ----------------
   @Override
   public void present(Image frame) {
      if (!surfaceReady) {
         return;
      }
      Bitmap fb = frame.getBitmap();
      if (!smoothScale) {
         drawFrame(fb, framePaint);
         return;
      }
      int w = fb.getWidth(), h = fb.getHeight();
      synchronized (upLock) {
         if (upThread == null) {
            smoothPaint.setFilterBitmap(true);
            upThread = new Thread(new Runnable() {
               public void run() {
                  upWorker();
               }
            }, "upscale-present");
            upThread.setDaemon(true);
            upThread.start();
         }
         if (upReady) {
            return; // сглаживатель ещё занят прошлым кадром - этот пропускаем
         }
         if (stageIn == null || stageIn.length != w * h) {
            stageIn = new int[w * h];
         }
         stageW = w;
         stageH = h;
         fb.getPixels(stageIn, 0, w, 0, 0, w, h);
         upReady = true;
         upLock.notifyAll();
      }
   }

   private Graphics gg;
   private int ggW;
   private volatile boolean gpuDrawn;

   private String modeText() {
      if (gpuDrawn) {
         return "  GPU вывод " + outPerSec + "/с";
      }
      return smoothScale ? "  ап2x " + Math.round(upMs) + "мс вывод " + outPerSec + "/с" : "  апскейл выкл";
   }

   /** Кадр прямо на экран на видеокарте: команды рисования проигрываются на аппаратном Canvas с матрицей масштаба. */
   @Override
   public boolean presentReplay(float alpha) {
      if (!surfaceReady) {
         return false; // поверхность ещё не создана (старт): режим видеокарты не сбрасываем, кадр придёт позже
      }
      if (hwFailed || android.os.Build.VERSION.SDK_INT < 26) {
         Display.gpu = false;
         gpuDrawn = false;
         return false;
      }
      int w = Display.replayWidth();
      if (w <= 0 || !Display.replayReady()) {
         return false;
      }
      synchronized (drawLock) {
         SurfaceHolder holder = getHolder();
         Canvas c = null;
         try {
            c = holder.lockHardwareCanvas();
            if (c == null) {
               return false;
            }
            c.drawRect(0, 0, c.getWidth(), c.getHeight(), bgPaint);
            if (gg == null || ggW != w) {
               gg = new Graphics(null, w, Display.HEIGHT);
               gg.setWide((w - Display.WIDTH) / 2);
               ggW = w;
            }
            float k = dst.height() / (float) Display.HEIGHT;
            c.save();
            c.translate(dst.left, dst.top);
            c.scale(k, k);
            gg.bindGpu(c, 2);
            try {
               Display.replayInto(gg, alpha);
            } finally {
               gg.unbind();
               c.restore();
            }
            gpuDrawn = true;
            drawOverlay(c);
            return true;
         } catch (Throwable e) {
            System.err.println("GPU: " + e);
            Display.gpu = false; // сбой - навсегда возвращаемся к прежнему способу вывода
            gpuDrawn = false;
            return false;
         } finally {
            if (c != null) {
               try {
                  holder.unlockCanvasAndPost(c);
               } catch (Throwable ignored) {
               }
               countOut();
            }
         }
      }
   }

   private int[] gIn, gOut;
   private Bitmap gBmp;
   private final Paint gPaint = new Paint();

   /** Готовый растровый кадр (меню/заставки) через видеокарту: Scale2x на процессоре один раз на кадр, вывод и масштаб - аппаратные. */
   @Override
   public boolean presentBitmapGpu(Image frame) {
      if (!surfaceReady) {
         return false; // поверхность ещё не создана (старт): режим видеокарты не сбрасываем, кадр придёт позже
      }
      if (hwFailed || android.os.Build.VERSION.SDK_INT < 26) {
         Display.gpu = false;
         gpuDrawn = false;
         return false;
      }
      Bitmap fb = frame.getBitmap();
      int w = fb.getWidth(), h = fb.getHeight();
      synchronized (drawLock) {
         SurfaceHolder holder = getHolder();
         Canvas c = null;
         try {
            if (gIn == null || gIn.length != w * h) {
               gIn = new int[w * h];
               gOut = new int[w * h * 4];
               gBmp = Bitmap.createBitmap(w * 2, h * 2, Bitmap.Config.ARGB_8888);
               gPaint.setFilterBitmap(true);
            }
            fb.getPixels(gIn, 0, w, 0, 0, w, h);
            scale2xParallel(gIn, gOut, w, h);
            gBmp.setPixels(gOut, 0, w * 2, 0, 0, w * 2, h * 2);
            c = holder.lockHardwareCanvas();
            if (c == null) {
               return false;
            }
            c.drawRect(0, 0, c.getWidth(), c.getHeight(), bgPaint);
            src.set(0, 0, w * 2, h * 2);
            c.drawBitmap(gBmp, src, dst, gPaint);
            if (Display.hybridReady()) {
               // растр даёт фон и боковые поля, а картинки и текст кадра дорисовываются поверх в полном разрешении
               if (gg == null || ggW != w) {
                  gg = new Graphics(null, w, Display.HEIGHT);
                  gg.setWide((w - Display.WIDTH) / 2);
                  ggW = w;
               }
               int ex = (w - Display.WIDTH) / 2;
               float k = dst.height() / (float) Display.HEIGHT;
               c.save();
               c.translate(dst.left, dst.top);
               c.scale(k, k);
               c.clipRect(ex, 0, ex + Display.WIDTH, Display.HEIGHT);
               gg.bindGpu(c, 2);
               try {
                  Display.replayHybrid(gg);
               } finally {
                  gg.unbind();
                  c.restore();
               }
            }
            gpuDrawn = true;
            drawOverlay(c);
            return true;
         } catch (Throwable e) {
            System.err.println("GPU bitmap: " + e);
            gpuDrawn = false;
            return false;
         } finally {
            if (c != null) {
               try {
                  holder.unlockCanvasAndPost(c);
               } catch (Throwable ignored) {
               }
               countOut();
            }
         }
      }
   }

   private void countOut() {
      outFrames++;
      long now = System.nanoTime();
      if (now - outWindow >= 1000000000L) {
         outPerSec = (int) Math.round(outFrames * 1e9 / (now - outWindow));
         outFrames = 0;
         outWindow = now;
      }
   }

   private void drawOverlay(Canvas c) {
      Display.animating = fx.draw(c, c.getWidth(), c.getHeight(), dst);
      if (engine.Fx.showStats) {
         sp.setTextSize(Math.max(20f, dst.width() / 48f));
         sp.setColor(0xCC000000);
         c.drawRect(0, c.getHeight() - sp.getTextSize() * 1.5f, c.getWidth() * 0.62f, c.getHeight(), sp);
         sp.setColor(0xFF66FF66);
         c.drawText(Display.stats() + modeText(), 8, c.getHeight() - sp.getTextSize() * 0.35f, sp);
      }
      java.util.List<String> errs = ErrLog.snapshot();
      if (!errs.isEmpty()) {
         ep.setTextSize(Math.max(22f, dst.width() / 36f));
         ep.setColor(0xCC000000);
         float lh = ep.getTextSize() * 1.15f;
         c.drawRect(0, 0, c.getWidth(), lh * errs.size() + 8, ep);
         ep.setColor(0xFFFF5555);
         for (int i = 0; i < errs.size(); i++) {
            c.drawText(errs.get(i), 6, lh * (i + 1), ep);
         }
      }
      int[] st = null;
      try {
         st = main.f.uiState();
      } catch (Throwable ignored) {
      }
      for (Btn b : buttons) {
         skin.draw(c, b.label, b.cx, b.cy, b.r, b.down, st);
      }
   }

   private void drawFrame(Bitmap bm, Paint paint) {
      synchronized (drawLock) {
      SurfaceHolder holder = getHolder();
      Canvas c = null;
      try {
         // аппаратный Canvas: масштабирование большого кадра делает видеокарта (программный даёт ~10 показов/с)
         if (!hwFailed && android.os.Build.VERSION.SDK_INT >= 26) {
            try {
               c = holder.lockHardwareCanvas();
            } catch (RuntimeException e) {
               hwFailed = true;
            }
         }
         if (c == null) {
            c = holder.lockCanvas();
         }
         if (c == null) {
            return;
         }
         c.drawRect(0, 0, c.getWidth(), c.getHeight(), bgPaint);
         src.set(0, 0, bm.getWidth(), bm.getHeight());
         c.drawBitmap(bm, src, dst, paint);
         drawOverlay(c);
      } finally {
         if (c != null) {
            holder.unlockCanvasAndPost(c);
            gpuDrawn = false;
            countOut();
         }
      }
      }
   }

   @Override
   public void surfaceCreated(SurfaceHolder h) {
      surfaceReady = true;
      if (!sfxInit) {
         sfxInit = true;
         loadSettings();
         engine.Fx.onStats = new Runnable() {
            public void run() {
               setShowStats(engine.Fx.showStats);
            }
         };
         Sfx sfx = new Sfx();
         sfx.init();
         engine.Fx.sink = sfx;
      }
      final android.view.Choreographer ch = android.view.Choreographer.getInstance();
      if (ch != null) {
         ch.postFrameCallback(new android.view.Choreographer.FrameCallback() {
            @Override
            public void doFrame(long t) {
               Display.vsync();
               if (surfaceReady) {
                  ch.postFrameCallback(this);
               }
            }
         });
      }
      Display.presentAgain();
   }

   @Override
   public void surfaceChanged(SurfaceHolder h, int f, int w, int hh) {
      Display.presentAgain();
   }

   @Override
   public void surfaceDestroyed(SurfaceHolder h) {
      surfaceReady = false;
   }

   // ---------------- touch ----------------
   @Override
   public boolean onTouchEvent(MotionEvent ev) {
      int action = ev.getActionMasked();
      if (engine.Fx.showStats && action == MotionEvent.ACTION_DOWN && ev.getY() > getHeight() - 56 && ev.getX() < getWidth() * 0.62f) {
         boolean onButton = false;
         for (Btn b : buttons) {
            onButton |= b.hit(ev.getX(), ev.getY());
         }
         if (!onButton) { // касание строки диагностики: вкл/выкл сглаживающий апскейл
            // цикл режимов: видеокарта -> сглаживание на процессоре -> без сглаживания -> видеокарта
            if (Display.gpu) {
               Display.gpu = false;
               smoothScale = true;
            } else if (smoothScale) {
               smoothScale = false;
            } else {
               smoothScale = true;
               Display.gpu = android.os.Build.VERSION.SDK_INT >= 26 && !hwFailed;
            }
            upFrames = 0;
            upMs = 0;
            Display.presentAgain();
            return true;
         }
      }
      boolean cancel = action == MotionEvent.ACTION_CANCEL;
      int skip = (action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_POINTER_UP) ? ev.getActionIndex() : -1;
      int n = buttons.size();
      boolean[] want = new boolean[n];
      if (!cancel) {
         for (int i = 0; i < ev.getPointerCount(); i++) {
            if (i == skip) {
               continue;
            }
            float x = ev.getX(i), y = ev.getY(i);
            // каждый палец активирует ближайшую подходящую кнопку (приоритет — последней в списке: мелкие сверху)
            Btn best = null;
            float bestD = Float.MAX_VALUE;
            for (Btn b : buttons) {
               if (visible(b) && b.hit(x, y)) {
                  float dd = (x - b.cx) * (x - b.cx) + (y - b.cy) * (y - b.cy);
                  if (dd < bestD) {
                     bestD = dd;
                     best = b;
                  }
               }
            }
            if (best != null) {
               want[buttons.indexOf(best)] = true;
            }
         }
      }
      for (int k = 0; k < n; k++) {
         Btn b = buttons.get(k);
         if (want[k] != b.down) {
            b.down = want[k];
            Display.key(b.down, b.code);
         }
      }
      return true;
   }
}
