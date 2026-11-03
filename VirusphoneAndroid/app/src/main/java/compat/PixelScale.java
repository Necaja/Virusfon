package compat;

/** Пиксельные апскейлеры для pixel-art: Scale2x (EPX) и Scale3x (AdvMAME3x). Без Android-зависимостей. */
public final class PixelScale {
   private PixelScale() {
   }

   /** Scale2x: строки yFrom..yTo-1 исходника; d имеет размер (2w)*(2h). */
   public static void x2Rows(int[] s, int[] d, int w, int h, int yFrom, int yTo) {
      int w2 = w * 2;
      for (int y = yFrom; y < yTo; y++) {
         int row = y * w, up = (y > 0 ? y - 1 : y) * w, dn = (y < h - 1 ? y + 1 : y) * w;
         int o0 = y * 2 * w2, o1 = o0 + w2;
         for (int x = 0; x < w; x++) {
            int p = s[row + x];
            int a = s[up + x], b = s[row + (x < w - 1 ? x + 1 : x)], c = s[row + (x > 0 ? x - 1 : x)], e = s[dn + x];
            int p0 = p, p1 = p, p2 = p, p3 = p;
            if (a != e && c != b) {
               if (c == a) p0 = a;
               if (a == b) p1 = b;
               if (e == c) p2 = c;
               if (b == e) p3 = e;
            }
            int o = x * 2;
            d[o0 + o] = p0;
            d[o0 + o + 1] = p1;
            d[o1 + o] = p2;
            d[o1 + o + 1] = p3;
         }
      }
   }

   /** Scale3x: d имеет размер (3w)*(3h). Плоские области и острые углы сохраняются, диагонали сглаживаются. */
   public static void x3(int[] s, int[] d, int w, int h) {
      int w3 = w * 3;
      for (int y = 0; y < h; y++) {
         int r0 = (y > 0 ? y - 1 : y) * w, r1 = y * w, r2 = (y < h - 1 ? y + 1 : y) * w;
         int o0 = y * 3 * w3, o1 = o0 + w3, o2 = o1 + w3;
         for (int x = 0; x < w; x++) {
            int xl = x > 0 ? x - 1 : x, xr = x < w - 1 ? x + 1 : x;
            int A = s[r0 + xl], B = s[r0 + x], C = s[r0 + xr];
            int D = s[r1 + xl], E = s[r1 + x], F = s[r1 + xr];
            int G = s[r2 + xl], H = s[r2 + x], I = s[r2 + xr];
            int e0 = E, e1 = E, e2 = E, e3 = E, e5 = E, e6 = E, e7 = E, e8 = E;
            if (B != H && D != F) {
               e0 = D == B ? D : E;
               e1 = (D == B && E != C) || (B == F && E != A) ? B : E;
               e2 = B == F ? F : E;
               e3 = (D == B && E != G) || (D == H && E != A) ? D : E;
               e5 = (B == F && E != I) || (H == F && E != C) ? F : E;
               e6 = D == H ? D : E;
               e7 = (D == H && E != I) || (H == F && E != G) ? H : E;
               e8 = H == F ? F : E;
            }
            int o = x * 3;
            d[o0 + o] = e0;
            d[o0 + o + 1] = e1;
            d[o0 + o + 2] = e2;
            d[o1 + o] = e3;
            d[o1 + o + 1] = E;
            d[o1 + o + 2] = e5;
            d[o2 + o] = e6;
            d[o2 + o + 1] = e7;
            d[o2 + o + 2] = e8;
         }
      }
   }
}
