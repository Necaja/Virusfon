package main;

public final class a {
   public static int a = 0;
   public static int b = 0;
   private static d[] i;
   private static short[] j;
   private static boolean[] k;
   static d[] c;
   private static d l = new d();
   static int d;
   static c[] e;
   private static byte[] m;
   private static byte[] n;
   private static byte[] o;
   private static int[] p;
   private static int[][] q;
   private static int r;
   private static int s;
   static boolean f = false;
   private static int t;
   private static int u;
   static int g;
   static int h;
   private static int v;
   private static int w;

   public a() {
      i = new d[100];
      j = new short[100];
      k = new boolean[100];

      for (int var1 = 0; var1 < 100; var1++) {
         i[var1] = new d();
         j[var1] = -1;
         k[var1] = false;
      }
   }

   private static d b(int var0) {
      int var2 = 0;

      d var10000;
      while (true) {
         if (var2 >= 100) {
            var10000 = null;
            break;
         }

         if (!k[var2]) {
            j[var2] = (short)var0;
            k[var2] = true;
            i[var2].a();
            var10000 = i[var2];
            break;
         }

         var2++;
      }

      d var1 = var10000;
      c[var0] = var1;
      System.arraycopy(n, 0, m, 0, n.length);
      var1.a(m, p[var0], var0);
      return var1;
   }

   static d a(d var0) {
      for (int var1 = d - 1; var1 >= 0; var1--) {
         d var2;
         if ((var2 = c[var1]) != null && var2.a[3] && var2 != var0 && var2.h < 5 && var0.a(var2)) {
            return var2;
         }
      }

      return null;
   }

   public static void a() {
      if (e != null) {
         for (int var0 = 0; var0 < e.length; var0++) {
            e[var0].a = null;
         }
      }

      if (c != null) {
         for (int var1 = 0; var1 < d; var1++) {
            if (c[var1] != null && var1 >= 5 && c[var1].k == 0) {
               c[var1] = null;
            }
         }
      }

      for (int var2 = 0; var2 < 100; var2++) {
         j[var2] = -1;
         k[var2] = false;
      }
   }

   public final void b() {
      for (int var2 = 0; var2 < e.length; var2++) {
         e[var2].a();
      }

      System.arraycopy(n, 0, m, 0, n.length);
      System.arraycopy(n, 0, o, 0, n.length);
      l.a();

      for (int var3 = 0; var3 < 5; var3++) {
         c[var3].a();
      }

      for (int var4 = 0; var4 < d; var4++) {
         d var1;
         if ((var1 = c[var4]) != null) {
            var1.a(m, p[var4], var4);
         }
      }

      for (int var5 = 0; var5 < d; var5++) {
         if (a(a, b, var5) && c[var5] == null) {
            b(var5);
         }
      }

      a(true, c[main.f.d]);
      c[main.f.c].a(true);
   }

   public static int a(byte[] var0, int var1) {
      n = new byte[var1];
      o = new byte[var1];
      m = new byte[var1];
      System.arraycopy(var0, 0, m, 0, var1);
      System.arraycopy(m, 0, n, 0, var1);
      p = new int[d = var1 / 19];
      q = new int[d][];
      c = new d[d];
      int var3 = 0;

      for (int var2 = 0; var2 < d; var2++) {
         p[var2] = var3;
         if (var2 < 5) {
            c[var2] = new d();
         } else if ((m[var2 * 19 + 2] & 16) != 0) {
            c[var2] = new d();
            c[var2].k = 1;
         }

         q[var2] = new int[4];
         q[var2][0] = main.f.a(m, var3 + 7) - 150;
         q[var2][1] = main.f.a(m, var3 + 9) - 150;
         q[var2][2] = main.f.a(m, var3 + 7) + 150;
         q[var2][3] = main.f.a(m, var3 + 9) + 150;
         var3 += 19;
      }

      return 0;
   }

   public static void c() {
      if (!engine.c.e) {
         int[] var0 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
         int var1 = 0;

         for (int var2 = d - 1; var2 >= 0; var2--) {
            d var3;
            if ((var3 = c[var2]) != null && var3.a[3]) {
               if ((var3.h != 8 || var3.g != 0)
                  && (var3.h != 4 || var3.g != 1)
                  && (var3.h != 4 || var3.g != 3)
                  && (var3.h != 59 || var3.g != 7 && var3.g != 12)
                  && (var3.h != 61 || var3.g != 6)
                  && (var3.h != 62 || var3.g != 7 && var3.g != 9)
                  && (var3.h != 63 || var3.g != 7 && var3.g != 9)
                  && (var3.h != 64 || var3.g != 7 && var3.g != 9)
                  && (var3.h != 65 || var3.g < 11 || var3.g > 17)
                  && (var3.h != 66 || var3.g != 8 && var3.g != 10)) {
                  int var4 = a;
                  int var5 = b;
                  javax.microedition.lcdui.Display.tag(16 + var2, (var3.c >> 8) - var4, (var3.d >> 8) - var5);
                  var3.a(var4, var5);
               } else {
                  var0[var1] = var2;
                  var1++;
               }
            }
         }

         for (int var6 = 0; var6 < var0.length; var6++) {
            d var7;
            if (var0[var6] > 0 && (var7 = c[var0[var6]]) != null && var7.a[3]) {
               int var8 = a;
               int var9 = b;
               javax.microedition.lcdui.Display.tag(16 + var0[var6], (var7.c >> 8) - var8, (var7.d >> 8) - var9);
               var7.a(var8, var9);
            }
         }

         javax.microedition.lcdui.Display.tag(0, 0, 0);
         main.f.g.setClip(0, 0, 240, 320);
      }
   }

   private static boolean a(int var0, int var1, int var2) {
      return var0 <= q[var2][2] && var1 <= q[var2][3] && var0 + 240 >= q[var2][0] && var1 + 320 >= q[var2][1];
   }

   public final void a(boolean var1) {
      label59:
      for (int var7 = d - 1; var7 >= 0; var7--) {
         d var2 = c[var7];
         if (a(a, b, var7)) {
            if (var2 == null) {
               var2 = b(var7);
            }
         } else if (var2 != null && var7 >= 5 && !var2.a[2] && !var2.equals(l)) {
            d var10000 = c[var7];
            int var5 = p[var7];
            byte[] var4 = m;
            d var3 = var10000;
            var5++;
            var5++;
            byte var6 = 0;
            if (var3.a[0]) {
               var6 = 1;
            }

            if (var3.a[1]) {
               var6 = (byte)(var6 + 2);
            }

            if (var3.a[2]) {
               var6 = (byte)(var6 + 4);
            }

            if (var3.a[3]) {
               var6 = (byte)(var6 + 8);
            }

            var4[var5] = var6;
            c[var7] = null;
            int var8 = var7;

            for (int var9 = 0; var9 < 100; var9++) {
               if (j[var9] == var8) {
                  k[var9] = false;
                  i[var9].a();
                  continue label59;
               }
            }
            continue;
         }

         if (var2 != null && var1) {
            var2.b();
         }
      }

      a(false, c[main.f.d]);
   }

   private static int b(int var0, int var1) {
      if (Math.abs(var0) > Math.abs(var1)) {
         if (var1 != 0 && var0 / var1 > 0) {
            var0 -= var1;
         }

         if (var0 > 0) {
            if (var0 < 8) {
               var0 = 1;
            } else if (var0 < 16) {
               var0 = 2;
            } else if (var0 < 32) {
               var0 = 4;
            } else if (var0 < 64) {
               var0 = 8;
            } else if (var0 < 128) {
               var0 = 16;
            } else {
               var0 = 32;
            }

            if (var1 > 0) {
               var0 += var1;
            }
         } else {
            if (var0 > -8) {
               var0 = -1;
            } else if (var0 > -16) {
               var0 = -2;
            } else if (var0 > -32) {
               var0 = -4;
            } else if (var0 > -64) {
               var0 = -8;
            } else if (var0 > -128) {
               var0 = -16;
            } else {
               var0 = -32;
            }

            if (var1 < 0) {
               var0 += var1;
            }
         }
      }

      return var0;
   }

   static void b(boolean var0) {
      System.arraycopy(o, 0, m, 0, m.length);

      for (int var1 = 0; var1 < d; var1++) {
         if (c[var1] != null && !c[var1].equals(c) && var1 >= 5 && c[var1].k == 0) {
            c[var1] = null;
            k[var1] = false;
         }
      }

      if (l != null) {
         l.a[3] = false;
      }
   }

   static void a(int var0) {
      s %= 2;
      r %= 2;
      var0 <<= 1;
      s += var0;
      r += var0;
   }

   public static void a(int var0, int var1) {
      if (var0 == -1 && var1 == -1) {
         g = a;
         h = a;
      } else {
         g = var0;
         if (var0 < 0) {
            g = 0;
         }

         if ((h = var1 - 240) > engine.c.a * engine.c.c - 240) {
            h = engine.c.a * engine.c.c - 240;
         }
      }

      f = true;
   }

   public static void d() {
      g = 0;
      h = engine.c.a * engine.c.c - 240;
      v = 0;
      w = engine.c.b * engine.c.c - 320;
      f = false;
   }

   private static void a(boolean var0, d var1) {
      int var2 = 0;
      int var3 = 0;
      var2 = (var1.c >> 8) - 120;
      var3 = (var1.d >> 8) - 160;
      if (var1.h < 5) {
         var2 += var1.i - a;
         var3 += var1.j - b;
      } else {
         var2 -= a;
         var3 -= b;
      }

      if (var0) {
         a += var2;
         b += var3;
      } else {
         int var6 = b(var2, var1.e >> 8);
         int var5 = b(var3, var1.f >> 8);
         a += var6;
         b += var5;
         if (r > 0) {
            b = b + (r % 2 != 1 ? -12 : 12);
            r--;
         }

         if (s > 0) {
            a = a + (s % 2 != 1 ? -12 : 12);
            s--;
         }
      }

      if (a < g) {
         a = g;
      }

      if (c[main.f.c].c >> 8 < g + 16 && c[main.f.c].l) {
         c[main.f.c].c = g + 16 << 8;
      }

      if (a > h) {
         a = h;
         if (c[main.f.c].c >> 8 >= h + 240 - 16 && c[main.f.c].l) {
            c[main.f.c].c = h + 240 - 16 << 8;
         }
      }

      if (b < 0) {
         b = 0;
      }

      if (b > w) {
         b = w;
      }

      if (t == a && u == b) {
         main.f.e = false;
      } else {
         t = a;
         u = b;
         main.f.e = true;
      }

      if (main.f.E) {
         if (main.f.K == 610) {
            main.f.f = 0;
            main.f.E = false;
            engine.c.e = true;
            main.f.N = true;
            return;
         }

         if (main.f.K == -1) {
            cMIDlet.b.f();
            main.f.f = 0;
            engine.c.e = true;
            main.f.E = false;
            return;
         }

         if (main.f.K == 701) {
            cMIDlet.b.e();
            main.f.f = 0;
            engine.c.e = true;
            main.f.E = false;
            return;
         }

         if (main.f.K == 702) {
            cMIDlet.b.i();
            main.f.f = 0;
            engine.c.e = true;
            main.f.E = false;
            return;
         }

         if (main.f.K == 609 && main.e.q(39) > 2) {
            if (!main.e.i(32)) {
               main.f.f = 0;
               main.f.E = false;
               engine.c.e = true;
               main.f.N = true;
               return;
            }

            main.f.K = 610;
            main.f.f = 0;
            engine.c.e = true;
            main.f.E = false;
            main.f.k = 2;
            return;
         }

         main.f.f = 0;
         main.f.E = false;
         engine.c.e = true;
         main.f.k = 2;
      }

      if (main.f.C) {
         main.f.K = 0;
         main.f.f = 0;
         engine.c.e = true;
         main.e.g = 18;
         main.f.C = false;
         main.f.k = 2;
      }
   }
}
