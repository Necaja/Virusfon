package javax.microedition.lcdui;
import java.awt.image.BufferedImage;
public final class Font { final java.awt.Font f; final java.awt.FontMetrics fm;
  private Font(int sz){ f=new java.awt.Font("SansSerif",0,sz); fm=new BufferedImage(1,1,1).createGraphics().getFontMetrics(f);}
  public static Font getFont(int face,int style,int size){ return new Font(size==8?12:size==16?18:14);}
  public static Font getDefaultFont(){return getFont(0,0,0);}
  public int getHeight(){return fm.getHeight();} public int stringWidth(String s){return fm.stringWidth(s);} public int charWidth(char c){return fm.charWidth(c);}
  public int getBaselinePosition(){return fm.getAscent();} }
