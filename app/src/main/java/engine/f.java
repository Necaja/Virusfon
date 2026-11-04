package engine;

import java.io.InputStream;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;

public final class f {
   private Player a;
   private String[] b = new String[]{"audio/x-tone-seq", "audio/midi", "audio/x-wav"};
   private String c = "";
   /** Главное меню и его экраны: вместо MIDI "menu" играет трек title.mp3 (выставляет main.f). */
   public static volatile boolean title;

   public final void a(String var1, boolean var2, int var3) {
      byte var8 = 1;
      var2 = true;
      if (title && "menu".equals(var1)) {
         var1 = "title";
      }
      if (!this.c.equals(var1)) {
         this.a();
         this.b(var1, var2, var8);

         try {
            if (this.a != null) {
               this.a.realize();
               this.a.prefetch();
               this.a.start();
               this.c = var1;
            }

            return;
         } catch (Exception var4) {
            var4.printStackTrace();
         }
      }
   }

   public final void b(String var1, boolean var2, int var3) {
      try {
         InputStream var5;
         boolean mp3 = "title".equals(var1);
         if ((var5 = compat.Res.open("/" + var1 + (mp3 ? ".mp3" : ".mid"))) != null) {
            this.a = Manager.createPlayer(var5, mp3 ? "audio/mpeg" : this.b[var3]);
            this.a.realize();
            if (var2) {
               this.a.setLoopCount(-1);
            }
         }

         System.gc();
      } catch (Exception var4) {
         var4.printStackTrace();
      }
   }

   public final void a() {
      try {
         if (this.a != null) {
            this.a.stop();
            this.a.deallocate();
            this.a.close();
            this.a = null;
            this.c = "";
            System.gc();
         }
      } catch (Exception var1) {
      }
   }
}
