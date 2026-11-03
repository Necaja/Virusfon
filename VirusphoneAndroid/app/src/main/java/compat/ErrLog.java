package compat;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Перехват System.err (игра печатает туда исключения через printStackTrace) и необработанных
 * исключений потоков. Первые строки хранятся и рисуются поверх игры — удобно для отладки без ПК.
 */
public final class ErrLog {
   private static final List<String> LINES = new ArrayList<String>();
   private static final int MAX = 14;
   private static final StringBuilder cur = new StringBuilder();

   private ErrLog() {
   }

   public static synchronized List<String> snapshot() {
      return new ArrayList<String>(LINES);
   }

   private static synchronized void add(String s) {
      if (LINES.size() < MAX) {
         LINES.add(s.length() > 70 ? s.substring(0, 70) : s);
      }
   }

   public static void install() {
      final PrintStream orig = System.err;
      System.setErr(new PrintStream(new OutputStream() {
         @Override
         public void write(int b) {
            orig.write(b);
            if (b == '\n') {
               String s = cur.toString().trim();
               cur.setLength(0);
               if (s.length() > 0) {
                  add(s);
               }
            } else if (b != '\r') {
               cur.append((char) (b & 0xFF));
            }
         }
      }, true));
      final Thread.UncaughtExceptionHandler old = Thread.getDefaultUncaughtExceptionHandler();
      Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
         public void uncaughtException(Thread t, Throwable e) {
            add("CRASH " + t.getName() + ": " + e);
            for (StackTraceElement el : e.getStackTrace()) {
               add("  at " + el);
            }
            if (old != null) {
               old.uncaughtException(t, e);
            }
         }
      });
   }
}
