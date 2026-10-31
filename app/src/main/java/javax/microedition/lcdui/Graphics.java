package javax.microedition.lcdui;

import android.graphics.Paint;
import android.graphics.RectF;

/** MIDP-Graphics поверх android.graphics.Canvas. Клип хранится "по-J2ME" (абсолютная замена). */
public class Graphics {
   public static final int HCENTER = 1, VCENTER = 2, LEFT = 4, RIGHT = 8, TOP = 16, BOTTOM = 32, BASELINE = 64;
   public static final int SOLID = 0, DOTTED = 1;

   private final android.graphics.Canvas c;
   private final Paint fill = new Paint();
   private final Paint bmp = new Paint();
   private final RectF oval = new RectF();
   private final int width, height;
   private int color = 0xFF000000;
   private int tx, ty;
   private int clipX, clipY, clipW, clipH;
   private int stroke = SOLID;
   private Font font = Font.getDefaultFont();

   public Graphics(android.graphics.Canvas c, int w, int h) {
      this.c = c;
      this.width = w;
      this.height = h;
      fill.setAntiAlias(false);
      fill.setStrokeWidth(1f);
      bmp.setFilterBitmap(false);
      bmp.setAntiAlias(false);
      reset();
   }

   /** Сброс состояния перед каждым paint(): нулевой translate, клип = весь экран. */
   public void reset() {
      tx = 0;
      ty = 0;
      clipX = 0;
      clipY = 0;
      clipW = width;
      clipH = height;
      color = 0xFF000000;
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
      color = 0xFF000000 | rgb;
   }

   public void setColor(int r, int g, int b) {
      color = 0xFF000000 | ((r & 255) << 16) | ((g & 255) << 8) | (b & 255);
   }

   public int getColor() {
      return color & 0xFFFFFF;
   }

   public void setGrayScale(int v) {
      setColor(v, v, v);
   }

   public void setFont(Font f) {
      font = f == null ? Font.getDefaultFont() : f;
   }

   public Font getFont() {
      return font;
   }

   public void setStrokeStyle(int s) {
      stroke = s;
   }

   public int getStrokeStyle() {
      return stroke;
   }

   public void translate(int x, int y) {
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
      clipX = x;
      clipY = y;
      clipW = Math.max(0, w);
      clipH = Math.max(0, h);
   }

   public void clipRect(int x, int y, int w, int h) {
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
      if (w <= 0 || h <= 0) {
         return;
      }
      begin();
      fill.setStyle(Paint.Style.FILL);
      fill.setColor(color);
      c.drawRect(tx + x, ty + y, tx + x + w, ty + y + h, fill);
      end();
   }

   public void drawRect(int x, int y, int w, int h) {
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
      begin();
      fill.setStyle(Paint.Style.STROKE);
      fill.setColor(color);
      c.drawLine(tx + x1 + 0.5f, ty + y1 + 0.5f, tx + x2 + 0.5f, ty + y2 + 0.5f, fill);
      end();
   }

   public void fillArc(int x, int y, int w, int h, int startAngle, int arcAngle) {
      begin();
      fill.setStyle(Paint.Style.FILL);
      fill.setColor(color);
      oval.set(tx + x, ty + y, tx + x + w, ty + y + h);
      c.drawArc(oval, -startAngle, -arcAngle, true, fill); // MIDP: против часовой, Android: по часовой
      end();
   }

   public void drawArc(int x, int y, int w, int h, int startAngle, int arcAngle) {
      begin();
      fill.setStyle(Paint.Style.STROKE);
      fill.setColor(color);
      oval.set(tx + x + 0.5f, ty + y + 0.5f, tx + x + w + 0.5f, ty + y + h + 0.5f);
      c.drawArc(oval, -startAngle, -arcAngle, false, fill);
      end();
   }

   public void fillTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
      begin();
      android.graphics.Path p = new android.graphics.Path();
      p.moveTo(tx + x1, ty + y1);
      p.lineTo(tx + x2, ty + y2);
      p.lineTo(tx + x3, ty + y3);
      p.close();
      fill.setStyle(Paint.Style.FILL);
      fill.setColor(color);
      c.drawPath(p, fill);
      end();
   }

   @SuppressWarnings("deprecation")
   public void drawRGB(int[] rgb, int offset, int scanlength, int x, int y, int w, int h, boolean processAlpha) {
      if (w <= 0 || h <= 0) {
         return;
      }
      begin();
      c.drawBitmap(rgb, offset, scanlength, tx + x, ty + y, w, h, processAlpha, bmp);
      end();
   }

   // ---------- изображения ----------
   public void drawImage(Image img, int x, int y, int anchor) {
      if (img == null) {
         return;
      }
      int w = img.getWidth(), h = img.getHeight();
      if ((anchor & HCENTER) != 0) x -= w / 2; else if ((anchor & RIGHT) != 0) x -= w;
      if ((anchor & VCENTER) != 0) y -= h / 2; else if ((anchor & BOTTOM) != 0) y -= h;
      begin();
      c.drawBitmap(img.bitmap, tx + x, ty + y, bmp);
      end();
   }

   /** Nokia DirectGraphics.drawImage: manipulation = FLIP_HORIZONTAL 0x2000 | FLIP_VERTICAL 0x4000 | ROTATE_90/180/270. */
   public void drawImageManip(Image img, int x, int y, int anchor, int manip) {
      if (img == null) {
         return;
      }
      boolean fh = (manip & 0x2000) != 0, fv = (manip & 0x4000) != 0;
      int rot = manip & 0x1FF;
      if (!fh && !fv && rot == 0) {
         drawImage(img, x, y, anchor);
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
      c.drawBitmap(img.bitmap, 0, 0, bmp);
      end();
   }

   // ---------- текст ----------
   public void drawString(String s, int x, int y, int anchor) {
      if (s == null || s.length() == 0) {
         return;
      }
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
