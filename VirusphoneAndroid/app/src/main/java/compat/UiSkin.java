package compat;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import java.io.InputStream;

/**
 * Оформление сенсорных кнопок спрайтами самой игры: круглые рамки и стрелки (keyhelp),
 * слоты умений (key + res, как внизу экрана), меч с шлейфом (атласы zhujiao2..4) и вспышка удара (attackpro).
 */
final class UiSkin {
   private final Paint px = new Paint();
   private final Paint txt = new Paint();
   private final Paint outl = new Paint();
   private final Rect s = new Rect();
   private final RectF d = new RectF();

   private Bitmap circleIdle, circlePress, spark, keyImg, resImg;
   private final Bitmap[] arrowGold = new Bitmap[4], arrowGreen = new Bitmap[4];
   private final Bitmap[] atk = new Bitmap[3];
   private final Bitmap[] iconCache = new Bitmap[40];
   private boolean loaded;
   /** Прозрачность в покое (255 = непрозрачно), чтобы кнопки не закрывали диалоги и мир. */
   static final int A_RING = 105, A_ICON = 170, A_SLOT = 135, A_SLOT_ICON = 190;

   UiSkin() {
      px.setFilterBitmap(false);
      px.setAntiAlias(false);
      txt.setAntiAlias(true);
      txt.setTextAlign(Paint.Align.CENTER);
      txt.setFakeBoldText(true);
      outl.setAntiAlias(true);
      outl.setTextAlign(Paint.Align.CENTER);
      outl.setFakeBoldText(true);
      outl.setStyle(Paint.Style.STROKE);
      outl.setColor(0xFF2A1408);
   }

   // ---------- загрузка ----------
   private static Bitmap decode(String name) {
      InputStream in = null;
      try {
         in = Res.open(name);
         if (in == null) {
            return null;
         }
         BitmapFactory.Options o = new BitmapFactory.Options();
         o.inScaled = false;
         return BitmapFactory.decodeStream(in, null, o);
      } catch (Exception e) {
         return null;
      } finally {
         try {
            if (in != null) {
               in.close();
            }
         } catch (Exception ignored) {
         }
      }
   }

   private static Bitmap sub(Bitmap b, int x, int y, int w, int h) {
      if (b == null) {
         return null;
      }
      x = Math.max(0, x);
      y = Math.max(0, y);
      w = Math.min(w, b.getWidth() - x);
      h = Math.min(h, b.getHeight() - y);
      if (w <= 0 || h <= 0) {
         return null;
      }
      return Bitmap.createBitmap(b, x, y, w, h);
   }

   /** Обрезать прозрачные поля. */
   private static Bitmap trim(Bitmap b) {
      if (b == null) {
         return null;
      }
      int w = b.getWidth(), h = b.getHeight();
      int[] p = new int[w * h];
      b.getPixels(p, 0, w, 0, 0, w, h);
      int x0 = w, y0 = h, x1 = -1, y1 = -1;
      for (int y = 0; y < h; y++) {
         for (int x = 0; x < w; x++) {
            if ((p[y * w + x] >>> 24) != 0) {
               x0 = Math.min(x0, x);
               x1 = Math.max(x1, x);
               y0 = Math.min(y0, y);
               y1 = Math.max(y1, y);
            }
         }
      }
      return x1 < 0 ? b : Bitmap.createBitmap(b, x0, y0, x1 - x0 + 1, y1 - y0 + 1);
   }

   private static void paste(Canvas c, Bitmap src, int dx, int dy) {
      if (src != null) {
         c.drawBitmap(src, dx, dy, null);
      }
   }

   void load() {
      if (loaded) {
         return;
      }
      loaded = true;
      // keyhelp.png: стрелки 12x12 (зелёные y=0, золотые y=12), круглые рамки 18x18 (чёрная и коричневая) y=24
      Bitmap kh = decode("keyhelp.png");
      if (kh != null) {
         circleIdle = trim(sub(kh, 0, 24, 18, 18));
         circlePress = trim(sub(kh, 18, 24, 18, 18));
         for (int i = 0; i < 4; i++) {
            arrowGreen[i] = trim(sub(kh, i * 12, 0, 12, 12));
            arrowGold[i] = trim(sub(kh, i * 12, 12, 12, 12));
         }
      }
      keyImg = decode("key.png");
      resImg = decode("res.png");
      spark = trim(sub(decode("attackpro.png"), 0, 0, 78, 60));
      // меч со шлейфом: куски атласов героя (zhujiao2..4 — по уровню меча)
      Bitmap z2 = decode("zhujiao2.png"), z3 = decode("zhujiao3.png"), z4 = decode("zhujiao4.png");
      if (z2 != null) {
         Bitmap t = Bitmap.createBitmap(70, 36, Bitmap.Config.ARGB_8888);
         Canvas c = new Canvas(t);
         paste(c, sub(z2, 143, 157, 48, 13), 10, 0);   // огненный шлейф
         paste(c, sub(z2, 133, 180, 60, 14), 0, 18);   // клинок
         atk[0] = trim(t);
      }
      atk[1] = trim(sub(z3, 0, 209, 41, 23));
      atk[2] = trim(sub(z4, 0, 216, 43, 26));
   }

   // ---------- рисование ----------
   private void sprite(Canvas c, Bitmap b, float cx, float cy, float w, float h, int alpha) {
      if (b == null) {
         return;
      }
      s.set(0, 0, b.getWidth(), b.getHeight());
      d.set(cx - w / 2f, cy - h / 2f, cx + w / 2f, cy + h / 2f);
      px.setAlpha(alpha);
      c.drawBitmap(b, s, d, px);
      px.setAlpha(255);
   }

   /** Вписать спрайт в квадрат размера box (с сохранением пропорций). */
   private void fit(Canvas c, Bitmap b, float cx, float cy, float box, int alpha) {
      if (b == null) {
         return;
      }
      float k = box / Math.max(b.getWidth(), b.getHeight());
      sprite(c, b, cx, cy, b.getWidth() * k, b.getHeight() * k, alpha);
   }

   private void ring(Canvas c, float cx, float cy, float r, boolean down) {
      Bitmap b = down ? circlePress : circleIdle;
      if (b == null) {
         return;
      }
      sprite(c, b, cx, cy, r * 2f, r * 2f * b.getHeight() / b.getWidth(), down ? 235 : A_RING);
   }

   private void label(Canvas c, String t, float cx, float cy, float size, int color) {
      txt.setTextSize(size);
      outl.setTextSize(size);
      outl.setStrokeWidth(Math.max(2f, size * 0.16f));
      txt.setColor(color);
      outl.setColor((color & 0xFF000000) == 0xFF000000 ? 0xFF2A1408 : (((color >>> 24) * 3 / 4) << 24) | 0x2A1408);
      float ty = cy - (txt.descent() + txt.ascent()) / 2f;
      c.drawText(t, cx, ty, outl);
      c.drawText(t, cx, ty, txt);
   }

   private Bitmap slotIcon(int index, int value) {
      if (value < 0 || resImg == null) {
         return null;
      }
      int key = index * 10 + Math.min(9, value);
      if (key >= iconCache.length) {
         return null;
      }
      if (iconCache[key] == null) {
         int sx = index < 2 ? (value - 42) * 12 : 144 + value * 12;
         iconCache[key] = sub(resImg, sx, 0, 12, 12);
      }
      return iconCache[key];
   }

   /**
    * Нарисовать кнопку. id: left/right/up/down/atk/jump/pause/info/s0..s3.
    * state — результат main.f.uiState() (может быть null).
    */
   void draw(Canvas c, String id, float cx, float cy, float r, boolean down, int[] state) {
      load();
      if (id.startsWith("s")) {
         drawSlot(c, id.charAt(1) - '0', cx, cy, r, down, state);
         return;
      }
      ring(c, cx, cy, r, down);
      Bitmap[] arrows = down ? arrowGreen : arrowGold;
      int ia = down ? 255 : A_ICON;
      switch (id) {
         case "left": fit(c, arrows[1], cx, cy, r * 1.15f, ia); break;
         case "right": fit(c, arrows[3], cx, cy, r * 1.15f, ia); break;
         case "up": fit(c, arrows[0], cx, cy, r * 1.15f, ia); break;
         case "down": fit(c, arrows[2], cx, cy, r * 1.15f, ia); break;
         case "jump":
            fit(c, arrows[0], cx, cy - r * 0.22f, r * 0.95f, ia);
            label(c, "ПРЫЖОК", cx, cy + r * 0.52f, r * 0.30f, (ia << 24) | (down ? 0xB6F25A : 0xFFD35A));
            break;
         case "atk": {
            if (down && spark != null) {
               fit(c, spark, cx + r * 0.2f, cy - r * 0.05f, r * 1.7f, 200); // вспышка удара
            }
            Bitmap dyn = null;
            try {
               javax.microedition.lcdui.Image img = main.f.uiWeaponIcon();
               dyn = img == null ? null : img.getBitmap();
            } catch (Throwable ignored) {
            }
            if (dyn != null) {
               fit(c, dyn, cx, cy, r * 1.7f, ia); // меч и шлейф экипированного оружия в момент удара
            } else {
               int tier = state != null ? state[6] : 0;
               Bitmap sw = atk[Math.max(0, Math.min(2, tier))];
               if (sw != null) {
                  c.save();
                  c.rotate(-32f, cx, cy);
                  fit(c, sw, cx, cy, r * 1.5f, ia);
                  c.restore();
               }
            }
            break;
         }
         case "pause": {
            float bw = r * 0.22f, bh = r * 0.8f;
            px.setColor((ia << 24) | (down ? 0xB6F25A : 0xFFD35A));
            c.drawRect(cx - bw * 1.4f, cy - bh / 2, cx - bw * 0.4f, cy + bh / 2, px);
            c.drawRect(cx + bw * 0.4f, cy - bh / 2, cx + bw * 1.4f, cy + bh / 2, px);
            break;
         }
         case "info":
            label(c, "i", cx, cy, r * 1.15f, (ia << 24) | (down ? 0xB6F25A : 0xFFD35A));
            break;
         default:
            break;
      }
   }

   private void drawSlot(Canvas c, int idx, float cx, float cy, float r, boolean down, int[] st) {
      if (keyImg == null) {
         return;
      }
      float side = r * 2f, u = side / 20f; // слот 20x20 пикселей игры
      float x0 = cx - side / 2f, y0 = cy - side / 2f;
      Rect fr = new Rect(0, 11, 20, 31);
      d.set(x0, y0, x0 + side, y0 + side);
      px.setAlpha(down ? 255 : A_SLOT);
      c.drawBitmap(keyImg, fr, d, px);
      px.setAlpha(255);
      int sa = down ? 255 : A_SLOT_ICON;
      int val = st == null ? -1 : st[idx];
      Bitmap ic = slotIcon(idx, val);
      if (ic != null) {
         sprite(c, ic, x0 + 10 * u, y0 + 9 * u, 12 * u, 12 * u, sa);
      }
      // полоска перезарядки (как в HUD игры): у слотов 3 и 4
      int cd = st == null ? 0 : (idx == 2 ? st[4] : idx == 3 ? st[5] : 0);
      if (cd > 0) {
         Rect m = new Rect(20, 11, 32, 11 + Math.min(14, cd));
         d.set(x0 + 4 * u, y0 + 2 * u, x0 + 16 * u, y0 + (2 + Math.min(14, cd)) * u);
         px.setAlpha(sa);
         c.drawBitmap(keyImg, m, d, px);
         px.setAlpha(255);
      }
      // цифра клавиши
      Rect dg = new Rect(idx * 11, 0, idx * 11 + 11, 11);
      d.set(x0 + 8 * u, y0 + 10 * u, x0 + 19 * u, y0 + 21 * u);
      px.setAlpha(sa);
      c.drawBitmap(keyImg, dg, d, px);
      px.setAlpha(255);
      if (down) {
         px.setColor(0x55FFFFFF);
         c.drawRect(x0, y0, x0 + side, y0 + side, px);
      }
   }
}
