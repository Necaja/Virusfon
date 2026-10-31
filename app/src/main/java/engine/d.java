package engine;

import java.util.Vector;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class d {
   private static int a = 0;
   private static int b = 0;
   private static int c = 0;
   private static int d;
   private static byte e;
   private static byte f;
   private static boolean g;
   private static String[][] h;
   private static int i = 0;
   private static int j;
   private static int k = 0;
   private static int l = 0;
   private static boolean m = false;
   private static boolean n = false;

   public static boolean a(Graphics var0, String[] var1) {
      int var2 = 260 / (engine.g.b + 2) + 2;
      if (c == 0) {
         if (a < 30) {
            a++;
         } else {
            var0.setClip(0, 15, 240, 260);
            var0.setFont(engine.g.a);
            var0.setColor(16777215);
            int var3 = 0;
            if (30 - (290 - b) > 0) {
               var3 = (30 - (290 - b)) / (engine.g.b + 2);
            }

            for (int var4 = var3 + var2 > var1.length ? var1.length : var3 + var2; var3 < var4; var3++) {
               b(var0, var1[var3], -1, 290 - b + var3 * (engine.g.b + 2), 16777215, 0, 20);
            }

            if ((b += 2) > (var1.length + 1) * (engine.g.b + 2) + 320 - 60) {
               c = 1;
            }
         }
      } else {
         if (a <= 0) {
            c = 0;
            b = 0;
            return true;
         }

         a--;
      }

      engine.h.a(var0, 0, 0, 240, 320);
      var0.setColor(0);
      var0.fillRect(0, 0, 240, a);
      var0.fillRect(0, 320 - a, 240, a);
      a(var0, null, "Пропустить");
      return false;
   }

   public static void a() {
      c = 1;
   }

   public static void a(Graphics var0, String var1, int var2, int var3, int var4, int var5, int var6) {
      if (h == null) {
         int var7 = var5;
         Font var16 = engine.g.a;
         var1 = var1;
         String[] var23;
         if (var1 == null) {
            var23 = null;
         } else {
            if (var5 < var16.charWidth('哈')) {
               var7 = var16.charWidth('哈');
            }

            int var8 = 0;
            int var9 = 0;
            Vector var10 = new Vector();
            StringBuffer var11 = null;
            boolean var17 = false;

            while (var1.length() > var8) {
               char var18;
               switch (var18 = var1.charAt(var8)) {
                  case '\b':
                     (var11 = new StringBuffer(var1)).deleteCharAt(var8);
                     var1 = var11.toString();
                     break;
                  case '\t':
                     (var11 = new StringBuffer(var1)).deleteCharAt(var8);
                     var11.insert(var8, "　　");
                     var1 = var11.toString();
                     break;
                  case '\n':
                     var10.addElement(var1.substring(0, var8));
                     var1 = var1.substring(var8 + 1);
                     var9 = 0;
                     var8 = 0;
                     break;
                  case '\u000b':
                  default:
                     if (var9 + var16.charWidth(var18) > var7) {
                        var10.addElement(var1.substring(0, var8));
                        var1 = var1.substring(var8);
                        var9 = 0;
                        var8 = 0;
                     } else {
                        var9 += var16.charWidth(var18);
                        var8++;
                     }
                     break;
                  case '\f':
                     (var11 = new StringBuffer(var1)).deleteCharAt(var8);
                     var1 = var11.toString();
                     var10.addElement("Дальше");
                     break;
                  case '\r':
                     (var11 = new StringBuffer(var1)).deleteCharAt(var8);
                     var1 = var11.toString();
               }
            }

            var10.addElement(var1);
            String[] var13 = new String[var10.size()];
            var10.copyInto(var13);
            var23 = var13;
         }

         h = a(var23, var6 / engine.g.b);
         f = 0;
         e = 0;
         d = 0;
         if (g) {
            b();
         }

         g = false;
      }

      int var14 = d;
      var0.setFont(engine.g.a);
      var0.setColor(var2);

      for (int var15 = 0; var15 < h[f].length; var15++) {
         if (var15 < e) {
            var0.drawString(h[f][var15], var3, var4 + engine.g.b * var15, 20);
         }
      }

      if (e < h[f].length) {
         if (var14 > 0) {
            var0.drawSubstring(h[f][e], 0, var14, var3, var4 + engine.g.b * e, 20);
         }

         if (var14 < h[f][e].length()) {
            d++;
            return;
         }

         d = 0;
         e++;
      }
   }

   public static void b() {
      e = (byte)h[f].length;
   }

   public static boolean c() {
      return e >= h[f].length;
   }

   public static boolean d() {
      if (f < h.length - 1) {
         f++;
         d = 0;
         e = 0;
         return true;
      } else {
         return false;
      }
   }

   public static void e() {
      if (f > 0) {
         f--;
         d = 0;
         e = 0;
      }
   }

   public static boolean f() {
      return f < h.length - 1;
   }

   public static void a(boolean var0) {
      h = null;
      g = false;
   }

   private static String[][] a(String[] var0, int var1) {
      int var2 = 0;
      int var3 = 0;

      for (int var4 = 0; var4 < var0.length; var4++) {
         if (var0[var4].equals("Дальше") ? var2 != 0 : ++var2 % var1 == 0 || var4 == var0.length - 1) {
            var3++;
            var2 = 0;
         }
      }

      if (var3 == 0) {
         var3 = 1;
      }

      Vector var9 = new Vector();
      String[][] var8 = new String[var3][];
      int var5 = 0;
      var2 = 0;

      for (int var6 = 0; var6 < var0.length; var6++) {
         if (var0[var6].equals("Дальше")) {
            if (var2 == 0) {
               continue;
            }
         } else {
            var2++;
            var9.addElement(var0[var6]);
            if (var2 % var1 != 0 && var6 != var0.length - 1) {
               continue;
            }
         }

         var8[var5] = new String[var9.size()];
         var9.copyInto(var8[var5]);
         var9.removeAllElements();
         var5++;
         var2 = 0;
      }

      System.gc();
      return var8;
   }

   public static void b(Graphics var0, String var1, int var2, int var3, int var4, int var5, int var6) {
      if (var2 == -1) {
         var2 = (240 - engine.g.a.stringWidth(var1)) / 2;
      }

      var0.setFont(engine.g.a);
      var0.setClip(0, 0, 240, 320);
      if (var5 >= 0) {
         var0.setColor(var5);
         var0.drawString(var1, var2 + 1, var3, var6);
         var0.drawString(var1, var2 - 1, var3, var6);
         var0.drawString(var1, var2, var3 + 1, var6);
         var0.drawString(var1, var2, var3 - 1, var6);
      }

      var0.setColor(var4);
      var0.drawString(var1, var2, var3, var6);
   }

   public static void c(Graphics var0, String var1, int var2, int var3, int var4, int var5, int var6) {
      var0.setFont(engine.g.a);
      var0.setClip(0, 0, 240, 320);
      var0.setColor(var5);
      var0.drawString(var1, var2 + 1, var3, 20);
      var0.drawString(var1, var2 - 1, var3, 20);
      var0.drawString(var1, var2, var3 + 1, 20);
      var0.drawString(var1, var2, var3 - 1, 20);
      var0.setColor(var4);
      var0.drawString(var1, var2, var3, 20);
   }

   public static void a(Graphics var0, String var1, int var2, int var3, int var4, int var5) {
      var0.setFont(engine.g.a);
      var0.setClip(0, 0, 240, 320);
      var0.setColor(var4);
      var0.drawString(var1, var2, var3, 33);
   }

   public static void a(Graphics var0, String var1, String var2) {
      if (var1 != null) {
         b(var0, var1, 3, 320 - engine.g.b, 15597476, 6362880, 20);
      }

      if (var2 != null) {
         b(var0, var2, 240 - engine.g.a.stringWidth(var2) - 2, 320 - engine.g.b, 15597476, 6362880, 20);
      }
   }

   public static void a(Graphics var0, String[] var1, int var2, int var3, Image var4, Image var5) {
      int var6 = 0;
      var3 = 270 / (engine.g.b + 2) - 1;
      j = var1.length % var3 == 0 ? var1.length / var3 : var1.length / var3 + 1;
      if ((i + 1) * var3 >= var1.length) {
         var6 = var1.length - var3 * i;
      } else {
         var6 = var3;
      }

      engine.h.a(var0, 0);
      if (var4 != null) {
         engine.h.a(var0, var4, 0, 0);
      }

      var0.setFont(engine.g.a);

      for (int var9 = 0; var9 < var6; var9++) {
         var0.setColor(16777215);
         var0.drawString(var1[var9 + i * var3], 120, 50 + var9 * (engine.g.b + 2), 17);
      }

      a(var0, i + 1 + "/" + j, "Назад");
   }

   public static void g() {
      if (i > 0) {
         i--;
      }
   }

   public static void h() {
      if (i < j - 1) {
         i++;
      }
   }

   public static void i() {
      i = 0;
   }

   public static void a(Graphics var0, String[] var1, int[] var2, String[] var3, int var4, int var5, int var6, int var7) {
      if (var1 != null) {
         if (var1.length < var7) {
            var7 = var1.length;
         }

         engine.h.a(var0, 12, var5, var6, var7 * (engine.g.b + 4) + 4, 6907220, 14593146);
         engine.h.a(var0, 14, var5 + 1, var6 - 4, var7 * (engine.g.b + 4) + 2, 14593146, 16708041);

         for (int var8 = 0; var8 < var7; var8++) {
            var0.setColor(13549230);
            var0.fillRect(16, var5 + 4 + var8 * (engine.g.b + 4), var6 - 12, engine.g.b);
            if (var1 != null) {
               if (var8 == k) {
                  b(var0, var1[var8 + l], 17, var5 + 4 + var8 * (engine.g.b + 4), 16433179, 7366729, 20);
               } else {
                  b(var0, var1[var8 + l], 17, var5 + 4 + var8 * (engine.g.b + 4), 15597476, 7366729, 20);
               }
            }

            if (var2 != null) {
               if (var8 == k) {
                  b(
                     var0,
                     String.valueOf(var2[var8 + l]),
                     var6 + 12 - 10 - engine.g.a.stringWidth(String.valueOf(var2[var8 + l])),
                     var5 + 4 + var8 * (engine.g.b + 4),
                     16433179,
                     7366729,
                     20
                  );
               } else {
                  b(
                     var0,
                     String.valueOf(var2[var8 + l]),
                     var6 + 12 - 10 - engine.g.a.stringWidth(String.valueOf(var2[var8 + l])),
                     var5 + 4 + var8 * (engine.g.b + 4),
                     15597476,
                     7366729,
                     20
                  );
               }
            }

            if (var3 != null) {
               if (var8 == k) {
                  b(var0, var3[var8 + l], var6 + 12 - 10 - engine.g.a.stringWidth(var3[var8 + l]), var5 + 4 + var8 * (engine.g.b + 4), 16433179, 7366729, 20);
               } else {
                  b(var0, var3[var8 + l], var6 + 12 - 10 - engine.g.a.stringWidth(var3[var8 + l]), var5 + 4 + var8 * (engine.g.b + 4), 15597476, 7366729, 20);
               }
            }
         }

         engine.h.a(var0, var6 + 12 - 6, var5 + 2, 4, var7 * (engine.g.b + 4), 3022349, 7085131);
         engine.h.a(var0, var6 + 12 - 7, var5 + 2 + (l + k) * var7 * (engine.g.b + 4) / var1.length, 6, var7 * (engine.g.b + 4) / var1.length, 3022349, 14918185);
         var0.setColor(7085131);
         var0.fillArc(22 + engine.g.a.stringWidth(var1[l + k]), var5 + 4 + k * (engine.g.b + 4) + (engine.g.b - 10 >> 1), 10, 10, 0, 360);
         var0.setColor(4243435);
         var0.fillArc(23 + engine.g.a.stringWidth(var1[l + k]), var5 + 5 + k * (engine.g.b + 4) + (engine.g.b - 9 >> 1), 8, 8, 0, 360);
         if (m) {
            if (k > 0) {
               k--;
            } else if (k == 0 && l > 0) {
               l--;
            }

            m = false;
         }

         if (n) {
            if (k < var7 - 1) {
               k++;
            } else if (k == var7 - 1 && l + k < var1.length - 1) {
               l++;
            }

            n = false;
         }
      }
   }

   public static void j() {
      m = true;
   }

   public static void k() {
      n = true;
   }

   public static void l() {
      k = 0;
      l = 0;
   }

   public static int m() {
      return l + k;
   }

   public static final String[] a(String var0, int var1) {
      Vector var2 = new Vector();
      int var3 = 0;
      int var4 = 0;
      int var5 = var0.length();

      while (var4 <= var5) {
         if (var4 - var3 >= var1) {
            var2.addElement(var0.substring(var3, var4));
            var3 = var4;
         } else {
            var4 += var1;
         }

         if (var4 > var5) {
            var2.addElement(var0.substring(var3, var5));
         }
      }

      String[] var6 = new String[var2.size()];
      var2.copyInto(var6);
      return var6;
   }
}
