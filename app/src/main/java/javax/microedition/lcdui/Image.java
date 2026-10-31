package javax.microedition.lcdui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import compat.Res;
import java.io.IOException;
import java.io.InputStream;

public class Image {
   final Bitmap bitmap;
   private final boolean mutable;

   private Image(Bitmap b, boolean mutable) {
      this.bitmap = b;
      this.mutable = mutable;
   }

   public Bitmap getBitmap() {
      return bitmap;
   }

   private static BitmapFactory.Options opts() {
      BitmapFactory.Options o = new BitmapFactory.Options();
      o.inScaled = false; // без масштабирования по density — пиксель в пиксель
      o.inPreferredConfig = Bitmap.Config.ARGB_8888;
      return o;
   }

   /** Загрузка PNG из assets: createImage("/hero.png"). */
   public static Image createImage(String name) throws IOException {
      InputStream in = Res.open(name);
      if (in == null) {
         throw new IOException("resource not found: " + name);
      }
      try {
         Bitmap b = BitmapFactory.decodeStream(in, null, opts());
         if (b == null) {
            throw new IOException("cannot decode: " + name);
         }
         return new Image(b, false);
      } finally {
         try {
            in.close();
         } catch (IOException ignored) {
         }
      }
   }

   public static Image createImage(int w, int h) {
      Bitmap b = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
      b.eraseColor(0xFFFFFFFF); // MIDP: изменяемое изображение изначально белое
      return new Image(b, true);
   }

   public static Image createImage(byte[] data, int off, int len) {
      Bitmap b = BitmapFactory.decodeByteArray(data, off, len, opts());
      if (b == null) {
         throw new IllegalArgumentException("cannot decode image data");
      }
      return new Image(b, false);
   }

   public static Image createImage(Image src) {
      return new Image(src.bitmap, false);
   }

   public static Image createRGBImage(int[] rgb, int w, int h, boolean processAlpha) {
      Bitmap b = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
      if (!processAlpha) {
         int[] c = new int[w * h];
         for (int i = 0; i < c.length; i++) {
            c[i] = rgb[i] | 0xFF000000;
         }
         rgb = c;
      }
      b.setPixels(rgb, 0, w, 0, 0, w, h);
      return new Image(b, false);
   }

   public Graphics getGraphics() {
      if (!mutable) {
         throw new IllegalStateException("immutable image");
      }
      return new Graphics(new android.graphics.Canvas(bitmap), bitmap.getWidth(), bitmap.getHeight());
   }

   public boolean isMutable() {
      return mutable;
   }

   public int getWidth() {
      return bitmap.getWidth();
   }

   public int getHeight() {
      return bitmap.getHeight();
   }

   public void getRGB(int[] rgb, int offset, int scanlength, int x, int y, int w, int h) {
      bitmap.getPixels(rgb, offset, scanlength, x, y, w, h);
   }
}
