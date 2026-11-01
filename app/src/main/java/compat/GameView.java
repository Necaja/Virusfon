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
   private final Btn toggle = new Btn("123", 0, false, false);
   private final Paint bgPaint = new Paint();
   private final Paint framePaint = new Paint();
   private final Paint fillPaint = new Paint();
   private final Paint ringPaint = new Paint();
   private final Paint textPaint = new Paint();
   private final Rect src = new Rect();
   private final Rect dst = new Rect();
   private volatile boolean surfaceReady;
   private volatile boolean numpadOn;

   public GameView(Context ctx) {
      super(ctx);
      getHolder().addCallback(this);
      setFocusable(true);
      setFocusableInTouchMode(true);
      framePaint.setFilterBitmap(false);
      bgPaint.setColor(0xFF000000);
      fillPaint.setAntiAlias(true);
      ringPaint.setAntiAlias(true);
      ringPaint.setStyle(Paint.Style.STROKE);
      textPaint.setAntiAlias(true);
      textPaint.setTextAlign(Paint.Align.CENTER);
      textPaint.setFakeBoldText(true);

      buttons.add(new Btn("◄", -3, false, false));    // 0 влево
      buttons.add(new Btn("►", -4, false, false));    // 1 вправо
      buttons.add(new Btn("▲", -1, false, false));    // 2 вверх (в игре — прыжок; в меню — вверх)
      buttons.add(new Btn("▼", -2, false, false));    // 3 вниз
      buttons.add(new Btn("АТАКА", -5, false, false)); // 4 fire / OK
      buttons.add(new Btn("ПРЫЖОК", -1, false, false)); // 5 тот же код, что и «вверх»
      buttons.add(new Btn("❚❚", -6, false, false));   // 6 пауза (левая софт-клавиша: «Меню» в игре)
      int[] sk = {1, 3, 7, 9};                         // 7..10 навыки (как на панели в игре)
      for (int n : sk) {
         buttons.add(new Btn(String.valueOf(n), 48 + n, true, false));
      }
      String[] more = {"0", "2", "4", "5", "6", "8", "*", "#"};
      int[] codes = {48, 50, 52, 53, 54, 56, 42, 35};
      for (int i = 0; i < more.length; i++) {
         buttons.add(new Btn(more[i], codes[i], false, true));
      }
      buttons.add(new Btn("ИНФО", -7, false, false)); // правая софт-клавиша: «Инфо» / назад
      buttons.add(toggle);
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
      // пауза — вверху справа, переключатель цифровой панели — левее
      place(buttons.get(6), w - 1.0f * u, 0.95f * u, 0.55f * u);
      place(buttons.get(buttons.size() - 2), w - 2.45f * u, 0.95f * u, 0.55f * u);
      place(toggle, w - 3.9f * u, 0.95f * u, 0.5f * u);
      // цифровая панель (по включению): две строки по центру внизу
      int idx = 0;
      float step = 1.25f * u;
      for (Btn b : buttons) {
         if (b.numpad) {
            int row = idx / 4, col = idx % 4;
            place(b, w / 2f + (col - 1.5f) * step, h - (1.0f + row * 1.2f) * u, 0.5f * u);
            idx++;
         }
      }
      ringPaint.setStrokeWidth(Math.max(2f, u * 0.045f));
   }

   private boolean visible(Btn b) {
      return !b.numpad || numpadOn;
   }

   // ---------------- сглаживающий апскейл (Scale2x/EPX + билинейный показ) ----------------
   /** Выключить, если телефон не успевает: тогда кадр масштабируется "пиксель в пиксель". */
   public static volatile boolean smoothScale = true;
   /** Строка диагностики внизу экрана (шаги логики/с, показ/с и т.д.). */
   public static volatile boolean showStats = true;
   private int[] pxIn, pxOut;
   private Bitmap upBmp;
   private float upMs;
   private boolean filterOn;

   private Bitmap upscale(Bitmap bm) {
      if (!smoothScale) {
         if (filterOn) {
            framePaint.setFilterBitmap(false);
            filterOn = false;
         }
         return bm;
      }
      long t = System.nanoTime();
      int w = bm.getWidth(), h = bm.getHeight();
      if (pxIn == null || pxIn.length != w * h) {
         pxIn = new int[w * h];
         pxOut = new int[w * h * 4];
         upBmp = Bitmap.createBitmap(w * 2, h * 2, Bitmap.Config.ARGB_8888);
      }
      bm.getPixels(pxIn, 0, w, 0, 0, w, h);
      scale2x(pxIn, pxOut, w, h);
      upBmp.setPixels(pxOut, 0, w * 2, 0, 0, w * 2, h * 2);
      if (!filterOn) {
         framePaint.setFilterBitmap(true);
         filterOn = true;
      }
      upMs = upMs * 0.9f + ((System.nanoTime() - t) / 1000000f) * 0.1f;
      if (upMs > 16f) {
         smoothScale = false; // слишком медленно для этого телефона — возвращаем быстрый режим
      }
      return upBmp;
   }

   /** Scale2x (EPX): углы и диагонали сглаживаются, плоские области и острые края сохраняются. */
   static void scale2x(int[] s, int[] d, int w, int h) {
      int w2 = w * 2;
      for (int y = 0; y < h; y++) {
         int row = y * w, up = (y > 0 ? y - 1 : y) * w, dn = (y < h - 1 ? y + 1 : y) * w;
         int o0 = y * 2 * w2, o1 = o0 + w2;
         for (int x = 0; x < w; x++) {
            int p = s[row + x];
            int a = s[up + x], b = s[row + (x < w - 1 ? x + 1 : x)], c = s[row + (x > 0 ? x - 1 : x)], e = s[dn + x];
            int p0 = p, p1 = p, p2 = p, p3 = p;
            if (a != e && c != b) {
               if (c == a) p0 = a;
               if (a == b) p1 = b;
               if (e == c) p2 = c;
               if (b == e) p3 = e;
            }
            int o = x * 2;
            d[o0 + o] = p0;
            d[o0 + o + 1] = p1;
            d[o1 + o] = p2;
            d[o1 + o + 1] = p3;
         }
      }
   }

   // ---------------- Display.Surface ----------------
   @Override
   public void present(Image frame) {
      if (!surfaceReady) {
         return;
      }
      SurfaceHolder holder = getHolder();
      Canvas c = null;
      try {
         c = holder.lockCanvas();
         if (c == null) {
            return;
         }
         c.drawRect(0, 0, c.getWidth(), c.getHeight(), bgPaint);
         Bitmap bm = upscale(frame.getBitmap());
         src.set(0, 0, bm.getWidth(), bm.getHeight());
         c.drawBitmap(bm, src, dst, framePaint);
         if (showStats) {
            Paint sp = new Paint();
            sp.setTextSize(Math.max(20f, dst.width() / 48f));
            sp.setColor(0xCC000000);
            c.drawRect(0, c.getHeight() - sp.getTextSize() * 1.5f, c.getWidth() * 0.62f, c.getHeight(), sp);
            sp.setColor(0xFF66FF66);
            c.drawText(Display.stats() + (smoothScale ? "  ап2x " + Math.round(upMs) + "мс" : "  апскейл выкл"), 8, c.getHeight() - sp.getTextSize() * 0.35f, sp);
         }
         java.util.List<String> errs = ErrLog.snapshot();
         if (!errs.isEmpty()) {
            Paint ep = new Paint();
            ep.setTextSize(Math.max(22f, dst.width() / 36f));
            ep.setColor(0xCC000000);
            float lh = ep.getTextSize() * 1.15f;
            c.drawRect(0, 0, c.getWidth(), lh * errs.size() + 8, ep);
            ep.setColor(0xFFFF5555);
            for (int i = 0; i < errs.size(); i++) {
               c.drawText(errs.get(i), 6, lh * (i + 1), ep);
            }
         }
         for (Btn b : buttons) {
            if (!visible(b)) {
               continue;
            }
            boolean on = b.down || (b == toggle && numpadOn);
            fillPaint.setColor(on ? 0xB0FFFFFF : 0x66202430);
            c.drawCircle(b.cx, b.cy, b.r, fillPaint);
            ringPaint.setColor(on ? 0xFFFFFFFF : 0x99FFFFFF);
            c.drawCircle(b.cx, b.cy, b.r, ringPaint);
            textPaint.setColor(on ? 0xFF101018 : 0xDDFFFFFF);
            float size = b.r * (b.label.length() > 2 ? 0.40f : 0.85f);
            if (b.slot || b.numpad) {
               size = b.r * 1.0f;
            }
            textPaint.setTextSize(size);
            float ty = b.cy - (textPaint.descent() + textPaint.ascent()) / 2f;
            c.drawText(b.label, b.cx, ty, textPaint);
         }
      } finally {
         if (c != null) {
            holder.unlockCanvasAndPost(c);
         }
      }
   }

   @Override
   public void surfaceCreated(SurfaceHolder h) {
      surfaceReady = true;
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
            if (b == toggle) {
               if (b.down) {
                  numpadOn = !numpadOn;
               }
            } else {
               Display.key(b.down, b.code);
            }
         }
      }
      return true;
   }
}
