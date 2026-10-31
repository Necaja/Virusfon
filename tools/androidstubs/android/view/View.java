package android.view;
public class View { public static final int SYSTEM_UI_FLAG_LAYOUT_STABLE=1, SYSTEM_UI_FLAG_HIDE_NAVIGATION=2, SYSTEM_UI_FLAG_FULLSCREEN=4, SYSTEM_UI_FLAG_IMMERSIVE_STICKY=8;
 public View(android.content.Context c){} protected void onSizeChanged(int w,int h,int ow,int oh){} public void setFocusable(boolean b){} public void setFocusableInTouchMode(boolean b){} public boolean onTouchEvent(MotionEvent e){return false;} public void setSystemUiVisibility(int v){} }
