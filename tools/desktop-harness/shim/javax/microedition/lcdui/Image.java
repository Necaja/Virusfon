package javax.microedition.lcdui;
import java.awt.image.BufferedImage; import java.io.*; import javax.imageio.ImageIO;
public class Image { public final BufferedImage bi; boolean mutable;
  Image(BufferedImage b, boolean m){bi=b;mutable=m;}
  public static Image createImage(String n) throws IOException { InputStream in=compat.Res.open(n); if(in==null) throw new IOException("nf "+n); BufferedImage b=ImageIO.read(in); if(b==null) throw new IOException("decode "+n); return new Image(b,false);}
  public static Image createImage(int w,int h){ BufferedImage b=new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB); java.awt.Graphics2D g=b.createGraphics(); g.setColor(java.awt.Color.WHITE); g.fillRect(0,0,w,h); g.dispose(); return new Image(b,true);}
  public static Image createImage(byte[] d,int o,int l){ try{return new Image(ImageIO.read(new ByteArrayInputStream(d,o,l)),false);}catch(IOException e){throw new IllegalArgumentException();} }
  public static Image createImage(Image s){return new Image(s.bi,false);}
  public static Image createRGBImage(int[] rgb,int w,int h,boolean a){ BufferedImage b=new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB); b.setRGB(0,0,w,h,rgb,0,w); return new Image(b,false);}
  public Graphics getGraphics(){ return new Graphics(bi.createGraphics(), bi.getWidth(), bi.getHeight()); }
  public int getWidth(){return bi.getWidth();} public int getHeight(){return bi.getHeight();} public boolean isMutable(){return mutable;}
  public void getRGB(int[] r,int o,int s,int x,int y,int w,int h){ bi.getRGB(x,y,w,h,r,o,s);} }
