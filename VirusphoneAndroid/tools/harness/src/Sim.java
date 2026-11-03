import android.content.Context;
import android.content.res.AssetManager;
import java.io.File;
import javax.microedition.lcdui.Display;
public class Sim {
  static int k() throws Exception { return main.f.k; }
  public static void main(String[] a) throws Exception {
    AssetManager.dir = new File(a[0]);
    final File tmp = new File(a[1]); tmp.mkdirs();
    final AssetManager am = new AssetManager();
    compat.Res.init(new Context(){ public AssetManager getAssets(){return am;} public File getFilesDir(){return tmp;} public File getCacheDir(){return tmp;} public Context getApplicationContext(){return this;} });
    javax.microedition.midlet.MIDlet m = new main.cMIDlet();
    m.hostStart();
    String[] script = a.length>2 ? a[2].split(",") : new String[0]; // "t:key" pairs: seconds:keycode
    int last=-999; long t0=System.currentTimeMillis(); int si=0;
    while (System.currentTimeMillis()-t0 < Long.parseLong(a[3])) {
      long el = System.currentTimeMillis()-t0;
      if (si < script.length) { String[] p = script[si].split(":"); if (el >= Long.parseLong(p[0])) { int code=Integer.parseInt(p[1]); Display.key(true,code); Thread.sleep(120); Display.key(false,code); System.out.println("[sim] pressed "+code+" at "+el+"ms k="+k()); si++; } }
      int k=k(); if (k!=last){ System.out.println("[sim] "+el+"ms state k="+k+" aR?"); last=k; }
      Thread.sleep(50);
    }
    System.out.println("[sim] final k="+k());
    for (java.util.Map.Entry<Thread,StackTraceElement[]> e : Thread.getAllStackTraces().entrySet()) {
      if (e.getKey().getName().startsWith("Thread-")||e.getKey().getName().startsWith("lcdui")) { System.out.println("== "+e.getKey().getName()); int n=0; for (StackTraceElement s: e.getValue()) { if (n++<8) System.out.println("   "+s); } }
    }
    System.exit(0);
  }
}
