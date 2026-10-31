package compat;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

/** Хост J2ME-MIDlet'а: main.cMIDlet (MIDlet-1 из исходного JAD/манифеста). */
public class GameActivity extends Activity {
   private MIDlet midlet;
   private GameView view;

   @Override
   protected void onCreate(Bundle b) {
      super.onCreate(b);
      getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
      Res.init(this);
      view = new GameView(this);
      setContentView(view);
      Display.setSurface(view);
      MIDlet.exitHook = new Runnable() {
         public void run() {
            runOnUiThread(new Runnable() {
               public void run() {
                  finish();
               }
            });
         }
      };
      midlet = new main.cMIDlet();
   }

   @Override
   protected void onResume() {
      super.onResume();
      hideSystemUi();
      midlet.hostStart();
   }

   @Override
   protected void onPause() {
      midlet.hostPause();
      super.onPause();
   }

   @Override
   protected void onDestroy() {
      Display.setSurface(null);
      MIDlet.exitHook = null;
      super.onDestroy();
   }

   @Override
   public void onWindowFocusChanged(boolean hasFocus) {
      super.onWindowFocusChanged(hasFocus);
      if (hasFocus) {
         hideSystemUi();
      }
   }

   @SuppressWarnings("deprecation")
   private void hideSystemUi() {
      view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
   }

   /** Аппаратные клавиши → J2ME key codes. BACK → правая софт-клавиша (-7). */
   private static int map(int keyCode) {
      switch (keyCode) {
         case KeyEvent.KEYCODE_DPAD_UP: return -1;
         case KeyEvent.KEYCODE_DPAD_DOWN: return -2;
         case KeyEvent.KEYCODE_DPAD_LEFT: return -3;
         case KeyEvent.KEYCODE_DPAD_RIGHT: return -4;
         case KeyEvent.KEYCODE_DPAD_CENTER:
         case KeyEvent.KEYCODE_ENTER: return -5;
         case KeyEvent.KEYCODE_MENU: return -6;
         case KeyEvent.KEYCODE_BACK: return -7;
         case KeyEvent.KEYCODE_STAR: return 42;
         case KeyEvent.KEYCODE_POUND: return 35;
         default:
            if (keyCode >= KeyEvent.KEYCODE_0 && keyCode <= KeyEvent.KEYCODE_9) {
               return 48 + (keyCode - KeyEvent.KEYCODE_0);
            }
            return 0;
      }
   }

   @Override
   public boolean onKeyDown(int keyCode, KeyEvent e) {
      int k = map(keyCode);
      if (k == 0) {
         return super.onKeyDown(keyCode, e);
      }
      if (e.getRepeatCount() == 0) {
         Display.key(true, k);
      }
      return true;
   }

   @Override
   public boolean onKeyUp(int keyCode, KeyEvent e) {
      int k = map(keyCode);
      if (k == 0) {
         return super.onKeyUp(keyCode, e);
      }
      Display.key(false, k);
      return true;
   }
}
