package android.graphics;
public class Bitmap { public enum Config { ARGB_8888 } int w,h; int[] px;
 public Bitmap(int w,int h){this.w=w;this.h=h;px=new int[w*h];}
 public static Bitmap createBitmap(int w,int h,Config c){return new Bitmap(w,h);} public void eraseColor(int c){java.util.Arrays.fill(px,c);} public int getWidth(){return w;} public int getHeight(){return h;}
 public void getPixels(int[] p,int o,int s,int x,int y,int ww,int hh){} public void setPixels(int[] p,int o,int s,int x,int y,int ww,int hh){} }
