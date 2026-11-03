package javax.microedition.lcdui;

public abstract class Canvas extends Displayable {
   public static final int UP = 1, LEFT = 2, RIGHT = 5, DOWN = 6, FIRE = 8;
   public static final int GAME_A = 9, GAME_B = 10, GAME_C = 11, GAME_D = 12;
   public static final int KEY_NUM0 = 48, KEY_NUM1 = 49, KEY_NUM2 = 50, KEY_NUM3 = 51, KEY_NUM4 = 52;
   public static final int KEY_NUM5 = 53, KEY_NUM6 = 54, KEY_NUM7 = 55, KEY_NUM8 = 56, KEY_NUM9 = 57;
   public static final int KEY_STAR = 42, KEY_POUND = 35;

   protected Canvas() {
   }

   protected abstract void paint(Graphics g);

   public final void repaint() {
      Display.requestRepaint();
   }

   public final void repaint(int x, int y, int w, int h) {
      Display.requestRepaint();
   }

   public final void serviceRepaints() {
      Display.renderNow();
   }

   public void setFullScreenMode(boolean mode) {
   }

   public boolean isDoubleBuffered() {
      return true;
   }

   protected void keyPressed(int keyCode) {
   }

   protected void keyReleased(int keyCode) {
   }

   protected void keyRepeated(int keyCode) {
   }

   protected void pointerPressed(int x, int y) {
   }

   protected void pointerReleased(int x, int y) {
   }

   protected void pointerDragged(int x, int y) {
   }

   public int getGameAction(int keyCode) {
      switch (keyCode) {
         case -1: return UP;
         case -2: return DOWN;
         case -3: return LEFT;
         case -4: return RIGHT;
         case -5: return FIRE;
         default: return 0;
      }
   }

   public int getKeyCode(int gameAction) {
      switch (gameAction) {
         case UP: return -1;
         case DOWN: return -2;
         case LEFT: return -3;
         case RIGHT: return -4;
         case FIRE: return -5;
         default: return 0;
      }
   }

   // --- вызовы со стороны Android-хоста (пакетно-публичные обёртки над protected-методами) ---
   public final void hostKey(boolean down, int keyCode) {
      if (down) {
         keyPressed(keyCode);
      } else {
         keyReleased(keyCode);
      }
   }

   final void hostPaint(Graphics g) {
      paint(g);
   }

   final void hostShow() {
      showNotify();
   }

   final void hostHide() {
      hideNotify();
   }
}
