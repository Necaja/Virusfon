package engine;

import javax.microedition.lcdui.Font;

/** Общий шрифт игры (FACE_PROPORTIONAL, PLAIN, SMALL) и его высота. Константы интерфейса. */
public interface g {
   Font a = Font.getFont(64, 0, 8);
   short b = (short)a.getHeight();
}
