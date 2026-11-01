package android.graphics;
import java.io.*;
public class BitmapFactory { public static class Options { public boolean inScaled; public Bitmap.Config inPreferredConfig; }
 public static Bitmap decodeStream(InputStream i, Rect r, Options o){ try { java.awt.image.BufferedImage b = javax.imageio.ImageIO.read(i); return b==null?null:new Bitmap(b.getWidth(), b.getHeight()); } catch(Exception e){ return null; } }
 public static Bitmap decodeByteArray(byte[] d,int o,int l,Options op){ return decodeStream(new ByteArrayInputStream(d,o,l),null,op);} }
