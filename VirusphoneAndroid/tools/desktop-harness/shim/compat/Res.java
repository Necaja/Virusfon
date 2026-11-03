package compat;
import java.io.*;
public final class Res {
  public static File assets = new File(System.getProperty("assets","app/src/main/assets"));
  public static File files = new File(System.getProperty("java.io.tmpdir"), "rmsdir");
  public static InputStream open(String p){ try { return new FileInputStream(new File(assets, p.startsWith("/")?p.substring(1):p)); } catch(Exception e){ System.err.println("RES MISSING "+p); return null; } }
  public static void yield(){ try{Thread.sleep(1);}catch(InterruptedException e){} }
}
