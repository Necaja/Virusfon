package compat;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.InputStream;

/** Доступ к ресурсам игры (бывший Class.getResourceAsStream из JAR) — читает из assets/. */
public final class Res {
   private static Context ctx;

   private Res() {
   }

   public static void init(Context c) {
      ctx = c.getApplicationContext();
   }

   public static Context context() {
      return ctx;
   }

   /** @return поток или null, если ресурса нет (как в J2ME). Путь вида "/a.bin" или "a.bin". */
   public static InputStream open(String path) {
      if (ctx == null || path == null) {
         return null;
      }
      String p = path.startsWith("/") ? path.substring(1) : path;
      try {
         // буфер обязателен: игра читает данные побайтно, а AssetInputStream.read() — дорогой JNI-вызов
         return new BufferedInputStream(ctx.getAssets().open(p), 32 * 1024);
      } catch (Exception e) {
         return null;
      }
   }

   /** Замена Thread.yield() в игровом цикле: оригинал крутился в busy-wait и грел бы CPU. */
   public static void yield() {
      try {
         Thread.sleep(1);
      } catch (InterruptedException e) {
         Thread.currentThread().interrupt();
      }
   }
}
