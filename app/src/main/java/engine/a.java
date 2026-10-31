package engine;

import java.util.Random;

public final class a {
   private static Random a = new Random();
   private static int b = 0;
   private static int c = 0;

   public static int a(int var0) {
      return Math.abs(a.nextInt() % var0);
   }

   public static boolean b(int var0) {
      if (++b >= var0) {
         b = 0;
         return true;
      } else {
         return false;
      }
   }

   public static boolean c(int var0) {
      if (++c >= var0) {
         c = 0;
         return true;
      } else {
         return false;
      }
   }
}
