package compat;

import android.media.SoundPool;
import engine.Fx;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/** Короткие звуки переходов (книга, свиток) через SoundPool: минимальная задержка, не мешает музыке. */
public final class Sfx implements Fx.Sink {
   private SoundPool pool;
   private int book, scroll;
   private boolean ready;

   public void init() {
      try {
         pool = new SoundPool.Builder().setMaxStreams(3).build();
         book = load("fx_book.wav");
         scroll = load("fx_scroll.wav");
         ready = true;
      } catch (Throwable e) {
         ready = false;
      }
   }

   private int load(String asset) throws Exception {
      File f = new File(Res.context().getCacheDir(), asset);
      InputStream in = Res.open(asset);
      if (in == null) {
         return 0;
      }
      FileOutputStream out = new FileOutputStream(f);
      try {
         byte[] buf = new byte[8192];
         int n;
         while ((n = in.read(buf)) > 0) {
            out.write(buf, 0, n);
         }
      } finally {
         out.close();
         in.close();
      }
      return pool.load(f.getAbsolutePath(), 1);
   }

   @Override
   public void play(int kind) {
      if (!ready) {
         return;
      }
      int id = kind == Fx.BOOK ? book : scroll;
      if (id != 0) {
         pool.play(id, 0.9f, 0.9f, 1, 0, 1f);
      }
   }
}
