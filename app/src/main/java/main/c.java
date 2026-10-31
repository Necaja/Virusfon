package main;

import javax.microedition.lcdui.Image;

public final class c {
   Image a;
   int b;
   byte[] c;
   byte[] d;
   byte[][] e;
   byte[][] f;
   byte[] g;
   byte[] h;
   short[] i;
   int j;
   private int v = 0;
   private int w = 0;
   private int x = 0;
   private int y = 0;
   int k = 0;
   int l = 0;
   int m = 0;
   int n;
   boolean o = false;
   boolean p = false;
   int q = 0;
   int r = 0;
   int s = 0;
   boolean t = false;
   boolean u = false;

   public c() {
      this.b = -1;
      this.j = -1;
   }

   final boolean a() {
      switch (this.b) {
         case 3:
            this.a = main.f.B;
         case 4:
         case 5:
         case 6:
         case 7:
         case 8:
         default:
            break;
         case 9:
            this.a = main.f.y;
            break;
         case 10:
            this.a = main.f.u;
            break;
         case 11:
            this.a = main.f.q[13];
            break;
         case 12:
            this.a = main.f.q[12];
            break;
         case 13:
            this.a = main.f.q[11];
            break;
         case 14:
            this.a = main.f.q[10];
            break;
         case 15:
            this.a = main.f.q[9];
            break;
         case 16:
            this.a = main.f.q[8];
            break;
         case 17:
            this.a = main.f.q[0];
            break;
         case 18:
            this.a = main.f.q[7];
            break;
         case 19:
            this.a = main.f.q[6];
            break;
         case 20:
            this.a = main.f.q[4];
            break;
         case 21:
            this.a = main.f.q[3];
            break;
         case 22:
            this.a = main.f.q[2];
            break;
         case 23:
            this.a = main.f.q[1];
            break;
         case 24:
            this.a = main.f.r;
            break;
         case 25:
            this.a = main.f.q[5];
            break;
         case 26:
            this.a = main.f.v[0];
            break;
         case 27:
            this.a = main.f.t;
            break;
         case 28:
            this.a = main.f.m[4];
            break;
         case 29:
            this.a = main.f.m[3];
            break;
         case 30:
            this.a = main.f.m[2];
            break;
         case 31:
            this.a = main.f.m[1];
            break;
         case 32:
            this.a = main.f.m[0];
            break;
         case 33:
            this.a = main.f.v[1];
            break;
         case 34:
            this.a = main.f.v[2];
            break;
         case 35:
            this.a = main.f.v[3];
            break;
         case 36:
            this.a = main.f.v[4];
            break;
         case 37:
            this.a = main.f.v[5];
            break;
         case 38:
            this.a = main.f.v[6];
            break;
         case 39:
            this.a = main.f.v[7];
            break;
         case 40:
            this.a = main.f.v[8];
            break;
         case 41:
            this.a = main.f.v[9];
            break;
         case 42:
            this.a = main.f.x;
            break;
         case 43:
            this.a = main.f.w;
            break;
         case 44:
            this.a = main.f.z[0];
            break;
         case 45:
            this.a = main.f.z[1];
            break;
         case 46:
            this.a = main.f.z[2];
            break;
         case 47:
            this.a = main.f.z[3];
            break;
         case 48:
            this.a = main.f.z[4];
            break;
         case 49:
            this.a = main.f.z[5];
            break;
         case 50:
            this.a = main.f.z[6];
            break;
         case 51:
            this.a = main.f.q[0];
            break;
         case 52:
            this.a = main.f.s;
      }

      return true;
   }

   public final int a(int var1, int var2) {
      if (var1 < 0 || var1 >= this.g.length) {
         return -1;
      } else {
         return var2 >= 0 && var2 < this.g[var1] ? this.f[var1][var2 << 1] : -1;
      }
   }

   public final void a(int var1, int var2, int var3, boolean var4) {
      this.o = true;
      this.m = 0;
      this.k = var1;
      this.l = var2;
      this.n = var3;
      this.p = var4;
      if (this.p) {
         this.l -= 15;
      }
   }

   public final void a(int var1, int var2, boolean var3) {
      this.t = true;
      this.s = 0;
      this.q = var1;
      this.r = var2 - 31;
      this.u = var3;
      if (!this.u) {
         this.q -= 75;
      }
   }
}
