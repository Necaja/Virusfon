package engine;

/**
 * Экранные эффекты переходов: книга (инфо, диалоги с персонажами, магазин) и свиток (пауза).
 * Игра только сообщает {@link #start}; саму картинку и звук делает Android-часть (compat.BookFx),
 * по реальному времени, поэтому анимация идёт плавно независимо от шагов логики.
 */
public final class Fx {
   public static final int NONE = 0, BOOK = 1, SCROLL = 2, BOOK_CLOSE = 3, SCROLL_CLOSE = 4;
   public static final long BOOK_NS = 1000000000L, SCROLL_NS = 900000000L;

   /** Приёмник звука (ставит Android-часть). */
   public interface Sink {
      void play(int kind);
   }

   public static volatile Sink sink;
   public static volatile int kind;
   public static volatile long startNs;
   /** Выключатель (на будущее для настроек). */
   public static volatile boolean enabled = true;

   /** Показ строки диагностики (настройки → Отладка); сохранение делает Android-часть через onStats. */
   public static volatile boolean showStats = false;
   public static volatile Runnable onStats;

   public static void toggleStats() {
      showStats = !showStats;
      Runnable r = onStats;
      if (r != null) {
         r.run();
      }
   }

   private Fx() {
   }

   public static void start(int k, boolean sound) {
      if (!enabled) {
         return;
      }
      startNs = System.nanoTime();
      kind = k;
      Sink s = sink;
      if (sound && s != null) {
         try {
            s.play(k);
         } catch (Throwable ignored) {
         }
      }
   }

   public static boolean active(long now) {
      int k = kind;
      return k != NONE && now - startNs < ((k == BOOK || k == BOOK_CLOSE) ? BOOK_NS : SCROLL_NS);
   }
}
