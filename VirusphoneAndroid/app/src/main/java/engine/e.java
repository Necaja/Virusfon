package engine;

import java.io.InputStream;

public final class e {
   public static int a(InputStream var0) throws java.io.IOException {
      int var1 = (var0.read() & 0xFF) << 8;
      int var2 = var0.read() & 0xFF;
      return var1 | var2;
   }

   public static int a(InputStream var0, byte[] var1, int var2, int var3) {
      try {
         for (int var4 = 0; var4 < var3; var4++) {
            var1[var2 + var4] = (byte)var0.read();
         }

         return var3;
      } catch (Exception var5) {
         return -1;
      }
   }
}
