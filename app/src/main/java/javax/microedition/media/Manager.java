package javax.microedition.media;

import compat.Res;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public final class Manager {
   private static int counter;

   private Manager() {
   }

   public static Player createPlayer(InputStream in, String type) throws IOException, MediaException {
      String ext = type != null && type.contains("wav") ? ".wav" : type != null && type.contains("mpeg") ? ".mp3" : ".mid";
      File f = new File(Res.context().getCacheDir(), "snd" + (counter++) + ext);
      FileOutputStream out = new FileOutputStream(f);
      try {
         byte[] buf = new byte[4096];
         int n;
         while ((n = in.read(buf)) > 0) {
            out.write(buf, 0, n);
         }
      } finally {
         out.close();
         in.close();
      }
      return new Player(f);
   }
}
