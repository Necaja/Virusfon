package engine;

import java.io.IOException;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

/**
 * Новое главное меню: закат над деревней Фонзо Тим, пара героев со спины, розовое дерево с падающими лепестками;
 * пункты меню на развёрнутом свитке (валики сверху и снизу). Рисуется только командами Graphics, поэтому
 * видеокарта показывает его в полном разрешении (как игровой мир). Ресурсы делает tools/make_title_assets.py.
 */
public final class TitleScene {
   // фон 720x320; логическая x = x фона - 240 (центр колонки 240 — середина фона)
   private static final int BG_X = -240;
   // хижины фона (центр x, ширина, высота) — для мерцающих окон; совпадает с генератором
   private static final int[][] HUTS = {
      {30, 40, 38}, {92, 34, 30}, {150, 28, 26}, {226, 30, 30}, {300, 30, 28}, {352, 36, 34},
      {418, 30, 26}, {478, 40, 36}, {545, 34, 30}, {610, 36, 32}, {676, 30, 28}
   };
   private static final int SUN_X = 190 + BG_X, SUN_Y = 176;
   private static final int FW = 104, FH = 92, FRAMES = 12;
   private static final int[] PETAL_COL = {0xC83A76, 0xE8508A, 0xFF7FAE, 0xFFB4CF};

   private static Image bg, tree, couple, cloud, glow, logo;
   private static boolean loaded, failed;
   private static long t0, lastDraw;
   private static float selPos = -1;
   private static long lastSelNs;

   private static Font fItem, fSel;

   // лепестки: фиксированный набор параметров
   private static final int NP = 64;
   private static final float[] px = new float[NP], py = new float[NP], pv = new float[NP], psw = new float[NP], pph = new float[NP],
      pdr = new float[NP], plife = new float[NP];
   private static final int[] psz = new int[NP], pcol = new int[NP];

   private TitleScene() {
   }

   private static Image load(String n) {
      try {
         return Image.createImage(n);
      } catch (IOException e) {
         failed = true;
         return null;
      }
   }

   private static void init() {
      if (loaded) {
         return;
      }
      loaded = true;
      bg = load("/title_bg.png");
      tree = load("/title_tree.png");
      couple = load("/title_couple.png");
      cloud = load("/title_cloud.png");
      glow = load("/title_glow.png");
      logo = load("/title_logo.png");
      fItem = Font.getFont(64, 1, 0);
      fSel = Font.getFont(64, 1, 16);
      java.util.Random r = new java.util.Random(3);
      for (int i = 0; i < NP; i++) {
         px[i] = 300 + r.nextFloat() * 140;
         py[i] = 110 + r.nextFloat() * 80;
         pv[i] = 10 + r.nextFloat() * 12;
         psw[i] = 8 + r.nextFloat() * 18;
         pph[i] = r.nextFloat() * 6.3f;
         pdr[i] = -9 + r.nextFloat() * 13;
         plife[i] = 10 + r.nextFloat() * 4;
         psz[i] = new int[] {1, 2, 2, 3}[r.nextInt(4)];
         pcol[i] = PETAL_COL[r.nextInt(4)];
      }
   }

   public static boolean ready() {
      init();
      return !failed && bg != null;
   }

   private static float ease(float x) {
      x = Math.max(0f, Math.min(1f, x));
      return x * x * (3 - 2 * x);
   }

   /** Нарисовать кадр меню. items — пункты, sel — выбранный (0..n-1). Возвращает false, если ресурсов нет (рисуйте по-старому). */
   public static boolean draw(Graphics g, String[] items, int sel) {
      init();
      if (failed || bg == null) {
         return false;
      }
      long now = System.nanoTime();
      if (now - lastDraw > 800000000L) {
         t0 = now; // зашли в меню заново: свиток разворачивается снова
         selPos = sel;
      }
      lastDraw = now;
      float t = (now - t0) / 1e9f;
      int ex = Display.extra();
      Display.markWorld();
      g.setClip(-ex, 0, 240 + ex * 2, 320);

      // фон: небо, солнце, горы, озеро, хижины, земля
      g.drawImage(bg, BG_X, 0, 20);
      // облака
      cloudAt(g, t, 38, 2.4f, 0);
      cloudAt(g, t, 72, 1.5f, 330);
      cloudAt(g, t, 104, 1.0f, 620);
      // свечение солнца (3 кадра пульсации)
      int gf = (int) ((Math.sin(t * 1.3) + 1) * 1.49);
      clipDraw(g, glow, SUN_X - 100, SUN_Y - 100, gf * 200, 200, 200);
      // дорожка солнца на воде
      java.util.Random rr = new java.util.Random((long) (t * 6));
      for (int y = 206; y < 262; y += 2) {
         float v = (y - 205) / 57f;
         int w = (int) (6 + 20 * v + rr.nextFloat() * 8 - 4);
         int a = (int) (200 * (1 - v * 0.7f));
         g.fillRectArgb(SUN_X - w, y, w * 2, 1, (a << 24) | 0xFFE296);
      }
      for (int i = 0; i < 36; i++) {
         java.util.Random q = new java.util.Random(i * 31L);
         float x = q.nextFloat() * 720 - 240;
         float y = 208 + q.nextFloat() * 50;
         float ph = (t * 0.8f + q.nextFloat() * 6) % 3;
         if (ph < 1f) {
            int ln = (int) (4 + 6 * ph);
            g.fillRectArgb((int) x - ln, (int) y, ln * 2, 1, ((int) (120 * (1 - ph)) << 24) | 0xFFDCAA);
         }
      }
      // мерцающие окна хижин
      for (int i = 0; i < HUTS.length; i++) {
         double tw = 0.6 + 0.4 * Math.sin(t * 2.2 + i * 1.7);
         int c = (255 << 16) | ((int) (190 * tw + 40) << 8) | (int) (90 * tw);
         g.setColor(c);
         int x = HUTS[i][0] + BG_X, h = HUTS[i][2];
         g.fillRect(x - 3, 233 - (int) (h * 0.32), 6, (int) (h * 0.14));
      }
      // лепестки позади, дерево, пара
      petals(g, t, false);
      g.drawImage(tree, 386 - 88 + 0, 120, 20);
      int f = ((int) (t * 8)) % FRAMES;
      clipDraw(g, couple, 254, 217, f * FW, FW, FH);
      petals(g, t, true);

      // боковые поля чуть темнее, как у остальных экранов
      g.fillRectArgb(-ex, 0, ex, 320, 0x46050314);
      g.fillRectArgb(240, 0, ex, 320, 0x46050314);

      logo(g, t);
      scroll(g, t, items, sel, now);
      // выход из чёрного
      float fi = ease(t / 0.6f);
      if (fi < 1f) {
         g.fillRectArgb(-ex, 0, 240 + ex * 2, 320, ((int) (255 * (1 - fi)) << 24));
      }
      g.setClip(-ex, 0, 240 + ex * 2, 320);
      return true;
   }

   private static void clipDraw(Graphics g, Image im, int x, int y, int sx, int w, int h) {
      if (im == null) {
         return;
      }
      g.setClip(x, y, w, h);
      g.drawImage(im, x - sx, y, 20);
      int ex = Display.extra();
      g.setClip(-ex, 0, 240 + ex * 2, 320);
   }

   private static void cloudAt(Graphics g, float t, int y, float speed, int off) {
      if (cloud == null) {
         return;
      }
      int span = 720 + 300;
      int x = (int) ((off + t * speed * 3) % span) - 150 - 240;
      g.drawImage(cloud, x, y, 20);
   }

   private static void petals(Graphics g, float t, boolean front) {
      for (int i = 0; i < NP; i++) {
         boolean near = psz[i] >= 3;
         if (near != front) {
            continue;
         }
         float tt = (t + pph[i] * 3) % plife[i];
         float y = py[i] + pv[i] * tt;
         float x = px[i] + pdr[i] * tt + (float) Math.sin(tt * 1.7 + pph[i]) * psw[i] * 0.5f + (float) Math.sin(tt * 0.6) * 12;
         if (y > 296 || y < 0) {
            continue;
         }
         float flip = (float) Math.sin(tt * 4 + pph[i]);
         int s = psz[i];
         int w = Math.max(1, Math.round(s * (0.5f + Math.abs(flip) * 0.7f)));
         g.setColor(pcol[i]);
         g.fillRect((int) x, (int) y, w + 1, Math.max(1, s - 1) + 1);
      }
   }

   private static void logo(Graphics g, float t) {
      if (logo == null) {
         return;
      }
      float a = ease((t - 0.2f) / 0.8f);
      if (a <= 0) {
         return;
      }
      int y = 8 + (int) ((1 - a) * -14);
      g.drawScaled(logo, 0, y, 240, 76);
   }

   // ---------------- свиток ----------------
   private static void scroll(Graphics g, float t, String[] items, int sel, long now) {
      float open = ease((t - 0.5f) / 1.1f);
      int cy = 196, fullH = 206;
      float hh = fullH * open;
      if (hh < 2) {
         return;
      }
      int x0 = 10, x1 = 230;
      int y0 = (int) (cy - hh / 2), y1 = (int) (cy + hh / 2);
      // тень
      g.fillRectArgb(x0 + 3, y1 + 3, x1 - x0, 6, 0x5A000000);
      // лист
      g.setColor(0xEED9A4);
      g.fillRect(x0 + 4, y0, x1 - x0 - 8, y1 - y0);
      for (int i = 0; i < 10; i++) {
         int a = (int) (70 * (1 - i / 10f) * (1 - i / 10f));
         g.fillRectArgb(x0 + 4, y0 + 8 + i, x1 - x0 - 8, 1, (a << 24) | 0x7A5A2A);
         g.fillRectArgb(x0 + 4, y1 - 9 - i, x1 - x0 - 8, 1, (a << 24) | 0x7A5A2A);
      }
      g.setColor(0xA88A4A);
      g.fillRect(x0 + 4, y0 + 8, 1, Math.max(1, y1 - y0 - 16));
      g.fillRect(x1 - 5, y0 + 8, 1, Math.max(1, y1 - y0 - 16));
      // пункты и подсветка (сначала подсветка)
      java.util.Random fr = new java.util.Random(2);
      for (int i = 0; i < 24; i++) {
         int yy = y0 + 14 + fr.nextInt(Math.max(1, y1 - y0 - 28));
         int ln = 8 + fr.nextInt(18);
         int xx = x0 + 10 + fr.nextInt(200 - ln);
         g.fillRectArgb(xx, yy, ln, 1, 0x2DC9AA6A);
      }
      int row0 = 134, rowH = 24;
      // положение подсветки: плавно догоняет выбранный пункт (при переходе вниз едет сверху вниз)
      float dt = lastSelNs == 0 ? 0f : Math.min(0.1f, (now - lastSelNs) / 1e9f);
      lastSelNs = now;
      selPos += (sel - selPos) * Math.min(1f, dt * 14f);
      if (Math.abs(sel - selPos) < 0.01f) {
         selPos = sel;
      }
      if (t > 1.2f) {
         float a = ease((t - 1.5f) / 0.5f);
         int by = row0 + (int) (selPos * rowH);
         int ia = (int) (255 * a);
         g.fillRectArgb(x0 + 10, by - 11, x1 - x0 - 20, 22, (ia << 24) | 0xE8C26A);
         g.fillRectArgb(x0 + 10, by - 11, x1 - x0 - 20, 1, (ia << 24) | 0xB78F3A);
         g.fillRectArgb(x0 + 10, by + 10, x1 - x0 - 20, 1, (ia << 24) | 0xB78F3A);
         g.setColor(0x8A2210);
         if (a > 0.6f) {
            for (int k = 0; k < 6; k++) {
               g.fillRect(x0 + 18 + k, by - 6 + k, 1, 12 - 2 * k);
               g.fillRect(x1 - 18 - k, by - 6 + k, 1, 12 - 2 * k);
            }
         }
      }
      for (int i = 0; i < items.length; i++) {
         float show = ease((t - (1.25f + i * 0.1f)) / 0.35f);
         if (show <= 0.05f) {
            continue;
         }
         float near = Math.max(0f, 1 - Math.abs(selPos - i));
         Font f = near > 0.5f ? fSel : fItem;
         g.setFont(f);
         int c = near > 0.5f ? 0x6A1608 : 0x4A2E14;
         String s = items[i].trim();
         int w = f.stringWidth(s);
         int y = row0 + i * rowH - f.getHeight() / 2 + (int) ((1 - show) * -10);
         g.setColor(c);
         g.drawString(s, (x0 + x1) / 2 - w / 2, y, 20);
         if (i > 0 && near < 0.5f && Math.abs(selPos + 0.5f - i) > 0.6f) {
            g.fillRectArgb(x0 + 24, row0 + (int) ((i - 0.5f) * rowH), x1 - x0 - 48, 1, 0x6EA88A4A);
         }
      }
      // верхний и нижний валики с загибами
      roller(g, x0, x1, y0, true);
      roller(g, x0, x1, y1, false);
   }

   private static void roller(Graphics g, int x0, int x1, int ry, boolean up) {
      // загнутый край листа
      g.setColor(0xCDB27A);
      int dy = up ? 7 : -13;
      g.fillRect(x0 + 8, ry + dy, x1 - x0 - 16, 6);
      g.setColor(0xB78F3A);
      g.fillRect(x0 - 4, ry - 7, x1 - x0 + 8, 14);
      int[] cols = {0x3A2410, 0x6E4B26, 0xA97F45, 0xD6B574, 0xE9D39B, 0xD6B574, 0xA97F45, 0x6E4B26};
      for (int i = 0; i < cols.length; i++) {
         g.setColor(cols[i]);
         g.fillRect(x0 - 2, ry - 7 + i * 2 - (i * 2) / 10, x1 - x0 + 4, 2);
      }
      g.setColor(0xD9AE4F);
      g.fillRect(x0 - 8, ry - 9, 6, 18);
      g.fillRect(x1 + 2, ry - 9, 6, 18);
      g.setColor(0xF4D889);
      g.fillRect(x0 - 8, ry - 9, 2, 18);
      g.setColor(0x9C7424);
      g.fillRect(x1 + 6, ry - 9, 2, 18);
   }
}
