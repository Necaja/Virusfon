package main;

import engine.h;

public final class d {
   private c m;
   private c n;
   boolean[] a;
   int[] b;
   int c;
   int d;
   private int o;
   private int p;
   int e;
   int f;
   private int q;
   private byte r;
   int g;
   private int s;
   int h;
   private int t;
   private int u;
   private int v;
   private int w;
   private boolean x;
   private boolean y;
   private boolean z;
   private int A;
   private int B;
   private int C;
   private int[] D;
   private int[] E;
   private int F;
   int i = 24;
   private int G = 24;
   int j = -44;
   private int[] H;
   int k;
   private int I;
   private int J;
   boolean l;
   private boolean K = false;
   private int L = 0;
   private int M = 0;
   private int N;
   private int O;
   private int P;
   private int Q;
   private int R = 0;
   private int S = 0;
   private int T = 0;

   public d() {
      this.a = new boolean[4];
      this.b = new int[4];
      this.H = new int[4];
      this.D = new int[2];
      this.E = new int[4];
   }

   public final void a() {
      this.m = null;
      this.n = null;
      this.c = 0;
      this.d = 0;
      this.e = 0;
      this.f = 0;
      this.t = 0;
      this.u = 0;
      this.v = 0;

      for (int var1 = 0; var1 < 4; var1++) {
         this.a[var1] = false;
         this.b[var1] = 0;
         this.H[var1] = 0;
      }

      this.q = 0;
      this.r = 0;
      this.g = -1;
      this.s = 0;
      this.h = 0;
      this.z = false;
      this.I = -1;
      this.x = false;
      this.y = false;
      this.F = 0;
      this.l = true;
   }

   public final void a(byte[] var1, int var2, int var3) {
      this.n = new c();
      this.n.o = false;
      this.n.j = -1;
      this.J = var3;
      this.h = var1[var2++];
      this.m = main.a.e[this.h];
      this.g = var1[var2++];
      byte var15 = var1[var2++];
      this.a[0] = (var15 & 1) != 0;
      this.a[1] = (var15 & 2) != 0;
      this.a[2] = (var15 & 4) != 0;
      this.a[3] = (var15 & 8) != 0;
      if (main.f.K == 0) {
         if (this.h == 5) {
            this.a[3] = main.e.q(43) >= 3;
         } else if (this.h == 14) {
            this.a[3] = main.e.q(21) >= 3;
         } else if (this.h == 15) {
            this.a[3] = main.e.q(10) >= 3;
         } else if (this.h == 10) {
            this.a[3] = main.e.q(21) < 3;
         }
      } else if (main.f.K == 501) {
         if (this.h == 74) {
            this.a[3] = main.e.q(29) < 4;
         }
      } else if (main.f.K != 610 && main.f.K != 702) {
         if (this.h == 58) {
            this.a[3] = main.e.q(10) < 3;
         } else if (this.h == 59 && this.g != 7 && this.g != 12) {
            this.a[3] = main.e.q(43) < 3;
         } else if (this.h == 60) {
            this.a[3] = main.e.q(21) < 3;
         } else if (this.h == 61 && this.g != 6 && this.g != 2) {
            this.a[3] = main.e.q(24) < 3;
         } else if (this.h == 10 && main.f.K != 609) {
            this.a[3] = main.e.q(24) < 3;
         }
      }

      this.i = this.a[0] ? -this.G : this.G;
      this.A = var1[var2++];
      if (this.A < 0) {
         this.A += 256;
      }

      if (this.h == 8) {
         this.B = this.A;
      } else {
         this.B = main.e.e(this.A, this.h);
      }

      this.C = var1[var2++];
      this.D[0] = var1[var2++];
      this.D[1] = var1[var2++];
      this.c = main.f.a(var1, var2) << 8;
      var2 += 2;
      this.d = main.f.a(var1, var2) << 8;
      var2 += 2;
      this.o = main.f.a(var1, var2) << 8;
      var2 += 2;
      this.p = main.f.a(var1, var2) << 8;
      var2 += 2;

      for (int var16 = 0; var16 < 4; var16++) {
         this.E[var16] = var1[var2 + var16];
      }

      if (main.f.K != 701 && main.f.K != 702 && main.f.K != 610) {
         if (main.e.g == 0) {
            if (this.J == main.f.c) {
               this.a[3] = true;
               if (main.f.P) {
                  main.a.c[main.f.c].c = main.e.S;
                  main.a.c[main.f.c].d = main.e.T;
               }
            }
         } else if (this.J == main.e.g) {
            main.a.c[main.f.c].c = this.c;
            main.a.c[main.f.c].d = this.d;
            this.a[3] = true;
         }
      }

      if (this.h == 0 && this.g == 0) {
         main.f.g();
      } else {
         this.c(this.g, 1);
      }

      this.j = this.b[1];
      this.l = true;
   }

   public final void a(int var1, int var2) {
      if (this.h != 6) {
         if (this.h < 5 || this.k == 1 || b(this)) {
            var1 = (this.c >> 8) - var1;
            var2 = (this.d >> 8) - var2;
            int var6 = this.j;
            c var3 = this.n;
            if (this.n.j > 4) {
               if (var3.j < main.e.Y.length) {
                  engine.d.a(main.f.g, main.e.Y[var3.j], var1, var2 + var6, 16777215, 33);
               }
            } else if (var3.j >= 0 && main.e.X[0] > 0) {
               engine.d.a(main.f.g, main.e.h[main.e.X[0] * 3], var1, var2 + var6 - 6, 16776960, 33);
            }

            boolean var10003 = this.a[0];
            boolean var10004 = this.a[1];
            int var24 = this.q;
            boolean var21 = var10004;
            boolean var31 = var10003;
            int var5 = var2;
            int var4 = var1;
            var3 = this.m;
            byte[] var25 = this.m.e[var24];
            int var7 = var3.a.getWidth();
            int var8 = var3.a.getHeight();

            for (int var9 = 0; var9 < var25.length; var9 += 4) {
               int var10 = (var25[var9] & 255) << 2;
               int var11 = var25[var9 + 1] & 255;
               int var12 = var3.c[var10] & 255;
               int var13 = var3.c[var10 + 1] & 255;
               int var14 = var3.c[var10 + 2] & 255;
               var10 = var3.c[var10 + 3] & 255;
               if (var12 + var14 > var7) {
                  var14 = var7 - var12;
               }

               if (var13 + var10 > var8) {
                  var10 = var8 - var13;
               }

               if (var14 > 0 && var10 > 0) {
                  int var15;
                  if (var31) {
                     var15 = var4 - var25[var9 + 2];
                     var11 ^= 1;
                  } else {
                     var15 = var4 + var25[var9 + 2];
                  }

                  int var16;
                  if (var21) {
                     var16 = var5 - var25[var9 + 3];
                     var11 ^= 2;
                  } else {
                     var16 = var5 + var25[var9 + 3];
                  }

                  int var17;
                  int var18;
                  if ((var11 & 4) != 0) {
                     if ((var11 & 1) == 0) {
                        var15 -= var10;
                     }

                     if ((var11 & 2) != 0) {
                        var16 -= var14;
                     }

                     var17 = var10;
                     var18 = var14;
                  } else {
                     if ((var11 & 1) != 0) {
                        var15 -= var14;
                     }

                     if ((var11 & 2) != 0) {
                        var16 -= var10;
                     }

                     var17 = var14;
                     var18 = var10;
                  }

                  short var36;
                  switch (var11) {
                     case 1:
                        var36 = 8192;
                        var12 = var7 - var12 - var14;
                        break;
                     case 2:
                        var36 = 16384;
                        var13 = var8 - var13 - var10;
                        break;
                     case 3:
                        var36 = 180;
                        var12 = var7 - var12 - var14;
                        var13 = var8 - var13 - var10;
                        break;
                     case 4:
                        var36 = 270;
                        var14 = var12;
                        var12 = var8 - var13 - var10;
                        var13 = var14;
                        break;
                     case 5:
                        var36 = 8462;
                        var10 = var12;
                        var12 = var13;
                        var13 = var10;
                        break;
                     case 6:
                        var36 = 16654;
                        int var19 = var12;
                        var12 = var8 - var13 - var10;
                        var13 = var7 - var19 - var14;
                        break;
                     case 7:
                        var36 = 90;
                        var10 = var12;
                        var12 = var13;
                        var13 = var7 - var10 - var14;
                        break;
                     default:
                        var36 = 0;
                  }

                  if (var16 + var18 >= 0 && var16 < 320) {
                     if (var16 < 0) {
                        main.f.g.setClip(var15, 0, var17, var18 + var16);
                        main.f.g.clipRect(var15, 0, var17, var18 + var16);
                     } else if (var16 + var18 > 320) {
                        main.f.g.setClip(var15, var16, var17, 320 - var16);
                        main.f.g.clipRect(var15, var16, var17, 320 - var16);
                     } else {
                        main.f.g.setClip(var15, var16, var17, var18);
                        main.f.g.clipRect(var15, var16, var17, var18);
                     }

                     if (var36 == 0) {
                        main.f.g.drawImage(var3.a, var15 - var12, var16 - var13, 20);
                     } else {
                        main.f.h.drawImage(var3.a, var15 - var12, var16 - var13, 20, var36);
                     }
                  }
               }
            }

            var3 = this.n;
            c var28 = this.n;
            if (var3.t) {
               switch (var3.s) {
                  case 0:
                     if (var3.u) {
                        engine.h.a(main.f.g, main.f.n, var3.q - main.a.a, var3.r - main.a.b, 75, 75, 0, 0);
                     } else {
                        engine.h.a(main.f.g, main.f.h, main.f.n, var3.q - main.a.a, var3.r - main.a.b, 75, 75, 154, 0);
                     }
                     break;
                  case 1:
                     if (var3.u) {
                        engine.h.a(main.f.g, main.f.n, var3.q - 5 - main.a.a, var3.r - 5 - main.a.b, 42, 75, 75, 0);
                     } else {
                        engine.h.a(main.f.g, main.f.h, main.f.n, var3.q + 38 - main.a.a, var3.r - 5 - main.a.b, 42, 75, 112, 0);
                     }
                     break;
                  case 2:
                     if (var3.u) {
                        engine.h.a(main.f.g, main.f.n, var3.q - 6 - main.a.a, var3.r - 8 - main.a.b, 53, 75, 117, 0);
                     } else {
                        engine.h.a(main.f.g, main.f.h, main.f.n, var3.q + 29 - main.a.a, var3.r - 8 - main.a.b, 53, 75, 59, 0);
                     }
                     break;
                  case 3:
                     if (var3.u) {
                        engine.h.a(main.f.g, main.f.n, var3.q - 12 - main.a.a, var3.r - 15 - main.a.b, 59, 75, 170, 0);
                     } else {
                        engine.h.a(main.f.g, main.f.h, main.f.n, var3.q + 19 - main.a.a, var3.r - 15 - main.a.b, 59, 75, 0, 0);
                     }
               }

               var3.s++;
               if (var3.s > 3) {
                  var3.t = false;
               }
            }

            if (var3.o) {
               switch (var3.m) {
                  case 0:
                  case 1:
                     if (!var3.p) {
                        engine.h.b(main.f.g, main.f.o[1], var3.n, var3.k - main.a.a, var3.l - 10 - main.a.b, 18, 25, 2);
                     } else {
                        engine.h.a(main.f.g, main.f.p, var3.k - 43 - main.a.a, var3.l - 45 + 29 - main.a.b, 86, 45, 0, 0);
                        engine.h.b(main.f.g, main.f.o[1], var3.n, var3.k - main.a.a, var3.l - 10 - main.a.b, 18, 25, 2);
                     }
                     break;
                  case 2:
                     if (var3.p) {
                        engine.h.a(main.f.g, main.f.p, var3.k - 31 - main.a.a, var3.l - 30 + 21 - main.a.b, 62, 30, 0, 45);
                     }

                     engine.h.b(main.f.g, main.f.o[0], var3.n, var3.k - main.a.a, var3.l - 8 - main.a.b, 13, 18, 2);
                     break;
                  case 3:
                     if (var3.p) {
                        engine.h.a(main.f.g, main.f.p, var3.k - 31 - main.a.a, var3.l - 30 + 17 - main.a.b, 62, 30, 0, 45);
                     }

                     engine.h.b(main.f.g, main.f.o[0], var3.n, var3.k - main.a.a, var3.l - 12 - main.a.b, 13, 18, 2);
                     break;
                  case 4:
                     if (var3.p) {
                        engine.h.a(main.f.g, main.f.p, var3.k - 31 - main.a.a, var3.l - 30 + 13 - main.a.b, 62, 30, 0, 45);
                     }

                     engine.h.b(main.f.g, main.f.o[0], var3.n, var3.k - main.a.a, var3.l - 16 - main.a.b, 13, 18, 2);
               }

               var3.m++;
               if (var3.m > 4) {
                  var3.o = false;
               }
            }
         }

         if (main.f.k == 7 && !main.f.L && !main.f.T) {
            boolean var29 = false;
            if (this.q == -1) {
               byte var38 = -1;
            } else if (this.r < 0) {
               byte var10000 = -1;
            } else {
               this.r++;
               var1 = this.s;
               int var32 = this.g;
               c var30 = this.m;
               if (this.r >= (var32 < 0 || var32 >= var30.g.length ? -1 : (var1 >= 0 && var1 < var30.g[var32] ? var30.f[var32][(var1 << 1) + 1] : -1))) {
                  this.s++;
                  if (this.s >= this.m.g[this.g]) {
                     this.s = 0;
                     this.y = true;
                  }

                  this.q = this.m.a(this.g, this.s) & 0xFF;
                  this.r = 0;
               }
            }
         }
      }
   }

   private boolean c() {
      return this.y;
   }

   private boolean d() {
      return this.o == 0 && this.p == 0 ? false : this.c <= this.o && !this.a[0] || this.c >= this.p && this.a[0];
   }

   private static boolean a(int var0, boolean var1) {
      int var2;
      return (var2 = var0 + (var1 ? 16 : -16)) >= main.a.h + 240 && var1 || var2 <= main.a.g && !var1;
   }

   private boolean c(boolean var1) {
      return this.b(-1, true) && !var1 || this.b(1, true) && var1;
   }

   private boolean d(boolean var1) {
      return !this.l(var1) || this.c(this.a[0]) || a(this.c >> 8, this.a[0]);
   }

   private void e() {
      this.L = 0;
      this.M = engine.a.a(5) * 20 + 20;
   }

   private boolean f() {
      this.L++;
      if (this.L >= this.M) {
         this.L = 0;
         return true;
      } else {
         return false;
      }
   }

   public final void b(int var1, int var2) {
      if (main.f.c == var1) {
         this.c(var2, 1);
      } else {
         main.f.c = var1;
         main.f.d = var1;
         d var3;
         (var3 = main.a.c[main.f.c]).a[0] = this.a[0];
         var3.a[1] = this.a[1];
         var3.a[2] = this.a[2];
         var3.a[3] = this.a[3];
         var3.c = this.c;
         var3.d = this.d;
         var3.i = this.i;
         var3.c(var2, 1);
         this.a[2] = false;
         this.a[3] = false;
         this.g = -1;
         var3.n.o = this.n.o;
         var3.n.m = this.n.m;
         var3.n.k = this.n.k;
         var3.n.l = this.n.l;
         var3.n.n = this.n.n;
         var3.n.p = this.n.p;
         if (var3.n.p) {
            var3.n.l -= 15;
         }

         this.n.o = false;
      }
   }

   private void d(int var1, int var2) {
      main.e.t(this.h);
      main.e.K(this.A);
      main.e.a();
      if (this.h == 35) {
         if (main.e.q(8) == 3 && main.e.F[2] == 0) {
            main.f.b(26, 0);
            main.e.F[2]++;
         }
      } else if (this.h == 36) {
         if (main.e.q(29) == 3 && main.e.F[5] == 0) {
            main.f.b(47, 0);
            main.e.F[5]++;
         }

         main.a.d();
      }

      this.I = this.h;
      this.h = 23;
      this.m = main.a.e[this.h];
      this.c(0, 1);
   }


   // ---------- иконка атаки для сенсорной кнопки: меч со шлейфом в момент удара ----------
   /** Готовая иконка (или null) и номер оружия, для которого она построена. */
   static volatile javax.microedition.lcdui.Image uiIcon;
   static volatile int uiIconFor = -2;

   private static boolean uiBody(int tier, int rx, int ry, int rw, int rh) {
      if (rw * rh < 70) {
         return true;
      }
      if (tier == 0) {
         return rx + rw <= 130 && ry + rh <= 95;
      }
      if (tier == 1) {
         return rx + rw <= 100 && ry + rh <= 92 || ry >= 232;
      }
      return rx + rw <= 100 && ry + rh <= 92 || rx >= 198 && ry + rh <= 60 || ry >= 236 || rx >= 234;
   }

   /** Оставить в кадре только детали оружия и шлейфа (без тела героя). */
   private static byte[] uiKeep(c sp, int tier, int q) {
      byte[] src = sp.e[q];
      byte[] out = new byte[src.length];
      int n = 0;
      for (int i = 0; i + 3 < src.length; i += 4) {
         int ri = (src[i] & 255) << 2;
         if (ri + 3 >= sp.c.length) {
            continue;
         }
         int rw = sp.c[ri + 2] & 255, rh = sp.c[ri + 3] & 255;
         if (uiBody(tier, sp.c[ri] & 255, sp.c[ri + 1] & 255, rw, rh)) {
            continue;
         }
         int ox = src[i + 2], oy = src[i + 3];
         if (rw * rh < 200 && Math.abs(ox) <= 16 && oy >= -34 && oy <= 4) {
            continue; // мелкие остатки ног/рук у тела
         }
         System.arraycopy(src, i, out, n, 4);
         n += 4;
      }
      byte[] r = new byte[n];
      System.arraycopy(out, 0, r, 0, n);
      return r;
   }

   private static int uiArea(c sp, byte[] fr) {
      int a = 0;
      for (int i = 0; i + 3 < fr.length; i += 4) {
         int ri = (fr[i] & 255) << 2;
         a += (sp.c[ri + 2] & 255) * (sp.c[ri + 3] & 255);
      }
      return a;
   }

   /** Строит иконку для текущего оружия: из его трёх ударных анимаций берётся кадр с самым большим следом. */
   static void uiBuildWeaponIcon() {
      int weapon = main.e.I;
      if (uiIconFor == weapon) {
         return;
      }
      int tier = Math.max(0, Math.min(2, weapon / 4));
      c sp = main.a.e[tier + 1];
      if (sp == null || sp.e == null || sp.a == null || sp.c == null || sp.f == null || sp.g == null) {
         return; // спрайты оружия ещё не загружены — попробуем в следующем кадре
      }
      uiIconFor = weapon;
      javax.microedition.lcdui.Graphics oldG = main.f.g;
      com.nokia.mid.ui.DirectGraphics oldH = main.f.h;
      try {
         int base = weapon % 4 * 3, bestQ = -1, best = 0;
         byte[] bestFrame = null;
         for (int an = base; an < base + 3 && an < sp.g.length; an++) {
            for (int st = 0; st < sp.g[an]; st++) {
               int q = sp.f[an][st << 1];
               if (q < 0 || q >= sp.e.length) {
                  continue;
               }
               byte[] kept = uiKeep(sp, tier, q);
               int area = uiArea(sp, kept);
               if (area > best) {
                  best = area;
                  bestQ = q;
                  bestFrame = kept;
               }
            }
         }
         if (bestFrame == null) {
            return;
         }
         int size = 220;
         javax.microedition.lcdui.Image im = javax.microedition.lcdui.Image.createImage(size, size);
         im.clear();
         javax.microedition.lcdui.Graphics g2 = im.getGraphics();
         main.f.g = g2;
         main.f.h = com.nokia.mid.ui.DirectUtils.getDirectGraphics(g2);
         d tmp = new d();
         tmp.n = new c();
         tmp.m = sp;
         tmp.q = bestQ;
         tmp.c = size / 2 << 8;
         tmp.d = size * 2 / 3 << 8;
         tmp.a[3] = true;
         byte[] orig = sp.e[bestQ];
         sp.e[bestQ] = bestFrame;
         try {
            tmp.a(0, 0);
         } finally {
            sp.e[bestQ] = orig;
         }
         int[] px = new int[size * size];
         im.getRGB(px, 0, size, 0, 0, size, size);
         // убрать мелкие отдельные обрывки (остатки тела героя): оставляем куски не меньше 15% самого большого
         int[] label = new int[size * size];
         int[] stack = new int[size * size];
         int[] sizes = new int[size * size / 2 + 2];
         int labels = 0, biggest = 0;
         for (int start = 0; start < size * size; start++) {
            if (px[start] >>> 24 == 0 || label[start] != 0) {
               continue;
            }
            labels++;
            int sp2 = 0, count = 0;
            stack[sp2++] = start;
            label[start] = labels;
            while (sp2 > 0) {
               int cur = stack[--sp2];
               count++;
               int cx = cur % size, cy = cur / size;
               for (int dy = -1; dy <= 1; dy++) {
                  for (int dx = -1; dx <= 1; dx++) {
                     int nx = cx + dx, ny = cy + dy;
                     if (nx >= 0 && ny >= 0 && nx < size && ny < size) {
                        int ni = ny * size + nx;
                        if (label[ni] == 0 && px[ni] >>> 24 != 0) {
                           label[ni] = labels;
                           stack[sp2++] = ni;
                        }
                     }
                  }
               }
            }
            if (labels < sizes.length) {
               sizes[labels] = count;
            }
            biggest = Math.max(biggest, count);
         }
         for (int i = 0; i < px.length; i++) {
            if (label[i] != 0 && label[i] < sizes.length && sizes[label[i]] * 100 < biggest * 15) {
               px[i] = 0;
            }
         }
         int x0 = size, y0 = size, x1 = -1, y1 = -1;
         for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
               if (px[y * size + x] >>> 24 != 0) {
                  x0 = Math.min(x0, x);
                  x1 = Math.max(x1, x);
                  y0 = Math.min(y0, y);
                  y1 = Math.max(y1, y);
               }
            }
         }
         if (x1 >= x0) {
            int w = x1 - x0 + 1, h = y1 - y0 + 1;
            int[] cut = new int[w * h];
            for (int y = 0; y < h; y++) {
               System.arraycopy(px, (y + y0) * size + x0, cut, y * w, w);
            }
            uiIcon = javax.microedition.lcdui.Image.createRGBImage(cut, w, h, true);
         }
      } catch (Throwable e) {
         uiIcon = null;
      } finally {
         main.f.g = oldG;
         main.f.h = oldH;
      }
   }

   private static boolean b(d var0) {
      return (var0.c >> 8) + var0.b[0] <= main.a.a + engine.View.right()
         && (var0.c >> 8) + var0.b[2] >= main.a.a - engine.View.extra()
         && (var0.d >> 8) + var0.b[1] <= main.a.b + 320
         && (var0.d >> 8) + var0.b[3] >= main.a.b;
   }

   // Проверка "в кадре" по ОРИГИНАЛЬНЫМ 240 px: для сюжетных условий ("персонаж ушёл за экран"),
   // иначе в широком режиме они могут никогда не выполниться (карта уже кадра).
   private static boolean s(d var0) {
      return (var0.c >> 8) + var0.b[0] <= main.a.a + 240
         && (var0.c >> 8) + var0.b[2] >= main.a.a
         && (var0.d >> 8) + var0.b[1] <= main.a.b + 320
         && (var0.d >> 8) + var0.b[3] >= main.a.b;
   }

   private static boolean c(d var0) {
      return (var0.c >> 8) + var0.b[0] <= main.a.a + engine.View.right() + 120
         && (var0.c >> 8) + var0.b[2] >= main.a.a - engine.View.extra() - 120
         && (var0.d >> 8) + var0.b[1] <= main.a.b + 320 + 160
         && (var0.d >> 8) + var0.b[3] >= main.a.b - 160;
   }

   public final boolean b() {
      if (this.a[3] || this.h == 4 && this.g == 1 && main.e.l || this.h == 4 && this.g == 3 && main.e.m) {
         if (this.q == -1) {
            return false;
         } else if (this.h >= 5 && this.k != 1 && !c(this)) {
            return false;
         } else if (main.f.L) {
            return false;
         } else {
            this.n.j = this.h;
            if (this.F > 0) {
               this.F--;
            }

            switch (this.h) {
               case 0:
               case 1:
               case 2:
               case 3:
               case 4:
               case 7:
               case 10:
               case 12:
               case 22:
               case 24:
               case 25:
               case 26:
               case 27:
               case 28:
               case 29:
               case 30:
               case 31:
               case 32:
               case 33:
               case 34:
               case 35:
               case 36:
               case 37:
               case 38:
               case 39:
               case 40:
               case 41:
               case 42:
               case 43:
               case 44:
               case 45:
               case 46:
               case 47:
               case 48:
               case 49:
               case 50:
               case 51:
               case 52:
               case 53:
               case 54:
               case 55:
               case 56:
               case 57:
               case 58:
               case 59:
               case 60:
               case 61:
               case 62:
               case 63:
               case 64:
               case 65:
               case 66:
               case 67:
                  this.a(false);
               case 5:
               case 6:
               case 8:
               case 9:
               case 11:
               case 13:
               case 14:
               case 15:
               case 16:
               case 17:
               case 18:
               case 19:
               case 20:
               case 21:
               case 23:
               default:
                  this.e = this.e + this.t;
                  this.f = this.f + this.u;
                  if (this.f > 4096) {
                     this.f = 4096;
                  }

                  switch (this.h) {
                     case 0:
                        if (main.f.F) {
                           main.f.F = false;
                        }

                        if (main.f.H > 0) {
                           main.f.H--;
                        }

                        if (main.e.M > 0 && this.g != 7 && this.g != 1 && this.g != 2 && this.g != 18) {
                           int var8;
                           if ((var8 = this.e(false)) == -1) {
                              main.f.a(1, -1);
                              this.z = true;
                              if (this.h(true)) {
                                 this.e(true);
                                 this.c(7, 1);
                                 main.f.a(1234, -1);
                                 break;
                              }
                           } else if (var8 == 1) {
                              main.f.a(3, -1);
                              this.z = true;
                              if (this.g(true)) {
                                 this.e(true);
                                 if ((this.g < 4 || this.g > 6) && this.g != 17) {
                                    if (this.g != 19) {
                                       this.c(19, 1);
                                    }
                                 } else {
                                    this.c(7, 1);
                                    main.f.a(1234, -1);
                                 }
                                 break;
                              }
                           } else if (this.z) {
                              main.f.a(-1, -1);
                              this.z = false;
                           }
                        }

                        int var9 = 0;
                        var9 = this.g;
                        if (this.g >= 31 && var9 <= 41) {
                           var9 = 0;
                        } else if (var9 >= 20 && var9 <= 30) {
                           var9 = 3;
                        }

                        switch (var9) {
                           case 0:
                              if (this.k(true) && ++this.v > 2) {
                                 int var10001 = main.e.H[main.e.I];
                                 var9 = this.G;
                                 int var23 = var10001;
                                 int var28 = main.f.j;
                                 if ((main.f.j & 4112) != 0) {
                                    this.a[0] = true;
                                    this.i = -var9;
                                 } else if ((var28 & 8256) != 0) {
                                    this.i = var9;
                                    this.a[0] = false;
                                 }

                                 this.v = 0;
                                 this.c(var23, 1);
                                 this.I = 0;
                                 return true;
                              } else if (this.k(false)) {
                                 this.b(this.i(true));
                                 this.c(this.g, 1);
                                 this.I = 0;
                                 return true;
                              } else if (this.h(true)) {
                                 this.c(4, 1);
                                 return true;
                              } else {
                                 if (this.f(true)) {
                                    this.b(main.e.I / 4 + 1, main.e.I % 4 * 3);
                                    main.f.I = this.a[0];
                                 } else {
                                    boolean var24 = false;
                                    boolean var36;
                                    if (main.e.M >= 0 && !main.f.L && !main.f.D) {
                                       var9 = main.f.i;
                                       var36 = !b(main.f.i) && (var9 & 512) != 0;
                                    } else {
                                       var36 = false;
                                    }

                                    if (var36 && main.e.r >= 0 && main.f.Y == 0) {
                                       switch (main.e.r) {
                                          case 0:
                                             if (!main.e.l && main.e.H(20)) {
                                                this.b(4, 0);
                                                main.f.e(2);
                                             }
                                             break;
                                          case 1:
                                             if (main.e.m || !main.e.H(40)) {
                                                break;
                                             }

                                             main.e.m = true;
                                             main.e.o = 0;
                                             this.b(4, 2);
                                             main.f.G = false;

                                             for (int var22 = 0; var22 < main.e.n.length; var22++) {
                                                main.e.n[var22] = 0;
                                             }

                                             main.f.e(2);
                                             break;
                                          case 2:
                                             if (main.e.H(1)) {
                                                main.f.a(-1, -1);
                                                this.b(4, 5);
                                             }
                                       }
                                    } else {
                                       var24 = false;
                                       if (main.e.M >= 0 && !main.f.L && !main.f.D) {
                                          var9 = main.f.i;
                                          var36 = !b(main.f.i) && (var9 & 128) != 0;
                                       } else {
                                          var36 = false;
                                       }

                                       if (var36 && main.e.q >= 0 && main.f.X == 0) {
                                          switch (main.e.q) {
                                             case 0:
                                                if (!main.e.l && main.e.H(20)) {
                                                   this.b(4, 0);
                                                   main.f.e(1);
                                                }
                                                break;
                                             case 1:
                                                if (main.e.m || !main.e.H(40)) {
                                                   break;
                                                }

                                                main.e.m = true;
                                                main.e.o = 0;
                                                this.b(4, 2);
                                                main.f.G = false;

                                                for (int var21 = 0; var21 < main.e.n.length; var21++) {
                                                   main.e.n[var21] = 0;
                                                }

                                                main.f.e(1);
                                                break;
                                             case 2:
                                                if (main.e.H(1)) {
                                                   main.f.a(-1, -1);
                                                   this.b(4, 5);
                                                }
                                          }
                                       } else {
                                          var24 = false;
                                          if (main.e.M >= 0 && !main.f.L && !main.f.D) {
                                             var9 = main.f.i;
                                             var36 = !b(main.f.i) && (var9 & 2) != 0;
                                          } else {
                                             var36 = false;
                                          }

                                          if (var36 && main.e.s >= 0) {
                                             main.e.m(main.e.s);
                                             if (!main.e.i(main.e.s)) {
                                                main.e.s = -1;
                                             }
                                          } else {
                                             var24 = false;
                                             if (main.e.M >= 0 && !main.f.L && !main.f.D) {
                                                var9 = main.f.i;
                                                var36 = !b(main.f.i) && (var9 & 8) != 0;
                                             } else {
                                                var36 = false;
                                             }

                                             if (var36 && main.e.t >= 0) {
                                                main.e.m(main.e.t);
                                                if (!main.e.i(main.e.t)) {
                                                   main.e.t = -1;
                                                }
                                             }
                                          }
                                       }
                                    }

                                    this.c(1, true);
                                    if ((this.O < 3 || this.O == 7) && this.a(1) && !E()) {
                                       this.c(6, 1);
                                       return true;
                                    }
                                 }

                                 return true;
                              }
                           case 1:
                              if (!this.h(false)) {
                                 this.c(7, 1);
                                 main.f.a(1234, -1);
                              }

                              if (this.a(-1)) {
                                 this.c(18, 1);
                              }

                              return true;
                           case 2:
                              if (!this.g(false)) {
                                 this.c(7, 1);
                                 main.f.a(1234, -1);
                              }

                              if (this.a(1)) {
                                 this.c(17, 1);
                              }

                              return true;
                           case 3:
                              if (this.h(true)) {
                                 this.c(4, 1);
                              } else {
                                 if (!this.k(true) && !main.f.D) {
                                    this.c(main.e.G[main.e.I], 1);
                                 }

                                 if ((this.O < 3 || this.O == 7) && this.a(1) && !E()) {
                                    this.c(6, 1);
                                    return true;
                                 }
                              }

                              return true;
                           case 4:
                              if (this.f(true) && this.C == 0) {
                                 this.C = 1;
                                 this.c(42, 1);
                              } else if (this.y) {
                                 this.c(5, 1);
                                 return true;
                              }

                              return true;
                           case 5:
                              if (this.f(true) && this.C == 0) {
                                 this.C = 1;
                                 this.c(42, 1);
                              } else if (this.c()) {
                                 this.c(6, 1);
                                 return true;
                              }

                              return true;
                           case 6:
                              var9 = ((this.c >> 8) + (this.a[0] ? this.b[0] : this.b[2])) / engine.c.c;
                              int var4 = ((this.d >> 8) + this.b[1]) / engine.c.d;
                              boolean var35;
                              if (engine.c.a(var9, var4 - 1) < 3 && engine.c.a(var9, var4) == 4) {
                                 if (this.a[0]) {
                                    this.c = (var9 + 1) * engine.c.c << 8;
                                 } else {
                                    this.c = var9 * engine.c.c - 1 << 8;
                                 }

                                 this.d = var4 * engine.c.d - 1 << 8;
                                 var35 = true;
                              } else {
                                 var35 = false;
                              }

                              if (var35) {
                                 this.c(15, 1);
                                 main.f.a(13, -1);
                                 return true;
                              } else {
                                 if (this.f(true) && this.C == 0) {
                                    this.C = 1;
                                    this.c(42, 1);
                                 } else if (this.O >= 3 && this.O <= 6) {
                                    this.C = 0;
                                    this.c(8, 1);
                                    main.f.a(-1, -1);
                                    return true;
                                 }

                                 return true;
                              }
                           case 7:
                              if (this.h(true)) {
                                 this.c(1, 1);
                                 main.f.a(-1, -1);
                                 return true;
                              } else {
                                 if (this.k(false)) {
                                    this.b(this.i(true));
                                    this.c(6, 1);
                                    main.f.a(-1, -1);
                                 } else if (this.g(true)) {
                                    this.c(2, 1);
                                    main.f.a(-1, -1);
                                    return true;
                                 }

                                 return true;
                              }
                           case 8:
                              if (this.c()) {
                                 if (main.e.M > 0) {
                                    this.c(main.e.G[main.e.I], 1);
                                 } else {
                                    this.c(13, 1);
                                 }

                                 return true;
                              }

                              return true;
                           case 9:
                           case 10:
                           case 11:
                           case 12:
                              if (this.O < 3 || this.O == 7) {
                                 this.c(17, 1);
                              } else if (this.c()) {
                                 if (main.e.M > 0) {
                                    this.c(main.e.G[main.e.I], 1);
                                 } else {
                                    this.c(13, 1);
                                 }

                                 return true;
                              }

                              return true;
                           case 13:
                              main.e.M = 0;
                              if (this.c()) {
                                 main.e.i++;
                                 this.c(14, 1);
                                 this.I = 0;
                              }

                              return true;
                           case 14:
                              if (this.c()) {
                                 if (this.I == 0) {
                                    main.b.a(3);
                                    this.I++;
                                 } else if (this.I == 1) {
                                    if (main.e.M > 0) {
                                       this.c(main.e.G[main.e.I], 1);
                                    } else {
                                       main.f.h();
                                       this.I = 2;
                                    }

                                    return true;
                                 }

                                 return true;
                              }

                              return true;
                           case 15:
                              if (this.c()) {
                                 if (this.h(true)) {
                                    this.C = 0;
                                    this.c(16, 1);
                                    main.f.a(-1, -1);
                                 } else if (this.g(true)) {
                                    this.C = 0;
                                    this.d = this.d - (this.j << 8);
                                    this.c = this.c + ((this.a[0] ? 12 : -12) << 8);
                                    this.c(17, 1);
                                    main.f.a(-1, -1);
                                 }

                                 return true;
                              }

                              return true;
                           case 16:
                              if (this.c()) {
                                 this.c = this.c + ((this.a[0] ? -16 : 16) << 8);
                                 this.c(main.e.G[main.e.I], 1);
                              }

                              return true;
                           case 17:
                              if (this.f(true) && this.C == 0) {
                                 this.C = 2;
                                 this.c(42, 1);
                              } else if (this.O >= 3 && this.O <= 6) {
                                 this.C = 0;
                                 this.c(8, 1);
                                 main.f.a(-1, -1);
                                 return true;
                              }

                              return true;
                           case 18:
                              if (this.c()) {
                                 this.c(17, 1);
                              }

                              return true;
                           case 19:
                              if (this.c()) {
                                 this.d += 15360;
                                 this.c(7, 1);
                                 main.f.a(1234, -1);
                              }

                              return true;
                           case 20:
                           case 21:
                           case 22:
                           case 23:
                           case 24:
                           case 25:
                           case 26:
                           case 27:
                           case 28:
                           case 29:
                           case 30:
                           case 31:
                           case 32:
                           case 33:
                           case 34:
                           case 35:
                           case 36:
                           case 37:
                           case 38:
                           case 39:
                           case 40:
                           case 41:
                           default:
                              return true;
                           case 42:
                              if (this.c()) {
                                 this.c(6, 1);
                              }

                              return true;
                        }
                     case 1:
                     case 2:
                     case 3:
                        if (main.f.H > 0) {
                           main.f.H--;
                        }

                        switch (this.g) {
                           case 0:
                           case 1:
                           case 3:
                           case 4:
                           case 6:
                           case 7:
                           case 9:
                           case 10:
                              if (main.f.F && this.f(false)) {
                                 main.f.F = false;
                                 this.K = true;
                              }

                              if (this.c()) {
                                 if (this.K) {
                                    this.b(main.f.I);
                                    this.c(this.g + 1, 1);
                                    this.K = false;
                                 } else {
                                    this.b(0, main.e.G[main.e.I]);
                                 }

                                 return true;
                              }

                              return true;
                           case 2:
                           case 5:
                           case 8:
                           case 11:
                              if (this.c()) {
                                 this.b(0, main.e.G[main.e.I]);
                              }

                              return true;
                           default:
                              return true;
                        }
                     case 4:
                        if (main.f.H > 0) {
                           main.f.H--;
                        }

                        switch (this.g) {
                           case 0:
                              if (this.c()) {
                                 this.b(0, main.e.G[main.e.I]);
                                 main.e.l = true;
                              }

                              return true;
                           case 1:
                              this.n.j = -1;
                              if (!this.a[3]) {
                                 this.a[3] = main.e.l;
                                 this.b(main.a.c[4].a[0]);
                                 this.c(1, 1);
                                 this.c = main.a.c[4].c + ((this.a[0] ? -64 : 64) << 8);
                                 this.d = main.a.c[4].d - 8960;
                              }

                              if (!b(this)) {
                                 this.a[3] = false;
                                 main.e.l = false;
                              }

                              return true;
                           case 2:
                              if (!main.e.m) {
                                 this.b(0, main.e.G[main.e.I]);
                              }

                              return true;
                           case 3:
                              this.n.j = -1;
                              if (!this.a[3]) {
                                 if (main.e.o < 10 && engine.a.c(50)) {
                                    this.a[3] = main.e.m;
                                    this.J = main.e.o;
                                    this.c = main.e.n[this.J];
                                    if (this.c == 0) {
                                       this.c = engine.a.a(240) + main.a.a << 8;
                                    }

                                    this.d = main.a.b << 8;
                                    main.e.o++;
                                    this.c(3, 1);
                                    return true;
                                 }
                              } else if (!b(this)) {
                                 this.a[3] = false;
                                 if (this.J >= 9) {
                                    main.e.m = false;
                                    main.f.G = true;
                                 }

                                 return true;
                              }

                              return true;
                           case 4:
                              this.n.j = -1;
                              if (this.c()) {
                                 this.c(3, 1);
                                 this.a[3] = false;
                                 if (this.J >= 9) {
                                    main.e.m = false;
                                    main.f.G = true;
                                    return true;
                                 }
                              }

                              return true;
                           case 5:
                           case 6:
                           case 7:
                           case 8:
                              if (this.c()) {
                                 this.c(this.g + 1, 1);
                                 if (this.g == 9) {
                                    this.d -= 4096;
                                    return true;
                                 }
                              }

                              return true;
                           case 9:
                              if (this.v++ >= 5) {
                                 if (!main.e.H(1)) {
                                    this.b(0, 5);
                                    return true;
                                 }

                                 this.v = 0;
                              }

                              if (this.k(true)) {
                                 this.b(this.i(true));
                                 this.c(10, 1);
                              }

                              if (this.h(true)) {
                                 this.c(11, 1);
                              } else if (this.g(true)) {
                                 this.c(12, 1);
                                 return true;
                              }

                              return true;
                           case 10:
                              if (this.v++ >= 5) {
                                 if (!main.e.H(1)) {
                                    this.b(0, 5);
                                    return true;
                                 }

                                 this.v = 0;
                              }

                              if (!this.k(true)) {
                                 this.c(9, 1);
                              }

                              return true;
                           case 11:
                              if (this.v++ >= 5) {
                                 if (!main.e.H(1)) {
                                    this.b(0, 5);
                                    return true;
                                 }

                                 this.v = 0;
                              }

                              if (!this.h(false)) {
                                 this.c(9, 1);
                              }

                              return true;
                           case 12:
                              if (this.v++ >= 5) {
                                 if (!main.e.H(1)) {
                                    this.b(0, 5);
                                    return true;
                                 }

                                 this.v = 0;
                              }

                              if (!this.g(false)) {
                                 this.c(9, 1);
                              }

                              if (this.O >= 3 && this.O <= 6) {
                                 this.b(0, 6);
                              }

                              return true;
                           case 13:
                              if (this.c()) {
                                 this.b(0, main.e.G[main.e.I]);
                              }

                              return true;
                           default:
                              return true;
                        }
                     case 5:
                     case 9:
                     case 10:
                     case 11:
                     case 13:
                     case 14:
                     case 15:
                     case 16:
                     case 17:
                     case 18:
                     case 19:
                     case 20:
                     case 21:
                        this.l();
                        break;
                     case 6:
                        d var7 = main.a.c[main.f.c];
                        switch (this.g) {
                           case 0:
                              if (var7.g != 9) {
                                 if (this.y()) {
                                    if (this.B == 0) {
                                       if (this.I == -1) {
                                          main.a.c[1].c(6, 1);
                                          this.I++;
                                          return true;
                                       }
                                    } else if (this.I == -1) {
                                       main.a.c[2].c(11, 1);
                                       this.I++;
                                       return true;
                                    }

                                    return true;
                                 } else {
                                    if (this.I == 0) {
                                       if (this.B == 0) {
                                          main.a.c[1].c(5, 1);
                                       } else {
                                          main.a.c[2].c(10, 1);
                                       }

                                       this.I = -1;
                                       engine.d.a(false);
                                       return true;
                                    }

                                    return true;
                                 }
                              }

                              return true;
                           case 1:
                              if (var7.g != 9) {
                                 if (this.y()) {
                                    if (this.I == -1) {
                                       main.a.c[3].c(8, 1);
                                       this.I++;
                                       return true;
                                    }
                                 } else if (this.I == 0) {
                                    main.a.c[3].c(7, 1);
                                    this.I = -1;
                                    engine.d.a(false);
                                    return true;
                                 }

                                 return true;
                              }

                              return true;
                           case 2:
                              if (var7.g != 9) {
                                 if (this.y()) {
                                    if (this.I == -1) {
                                       main.a.c[4].c(4, 1);
                                       this.I++;
                                       return true;
                                    }
                                 } else if (this.I == 0) {
                                    main.a.c[4].c(3, 1);
                                    this.I = -1;
                                    engine.d.a(false);
                                    return true;
                                 }

                                 return true;
                              }

                              return true;
                           case 3:
                              if (this.y() && !main.a.f) {
                                 this.a[3] = false;
                                 main.f.K = this.B;
                                 main.f.E = true;
                              }

                              return true;
                           case 4:
                              if (var7.g < 4 && this.y()) {
                                 if (var7.a[0] == this.a[0]) {
                                    main.f.a(this.B, -1);
                                    this.I = 1;
                                 } else {
                                    main.f.a(-1, -1);
                                 }

                                 return true;
                              } else {
                                 if (this.I == 1 && var7.a(this)) {
                                    main.f.a(-1, -1);
                                    this.I = 0;
                                    return true;
                                 }

                                 return true;
                              }
                           case 5:
                              if (main.f.c == 0 && var7.g < 4 && this.c(46080) && this.d(25600) && e(this.J)) {
                                 var7.b(0, main.e.G[main.e.I]);
                                 this.c(6, 1);
                                 if (this.B > 0) {
                                    main.f.b(this.B, 0);
                                    return true;
                                 }
                              }

                              return true;
                           case 6:
                              if (i()) {
                                 if (this.D[0] == 0) {
                                    var7.b(0, 21);
                                 }

                                 if (this.C > 0) {
                                    main.f.b(this.C, 0);
                                 }

                                 this.a[3] = false;
                              }

                              return true;
                           case 7:
                              if (this.c(8192) && this.d - var7.d <= 25600 && this.d - var7.d >= 0) {
                                 for (int var17 = 1; var17 <= this.C; var17++) {
                                    main.a.c[this.J + var17].a[3] = true;
                                    if (this.D[1] == 0) {
                                       int var20 = var17 % 2;
                                       main.a.c[this.J + var17].a[0] = var20 == 1;
                                       main.a.c[this.J + var17].c = var20 == 1 ? main.a.a + (var17 << 4) << 8 : main.a.a + engine.View.right() - (var17 << 4) << 8;
                                    } else if (this.D[1] == 1) {
                                       main.a.c[this.J + var17].a[0] = false;
                                       main.a.c[this.J + var17].c = main.a.a + engine.View.right() + (var17 << 3) << 8;
                                    }

                                    if (this.D[0] > 0) {
                                       main.a.c[this.J + var17].o = main.a.a << 8;
                                       main.a.c[this.J + var17].p = main.a.a + engine.View.right() << 8;
                                    }
                                 }

                                 if (this.B > 0) {
                                    main.f.b(this.B, 0);
                                 }

                                 if (this.D[0] > 0) {
                                    main.f.J = main.f.J + this.C;
                                    main.a.a(-1, -1);
                                 }

                                 for (int var18 = 0; var18 < 4; var18 += 2) {
                                    if (this.E[var18] > 0) {
                                       main.a.c[this.E[var18]].a[3] = true;
                                       main.a.c[this.E[var18]].c(this.E[var18 + 1], 1);
                                    }
                                 }

                                 if (var7.g == 21) {
                                    var7.b(0, main.e.G[main.e.I]);
                                 }

                                 this.a[3] = false;
                              }

                              return true;
                           case 8:
                              if (this.B > 0) {
                                 if (e(this.J)) {
                                    if (this.B == 2) {
                                       main.a.c[this.J + 1].a[3] = true;
                                       this.B--;
                                       this.a[3] = false;
                                       return true;
                                    } else if (this.B == 1 && this.C == 1) {
                                       main.a.c[this.J - 1].a[3] = true;
                                       this.B--;
                                       this.a[3] = false;
                                       return true;
                                    } else {
                                       if (this.C == 0) {
                                          this.B = 0;
                                       } else if (i()) {
                                          this.B = 0;
                                          this.a[3] = false;
                                          return true;
                                       }

                                       return true;
                                    }
                                 }
                              } else if (i()) {
                                 this.a[3] = false;
                                 return true;
                              }

                              return true;
                           case 9:
                              if (this.y()) {
                                 if (this.v == 1) {
                                    var7.b(0, main.e.G[main.e.I]);
                                    main.f.D = true;
                                    main.a.c[this.J + 1].a[3] = true;
                                    main.a.c[this.J + 1].c = main.a.a - 80 << 8;
                                    main.f.a(1, -1);
                                    main.f.b(27, 0);
                                    this.v = 2;
                                    return true;
                                 }
                              } else if (this.c(15360) && this.v == 0) {
                                 main.a.a(-1, -1);
                                 this.v = 1;
                                 return true;
                              }

                              return true;
                           default:
                              return true;
                        }
                     case 7:
                     case 24:
                     case 25:
                     case 26:
                     case 27:
                     case 28:
                     case 29:
                     case 30:
                     case 31:
                     case 32:
                     case 33:
                     case 34:
                     case 35:
                     case 36:
                     case 37:
                     case 50:
                     case 51:
                     case 52:
                     case 53:
                     case 54:
                     case 55:
                     case 56:
                     case 57:
                        this.j();
                        break;
                     case 8:
                        d var6 = main.a.c[main.f.c];
                        switch (this.g) {
                           case 0:
                              this.n.j = -1;
                              if (main.f.K == 0) {
                                 if (this.y()) {
                                    if (!main.e.i(32) && !main.e.i(33)) {
                                       main.f.f(3);
                                       main.f.b(18, 0);
                                    } else if (main.e.q(2) < 2) {
                                       if (!this.z) {
                                          main.f.a("Сейчас это слишком опасно");
                                       }

                                       this.z = true;
                                       return true;
                                    }
                                 } else {
                                    this.z = false;
                                 }
                              } else if (main.f.K == 104 && this.y() && main.e.q(5) == 3 && main.e.F[1] == -1) {
                                 main.f.f(3);
                                 main.a.c[22].a[3] = true;
                                 main.e.F[1]++;
                              }

                              if (this.c(2560) && this.d(0) && main.e.M > 0) {
                                 main.f.H = 6;
                                 main.f.a(1, -1);
                                 if (this.h(true)) {
                                    if (main.f.K == 103) {
                                       if (var6.a[3] && this.J == 9 && main.e.q(5) < 2) {
                                          main.f.a("Миссия не выполнена");
                                          main.f.f(0);
                                          return true;
                                       }
                                    } else if (main.f.K == 107) {
                                       if (var6.a[3] && this.J == 9 && main.e.q(23) < 2) {
                                          main.f.a("Миссия не выполнена");
                                          main.f.f(0);
                                          return true;
                                       }
                                    } else if (main.f.K == 108) {
                                       if (var6.a[3] && this.J == 9) {
                                          if (main.e.q(24) >= 3 && !main.e.i(11)) {
                                             main.f.b(45, 0);
                                             main.f.f(0);
                                             return true;
                                          }

                                          if (main.e.q(24) != 4) {
                                             main.f.a("Миссия не выполнена");
                                             main.f.f(0);
                                             return true;
                                          }

                                          if (main.f.S[7] == 10) {
                                             main.f.S[7] = 9;
                                             main.f.a("Открыта новая сцена" + main.f.R[7]);
                                             main.f.f(0);
                                          }
                                       }
                                    } else if (main.f.K == 203) {
                                       if (var6.a[3] && this.J == 9 && main.e.q(8) < 2) {
                                          main.f.a("Миссия не выполнена");
                                          main.f.f(0);
                                          return true;
                                       }
                                    } else if (main.f.K == 207) {
                                       if (var6.a[3] && this.J == 9 && main.e.q(43) < 2) {
                                          main.f.a("Миссия не выполнена");
                                          main.f.f(0);
                                          return true;
                                       }
                                    } else if (main.f.K == 303) {
                                       if (var6.a[3] && this.J == 9 && main.e.q(10) < 2) {
                                          main.f.a("Миссия не выполнена");
                                          main.f.f(0);
                                          return true;
                                       }
                                    } else if (main.f.K == 403) {
                                       if (var6.a[3] && this.J == 9 && main.e.q(21) < 2) {
                                          main.f.a("Миссия не выполнена");
                                          main.f.f(0);
                                          return true;
                                       }
                                    } else if (main.f.K == 505) {
                                       if (var6.a[3] && this.J == 9) {
                                          if (main.e.F[6] < 1) {
                                             main.f.b(48, 0);
                                             main.f.f(0);
                                             return true;
                                          }

                                          if (main.f.S[8] == 10) {
                                             main.f.S[8] = 9;
                                             main.f.a("Открыта новая сцена" + main.f.R[8]);
                                             main.f.f(0);
                                          }
                                       }
                                    } else if (main.f.K == 604) {
                                       if (var6.a[3] && this.J == 9 && main.e.q(38) < 2) {
                                          main.f.a("Миссия не выполнена");
                                          main.f.f(0);
                                          return true;
                                       }
                                    } else if (main.f.K == 605 && var6.a[3] && this.J == 9 && main.e.q(39) < 2) {
                                       main.f.a("Миссия не выполнена");
                                       main.f.f(0);
                                       return true;
                                    }

                                    if (var6.g == main.e.H[main.e.I] || var6.g == main.e.G[main.e.I]) {
                                       var6.a[3] = false;
                                       main.a.c[this.J + 1].a[3] = true;
                                       main.a.c[this.J + 1].a[0] = var6.a[0];
                                       main.f.f(0);
                                       main.f.a(-1, -1);
                                       return true;
                                    }
                                 }
                              } else if (this.c(5120) && this.d(5120)) {
                                 main.f.a(-1, -1);
                                 return true;
                              }

                              return true;
                           case 1:
                              this.n.j = -1;
                              if (this.c()) {
                                 main.f.E = true;
                                 main.f.K = this.B * 100 + this.C;
                                 main.e.g = this.D[0];
                              }

                              return true;
                           case 2:
                              this.n.j = -1;
                              if (this.c()) {
                                 var6.a[3] = this.a[3];
                                 var6.c = this.c;
                                 var6.d = this.d;
                                 this.a[3] = false;
                              }

                              return true;
                           default:
                              return true;
                        }
                     case 12:
                        this.m();
                        break;
                     case 22:
                        this.z();
                        break;
                     case 23:
                        this.n.j = -1;
                        switch (this.g) {
                           case 0:
                              if (this.c()) {
                                 this.A();
                                 if (this.z) {
                                    this.c(1, 1);
                                 } else {
                                    this.a[3] = false;
                                 }

                                 return true;
                              }

                              return true;
                           case 1:
                           case 3:
                              if (this.y()) {
                                 main.f.a(5, -1);
                                 this.v = 1;
                                 if (this.f(true)) {
                                    this.c(this.g + 1, 1);
                                    this.A();
                                    main.f.a(-1, -1);
                                    main.f.f(0);
                                    return true;
                                 }
                              } else if (this.v == 1) {
                                 main.f.a(-1, -1);
                                 this.v = 0;
                                 return true;
                              }

                              return true;
                           case 2:
                           case 4:
                              if (this.c()) {
                                 this.a[3] = false;
                              }

                              return true;
                           default:
                              return true;
                        }
                     case 38:
                     case 39:
                     case 40:
                     case 41:
                     case 42:
                     case 43:
                     case 44:
                     case 45:
                     case 46:
                     case 47:
                     case 48:
                     case 49:
                        this.k();
                        break;
                     case 58:
                        this.n();
                        break;
                     case 59:
                        this.o();
                        break;
                     case 60:
                        this.p();
                        break;
                     case 61:
                        this.q();
                        break;
                     case 62:
                        this.r();
                        break;
                     case 63:
                        this.s();
                        break;
                     case 64:
                        this.t();
                        break;
                     case 65:
                        this.u();
                        break;
                     case 66:
                        this.v();
                        break;
                     case 67:
                        this.n.j = -1;
                        this.l = false;
                        switch (this.g) {
                           case 0:
                           case 2:
                              if (this.B()) {
                                 this.c(this.g + 1, 1);
                              }

                              this.D();
                              return true;
                           case 1:
                           case 3:
                              if (this.B()) {
                                 this.c(this.g - 1, 1);
                              }

                              this.D();
                              return true;
                           case 4:
                           case 6:
                              if (this.C()) {
                                 this.c(this.g + 1, 1);
                              }

                              this.D();
                              return true;
                           case 5:
                           case 7:
                              if (this.C()) {
                                 this.c(this.g - 1, 1);
                              }

                              this.D();
                              return true;
                           default:
                              return true;
                        }
                     case 68:
                        this.n.j = -1;
                        d var1;
                        if ((var1 = main.a.c[main.f.c]).a(this) && e(var1)) {
                           var1.a(main.e.h() / 10 + main.e.m(), var1.c < this.c, false);
                        }
                        break;
                     case 69:
                        if (this.y()) {
                           if (this.I < 0) {
                              if (main.f.P) {
                                 this.I = 0;
                                 main.f.P = false;
                              } else {
                                 this.I = 0;
                                 main.f.d();
                                 main.f.f(0);
                              }
                           }
                        } else {
                           this.I = -1;
                        }
                        break;
                     case 70:
                        this.n.j = -1;
                        main.f.f(3);
                        switch (this.g) {
                           case 0:
                              if (this.c()) {
                                 this.c(1, 1);
                                 main.f.b(21, 0);
                              }

                              return true;
                           case 1:
                              if (this.c(10240) && this.d(0)) {
                                 main.f.b(23, 0);
                                 this.c(2, 1);
                                 main.f.D = false;
                              }

                              return true;
                           case 2:
                              if (this.c()) {
                                 main.a.c[main.f.c].c(main.e.G[main.e.I], 1);
                                 main.f.b(24, 0);
                                 this.a[3] = false;
                              }

                              return true;
                           default:
                              return true;
                        }
                     case 71:
                        this.n.j = -1;
                        main.f.f(3);
                        switch (this.g) {
                           case 0:
                              if (this.c()) {
                                 this.c(1, 1);
                                 main.f.b(29, 0);
                              }

                              return true;
                           case 1:
                              if (this.c()) {
                                 this.c(2, 1);
                              }

                              return true;
                           case 2:
                              if (this.c()) {
                                 main.f.b(30, 0);
                                 this.a[3] = false;
                              }

                              return true;
                           default:
                              return true;
                        }
                     case 72:
                        this.n.j = -1;
                        main.f.f(3);
                        switch (this.g) {
                           case 0:
                              if (this.c()) {
                                 this.c(1, 1);
                                 main.f.b(34, 0);
                              }

                              return true;
                           case 1:
                              if (this.c()) {
                                 this.c(2, 1);
                              }

                              return true;
                           case 2:
                              if (this.c()) {
                                 main.f.b(35, 0);
                                 this.a[3] = false;
                              }

                              return true;
                           default:
                              return true;
                        }
                     case 73:
                        this.n.j = -1;
                        main.f.f(3);
                        switch (this.g) {
                           case 0:
                              if (this.c()) {
                                 this.c(1, 1);
                                 if (main.f.K == 609) {
                                    if (!main.e.i(32)) {
                                       main.f.b(68, 0);
                                    } else {
                                       main.f.b(65, 0);
                                    }

                                    return true;
                                 } else {
                                    main.f.b(40, 0);
                                    return true;
                                 }
                              }

                              return true;
                           case 1:
                              if (this.c() && (main.f.K != 609 || main.e.i(32))) {
                                 this.c(2, 1);
                              }

                              return true;
                           case 2:
                              if (this.c()) {
                                 if (main.f.K == 404) {
                                    main.f.b(41, 0);
                                 }

                                 this.a[3] = false;
                              }

                              return true;
                           default:
                              return true;
                        }
                     case 74:
                        this.n.j = -1;
                        switch (this.g) {
                           case 0:
                              label887: {
                                 if (this.a[3]) {
                                    d var2 = main.a.c[main.f.c];
                                    if (this.d + (this.b[1] << 8) <= var2.d + (var2.b[3] << 8) && this.d + (this.b[3] << 8) >= var2.d + (var2.b[1] << 8)) {
                                       if (this.c > var2.c) {
                                          int var3 = this.c + (this.b[0] - var2.x()[2] << 8);
                                          if (var2.c > var3) {
                                             if (var2.c - var3 > 2048) {
                                                var2.c = var2.c - (2048 + var2.e);
                                             } else {
                                                var2.c = var3;
                                             }

                                             var2.c(1, false);
                                             var2.b(-1, false);
                                             boolean var10000 = true;
                                             break label887;
                                          }
                                       } else {
                                          int var19 = this.c + (this.b[2] - var2.x()[0] << 8);
                                          if (var2.c < var19) {
                                             if (var19 - var2.c > 2048) {
                                                var2.c = var2.c + (2048 - var2.e);
                                             } else {
                                                var2.c = var19;
                                             }

                                             var2.c(1, false);
                                             var2.b(1, false);
                                             boolean var30 = true;
                                             break label887;
                                          }
                                       }
                                    }
                                 }

                                 boolean var29 = false;
                              }

                              if (main.e.q(29) == 4) {
                                 this.c(1, 1);
                              }
                              break;
                           case 1:
                              if (e(this.J)) {
                                 this.c(2, 1);
                              }
                              break;
                           case 2:
                              if (this.c()) {
                                 this.c(3, 1);
                              }
                              break;
                           case 3:
                              if (i()) {
                                 this.a[3] = false;
                              }
                        }
                  }

                  return true;
            }
         }
      } else {
         return false;
      }
   }

   private boolean b(int var1, boolean var2) {
      if (this.h != 4 || this.g != 1 && this.g != 3) {
         int var3 = this.c >> 8;
         if (var1 == -1) {
            var3 += this.b[0];
            if (var2) {
               var3--;
            }
         } else {
            var3 += this.b[2];
            if (var2) {
               var3++;
            }
         }

         if (var3 < 0) {
            var3 = -1;
         } else {
            var3 /= engine.c.c;
         }

         int var4 = ((this.d >> 8) + this.b[1] + 1) / engine.c.d;
         int var5 = ((this.d >> 8) + this.b[3]) / engine.c.d;
         int var6 = 0;

         for (int var9 = var5; var9 >= var4; var9--) {
            if ((var6 = engine.c.a(var3, var9)) == 3) {
               if (var1 != -1 && (var1 != 0 || !this.a[0])) {
                  this.c = var3 * engine.c.c - 1 - this.b[2] << 8;
               } else {
                  this.c = (var3 + 1) * engine.c.c - this.b[0] << 8;
               }

               var2 = true;
               break;
            }
         }

         if (var2) {
            if (var1 == -1) {
               this.P = var6;
            } else if (var1 == 1) {
               this.Q = var6;
            }
         }

         return var6 == 3;
      } else {
         return false;
      }
   }

   private boolean c(int var1, boolean var2) {
      if ((this.h != 4 || this.g != 1 && this.g != 3)
         && (this.h != 59 || this.g != 12 && this.g != 10)
         && (this.h != 62 || this.g != 7 && this.g != 9)
         && (this.h != 64 || this.g != 7 && this.g != 9)
         && (this.h != 63 || this.g != 7 && this.g != 9)
         && (this.h != 65 || this.g == 7 && this.d >= 69632)
         && (this.h != 66 || this.g != 8 && this.g != 10)) {
         int var3 = ((this.c >> 8) + this.b[0]) / engine.c.c;
         int var4 = ((this.c >> 8) + this.b[2]) / engine.c.c;
         int var5 = this.d >> 8;
         if (var1 < 0) {
            var5 += this.b[1];
            if (var2) {
               var5--;
            }
         } else if (var1 > 0) {
            var5 += this.b[3];
            if (var2) {
               var5++;
            }
         }

         var5 /= engine.c.d;
         int var6 = 0;
         if (this.f >= 0 && this.h < 5) {
            boolean var8 = this.a[0];
            int var9 = ((this.c >> 8) + this.b[2]) / engine.c.c;
            int var10 = engine.c.c - 1 - ((this.c >> 8) + this.b[2]) % engine.c.c;
            int var11 = ((this.d >> 8) + (var8 ? 1 : 0)) / engine.c.d;
            int var12 = ((this.c >> 8) + this.b[0]) / engine.c.c;
            int var13 = ((this.c >> 8) + this.b[0]) % engine.c.c;
            int var14 = ((this.d >> 8) + (var8 ? 0 : 1)) / engine.c.d;
            boolean var10000;
            if (engine.c.a(var9, var11) == 5) {
               this.d = var11 * engine.c.d - 1 - this.b[3] + var10 << 8;
               var10000 = true;
            } else if (engine.c.a(var12, var14) == 6) {
               if (!var8) {
                  this.d = var14 * engine.c.d - 1 - this.b[3] + var13 << 8;
               } else {
                  this.d = var14 * engine.c.d + 1 - this.b[3] + var13 << 8;
               }

               var10000 = true;
            } else {
               label203: {
                  if (var8) {
                     if (engine.c.a(var9, var11 + 1) == 5) {
                        this.d = (var11 + 1) * engine.c.d - this.b[3] + var10 << 8;
                        var10000 = true;
                        break label203;
                     }

                     if (engine.c.a(var9 + 1, var11) == 5) {
                        this.d = (var11 + 1) * engine.c.d - 1 - this.b[3] << 8;
                        var10000 = true;
                        break label203;
                     }

                     if (engine.c.a(var12, var14 - 1) == 6) {
                        this.d = (var14 - 1) * engine.c.d - 1 - this.b[3] + var13 << 8;
                        var10000 = true;
                        break label203;
                     }
                  } else {
                     if (engine.c.a(var9, var11 - 1) == 5) {
                        this.d = (var11 - 1) * engine.c.d - 1 - this.b[3] + var10 << 8;
                        var10000 = true;
                        break label203;
                     }

                     if (engine.c.a(var12, var14 + 1) == 6) {
                        this.d = (var14 + 1) * engine.c.d - this.b[3] + var13 << 8;
                        var10000 = true;
                        break label203;
                     }

                     if (engine.c.a(var12 - 1, var14) == 6) {
                        this.d = (var14 + 1) * engine.c.d - 1 - this.b[3] << 8;
                        var10000 = true;
                        break label203;
                     }
                  }

                  var10000 = false;
               }
            }

            if (var10000) {
               var6 = 5;
               var2 = true;
            }
         }

         if (var6 != 5) {
            for (int var15 = var3; var15 <= var4; var15++) {
               var6 = engine.c.a(var15, var5);
               if ((var1 >= 0 || var6 == 3) && (var1 <= 0 || var6 >= 3 && var6 <= 4)) {
                  if (var1 == -1) {
                     this.d = (var5 + 1) * engine.c.d - this.b[1] << 8;
                  } else if (var1 == 1) {
                     this.d = var5 * engine.c.d - 1 - this.b[3] << 8;
                  }

                  var2 = true;
                  break;
               }
            }
         }

         if (var2) {
            if (var1 < 0) {
               this.N = var6;
            } else if (var1 > 0) {
               this.O = var6;
            }
         }

         return var1 == -1 ? var6 == 3 : var6 >= 3 && var6 <= 4;
      } else {
         return false;
      }
   }

   private int e(boolean var1) {
      int var2 = this.c >> 8;
      int var3 = ((this.d >> 8) + this.b[1] + 1) / engine.c.d;
      int var4 = ((this.d >> 8) + this.b[3] + 1) / engine.c.d;
      var2 /= engine.c.c;
      boolean var5 = false;
      if (engine.c.a(var2, var3) == 7) {
         if (var1) {
            this.c = var2 * engine.c.c + engine.c.c / 2 << 8;
         }

         return -1;
      } else if (engine.c.a(var2, var4) == 7) {
         if (var1) {
            this.c = var2 * engine.c.c + engine.c.c / 2 << 8;
         }

         return 1;
      } else {
         return 0;
      }
   }

   private boolean a(int var1) {
      int var2 = this.c >> 8;
      int var3 = ((this.d >> 8) + this.b[1] + 1) / engine.c.d;
      int var5 = ((this.d >> 8) + this.b[3]) / engine.c.d;
      var2 /= engine.c.c;
      boolean var4 = false;
      if (var1 == -1) {
         if (engine.c.a(var2, var3) != 7) {
            return true;
         }
      } else if (var1 == 1 && engine.c.a(var2, var5) != 7) {
         return true;
      }

      return false;
   }

   public final boolean a(boolean var1) {
      if (!var1 && this.e == 0 && this.f == 0) {
         return false;
      } else {
         int var1b = Math.max(Math.abs(this.e / engine.c.c) >> 8, Math.abs(this.f / engine.c.d) >> 8) + 1;
         int var2 = this.e / var1b;
         int var3 = this.f / var1b;
         this.P = -1;
         this.Q = -1;
         this.N = -1;
         this.O = -1;
         if (this.h >= 5 && this.h != 22) {
            if (this.l && (!this.l(var2 > 0) && var3 == 0 || this.c(var2 > 0) || a(this.c >> 8, var2 > 0))) {
               var2 = 0;
            }

            if (this.o > 0 && this.p > 0) {
               if (this.c < this.o && var2 < 0) {
                  var2 = 0;
               }

               if (this.c > this.p && var2 > 0) {
                  var2 = 0;
               }
            }
         }

         for (int var4 = 0; var4 < var1b; var4++) {
            this.c += var2;
            if (this.e != 0) {
               boolean var5;
               if (this.e > 0) {
                  var5 = this.b(1, false);
               } else {
                  var5 = this.b(-1, false);
               }

               if (var5) {
                  var2 = 0;
               }
            }

            this.d += var3;
            if (this.f != 0) {
               boolean var8;
               if (this.f > 0) {
                  var8 = this.c(1, false);
               } else {
                  var8 = this.c(-1, false);
               }

               if (var8) {
                  var3 = 0;
               }
            }
         }

         if (this.h == 67 && this.z) {
            d var7;
            (var7 = main.a.c[main.f.c]).c += var2;
            var7.d += var3;
         }

         if (var3 == 0) {
            if (this.f > 0) {
               this.u = 0;
            }

            this.f = 0;
         }

         if (this.P == -1 && this.e <= 0) {
            this.b(-1, true);
         }

         if (this.Q == -1 && this.e >= 0) {
            this.b(1, true);
         }

         if (this.N == -1 && this.f <= 0) {
            this.c(-1, true);
         }

         if (this.O == -1 && this.f >= 0) {
            this.c(1, true);
         }

         return true;
      }
   }

   private boolean f(boolean var1) {
      if (main.e.M >= 0 && !main.f.L && !main.f.D) {
         int var2;
         return b(var2 = var1 ? main.f.i : main.f.j) ? false : (var2 & 16416) != 0;
      } else {
         return false;
      }
   }

   private boolean g(boolean var1) {
      if (main.e.M >= 0 && !main.f.L && !main.f.D) {
         int var2;
         return b(var2 = var1 ? main.f.i : main.f.j) ? false : (var2 & 2304) != 0;
      } else {
         return false;
      }
   }

   private boolean h(boolean var1) {
      if (main.e.M >= 0 && !main.f.L && !main.f.D) {
         int var2;
         return b(var2 = var1 ? main.f.i : main.f.j) ? false : (var2 & 1028) != 0;
      } else {
         return false;
      }
   }

   private boolean i(boolean var1) {
      if (main.e.M >= 0 && !main.f.L && !main.f.D) {
         int var2;
         return b(var2 = var1 ? main.f.i : main.f.j) ? false : (var2 & 4112) != 0;
      } else {
         return false;
      }
   }

   private boolean j(boolean var1) {
      if (main.e.M >= 0 && !main.f.L && !main.f.D) {
         int var2 = main.f.j;
         return b(main.f.j) ? false : (var2 & 8256) != 0;
      } else {
         return false;
      }
   }

   private boolean k(boolean var1) {
      if (main.e.M >= 0 && !main.f.L && !main.f.D) {
         int var2;
         return b(var2 = var1 ? main.f.j : main.f.i) ? false : (var2 & 12368) != 0;
      } else {
         return false;
      }
   }

   private static boolean b(int var0) {
      return main.f.O > 0 && (main.f.O & var0) == 0;
   }

   public final void b(boolean var1) {
      if (this.a[0] != var1) {
         this.a[0] = var1;
         this.e = -this.e;
         this.t = -this.t;
         this.i = -this.i;
         this.g();
      }
   }

   final void c(int var1, int var2) {
      this.y = false;
      this.g = var1;
      if (this.g == -1) {
         this.q = -1;
         this.s = -1;
         this.g();
      } else {
         this.s = 0;
         this.r = 0;
         this.q = this.m.a(this.g, this.s);
         this.x = false;
         this.g();
         this.e = this.m.i[this.g << 2];
         if (this.a[0]) {
            this.e = -this.e;
         }

         this.f = this.m.i[(this.g << 2) + 1];
         if (this.a[1]) {
            this.f = -this.f;
         }

         this.t = this.m.i[(this.g << 2) + 2];
         if (this.a[0]) {
            this.t = -this.t;
         }

         this.u = this.m.i[(this.g << 2) + 3];
         if (this.a[1]) {
            this.u = -this.u;
         }
      }
   }

   private int[] g() {
      for (int var1 = 0; var1 < 4; var1++) {
         this.b[var1] = 0;
      }

      byte[] var2 = this.m.d;
      if (this.q != -1 && var2 != null) {
         this.q &= 255;
         this.b[1] = var2[(this.q << 3) + 1];
         this.b[3] = var2[(this.q << 3) + 3];
         if (this.a[0]) {
            this.b[0] = (byte)(-var2[(this.q << 3) + 2]);
            this.b[2] = (byte)(-var2[this.q << 3]);
         } else {
            this.b[0] = var2[this.q << 3];
            this.b[2] = var2[(this.q << 3) + 2];
         }
      }

      return this.b;
   }

   private boolean h() {
      return Math.abs(this.c - main.a.c[main.f.c].c) >> 8 < 360;
   }

   private boolean c(int var1) {
      return Math.abs(this.c - main.a.c[main.f.c].c) <= var1;
   }

   private boolean e(int var1, int var2) {
      return Math.abs(this.c - main.a.c[var2].c) <= 7680;
   }

   private boolean d(int var1) {
      return Math.abs(this.d - main.a.c[main.f.c].d) <= var1;
   }

   private boolean l(boolean var1) {
      int var2;
      var2 = (var2 = this.d >> 8) + this.b[3];
      var2++;
      var2 /= engine.c.d;
      int var3 = 0;
      if (!var1) {
         var3 = ((this.c >> 8) + this.b[0] - 1) / engine.c.c;
      } else {
         var3 = ((this.c >> 8) + this.b[2] + 1) / engine.c.c;
         if ((this.c >> 8) + this.b[2] + 1 >= engine.c.a * engine.c.c) {
            return false;
         }
      }

      return engine.c.a(var3, var2) >= 3 && engine.c.a(var3, var2) != 5 && engine.c.a(var3, var2) != 6;
   }

   private static boolean e(int var0) {
      main.f.D = true;
      if (main.f.d != var0) {
         main.f.d = var0;
      } else if (!main.f.e) {
         return true;
      }

      return false;
   }

   private static boolean i() {
      if (main.f.d != main.f.c) {
         main.f.d = main.f.c;
      } else if (!main.f.e) {
         main.f.D = false;
         return true;
      }

      return false;
   }

   private boolean f(int var1, int var2) {
      d var3 = main.a.c[main.f.c];
      return this.c(var1 << 8) && this.d(var2 << 8) && this.d(var3) && e(var3);
   }

   private boolean d(d var1) {
      return this.c - var1.c < 0 ? this.a[0] : !this.a[0];
   }

   private static boolean e(d var0) {
      if (main.f.c == 0) {
         if (var0.g == 0 || var0.g == 3 || var0.g >= 20 && var0.g <= 41) {
            return true;
         }
      } else {
         if (main.f.c < 4) {
            return true;
         }

         if (main.f.c == 4 && (var0.g == 0 || var0.g >= 5 && var0.g <= 12)) {
            return true;
         }
      }

      return false;
   }

   private void j() {
      d var1 = main.a.c[main.f.c];
      if (this.h == 35) {
         if (main.e.q(8) == 2 && main.e.F[2] == -1) {
            if (this.c(20480) && this.d(0)) {
               main.f.b(25, 0);
               main.e.F[2]++;
            }

            return;
         }
      } else if (this.h == 36 && main.e.q(29) == 2 && main.e.F[5] == -1) {
         if (this.c(20480) && this.d(0)) {
            var1.b(0, main.e.G[main.e.I]);
            this.b(true);
            main.f.b(46, 0);
            main.a.a(0, 460);
            main.e.F[5]++;
         }

         return;
      }

      if (main.e.m && b(this) && this.B > 0) {
         for (int var2 = 0; var2 < main.e.n.length; var2++) {
            if (main.e.n[var2] == 0) {
               main.e.n[var2] = this.c;
               break;
            }
         }
      }

      if (var1.a(this) && e(var1)) {
         var1.a(main.e.I(this.A), var1.c < this.c, false);
      }

      switch (this.g) {
         case 0:
            if (!main.f.D && this.h() && !this.w() && main.f.G && this.y) {
               if (this.f(50, 16)) {
                  this.v++;
                  if (this.v > 6) {
                     if (engine.a.a(500) <= this.A * 5 + 100) {
                        this.c(3, 1);
                     } else {
                        this.c(2, 1);
                     }

                     this.v = 0;
                     return;
                  }
               } else {
                  if (this.c(25600) && this.d(4096) && e(var1) && !this.d(var1)) {
                     this.b(!this.a[0]);
                     this.c(0, 1);
                     return;
                  }

                  this.I++;
                  if (this.I > 6) {
                     this.c(1, 1);
                     this.I = 0;
                     this.e();
                     return;
                  }
               }
            }
            break;
         case 1:
            if (main.f.D) {
               this.c(0, 1);
               return;
            }

            if (!this.h() || this.w()) {
               break;
            }

            if (!main.f.G) {
               this.c(0, 1);
               return;
            }

            if (this.f(50, 16)) {
               this.c(0, 1);
               return;
            }

            if (this.c(25600) && this.d(4096) && e(var1)) {
               if (!this.d(var1)) {
                  this.b(!this.a[0]);
                  this.c(0, 1);
                  return;
               }
               break;
            } else {
               if (!this.d(this.a[0]) && !this.f() && !this.d()) {
                  break;
               }

               this.b(!this.a[0]);
               this.c(0, 1);
               return;
            }
         case 2:
            if (!this.w()) {
               if (!main.f.G) {
                  this.c(0, 1);
                  return;
               }

               if (this.y) {
                  this.c(0, 1);
                  return;
               }
            }
            break;
         case 3:
            if (!this.w() && this.y) {
               this.c(0, 1);
               return;
            }
            break;
         case 4:
            if (!this.w() && this.y) {
               if (this.B <= 0) {
                  this.d(23, 0);
                  return;
               }

               this.c(0, 1);
               return;
            }
            break;
         case 5:
            if (this.y) {
               if (this.B <= 0) {
                  this.d(23, 0);
                  return;
               }

               this.c(6, 1);
               return;
            }
            break;
         case 6:
            if (this.y) {
               this.c(0, 1);
            }
      }
   }

   private void k() {
      d var1 = main.a.c[main.f.c];
      if (this.h == 47 && main.e.q(5) == 2 && main.e.F[0] == -1) {
         if (this.c(20480) && this.d(0)) {
            main.f.b(20, 0);
            main.e.F[0]++;
            main.e.F[1] = -1;
         }
      } else {
         if (main.e.m && b(this) && this.B > 0) {
            for (int var2 = 0; var2 < main.e.n.length; var2++) {
               if (main.e.n[var2] == 0) {
                  main.e.n[var2] = this.c;
                  break;
               }
            }
         }

         switch (this.g) {
            case 0:
               if (!main.f.D && this.h() && !this.w() && main.f.G && this.y) {
                  if (this.f(100, 16)) {
                     this.v++;
                     if (this.v > 6) {
                        if (engine.a.a(500) <= this.A * 5 + 100 && !main.a.c[this.J + 1].a[3]) {
                           this.c(3, 1);
                        } else {
                           this.c(2, 1);
                        }

                        this.v = 0;
                        return;
                     }
                  } else {
                     if (this.c(30720) && this.d(4096) && e(var1) && !this.d(var1)) {
                        this.b(!this.a[0]);
                        this.c(0, 1);
                        return;
                     }

                     this.I++;
                     if (this.I > 6) {
                        this.c(1, 1);
                        this.I = 0;
                        this.e();
                        return;
                     }
                  }
               }
               break;
            case 1:
               if (main.f.D) {
                  this.c(0, 1);
                  return;
               }

               if (!this.h() || this.w()) {
                  break;
               }

               if (!main.f.G) {
                  this.c(0, 1);
                  return;
               }

               if (this.f(100, 16)) {
                  this.c(0, 1);
                  return;
               }

               if (this.c(30720) && this.d(4096) && e(var1)) {
                  if (!this.d(var1)) {
                     this.b(!this.a[0]);
                     this.c(0, 1);
                     return;
                  }
                  break;
               } else {
                  if (!this.d(this.a[0]) && !this.f() && !this.d()) {
                     break;
                  }

                  this.b(!this.a[0]);
                  this.c(0, 1);
                  return;
               }
            case 2:
               if (!this.w()) {
                  if (!main.f.G) {
                     this.c(0, 1);
                     return;
                  }

                  if (this.y) {
                     this.c(0, 1);
                     return;
                  }
               }
               break;
            case 3:
               if (!this.w() && this.y) {
                  this.c(0, 1);
                  main.a.c[this.J + 1].a[3] = true;
                  main.a.c[this.J + 1].c = this.c;
                  main.a.c[this.J + 1].d = this.d;
                  main.a.c[this.J + 1].b(this.a[0]);
                  return;
               }
               break;
            case 4:
               if (!this.w() && this.y) {
                  if (this.B <= 0) {
                     this.d(23, 0);
                     return;
                  }

                  this.c(0, 1);
                  return;
               }
               break;
            case 5:
               if (this.y) {
                  if (this.B <= 0) {
                     this.d(23, 0);
                     return;
                  }

                  this.c(6, 1);
                  return;
               }
               break;
            case 6:
               if (this.y) {
                  this.c(0, 1);
                  return;
               }
               break;
            case 7:
               this.n.j = -1;
               this.l = false;
               if (var1.a(this) && e(var1)) {
                  var1.a(main.e.I(this.A), var1.c < this.c, false);
               }

               if (!b(this) || this.P == 3 || this.Q == 3) {
                  this.a[3] = false;
               }
         }
      }
   }

   private void l() {
      d var1 = main.a.c[main.f.c];
      if (this.g < 4 && this.h()) {
         if (!this.y() && this.I == 1) {
            main.f.a(-1, -1);
            this.I = -1;
         }

         if (main.f.V < 0) {
            for (int var2 = 44; var2 < 81; var2++) {
               if (main.e.q(var2) > 0 && main.e.r(var2) == this.h && this.g != main.e.q(var2) % 4 && this.g < main.e.q(var2) % 4) {
                  this.c(main.e.q(var2) % 4, 1);
               }
            }

            if (this.g != main.e.q(main.e.C) % 4 && main.e.r(main.e.C) == this.h) {
               if (this.g < main.e.q(main.e.C) % 4) {
                  this.c(main.e.q(main.e.C) % 4, 1);
               }

               return;
            }
         } else if (main.e.q(main.f.V) > 0 && main.e.r(main.f.V) == this.h && this.g != main.e.q(main.f.V) % 4) {
            this.c(main.e.q(main.f.V) % 4, 1);
         }
      }

      switch (this.g) {
         case 0:
            if (this.h() && this.y() && main.f.c == 0 && (var1.g == main.e.G[main.e.I] || var1.g == main.e.H[main.e.I])) {
               if (this.h == 11 || this.h == 13) {
                  main.f.a(5, -1);
                  this.I = 1;
               }

               if (this.f(true) && (var1.g == main.e.G[main.e.I] || var1.g == main.e.H[main.e.I])) {
                  if (this.h == 11) {
                     cMIDlet.b.a(false);
                     main.f.f(0);
                     return;
                  }

                  if (this.h == 13) {
                     cMIDlet.b.b(false);
                     main.f.f(0);
                     return;
                  }
               }
            }
            break;
         case 1:
            if (this.h() && this.y() && main.f.c == 0 && (var1.g == main.e.G[main.e.I] || var1.g == main.e.H[main.e.I])) {
               main.f.a(5, -1);
               this.I = 1;
               if (this.f(true) && (var1.g == main.e.G[main.e.I] || var1.g == main.e.H[main.e.I])) {
                  if (this.h == 11) {
                     cMIDlet.b.a(true);
                  } else if (this.h == 13) {
                     cMIDlet.b.b(true);
                  } else {
                     cMIDlet.b.c(this.h);
                  }

                  main.f.f(0);
               }

               if (main.f.U) {
                  main.e.s(main.f.V);
                  if (main.e.r(main.f.V) != this.h) {
                     this.c(0, 1);
                  }

                  main.f.b(main.f.V, 1);
                  main.f.U = false;
                  main.f.V = -1;
                  return;
               }
            }
            break;
         case 2:
            if (this.h() && this.y() && main.f.c == 0 && (var1.g == main.e.G[main.e.I] || var1.g == main.e.H[main.e.I])) {
               main.f.a(5, -1);
               this.I = 1;
               if (this.f(true) && (var1.g == main.e.G[main.e.I] || var1.g == main.e.H[main.e.I])) {
                  if (this.h == 11) {
                     cMIDlet.b.a(true);
                  } else if (this.h == 13) {
                     cMIDlet.b.b(true);
                  } else {
                     cMIDlet.b.c(this.h);
                  }

                  main.f.f(0);
               }

               if (main.f.U) {
                  if (main.e.q(main.f.V) == 1) {
                     main.e.s(main.f.V);
                     if (main.e.r(main.f.V) != this.h) {
                        this.c(0, 1);
                     }

                     main.f.b(main.f.V, 1);
                     main.f.U = false;
                     main.f.V = -1;
                     return;
                  }

                  if (main.e.q(main.f.V) == 3) {
                     if (main.e.d(main.f.V, this.h)) {
                        this.c(0, 1);
                        main.f.b(main.f.V, 2);
                     }

                     main.f.U = false;
                     main.f.V = -1;
                     return;
                  }
               }
            }
            break;
         case 3:
            if (this.h() && this.y() && main.f.c == 0 && (var1.g == main.e.G[main.e.I] || var1.g == main.e.H[main.e.I])) {
               main.f.a(5, -1);
               this.I = 1;
               if (this.f(true) && (var1.g == main.e.G[main.e.I] || var1.g == main.e.H[main.e.I])) {
                  if (this.h == 11) {
                     cMIDlet.b.a(true);
                  } else if (this.h == 13) {
                     cMIDlet.b.b(true);
                  } else {
                     cMIDlet.b.c(this.h);
                  }

                  main.f.f(0);
               }

               if (main.f.U) {
                  if (main.e.d(main.f.V, this.h)) {
                     this.c(0, 1);
                     main.f.b(main.f.V, 2);
                  }

                  main.f.U = false;
                  main.f.V = -1;
                  return;
               }
            }
            break;
         case 4:
            if (this.h == 10) {
               this.l = false;
               if (main.f.K == 0) {
                  e(this.J);
                  if (this.y()) {
                     i();
                     main.f.D = false;
                     main.f.b(19, 0);
                     return;
                  }
               } else if (main.f.K == 108) {
                  if (!this.y()) {
                     main.f.a(-1, -1);
                  }

                  if (!s(this)) {
                     this.a[3] = false;
                     var1.b(true);
                     main.f.b(43, 0);
                     return;
                  }
               } else if (main.f.K == 609 && this.c(10240)) {
                  var1.b(0, main.e.G[main.e.I]);
                  this.c(0, 1);
                  main.f.b(64, 0);
                  main.a.c[this.J - 1].a[3] = true;
                  main.a.c[this.J - 1].c = main.a.a + 120 << 8;
                  main.a.c[this.J - 1].d = main.a.b + 160 << 8;
                  return;
               }
            } else if (this.h == 13) {
               this.n.j = -1;
            }
      }
   }

   private void m() {
      d var1 = main.a.c[main.f.c];
      if (this.g != 8 && this.h()) {
         if (!this.y() && this.I == 1) {
            main.f.a(-1, -1);
            this.I = -1;
         }

         if (main.f.V < 0) {
            if (this.g % 2 == 0) {
               for (int var2 = 44; var2 < 81; var2++) {
                  if (main.e.q(var2) > 0 && main.e.r(var2) == this.h && this.g != main.e.q(var2) % 4 << 1 && this.g < main.e.q(var2) % 4 << 1) {
                     this.c(main.e.q(var2) % 4 << 1, 1);
                  }
               }
            }
         } else if (this.g % 2 == 0 && main.e.q(main.f.V) > 0 && main.e.r(main.f.V) == this.h && this.g != main.e.q(main.f.V) % 4 << 1) {
            this.c(main.e.q(main.f.V) % 4 << 1, 1);
         }
      }

      switch (this.g) {
         case 0:
            if (this.h() && !this.y()) {
               this.c(this.g + 1, 1);
               return;
            }
            break;
         case 1:
         case 3:
         case 5:
         case 7:
            if (this.h()) {
               if (this.y() && main.f.c == 0 && (var1.g == main.e.G[main.e.I] || var1.g == main.e.H[main.e.I])) {
                  if (this.g != 1) {
                     main.f.a(5, -1);
                  }

                  this.I = 1;
                  if (this.f(true)) {
                     if (!this.d(var1)) {
                        this.b(!this.a[0]);
                     }

                     this.c(this.g - 1, 1);
                     main.f.f(0);
                     return;
                  }
               }

               if (this.d()) {
                  this.b(!this.a[0]);
                  this.c(this.g - 1, 1);
               }
            }
            break;
         case 2:
            if (this.h()) {
               if (!this.y()) {
                  this.c(this.g + 1, 1);
                  return;
               }

               if (main.f.c == 0 && (var1.g == main.e.G[main.e.I] || var1.g == main.e.H[main.e.I])) {
                  main.f.a(5, -1);
                  this.I = 1;
                  if (this.f(true)) {
                     cMIDlet.b.c(this.h);
                     main.f.f(0);
                  }

                  if (main.f.U) {
                     main.e.s(main.f.V);
                     if (main.e.r(main.f.V) != this.h) {
                        this.c(0, 1);
                     }

                     main.f.b(main.f.V, 1);
                     main.f.U = false;
                     main.f.V = -1;
                     return;
                  }
               }
            }
            break;
         case 4:
            if (this.h()) {
               if (!this.y()) {
                  this.c(this.g + 1, 1);
                  return;
               }

               if (main.f.c == 0 && (var1.g == main.e.G[main.e.I] || var1.g == main.e.H[main.e.I])) {
                  main.f.a(5, -1);
                  this.I = 1;
                  if (this.f(true) && (var1.g == main.e.G[main.e.I] || var1.g == main.e.H[main.e.I])) {
                     cMIDlet.b.c(this.h);
                     main.f.f(0);
                  }

                  if (main.f.U) {
                     if (main.e.q(main.f.V) == 1) {
                        main.e.s(main.f.V);
                        if (main.e.r(main.f.V) != this.h) {
                           this.c(0, 1);
                        }

                        main.f.b(main.f.V, 1);
                        main.f.U = false;
                        main.f.V = -1;
                        return;
                     }

                     if (main.e.q(main.f.V) == 3) {
                        if (main.e.d(main.f.V, this.h)) {
                           this.c(0, 1);
                           main.f.b(main.f.V, 2);
                        }

                        main.f.U = false;
                        main.f.V = -1;
                        return;
                     }
                  }
               }
            }
            break;
         case 6:
            if (this.h()) {
               if (!this.y()) {
                  this.c(this.g + 1, 1);
                  return;
               }

               if (main.f.c == 0 && (var1.g == main.e.G[main.e.I] || var1.g == main.e.H[main.e.I])) {
                  main.f.a(5, -1);
                  this.I = 1;
                  if (this.f(true) && (var1.g == main.e.G[main.e.I] || var1.g == main.e.H[main.e.I])) {
                     cMIDlet.b.c(this.h);
                     main.f.f(0);
                  }

                  if (main.f.U) {
                     if (main.e.d(main.f.V, this.h)) {
                        this.c(0, 1);
                        main.f.b(main.f.V, 2);
                     }

                     main.f.U = false;
                     main.f.V = -1;
                     return;
                  }
               }
            }
      }
   }

   private void n() {
      if (main.e.q(10) == 2 && main.e.F[3] == -1) {
         if (this.c(20480) && this.d(0)) {
            main.f.b(27, 0);
            main.e.F[3]++;
            main.a.a(228, 488);
         }
      } else {
         if (main.e.F[3] == 0) {
            this.c(7, 1);
            main.e.F[3]++;
         }

         if (main.e.m && b(this) && this.B > 0) {
            for (int var1 = 0; var1 < main.e.n.length; var1++) {
               if (main.e.n[var1] == 0) {
                  main.e.n[var1] = this.c;
                  break;
               }
            }
         }

         d var3;
         if ((var3 = main.a.c[main.f.c]).a(this)) {
            if (e(var3)) {
               var3.a(main.e.I(this.A), var3.c < this.c, false);
            }
         } else if (this.y() && this.g < 10 && this.B > 0 && e(var3)) {
            var3.a(main.e.I(this.A) / 2, var3.c < this.c, false);
         }

         switch (this.g) {
            case 0:
               if (!main.f.D && this.h() && !this.w() && main.f.G && this.y) {
                  if (this.w++ > 150) {
                     this.w = 0;
                     this.v = 0;
                     this.I = 0;
                     this.c(7, 1);
                     return;
                  }

                  if (this.f(56, 0)) {
                     this.v++;
                     if (this.v > 6) {
                        if (engine.a.a(500) <= this.A * 5 + 100) {
                           this.c(3, 1);
                        } else {
                           this.c(2, 1);
                        }

                        this.v = 0;
                        return;
                     }
                  } else {
                     if (this.c(25600) && this.d(0) && e(var3) && !this.d(var3)) {
                        this.b(!this.a[0]);
                        this.c(0, 1);
                        return;
                     }

                     this.I++;
                     if (this.I > 6) {
                        this.c(1, 1);
                        this.I = 0;
                        this.e();
                        return;
                     }
                  }
               }
               break;
            case 1:
               if (main.f.D) {
                  this.c(0, 1);
                  return;
               }

               if (!this.h() || this.w()) {
                  break;
               }

               if (!main.f.G) {
                  this.c(0, 1);
                  return;
               }

               if (this.w++ > 150) {
                  this.w = 0;
                  this.v = 0;
                  this.I = 0;
                  this.c(7, 1);
                  return;
               }

               if (this.f(56, 0)) {
                  this.c(0, 1);
                  return;
               }

               if (this.c(25600) && this.d(0) && e(var3)) {
                  if (!this.d(var3)) {
                     this.b(!this.a[0]);
                     this.c(0, 1);
                     return;
                  }
                  break;
               } else {
                  if (!this.d(this.a[0]) && !this.f() && !this.d()) {
                     break;
                  }

                  this.b(!this.a[0]);
                  this.c(0, 1);
                  return;
               }
            case 2:
               if (!this.w()) {
                  if (!main.f.G) {
                     this.c(0, 1);
                     return;
                  }

                  if (this.y) {
                     this.c(0, 1);
                     return;
                  }
               }
               break;
            case 3:
               if (this.y) {
                  this.c(0, 1);
                  return;
               }
               break;
            case 4:
               if (!this.w() && this.y) {
                  if (this.B <= 0) {
                     this.c(10, 1);
                     return;
                  }

                  this.c(0, 1);
                  return;
               }
               break;
            case 5:
               if (this.y) {
                  if (this.B <= 0) {
                     this.c(10, 1);
                     return;
                  }

                  if (engine.a.a(100) <= 60) {
                     this.c(7, 1);
                     return;
                  }

                  this.c(6, 1);
                  return;
               }
               break;
            case 6:
            case 9:
               if (this.y) {
                  this.c(0, 1);
                  return;
               }
               break;
            case 7:
               if (this.y) {
                  this.c(8, 1);
                  return;
               }
               break;
            case 8:
               if (this.y) {
                  this.c(9, 1);
                  return;
               }
               break;
            case 10:
               main.f.f(3);
               if (main.e.F[3] == 1) {
                  var3.b(0, main.e.G[main.e.I]);
                  main.f.b(28, 0);
                  main.e.F[3]++;
                  main.a.d();
                  return;
               }

               this.c(11, 1);
               return;
            case 11:
               this.l = false;
               main.f.f(3);
               if (!c(this)) {
                  this.a[3] = false;
                  main.e.t(this.h);
                  main.e.K(this.A);
                  main.a.c[this.J + 1].a[3] = true;
                  main.a.c[this.J + 1].b(var3.a[0]);
                  if (var3.a[0]) {
                     main.a.c[this.J + 1].c = main.a.a + 40 << 8;
                     return;
                  }

                  main.a.c[this.J + 1].c = main.a.a + engine.View.right() - 40 << 8;
               }
         }
      }
   }

   private void o() {
      d var1 = main.a.c[main.f.c];
      if (main.e.q(43) == 2 && main.e.F[4] == -1) {
         if (this.c(20480) && this.d(0)) {
            var1.b(0, main.e.G[main.e.I]);
            main.f.b(31, 0);
            main.e.F[4]++;
            main.a.a(120, 560);
         } else {
            main.f.D = true;
            if (var1.a[3] && var1.g != main.e.H[main.e.I]) {
               var1.b(0, main.e.H[main.e.I]);
            }
         }
      } else {
         if (main.e.F[4] == 0) {
            this.c(3, 1);
            var1.b(true);
            var1.b(0, main.e.G[main.e.I]);
            main.e.F[4]++;
            main.f.f(3);
         } else if (main.e.F[4] == 2 && this.g != 7) {
            main.f.f(3);
            if (var1.g == main.e.G[main.e.I]) {
               main.f.b(32, 0);
               main.e.F[4]++;
               main.f.D = false;
            }

            return;
         }

         if (main.e.m && b(this) && this.B > 0) {
            for (int var2 = 0; var2 < main.e.n.length; var2++) {
               if (main.e.n[var2] == 0) {
                  main.e.n[var2] = this.c;
                  break;
               }
            }
         }

         if (this.g != 7 && this.g != 12 && this.g != 15 && this.y() && this.B > 0 && e(var1)) {
            var1.a(main.e.I(this.A) / 2, var1.c < this.c, false);
         }

         this.l = false;
         switch (this.g) {
            case 0:
               if (!main.f.D && this.h() && !this.w() && main.f.G && this.y && this.w++ > 50) {
                  this.w = 0;
                  this.v = 0;
                  this.I = 0;
                  this.c(1, 1);
                  return;
               }
               break;
            case 1:
               if (main.f.D) {
                  this.c(0, 1);
                  return;
               }

               if (this.h() && !this.w()) {
                  if (!main.f.G) {
                     this.c(0, 1);
                     return;
                  }

                  if (this.d >> 8 <= main.a.b + 80) {
                     this.c(10, 1);
                     return;
                  }
               }
               break;
            case 2:
               this.w();
               if (this.O >= 3 && this.O <= 6) {
                  this.c(3, 1);
                  return;
               }
               break;
            case 3:
               if (this.y) {
                  this.c(0, 1);
                  main.a.c[this.J + 1].a[3] = true;
                  main.a.c[this.J + 1].c = this.c;
                  main.a.c[this.J + 1].d = this.d;
                  main.a.c[this.J + 1].b(this.a[0]);
                  if (main.e.F[4] == 1) {
                     var1.b(false);
                     var1.b(0, 4);
                     main.e.F[4]++;
                     return;
                  }
               }
               break;
            case 4:
               if (this.y) {
                  if (this.B <= 0) {
                     this.c(13, 1);
                     main.f.f(3);
                     return;
                  }

                  this.c(0, 1);
                  return;
               }
               break;
            case 5:
               if (this.y) {
                  if (this.B <= 0) {
                     this.c(13, 1);
                     main.f.f(3);
                     return;
                  }

                  this.c(6, 1);
                  return;
               }
               break;
            case 6:
               if (this.y) {
                  if (engine.a.a(100) <= 60 && !main.a.c[this.J + 1].a[3]) {
                     this.c(3, 1);
                     return;
                  }

                  this.c(0, 1);
                  return;
               }
               break;
            case 7:
            case 12:
               this.n.j = -1;
               if (var1.a(this) && e(var1)) {
                  var1.a(main.e.I(this.A), var1.c < this.c, false);
               }

               if (!b(this) || this.P == 3 || this.Q == 3) {
                  this.a[3] = false;
                  return;
               }
               break;
            case 8:
            case 9:
               if (this.y) {
                  if (this.B <= 0) {
                     this.c(13, 1);
                     main.f.f(3);
                     return;
                  }

                  this.c(this.E[0], 1);
                  return;
               }
               break;
            case 10:
               this.w();
               if (this.a[0]) {
                  if (this.I < 4 && this.c - this.v >= 17408) {
                     this.v = this.c;
                     main.a.c[this.J + 2 + this.I].a[3] = true;
                     main.a.c[this.J + 2 + this.I].c = this.c;
                     main.a.c[this.J + 2 + this.I].d = this.d;
                     this.I++;
                  }

                  if (this.c >= this.p) {
                     this.c = this.p;
                     this.b(!this.a[0]);
                     this.c(2, 1);
                     return;
                  }
               } else if (this.p - this.c >= 69632) {
                  this.b(!this.a[0]);
                  this.c(10, 1);
                  this.v = this.c;
                  main.a.c[this.J + 2 + this.I].a[3] = true;
                  main.a.c[this.J + 2 + this.I].c = this.c;
                  main.a.c[this.J + 2 + this.I].d = this.d;
                  this.I++;
                  return;
               }
               break;
            case 11:
               this.w();
               if (this.y) {
                  this.c(10, 1);
                  return;
               }
               break;
            case 13:
               main.f.f(3);
               if (this.O >= 3 && this.O <= 6) {
                  this.c(14, 1);
                  return;
               }
               break;
            case 14:
               if (main.e.F[4] == 3) {
                  main.f.b(33, 0);
                  main.e.F[4]++;
                  return;
               }

               if (main.e.F[4] == 4) {
                  this.b(false);
                  this.c(15, 1);
                  main.e.F[4]++;
                  return;
               }
               break;
            case 15:
               main.f.f(3);
               if (!c(this)) {
                  this.a[3] = false;
                  main.e.t(this.h);
                  main.e.K(this.A);
                  main.a.c[this.J + 6].a[3] = true;
                  main.a.c[this.J + 6].b(var1.a[0]);
                  main.a.c[this.J + 6].d = var1.d;
                  if (var1.a[0]) {
                     main.a.c[this.J + 6].c = main.a.a + 40 << 8;
                  } else {
                     main.a.c[this.J + 6].c = main.a.a + engine.View.right() - 40 << 8;
                  }

                  main.a.d();
               }
         }
      }
   }

   private void p() {
      if (main.e.m && b(this) && this.B > 0) {
         for (int var1 = 0; var1 < main.e.n.length; var1++) {
            if (main.e.n[var1] == 0) {
               main.e.n[var1] = this.c;
               break;
            }
         }
      }

      d var3;
      if ((var3 = main.a.c[main.f.c]).a(this)) {
         if (e(var3)) {
            var3.a(main.e.I(this.A), var3.c < this.c, false);
         }
      } else if (this.g < 8 && this.y() && this.B > 0 && e(var3)) {
         var3.a(main.e.I(this.A) / 2, var3.c < this.c, false);
      }

      switch (this.g) {
         case 0:
            if (!main.f.D && this.h() && !this.w() && main.f.G && this.y) {
               if (this.w++ > 100) {
                  this.w = 0;
                  this.v = 0;
                  this.I = 0;
                  this.c(7, 1);
                  return;
               }

               if (this.f(60, 0)) {
                  this.v++;
                  if (this.v > 6) {
                     if (engine.a.a(500) <= this.A * 5 + 100) {
                        this.c(3, 1);
                     } else {
                        this.c(2, 1);
                     }

                     this.v = 0;
                     return;
                  }
               } else {
                  if (this.c(30720) && this.d(0) && e(var3) && !this.d(var3)) {
                     this.b(!this.a[0]);
                     this.c(0, 1);
                     return;
                  }

                  this.I++;
                  if (this.I > 6) {
                     this.c(1, 1);
                     this.I = 0;
                     this.e();
                     return;
                  }
               }
            }
            break;
         case 1:
            if (main.f.D) {
               this.c(0, 1);
               return;
            }

            if (!this.h() || this.w()) {
               break;
            }

            if (!main.f.G) {
               this.c(0, 1);
               return;
            }

            if (this.w++ > 100) {
               this.w = 0;
               this.v = 0;
               this.I = 0;
               this.c(7, 1);
               return;
            }

            if (this.f(60, 0)) {
               this.c(0, 1);
               return;
            }

            if (this.c(30720) && this.d(0) && e(var3)) {
               if (!this.d(var3)) {
                  this.b(!this.a[0]);
                  this.c(0, 1);
                  return;
               }
               break;
            } else {
               if (!this.d(this.a[0]) && !this.f() && !this.d()) {
                  break;
               }

               this.b(!this.a[0]);
               this.c(0, 1);
               return;
            }
         case 2:
            if (!this.w()) {
               if (!main.f.G) {
                  this.c(0, 1);
                  return;
               }

               if (this.y) {
                  this.c(0, 1);
                  return;
               }
            }
            break;
         case 3:
            if (this.y) {
               this.c(0, 1);
               return;
            }
            break;
         case 4:
            if (!this.w() && this.y) {
               if (this.B <= 0) {
                  this.c(11, 1);
                  return;
               }

               if (engine.a.a(100) <= 5) {
                  this.c(7, 1);
                  return;
               }

               this.c(0, 1);
               return;
            }
            break;
         case 5:
            if (this.y) {
               if (this.B <= 0) {
                  this.c(11, 1);
                  return;
               }

               if (engine.a.a(100) <= 10) {
                  this.c(7, 1);
                  return;
               }

               this.c(6, 1);
               return;
            }
            break;
         case 6:
         case 7:
            if (this.y) {
               this.c(0, 1);
               return;
            }
            break;
         case 8:
            if (this.c(20480) && this.d(0)) {
               this.c(10, 1);
               main.f.b(36, 0);
               main.a.a(100, 560);
               return;
            }
            break;
         case 9:
            main.f.f(3);
            if (this.y) {
               this.c(12, 1);
               main.f.b(38, 0);
               return;
            }
            break;
         case 10:
            if (this.y) {
               this.c(1, 1);
               main.f.b(37, 0);
               return;
            }
            break;
         case 11:
            main.f.f(3);
            if (this.y) {
               this.b(false);
               this.c(9, 1);
               return;
            }
            break;
         case 12:
            this.l = false;
            main.f.f(3);
            if (!c(this)) {
               this.a[3] = false;
               main.e.t(this.h);
               main.e.K(this.A);
               main.a.d();
               main.f.b(39, 0);
               main.a.c[this.J + 1].a[3] = true;
               main.a.c[this.J + 1].d = main.a.b + 160 << 8;
               main.a.c[this.J + 1].c = main.a.a + 120 << 8;
            }
      }
   }

   private void q() {
      if (main.e.m && b(this) && this.B > 0) {
         for (int var1 = 0; var1 < main.e.n.length; var1++) {
            if (main.e.n[var1] == 0) {
               main.e.n[var1] = this.c;
               break;
            }
         }
      }

      d var3 = main.a.c[main.f.c];
      if ((this.g == 0 || this.g == 5) && this.y() && this.B > 0 && e(var3)) {
         var3.a(main.e.I(this.A) / 2, var3.c < this.c, false);
      }

      this.l = false;
      this.n.j = this.h;
      switch (this.g) {
         case 0:
            if (!main.f.D && this.h()) {
               this.w();
               if (main.f.G && this.y && this.J == 29) {
                  if (this.w++ > 100) {
                     this.w = 0;
                     this.v = 0;
                     this.I = 0;
                     this.c(1, 1);
                     if (main.a.c[27].g != 7 && main.a.c[27].g != 4) {
                        main.a.c[27].c(1, 1);
                     }

                     if (main.a.c[25].g != 7 && main.a.c[27].g != 4) {
                        main.a.c[25].c(1, 1);
                        return;
                     }
                  } else if (!main.a.c[28].a[3] && !main.a.c[26].a[3] && !main.a.c[30].a[3] && this.v++ > 30) {
                     this.c(5, 1);
                     this.v = 0;
                     if (main.a.c[27].g != 7 && main.a.c[27].g != 4) {
                        main.a.c[27].c(5, 1);
                     }

                     if (main.a.c[25].g != 7 && main.a.c[27].g != 4) {
                        main.a.c[25].c(5, 1);
                        return;
                     }
                  }
               }
            }
            break;
         case 1:
            if (this.y) {
               if (this.J == 29) {
                  if (main.a.c[27].g == 7) {
                     main.a.c[27].c(2, 1);
                  }

                  if (main.a.c[25].g == 7) {
                     main.a.c[25].c(2, 1);
                  }
               }

               this.c(2, 1);
               return;
            }
            break;
         case 2:
            if (this.y) {
               if (this.J == 29) {
                  switch (engine.a.a(3)) {
                     case 0:
                        this.c = 47616;
                        this.d = 61184;
                        main.a.c[27].c = 68096;
                        main.a.c[27].d = 40704;
                        main.a.c[25].c = 88064;
                        main.a.c[25].d = 61184;
                        break;
                     case 1:
                        this.c = 68096;
                        this.d = 40704;
                        main.a.c[27].c = 88064;
                        main.a.c[27].d = 61184;
                        main.a.c[25].c = 47616;
                        main.a.c[25].d = 61184;
                        break;
                     case 2:
                        this.c = 88064;
                        this.d = 61184;
                        main.a.c[27].c = 47616;
                        main.a.c[27].d = 61184;
                        main.a.c[25].c = 68096;
                        main.a.c[25].d = 40704;
                  }
               }

               this.c(0, 1);
               return;
            }
            break;
         case 3:
            this.w++;
            if (this.y) {
               if (this.B <= 0) {
                  main.a.c[25].a[3] = false;
                  main.a.c[27].a[3] = false;
                  this.c(12, 1);
                  main.f.b(44, 0);
                  return;
               }

               this.c(0, 1);
               return;
            }
            break;
         case 4:
            if (this.y) {
               this.c(7, 1);
               return;
            }
            break;
         case 5:
            if (this.y) {
               this.c(0, 1);
               main.a.c[this.J + 1].a[3] = true;
               main.a.c[this.J + 1].c = this.c;
               main.a.c[this.J + 1].d = this.d;
               main.a.c[this.J + 1].b(this.a[0]);
               if (this.c - var3.c > 0) {
                  main.a.c[this.J + 1].T = -1;
               } else if (this.c - var3.c == 0) {
                  main.a.c[this.J + 1].T = 0;
               } else {
                  main.a.c[this.J + 1].T = 1;
               }

               if (this.d - var3.d < 0) {
                  main.a.c[this.J + 1].S = 1;
               } else if (this.d - var3.d == 0) {
                  main.a.c[this.J + 1].S = 0;
               } else {
                  main.a.c[this.J + 1].S = -1;
               }

               if (Math.abs(this.d - var3.d >> 8) / 4 == 0) {
                  main.a.c[this.J + 1].R = 4;
               } else {
                  main.a.c[this.J + 1].R = Math.abs(this.c - var3.c >> 8) / (Math.abs(this.d - var3.d >> 8) / 4);
               }

               if (main.a.c[this.J + 1].S == 0 && main.a.c[this.J + 1].R == 0) {
                  main.a.c[this.J + 1].R = 4;
                  return;
               }
            }
            break;
         case 6:
            this.n.j = -1;
            if (var3.a(this) && e(var3)) {
               var3.a(main.e.I(this.A), var3.c < this.c, false);
            }

            this.c = this.c + (this.R * this.T << 8);
            this.d = this.d + (4 * this.S << 8);
            if (!c(this)) {
               this.a[3] = false;
               return;
            }
            break;
         case 7:
            this.n.j = -1;
            return;
         case 8:
            main.f.f(3);
            return;
         case 9:
            if (this.y) {
               main.a.c[29].a[3] = true;
               main.a.c[27].a[3] = true;
               main.a.c[25].a[3] = true;
               this.a[3] = false;
               main.a.a(80, 480);
               return;
            }
            break;
         case 10:
            this.n.j = -1;
            if (main.e.q(24) == 2) {
               this.c(11, 1);
               return;
            }
            break;
         case 11:
            main.f.f(3);
            if (this.y) {
               this.c(8, 1);
               var3.b(true);
               main.a.c[this.J + 7].b(true);
               main.f.b(42, 0);
               return;
            }
            break;
         case 12:
            main.f.f(3);
            if (this.y) {
               main.e.t(this.h);
               main.e.K(this.A);
               main.a.d();
               this.a[3] = false;
            }
      }
   }

   private void r() {
      d var1 = main.a.c[main.f.c];
      if (main.e.F[6] == -1) {
         if (this.c(20480) && this.d(0)) {
            var1.b(0, main.e.G[main.e.I]);
            this.b(true);
            main.f.b(49, 0);
            main.a.a(0, 350);
            main.e.F[6]++;
         }
      } else {
         if (main.e.m && b(this) && this.B > 0) {
            for (int var2 = 0; var2 < main.e.n.length; var2++) {
               if (main.e.n[var2] == 0) {
                  main.e.n[var2] = this.c;
                  break;
               }
            }
         }

         if (this.g != 7 && this.g != 9 && this.y() && this.B > 0 && e(var1)) {
            var1.a(main.e.I(this.A) / 2, var1.c < this.c, false);
         }

         switch (this.g) {
            case 0:
               if (!main.f.D && this.h() && !this.w() && main.f.G && this.y) {
                  if (this.f(100, 0)) {
                     this.v++;
                     if (this.v > 15) {
                        if (engine.a.a(500) <= this.A * 5 + 100) {
                           if (engine.a.a(100) < 50 && !main.a.c[this.J + 1].a[3]) {
                              this.c(3, 1);
                           } else if (!main.a.c[this.J + 6].a[3]) {
                              this.c(8, 1);
                           }
                        } else {
                           this.c(2, 1);
                        }

                        this.v = 0;
                        return;
                     }
                  } else {
                     if (this.c(30720) && this.d(0) && e(var1) && !this.d(var1)) {
                        this.b(!this.a[0]);
                        this.c(0, 1);
                        return;
                     }

                     this.I++;
                     if (this.I > 6) {
                        this.c(1, 1);
                        this.I = 0;
                        this.e();
                        return;
                     }
                  }
               }
               break;
            case 1:
               if (main.f.D) {
                  this.c(0, 1);
                  return;
               }

               if (!this.h() || this.w()) {
                  break;
               }

               if (!main.f.G) {
                  this.c(0, 1);
                  return;
               }

               this.v++;
               if (this.v > 15) {
                  if (engine.a.a(500) <= this.A * 5 + 100) {
                     if (engine.a.a(100) < 50 && !main.a.c[this.J + 1].a[3]) {
                        this.c(3, 1);
                     } else if (!main.a.c[this.J + 6].a[3]) {
                        this.c(8, 1);
                     }
                  }

                  this.v = 0;
                  return;
               }

               if (this.f(100, 0)) {
                  this.c(0, 1);
                  return;
               }

               if (this.c(30720) && this.d(0) && e(var1)) {
                  if (!this.d(var1)) {
                     this.b(!this.a[0]);
                     this.c(0, 1);
                     return;
                  }
                  break;
               } else {
                  if (!this.d(this.a[0]) && !this.f() && !this.d()) {
                     break;
                  }

                  this.b(!this.a[0]);
                  this.c(0, 1);
                  return;
               }
            case 2:
               if (!this.w()) {
                  if (!main.f.G) {
                     this.c(0, 1);
                     return;
                  }

                  if (this.y) {
                     this.c(0, 1);
                     return;
                  }
               }
               break;
            case 3:
               if (this.y) {
                  this.c(0, 1);
                  main.a.c[this.J + 1].a[3] = true;
                  main.a.c[this.J + 1].c = this.c;
                  main.a.c[this.J + 1].d = this.d;
                  main.a.c[this.J + 1].b(this.a[0]);
                  return;
               }
               break;
            case 4:
               if (this.y) {
                  if (this.B <= 0) {
                     main.a.a(6);
                     this.v = 0;
                     this.c(10, 1);
                     return;
                  }

                  this.c(0, 1);
                  return;
               }
               break;
            case 5:
               if (this.y) {
                  if (this.B <= 0) {
                     main.a.a(6);
                     this.v = 0;
                     this.c(10, 1);
                     return;
                  }

                  this.c(6, 1);
                  return;
               }
               break;
            case 6:
               if (this.y) {
                  this.c(3, 1);
                  return;
               }
               break;
            case 7:
               this.n.j = -1;
               this.l = false;
               if (var1.a(this) && e(var1)) {
                  var1.a(main.e.I(this.A), var1.c < this.c, false);
               }

               if ((this.c >> 8) + this.b[0] > main.a.a + engine.View.right() || (this.c >> 8) + this.b[2] < main.a.a - engine.View.extra() || this.P == 3 || this.Q == 3) {
                  this.a[3] = false;
                  return;
               }
               break;
            case 8:
               this.v++;
               if (this.v == 1) {
                  main.a.c[this.J + 2].a[3] = true;
                  main.a.c[this.J + 2].c = main.a.a + engine.a.a(10) * 24 << 8;
                  main.a.c[this.J + 2].d = main.a.b + 320 << 8;
                  main.a.c[this.J + 2].b(this.a[0]);
               } else if (this.v == 7) {
                  main.a.c[this.J + 3].a[3] = true;
                  main.a.c[this.J + 3].c = main.a.a + engine.a.a(10) * 24 << 8;
                  main.a.c[this.J + 3].d = main.a.b + 320 << 8;
                  main.a.c[this.J + 3].b(this.a[0]);
               } else if (this.v == 13) {
                  main.a.c[this.J + 4].a[3] = true;
                  main.a.c[this.J + 4].c = main.a.a + engine.a.a(10) * 24 << 8;
                  main.a.c[this.J + 4].d = main.a.b + 320 << 8;
                  main.a.c[this.J + 4].b(this.a[0]);
               } else if (this.v == 19) {
                  main.a.c[this.J + 5].a[3] = true;
                  main.a.c[this.J + 5].c = main.a.a + engine.a.a(10) * 24 << 8;
                  main.a.c[this.J + 5].d = main.a.b + 320 << 8;
                  main.a.c[this.J + 5].b(this.a[0]);
               } else if (this.v == 25) {
                  main.a.c[this.J + 6].a[3] = true;
                  main.a.c[this.J + 6].c = main.a.a + engine.a.a(10) * 24 << 8;
                  main.a.c[this.J + 6].d = main.a.b + 320 << 8;
                  main.a.c[this.J + 6].b(this.a[0]);
               }

               if (this.y) {
                  System.out.println(this.v);
                  this.c(0, 1);
                  this.v = 0;
                  return;
               }
               break;
            case 9:
               this.n.j = -1;
               this.l = false;
               if (var1.a(this) && e(var1)) {
                  var1.a(main.e.I(this.A), var1.c < this.c, false);
               }

               if ((var1.d >> 8) + var1.b[3] < main.a.b - 160) {
                  this.a[3] = false;
                  return;
               }
               break;
            case 10:
               this.v++;
               if (this.v == 13) {
                  if (main.e.F[6] == 0) {
                     main.f.b(50, 0);
                     main.e.F[6]++;
                  }

                  main.a.d();
                  return;
               }

               if (this.v > 13) {
                  this.v = 0;
                  this.d(23, 0);
                  main.a.d();
               }
         }
      }
   }

   private void s() {
      d var1 = main.a.c[main.f.c];
      if (main.e.F[7] == -1) {
         main.f.f(3);
         main.f.D = true;
         var1.b(0, main.e.H[main.e.I]);
         main.e.F[7]++;
      } else if (main.e.F[7] == 0) {
         if (this.c(20480) && this.d(0)) {
            var1.b(0, main.e.G[main.e.I]);
            if (main.e.q(38) == 2) {
               main.f.b(51, 0);
            }

            main.a.a(0, 480);
            main.f.D = false;
            main.e.F[7]++;
         }
      } else {
         if (main.e.m && b(this) && this.B > 0) {
            for (int var2 = 0; var2 < main.e.n.length; var2++) {
               if (main.e.n[var2] == 0) {
                  main.e.n[var2] = this.c;
                  break;
               }
            }
         }

         if (this.g != 7 && this.g != 9 && this.y() && this.B > 0 && e(var1)) {
            var1.a(main.e.I(this.A) / 2, var1.c < this.c, false);
         }

         switch (this.g) {
            case 0:
               if (!main.f.D && this.h() && !this.w() && main.f.G && this.y) {
                  if (this.f(100, 0)) {
                     this.v++;
                     if (this.v > 15) {
                        if (engine.a.a(500) <= this.A * 5 + 100) {
                           if (engine.a.a(100) < 50 && !main.a.c[this.J + 1].a[3]) {
                              this.c(3, 1);
                           } else if (!main.a.c[this.J + 7].a[3]) {
                              this.c(8, 1);
                           }
                        } else {
                           this.c(2, 1);
                        }

                        this.v = 0;
                        return;
                     }
                  } else {
                     if (this.c(30720) && this.d(0) && e(var1) && !this.d(var1)) {
                        this.b(!this.a[0]);
                        this.c(0, 1);
                        return;
                     }

                     this.I++;
                     if (this.I > 6) {
                        this.c(1, 1);
                        this.I = 0;
                        this.e();
                        return;
                     }
                  }
               }
               break;
            case 1:
               if (main.f.D) {
                  this.c(0, 1);
                  return;
               }

               if (!this.h() || this.w()) {
                  break;
               }

               if (!main.f.G) {
                  this.c(0, 1);
                  return;
               }

               this.v++;
               if (this.v > 15) {
                  if (engine.a.a(500) <= this.A * 5 + 100) {
                     if (engine.a.a(100) < 50 && !main.a.c[this.J + 1].a[3]) {
                        this.c(3, 1);
                     } else if (!main.a.c[this.J + 7].a[3]) {
                        this.c(8, 1);
                     }
                  }

                  this.v = 0;
                  return;
               }

               if (this.f(100, 0)) {
                  this.c(0, 1);
                  return;
               }

               if (this.c(30720) && this.d(0) && e(var1)) {
                  if (!this.d(var1)) {
                     this.b(!this.a[0]);
                     this.c(0, 1);
                     return;
                  }
                  break;
               } else {
                  if (!this.d(this.a[0]) && !this.f() && !this.d()) {
                     break;
                  }

                  this.b(!this.a[0]);
                  this.c(0, 1);
                  return;
               }
            case 2:
               if (!this.w()) {
                  if (!main.f.G) {
                     this.c(0, 1);
                     return;
                  }

                  if (this.y) {
                     this.c(0, 1);
                     return;
                  }
               }
               break;
            case 3:
               if (this.y) {
                  if (this.v < 1) {
                     this.c(3, 1);
                  } else {
                     this.c(0, 1);
                  }

                  if (this.v < 2) {
                     main.a.c[this.J + 1 + this.v].a[3] = true;
                     main.a.c[this.J + 1 + this.v].c = this.c;
                     main.a.c[this.J + 1 + this.v].d = this.d;
                     main.a.c[this.J + 1 + this.v].b(this.a[0]);
                  }

                  this.v++;
                  return;
               }
               break;
            case 4:
               if (this.y) {
                  if (this.B <= 0) {
                     main.a.a(6);
                     this.v = 0;
                     this.c(10, 1);
                     return;
                  }

                  this.c(0, 1);
                  return;
               }
               break;
            case 5:
               if (this.y) {
                  if (this.B <= 0) {
                     main.a.a(6);
                     this.v = 0;
                     this.c(10, 1);
                     return;
                  }

                  this.c(0, 1);
                  return;
               }
               break;
            case 6:
               if (this.y) {
                  if (!main.a.c[this.J + 7].a[3]) {
                     this.c(8, 1);
                  } else {
                     this.c(3, 1);
                  }

                  this.v = 0;
                  return;
               }
               break;
            case 7:
               this.n.j = -1;
               this.l = false;
               if (var1.a(this) && e(var1)) {
                  var1.a(main.e.I(this.A), var1.c < this.c, false);
               }

               if ((this.c >> 8) + this.b[0] > main.a.a + engine.View.right() || (this.c >> 8) + this.b[2] < main.a.a - engine.View.extra() || this.P == 3 || this.Q == 3) {
                  this.a[3] = false;
                  return;
               }
               break;
            case 8:
               this.v++;
               if (this.v == 25) {
                  main.a.c[this.J + 7].a[3] = true;
                  main.a.c[this.J + 7].c = main.a.a + engine.a.a(10) * 24 << 8;
                  main.a.c[this.J + 7].d = main.a.b << 8;
                  main.a.c[this.J + 7].b(this.a[0]);
               } else if (this.v == 1) {
                  main.a.c[this.J + 3].a[3] = true;
                  main.a.c[this.J + 3].c = main.a.a + engine.a.a(10) * 24 << 8;
                  main.a.c[this.J + 3].d = main.a.b << 8;
                  main.a.c[this.J + 3].b(this.a[0]);
               } else if (this.v == 7) {
                  main.a.c[this.J + 4].a[3] = true;
                  main.a.c[this.J + 4].c = main.a.a + engine.a.a(10) * 24 << 8;
                  main.a.c[this.J + 4].d = main.a.b << 8;
                  main.a.c[this.J + 4].b(this.a[0]);
               } else if (this.v == 13) {
                  main.a.c[this.J + 5].a[3] = true;
                  main.a.c[this.J + 5].c = main.a.a + engine.a.a(10) * 24 << 8;
                  main.a.c[this.J + 5].d = main.a.b << 8;
                  main.a.c[this.J + 5].b(this.a[0]);
               } else if (this.v == 19) {
                  main.a.c[this.J + 6].a[3] = true;
                  main.a.c[this.J + 6].c = main.a.a + engine.a.a(10) * 24 << 8;
                  main.a.c[this.J + 6].d = main.a.b << 8;
                  main.a.c[this.J + 6].b(this.a[0]);
               }

               if (this.y) {
                  this.c(0, 1);
                  this.v = 0;
                  return;
               }
               break;
            case 9:
               this.n.j = -1;
               this.l = false;
               if (var1.a(this) && e(var1)) {
                  var1.a(main.e.I(this.A), var1.c < this.c, false);
               }

               if ((this.d >> 8) + this.b[1] > main.a.b + 320) {
                  this.a[3] = false;
                  return;
               }
               break;
            case 10:
               this.v++;
               if (this.v == 13) {
                  if (main.e.q(38) == 2 && main.e.F[7] == 1) {
                     main.f.b(52, 0);
                     main.e.F[7]++;
                  }

                  main.a.d();
                  return;
               }

               if (this.v > 13) {
                  this.v = 0;
                  this.d(23, 0);
                  main.a.d();
               }
         }
      }
   }

   private void t() {
      d var1 = main.a.c[main.f.c];
      if (main.e.F[8] == -1) {
         main.f.f(3);
         main.f.D = true;
         var1.b(0, main.e.H[main.e.I]);
         main.e.F[8]++;
      } else if (main.e.F[8] == 0) {
         if (this.c(20480) && this.d(0)) {
            var1.b(0, main.e.G[main.e.I]);
            if (main.e.q(38) == 2) {
               main.f.b(53, 0);
            }

            main.a.a(0, 480);
            main.f.D = false;
            main.e.F[8]++;
         }
      } else {
         if (main.e.m && b(this) && this.B > 0) {
            for (int var2 = 0; var2 < main.e.n.length; var2++) {
               if (main.e.n[var2] == 0) {
                  main.e.n[var2] = this.c;
                  break;
               }
            }
         }

         if (this.g != 7 && this.g != 9 && this.y() && this.B > 0 && e(var1)) {
            var1.a(main.e.I(this.A) / 2, var1.c < this.c, false);
         }

         switch (this.g) {
            case 0:
               if (!main.f.D && this.h() && !this.w() && main.f.G && this.y) {
                  if (this.f(100, 0)) {
                     this.v++;
                     if (this.v > 15) {
                        if (engine.a.a(500) <= this.A * 5 + 100) {
                           if (engine.a.a(100) < 50 && !main.a.c[this.J + 1].a[3]) {
                              this.c(3, 1);
                           } else if (!main.a.c[this.J + 8].a[3]) {
                              this.c(8, 1);
                           }
                        } else {
                           this.c(2, 1);
                        }

                        this.v = 0;
                        return;
                     }
                  } else {
                     if (this.c(30720) && this.d(0) && e(var1) && !this.d(var1)) {
                        this.b(!this.a[0]);
                        this.c(0, 1);
                        return;
                     }

                     this.I++;
                     if (this.I > 6) {
                        this.c(1, 1);
                        this.I = 0;
                        this.e();
                        return;
                     }
                  }
               }
               break;
            case 1:
               if (main.f.D) {
                  this.c(0, 1);
                  return;
               }

               if (!this.h() || this.w()) {
                  break;
               }

               if (!main.f.G) {
                  this.c(0, 1);
                  return;
               }

               if (this.f(100, 0)) {
                  this.c(0, 1);
                  return;
               }

               if (this.c(30720) && this.d(0) && e(var1)) {
                  if (!this.d(var1)) {
                     this.b(!this.a[0]);
                     this.c(0, 1);
                     return;
                  }
                  break;
               } else {
                  if (!this.d(this.a[0]) && !this.f() && !this.d()) {
                     break;
                  }

                  this.b(!this.a[0]);
                  this.c(0, 1);
                  return;
               }
            case 2:
               if (!this.w()) {
                  if (!main.f.G) {
                     this.c(0, 1);
                     return;
                  }

                  if (this.y) {
                     this.c(0, 1);
                     return;
                  }
               }
               break;
            case 3:
               if (this.y) {
                  if (this.v < 1) {
                     this.c(3, 1);
                  } else {
                     this.c(0, 1);
                  }

                  if (this.v < 2) {
                     main.a.c[this.J + 1 + this.v].a[3] = true;
                     main.a.c[this.J + 1 + this.v].c = this.c;
                     main.a.c[this.J + 1 + this.v].d = this.d;
                     main.a.c[this.J + 1 + this.v].b(this.a[0]);
                  }

                  this.v++;
                  return;
               }
               break;
            case 4:
               if (this.y) {
                  if (this.B <= 0) {
                     this.v = 0;
                     this.c(10, 1);
                     return;
                  }

                  this.c(0, 1);
                  return;
               }
               break;
            case 5:
               if (this.y) {
                  if (this.B <= 0) {
                     this.v = 0;
                     this.c(10, 1);
                     return;
                  }

                  this.c(0, 1);
                  return;
               }
               break;
            case 6:
               if (this.y) {
                  if (!main.a.c[this.J + 8].a[3]) {
                     this.c(8, 1);
                  } else {
                     this.c(3, 1);
                  }

                  this.v = 0;
                  return;
               }
               break;
            case 7:
               this.n.j = -1;
               this.l = false;
               if (var1.a(this) && e(var1)) {
                  var1.a(main.e.I(this.A), var1.c < this.c, false);
               }

               if ((this.c >> 8) + this.b[0] > main.a.a + engine.View.right() || (this.c >> 8) + this.b[2] < main.a.a - engine.View.extra() || this.P == 3 || this.Q == 3) {
                  this.a[3] = false;
                  return;
               }
               break;
            case 8:
               this.v++;
               if (this.v == 31) {
                  main.a.c[this.J + 8].a[3] = true;
                  main.a.c[this.J + 8].c = main.a.a + engine.a.a(10) * 24 << 8;
                  main.a.c[this.J + 8].d = this.d - (engine.a.a(4) * 20 << 8);
                  main.a.c[this.J + 8].b(this.a[0]);
               } else if (this.v == 25) {
                  main.a.c[this.J + 7].a[3] = true;
                  main.a.c[this.J + 7].c = main.a.a + engine.a.a(10) * 24 << 8;
                  main.a.c[this.J + 7].d = this.d - (engine.a.a(4) * 20 << 8);
                  main.a.c[this.J + 7].b(this.a[0]);
               } else if (this.v == 1) {
                  main.a.c[this.J + 3].a[3] = true;
                  main.a.c[this.J + 3].c = main.a.a + engine.a.a(10) * 24 << 8;
                  main.a.c[this.J + 3].d = this.d - (engine.a.a(4) * 20 << 8);
                  main.a.c[this.J + 3].b(this.a[0]);
               } else if (this.v == 7) {
                  main.a.c[this.J + 4].a[3] = true;
                  main.a.c[this.J + 4].c = main.a.a + engine.a.a(10) * 24 << 8;
                  main.a.c[this.J + 4].d = this.d - (engine.a.a(4) * 20 << 8);
                  main.a.c[this.J + 4].b(this.a[0]);
               } else if (this.v == 13) {
                  main.a.c[this.J + 5].a[3] = true;
                  main.a.c[this.J + 5].c = main.a.a + engine.a.a(10) * 24 << 8;
                  main.a.c[this.J + 5].d = this.d - (engine.a.a(4) * 20 << 8);
                  main.a.c[this.J + 5].b(this.a[0]);
               } else if (this.v == 19) {
                  main.a.c[this.J + 6].a[3] = true;
                  main.a.c[this.J + 6].c = main.a.a + engine.a.a(10) * 24 << 8;
                  main.a.c[this.J + 6].d = this.d - (engine.a.a(4) * 20 << 8);
                  main.a.c[this.J + 6].b(this.a[0]);
               }

               if (this.y) {
                  this.c(0, 1);
                  this.v = 0;
                  return;
               }
               break;
            case 9:
               this.n.j = -1;
               if (var1.a(this) && e(var1)) {
                  var1.a(main.e.I(this.A), var1.c < this.c, false);
               }

               if (this.y) {
                  this.c(9, 1);
                  this.a[3] = false;
                  return;
               }
               break;
            case 10:
               this.v++;
               if (this.v == 13) {
                  if (main.e.q(38) == 2 && main.e.F[8] == 1) {
                     main.f.b(54, 0);
                     main.e.F[8]++;
                  }

                  main.a.d();
                  return;
               }

               if (this.v > 13) {
                  main.a.d();
                  this.v = 0;
                  this.d(23, 0);
               }
         }
      }
   }

   private void u() {
      d var1 = main.a.c[main.f.c];
      if (main.e.F[9] == -1) {
         main.f.f(5);
         main.f.D = true;
         var1.b(0, main.e.H[main.e.I]);
         main.e.F[9]++;
      } else if (main.e.F[9] == 0) {
         main.f.f(5);
         if (this.c(25600)) {
            var1.b(0, main.e.G[main.e.I]);
            this.l = false;
            this.c(1, 1);
            main.f.b(56, 0);
            main.a.a(80, 490);
            main.f.D = false;
            main.e.F[9]++;
         }
      } else if (main.e.F[9] == 1) {
         main.f.f(5);
         if (this.c(17920)) {
            main.f.b(57, 0);
            main.e.F[9]++;
         }
      } else {
         if (main.e.m && b(this) && this.B > 0) {
            for (int var2 = 0; var2 < main.e.n.length; var2++) {
               if (main.e.n[var2] == 0) {
                  main.e.n[var2] = this.c;
                  break;
               }
            }
         }

         if (this.g < 6 && this.y() && this.B > 0 && e(var1)) {
            var1.a(main.e.I(this.A) / 2, var1.c < this.c, false);
         }

         switch (this.g) {
            case 0:
               if (!main.f.D && !main.a.c[this.J + 1].a[3] && !main.a.c[this.J + 2].a[3] && !main.a.c[this.J + 3].a[3] && this.h()) {
                  this.w();
                  if (main.f.G && this.y) {
                     if (this.w++ > 100) {
                        this.w = 0;
                        this.v = 0;
                        this.I = 0;
                        int var4;
                        if ((var4 = engine.a.a(100)) < 30) {
                           this.c(3, 1);
                           return;
                        }

                        if (var4 < 60) {
                           this.c(4, 1);
                           return;
                        }

                        this.c(5, 1);
                        return;
                     }

                     this.I++;
                     if (this.I > 6) {
                        this.c(1, 1);
                        this.I = 0;
                        this.e();
                        return;
                     }
                  }
               }
               break;
            case 1:
               this.l = false;
               if (main.f.D) {
                  this.c(0, 1);
                  return;
               }

               if (this.h()) {
                  this.w();
                  if (!main.f.G) {
                     this.c(0, 1);
                     return;
                  }

                  if (this.w++ > 100) {
                     this.w = 0;
                     this.v = 0;
                     this.I = 0;
                     int var3;
                     if ((var3 = engine.a.a(100)) < 30) {
                        this.c(3, 1);
                        return;
                     }

                     if (var3 < 60) {
                        this.c(4, 1);
                        return;
                     }

                     this.c(5, 1);
                     return;
                  }
               }

               if (this.c(this.a[0]) || a(this.c >> 8, this.a[0]) || this.f() || this.d()) {
                  this.b(!this.a[0]);
                  this.c(0, 1);
                  return;
               }
            case 2:
            default:
               break;
            case 3:
               if (this.y) {
                  this.c(0, 1);
                  main.a.c[this.J + 3].a[3] = true;
                  main.a.c[this.J + 3].c = var1.c;
                  main.a.c[this.J + 3].c(11, 1);
                  return;
               }
               break;
            case 4:
               if (this.y) {
                  this.c(0, 1);
                  main.a.c[this.J + 1].a[3] = true;
                  main.a.c[this.J + 1].c = main.a.a - 60 << 8;
                  main.a.c[this.J + 1].b(true);
                  main.a.c[this.J + 1].c(13, 1);
                  return;
               }
               break;
            case 5:
               if (this.y) {
                  this.c(0, 1);
                  main.a.c[this.J + 2].a[3] = true;
                  main.a.c[this.J + 2].c = var1.c;
                  main.a.c[this.J + 2].c(14, 1);
                  return;
               }
               break;
            case 6:
               this.w++;
               if (this.y) {
                  if (this.B <= 0) {
                     this.c(7, 1);
                     if (!this.d(var1)) {
                        this.b(!this.a[0]);
                     }

                     main.a.a(0, 490);
                     return;
                  }

                  this.c(0, 1);
                  return;
               }
               break;
            case 7:
               main.f.f(5);
               if (this.d >= 69632 && this.O >= 3 && this.O <= 6) {
                  this.c(8, 1);
                  this.v = 0;
                  return;
               }
               break;
            case 8:
               main.f.f(5);
               if (this.v == 0) {
                  main.f.f(3);
                  main.f.D = true;
                  if (this.c - var1.c > 0) {
                     var1.b(false);
                  } else {
                     var1.b(true);
                  }

                  var1.b(0, main.e.H[main.e.I]);
                  this.v = 1;
               }

               if (main.f.c == 0 && var1.g == 15) {
                  var1.d = var1.d - (this.j << 8);
                  var1.c = var1.c + ((this.a[0] ? 12 : -12) << 8);
                  var1.c(17, 1);
                  main.f.a(-1, -1);
               }

               if (this.y && this.d(0)) {
                  if (this.c - var1.c > 0) {
                     var1.b(false);
                  } else {
                     var1.b(true);
                  }

                  if (!main.e.i(32)) {
                     main.f.b(58, 0);
                     this.c(10, 1);
                  } else {
                     main.f.b(60, 0);
                     this.c(9, 1);
                  }

                  main.f.D = false;
                  return;
               }
               break;
            case 9:
               main.f.f(5);
               if (this.y) {
                  this.c(18, 1);
                  main.f.b(61, 0);
                  this.v = 0;
                  return;
               }
               break;
            case 10:
               main.f.f(3);
               if (this.y) {
                  main.e.t(this.h);
                  main.e.K(this.A);
                  this.a[3] = false;
                  main.f.b(59, 0);
                  return;
               }
               break;
            case 11:
               this.n.j = -1;
               if (this.y) {
                  this.c(12, 1);
                  main.a.a(3);
                  return;
               }
               break;
            case 12:
               this.n.j = -1;
               if (var1.a(this) && e(var1)) {
                  var1.a(main.e.I(this.A), var1.c < this.c, false);
               }

               if (this.y) {
                  this.v++;
                  if (this.v > 5) {
                     this.v = 0;
                     this.a[3] = false;
                     return;
                  }

                  this.c(11, 1);
                  this.c = var1.c;
                  return;
               }
               break;
            case 13:
               this.n.j = -1;
               this.l = false;
               if (var1.a(this) && e(var1)) {
                  var1.a(main.e.I(this.A), var1.c < this.c, false);
               }

               if ((this.c >> 8) + this.b[0] > main.a.a + engine.View.right()) {
                  this.a[3] = false;
                  return;
               }
               break;
            case 14:
               this.n.j = -1;
               if (this.y) {
                  this.c(15, 1);
                  return;
               }
               break;
            case 15:
               this.n.j = -1;
               if (var1.a(this) && e(var1)) {
                  var1.a[3] = false;
                  this.c(16, 1);
                  return;
               }

               if (this.y) {
                  this.c(17, 1);
                  return;
               }
               break;
            case 16:
               this.n.j = -1;
               if (this.v++ > 50) {
                  this.v = 0;
                  var1.a[3] = true;
                  var1.a(main.e.I(this.A), var1.c < this.c, false);
                  this.c(17, 1);
                  return;
               }
               break;
            case 17:
               this.n.j = -1;
               if (this.y) {
                  this.a[3] = false;
               }
               break;
            case 18:
               this.n.j = -1;
               if (this.v == 0) {
                  main.f.f(3);
                  main.f.D = true;
                  var1.b(0, main.e.H[main.e.I]);
                  this.v = 1;
                  return;
               }

               if (this.v == 1 && this.c(5120)) {
                  var1.b(0, main.e.G[main.e.I]);
                  main.f.b(62, 0);
                  main.f.D = false;
                  this.v = 2;
                  return;
               }
         }
      }
   }

   private void v() {
      d var1 = main.a.c[main.f.c];
      if (main.e.F[10] == -1) {
         main.f.f(5);
         main.f.D = true;
         var1.b(0, main.e.H[main.e.I]);
         main.e.F[10]++;
      } else if (main.e.F[10] == 0) {
         main.f.f(5);
         if (this.c(20480)) {
            var1.b(0, main.e.G[main.e.I]);
            main.f.b(63, 0);
            main.a.a(0, 620);
            main.f.D = false;
            main.e.F[10]++;
         }
      } else {
         if (main.e.m && b(this) && this.B > 0) {
            for (int var2 = 0; var2 < main.e.n.length; var2++) {
               if (main.e.n[var2] == 0) {
                  main.e.n[var2] = this.c;
                  break;
               }
            }
         }

         if (var1.a(this)) {
            if (e(var1)) {
               var1.a(main.e.I(this.A), var1.c < this.c, false);
            }
         } else if (this.y() && this.B > 0 && e(var1)) {
            var1.a(main.e.I(this.A) / 2, var1.c < this.c, false);
         }

         switch (this.g) {
            case 0:
               if (!main.f.D && this.h() && !this.w() && main.f.G && this.y) {
                  if (this.w++ > 60) {
                     this.w = 0;
                     this.v = 0;
                     this.I = 0;
                     if (engine.a.a(2) == 1) {
                        this.c(7, 1);
                        return;
                     }

                     this.c(9, 1);
                     return;
                  }

                  if (this.f(64, 0)) {
                     this.v++;
                     if (this.v > 6) {
                        if (engine.a.a(500) <= this.A * 5 + 100) {
                           this.c(3, 1);
                        } else {
                           this.c(2, 1);
                        }

                        this.v = 0;
                        return;
                     }
                  } else {
                     if (this.c(128 << 8) && this.d(0) && e(var1) && !this.d(var1)) {
                        this.b(!this.a[0]);
                        this.c(0, 1);
                        return;
                     }

                     this.I++;
                     if (this.I > 6) {
                        this.c(1, 1);
                        this.I = 0;
                        this.e();
                        return;
                     }
                  }
               }
               break;
            case 1:
               if (main.f.D) {
                  this.c(0, 1);
                  return;
               }

               if (!this.h() || this.w()) {
                  break;
               }

               if (!main.f.G) {
                  this.c(0, 1);
                  return;
               }

               if (this.w++ > 60) {
                  this.w = 0;
                  this.v = 0;
                  this.I = 0;
                  if (engine.a.a(2) == 1) {
                     this.c(7, 1);
                     return;
                  }

                  this.c(9, 1);
                  return;
               }

               if (this.f(64, 0)) {
                  this.c(0, 1);
                  return;
               }

               if (this.c(128 << 8) && this.d(0) && e(var1)) {
                  if (!this.d(var1)) {
                     this.b(!this.a[0]);
                     this.c(0, 1);
                     return;
                  }
                  break;
               } else {
                  if (!this.d(this.a[0]) && !this.f() && !this.d()) {
                     break;
                  }

                  this.b(!this.a[0]);
                  this.c(0, 1);
                  return;
               }
            case 2:
               if (!this.w()) {
                  if (!main.f.G) {
                     this.c(0, 1);
                     return;
                  }

                  if (this.y) {
                     this.c(0, 1);
                     return;
                  }
               }
               break;
            case 3:
               if (this.y) {
                  this.c(0, 1);
                  return;
               }
               break;
            case 4:
               if (!this.w() && this.y) {
                  if (this.B <= 0) {
                     main.e.t(this.h);
                     main.e.K(this.A);
                     if (!main.e.i(32)) {
                        this.c(12, 1);
                     } else {
                        this.c(11, 1);
                     }

                     if (main.e.i == 0) {
                        main.e.a(2);
                     }

                     this.v = 0;
                     return;
                  }

                  this.c(0, 1);
                  return;
               }
               break;
            case 5:
               if (this.y) {
                  if (this.B <= 0) {
                     main.e.t(this.h);
                     main.e.K(this.A);
                     if (!main.e.i(32)) {
                        this.c(12, 1);
                     } else {
                        this.c(11, 1);
                     }

                     if (main.e.i == 0) {
                        main.e.a(2);
                     }

                     this.v = 0;
                     return;
                  }

                  this.c(0, 1);
                  return;
               }
               break;
            case 6:
               if (this.y) {
                  this.c(0, 1);
                  return;
               }
               break;
            case 7:
               this.v++;
               if (this.v == 71) {
                  main.a.c[this.J + 1].a[3] = true;
                  main.a.c[this.J + 1].c = main.a.a + (engine.a.a(7) << 5) << 8;
                  main.a.c[this.J + 1].d = main.a.b << 8;
                  main.a.c[this.J + 1].b(this.a[0]);
               } else if (this.v == 61) {
                  main.a.c[this.J + 2].a[3] = true;
                  main.a.c[this.J + 2].c = main.a.a + (engine.a.a(7) << 5) << 8;
                  main.a.c[this.J + 2].d = main.a.b << 8;
                  main.a.c[this.J + 2].b(this.a[0]);
               }

               if (this.v == 51) {
                  main.a.c[this.J + 8].a[3] = true;
                  main.a.c[this.J + 8].c = main.a.a + (engine.a.a(7) << 5) << 8;
                  main.a.c[this.J + 8].d = main.a.b << 8;
                  main.a.c[this.J + 8].b(this.a[0]);
               } else if (this.v == 41) {
                  main.a.c[this.J + 7].a[3] = true;
                  main.a.c[this.J + 7].c = main.a.a + (engine.a.a(7) << 5) << 8;
                  main.a.c[this.J + 7].d = main.a.b << 8;
                  main.a.c[this.J + 7].b(this.a[0]);
               } else if (this.v == 1) {
                  main.a.c[this.J + 3].a[3] = true;
                  main.a.c[this.J + 3].c = main.a.a + (engine.a.a(7) << 5) << 8;
                  main.a.c[this.J + 3].d = main.a.b << 8;
                  main.a.c[this.J + 3].b(this.a[0]);
               } else if (this.v == 11) {
                  main.a.c[this.J + 4].a[3] = true;
                  main.a.c[this.J + 4].c = main.a.a + (engine.a.a(7) << 5) << 8;
                  main.a.c[this.J + 4].d = main.a.b << 8;
                  main.a.c[this.J + 4].b(this.a[0]);
               } else if (this.v == 21) {
                  main.a.c[this.J + 5].a[3] = true;
                  main.a.c[this.J + 5].c = main.a.a + (engine.a.a(7) << 5) << 8;
                  main.a.c[this.J + 5].d = main.a.b << 8;
                  main.a.c[this.J + 5].b(this.a[0]);
               } else if (this.v == 31) {
                  main.a.c[this.J + 6].a[3] = true;
                  main.a.c[this.J + 6].c = main.a.a + (engine.a.a(7) << 5) << 8;
                  main.a.c[this.J + 6].d = main.a.b << 8;
                  main.a.c[this.J + 6].b(this.a[0]);
               }

               if (this.v > 50) {
                  this.c(0, 1);
                  this.v = 0;
                  return;
               }
               break;
            case 8:
               this.n.j = -1;
               this.l = false;
               if (var1.a(this) && e(var1)) {
                  var1.a(main.e.I(this.A), var1.c < this.c, false);
               }

               if ((this.d >> 8) + this.b[1] > main.a.b + 320) {
                  this.a[3] = false;
                  return;
               }
               break;
            case 9:
               if (this.v == 0) {
                  if (!this.a[0]) {
                     main.a.c[this.J + 9].c = main.a.a + engine.View.right() - this.b[0] << 8;
                  } else {
                     main.a.c[this.J + 9].c = main.a.a - this.b[2] << 8;
                  }

                  main.a.c[this.J + 9].d = this.d - ((engine.a.a(4) + 1) * 20 << 8);
                  main.a.c[this.J + 9].b(this.a[0]);
                  main.a.c[this.J + 9].a[3] = true;
               }

               this.v++;
               if (!main.a.c[this.J + 9].a[3]) {
                  this.v = 0;
                  this.c(0, 1);
                  return;
               }
               break;
            case 10:
               this.n.j = -1;
               this.l = false;
               if (var1.a(this) && e(var1)) {
                  var1.a(main.e.I(this.A), var1.c < this.c, false);
               }

               if ((this.c >> 8) + this.b[0] > main.a.a + engine.View.right() || (this.c >> 8) + this.b[2] < main.a.a - engine.View.extra()) {
                  this.v++;
                  if (this.v > 5) {
                     this.v = 0;
                     this.a[3] = false;
                     return;
                  }

                  this.c(10, 1);
                  this.d = main.a.c[this.J - 9].d - ((engine.a.a(4) + 1) * 20 << 8);
                  if (!main.a.c[this.J - 9].a[0]) {
                     this.c = main.a.a + engine.View.right() - this.b[0] << 8;
                     return;
                  }

                  this.c = main.a.a - this.b[2] << 8;
               }
               break;
            case 11:
               if (this.v == 0) {
                  main.a.c[this.J - 1].a[3] = true;
                  main.a.c[this.J - 1].c = main.a.a + engine.View.right() << 8;
                  main.a.c[this.J - 1].b(false);
                  this.v = 1;
                  return;
               }
               break;
            case 12:
               if (this.y) {
                  var1.b(0, main.e.G[main.e.I]);
                  this.c(13, 1);
                  main.f.b(67, 0);
                  main.a.a(-1, -1);
                  return;
               }
               break;
            case 13:
               main.f.f(5);
               if (this.v == 12) {
                  main.a.c[this.J - 2].a[3] = true;
                  main.a.c[this.J - 2].c = main.a.a + 120 << 8;
                  main.a.c[this.J - 2].d = main.a.b + 160 << 8;
               } else if (this.v == 40) {
                  main.f.D = true;
                  var1.b(false);
                  var1.b(0, main.e.H[main.e.I]);
               } else if (this.v == 46) {
                  var1.l = false;
                  main.f.b(69, 0);
               }

               if (!s(var1)) {
                  main.a.c[this.J - 2].c(2, 1);
                  main.f.b(70, 0);
               }

               this.v++;
               return;
         }
      }
   }

   private boolean w() {
      d var1;
      if ((var1 = main.a.a(this)) == null) {
         return false;
      } else {
         main.f.F = true;
         if (this.F != 0) {
            return false;
         } else {
            boolean var2;
            var2 = false;
            label61:
            switch (var1.h) {
               case 0:
               case 1:
               case 2:
               case 3:
                  this.F = 3;
                  this.f(main.e.l() - main.e.J(this.A));
                  this.n.a((this.c >> 8) + (var1.a[0] ? 20 : -20), (this.d >> 8) + this.b[1] / 2, !var1.a[0]);
                  switch (var1.g) {
                     case 2:
                     case 5:
                     case 8:
                     case 11:
                        var2 = true;
                     case 3:
                     case 4:
                     case 6:
                     case 7:
                     case 9:
                     case 10:
                     default:
                        break label61;
                  }
               case 4:
                  this.n.a((this.c >> 8) + (var1.a[0] ? 20 : -20), (this.d >> 8) + this.b[1] / 2, !var1.a[0]);
                  switch (var1.g) {
                     case 1:
                        this.F = 8;
                        this.f(main.e.l() - main.e.J(this.A));
                        break;
                     case 3:
                        this.f(main.e.l() / 2 - main.e.J(this.A));
                        var1.c(4, 1);
                        break;
                     case 13:
                        var2 = true;
                  }
            }

            switch (this.h) {
               case 7:
               case 24:
               case 25:
               case 26:
               case 27:
               case 28:
               case 29:
               case 30:
               case 31:
               case 32:
               case 33:
               case 34:
               case 35:
               case 36:
               case 37:
               case 38:
               case 39:
               case 40:
               case 41:
               case 42:
               case 43:
               case 44:
               case 45:
               case 46:
               case 47:
               case 48:
               case 49:
               case 50:
               case 51:
               case 52:
               case 53:
               case 54:
               case 55:
               case 56:
               case 57:
               case 58:
               case 60:
               case 62:
               case 63:
               case 64:
               case 66:
                  if (var2) {
                     this.c(5, 1);
                  } else {
                     this.c(4, 1);
                  }
               case 8:
               case 9:
               case 10:
               case 11:
               case 12:
               case 13:
               case 14:
               case 15:
               case 16:
               case 17:
               case 18:
               case 19:
               case 20:
               case 21:
               case 22:
               case 23:
               default:
                  break;
               case 59:
                  if (this.g == 0) {
                     if (var2) {
                        this.c(5, 1);
                     } else {
                        this.c(4, 1);
                     }
                  } else if (this.g < 3) {
                     this.E[0] = this.g;
                     this.c(8, 1);
                  } else if (this.g == 10 || this.g == 11) {
                     this.E[0] = this.g;
                     this.c(9, 1);
                  }
                  break;
               case 61:
                  if (this.J == 29) {
                     this.c(3, 1);
                  } else {
                     this.c(4, 1);
                  }
                  break;
               case 65:
                  this.c(6, 1);
            }

            return true;
         }
      }
   }

   private void f(int var1) {
      if (this.h != 12) {
         this.B -= var1;
         this.n.a(this.c >> 8, (this.d >> 8) + this.b[1], var1, var1 > main.e.k());
      }
   }

   private int[] x() {
      if (this.b == null) {
         this.g();
      }

      return this.b;
   }

   private boolean y() {
      if (!this.a[3]) {
         return false;
      } else {
         d var1 = main.a.c[main.f.c];
         if (this.d + (this.b[1] << 8) > var1.d + (var1.b[3] << 8)) {
            return false;
         } else if (this.d + (this.b[3] << 8) < var1.d + (var1.b[1] << 8)) {
            return false;
         } else {
            if (this.c > var1.c) {
               int var2 = this.c + (this.b[0] - var1.x()[2] << 8);
               if (var1.c >= var2) {
                  return true;
               }
            } else {
               int var3 = this.c + (this.b[2] - var1.x()[0] << 8);
               if (var1.c <= var3) {
                  return true;
               }
            }

            return false;
         }
      }
   }

   final boolean a(d var1) {
      d var2 = var1;
      byte[] var3 = var1.m.d;

      for (int var4 = 0; var4 < 4; var4++) {
         var2.H[var4] = 0;
      }

      if (var2.q != -1 && var3 != null) {
         var3[(var2.q << 3) + 4 + 1] = (byte)var3[(var2.q << 3) + 4 + 1];
         var3[(var2.q << 3) + 4 + 3] = (byte)var3[(var2.q << 3) + 4 + 3];
         if (var3[(var2.q << 3) + 4 + 2] > 0) {
            var3[(var2.q << 3) + 4 + 2] = (byte)var3[(var2.q << 3) + 4 + 2];
         }

         if (var3[(var2.q << 3) + 4] > 0) {
            var3[(var2.q << 3) + 4] = (byte)var3[(var2.q << 3) + 4];
         }

         if (var2.a[0]) {
            var2.H[0] = -var3[(var2.q << 3) + 4 + 2];
            var2.H[2] = -var3[(var2.q << 3) + 4];
         } else {
            var2.H[0] = var3[(var2.q << 3) + 4];
            var2.H[2] = var3[(var2.q << 3) + 4 + 2];
         }

         var2.H[1] = var3[(var2.q << 3) + 4 + 1];
         var2.H[3] = var3[(var2.q << 3) + 4 + 3];
      }

      int[] var8 = var2.H;
      boolean var5 = false;
      int var12 = var1.d;
      int var10 = var1.c;
      if (var8[0] != var8[2]) {
         int[] var7 = this.x();
         int var11 = var10 - this.c >> 8;
         var12 = var12 - this.d >> 8;
         if (var11 + var8[0] > var7[2] || var12 + var8[1] > var7[3]) {
            return false;
         }

         if (var11 + var8[2] >= var7[0] && var12 + var8[3] >= var7[1]) {
            return true;
         }
      }

      return false;
   }

   private void a(int var1, boolean var2, boolean var3) {
      if (main.f.H <= 0) {
         if (var1 > 0) {
            if ((var1 = var1 - main.e.m()) <= 0) {
               var1 = 1;
            }

            this.n.a(this.c >> 8, (this.d >> 8) + this.b[1] - this.b[3], var1, false);
            main.e.M -= var1;
         }

         if (var2) {
            if (!this.a[0]) {
               this.b(0, 9);
            } else {
               this.b(0, 11);
            }
         } else if (this.a[0]) {
            this.b(0, 9);
         } else {
            this.b(0, 11);
         }

         main.f.H = 20;
      }
   }

   private void z() {
      this.n.j = -1;
      if (this.g == 25) {
         e(this.J);
      }

      if (main.f.K != 702) {
         switch (this.g) {
            case 0:
               return;
            case 1:
               if (this.e(7680, this.J + 1)) {
                  this.c(18, 1);
                  main.f.d = this.J;
                  return;
               }
               break;
            case 2:
               if (this.e(7680, this.J + 1)) {
                  this.c(0, 1);
                  main.f.b(4, 0);
                  main.a.c[this.J + 2].c(21, 1);
                  return;
               }
               break;
            case 3:
               if (this.y) {
                  this.c(4, 1);
                  main.a.c[this.J - 1].c(1, 1);
                  main.f.b(0, 0);
                  return;
               }
            case 4:
            case 6:
            case 14:
            case 17:
            default:
               break;
            case 5:
               if (this.I == 1) {
                  if (this.e(7680, this.J + 1)) {
                     this.c(6, 1);
                     main.a.c[this.J - 1].c(20, 1);
                     main.f.b(3, 0);
                     return;
                  }
               } else if (!s(this)) {
                  this.I = 1;
                  main.f.b(2, 0);
                  return;
               }
               break;
            case 7:
               if (this.y) {
                  this.c(8, 1);
                  main.f.b(6, 0);
                  return;
               }
               break;
            case 8:
               if (this.y) {
                  this.c(9, 1);
                  main.a.c[this.J - 3].c(24, 1);
                  return;
               }
               break;
            case 9:
               if (this.y) {
                  if (this.I == 1) {
                     main.f.D = false;
                     main.f.b(4112);
                     main.f.a(2, -1);
                     this.I = 2;
                     return;
                  }

                  if (this.I == 2) {
                     if (this.i(false)) {
                        this.I = 3;
                        return;
                     }

                     if (main.f.i != 0) {
                        main.f.a("Неправильно!");
                        return;
                     }
                  } else if (this.I == 3 && !this.i(false)) {
                     this.c(10, 1);
                     this.I = 0;
                     main.f.a(-1, -1);
                     return;
                  }
               }
               break;
            case 10:
               if (this.y) {
                  if (this.I == 1) {
                     main.f.b(8256);
                     main.f.a(4, -1);
                     this.I = 2;
                     return;
                  }

                  if (this.I == 2) {
                     if (this.j(false)) {
                        this.I = 3;
                        return;
                     }

                     if (main.f.i != 0) {
                        main.f.a("Неправильно!");
                        return;
                     }
                  } else {
                     if (this.I != 3) {
                        main.f.b(8, 0);
                        this.I = 1;
                        return;
                     }

                     if (!this.j(false)) {
                        this.c(11, 1);
                        this.I = 0;
                        main.f.a(-1, -1);
                        return;
                     }
                  }
               }
               break;
            case 11:
               if (this.y) {
                  if (this.I == 1) {
                     main.f.b(1028);
                     main.f.a(1, -1);
                     this.I = 2;
                     return;
                  }

                  if (this.I == 2) {
                     if (this.h(false)) {
                        this.I = 3;
                        return;
                     }

                     if (main.f.i != 0) {
                        main.f.a("Неправильно!");
                        return;
                     }
                  } else {
                     if (this.I != 3) {
                        main.f.b(9, 0);
                        this.I = 1;
                        return;
                     }

                     if (main.a.c[main.f.c].g == main.e.G[main.e.I] || main.a.c[main.f.c].g == main.e.H[main.e.I]) {
                        this.c(12, 1);
                        this.I = 0;
                        main.f.a(-1, -1);
                        return;
                     }
                  }
               }
               break;
            case 12:
               if (this.y) {
                  if (this.I == 1) {
                     main.f.b(16416);
                     main.f.a(5, -1);
                     this.I = 2;
                     return;
                  }

                  if (this.I == 2) {
                     if (this.f(false)) {
                        this.I = 3;
                        return;
                     }

                     if (main.f.i != 0) {
                        main.f.a("Неправильно!");
                        return;
                     }
                  } else {
                     if (this.I != 3) {
                        main.f.b(10, 0);
                        this.I = 1;
                        return;
                     }

                     if (main.f.c == 0 && (main.a.c[main.f.c].g == main.e.G[main.e.I] || main.a.c[main.f.c].g == main.e.H[main.e.I])) {
                        this.c(13, 1);
                        this.I = 0;
                        main.f.a(-1, -1);
                        main.a.c[6].c(0, 1);
                        return;
                     }
                  }
               }
               break;
            case 13:
               if (this.I == 1) {
                  if ((main.a.c[main.f.c].g == main.e.G[main.e.I] || main.a.c[main.f.c].g == main.e.H[main.e.I]) && !main.a.c[5].a[3] && !main.a.c[6].a[3]) {
                     main.f.D = true;
                     main.f.b(12, 0);
                     this.I = 2;
                     return;
                  }
               } else {
                  if (this.I == 2) {
                     main.a.c[this.J - 1].c(16, 1);
                     this.I = 3;
                     return;
                  }

                  if (this.I != 3) {
                     if (this.I == 4) {
                        if (this.c(2560)) {
                           main.a.c[main.f.c].c(main.e.G[main.e.I], 1);
                           main.f.D = false;
                           main.f.b(13, 0);
                           this.I = 5;
                           return;
                        }
                     } else if (this.I != 5 && (main.a.c[main.f.c].g == main.e.G[main.e.I] || main.a.c[main.f.c].g == main.e.H[main.e.I])) {
                        main.f.b(0);
                        main.f.b(11, 0);
                        this.I = 1;
                        return;
                     }
                  }
               }
               break;
            case 15:
               if (this.y && this.I != 1) {
                  if (this.I == 2) {
                     this.I = 3;
                     return;
                  }

                  if (this.I != 3) {
                     main.a.c[5].a[3] = true;
                     this.I = 1;
                     return;
                  }
               }
               break;
            case 16:
               if (this.y) {
                  this.a[3] = false;
                  main.a.c[this.J + 1].I = 4;
                  main.a.c[main.f.c].b(0, main.e.H[main.e.I]);
                  if (main.a.c[this.J + 1].c - main.a.c[main.f.c].c < 0) {
                     main.a.c[main.f.c].b(true);
                     return;
                  }

                  main.a.c[main.f.c].b(false);
                  return;
               }
               break;
            case 18:
               if (this.y) {
                  if (this.I == 1) {
                     this.c(17, 1);
                     main.a.c[this.J + 1].c(19, 1);
                     this.I = 2;
                     main.f.b(14, 0);
                     return;
                  }

                  this.c(18, 1);
                  main.f.b(1, 0);
                  this.I = 1;
                  return;
               }
               break;
            case 19:
               if (this.y) {
                  this.c(5, 1);
                  main.f.b(15, 0);
                  return;
               }
               break;
            case 20:
               if (this.y) {
                  if (this.v == 1) {
                     main.a.c[this.J + 3].c = main.a.a + 120 << 8;
                     main.a.c[this.J + 3].d = main.a.b + 170 << 8;
                     main.a.c[this.J + 3].a[3] = true;
                     this.c(0, 1);
                     main.f.b(5, 0);
                     return;
                  }

                  this.c(2, 1);
                  main.f.b(16, 0);
                  this.v = 1;
                  return;
               }
               break;
            case 21:
               if (this.y) {
                  this.c(15, 1);
                  return;
               }
               break;
            case 22:
               if (this.y) {
                  this.c(23, 1);
                  main.a.c[6].a[3] = true;
                  return;
               }
               break;
            case 23:
               if (this.y) {
                  main.a.c[this.J + 2].c(20, 1);
                  main.a.c[this.J + 4].I = 2;
                  this.a[3] = false;
               }
               break;
            case 24:
               if (this.y) {
                  this.a[3] = false;
                  main.f.d = main.f.c;
                  d var1;
                  (var1 = main.a.c[main.f.c]).a[2] = true;
                  var1.a[3] = true;
                  var1.c = this.c - 512;
                  var1.d = this.d;
                  var1.c(main.e.G[main.e.I], 1);
                  main.a.a(-1, -1);
                  main.f.b(7, 0);
                  main.a.c[this.J + 3].I = 1;
                  return;
               }
         }
      }
   }

   private void A() {
      switch (this.I) {
         case 7:
            this.g(30, 88);
            return;
         case 24:
            this.g(50, 76);
            return;
         case 25:
            this.g(40, 107);
            this.g(50, 72);
            return;
         case 26:
            this.g(80, 63);
            return;
         case 27:
            this.g(60, 105);
            return;
         case 28:
            this.g(50, 77);
            return;
         case 29:
            this.g(50, 79);
            this.g(50, 78);
            return;
         case 30:
            this.g(50, 82);
            return;
         case 31:
            this.g(50, 83);
            this.g(60, 84);
            return;
         case 32:
            this.g(15, 94);
            this.g(30, 93);
            return;
         case 33:
            this.g(4, 96);
            this.g(30, 103);
            return;
         case 34:
            this.g(50, 85);
            return;
         case 35:
            this.g(60, 70);
            this.g(60, 71);
            return;
         case 36:
            this.g(20, 91);
            this.g(30, 90);
            return;
         case 37:
            this.g(30, 89);
            return;
         case 38:
            this.g(30, 108);
            return;
         case 39:
            this.g(30, 92);
            return;
         case 40:
            this.g(50, 80);
            this.g(60, 81);
            return;
         case 41:
            this.g(80, 60);
            return;
         case 42:
            this.g(80, 61);
            this.g(80, 62);
            return;
         case 43:
            this.g(60, 67);
            return;
         case 44:
            this.g(50, 109);
            return;
         case 45:
            this.g(60, 68);
            this.g(60, 69);
            return;
         case 46:
            this.g(15, 110);
            this.g(20, 102);
            return;
         case 47:
            this.g(80, 64);
            this.g(80, 65);
            return;
         case 48:
            this.g(15, 98);
            this.g(30, 97);
            return;
         case 49:
            this.g(4, 96);
            this.g(30, 95);
            return;
         case 50:
            this.g(40, 111);
            return;
         case 51:
            this.g(20, 87);
            this.g(40, 86);
            return;
         case 52:
            this.g(40, 112);
            return;
         case 53:
            this.g(60, 66);
            return;
         case 54:
            this.g(50, 73);
            return;
         case 55:
            this.g(50, 74);
            this.g(60, 75);
            return;
         case 56:
            this.g(4, 96);
            this.g(30, 99);
            return;
         case 57:
            this.g(15, 101);
            this.g(30, 100);
            return;
         case 62:
            this.g(50, 104);
            return;
         case 63:
         case 64:
            this.g(100, 104);
         case 8:
         case 9:
         case 10:
         case 11:
         case 12:
         case 13:
         case 14:
         case 15:
         case 16:
         case 17:
         case 18:
         case 19:
         case 20:
         case 21:
         case 22:
         case 23:
         case 58:
         case 59:
         case 60:
         case 61:
      }
   }

   private void g(int var1, int var2) {
      if (this.g == 0) {
         if (!this.z) {
            this.C = engine.a.a(100);
            if (main.e.U) {
               this.C = 0;
            }

            if (this.C < var1) {
               this.z = true;
               return;
            }
         }
      } else if (this.C < var1) {
         main.e.a(var2, 1);
      }
   }

   private boolean B() {
      return this.o == 0 && this.p == 0 ? false : this.c <= this.o || this.c >= this.p;
   }

   private boolean C() {
      return this.o == 0 && this.p == 0 ? false : this.d <= this.o || this.d >= this.p;
   }

   private boolean D() {
      if (!this.a[3]) {
         return false;
      } else {
         d var1 = main.a.c[main.f.c];
         if (this.d + (this.b[1] << 8) > var1.d + (var1.b[3] << 8)
            || this.d + (this.b[3] << 8) < var1.d + (var1.b[1] << 8)
            || this.c + (this.b[0] << 8) > var1.c + 3072
            || this.c + (this.b[2] << 8) < var1.c + -3072) {
            this.z = false;
            return false;
         } else if (this.z) {
            return false;
         } else if (this.d + (this.b[3] << 8) < var1.d) {
            if (this.d + (this.b[1] << 8) <= var1.d + (var1.b[3] << 8)
               && this.d + (this.b[3] << 8) >= var1.d + (var1.b[1] << 8)
               && this.c + (this.b[0] << 8) <= var1.c
               && this.c + (this.b[2] << 8) >= var1.c) {
               if (var1.g == 6) {
                  var1.d = this.d;
                  var1.c(15, 1);
                  main.f.a(13, -1);
                  this.z = true;
               }

               return true;
            } else {
               this.z = false;
               return false;
            }
         } else {
            if (var1.g == 6) {
               var1.d = this.d;
               this.z = true;
               var1.c(8, 1);
            } else if (var1.g == main.e.H[main.e.I] || var1.g == main.e.G[main.e.I]) {
               this.z = true;
            }

            return true;
         }
      }
   }

   private static boolean E() {
      for (int var0 = main.a.d - 1; var0 >= 0; var0--) {
         d var1;
         if ((var1 = main.a.c[var0]) != null && var1.a[3] && var1.h == 67 && var1.z) {
            return true;
         }
      }

      return false;
   }
}
