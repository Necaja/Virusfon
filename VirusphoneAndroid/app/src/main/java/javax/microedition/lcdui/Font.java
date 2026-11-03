package javax.microedition.lcdui;

import android.graphics.Paint;
import android.graphics.Typeface;

public final class Font {
   public static final int STYLE_PLAIN = 0, STYLE_BOLD = 1, STYLE_ITALIC = 2, STYLE_UNDERLINED = 4;
   public static final int SIZE_MEDIUM = 0, SIZE_SMALL = 8, SIZE_LARGE = 16;
   public static final int FACE_SYSTEM = 0, FACE_MONOSPACE = 32, FACE_PROPORTIONAL = 64;

   /** Размеры шрифтов в пикселях логического экрана 240x320. Подстройте под желаемый вид. */
   private static final float PX_SMALL = 12f, PX_MEDIUM = 14f, PX_LARGE = 18f;

   private static final Font[] CACHE = new Font[3 * 8 * 3];
   final Paint paint = new Paint();
   private final int face, style, size;

   private Font(int face, int style, int size) {
      this.face = face;
      this.style = style;
      this.size = size;
      paint.setAntiAlias(true);
      paint.setTextSize(size == SIZE_SMALL ? PX_SMALL : size == SIZE_LARGE ? PX_LARGE : PX_MEDIUM);
      int ts = ((style & STYLE_BOLD) != 0 ? Typeface.BOLD : 0) | ((style & STYLE_ITALIC) != 0 ? Typeface.ITALIC : 0);
      paint.setTypeface(Typeface.create(face == FACE_MONOSPACE ? Typeface.MONOSPACE : Typeface.DEFAULT, ts));
      paint.setUnderlineText((style & STYLE_UNDERLINED) != 0);
   }

   public static Font getFont(int face, int style, int size) {
      int fi = face == FACE_MONOSPACE ? 1 : face == FACE_PROPORTIONAL ? 2 : 0;
      int si = size == SIZE_SMALL ? 1 : size == SIZE_LARGE ? 2 : 0;
      int idx = (fi * 8 + (style & 7)) * 3 + si;
      synchronized (CACHE) {
         if (CACHE[idx] == null) {
            CACHE[idx] = new Font(face, style, size);
         }
         return CACHE[idx];
      }
   }

   public static Font getDefaultFont() {
      return getFont(FACE_SYSTEM, STYLE_PLAIN, SIZE_MEDIUM);
   }

   public int getFace() { return face; }
   public int getStyle() { return style; }
   public int getSize() { return size; }
   public boolean isBold() { return (style & STYLE_BOLD) != 0; }

   public int getHeight() {
      Paint.FontMetrics fm = paint.getFontMetrics();
      return (int) Math.ceil(fm.descent - fm.ascent);
   }

   public int getBaselinePosition() {
      return (int) Math.ceil(-paint.getFontMetrics().ascent);
   }

   public int stringWidth(String s) {
      return (int) Math.ceil(paint.measureText(s));
   }

   public int charWidth(char c) {
      return (int) Math.ceil(paint.measureText(String.valueOf(c)));
   }

   public int charsWidth(char[] ch, int off, int len) {
      return (int) Math.ceil(paint.measureText(ch, off, len));
   }

   public int substringWidth(String s, int off, int len) {
      return (int) Math.ceil(paint.measureText(s, off, off + len));
   }
}
