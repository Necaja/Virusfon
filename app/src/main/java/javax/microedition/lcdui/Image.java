package javax.microedition.lcdui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import compat.Res;
import java.io.IOException;
import java.io.InputStream;

public class Image {
   final Bitmap bitmap;
   private final boolean mutable;
   /** Во сколько раз увеличивать картинки алгоритмами Scale2x/Scale3x для отрисовки на видеокарте (1 = не увеличивать). */
   public static volatile int hqK = 1;
   private static long hqBytes;
   private static final long HQ_BUDGET = 220L << 20;
   private volatile Bitmap hq;
   private volatile int hqKk;
   private boolean hqFail;

   private static final java.util.concurrent.ExecutorService HQ_EXEC = java.util.concurrent.Executors.newSingleThreadExecutor(
         new java.util.concurrent.ThreadFactory() {
            public Thread newThread(Runnable r) {
               Thread t = new Thread(r, "hq-build");
               t.setDaemon(true);
               t.setPriority(Thread.NORM_PRIORITY - 1);
               return t;
            }
         });
   private volatile boolean hqQueued;

   /**
    * Увеличенная копия (только для неизменяемых картинок). Строится в фоне при первом обращении;
    * пока не готова, возвращает null (рисуется обычная картинка), так что рывков при загрузке уровня нет.
    */
   Bitmap hq(int k) {
      if (k < 2 || mutable || hqFail) {
         return null;
      }
      Bitmap h = hq;
      if (h != null && hqKk == k) {
         return h;
      }
      if (!hqQueued) {
         hqQueued = true;
         final int kk = k;
         HQ_EXEC.execute(new Runnable() {
            public void run() {
               buildHq(kk);
            }
         });
      }
      return null;
   }

   private void buildHq(int k) {
      int w = bitmap.getWidth(), h = bitmap.getHeight();
      long bytes = (long) w * h * k * k * 4;
      if (bytes > (24L << 20) || w * h < 4) {
         hqFail = true;
         return;
      }
      synchronized (Image.class) {
         if (hqBytes + bytes > HQ_BUDGET) {
            hqFail = true;
            return;
         }
         hqBytes += bytes;
      }
      try {
         int[] s = new int[w * h];
         bitmap.getPixels(s, 0, w, 0, 0, w, h);
         int[] d = new int[w * h * k * k];
         if (k == 2) {
            compat.PixelScale.x2Rows(s, d, w, h, 0, h);
         } else {
            compat.PixelScale.x3(s, d, w, h);
         }
         Bitmap b = Bitmap.createBitmap(w * k, h * k, Bitmap.Config.ARGB_8888);
         b.setPixels(d, 0, w * k, 0, 0, w * k, h * k);
         hqSize = bytes;
         hqKk = k;
         hq = b;
      } catch (Throwable e) {
         synchronized (Image.class) {
            hqBytes -= bytes;
         }
         hqFail = true;
      }
   }

   private long hqSize;

   private void releaseHq() {
      if (hq != null) {
         synchronized (Image.class) {
            hqBytes -= hqSize;
            hqSize = 0;
         }
         hq = null;
      }
   }

   @Override
   protected void finalize() throws Throwable {
      try {
         releaseHq();
      } finally {
         super.finalize();
      }
   }

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

   /** Сделать изменяемое изображение полностью прозрачным (в MIDP оно изначально белое). */
   public void clear() {
      bitmap.eraseColor(0);
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
