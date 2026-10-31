package javax.microedition.lcdui;

public abstract class Displayable {
   public int getWidth() {
      return Display.WIDTH;
   }

   public int getHeight() {
      return Display.HEIGHT;
   }

   protected void showNotify() {
   }

   protected void hideNotify() {
   }
}
