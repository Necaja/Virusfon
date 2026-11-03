package android.graphics;
public class Paint { public enum Style { FILL, STROKE } public enum Align { CENTER }
 public static class FontMetrics { public float ascent=-10, descent=3; }
 public void setAntiAlias(boolean b){} public void setFilterBitmap(boolean b){} public void setStrokeWidth(float f){} public void setColor(int c){} public void setStyle(Style s){}
 public void setTextSize(float f){} public void setTypeface(Typeface t){} public void setUnderlineText(boolean b){} public void setTextAlign(Align a){} public void setFakeBoldText(boolean b){}
 public FontMetrics getFontMetrics(){return new FontMetrics();} public float measureText(String s){return s.length()*7;} public float measureText(char[] c,int o,int l){return l*7;} public float measureText(String s,int a,int b){return (b-a)*7;}
 public float descent(){return 3;} public float ascent(){return -10;} }
