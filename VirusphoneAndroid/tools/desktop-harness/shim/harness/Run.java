package harness;
import javax.microedition.lcdui.*;
public class Run {
  static void key(int c, int hold) throws Exception { Display.key(true,c); Thread.sleep(hold); Display.key(false,c); Thread.sleep(150); }
  static java.util.Set<String> fired=new java.util.HashSet<>(); static boolean jumped; static void setInt(Class<?> c,String n,int v) throws Exception { java.lang.reflect.Field f=c.getDeclaredField(n); f.setAccessible(true); f.setInt(null,v);}
  static void dump(String name) throws Exception {
    java.lang.reflect.Field f = Display.class.getDeclaredField("back"); f.setAccessible(true);
    java.lang.reflect.Field lf = Display.class.getDeclaredField("lock"); lf.setAccessible(true); java.util.concurrent.locks.ReentrantLock lk=(java.util.concurrent.locks.ReentrantLock) lf.get(null); lk.lock(); try { Image im = (Image) f.get(null); if (im==null) return; javax.imageio.ImageIO.write(im.bi, "png", new java.io.File(System.getProperty("java.io.tmpdir")+"/frames/"+name+".png")); } finally { lk.unlock(); } if(true) return; Image im=null;
    javax.imageio.ImageIO.write(im.bi, "png", new java.io.File(System.getProperty("java.io.tmpdir")+"/frames/"+name+".png"));
  }
  static int getInt(Class<?> c,String n) throws Exception { java.lang.reflect.Field f=c.getDeclaredField(n); f.setAccessible(true); return f.getInt(null);}
  public static void main(String[] a) throws Exception {
    new java.io.File(System.getProperty("java.io.tmpdir")+"/frames").mkdirs();
    Display.setLogicalWidth(Integer.parseInt(a.length>1?a[1]:"711")); main.cMIDlet m = new main.cMIDlet(); m.hostStart();
    String[] steps = a[0].split(","); int si=0; long t0=System.currentTimeMillis(); long next=t0+4000; int last=-99, n=0; long nd=t0+6000; int lastCam=-1, camDumps=0;
    while (System.currentTimeMillis()-t0 < (a.length>3?Integer.parseInt(a[3]):60000)) {
      Thread.sleep(100);
      if (main.f.k!=last){ last=main.f.k; System.out.println("[t="+(System.currentTimeMillis()-t0)+"] k="+last); }
      if (si<steps.length && System.currentTimeMillis()>next && (steps[si].indexOf(":")<0 || Integer.parseInt(steps[si].split(":")[0])==main.f.k)) { String st=steps[si++]; int c=Integer.parseInt(st.contains(":")?st.split(":")[1]:st); System.out.println("[key] "+c); key(c,200); next=System.currentTimeMillis()+(a.length>2?Integer.parseInt(a[2]):1800); }
      if (System.getProperty("jump")!=null && !jumped && main.f.k==7 && System.currentTimeMillis()-t0>14000){ jumped=true; setInt(main.f.class,"K",Integer.parseInt(System.getProperty("jump"))); setInt(main.f.class,"k",2); System.out.println("JUMP"); }
      long el=System.currentTimeMillis()-t0; if (System.getProperty("probe")!=null) { for (String pr: System.getProperty("probe").split(",")) { String[] kv=pr.split("@"); long at=Long.parseLong(kv[1]); if (el>at && el<at+150 && !fired.contains(pr)) { fired.add(pr); System.out.println("PROBE press "+kv[0]+" at k="+main.f.k); key(Integer.parseInt(kv[0]),250); Thread.sleep(1200); System.out.println("  -> k="+main.f.k); dump("probe_"+kv[0]+"_"+at+"_k"+main.f.k);} } }
      if (System.getProperty("interp")!=null && main.f.k==7) { int cam=getInt(main.a.class,"a"); if (cam!=lastCam && lastCam>=0 && camDumps<4) { camDumps++; dump("cam"+camDumps+"_exact"); Image im=Display.interpolated(0f); if(im!=null) javax.imageio.ImageIO.write(im.bi,"png",new java.io.File(System.getProperty("java.io.tmpdir")+"/frames/cam"+camDumps+"_i0.png")); System.out.println("CAM "+lastCam+"->"+cam); } lastCam=cam; }
      if (System.currentTimeMillis()>nd){ dump("f"+(n++)+"_k"+main.f.k); if(System.getProperty("interp")!=null){ for(float al: new float[]{0f,0.5f}){ Image im=Display.interpolated(al); if(im!=null) javax.imageio.ImageIO.write(im.bi,"png",new java.io.File(System.getProperty("java.io.tmpdir")+"/frames/f"+(n-1)+"_i"+(int)(al*10)+".png")); } } System.out.println("  K="+getInt(main.f.class,"K")+" map "+engine.c.a+"x"+engine.c.b+" tile "+engine.c.c+"x"+engine.c.d); nd=System.currentTimeMillis()+3000; }
    }
    System.exit(0);
  }
}
