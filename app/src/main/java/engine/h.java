package engine;

import com.nokia.mid.ui.DirectGraphics;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class h {
   private static int a = 0;
   private static int b = 0;
   private static int c;
   private static int[][] d = new int[10][5];
   private static boolean e = false;

   public static final void a(Graphics var0, Image var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      var0.setClip(var2, var3, var4, var5);
      var0.drawImage(var1, var2 - var6, var3 - var7, 20);
      a(var0, 0, 0, 240, 320);
   }

   public static final void a(Graphics var0, DirectGraphics var1, Image var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      var0.setClip(var3, var4, var5, var6);
      var1.drawImage(var2, var3 - var7, var4, 20, 8192);
      a(var0, 0, 0, 240, 320);
   }

   public static final void a(Graphics var0, Image var1, int var2, int var3) {
      var0.setClip(var2, var3, var1.getWidth(), var1.getHeight());
      var0.drawImage(var1, var2, var3, 20);
      a(var0, 0, 0, 240, 320);
   }

   public static final void b(Graphics var0, Image var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if (var2 > 99999999 || var2 < 0) {
         var2 = 0;
      }

      int var8 = var4;
      int[] var9;
      (var9 = new int[8])[7] = var2 / 10000000 % 10;
      var9[6] = var2 / 1000000 % 10;
      var9[5] = var2 / 100000 % 10;
      var9[4] = var2 / 10000 % 10;
      var9[3] = var2 / 1000 % 10;
      var9[2] = var2 / 100 % 10;
      var9[1] = var2 / 10 % 10;
      var9[0] = var2 % 10;
      int var10 = 8;

      while (var10 > 1 && var9[var10 - 1] <= 0) {
         var10--;
      }

      if (var7 == 1) {
         var3 -= var10 * var5;
      } else if (var7 == 2) {
         var3 -= var10 * var5 / var7;
      }

      var2 = var3;

      for (int var12 = 0; var12 < var10; var12++) {
         var0.setClip(var3 + var12 * var5, var4, var5, var6);
         var0.drawImage(var1, var2 + (var12 - var9[var10 - 1 - var12]) * var5, var8, 20);
      }

      a(var0, 0, 0, 240, 320);
   }

   private static void a(Graphics var0, int var1, int var2, int var3, int var4, int var5) {
      if ((var5 & 0xFF000000) == -16777216) {
         var0.setColor(var5);
         var0.fillRect(0, 0, 240, 320);
      } else {
         if ((var5 & 0xFF000000) != 0) {
            int[] var6;
            (var6 = new int[240 * 320])[0] = var5;
            var2 = 1;

            while (var2 < var6.length) {
               var3 = var2;
               if (var2 + var2 > var6.length) {
                  var3 = var6.length - var2;
               }

               System.arraycopy(var6, 0, var6, var2, var3);
               var2 += var3;
            }

            var0.drawRGB(var6, 0, 240, 0, 0, 240, 320, true);
         }
      }
   }

   public static final boolean a(Graphics var0, boolean var1, int var2) {
      switch (a + 2) {
         case 0:
            a(var0, 0, 0, 240, 320, 0 | 15 - b << 28 | 15 - b << 24);
            if (b >= 15) {
               b = 0;
               a++;
            } else {
               b++;
            }
            break;
         case 1:
            if (engine.a.b(6)) {
               a++;
            }
            break;
         case 2:
            a(var0, 0, 0, 240, 320, 0 | b << 28 | b << 24);
            if (b >= 15) {
               b = 0;
               a++;
            } else {
               b++;
            }
            break;
         case 3:
            a(var0, 0, 0, 240, 320, 0 | 15 - b << 28 | 15 - b << 24);
            a = 0;
            return true;
      }

      return false;
   }

   public static final boolean a(Graphics var0, Image var1) {
      a(var0, 15395305);
      switch (c) {
         case 0:
         default:
            break;
         case 1:
            var0.setClip(-10, 109, 67, 69);
            var0.drawImage(var1, -10, 109, 20);
            break;
         case 2:
            var0.setClip(32, 109, 67, 69);
            var0.drawImage(var1, 32, 109, 20);
            break;
         case 3:
            var0.setClip(41, 108, 67, 69);
            var0.drawImage(var1, -26, 108, 20);
            break;
         case 4:
            var0.setClip(41, 108, 67, 69);
            var0.drawImage(var1, -94, 108, 20);
            break;
         case 5:
            var0.setClip(53, 118, 48, 47);
            var0.drawImage(var1, 53, 48, 20);
            break;
         case 6:
            var0.setClip(63, 130, 108, 50);
            var0.drawImage(var1, 15, 60, 20);
            break;
         case 7:
            var0.setClip(67, 136, 104, 46);
            var0.drawImage(var1, 67, 14, 20);
            break;
         case 8:
         case 9:
         case 10:
         case 11:
         case 12:
            var0.setClip(69, 138, 102, 44);
            var0.drawImage(var1, -35, 16, 20);
            break;
         case 13:
            var0.setClip(69, 138, 102, 44);
            var0.drawImage(var1, -35, 16, 20);
            c = 0;
            return true;
      }

      if (engine.a.b(2)) {
         c++;
      }

      return false;
   }

   public static final void a(Graphics var0, int var1) {
      var0.setClip(0, 0, 240, 320);
      var0.setColor(var1);
      var0.fillRect(0, 0, 240, 320);
   }

   public static final void a(Graphics var0, int var1, int var2, int var3, int var4) {
      var0.setClip(0, var2, 240, var4);
   }

   public static final void a(Graphics var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if (var1 == -1) {
         var1 = 240 - var3 >> 1;
      }

      var0.setClip(0, 0, 240, 320);
      var0.setColor(var5);
      var0.fillRect(var1, var2, var3, var4);
      var0.setColor(var6);
      var0.fillRect(var1 + 1, var2 + 1, var3 - 2, var4 - 2);
   }

   public static void a() {
      e = true;
   }

   public static void b() {
      if (e) {
         for (int var0 = 0; var0 < d.length; var0++) {
            if (d[var0][4] != 0) {
               a(main.f.g, main.f.A, d[var0][0], d[var0][1], 36, 37, d[var0][2] * 36, 0);
               d[var0][2]++;
               d[var0][2] = d[var0][2] % 3;
               d[var0][3] = 0;
               d[var0][0] = d[var0][0] - 8;
               d[var0][1] = d[var0][1] + 8;
               if (d[var0][0] + 36 < 0 || d[var0][1] > 320) {
                  d[var0][4] = 0;
               }
            }
         }

         if (engine.a.c(10)) {
            for (int var1 = 0; var1 < d.length; var1++) {
               if (d[var1][4] == 0) {
                  d[var1][4] = 1;
                  d[var1][3] = 0;
                  d[var1][0] = engine.a.a(24) * 10 + 120;
                  d[var1][1] = -37;
                  break;
               }
            }
         }

         if (engine.a.b(100)) {
            main.f.W = true;
            main.f.E = true;
         }
      }
   }
}
