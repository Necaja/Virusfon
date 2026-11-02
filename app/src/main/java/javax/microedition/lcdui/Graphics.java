package javax.microedition.lcdui;

import android.graphics.Paint;
import android.graphics.RectF;

/** MIDP-Graphics поверх android.graphics.Canvas. Клип хранится "по-J2ME" (абсолютная замена). */
public class Graphics {
   public static final int HCENTER = 1, VCENTER = 2, LEFT = 4, RIGHT = 8, TOP = 16, BOTTOM = 32, BASELINE = 64;
   public static final int SOLID = 0, DOTTED = 1;

   private android.graphics.Canvas c;
   private final Paint fill = new Paint();
   private final Paint bmp = new Paint();
   private final Paint fillAA = new Paint();
   private final Paint hqPaint = new Paint();
   private final RectF dstF = new RectF();
   /** Режим вывода прямо на экранный (аппаратный) Canvas: матрица масштаба уже выставлена снаружи. */
   private boolean gpu;
   private int hqk = 1;
   private final RectF oval = new RectF();
   private final int width, height;
   private int color = 0xFF000000;
   private int tx, ty;
   private int clipX, clipY, clipW, clipH;
   private int stroke = SOLID;
   private Font font = Font.getDefaultFont();
   /** "Широкий" режим: игра верстает кадр 240x320 в центре; с каждого бока extra пикселей мира. */
   private int extra;
   /** Запись команд кадра (только для экранного Graphics), см. Rec. */
   private Rec rec;

   /** Привязать к экранному Canvas (матрица масштаба задана снаружи) и включить увеличенные картинки. */
   public void bindGpu(Object canvas, int k) {
      c = (android.graphics.Canvas) canvas;
      gpu = true;
      hqk = k;
      hqPaint.setFilterBitmap(true);
   }

   public void unbind() {
      c = null;
      gpu = false;
   }

   void setRec(Rec r) {
      rec = r;
   }

   /** Сменить текущую группу интерполяции; клип фиксируется без сдвига, чтобы он не "утёк" между группами. */
   void recTag(int id) {
      if (rec != null && rec.tag != id) {
         rec.tag = 0;
         rec.add(5, clipX, clipY, clipW, clipH, 0, 0, null);
         rec.tag = id;
         if (id != 0) {
            rec.tagged = true;
         }
      }
   }

   public Graphics(android.graphics.Canvas c, int w, int h) {
      this.c = c;
      this.width = w;
      this.height = h;
      fill.setAntiAlias(false);
      fill.setStrokeWidth(1f);
      fillAA.setAntiAlias(true);
      fillAA.setStrokeWidth(1f);
      bmp.setFilterBitmap(false);
      bmp.setAntiAlias(false);
      reset();
   }

   /** Сброс состояния перед каждым paint(): нулевой translate, клип = весь экран. */
   /** Включить широкий режим (только для экранного Graphics): центральная область 240 сдвигается на extra. */
   public void setWide(int extra) {
      this.extra = extra;
      reset();
   }

   public void reset() {
      tx = extra;
      ty = 0;
      clipX = -extra;
      clipY = 0;
      clipW = width;
      clipH = height;
      color = 0xFF000000;
   }

   /** Любой "на всю ширину исходного экрана" прямоугольник (x=0, w=240) в широком режиме растягивается на весь кадр. */
   private boolean full(int x, int w) {
      return extra > 0 && x == 0 && w == 240;
   }

   private void begin() {
      c.save();
      c.clipRect(tx + clipX, ty + clipY, tx + clipX + clipW, ty + clipY + clipH);
   }

   private void end() {
      c.restore();
   }

   // ---------- состояние ----------
   public void setColor(int rgb) {
      if (rec != null) rec.add(1, rgb & 0xFFFFFF, 0, 0, 0, 0, 0, null);
      color = 0xFF000000 | rgb;
   }

   public void setColor(int r, int g, int b) {
      if (rec != null) rec.add(1, ((r & 255) << 16) | ((g & 255) << 8) | (b & 255), 0, 0, 0, 0, 0, null);
      color = 0xFF000000 | ((r & 255) << 16) | ((g & 255) << 8) | (b & 255);
   }

   public int getColor() {
      return color & 0xFFFFFF;
   }

   public void setGrayScale(int v) {
      setColor(v, v, v);
   }

   public void setFont(Font f) {
      if (rec != null) rec.add(2, 0, 0, 0, 0, 0, 0, f == null ? Font.getDefaultFont() : f);
      font = f == null ? Font.getDefaultFont() : f;
   }

   public Font getFont() {
      return font;
   }

   public void setStrokeStyle(int s) {
      if (rec != null) rec.add(3, s, 0, 0, 0, 0, 0, null);
      stroke = s;
   }

   public int getStrokeStyle() {
      return stroke;
   }

   public void translate(int x, int y) {
      if (rec != null) rec.add(4, x, y, 0, 0, 0, 0, null);
      tx += x;
      ty += y;
   }

   public int getTranslateX() {
      return tx;
   }

   public int getTranslateY() {
      return ty;
   }

   public void setClip(int x, int y, int w, int h) {
      if (rec != null) rec.add(5, x, y, w, h, 0, 0, null);
      if (full(x, w)) {
         x = -tx; // на весь кадр, даже если игра сдвинула начало координат (translate)
         w = width;
      }
      clipX = x;
      clipY = y;
      clipW = Math.max(0, w);
      clipH = Math.max(0, h);
   }

   public void clipRect(int x, int y, int w, int h) {
      if (rec != null) rec.add(6, x, y, w, h, 0, 0, null);
      if (full(x, w)) {
         x = -tx; // на весь кадр, даже если игра сдвинула начало координат (translate)
         w = width;
      }
      int x2 = Math.min(clipX + clipW, x + w);
      int y2 = Math.min(clipY + clipH, y + h);
      clipX = Math.max(clipX, x);
      clipY = Math.max(clipY, y);
      clipW = Math.max(0, x2 - clipX);
      clipH = Math.max(0, y2 - clipY);
   }

   public int getClipX() { return clipX; }
   public int getClipY() { return clipY; }
   public int getClipWidth() { return clipW; }
   public int getClipHeight() { return clipH; }

   // ---------- примитивы ----------
   public void fillRect(int x, int y, int w, int h) {
      if (rec != null) rec.add(7, x, y, w, h, 0, 0, null);
      if (w <= 0 || h <= 0) {
         return;
      }
      if (full(x, w)) {
         x = -tx; // на весь кадр, даже если игра сдвинула начало координат (translate)
         w = width;
      }
      begin();
      fill.setStyle(Paint.Style.FILL);
      fill.setColor(color);
      c.drawRect(tx + x, ty + y, tx + x + w, ty + y + h, fill);
      end();
   }

   public void drawRect(int x, int y, int w, int h) {
      if (rec != null) rec.add(8, x, y, w, h, 0, 0, null);
      if (w < 0 || h < 0) {
         return;
      }
      begin();
      fill.setStyle(Paint.Style.STROKE);
      fill.setColor(color);
      c.drawRect(tx + x + 0.5f, ty + y + 0.5f, tx + x + w + 0.5f, ty + y + h + 0.5f, fill);
      end();
   }

   public void drawLine(int x1, int y1, int x2, int y2) {
      if (rec != null) rec.add(9, x1, y1, x2, y2, 0, 0, null);
      begin();
      fill.setStyle(Paint.Style.STROKE);
      fill.setColor(color);
      c.drawLine(tx + x1 + 0.5f, ty + y1 + 0.5f, tx + x2 + 0.5f, ty + y2 + 0.5f, fill);
      end();
   }

   public void fillArc(int x, int y, int w, int h, int startAngle, int arcAngle) {
      if (rec != null) rec.add(10, x, y, w, h, startAngle, arcAngle, null);
      begin();
      Paint pa = gpu ? fillAA : fill;
      pa.setStyle(Paint.Style.FILL);
      pa.setColor(color);
      oval.set(tx + x, ty + y, tx + x + w, ty + y + h);
      c.drawArc(oval, -startAngle, -arcAngle, true, pa); // MIDP: против часовой, Android: по часовой
      end();
   }

   public void drawArc(int x, int y, int w, int h, int startAngle, int arcAngle) {
      if (rec != null) rec.add(11, x, y, w, h, startAngle, arcAngle, null);
      begin();
      Paint pa = gpu ? fillAA : fill;
      pa.setStyle(Paint.Style.STROKE);
      pa.setColor(color);
      oval.set(tx + x + 0.5f, ty + y + 0.5f, tx + x + w + 0.5f, ty + y + h + 0.5f);
      c.drawArc(oval, -startAngle, -arcAngle, false, pa);
      end();
   }

   public void fillTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
      if (rec != null) rec.add(12, x1, y1, x2, y2, x3, y3, null);
      begin();
      android.graphics.Path p = new android.graphics.Path();
      p.moveTo(tx + x1, ty + y1);
      p.lineTo(tx + x2, ty + y2);
      p.lineTo(tx + x3, ty + y3);
      p.close();
      Paint pa = gpu ? fillAA : fill;
      pa.setStyle(Paint.Style.FILL);
      pa.setColor(color);
      c.drawPath(p, pa);
      end();
   }

   @SuppressWarnings("deprecation")
   public void drawRGB(int[] rgb, int offset, int scanlength, int x, int y, int w, int h, boolean processAlpha) {
      if (w <= 0 || h <= 0) {
         return;
      }
      if (rec != null) {
         if (w * h > 4096) {
            rec.overflow = true; // большие заливки (fade) не интерполируем
         } else {
            int[] cp = new int[w * h];
            for (int row = 0; row < h; row++) {
               System.arraycopy(rgb, offset + row * scanlength, cp, row * w, w);
            }
            rec.add(13, x, y, w, h, processAlpha ? 1 : 0, 0, cp);
         }
      }
      if (extra > 0 && x == 0 && y == 0 && w == 240 && h == 320 && scanlength == 240
            && rgb[offset] == rgb[offset + 240 * 320 - 1]) {
         // однотонная полноэкранная заливка/затемнение (fade): растягиваем на весь широкий кадр
         begin();
         fill.setStyle(Paint.Style.FILL);
         fill.setColor(processAlpha ? rgb[offset] : (0xFF000000 | rgb[offset]));
         c.drawRect(0, ty, width, ty + height, fill);
         end();
         return;
      }
      begin();
      c.drawBitmap(rgb, offset, scanlength, tx + x, ty + y, w, h, processAlpha, bmp);
      end();
   }

   private final Paint smooth = new Paint();
   private final android.graphics.Rect srcR = new android.graphics.Rect();
   private final android.graphics.Rect dstR = new android.graphics.Rect();

   /** Масштабирует изображение в прямоугольник (x,y,w,h) со сглаживанием (для размытия боковых полей). */
   public void drawScaled(Image img, int x, int y, int w, int h) {
      if (rec != null) rec.add(14, x, y, w, h, 0, 0, img);
      smooth.setFilterBitmap(true);
      srcR.set(0, 0, img.getWidth(), img.getHeight());
      dstR.set(tx + x, ty + y, tx + x + w, ty + y + h);
      begin();
      c.drawBitmap(img.bitmap, srcR, dstR, smooth);
      end();
   }

   /** Заливка с альфа-каналом (argb), в отличие от setColor, который альфу отбрасывает. */
   public void fillRectArgb(int x, int y, int w, int h, int argb) {
      if (rec != null) rec.add(15, x, y, w, h, argb, 0, null);
      begin();
      fill.setStyle(Paint.Style.FILL);
      fill.setColor(argb);
      c.drawRect(tx + x, ty + y, tx + x + w, ty + y + h, fill);
      end();
   }

   // ---------- изображения ----------
   public void drawImage(Image img, int x, int y, int anchor) {
      if (img == null) {
         return;
      }
      if (rec != null) rec.add(16, x, y, anchor, 0, 0, 0, img);
      drawImage0(img, x, y, anchor);
   }

   private void drawImage0(Image img, int x, int y, int anchor) {
      int w = img.getWidth(), h = img.getHeight();
      if ((anchor & HCENTER) != 0) x -= w / 2; else if ((anchor & RIGHT) != 0) x -= w;
      if ((anchor & VCENTER) != 0) y -= h / 2; else if ((anchor & BOTTOM) != 0) y -= h;
      begin();
      android.graphics.Bitmap q = gpu ? img.hq(hqk) : null;
      if (q != null) {
         dstF.set(tx + x, ty + y, tx + x + w, ty + y + h);
         c.drawBitmap(q, null, dstF, hqPaint);
      } else {
         c.drawBitmap(img.bitmap, tx + x, ty + y, bmp);
      }
      end();
   }

   /** Nokia DirectGraphics.drawImage: manipulation = FLIP_HORIZONTAL 0x2000 | FLIP_VERTICAL 0x4000 | ROTATE_90/180/270. */
   public void drawImageManip(Image img, int x, int y, int anchor, int manip) {
      if (img == null) {
         return;
      }
      boolean fh = (manip & 0x2000) != 0, fv = (manip & 0x4000) != 0;
      int rot = manip & 0x1FF;
      if (rec != null) rec.add(17, x, y, anchor, manip, 0, 0, img);
      if (!fh && !fv && rot == 0) {
         drawImage0(img, x, y, anchor);
         return;
      }
      int w = img.getWidth(), h = img.getHeight();
      boolean swap = rot == 90 || rot == 270;
      int dw = swap ? h : w, dh = swap ? w : h;
      if ((anchor & HCENTER) != 0) x -= dw / 2; else if ((anchor & RIGHT) != 0) x -= dw;
      if ((anchor & VCENTER) != 0) y -= dh / 2; else if ((anchor & BOTTOM) != 0) y -= dh;
      begin();
      c.translate(tx + x + dw / 2f, ty + y + dh / 2f);
      if (rot != 0) {
         c.rotate(-rot); // Nokia: против часовой
      }
      c.scale(fh ? -1 : 1, fv ? -1 : 1);
      c.translate(-w / 2f, -h / 2f);
      android.graphics.Bitmap q = gpu ? img.hq(hqk) : null;
      if (q != null) {
         dstF.set(0, 0, w, h);
         c.drawBitmap(q, null, dstF, hqPaint);
      } else {
         c.drawBitmap(img.bitmap, 0, 0, bmp);
      }
      end();
   }

   // ---------- текст ----------
   public void drawString(String s, int x, int y, int anchor) {
      if (s == null || s.length() == 0) {
         return;
      }
      if (rec != null) rec.add(18, x, y, anchor, 0, 0, 0, s);
      Paint p = font.paint;
      Paint.FontMetrics fm = p.getFontMetrics();
      float w = p.measureText(s);
      float px = x, py;
      if ((anchor & HCENTER) != 0) px = x - w / 2f; else if ((anchor & RIGHT) != 0) px = x - w;
      if ((anchor & BASELINE) != 0) py = y; else if ((anchor & BOTTOM) != 0) py = y - fm.descent; else py = y - fm.ascent;
      begin();
      p.setColor(color);
      p.setStyle(Paint.Style.FILL);
      c.drawText(s, tx + px, ty + py, p);
      end();
   }

   public void drawSubstring(String s, int off, int len, int x, int y, int anchor) {
      drawString(s.substring(off, off + len), x, y, anchor);
   }

   public void drawChar(char ch, int x, int y, int anchor) {
      drawString(String.valueOf(ch), x, y, anchor);
   }

   public void drawChars(char[] data, int off, int len, int x, int y, int anchor) {
      drawString(new String(data, off, len), x, y, anchor);
   }
}
