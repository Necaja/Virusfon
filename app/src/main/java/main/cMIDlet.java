package main;

import javax.microedition.midlet.MIDlet;

public class cMIDlet extends MIDlet {
   static cMIDlet a;
   static f b;

   public cMIDlet() {
      a = this;
      b = new f();
   }

   public void startApp() {
      if (!f.l) {
         b.a();
      } else {
         b.showNotify();
      }
   }

   public void pauseApp() {
      if (!f.l) {
         b.hideNotify();
      }
   }

   public void destroyApp(boolean var1) {
      f.b();
      this.notifyDestroyed();
   }
}
