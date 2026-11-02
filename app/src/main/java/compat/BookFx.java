package compat;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import engine.Fx;
import java.util.Random;

/**
 * Рисует эффекты переходов поверх кадра игры по реальному времени (60 кадров/с):
 * открывающаяся книга и разворачивающийся из центра свиток. Картинки - пиксель-арт, собранный в коде.
 */
public final class BookFx {
   private static final int CW = 96, CH = 128;
   private Bitmap cover, pageR, pageL, roller;
   private final Paint p = new Paint();
   private final Paint pix = new Paint();
   private final RectF dr = new RectF();
   private final Rect sr = new Rect();

   public BookFx() {
      pix.setFilterBitmap(false);
      pix.setAntiAlias(false);
   }

   // ---------------- сборка пиксель-арта ----------------
   private static final class Px {
      final int w, h;
      final int[] a;

      Px(int w, int h) {
         this.w = w;
         this.h = h;
         a = new int[w * h];
      }

      void rect(int x, int y, int rw, int rh, int c) {
         for (int j = Math.max(0, y); j < Math.min(h, y + rh); j++) {
            for (int i = Math.max(0, x); i < Math.min(w, x + rw); i++) {
               a[j * w + i] = c;
            }
         }
      }

      void set(int x, int y, int c) {
         if (x >= 0 && y >= 0 && x < w && y < h) {
            a[y * w + x] = c;
         }
      }

      Bitmap bitmap() {
         Bitmap b = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
         b.setPixels(a, 0, w, 0, 0, w, h);
         return b;
      }
   }

   private static final int LEATHER = 0xFF5A3419, LEATHER_D = 0xFF3A200E, LEATHER_L = 0xFF7A4A27, GOLD = 0xFFD9AE4F, GOLD_D = 0xFF9C7424,
         PAPER = 0xFFF1E2B8, PAPER_D = 0xFFD9C48F, INK = 0xFF9B8358;

   private void build() {
      Random r = new Random(11);
      // --- обложка ---
      Px c = new Px(CW, CH);
      c.rect(0, 0, CW, CH, LEATHER_D);
      c.rect(2, 2, CW - 4, CH - 4, LEATHER);
      for (int i = 0; i < 520; i++) {
         c.set(3 + r.nextInt(CW - 6), 3 + r.nextInt(CH - 6), r.nextBoolean() ? LEATHER_L : LEATHER_D);
      }
      c.rect(0, 0, 9, CH, LEATHER_D); // корешок
      for (int y : new int[]{18, 62, 106}) {
         c.rect(0, y, 9, 3, GOLD);
         c.rect(0, y + 3, 9, 1, GOLD_D);
      }
      // золотая рамка
      c.rect(14, 8, CW - 22, 1, GOLD);
      c.rect(14, CH - 9, CW - 22, 1, GOLD);
      c.rect(14, 8, 1, CH - 16, GOLD);
      c.rect(CW - 9, 8, 1, CH - 16, GOLD);
      c.rect(17, 11, CW - 28, 1, GOLD_D);
      c.rect(17, CH - 12, CW - 28, 1, GOLD_D);
      c.rect(17, 11, 1, CH - 22, GOLD_D);
      c.rect(CW - 12, 11, 1, CH - 22, GOLD_D);
      // уголки
      int[][] cs = {{12, 6}, {CW - 14, 6}, {12, CH - 14}, {CW - 14, CH - 14}};
      for (int[] q : cs) {
         c.rect(q[0], q[1], 7, 7, GOLD);
         c.rect(q[0] + 2, q[1] + 2, 3, 3, LEATHER_D);
      }
      // ромб-эмблема
      int cx = 14 + (CW - 22) / 2 + 1, cy = CH / 2;
      for (int dy = -20; dy <= 20; dy++) {
         int hw = 20 - Math.abs(dy);
         c.rect(cx - hw, cy + dy, hw * 2 + 1, 1, GOLD);
      }
      for (int dy = -15; dy <= 15; dy++) {
         int hw = 15 - Math.abs(dy);
         c.rect(cx - hw, cy + dy, hw * 2 + 1, 1, LEATHER_D);
      }
      for (int dy = -8; dy <= 8; dy++) {
         int hw = 8 - Math.abs(dy);
         c.rect(cx - hw, cy + dy, hw * 2 + 1, 1, GOLD_D);
      }
      c.rect(cx - 2, cy - 2, 5, 5, GOLD);
      c.rect(cx - 16, 26, 33, 1, GOLD);
      c.rect(cx - 16, CH - 27, 33, 1, GOLD);
      cover = c.bitmap();
      // --- страницы ---
      pageR = page(r, false);
      pageL = page(r, true);
   }

   private Bitmap page(Random r, boolean left) {
      Px g = new Px(CW, CH);
      g.rect(0, 0, CW, CH, LEATHER_D); // кожаный кант
      g.rect(2, 2, CW - 4, CH - 4, LEATHER);
      g.rect(5, 5, CW - 9, CH - 9, PAPER_D);
      g.rect(7, 7, CW - 13, CH - 13, PAPER);
      // тень у корешка
      for (int i = 0; i < 7; i++) {
         int sx = left ? CW - 8 - i : 7 + i;
         g.rect(sx, 7, 1, CH - 14, i < 2 ? PAPER_D : (i < 5 ? 0xFFE6D3A0 : PAPER));
      }
      // строки текста и заглавная буква
      int y = 16;
      g.rect(left ? 14 : 18, y, 9, 9, GOLD_D);
      g.rect(left ? 15 : 19, y + 1, 7, 7, GOLD);
      while (y < CH - 16) {
         int x0 = left ? 14 : 18;
         int len = 52 + r.nextInt(20) - (y == 16 ? 0 : 0);
         int start = y == 16 ? x0 + 12 : x0;
         if (r.nextInt(7) == 0) {
            len -= 20;
         }
         g.rect(start, y + 3, Math.max(8, len - (start - x0)), 1, INK);
         y += 6;
      }
      return g.bitmap();
   }

   private void buildRoller() {
      // вертикальный валик свитка: 12 px в ширину, 4 px тонкая линия по высоте (растягивается)
      Px g = new Px(12, 4);
      int[] cols = {0xFF3A2410, 0xFF6E4B26, 0xFFA97F45, 0xFFD6B574, 0xFFE9D39B, 0xFFD6B574, 0xFFA97F45, 0xFF6E4B26, 0xFF3A2410};
      for (int i = 0; i < 9; i++) {
         g.rect(i + 1, 0, 1, 4, cols[i]);
      }
      roller = g.bitmap();
   }

   // ---------------- вспомогательные функции ----------------
   private static float clamp(float v) {
      return v < 0 ? 0 : (v > 1 ? 1 : v);
   }

   private static float ease(float t) {
      t = clamp(t);
      return t * t * (3 - 2 * t);
   }

   private static float easeOutBack(float t) {
      t = clamp(t) - 1;
      return 1 + t * t * (2.2f * t + 1.2f);
   }

   private void img(Canvas c, Bitmap b, float x0, float x1, float y0, float y1, int alpha, int shade) {
      if (x1 - x0 < 1f) {
         return;
      }
      pix.setAlpha(alpha);
      sr.set(0, 0, b.getWidth(), b.getHeight());
      dr.set(x0, y0, x1, y1);
      c.drawBitmap(b, sr, dr, pix);
      if (shade > 0) { // затенение (перелистываемая страница уходит от света)
         p.setColor((Math.min(255, shade) * alpha / 255) << 24);
         c.drawRect(x0, y0, x1, y1, p);
      }
   }

   private void dim(Canvas c, int w, int h, float a) {
      p.setColor(((int) (clamp(a) * 255) << 24));
      c.drawRect(0, 0, w, h, p);
   }

   // ---------------- отрисовка ----------------
   /** Нарисовать текущий эффект поверх кадра. Возвращает true, пока эффект идёт (нужно продолжать перерисовку). */
   public boolean draw(Canvas c, int sw, int sh, Rect dst) {
      long now = System.nanoTime();
      if (!Fx.active(now)) {
         return false;
      }
      if (cover == null) {
         build();
         buildRoller();
      }
      float t = (now - Fx.startNs) / 1e9f;
      if (Fx.kind == Fx.BOOK) {
         drawBook(c, sw, sh, t);
      } else {
         drawScroll(c, sw, sh, dst, t);
      }
      return true;
   }

   private void drawBook(Canvas c, int sw, int sh, float t) {
      final float T = 1.0f;
      float backdrop;
      float scale = 1f;
      float fade = 1f;
      if (t < 0.14f) {
         float u = t / 0.14f;
         backdrop = 0.62f * ease(u);
         scale = 0.55f + 0.45f * easeOutBack(u);
         fade = clamp(u * 1.6f);
      } else if (t < 0.74f) {
         backdrop = 0.62f;
      } else {
         float u = clamp((t - 0.74f) / (T - 0.74f));
         backdrop = 0.62f * (1 - ease(u));
         scale = 1f + 0.55f * ease(u);
         fade = 1f - ease(u);
      }
      dim(c, sw, sh, backdrop);
      int alpha = (int) (255 * fade);
      float ph = sh * 0.62f * scale;      // высота книги
      float pw = ph * CW / (float) CH;     // ширина одной страницы
      float cx = sw / 2f, cy = sh * 0.5f;
      float y0 = cy - ph / 2, y1 = cy + ph / 2;
      // раскрытие обложки: угол 0..PI
      float open = ease((t - 0.14f) / 0.36f);
      float spine = cx - pw / 2 * (1 - open); // корешок едет к центру
      // тень под книгой
      p.setColor(((int) (0.35f * alpha) << 24));
      c.drawRect(spine - pw * (open > 0 ? 1.04f : 0.02f), y1 + ph * 0.015f, spine + pw * 1.04f, y1 + ph * 0.05f, p);
      // правая страница под обложкой
      img(c, pageR, spine, spine + pw, y0, y1, alpha, 0);
      // левая страница (видна, когда обложка откинута)
      if (open > 0.5f) {
         float wl = pw * (open - 0.5f) * 2f * 0 + pw;
         float revealed = clamp((open - 0.5f) * 2f);
         img(c, pageL, spine - pw * revealed, spine, y0, y1, alpha, (int) (90 * (1 - revealed)));
      }
      // перелистывание страниц после открытия
      float f1 = (t - 0.50f) / 0.20f;
      if (f1 > 0 && f1 < 1.2f) {
         flipPage(c, pageR, pageL, spine, pw, y0, y1, ease(f1), alpha);
      }
      float f2 = (t - 0.60f) / 0.20f;
      if (f2 > 0 && f2 < 1.2f) {
         flipPage(c, pageR, pageL, spine, pw, y0, y1, ease(f2), alpha);
      }
      // сама обложка
      if (open < 1f) {
         float ang = open * (float) Math.PI;
         float cw = pw * (float) Math.cos(ang);
         if (open < 0.5f) {
            img(c, cover, spine, spine + cw, y0, y1, alpha, (int) (110 * open));
         } else {
            img(c, pageL, spine + cw, spine, y0, y1, alpha, (int) (150 * (1 - open) * 2));
         }
      }
      // золотая закладка-ленточка
      if (open >= 1f) {
         p.setColor((alpha << 24) | 0xB03030);
         c.drawRect(spine + pw * 0.08f, y1 - ph * 0.02f, spine + pw * 0.12f, y1 + ph * 0.06f, p);
      }
   }

   private void flipPage(Canvas c, Bitmap right, Bitmap left, float spine, float pw, float y0, float y1, float u, int alpha) {
      float ang = u * (float) Math.PI;
      float w = pw * (float) Math.cos(ang);
      if (u < 0.5f) {
         img(c, right, spine, spine + w, y0, y1, alpha, (int) (70 * u));
      } else {
         img(c, left, spine + w, spine, y0, y1, alpha, (int) (70 * (1 - u)));
      }
   }

   private void drawScroll(Canvas c, int sw, int sh, Rect dst, float t) {
      final float T = 0.9f;
      float backdrop = 0.55f;
      float fade = 1f;
      float grow;
      if (t < 0.10f) {
         backdrop = 0.55f * ease(t / 0.10f);
         fade = clamp(t / 0.07f);
         grow = 0f;
      } else if (t < 0.60f) {
         grow = ease((t - 0.10f) / 0.50f);
      } else if (t < 0.70f) {
         float u = (t - 0.60f) / 0.10f;
         grow = 1f + 0.015f * (float) Math.sin(u * Math.PI); // небольшой "пружинящий" добег
      } else {
         grow = 1f;
         float u = clamp((t - 0.70f) / (T - 0.70f));
         fade = 1f - ease(u);
         backdrop = 0.55f * fade;
      }
      dim(c, sw, sh, backdrop);
      int alpha = (int) (255 * fade);
      float cx = sw / 2f, cy = sh * 0.5f;
      float colW = (dst.width() > 0 ? Math.min(dst.width(), sh * 0.75f) : sh * 0.75f); // ширина центральной колонки игры
      float maxHalf = colW * 0.5f * 0.96f;
      float rw = sh * 0.05f;                 // толщина валика
      float sheetH = sh * 0.50f;
      float y0 = cy - sheetH / 2, y1 = cy + sheetH / 2;
      float half = rw * 0.5f + (maxHalf - rw * 0.5f) * grow;
      // тень
      p.setColor(((int) (0.3f * alpha) << 24));
      c.drawRect(cx - half, y1 + sh * 0.01f, cx + half, y1 + sh * 0.035f, p);
      if (grow > 0f) {
         // лист пергамента
         p.setColor((alpha << 24) | 0xEAD9A8);
         c.drawRect(cx - half, y0, cx + half, y1, p);
         // затенение у краёв (изгиб листа у валиков)
         int steps = 10;
         for (int i = 0; i < steps; i++) {
            float k = i / (float) steps;
            int sh2 = (int) (80 * (1 - k) * (1 - k) * alpha / 255f);
            p.setColor((sh2 << 24) | 0x5A3A14);
            float wdt = rw * 1.6f / steps;
            c.drawRect(cx - half + rw * 0.5f + i * wdt, y0, cx - half + rw * 0.5f + (i + 1) * wdt, y1, p);
            c.drawRect(cx + half - rw * 0.5f - (i + 1) * wdt, y0, cx + half - rw * 0.5f - i * wdt, y1, p);
         }
         // тонкие рамки сверху и снизу и волокна
         p.setColor((alpha << 24) | 0x8B6B3A);
         c.drawRect(cx - half, y0, cx + half, y0 + sh * 0.006f, p);
         c.drawRect(cx - half, y1 - sh * 0.006f, cx + half, y1, p);
         p.setColor(((int) (0.18f * alpha) << 24) | 0x8B6B3A);
         for (int i = 1; i < 7; i++) {
            float yy = y0 + sheetH * i / 7f;
            c.drawRect(cx - half + rw, yy, cx + half - rw, yy + sh * 0.003f, p);
         }
      }
      // валики на краях (в начале сливаются в один свёрнутый свиток)
      drawRoller(c, cx - half, y0, y1, rw, alpha, sh);
      if (half > rw * 0.75f) {
         drawRoller(c, cx + half, y0, y1, rw, alpha, sh);
      }
   }

   private void drawRoller(Canvas c, float x, float y0, float y1, float rw, int alpha, int sh) {
      float ext = sh * 0.025f;
      pix.setAlpha(alpha);
      sr.set(0, 0, roller.getWidth(), roller.getHeight());
      dr.set(x - rw / 2, y0 - ext * 0.4f, x + rw / 2, y1 + ext * 0.4f);
      c.drawBitmap(roller, sr, dr, pix);
      // золотые наконечники
      p.setColor((alpha << 24) | 0xD9AE4F);
      c.drawRect(x - rw * 0.62f, y0 - ext, x + rw * 0.62f, y0 - ext * 0.4f, p);
      c.drawRect(x - rw * 0.62f, y1 + ext * 0.4f, x + rw * 0.62f, y1 + ext, p);
      p.setColor((alpha << 24) | 0x9C7424);
      c.drawRect(x - rw * 0.62f, y0 - ext * 0.5f, x + rw * 0.62f, y0 - ext * 0.4f, p);
      c.drawRect(x - rw * 0.62f, y1 + ext, x + rw * 0.62f, y1 + ext * 1.1f, p);
   }
}
