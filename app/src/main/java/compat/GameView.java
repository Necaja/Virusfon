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
 * Поверхность: кадр 240x320 сверху, поверх/под ним — отдельные круглые полупрозрачные сенсорные кнопки
 * в стиле мобильных экшенов (Dead Cells):
 *  слева — крестовина (влево/вправо/вверх/вниз), справа — большая кнопка АТАКА (fire, -5),
 *  рядом ПРЫЖОК (вверх, -1), над ними — быстрые слоты 1-5; сверху MENU/BACK и переключатель цифровой панели.
 * Мультитач, можно "съезжать" пальцем с одной кнопки на другую. Коды — как в J2ME (Nokia).
 */
public class GameView extends SurfaceView implements SurfaceHolder.Callback, Display.Surface {
   private static final class Btn {
      final String label;
      final int code;      // J2ME key code; 0 = служебная кнопка (переключатель)
      final boolean numpad; // видна только при включённой цифровой панели
      final boolean slot;  // видна всегда в ряду слотов 1-5
      float cx, cy, r;
      boolean down, visible = true;

      Btn(String label, int code, boolean slot, boolean numpad) {
         this.label = label;
         this.code = code;
         this.slot = slot;
         this.numpad = numpad;
      }

      boolean hit(float x, float y) {
         float dx = x - cx, dy = y - cy, rr = r * 1.18f; // чуть увеличенная зона касания
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
   private final Rect src = new Rect(0, 0, Display.WIDTH, Display.HEIGHT);
   private final Rect dst = new Rect();
   private volatile boolean surfaceReady;
   private volatile boolean numpadOn;
   private float baseR = 40f;

   public GameView(Context ctx) {
      super(ctx);
      getHolder().addCallback(this);
      setFocusable(true);
      setFocusableInTouchMode(true);
      framePaint.setFilterBitmap(false);
      bgPaint.setColor(0xFF0B0B12);
      fillPaint.setAntiAlias(true);
      ringPaint.setAntiAlias(true);
      ringPaint.setStyle(Paint.Style.STROKE);
      ringPaint.setStrokeWidth(4f);
      textPaint.setAntiAlias(true);
      textPaint.setTextAlign(Paint.Align.CENTER);
      textPaint.setFakeBoldText(true);

      buttons.add(new Btn("◄", -3, false, false));   // 0
      buttons.add(new Btn("►", -4, false, false));   // 1
      buttons.add(new Btn("▲", -1, false, false));   // 2 (вверх / навигация по меню)
      buttons.add(new Btn("▼", -2, false, false));   // 3
      buttons.add(new Btn("АТАКА", -5, false, false)); // 4 fire / OK
      buttons.add(new Btn("ПРЫЖОК", -1, false, false)); // 5 тот же код, что и "вверх"
      buttons.add(new Btn("MENU", -6, false, false)); // 6
      buttons.add(new Btn("BACK", -7, false, false)); // 7
      for (int i = 1; i <= 5; i++) {
         buttons.add(new Btn(String.valueOf(i), 48 + i, true, false));
      }
      String[] more = {"6", "7", "8", "9", "*", "0", "#"};
      int[] codes = {54, 55, 56, 57, 42, 48, 35};
      for (int i = 0; i < more.length; i++) {
         buttons.add(new Btn(more[i], codes[i], false, true));
      }
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
      // кадр: на всю ширину, но не выше 62% экрана; прижат к верху
      float scale = Math.min(w / (float) Display.WIDTH, (h * 0.62f) / Display.HEIGHT);
      int fw = Math.round(Display.WIDTH * scale), fh = Math.round(Display.HEIGHT * scale);
      int fx = (w - fw) / 2;
      dst.set(fx, 0, fx + fw, fh);

      float aH = h - fh;
      float r = Math.min(w * 0.10f, aH * 0.125f);
      baseR = r;
      float cy = fh + aH * 0.56f;

      // крестовина слева
      float dx = r * 2.5f, dcx = r * 0.4f + dx, dr = r * 0.95f;
      place(buttons.get(0), dcx - dx * 0.62f + 0f, cy, dr);
      place(buttons.get(1), dcx + dx * 0.62f + 0f, cy, dr);
      place(buttons.get(2), dcx, cy - r * 1.95f, dr * 0.9f);
      place(buttons.get(3), dcx, cy + r * 1.95f, dr * 0.9f);
      // действия справа
      place(buttons.get(4), w - r * 1.9f, cy + r * 0.5f, r * 1.3f);       // атака — самая большая
      place(buttons.get(5), w - r * 4.6f, cy + r * 1.1f, r * 1.0f);       // прыжок
      // служебные сверху (прижаты к низу кадра)
      float sy = fh + r * 0.75f;
      place(buttons.get(6), r * 1.1f, sy, r * 0.62f);
      place(buttons.get(7), w - r * 1.1f, sy, r * 0.62f);
      place(toggle, w / 2f, sy, r * 0.62f);
      // слоты 1-5 над кнопкой атаки; числа 6-9,*,0,# — вторым рядом (по включению)
      float sr = r * 0.5f, step = sr * 2.35f, rowY = cy - r * 2.9f;
      float right = w - r * 0.7f;
      int idx = 0;
      for (Btn b : buttons) {
         if (b.slot) {
            place(b, right - sr - (4 - idx) * step, rowY, sr);
            idx++;
         }
      }
      idx = 0;
      for (Btn b : buttons) {
         if (b.numpad) {
            place(b, right - sr - (6 - idx) * step, rowY - step * 1.0f, sr);
            idx++;
         }
      }
      textPaint.setTextSize(r * 0.5f);
   }

   private boolean visible(Btn b) {
      return !b.numpad || numpadOn;
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
         Bitmap bm = frame.getBitmap();
         c.drawBitmap(bm, src, dst, framePaint);
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
