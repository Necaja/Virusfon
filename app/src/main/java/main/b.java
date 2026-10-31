package main;

import engine.g;
import engine.h;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import javax.microedition.rms.RecordStore;

public final class b {
   private static String[] a = new String[]{
      "Нужны как воздух всегда к оплате пригоршни денег, а ты растратил. А может просто не заработал. Держи, дружище, отдашь в субботу. Лет через двести, когда ты станешь миллионером",
      "Над сундуками враги трясутся. Мы увеличим прирост ресурса. Забрать добычу готовьтесь сами, единолично",
      "Ты хочешь статус себе отличный, чтоб выбор был твой неограничен? Откроет доступ ко всем названьям в карьерном росте",
      "Монахи в Храме пробили полночь. Эй, что с Русланом? Скорей на помощь! Бальзам на шрамы прольется песней. Тсс... Дышит сам он. Руслан, воскресни! На пять минут лишь враг тише станет. Успеешь? Тут уж",
      "Разбито сердце? Душа разбита? У вас всего лишь нехватка крита! Мы вам бесплатно сдадим в аренду крит 100 процентов. Аплодисменты! Атака вдвое сильнее станет. Ну что, довольны?",
      "Ты был отважным, ты был бесстрашным. Проверить важно, что будет дальше? Вдохнули глубже, прямее плечи. Наш forum.fonzo все раны лечит. Зажми монету, Руслан, в кармане. Стрелой по свету"
   };
   private static int[] b = new int[]{1, 1, 1, 1, 1, 2};
   private static int[] c = new int[]{-1, 1, 1, -1, 1, 1};
   private static int d = 0;
   private static int e = 0;
   private static boolean f = false;
   private static engine.b g = new engine.b();
   private static String[] h = new String[]{"06", "03", "04", "02", "10", "01"};

   public static void a(int var0) {
      engine.d.a(false);
      d = var0;
      f = true;
   }

   public static boolean a() {
      if (f) {
         engine.h.a(main.f.g, 536648);
         label77:
         switch (e) {
            case 0:
            case 1:
               if (c[d] != 0) {
                  Object var2 = null;
                  a(a[d] + ".", 240, 150, 85);
                  if (engine.d.c() && !engine.d.f()) {
                     engine.d.a(main.f.g, "Да", "Нет");
                     if (e == 1) {
                        if (main.f.d(49184)) {
                           engine.b.a = engine.b.c();
                           if (b[d] - engine.b.a <= 0) {
                              e = 3;
                           } else {
                              var2 = "106610989";
                              String var1 = "6200301yhuo001,"
                                 + cMIDlet.a.getAppProperty("GameID")
                                 + ","
                                 + cMIDlet.a.getAppProperty("Code")
                                 + ","
                                 + "0001,"
                                 + cMIDlet.a.getAppProperty("Term")
                                 + ","
                                 + h[d];
                              g.a(b[d] - engine.b.a, (String)var2, var1);
                              e = 2;
                           }

                           engine.d.a(false);
                        } else if (main.f.d(65536)) {
                           e = 5;
                           return f;
                        }

                        return f;
                     } else {
                        e = 1;
                        return f;
                     }
                  }

                  return f;
               }

               a("Эта функция включена", 240, 150, 85);
               if (!engine.d.c()) {
                  return f;
               }
               break;
            case 2:
               a("Отправка мани ...", 240, 150, 85);
               if (engine.d.c() && !engine.b.a()) {
                  engine.d.a(false);
                  if (engine.b.b() == 0) {
                     e = 3;
                  } else {
                     e = 4;
                  }

                  return f;
               }

               return f;
            case 3:
               a("Успех оплаты. Вперед, ребята!", 240, 150, 85);
               if (!engine.d.c()) {
                  return f;
               }

               switch (d) {
                  case 0:
                     main.f.a(20000);
                     main.f.a("Получено 20000 золота");
                     main.e.a(53, 2);
                     break;
                  case 1:
                     main.e.U = true;
                     break;
                  case 2:
                     for (int var0 = 0; var0 < main.e.k.length; var0++) {
                        main.e.a(var0);
                     }
                     break;
                  case 3:
                     main.e.L = main.e.i();
                     main.e.M = main.e.h();
                     main.f.H = 30000;
                     break;
                  case 4:
                     main.e.V = true;
                     break;
                  case 5:
                     main.e.W = true;
                     main.f.a(5000);
                     main.e.a(53, 3);
               }

               engine.b.a(engine.b.a = engine.b.a - b[d]);
               if (c[d] > 0) {
                  c[d]--;
               }

               c();
               break;
            case 4:
               a("Забыли деньги? Не огорчайтесь. Чуть отдохните и возвращайтесь!", 240, 150, 85);
               if (engine.d.c()) {
                  e = 0;
                  engine.d.a(false);
               }

               return f;
            case 5:
               if (engine.d.c()) {
                  switch (d) {
                     case 5:
                        cMIDlet.b.f();
                     default:
                        break label77;
                  }
               }

               return f;
            default:
               return f;
         }

         e = 0;
         f = false;
         engine.d.a(false);
      }

      return f;
   }

   private static void c() {
      byte[] var0 = null;

      try {
         ByteArrayOutputStream var1 = new ByteArrayOutputStream();
         DataOutputStream var2 = new DataOutputStream(var1);

         for (int var3 = 0; var3 < c.length; var3++) {
            var2.writeInt(c[var3]);
         }

         var2.writeBoolean(main.e.U);
         var2.writeBoolean(main.e.V);
         var2.writeBoolean(main.e.W);
         var0 = var1.toByteArray();
         var1.close();
         var2.close();
      } catch (Exception var5) {
      }

      try {
         RecordStore var6;
         if ((var6 = RecordStore.openRecordStore("buylike", true)).getNumRecords() > 0) {
            var6.setRecord(1, var0, 0, var0.length);
         } else {
            var6.addRecord(var0, 0, var0.length);
         }

         var6.closeRecordStore();
      } catch (Exception var4) {
      }
   }

   public static void b() {
      RecordStore var0 = null;

      try {
         if ((var0 = RecordStore.openRecordStore("buylike", true)).getNumRecords() > 0) {
            byte[] var1 = var0.getRecord(1);
            ByteArrayInputStream var6 = new ByteArrayInputStream(var1);
            DataInputStream var2 = new DataInputStream(var6);

            for (int var3 = 0; var3 < c.length; var3++) {
               c[var3] = var2.readInt();
            }

            main.e.U = var2.readBoolean();
            main.e.V = var2.readBoolean();
            main.e.W = var2.readBoolean();
            var6.close();
            var2.close();
         }

         var0.closeRecordStore();
      } catch (Exception var4) {
         System.out.println(var4.toString());
      }
   }

   private static void a(String var0, int var1, int var2, int var3) {
      engine.h.a(main.f.g, 0, 85, 240, 150, 4263240, 16706981);
      engine.h.a(main.f.g, 1, 86, 238, 148, 16706981, 9207808);
      engine.d.a(main.f.g, var0, 15597476, 240 - (238 - engine.g.a.stringWidth("вводить")) + 4 >> 1, 91, 240 - engine.g.a.stringWidth("вводить"), 142);
      if (main.f.d(51488)) {
         if (!engine.d.c()) {
            engine.d.b();
            return;
         }

         if (!engine.d.d()) {
            main.f.L = false;
            return;
         }
      } else if (main.f.d(1028)) {
         if (engine.d.c()) {
            engine.d.e();
            return;
         }

         engine.d.b();
      }
   }
}
