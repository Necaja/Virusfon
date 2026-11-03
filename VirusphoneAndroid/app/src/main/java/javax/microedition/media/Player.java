package javax.microedition.media;

import android.media.MediaPlayer;
import java.io.File;

/** Минимальный Player (MIDI/WAV) поверх android.media.MediaPlayer. */
public class Player {
   public static final int CLOSED = 0, UNREALIZED = 100, REALIZED = 200, PREFETCHED = 300, STARTED = 400;

   private final File file;
   private MediaPlayer mp;
   private boolean prepared;
   private boolean loop;

   Player(File f) {
      this.file = f;
   }

   public synchronized void realize() throws MediaException {
      if (mp != null) {
         return;
      }
      try {
         mp = new MediaPlayer();
         mp.setDataSource(file.getPath());
         mp.setLooping(loop);
      } catch (Exception e) {
         mp = null;
         throw new MediaException(e.toString());
      }
   }

   public synchronized void prefetch() throws MediaException {
      realize();
      if (!prepared) {
         try {
            mp.prepare();
            prepared = true;
         } catch (Exception e) {
            throw new MediaException(e.toString());
         }
      }
   }

   public synchronized void start() throws MediaException {
      prefetch();
      mp.start();
   }

   public synchronized void stop() throws MediaException {
      if (mp != null && prepared && mp.isPlaying()) {
         mp.pause();
      }
   }

   public synchronized void deallocate() {
      if (mp != null) {
         mp.release();
         mp = null;
         prepared = false;
      }
   }

   public synchronized void close() {
      deallocate();
      file.delete();
   }

   /** n < 0 — бесконечный повтор. */
   public synchronized void setLoopCount(int n) {
      loop = n < 0 || n > 1;
      if (mp != null) {
         mp.setLooping(loop);
      }
   }
}
