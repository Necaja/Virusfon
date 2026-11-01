package android.graphics;
public class Canvas { public Canvas(){} public Canvas(Bitmap b){} public int save(){return 0;} public void restore(){} public boolean clipRect(int a,int b,int c,int d){return true;}
 public void drawRect(float a,float b,float c,float d,Paint p){} public void drawLine(float a,float b,float c,float d,Paint p){} public void drawArc(RectF r,float s,float w,boolean u,Paint p){}
 public void drawPath(Path pa,Paint p){} public void drawBitmap(int[] c,int o,int s,int x,int y,int w,int h,boolean a,Paint p){} public void drawBitmap(Bitmap b,float x,float y,Paint p){}
 public void drawBitmap(Bitmap b,Rect s,Rect d,Paint p){} public void drawText(String t,float x,float y,Paint p){} public void translate(float x,float y){} public void rotate(float d){} public void scale(float x,float y){}
 public void drawRoundRect(RectF r,float a,float b,Paint p){} public int getWidth(){return 0;} public int getHeight(){return 0;} }
