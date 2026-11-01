package engine;

import com.nokia.mid.ui.DirectGraphics;
import com.nokia.mid.ui.DirectUtils;
import java.io.IOException;
import java.io.InputStream;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class c {
   private static byte[] f;
   public static int a;
   public static int b;
   private static int g;
   private static int[] h = new int[2];
   public static int c = 16;
   public static int d = 16;
   public static boolean e = false;
   private static Image[] i = new Image[3];
   private static int j = 0;
   private static int k;
   private static int l;

   public static void a(String var0, String var1, String var2) {
      try {
         i[0] = Image.createImage(var0);
         i[1] = Image.createImage(var1);
         i[2] = Image.createImage(var2);
         h[0] = i[0].getWidth() / c;
         h[1] = i[1].getWidth() / c;
      } catch (IOException var3) {
      }
   }

   public static void a() {
      i[0] = null;
      i[1] = null;
      i[2] = null;
      System.gc();
   }

   public static int a(String var0) {
      int var1 = 0;

      try {
         InputStream var4;
         a = engine.e.a(var4 = compat.Res.open(var0));
         b = engine.e.a(var4);
         c = engine.e.a(var4);
         d = engine.e.a(var4);
         var1 = b;
         int var2 = a;
         int var6;
         var2 = (var6 = var1 * var2 << 1) << 1;
         g = var6;
         f = new byte[var2];
         var1 = 8 + engine.e.a(var4, f, 0, var2);
         var4.close();
         return var1;
      } catch (Exception var3) {
         System.out.println("Map_err");
         return -1;
      }
   }

   public static void a(int var0, int var1, Graphics var2) {
      int var19 = var1;
      var1 = var0;
      Graphics var17 = var2;
      if (!e && i[0] != null && i[1] != null) {
         DirectGraphics var3 = DirectUtils.getDirectGraphics(var2);
         javax.microedition.lcdui.Display.markWorld();
         engine.h.a(var2, 0);
         int ex = engine.View.extra();
         int var4;
         int var5 = (var4 = Math.floorDiv(var0 - ex, c)) + (240 + ex * 2) / c + 1;
         int var6;
         int var7 = (var6 = var19 / d) + 320 / d; // FIX: декомпилятор подставил var1 (=x) вместо var19 (=y)
         if (i[2] != null) {
            if (main.f.K == 0) {
               engine.h.a(var2, 12180445);
               int bh = 320 - i[2].getHeight(), bw = i[2].getWidth();
               for (int bx = -((ex + bw - 1) / bw) * bw; bx < 240 + ex; bx += bw) {
                  var2.drawImage(i[2], bx, bh, 20);
               }
            } else {
               label85: {
                  if (main.f.K == 701) {
                     engine.h.a(var2, 7631791);
                  } else if (main.f.K == 702) {
                     engine.h.a(var2, 0);
                     for (int by = 0; by <= 156; by += 52) {
                        backdrop(var2, var3, 0, by);
                     }
                     engine.h.b();
                     break label85;
                  }

                  backdrop(var2, var3, 0, 0);
               }
            }
         }

         // запас в 1 тайл со всех сторон: при интерполяции карта сдвигается на несколько пикселей назад
         javax.microedition.lcdui.Display.tag(1, -var1, -var19);
         for (int var20 = var6 - 1; var20 <= var7 + 1; var20++) {
            for (int var8 = var4 - 1; var8 <= var5 + 1; var8++) {
               int var9;
               // за краем карты столбцы тайлов отражаются зеркально (тайлы переворачиваются по горизонтали)
               boolean mir = var8 < 0 || var8 >= a;
               int colc = var8 < 0 ? -var8 - 1 : (var8 >= a ? 2 * a - var8 - 1 : var8);
               if (colc < 0 || colc >= a) {
                  continue;
               }
               if ((var9 = colc >= 0 && var20 >= 0 && var20 < b ? var20 * a + colc << 1 : -1) != -1) {
                  int var10 = var8 * c - var1;
                  int var11 = var20 * d - var19;
                  var17.setClip(var10, var11, c, d);

                  for (int var12 = 0; var12 <= 1; var12++) {
                     int var13 = 0;
                     if (var12 < 1) {
                        var13 = g;
                     }

                     byte var14;
                     if (f[var9 + var13 + 1] != -1 && f[var9 + var13] != -1) {
                        var14 = mir ? (byte)(f[var9 + var13] ^ 64) : f[var9 + var13];
                        int var15 = var12 == 1 ? h[0] : h[1];
                        int var21;
                        int var16 = (var21 = (f[var9 + var13 + 1] & 255) + ((var14 & 1) << 8)) / var15 * d;
                        k = var13 = var21 % var15 * c;
                        l = var16;
                        if (var12 > 0) {
                           if ((var14 & 192) == 0) {
                              var17.drawImage(i[0], var10 - var13, var11 - var16, 20);
                           } else {
                              var15 = a(var14, i[0].getWidth(), i[0].getHeight());
                              var3.drawImage(i[0], var10 - k, var11 - l, 20, var15);
                           }
                        } else if ((var14 & 192) == 0) {
                           var17.drawImage(i[1], var10 - var13, var11 - var16, 20);
                        } else {
                           var15 = a(var14, i[1].getWidth(), i[1].getHeight());
                           var3.drawImage(i[1], var10 - k, var11 - l, 20, var15);
                        }
                     }
                  }
               }
            }
         }
         javax.microedition.lcdui.Display.tag(0, 0, 0);
      }
   }

   /** Рисует задник (240 px шириной) в точке (x,y) и достраивает его зеркальными копиями до краёв широкого кадра. */
   private static void backdrop(Graphics g, DirectGraphics dg, int x, int y) {
      int ex = engine.View.extra();
      Image im = i[2];
      int w = im.getWidth();
      g.drawImage(im, x, y, 20);
      for (int k = 1; k <= 5; k++) {
         boolean right = x + k * w < 240 + ex;
         boolean left = x - k * w + w > -ex;
         if (!right && !left) {
            break;
         }
         int flip = k % 2 == 1 ? 8192 : 0;
         if (right) {
            dg.drawImage(im, x + k * w, y, 20, flip);
         }
         if (left) {
            dg.drawImage(im, x - k * w, y, 20, flip);
         }
      }
   }

   private static int a(int var0, int var1, int var2) {
      int var3 = 0;
      if ((var0 & 64) != 0) {
         if ((var0 & 128) != 0) {
            var3 = 180;
            k = var1 - k - c;
            l = var2 - l - d;
         } else {
            var3 = 8192;
            k = var1 - k - c;
         }
      } else if ((var0 & 128) != 0) {
         var3 = 16384;
         l = var2 - l - d;
      }

      return var3;
   }

   public static byte a(int var0, int var1) {
      if (var0 < 0 || var0 >= a) {
         return 1;
      } else if (var1 >= 0 && var1 < b) {
         byte var2;
         if ((var2 = (byte)((f[var1 * a + var0 << 1] & 62) >> 1)) == 2) {
            return 1;
         } else {
            return var2 == 1 ? 3 : var2;
         }
      } else {
         return 3;
      }
   }
}
