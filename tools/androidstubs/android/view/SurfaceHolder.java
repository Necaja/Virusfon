package android.view;
public interface SurfaceHolder { interface Callback { void surfaceCreated(SurfaceHolder h); void surfaceChanged(SurfaceHolder h,int f,int w,int hh); void surfaceDestroyed(SurfaceHolder h);} void addCallback(Callback c); android.graphics.Canvas lockCanvas(); android.graphics.Canvas lockHardwareCanvas(); void unlockCanvasAndPost(android.graphics.Canvas c); }
