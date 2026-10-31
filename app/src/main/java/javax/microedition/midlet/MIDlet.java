package javax.microedition.midlet;

public abstract class MIDlet {
   /** Устанавливается Android-хостом: закрыть Activity при notifyDestroyed(). */
   public static Runnable exitHook;

   protected MIDlet() {
   }

   protected abstract void startApp() throws MIDletStateChangeException;

   protected abstract void pauseApp();

   protected abstract void destroyApp(boolean unconditional) throws MIDletStateChangeException;

   public final void notifyDestroyed() {
      if (exitHook != null) {
         exitHook.run();
      }
   }

   public final void notifyPaused() {
   }

   public final void resumeRequest() {
   }

   public String getAppProperty(String key) {
      return null;
   }

   public final boolean platformRequest(String url) {
      return false;
   }

   // --- вызовы со стороны Android-хоста ---
   public final void hostStart() {
      try {
         startApp();
      } catch (MIDletStateChangeException ignored) {
      }
   }

   public final void hostPause() {
      pauseApp();
   }

   public final void hostDestroy() {
      try {
         destroyApp(true);
      } catch (MIDletStateChangeException ignored) {
      }
   }
}
