package com.nokia.mid.ui;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class DirectGraphics {
   public static final int FLIP_HORIZONTAL = 0x2000, FLIP_VERTICAL = 0x4000;
   public static final int ROTATE_90 = 90, ROTATE_180 = 180, ROTATE_270 = 270;

   private final Graphics g;

   DirectGraphics(Graphics g) {
      this.g = g;
   }

   public void drawImage(Image img, int x, int y, int anchor, int manipulation) {
      g.drawImageManip(img, x, y, anchor, manipulation);
   }

   public void fillTriangle(int x1, int y1, int x2, int y2, int x3, int y3, int argb) {
      g.setColor(argb & 0xFFFFFF);
      g.fillTriangle(x1, y1, x2, y2, x3, y3);
   }
}
