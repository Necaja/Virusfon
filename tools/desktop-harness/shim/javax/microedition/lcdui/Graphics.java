package javax.microedition.lcdui;
import java.awt.*; import java.awt.geom.*;
public class Graphics { public static final int HCENTER=1,VCENTER=2,LEFT=4,RIGHT=8,TOP=16,BOTTOM=32,BASELINE=64;
  final Graphics2D g; final int W,H; int tx,ty,cx,cy,cw,ch,extra; Font font=Font.getDefaultFont();
  public Graphics(Graphics2D g,int w,int h){this.g=g;W=w;H=h;reset();}
  public void setWide(int e){extra=e;reset();}
  private boolean full(int x,int w){return extra>0&&x==0&&w==240;}
  public void reset(){tx=extra;ty=0;cx=-extra;cy=0;cw=W;ch=H;g.setColor(Color.BLACK);}
  private void clip(){ g.setClip(tx+cx,ty+cy,cw,ch);}
  public void setColor(int rgb){g.setColor(new Color(rgb|0xFF000000,true));} public void setColor(int r,int gg,int b){g.setColor(new Color(r,gg,b));}
  public void setFont(Font f){font=f;} public Font getFont(){return font;} public void translate(int x,int y){tx+=x;ty+=y;}
  public void setClip(int x,int y,int w,int h){if(full(x,w)){x=-tx;w=W;} cx=x;cy=y;cw=Math.max(0,w);ch=Math.max(0,h);}
  public void clipRect(int x,int y,int w,int h){if(full(x,w)){x=-tx;w=W;} int x2=Math.min(cx+cw,x+w),y2=Math.min(cy+ch,y+h);cx=Math.max(cx,x);cy=Math.max(cy,y);cw=Math.max(0,x2-cx);ch=Math.max(0,y2-cy);}
  public void fillRect(int x,int y,int w,int h){if(full(x,w)){x=-tx;w=W;} clip();g.fillRect(tx+x,ty+y,w,h);} public void drawRect(int x,int y,int w,int h){clip();g.drawRect(tx+x,ty+y,w,h);}
  public void drawLine(int a,int b,int c,int d){clip();g.drawLine(tx+a,ty+b,tx+c,ty+d);}
  public void fillArc(int x,int y,int w,int h,int s,int a){clip();g.fillArc(tx+x,ty+y,w,h,s,a);}
  public void drawRGB(int[] rgb,int off,int sc,int x,int y,int w,int h,boolean al){ if(extra>0&&x==0&&y==0&&w==240&&h==320&&sc==240&&rgb[off]==rgb[off+240*320-1]){ clip(); g.setColor(new Color(rgb[off],true)); g.fillRect(0,ty,W,H); return; } java.awt.image.BufferedImage b=new java.awt.image.BufferedImage(w,h,2); b.setRGB(0,0,w,h,rgb,off,sc); clip(); g.drawImage(b,tx+x,ty+y,null);}
  public void drawImage(Image im,int x,int y,int an){ if(im==null)return; int w=im.getWidth(),h=im.getHeight(); if((an&HCENTER)!=0)x-=w/2;else if((an&RIGHT)!=0)x-=w; if((an&VCENTER)!=0)y-=h/2;else if((an&BOTTOM)!=0)y-=h; clip(); g.drawImage(im.bi,tx+x,ty+y,null);}
  public void drawImageManip(Image im,int x,int y,int an,int m){ if(im==null)return; boolean fh=(m&0x2000)!=0; int w=im.getWidth(),h=im.getHeight(); if((an&HCENTER)!=0)x-=w/2;else if((an&RIGHT)!=0)x-=w; if((an&VCENTER)!=0)y-=h/2;else if((an&BOTTOM)!=0)y-=h; clip(); if(fh) g.drawImage(im.bi,tx+x+w,ty+y,-w,h,null); else g.drawImage(im.bi,tx+x,ty+y,null);}
  public void fillTriangle(int a,int b,int c,int d,int e,int f){clip();g.fillPolygon(new int[]{tx+a,tx+c,tx+e},new int[]{ty+b,ty+d,ty+f},3);}
  public void drawSubstring(String s,int o,int l,int x,int y,int an){drawString(s.substring(o,o+l),x,y,an);}
  public void drawSidesMirrored(Image center,int argb){ if(extra<=0)return; setClip(-extra,0,extra,H); drawImageManip(center,-240,0,TOP|LEFT,0x2000); setClip(240,0,extra,H); drawImageManip(center,240,0,TOP|LEFT,0x2000); g.setClip(null); g.setColor(new Color(argb,true)); g.fillRect(0,0,extra,H); g.fillRect(extra+240,0,extra,H); setClip(-extra,0,W,H);}
  public void drawScaled(Image im,int x,int y,int w,int h){ clip(); g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR); g.drawImage(im.bi,tx+x,ty+y,w,h,null); g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);}
  public void fillRectArgb(int x,int y,int w,int h,int argb){ clip(); g.setColor(new Color(argb,true)); g.fillRect(tx+x,ty+y,w,h);}
  public void drawString(String s,int x,int y,int an){ if(s==null)return; g.setFont(font.f); int w=font.stringWidth(s); if((an&HCENTER)!=0)x-=w/2;else if((an&RIGHT)!=0)x-=w; int by=(an&BASELINE)!=0?y:(an&BOTTOM)!=0?y-font.fm.getDescent():y+font.fm.getAscent(); clip(); g.drawString(s,tx+x,ty+by);}
}
