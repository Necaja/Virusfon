package android.app;
public class Activity extends android.content.Context { protected void onCreate(android.os.Bundle b){} protected void onResume(){} protected void onPause(){} protected void onDestroy(){} public void onWindowFocusChanged(boolean h){}
 public android.view.Window getWindow(){return null;} public void setContentView(android.view.View v){} public void runOnUiThread(Runnable r){} public void finish(){}
 public boolean onKeyDown(int k, android.view.KeyEvent e){return false;} public boolean onKeyUp(int k, android.view.KeyEvent e){return false;}
 public android.content.res.AssetManager getAssets(){return null;} public java.io.File getFilesDir(){return null;} public java.io.File getCacheDir(){return null;} public android.content.Context getApplicationContext(){return this;} }
