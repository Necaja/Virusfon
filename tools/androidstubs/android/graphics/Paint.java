package android.graphics;
public class Paint { public enum Style { FILL, STROKE } public enum Align { CENTER }
 public static class FontMetrics { public float ascent, descent; }
 public void setAntiAlias(boolean b){} public void setFilterBitmap(boolean b){} public void setStrokeWidth(float f){} public void setColor(int c){} public void setStyle(Style s){}
 public void setTextSize(float f){} public void setTypeface(Typeface t){} public void setUnderlineText(boolean b){} public void setTextAlign(Align a){} public float getTextSize(){return 0;} public void setFakeBoldText(boolean b){}
 public FontMetrics getFontMetrics(){return null;} public float measureText(String s){return 0;} public float measureText(char[] c,int o,int l){return 0;} public float measureText(String s,int a,int b){return 0;}
 public float descent(){return 0;} public float ascent(){return 0;} }
