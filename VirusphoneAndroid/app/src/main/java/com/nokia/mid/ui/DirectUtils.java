package com.nokia.mid.ui;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class DirectUtils {
   private DirectUtils() {
   }

   public static DirectGraphics getDirectGraphics(Graphics g) {
      return new DirectGraphics(g);
   }

   public static Image createImage(int w, int h, int argb) {
      Image im = Image.createImage(w, h);
      im.getBitmap().eraseColor(argb);
      return im;
   }
}
