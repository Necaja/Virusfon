package engine;

import javax.microedition.lcdui.Display;

/**
 * Широкоэкранный режим. Исходная игра рассчитана на 240x320. Теперь кадр шире: игра по-прежнему
 * верстает всё в центральной области 240 px, а мир (карта, фон, спрайты, враги) дорисовывается
 * по бокам на {@link #extra()} пикселей слева и справа.
 */
public final class View {
   private View() {
   }

   /** Сколько пикселей мира видно слева и справа от исходной области 240x320. */
   public static int extra() {
      return Display.extra();
   }

   /** Правая граница видимой области относительно левой границы центральной области (240 + extra). */
   public static int right() {
      return 240 + Display.extra();
   }

   /** Полная логическая ширина кадра. */
   public static int width() {
      return Display.logicalWidth();
   }
}
