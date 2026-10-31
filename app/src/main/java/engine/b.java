package engine;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import javax.microedition.rms.RecordStore;

/**
 * Бывший SMS-биллинг (покупки бонусов за SMS). В исходной (русифицированной/крякнутой) версии
 * SMS не отправлялись: XConnection/XMessage были заглушками, а счётчик "отправленных" SMS
 * просто увеличивался. Здесь сохранено то же поведение без всяких javax.wireless.* зависимостей.
 * TODO(remake): заменить на нормальную внутриигровую валюту / IAP / награду за рекламу.
 */
public final class b implements Runnable {
   private static String b;
   private static String c;
   private static boolean d = false;
   private static int e;
   private static int f = 0;
   /** сколько "SMS" ещё осталось отправить / сколько уже отправлено (хранится в RMS) */
   public static int a = 0;

   /** Запустить "отправку" var1 сообщений. */
   public final void a(int var1, String var2, String var3) {
      if (!d) {
         d = true;
         f = var1;
         b = var2;
         c = var3;
         new Thread(this).start();
      }
   }

   public final void run() {
      for (int var1 = 0; var1 < f - 1; var1++) {
         if ((e = a(b, c)) != 0) {
            d = false;
            return;
         }
      }

      e = a(b, c);
      d = false;
   }

   /** true, пока идёт "отправка" */
   public static boolean a() {
      return d;
   }

   /** результат последней "отправки": 0 = успех */
   public static int b() {
      return e;
   }

   private static byte a(String number, String text) {
      a(++a);
      return 0;
   }

   /** прочитать счётчик из RMS ("shaolin2MessBank") */
   public static int c() {
      int var0 = 0;
      RecordStore var1 = null;

      try {
         var1 = RecordStore.openRecordStore("shaolin2MessBank", true);
         if (var1.getNumRecords() > 0) {
            byte[] var2 = var1.getRecord(1);
            DataInputStream var3 = new DataInputStream(new ByteArrayInputStream(var2));
            var0 = var3.readInt();
            var3.close();
         }
      } catch (Exception var4) {
      } finally {
         try {
            if (var1 != null) {
               var1.closeRecordStore();
            }
         } catch (Exception var5) {
         }
      }

      return var0;
   }

   /** записать счётчик в RMS */
   public static void a(int var0) {
      byte[] var1 = null;

      try {
         ByteArrayOutputStream var2 = new ByteArrayOutputStream();
         DataOutputStream var3 = new DataOutputStream(var2);
         var3.writeInt(var0);
         var1 = var2.toByteArray();
         var3.close();
      } catch (Exception var5) {
      }

      try {
         RecordStore var6 = RecordStore.openRecordStore("shaolin2MessBank", true);
         if (var6.getNumRecords() > 0) {
            var6.setRecord(1, var1, 0, var1.length);
         } else {
            var6.addRecord(var1, 0, var1.length);
         }

         var6.closeRecordStore();
      } catch (Exception var4) {
      }
   }
}
