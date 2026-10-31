package android.graphics;
public class Bitmap { public enum Config { ARGB_8888 }
 public static Bitmap createBitmap(int w,int h,Config c){return null;} public void eraseColor(int c){} public int getWidth(){return 0;} public int getHeight(){return 0;}
 public void getPixels(int[] p,int o,int s,int x,int y,int w,int h){} public void setPixels(int[] p,int o,int s,int x,int y,int w,int h){} }
