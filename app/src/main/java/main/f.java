package main;

import engine.g;
import engine.h;
import com.nokia.mid.ui.DirectGraphics;
import com.nokia.mid.ui.DirectUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;

public final class f extends Canvas implements g, Runnable {
   private static f Z;
   private static b aa = new b();
   private engine.f ab = new engine.f();
   private static a ac = new a();
   public static int c;
   public static int d;
   public static boolean e;
   private static int ad;
   public static int f;
   private static int ae = 1;
   public static Graphics g;
   public static DirectGraphics h;
   private static int af;
   public static int i;
   public static int j;
   private static int ag;
   private static int ah;
   public static int k = 1;
   public static boolean l;
   private static boolean ai;
   public static Image[] m = new Image[5];
   private Image aj;
   private Image ak;
   private Image al;
   private Image am;
   private Image an;
   private Image ao;
   private Image ap;
   private Image aq;
   private Image ar;
   public static Image n;
   private static Image as;
   public static Image[] o = new Image[2];
   public static Image p;
   private static Image at;
   private static Image au;
   private static Image av;
   private static Image aw;
   private static Image ax;
   public static Image[] q = new Image[14];
   public static Image r;
   public static Image s;
   public static Image t;
   public static Image u;
   public static Image[] v = new Image[10];
   private static Image[] ay = new Image[10];
   private static Image az;
   private static Image aA;
   private static Image aB;
   private static Image aC;
   public static Image w;
   public static Image x;
   public static Image y;
   public static Image[] z = new Image[7];
   public static Image A;
   public static Image B;
   public static boolean C = false;
   public static boolean D = false;
   public static boolean E = false;
   private static String aD = "";
   private static int aE;
   private static int[] aF = new int[]{39, 1, 2, 3, 4, 5, 35, 36};
   static boolean F = false;
   static boolean G = true;
   static int H;
   static boolean I = false;
   private static int aG;
   static int J = 0;
   private static int[] aH;
   private static int aI;
   private static int aJ;
   private static int aK;
   private long aL;
   private static int aM;
   public static int K;
   private static boolean aN = true;
   private static byte aO;
   public static boolean L = false;
   private static boolean aP = false;
   private static boolean aQ = false;
   public static boolean M = false;
   public static boolean N;
   private int aR;
   private int aS;
   private String[] aT;
   private int aU;
   private byte[] aV;
   static int O = 0;
   private String aW;
   static boolean P = false;
   private static byte[] aX;
   private static boolean aY = false;
   private int aZ;
   private int ba;
   static int Q = 4;
   public static String[] R = new String[]{
      "Fonzo Team ", "Лес Минга ", "Злой рок ", "Капец ", "Демон-Хилл ", "Туманы ", "Мир Хаоса ", "Снега ", "Ледовый дворец "
   };
   private int[] bb;
   private int[] bc;
   private int[] bd;
   static byte[] S = new byte[]{0, 10, 10, 10, 10, 10, 10, 10, 10};
   static boolean T = false;
   private static String[] be = new String[]{null, null, null, null, null, null, null, null, null, null};
   private String[] bf;
   private String[] bg;
   static boolean U = false;
   static int V = -1;
   private int bh;
   private String[] bi;
   private int bj;
   private byte bk;
   private int[] bl;
   private String[] bm;
   private byte bn;
   private int bo;
   private int bp;
   private int bq;
   private String[] br;
   private static String bs;
   private static int bt = 0;
   private boolean[] bu;
   private int bv;
   private static String[] bw = new String[]{"Возобновить ", "Главное меню ", "Звук ", "Инструкции ", "Выход "};
   private static boolean bx;
   private int by;
   private byte bz;
   private boolean bA;
   public static boolean W = false;
   private int bB;
   private int bC;
   private static int[] bD = new int[]{0, 0, 0, 0};
   private static int bE = 0;
   private String[] bF;
   private int bG;
   private int bH;
   private static int[][] bI = new int[10][2];
   private static String[] bJ = new String[]{null, null, null, null, null, null, null, null, null, null};
   private static int bK;
   /** Для сенсорного интерфейса: {слот1, слот3, слот7, слот9, перезарядка1, перезарядка2, уровень меча (0..2)}. */
   /** Иконка текущего оружия (меч со шлейфом) для кнопки атаки; null, пока не построена. */
   public static Image uiWeaponIcon() {
      return main.d.uiIcon;
   }

   public static int[] uiState() {
      int tier = main.e.I / 4;
      return new int[]{main.e.s, main.e.t, main.e.q, main.e.r, X, Y, Math.max(0, Math.min(2, tier))};
   }

   public static int X = 0;
   public static int Y = 0;
   private int bL;
   private static int bM;
   private String[] bN;
   private int bO;
   private int bP;
   private static int bQ;
   private static int bR;
   private static int bS;
   private static String[] bT;
   private boolean bU;
   private int tipT;
   private String[] tipLines = new String[0];
   private int bV;

   static void a(int var0) {
      if ((aG += var0) >= 10000) {
         main.e.a(4);
      }

      if (aG >= 100000) {
         main.e.a(5);
      }
   }

   public f() {
      new e();
      String[] var10000 = new String[]{
         "Выйти? ", "Новая игра ", "Продолжить игру ", "Вызов режима ", "Коды игры ", "Настройки ", "Инструкции ", "Об игре ", "Выход "
      };
      this.aT = new String[]{
         "Желаем приятной игры ",
         "Желаем приятной игры ",
         "Оставайтесь с нами ",
         "Оставайтесь с нами ",
         "Мечты в реальность ",
         "Мы работаем для вас ",
         "Желаем приятной игры",
         "Оставайтесь с нами ",
         "Мечты в реальность ",
         "Без звука более быстрая игра ",
         "Перевод от Fonzo Team ",
         "Лучшие игры для вас ",
         "Удача - больше сокровищ "
      };
      this.aU = 0;
      this.aV = new byte[]{1, 2, 3, 5, 5, 6, 7, 8};
      this.aW = "shanhaiyouxia";
      this.aZ = 0;
      this.ba = 0;
      this.bb = new int[]{107, 134, 164, 109, 155, 26, 174, 223, 117, 228, 28, 232, 14, 131, 52, 59, 19, 23};
      this.bc = new int[]{8, 7, 2, 6, 0, 1, 5, 4, 3};
      this.bd = new int[]{0, 101, 201, 301, 205, 401, 105, 501, 601};
      this.bh = 0;
      this.bi = new String[]{"Читы ", "Герой ", "Вещи ", "Реквизит ", "Магия ", "Синтез ", "Задача "};
      this.bj = 0;
      this.bk = 0;
      this.bl = new int[]{1000, 2000, 10000, 15000, 3000, 3000, 5000};
      this.bm = new String[]{
         "Стоимость лотерейного билета 1000 золотых, 100% выигрыш",
         "Немедленно возвращает в деревню ",
         "Атакует всех врагов ударами с неба",
         "Перенесет вас в любую точку на локации ",
         "Атака +5, постоянный прогресс ",
         "Защита +5, постоянный прогресс ",
         "Защита +4, крит +3, постоянный прогресс "
      };
      this.bn = 0;
      this.bo = 0;
      this.bp = 0;
      this.bq = 0;
      this.br = new String[]{"", "Синтез зелий ", "Синтез мечей ", "Синтез шлема ", "Синтез брони ", "Синтез колец "};
      this.bu = new boolean[]{false, false, false};
      this.bv = 0;
      this.by = 0;
      this.bz = 0;
      this.bB = 0;
      this.bC = 0;
      this.bF = new String[]{
         "Инфо - сведения о герое ",
         "virusfon навсегда ",
         "Etty - ковка и оружие ",
         "Телепорт сэкономит время ",
         "Синтез - высокое качество ",
         "Переводы Fonzo Team ",
         "Магазин - выгодные цены ",
         "Инфо - материалы и вещи ",
         "Инфо - сведения о задаче "
      };
      this.bG = 0;
      this.bH = 0;
      this.bL = 0;
      this.bN = new String[]{"Игра ", "Помощь ", "Настройки ", "Инструкции ", "Об игре ", "Выход "};
      this.bO = 0;
      this.bP = 0;
      this.bU = false;
      var10000 = new String[]{"Амитабха ... ... то делать? ", "Обновление оружия облегчит испытания ", "Инфо - изменить статус ", "Уроки переводов "};
      this.bV = 0;
      this.setFullScreenMode(true);
      this.setFullScreenMode(true);
      Z = this;
      this.ab.b("menu", true, 1);
   }

   private void j() {
      try {
         this.c(false);

         for (int var1 = 0; var1 < ay.length; var1++) {
            if (var1 != 1 && ay[var1] == null) {
               a(var1, "/splash" + var1 + ".png");
            }
         }

         if (aw == null) {
            aw = Image.createImage("/weapsmllicon.png");
         }

         if (au == null) {
            au = Image.createImage("/point.png");
         }

         if (as == null) {
            as = Image.createImage("/num.png");
         }

         if (this.ar == null) {
            this.ar = Image.createImage("/money.png");
         }

         if (av == null) {
            av = Image.createImage("/kuang1.png");
         }

         if (at == null) {
            at = Image.createImage("/tash.png");
         }

         if (this.am == null) {
            this.am = Image.createImage("/cool2.png");
         }

         if (this.ap == null) {
            this.ap = Image.createImage("/head0.png");
         }
      } catch (Exception var2) {
      }
   }

   private void g(int var1) {
      try {
         if (aC == null) {
            aC = Image.createImage("/dalog.png");
         }

         if (t == null) {
            t = Image.createImage("/ceo.png");
         }

         if (this.an == null) {
            this.an = Image.createImage("/res.png");
         }

         if (this.ao == null) {
            this.ao = Image.createImage("/key.png");
         }

         if (this.al == null) {
            this.al = Image.createImage("/cool.png");
         }

         if (m[0] == null) {
            m[0] = Image.createImage("/zhujiao1.png");
         }

         int var2 = main.e.I / 4 + 1;
         if (m[var2] == null) {
            m[var2] = Image.createImage("/zhujiao" + (var2 + 1) + ".png");
         }

         if (m[4] == null) {
            m[4] = Image.createImage("/zhujiao5.png");
         }

         if (aC == null) {
            aC = Image.createImage("/dalog.png");
         }

         if (y == null) {
            y = Image.createImage("/die.png");
         }

         if (r == null) {
            r = Image.createImage("/magicdoor.png");
         }

         if (n == null) {
            n = Image.createImage("/attackpro.png");
         }

         if (o[0] == null) {
            o[0] = Image.createImage("/num2.png");
         }

         if (o[1] == null) {
            o[1] = Image.createImage("/num3.png");
         }

         if (p == null) {
            p = Image.createImage("/numflash.png");
         }

         if (B == null) {
            B = Image.createImage("/keyhelp.png");
         }

         if (K == 702) {
            engine.c.a("/level" + (K / 100 + 1) + "_tile.png", "/level" + (K / 100 + 1) + "_0_tile.png", "/map9.png");
         } else {
            engine.c.a("/level" + (K / 100 + 1) + "_tile.png", "/level" + (K / 100 + 1) + "_0_tile.png", "/map" + this.aV[K / 100] + ".png");
         }

         switch (var1) {
            case 0:
               if (w == null) {
                  w = Image.createImage("/save.png");
               }

               for (int var6 = 0; var6 < 9; var6++) {
                  if (q[var6] == null) {
                     q[var6] = Image.createImage("/npc" + (var6 + 1) + ".png");
                  }
               }

               return;
            case 4:
               if (ax == null) {
                  ax = Image.createImage("/bossBlood.png");
               }
               break;
            case 101:
               if (v[4] == null) {
                  v[4] = Image.createImage("/enemy5.png");
               }

               if (v[7] == null) {
                  v[7] = Image.createImage("/enemy8.png");
                  return;
               }
               break;
            case 102:
               if (v[1] == null) {
                  v[1] = Image.createImage("/enemy2.png");
               }

               if (v[4] == null) {
                  v[4] = Image.createImage("/enemy5.png");
               }

               if (v[7] == null) {
                  v[7] = Image.createImage("/enemy8.png");
                  return;
               }
               break;
            case 103:
               if (v[4] == null) {
                  v[4] = Image.createImage("/enemy5.png");
               }

               if (v[1] == null) {
                  v[1] = Image.createImage("/enemy2.png");
               }

               if (w == null) {
                  w = Image.createImage("/save.png");
                  return;
               }
               break;
            case 104:
               if (v[6] == null) {
                  v[6] = Image.createImage("/enemy7.png");
               }

               if (z[3] == null) {
                  z[3] = Image.createImage("/boss4.png");
                  return;
               }
               break;
            case 105:
            case 106:
            case 107:
               if (w == null) {
                  w = Image.createImage("/save.png");
               }

               if (x == null) {
                  x = Image.createImage("/dici.png");
               }

               if (v[0] == null) {
                  v[0] = Image.createImage("/enemy1.png");
               }

               if (v[8] == null) {
                  v[8] = Image.createImage("/enemy9.png");
                  return;
               }
               break;
            case 108:
               if (z[3] == null) {
                  z[3] = Image.createImage("/boss4.png");
               }

               if (q[1] == null) {
                  q[1] = Image.createImage("/npc2.png");
                  return;
               }
               break;
            case 201:
               if (v[5] == null) {
                  v[5] = Image.createImage("/enemy6.png");
               }

               if (v[9] == null) {
                  v[9] = Image.createImage("/enemy10.png");
                  return;
               }
               break;
            case 202:
               if (v[1] == null) {
                  v[1] = Image.createImage("/enemy2.png");
               }

               if (v[5] == null) {
                  v[5] = Image.createImage("/enemy6.png");
               }

               if (v[9] == null) {
                  v[9] = Image.createImage("/enemy10.png");
                  return;
               }
               break;
            case 203:
               if (v[1] == null) {
                  v[1] = Image.createImage("/enemy2.png");
               }

               if (v[5] == null) {
                  v[5] = Image.createImage("/enemy6.png");
               }

               if (w == null) {
                  w = Image.createImage("/save.png");
                  return;
               }
               break;
            case 204:
               if (v[3] == null) {
                  v[3] = Image.createImage("/enemy4.png");
                  return;
               }
               break;
            case 205:
               if (x == null) {
                  x = Image.createImage("/dici.png");
               }

               if (v[2] == null) {
                  v[2] = Image.createImage("/enemy3.png");
               }

               if (v[5] == null) {
                  v[5] = Image.createImage("/enemy6.png");
                  return;
               }
               break;
            case 206:
            case 207:
               if (w == null) {
                  w = Image.createImage("/save.png");
               }

               if (x == null) {
                  x = Image.createImage("/dici.png");
               }

               if (v[1] == null) {
                  v[1] = Image.createImage("/enemy2.png");
               }

               if (v[2] == null) {
                  v[2] = Image.createImage("/enemy3.png");
               }

               if (v[5] == null) {
                  v[5] = Image.createImage("/enemy6.png");
                  return;
               }
               break;
            case 208:
               if (z[1] == null) {
                  z[1] = Image.createImage("/boss2.png");
               }

               if (z[3] == null) {
                  z[3] = Image.createImage("/boss4.png");
                  return;
               }
               break;
            case 301:
            case 302:
            case 303:
               if (w == null) {
                  w = Image.createImage("/save.png");
               }

               if (x == null) {
                  x = Image.createImage("/dici.png");
               }

               if (v[1] == null) {
                  v[1] = Image.createImage("/enemy2.png");
               }

               if (v[9] == null) {
                  v[9] = Image.createImage("/enemy10.png");
                  return;
               }
               break;
            case 304:
               if (z[0] == null) {
                  z[0] = Image.createImage("/boss1.png");
               }

               if (z[3] == null) {
                  z[3] = Image.createImage("/boss4.png");
                  return;
               }
               break;
            case 401:
               if (x == null) {
                  x = Image.createImage("/dici.png");
               }

               if (v[2] == null) {
                  v[2] = Image.createImage("/enemy3.png");
               }

               if (v[4] == null) {
                  v[4] = Image.createImage("/enemy5.png");
                  return;
               }
               break;
            case 402:
            case 403:
               if (w == null) {
                  w = Image.createImage("/save.png");
               }

               if (x == null) {
                  x = Image.createImage("/dici.png");
               }

               if (v[2] == null) {
                  v[2] = Image.createImage("/enemy3.png");
               }

               if (v[4] == null) {
                  v[4] = Image.createImage("/enemy5.png");
               }

               if (v[3] == null) {
                  v[3] = Image.createImage("/enemy4.png");
                  return;
               }
               break;
            case 404:
               if (z[2] == null) {
                  z[2] = Image.createImage("/boss3.png");
               }

               if (q[0] == null) {
                  q[0] = Image.createImage("/story2.png");
                  return;
               }
               break;
            case 501:
               if (w == null) {
                  w = Image.createImage("/save.png");
               }

               if (q[12] == null) {
                  q[12] = Image.createImage("/npc13.png");
               }

               if (q[13] == null) {
                  q[13] = Image.createImage("/npc14.png");
               }

               if (s == null) {
                  s = Image.createImage("/door.png");
                  return;
               }
               break;
            case 502:
            case 503:
            case 504:
               if (x == null) {
                  x = Image.createImage("/dici.png");
               }

               if (v[0] == null) {
                  v[0] = Image.createImage("/enemy1.png");
                  return;
               }
               break;
            case 505:
               if (z[4] == null) {
                  z[4] = Image.createImage("/boss5.png");
                  return;
               }
               break;
            case 601:
               for (int var5 = 9; var5 < 12; var5++) {
                  if (q[var5] == null) {
                     q[var5] = Image.createImage("/npc" + (var5 + 1) + ".png");
                  }
               }

               if (w == null) {
                  w = Image.createImage("/save.png");
                  return;
               }
               break;
            case 602:
               if (x == null) {
                  x = Image.createImage("/dici.png");
               }

               if (v[3] == null) {
                  v[3] = Image.createImage("/enemy4.png");
               }

               if (v[6] == null) {
                  v[6] = Image.createImage("/enemy7.png");
                  return;
               }
               break;
            case 603:
               if (x == null) {
                  x = Image.createImage("/dici.png");
               }

               if (v[3] == null) {
                  v[3] = Image.createImage("/enemy4.png");
               }

               if (v[6] == null) {
                  v[6] = Image.createImage("/enemy7.png");
               }

               if (v[9] == null) {
                  v[9] = Image.createImage("/enemy10.png");
                  return;
               }
               break;
            case 604:
            case 605:
               if (x == null) {
                  x = Image.createImage("/dici.png");
               }

               if (v[6] == null) {
                  v[6] = Image.createImage("/enemy7.png");
               }

               if (v[9] == null) {
                  v[9] = Image.createImage("/enemy10.png");
                  return;
               }
               break;
            case 606:
               if (z[4] == null) {
                  z[4] = Image.createImage("/boss5.png");
                  return;
               }
               break;
            case 607:
               if (z[4] == null) {
                  z[4] = Image.createImage("/boss5.png");
                  return;
               }
               break;
            case 608:
               if (z[5] == null) {
                  z[5] = Image.createImage("/boss6.png");
                  return;
               }
               break;
            case 609:
               if (z[6] == null) {
                  z[6] = Image.createImage("/boss7.png");
               }

               if (q[0] == null) {
                  q[0] = Image.createImage("/story2.png");
               }

               if (q[1] == null) {
                  q[1] = Image.createImage("/npc2.png");
                  return;
               }
               break;
            case 610:
               for (int var4 = 0; var4 < 8; var4++) {
                  if (var4 != 3 && q[var4] == null) {
                     q[var4] = Image.createImage("/npc" + (var4 + 1) + ".png");
                  }
               }

               return;
            case 701:
               if (u == null) {
                  u = Image.createImage("/story1.png");
               }

               if (v[0] == null) {
                  v[0] = Image.createImage("/enemy1.png");
                  return;
               }
               break;
            case 702:
               if (u == null) {
                  u = Image.createImage("/story1.png");
               }

               if (A == null) {
                  A = Image.createImage("/star.png");
                  return;
               }
         }
      } catch (Exception var3) {
      }
   }

   private void c(boolean var1) {
      m[0] = null;
      m[1] = null;
      m[2] = null;
      m[3] = null;
      m[4] = null;
      w = null;
      x = null;
      o[0] = null;
      o[1] = null;
      this.al = null;
      this.am = null;
      this.ap = null;
      this.ar = null;
      t = null;
      au = null;

      for (int var2 = 0; var2 < q.length; var2++) {
         q[var2] = null;
      }

      for (int var3 = 0; var3 < v.length; var3++) {
         v[var3] = null;
      }

      for (int var4 = 0; var4 < z.length; var4++) {
         z[var4] = null;
      }

      u = null;
      this.aj = null;
      this.ak = null;
      as = null;

      for (int var5 = 0; var5 < ay.length; var5++) {
         ay[var5] = null;
      }

      aC = null;
      B = null;
      at = null;
      aw = null;
      this.an = null;
      this.ao = null;
      av = null;
      y = null;
      r = null;
      n = null;
      p = null;
      if (var1) {
         main.a.a();
      } else {
         for (int var6 = 0; var6 < main.a.e.length; var6++) {
            main.a.e[var6].a = null;
         }
      }

      engine.c.a();
      System.gc();
   }

   private static boolean a(int var0, String var1) {
      try {
         ay[var0] = Image.createImage(var1);
         return true;
      } catch (Exception var2) {
         return false;
      }
   }

   public final void a() {
      Display.getDisplay(cMIDlet.a).setCurrent(this);
      new Thread(this).start();
   }

   public static void b() {
      Display.getDisplay(cMIDlet.a).setCurrent(null);
   }

   public final void paint(Graphics var1) {
      i = ~j & af;
      j = af;
      g = var1;
      h = DirectUtils.getDirectGraphics(var1);
      engine.h.a(g, 0, 0, 240, 320);

      try {
         if (main.b.a()) {
            if (ag != 0) {
               af = 0;
            }

            ag = 0;
            g = null;
         } else {
            label740:
            switch (k) {
               case 1:
                  g.setColor(-1);
                  g.fillRect(0, 0, 240, 320);
                  if (ad == 2) {
                     if (aA != null) {
                        g.drawImage(aA, 120, 160, 3);
                     }

                     if (this.bP <= 0) {
                        this.bP++;
                     } else if (this.bP < 20) {
                        this.bP++;
                     } else {
                        k = 3;
                     }
                  } else if (az != null) {
                     g.drawImage(az, 120, 160, 3);
                  }
                  break;
               case 2:
                  this.k();
                  break;
               case 3:
                  if (engine.h.a(g, aB)) {
                     k = 8;
                     f = 0;
                     aE = 0;
                  }
               case 4:
               case 10:
               case 12:
               case 13:
               case 14:
               case 15:
               case 23:
               default:
                  break;
               case 5:
                  f var21 = this;
                  engine.h.a(g, 16711680);
                  engine.h.a(g, 0, 0, 240, 320);
                  g.drawImage(ay[1], 0, 0, 20);
                  engine.h.a(g, ay[4], 160 - this.bO / 3 % 3, 271);
                  engine.h.a(g, h, ay[4], 68 + this.bO / 3 % 3, 271, 12, 17, 0, 0);
                  this.bO++;
                  this.bO %= 12;
                  engine.d.b(g, this.bN[ae - 1], -1, 267 + (26 - engine.g.b >> 1), 15597476, 6764371, 20);
                  if (d(49184)) {
                     switch (ae) {
                        case 1:
                           for (int var29 = 0; var29 < var21.bu.length; var29++) {
                              var21.bu[var29] = var21.j(var29);
                           }

                           k = 18;
                           main.e.i = 0;
                           break;
                        case 2:
                           k = 25;
                           break;
                        case 3:
                        case 4:
                        case 5:
                           int var22 = ae;
                           f = 0;
                           aO = (byte)(var22 - 1);
                           k = 11;
                           break;
                        case 6:
                           k = 0;
                     }

                     f = 0;
                     aE = 0;
                  }

                  if (d(5140)) {
                     if (--ae < 1) {
                        ae = 6;
                     }
                  } else if (d(10560) && ++ae > 6) {
                     ae = 1;
                  }
                  break;
               case 6:
                  engine.h.a(g, 0);
                  g.drawImage(ay[1], 0, 0, 20);
                  engine.d.b(g, "Загрузка с forum.fonzo.ru ... ", -1, 267 + (26 - engine.g.b >> 1), 15597476, 6362880, 20);
                  int var28 = 240 * aM / 16;
                  g.setColor(16711680);
                  g.drawLine(0, 319, 240, 319);
                  g.setColor(16777215);
                  g.drawLine(0, 319, var28, 319);
                  if (aM != 0) {
                     if (aM == 1) {
                        aA = null;
                        az = null;
                        aB = null;
                        System.gc();
                     } else if (aM != 2) {
                        if (aM == 3) {
                           this.n();
                        } else if (aM <= 3 || aM > 14) {
                           if (aM != 15) {
                              f = 1;
                              this.i();
                              break;
                           }

                           m();
                        }
                     }
                  }

                  aM++;
                  break;
               case 7:
                  if (W) {
                     if (engine.h.a(g, true, 2)) {
                        W = false;
                     }
                  } else if (N) {
                     this.c(true);
                     if (ay[2] == null) {
                        a(2, "/splash2.png");
                     }

                     if (aN) {
                        this.ab.a("menu", true, 1);
                     }

                     k = 16;
                  } else if (aQ) {
                     engine.c.a(main.a.a, main.a.b, g);
                     main.a.c();
                     this.H();
                     boolean var13 = false;
                     int var14;
                     if (K == 0) {
                        var14 = this.a("Записать игру? ", "Да ", "Нет ");
                     } else {
                        var14 = this.a("Цена 500 золотых, сохранить? ", "Да ", "Нет ");
                     }

                     if (var14 == 1) {
                        label721: {
                           if (K != 0) {
                              if (aG < 500) {
                                 a("Недостаточно денег для сохранения ");
                                 break label721;
                              }

                              aG -= 500;
                           }

                           this.i(bt);
                           a("Прогресс сохранен ");
                        }

                        aQ = false;
                     } else if (var14 == 2) {
                        aQ = false;
                     }
                  } else if (T) {
                     engine.c.a(main.a.a, main.a.b, g);
                     main.a.c();
                     this.H();

                     for (int var25 = 0; var25 < be.length; var25++) {
                        if (be[var25] != null) {
                           engine.d.panel(g, 10, 128, 220, 48);
                           engine.d.a(g, be[var25], 6764371, 20, 136, 200, engine.g.b * 2);
                           if (d(49184)) {
                              if (engine.d.c()) {
                                 if (!engine.d.d()) {
                                    engine.d.a(false);
                                    be[var25] = null;
                                 }
                              } else {
                                 engine.d.b();
                              }
                           }
                           break label740;
                        }
                     }

                     T = false;
                  } else if (M) {
                     engine.c.a(main.a.a, main.a.b, g);
                     main.a.c();
                     this.H();
                     boolean var17 = false;
                     if (K == 0) {
                        int var18;
                        if ((var18 = this.a("Произвести обмен? ", "Да ", "Нет ")) == 1) {
                           b(73, 0);
                           M = false;
                        } else if (var18 == 2) {
                           b(74, 0);
                           M = false;
                        }
                     } else {
                        int var19;
                        if ((var19 = this.a("Использовать для возвращения в деревню? ", "Да ", "Нет ")) == 1) {
                           main.e.m(53);
                           M = false;
                        } else if (var19 == 2) {
                           M = false;
                        }
                     }
                  } else if (L) {
                     engine.c.a(main.a.a, main.a.b, g);
                     main.a.c();
                     this.H();
                     if (L) {
                        int var20 = 2829099;
                        if (!this.bU) {
                           this.K();
                        }

                        this.drawDialog(var20);
                        if (d(49184)) {
                           if (engine.d.c()) {
                              if (!engine.d.d()) {
                                 engine.d.a(false);
                                 bR++;
                                 this.aq = null;
                                 this.bU = false;
                                 System.gc();
                                 if (bR >= bT.length) {
                                    bR = 0;
                                    L = false;
                                    bT = null;
                                    switch (bS) {
                                       case 0:
                                          switch (bQ) {
                                             case 3:
                                                if (aN) {
                                                   this.ab.a("gate", true, 1);
                                                }
                                             case 4:
                                             case 5:
                                             case 6:
                                             case 7:
                                             case 8:
                                             case 9:
                                             case 10:
                                             case 11:
                                             case 12:
                                             case 14:
                                             case 15:
                                             case 16:
                                             case 17:
                                             case 20:
                                             case 24:
                                             case 25:
                                             case 26:
                                             case 27:
                                             case 28:
                                             case 29:
                                             case 30:
                                             case 31:
                                             case 32:
                                             case 33:
                                             case 34:
                                             case 36:
                                             case 37:
                                             case 38:
                                             case 39:
                                             case 40:
                                             case 41:
                                             case 44:
                                             case 45:
                                             case 46:
                                             case 47:
                                             case 48:
                                             case 49:
                                             case 50:
                                             case 51:
                                             case 52:
                                             case 53:
                                             case 54:
                                             case 55:
                                             case 56:
                                             case 57:
                                             case 58:
                                             case 59:
                                             case 60:
                                             case 61:
                                             case 62:
                                             case 63:
                                             case 68:
                                             case 69:
                                             case 72:
                                             case 74:
                                             default:
                                                break label740;
                                             case 13:
                                                W = true;
                                                E = true;
                                                break label740;
                                             case 18:
                                                main.a.c[7].c(4, 1);
                                                main.a.c[7].b(true);
                                                g();
                                                main.a.c[c].b(true);
                                                break label740;
                                             case 19:
                                                main.a.c[7].c(0, 1);
                                                main.e.a(32, 1);
                                                break label740;
                                             case 21:
                                                main.a.c[c].b(false);
                                                b(22, 0);
                                                break label740;
                                             case 22:
                                                main.a.c[c].b(0, main.e.H[main.e.I]);
                                                main.a.c[c].c(main.e.H[main.e.I], 1);
                                                main.a.c[c].b(false);
                                                D = true;
                                                break label740;
                                             case 23:
                                                g();
                                                break label740;
                                             case 35:
                                                main.e.c(54, 1);
                                                main.e.c(55, 1);
                                                break label740;
                                             case 42:
                                                main.a.c[31].b(false);
                                                main.a.c[31].c(4, 1);
                                                break label740;
                                             case 43:
                                                main.a.c[24].c(9, 1);
                                                break label740;
                                             case 64:
                                                main.a.a(6);
                                                break label740;
                                             case 65:
                                                W = true;
                                                E = true;
                                                break label740;
                                             case 66:
                                                W = true;
                                                E = true;
                                                f(5);
                                                break label740;
                                             case 67:
                                                main.a.a(6);
                                                break label740;
                                             case 70:
                                                W = true;
                                                E = true;
                                                f(5);
                                                break label740;
                                             case 71:
                                                main.a.c[7].a[3] = true;
                                                engine.h.a();
                                                break label740;
                                             case 73:
                                                main.e.a(33, 1);
                                                main.e.b(32, 1);
                                                break label740;
                                          }
                                       case 1:
                                          if (main.e.p(bQ) == 2) {
                                             main.e.c(bQ, 3);
                                          } else {
                                             main.e.c(bQ, 2);
                                             if (main.e.p(bQ) == 1) {
                                                main.e.e();
                                             }
                                          }

                                          if (bQ == 2) {
                                             S[1] = 9;
                                             a("Открыта новая сцена " + R[1]);
                                          } else if (bQ == 7) {
                                             S[2] = 9;
                                             a("Открыта новая сцена " + R[2]);
                                          } else if (bQ == 10) {
                                             S[3] = 9;
                                             a("Открыта новая сцена " + R[3]);
                                          } else if (bQ == 13) {
                                             S[4] = 9;
                                             a("Открыта новая сцена " + R[4]);
                                          } else if (bQ == 18) {
                                             S[5] = 9;
                                             a("Открыта новая сцена " + R[5]);
                                          } else if (bQ == 23) {
                                             S[6] = 9;
                                             a("Открыта новая сцена " + R[6]);
                                          }
                                          break label740;
                                       case 2:
                                          main.e.c(bQ, 4);
                                          main.e.A(bQ);
                                          main.e.a(main.e.w(bQ), main.e.x(bQ));
                                          if (main.e.z(bQ) > 0) {
                                             a(main.e.z(bQ));
                                             a("Получено " + main.e.z(bQ) + "Золота ");
                                          }

                                          if (main.e.y(bQ) > 0) {
                                             main.e.G(main.e.y(bQ));
                                             a("Получено " + main.e.y(bQ) + "Опыта ");
                                          }

                                          if (bQ == 44) {
                                             M = true;
                                          } else if (bQ == 0) {
                                             main.e.c(0);
                                             a("В магазине можно изучить другие навыки ");
                                             a("В кузнице можно модернизировать предметы экипировки ");
                                             a("Мы не ищем легких путей.");
                                             a("Установите быстрый доступ к навыкам на сочетания клавиш");
                                          } else if (bQ == 1) {
                                             a("Мы не пользуемся читами.");
                                          } else if (bQ == 2) {
                                             a("Открыт доступ к синтезу оборудования и препаратов");
                                          } else if (bQ == 24) {
                                             main.e.c(2);
                                          } else if (bQ == 43) {
                                             main.e.c(1);
                                          }

                                          if (main.e.o(bQ)) {
                                             main.e.c(main.e.C = main.e.u(bQ), 1);
                                             main.e.s(main.e.C);
                                             b(main.e.C, 1);
                                             if (main.e.v(bQ) > 0) {
                                                main.e.c(main.e.v(bQ), 1);
                                             }

                                             if (bQ == 29) {
                                                main.e.c(65, 1);
                                                main.e.c(66, 1);
                                                main.e.c(67, 1);
                                             } else if (bQ == 35) {
                                                main.e.c(68, 1);
                                                main.e.c(69, 1);
                                                main.e.c(70, 1);
                                             } else if (bQ == 38) {
                                                main.e.c(71, 1);
                                                main.e.c(72, 1);
                                                main.e.c(73, 1);
                                                main.e.c(74, 1);
                                             }
                                          } else {
                                             if (main.e.u(bQ) > 0) {
                                                main.e.c(main.e.u(bQ), 1);
                                             }

                                             if (bQ == 45) {
                                                main.e.c(76, 1);
                                                main.e.c(77, 1);
                                                main.e.c(78, 1);
                                                main.e.c(79, 1);
                                                main.e.c(80, 1);
                                             } else if (bQ == 76) {
                                                main.e.a(14);
                                             } else if (bQ == 77) {
                                                main.e.a(15);
                                             } else if (bQ == 78) {
                                                main.e.a(16);
                                             } else if (bQ == 79) {
                                                main.e.a(17);
                                             } else if (bQ == 80) {
                                                main.e.a(18);
                                             }

                                             main.e.a(8);
                                             main.e.b();
                                          }
                                    }
                                 }
                              }
                           } else {
                              engine.d.b();
                           }
                        }
                     }
                  } else {
                     ac.a(true);
                     engine.c.a(main.a.a, main.a.b, g);
                     if (k == 7) {
                        main.a.c();
                        if (this.bB > 30) {
                           boolean var32 = false;
                        } else {
                           this.bB++;
                           if (K != 701 && K != 702 && K != 610) {
                              String var31 = "";
                              if (K != 0) {
                                 var31 = "- " + K % 100 + "  сцена ";
                              }

                              if (this.bc[Q] == 4) {
                                 var31 = "- " + (K % 100 - 4) + "  сцена ";
                              } else if (this.bc[Q] == 6) {
                                 var31 = "- " + (K % 100 - 4) + "  сцена ";
                              }

                              engine.d.b(g, R[this.bc[Q]] + var31, -1, 320 - engine.g.b >> 1, 0, 16777215, 20);
                           }

                           boolean var33 = true;
                        }

                        this.G();
                        this.H();
                        if (d(32768)) {
                           k = 9;
                           n(1);
                           f = 0;
                           this.ab.a();
                        }
                     }
                  }
                  break;
               case 8:
                  switch (this.bv) {
                     case 0:
                        this.bv = 1;
                        break label740;
                     case 1:
                        engine.h.a(g, 0);
                        g.drawImage(ay[1], 0, 0, 20);
                        engine.d.b(g, "Без звука более быстрая игра ", -1, 320 - engine.g.b - 60, 16770143, 0, 20);
                        engine.d.b(g, "Активировать звук? ", -1, 267 + (26 - engine.g.b >> 1), 16770143, 0, 20);
                        engine.d.a(g, "Да ", "Нет ");
                        if ((i & 32768) != 0) {
                           k = 6;
                           this.ab.a("menu", true, 1);
                           aN = true;
                           this.bv = 0;
                        } else if ((i & 65536) != 0) {
                           k = 6;
                           aN = false;
                           this.bv = 0;
                        }
                     default:
                        break label740;
                  }
               case 9:
                  aD = aN ? ": Вкл " : ": Выкл ";
                  if (f == 0) {
                     if (!bx) {
                        engine.c.a(main.a.a, main.a.b, g);
                        main.a.c();
                        this.H();
                     } else {
                        engine.c.a(main.a.a, main.a.b, g);
                        main.a.c();
                        engine.d.b(g, "Конец игры ", -1, 160, 0, 16777215, 20);
                        this.H();
                     }

                     if (!bx) {
                        engine.d.a(g, "Выбор ", null);
                     } else {
                        engine.d.a(g, "Выход ", "Продолжить игру ");
                     }

                     f++;
                  }

                  if (!bx) {
                     engine.h.a(g, 0, 160 - this.by, 240, this.by << 1);
                     e(120, 160);
                     f(120, 160);
                     if (this.bz == 0) {
                        if (this.by < engine.g.b * (bw.length + 1) / 2) {
                           this.by = this.by + engine.g.b * (bw.length + 1) / 2;
                           break;
                        }
                     } else if (this.bz == 1 && this.by > 0) {
                        this.by = this.by - engine.g.b * (bw.length + 1) / 2;
                        f = 0;
                        break;
                     }

                     this.J();
                     if (this.by == 0 || bM <= 0 || aI != 1 && aI != 2 && aI != 4 && aI != 5 && aI != 36) {
                        if (bM > 0) {
                           this.m(aI);
                           f = 0;
                           bM = 0;
                           this.bz = 0;
                        }
                     } else {
                        this.bz = 1;
                     }
                  } else if (d(65536)) {
                     this.aR = 0;
                     if (this.j(bt)) {
                        this.I();
                        this.k(bt);
                        k = 2;
                     } else {
                        this.i();
                     }
                  } else if (d(32768)) {
                     this.i();
                  }
                  break;
               case 11:
                  if ((i & 65536) != 0) {
                     if (!this.bA) {
                        k = 5;
                     } else {
                        f = 0;
                        k = 9;
                     }

                     engine.d.i();
                  } else if (aO == 2) {
                     engine.h.a(g, ay[2], 0, 0);
                     engine.d.b(g, "Настройки ", -1, 5 + (20 - engine.g.b >> 1), 15597476, 6895442, 20);
                     aD = aN ? "Звук: вкл " : "Звук: выкл ";
                     engine.d.b(g, aD, 240 - engine.g.a.stringWidth(aD) >> 1, 160, 0, 16777215, 20);
                     engine.d.a(g, "Изменить ", "Назад ");
                     if (d(49184)) {
                        if (aN = !aN) {
                           this.ab.a("menu", true, 1);
                        } else {
                           this.ab.a();
                        }
                     }
                  } else if (aO == 4) {
                     engine.d.a(g, main.e.b, 120, 50, ay[2], null);
                     engine.d.b(g, "Об игре ", -1, 30 - engine.g.b >> 1, 15597476, 6895442, 20);
                     if (d(5140)) {
                        engine.d.g();
                     }

                     if (d(10560)) {
                        engine.d.h();
                     }
                  } else if (aO == 3) {
                     engine.d.a(g, main.e.c, 120, 50, ay[2], null);
                     engine.d.b(g, "Инструкции ", -1, 30 - engine.g.b >> 1, 15597476, 6895442, 20);
                     if (d(5140)) {
                        engine.d.g();
                     }

                     if (d(10560)) {
                        engine.d.h();
                     }
                  }
                  break;
               case 16:
                  engine.h.a(g, ay[2], 0, 0);
                  if (!main.e.i(32)) {
                     if (engine.d.a(g, main.e.f)) {
                        K = 702;
                        N = false;
                        k = 2;
                     } else if (d(65536)) {
                        engine.d.a();
                     }
                  } else if (engine.d.a(g, main.e.e)) {
                     this.i();
                  } else if (d(65536)) {
                     engine.d.a();
                  }
                  break;
               case 17:
                  engine.h.a(g, ay[2], 0, 0);
                  switch (this.bh) {
                     case 0:
                        this.B();
                        break label740;
                     case 1:
                        this.D();
                        if ((f += 8) >= 40) {
                           f = 0;
                           if (this.bj > 0) {
                              this.bj--;
                           } else {
                              this.bj = 6;
                              main.e.f();
                           }

                           this.bh = 0;
                           if (this.bj == 4) {
                              main.e.c();
                           }
                        }
                        break label740;
                     case 2:
                        this.D();
                        if ((f -= 8) <= -40) {
                           f = 0;
                           if (this.bj < 6) {
                              this.bj++;
                           } else {
                              this.bj = 0;
                           }

                           this.bh = 0;
                           if (this.bj == 4) {
                              main.e.c();
                           } else if (this.bj == 6) {
                              main.e.f();
                           }
                        }
                        break label740;
                     case 3:
                        engine.h.a(g, ay[0], 0, 320 - ay[0].getHeight());
                        engine.h.a(g, ay[3], 2, 303, 17, 15, 0, 0);
                        engine.h.a(g, h, ay[0], 213, 298, 27, 22, 0, 0);
                        engine.h.a(g, ay[3], 221, 303, 17, 15, 17, 0);
                        engine.d.b(g, "Статус ", -1, 5 + (20 - engine.g.b >> 1), 15597476, 6362880, 20);
                        engine.h.a(g, 12, 46, 214, 24, 7299920, 14658680);
                        g.setColor(16708041);
                        g.fillRect(15, 48, 82, 20);
                        g.fillRect(99, 48, 124, 20);
                        engine.h.a(g, this.am, 43, 52, 25, 13, 0, 39);
                        engine.d.b(g, main.e.h[main.e.X[0] * 3], 161, 46 + (24 - engine.g.b >> 1), 15597476, 7085131, 17);
                        engine.d.a(g, main.e.y, null, main.e.A, 12, 71, 214, 6);
                        engine.h.a(g, 12, 222, 214, 68, 6907220, 14593146);
                        engine.h.a(g, 14, 224, 210, 64, 9600109, 8020827);
                        if (L) {
                           g(200, 60);
                        } else {
                           engine.d.a(g, main.e.z[main.e.B[engine.d.m()]], 15597476, 16, 225, 216, 62);
                           if (engine.d.c() && engine.a.b(20)) {
                              engine.d.d();
                           }

                           if (d(65536)) {
                              engine.d.a(false);
                              engine.d.l();
                              main.e.d();
                              this.bh = 0;
                           } else if (d(49184)) {
                              if (main.e.k[main.e.B[engine.d.m()]]) {
                                 main.e.X[0] = main.e.B[engine.d.m()];
                                 main.e.b(0);
                                 bs = "Статус изменен ";
                              } else {
                                 bs = "Статус не активирован ";
                              }

                              L = true;
                              engine.d.a(false);
                           } else if (d(1028)) {
                              engine.d.a(false);
                              engine.d.j();
                           } else if (d(2304)) {
                              engine.d.a(false);
                              engine.d.k();
                           }
                        }
                        break label740;
                     case 4:
                        engine.h.a(g, ay[0], 0, 320 - ay[0].getHeight());
                        engine.h.a(g, ay[3], 2, 303, 17, 15, 0, 0);
                        engine.h.a(g, h, ay[0], 213, 298, 27, 22, 0, 0);
                        engine.h.a(g, ay[3], 221, 303, 17, 15, 17, 0);
                        engine.d.b(g, this.br[this.bo + 1], -1, 5 + (20 - engine.g.b >> 1), 15597476, 6362880, 20);
                        engine.h.a(g, 80, 290, 78, 21, 7299920, 14658680);
                        engine.h.a(g, 82, 291, 74, 19, 14658680, 16708041);
                        engine.h.a(g, this.ar, 82, 292);
                        engine.h.b(g, as, aG, 102, 297, 7, 7, 0);
                        engine.d.a(g, main.e.y, null, null, 12, 46, 214, 6);
                        engine.h.a(g, 12, 222, 214, 68, 6907220, 14593146);
                        engine.h.a(g, 14, 224, 210, 64, 9600109, 8020827);
                        if (L) {
                           g(200, 60);
                        } else {
                           engine.d.a(g, main.e.h(main.e.B[engine.d.m()]), 15597476, 16, 225, 206, 62);
                           if (engine.d.c() && engine.a.b(20)) {
                              engine.d.d();
                           }

                           if (d(65536)) {
                              main.e.d();
                              engine.d.a(false);
                              engine.d.l();
                              this.bh = 0;
                           } else if (d(49184)) {
                              this.bh = 5;
                              engine.d.a(false);
                           } else if (d(1028)) {
                              engine.d.a(false);
                              engine.d.j();
                           } else if (d(2304)) {
                              engine.d.a(false);
                              engine.d.k();
                           }
                        }
                        break label740;
                     case 5:
                        this.C();
                        break label740;
                     case 6:
                        this.E();
                        break label740;
                     case 7:
                        engine.h.a(g, ay[0], 0, 320 - ay[0].getHeight());
                        engine.h.a(g, ay[3], 2, 303, 17, 15, 0, 0);
                        engine.h.a(g, h, ay[0], 213, 298, 27, 22, 0, 0);
                        engine.h.a(g, ay[3], 221, 303, 17, 15, 17, 0);
                        engine.d.b(g, "Реквизит ", -1, 30 - engine.g.b >> 1, 15597476, 6764371, 20);
                        engine.d.a(g, main.e.y, null, main.e.z, 12, 66, 214, 6);
                        engine.h.a(g, 12, 222, 214, 68, 6907220, 14593146);
                        engine.h.a(g, 14, 224, 210, 64, 9600109, 8020827);
                        if (L) {
                           if (this.bo == 1) {
                              boolean var7 = false;
                              switch (this.bq) {
                                 case 0:
                                    String var4 = "Уд ";
                                    String var3 = "Кл ";
                                    String var2 = "Да ";
                                    engine.h.a(g, 38, 139, 164, 42, 6907220, 16635556);
                                    engine.h.a(g, 41, 142, 158, 36, 16568212, 16707534);
                                    if (this.bV == 0) {
                                       engine.h.a(g, 46, 149, 46, 25, 16707534, 13549230);
                                    } else if (this.bV == 1) {
                                       engine.h.a(g, 92, 149, 46, 25, 16707534, 13549230);
                                    } else if (this.bV == 2) {
                                       engine.h.a(g, 138, 149, 46, 25, 16707534, 13549230);
                                    }

                                    engine.d.c(g, var2, 46 + (46 - engine.g.a.stringWidth(var2) >> 1), 149 + (25 - engine.g.b >> 1), 15597476, 6764371, 20);
                                    engine.d.c(g, var3, 92 + (46 - engine.g.a.stringWidth(var3) >> 1), 149 + (25 - engine.g.b >> 1), 15597476, 6764371, 20);
                                    engine.d.c(g, var4, 138 + (46 - engine.g.a.stringWidth(var4) >> 1), 149 + (25 - engine.g.b >> 1), 15597476, 6764371, 20);
                                    byte var10000;
                                    if (d(49184)) {
                                       engine.d.a(false);
                                       if (this.bV == 0) {
                                          this.bV = 0;
                                          var10000 = 1;
                                       } else if (this.bV == 1) {
                                          this.bV = 0;
                                          var10000 = 2;
                                       } else {
                                          this.bV = 0;
                                          var10000 = 3;
                                       }
                                    } else {
                                       if (d(4112)) {
                                          if (this.bV > 0) {
                                             this.bV--;
                                          }
                                       } else if (d(8256) && this.bV < 2) {
                                          this.bV++;
                                       }

                                       var10000 = 0;
                                    }

                                    byte var10 = var10000;
                                    if (var10000 == 1) {
                                       main.e.m(main.e.B[engine.d.m()]);
                                       L = false;
                                       main.e.d();
                                       main.e.n(this.bo + 9);
                                    } else if (var10 == 2) {
                                       engine.d.a(false);
                                       this.bq = 1;
                                    } else if (var10 == 3) {
                                       engine.d.a(false);
                                       this.bq = 2;
                                    }
                                    break;
                                 case 1:
                                    int var9;
                                    if ((var9 = this.a("Выберите клавишу для быстрого доступа", "1 ", "3 ")) == 1) {
                                       if ((main.e.s = main.e.B[engine.d.m()]) == main.e.t) {
                                          main.e.t = -1;
                                       }

                                       engine.d.a(false);
                                       L = false;
                                       this.bq = 0;
                                    } else if (var9 == 2) {
                                       main.e.t = main.e.B[engine.d.m()];
                                       if (main.e.s == main.e.t) {
                                          main.e.s = -1;
                                       }

                                       engine.d.a(false);
                                       L = false;
                                       this.bq = 0;
                                    }
                                    break;
                                 case 2:
                                    int var8;
                                    if ((var8 = this.a("Бросить? ", "Да ", "Нет ")) == 1) {
                                       main.e.j(main.e.B[engine.d.m()]);
                                       main.e.d();
                                       main.e.n(this.bo + 9);
                                       engine.d.a(false);
                                       L = false;
                                       this.bq = 0;
                                    } else if (var8 == 2) {
                                       engine.d.a(false);
                                       L = false;
                                       this.bq = 0;
                                    }
                              }
                           } else {
                              boolean var11 = false;
                              int var12;
                              if (main.e.a(main.e.B[engine.d.m()], 8, false) > 0) {
                                 var12 = this.a("Бросить? ", "Да ", "Нет ");
                              } else {
                                 var12 = this.a("Нельзя бросить ", "Да ", "Назад ");
                              }

                              if (var12 == 1) {
                                 if (main.e.a(main.e.B[engine.d.m()], 8, false) > 0) {
                                    main.e.j(main.e.B[engine.d.m()]);
                                    main.e.d();
                                    main.e.n(this.bo + 9);
                                 }

                                 engine.d.a(false);
                                 L = false;
                              } else if (var12 == 2) {
                                 engine.d.a(false);
                                 L = false;
                              }
                           }

                           if (d(65536)) {
                              L = false;
                              engine.d.a(false);
                           }
                        } else {
                           engine.d.a(g, main.e.h(main.e.B[engine.d.m()]), 15597476, 16, 225, 208, 62);
                           if (engine.d.c() && engine.a.b(20)) {
                              engine.d.d();
                           }

                           if (d(65536)) {
                              engine.d.a(false);
                              engine.d.l();
                              main.e.d();
                              this.bh = 0;
                           } else if (d(49184)) {
                              if (main.e.B[0] >= 0) {
                                 L = true;
                                 engine.d.a(false);
                              }
                           } else if (d(1028)) {
                              engine.d.a(false);
                              engine.d.j();
                           } else if (d(2304)) {
                              engine.d.a(false);
                              engine.d.k();
                           }
                        }
                        break label740;
                     case 8:
                        this.A();
                        break label740;
                     case 9:
                        switch (this.bk) {
                           case 1:
                              engine.h.a(g, ay[0], 0, 320 - ay[0].getHeight());
                              engine.h.a(g, ay[3], 2, 303, 17, 15, 0, 0);
                              engine.h.a(g, h, ay[0], 213, 298, 27, 22, 0, 0);
                              engine.h.a(g, ay[3], 221, 303, 17, 15, 17, 0);
                              engine.d.b(g, "Ковка ", -1, 30 - engine.g.b >> 1, 15597476, 6764371, 20);
                              engine.h.a(g, 80, 290, 78, 21, 7299920, 14658680);
                              engine.h.a(g, 82, 291, 74, 19, 14658680, 16708041);
                              engine.h.a(g, this.ar, 82, 292);
                              engine.h.b(g, as, aG, 102, 297, 7, 7, 0);
                              engine.d.a(g, main.e.y, null, main.e.z, 12, 56, 214, 6);
                              engine.h.a(g, 12, 212, 214, 68, 6907220, 14593146);
                              engine.h.a(g, 14, 214, 210, 64, 9600109, 8020827);
                              engine.d.a(g, main.e.h(main.e.B[engine.d.m()]), 15597476, 16, 215, 206, 62);
                              if (engine.d.c() && engine.a.b(20)) {
                                 engine.d.d();
                              }

                              if (d(65536)) {
                                 this.bk = (byte)(this.bk + 100);
                                 engine.d.l();
                                 main.e.d();
                              } else if (d(49184)) {
                                 if (main.e.B[engine.d.m()] >= 0) {
                                    this.bk = (byte)(this.bk + 10);
                                    engine.d.a(false);
                                 }
                              } else if (d(1028)) {
                                 engine.d.a(false);
                                 engine.d.j();
                              } else if (d(2304)) {
                                 engine.d.a(false);
                                 engine.d.k();
                              }
                              break label740;
                           case 11:
                              this.w();
                              break label740;
                           case 101:
                              this.z();
                        }
                     default:
                        break label740;
                  }
               case 18:
                  this.F();
                  break;
               case 19:
                  engine.h.a(g, ay[2], 0, 0);
                  switch (this.bh) {
                     case 0:
                        this.r();
                        break label740;
                     case 1:
                     case 2:
                        this.s();
                     default:
                        break label740;
                  }
               case 20:
                  engine.h.a(g, ay[2], 0, 0);
                  switch (this.bh) {
                     case 0:
                        this.t();
                        break label740;
                     case 1:
                     case 2:
                     case 3:
                        this.v();
                        break label740;
                     case 11:
                        this.w();
                        break label740;
                     case 12:
                        this.x();
                        break label740;
                     case 13:
                        this.y();
                        break label740;
                     case 101:
                     case 102:
                     case 103:
                        this.u();
                     default:
                        break label740;
                  }
               case 21:
                  engine.h.a(g, this.aj, 0, 0);
                  if (engine.d.a(g, main.e.d)) {
                     K = 0;
                     k = 2;
                  } else if (d(65536)) {
                     engine.d.a();
                  }
                  break;
               case 22:
                  this.q();
                  break;
               case 24:
                  this.p();
                  break;
               case 25:
                  this.o();
            }

            if (ag != 0) {
               af = 0;
            }

            ag = 0;
            g = null;
         }
      } catch (Exception var5) {
         var5.printStackTrace();
      }
   }

   private void c(int var1, int var2) {
      g.setColor(0);
      engine.h.a(g, 0, 0, 240, 320);
      if (var2 == 1) {
         this.aS++;
         if (this.aS > 16) {
            this.aR = 7;
            return;
         }
      } else {
         this.aS--;
         if (this.aS < 0) {
            this.aR = 8;
            return;
         }
      }

      for (int var3 = 0; var3 < 15; var3++) {
         g.fillRect(var3 << 4, 0, this.aS, 320);
      }
   }

   private void k() {
      if (this.aR == 0) {
         this.ab.a();
         c = 0;
         D = false;
         if (K == 701) {
            c = 8;
            D = true;
         } else if (K == 702) {
            c = 5;
         }

         d = c;
         bQ = -1;
         this.bA = true;
         bx = false;
         engine.c.e = false;
         E = false;
         J = 0;
         this.bB = 0;
         main.e.l = false;
         main.e.m = false;
         main.e.o = 0;
         G = true;
         X = 0;
         Y = 0;
         a(-1, -1);
         engine.d.a(false);
         main.a.a(0);
         if (main.e.i >= 10) {
            main.e.a(2);
         }

         if (K == 0 && !P && main.e.q(0) == 1) {
            b(17, 0);
         } else if (K == 104) {
            main.e.F[0] = -1;
         } else if (K == 204) {
            main.e.F[2] = -1;
         } else if (K == 304) {
            main.e.F[3] = -1;
         } else if (K == 208) {
            main.e.F[4] = -1;
         } else if (K == 601) {
            if (main.e.i == 0) {
               main.e.a(1);
            }
         } else if (K == 606) {
            main.e.F[7] = -1;
         } else if (K == 607) {
            main.e.F[8] = -1;
         } else if (K == 610) {
            b(66, 0);
         } else if (K == 702) {
            b(71, 0);
         }

         c("/script" + K + ".bin");
         main.a.a(aX, aX.length);
         main.a.b(false);
         if (f == 0) {
            f = 1;
         }

         this.aR = 1;
      } else if (this.aR == 1) {
         engine.h.a(g, 0);
         if (this.tipT == 0) {
            this.tipLines = engine.d.wrap(this.aT[this.aU].trim(), 190);
         }
         this.tipT++;
         int th = 44 + this.tipLines.length * (engine.g.b + 3);
         int ty = 150 - (th >> 1);
         engine.d.darkPanel(g, 14, ty, 212, th);
         engine.d.b(g, "СОВЕТ", -1, ty + 9, 0xE8C766, 0x000000, 20);
         g.setColor(0xC9A04A);
         g.fillRect(40, ty + 11 + engine.g.b, 160, 1);
         for (int var2 = 0; var2 < this.tipLines.length; var2++) {
            engine.d.b(g, this.tipLines[var2], -1, ty + 20 + engine.g.b + var2 * (engine.g.b + 3), 0xF5E8C8, 0x000000, 20);
         }

         int bw = 160;
         int bx = 40;
         int by = 262;
         g.setColor(0xC9A04A);
         g.fillRect(bx - 1, by - 1, bw + 2, 8);
         g.setColor(0x1B1410);
         g.fillRect(bx, by, bw, 6);
         g.setColor(0xE8C766);
         g.fillRect(bx + 1, by + 1, Math.min(bw - 2, (bw - 2) * this.tipT / 20), 4);
         engine.d.b(g, "Загрузка с forum.fonzo.ru ... ", -1, 274, 0xF5E8C8, 0x000000, 20);
         if (engine.a.b(20)) {
            this.tipT = 0;
            this.aR = 2;
         }
      } else if (this.aR == 2) {
         c = 0;
         main.a.a = 0;
         main.a.b = 0;
         E = false;
         this.c(true);
         this.g(K);
         engine.c.a("/p" + K + ".DAT");
         main.a.d();
         ac.b();
         this.aR = 6;
      } else if (this.aR == 6) {
         this.c(15, 1);
      } else if (this.aR == 7) {
         ac.a(false);
         engine.c.a(main.a.a, main.a.b, g);
         main.a.c();
         this.H();
         this.c(15, 2);
      } else if (this.aR == 8) {
         this.aR = 0;
         f = 0;
         if (aN) {
            if (K != 0 && K != 610 && K != 701 && K != 702) {
               this.ab.a("gate", true, 1);
            } else {
               this.ab.a("menu", true, 1);
            }
         }

         this.aU++;
         this.aU = this.aU % this.aT.length;
         k = 7;
      }
   }

   public static void b(int var0) {
      O = var0;
   }

   public final void keyPressed(int var1) {
      if (ah <= 0) {
         af = h(var1);
      }
   }

   public final void keyReleased(int var1) {
      int var2 = h(var1);
      if ((j & var2) != 0) {
         af &= ~var2;
      } else {
         ag |= var2;
      }
   }

   public final void keyRepeated(int var1) {
      if (ah <= 0) {
         af = h(var1);
      }
   }

   private static int h(int var0) {
      switch (var0) {
         case -7:
            return 65536;
         case -6:
            return 32768;
         case -5:
            return 16416;
         case -4:
            return 8256;
         case -3:
            return 4112;
         case -2:
            return 2304;
         case -1:
            return 1028;
         default:
            switch (var0) {
               case 35:
                  return 524288;
               case 36:
               case 37:
               case 38:
               case 39:
               case 40:
               case 41:
               case 43:
               case 44:
               case 45:
               case 46:
               case 47:
               default:
                  return 0;
               case 42:
                  return 262144;
               case 48:
                  return 1;
               case 49:
                  return 2;
               case 50:
                  return 4;
               case 51:
                  return 8;
               case 52:
                  return 16;
               case 53:
                  return 32;
               case 54:
                  return 64;
               case 55:
                  return 128;
               case 56:
                  return 256;
               case 57:
                  return 512;
            }
      }
   }

   protected final void hideNotify() {
      this.ab.a();
      ai = true;
      l = true;
   }

   protected final void showNotify() {
      l = false;
      ai = false;
      if (k == 7) {
         f = 0;
         k = 9;
         n(1);
         f(2);
      } else {
         if (k != 5 && k != 11 && k != 16 && k != 18 && k != 21 && k != 22 && k != 25) {
            if ((k == 17 || k == 19 || k == 20 || k == 23 || k == 24) && aN) {
               if (K == 0 || K == 610 || K == 701 || K == 702) {
                  this.ab.a("menu", true, 1);
                  return;
               }

               this.ab.a("gate", true, 1);
            }
         } else if (aN) {
            this.ab.a("menu", true, 1);
            return;
         }
      }
   }

   private static void l() {
      Z.repaint();
      Z.serviceRepaints();
   }

   private static void d(int var0, int var1) {
      long var2 = System.currentTimeMillis();
      aK = -1;

      while (aK < 1) {
         compat.Res.yield();
         if (!l) {
            l();
            aK++;

            long var4;
            do {
               compat.Res.yield();
            } while ((var4 = System.currentTimeMillis() - var2) < var1 && var4 >= 0L);

            var2 = System.currentTimeMillis();
         }
      }
   }

   public final void run() {
      compat.Res.yield();
      main.b.b();
      if (k == 1) {
         try {
            az = Image.createImage("/bbox.png");
            aA = Image.createImage("/red.png");
            aB = Image.createImage("/king86.png");
            if (ay[1] == null) {
               a(1, "/splash1.png");
            }
         } catch (Exception var4) {
         }

         this.bP = -8;
         ad = 1;
         d(1, 300);
         ad = 2;
         d(1, 200);
      }

      f var1 = this;

      while (k != 0) {
         compat.Res.yield();
         if (!l) {
            if (ah > 0) {
               ah--;
            }

            var1.aL = System.currentTimeMillis();
            l();
            if (!ai) {
               while (true) {
                  compat.Res.yield();
                  long var2;
                  if ((var2 = System.currentTimeMillis() - var1.aL) >= 50L || var2 <= 0L) {
                     break;
                  }
               }
            }
         }
      }

      var1.ab.a();
      cMIDlet.a.destroyApp(true);
   }

   private static void m() {
      RecordStore var0 = null;

      try {
         if ((var0 = RecordStore.openRecordStore("shanhaiyouxia_Title", true)).getNumRecords() > 0) {
            byte[] var1 = var0.getRecord(1);
            ByteArrayInputStream var6 = new ByteArrayInputStream(var1);
            DataInputStream var2 = new DataInputStream(var6);

            for (int var3 = 0; var3 < main.e.k.length; var3++) {
               main.e.k[var3] = var2.readBoolean();
            }

            var6.close();
            var2.close();
            var0.closeRecordStore();
            var0 = null;
         }

         var0.closeRecordStore();
      } catch (Exception var4) {
      }
   }

   static void c() {
      byte[] var0 = null;

      try {
         ByteArrayOutputStream var1 = new ByteArrayOutputStream();
         DataOutputStream var2 = new DataOutputStream(var1);

         for (int var3 = 0; var3 < main.e.k.length; var3++) {
            var2.writeBoolean(main.e.k[var3]);
         }

         var0 = var1.toByteArray();
         var1.close();
         var2.close();
      } catch (Exception var5) {
      }

      try {
         RecordStore var6;
         if ((var6 = RecordStore.openRecordStore("shanhaiyouxia_Title", true)).getNumRecords() > 0) {
            var6.setRecord(1, var0, 0, var0.length);
         } else {
            var6.addRecord(var0, 0, var0.length);
         }

         var6.closeRecordStore();
      } catch (Exception var4) {
      }
   }

   private void i(int var1) {
      byte[] var2 = null;

      try {
         ByteArrayOutputStream var3 = new ByteArrayOutputStream();
         DataOutputStream var4;
         (var4 = new DataOutputStream(var3)).writeInt(K);
         var4.writeInt(main.e.K);
         var4.writeInt(main.e.M);
         var4.writeInt(main.e.L);
         var4.writeInt(main.e.J);

         for (int var5 = 0; var5 < main.e.X.length; var5++) {
            var4.writeInt(main.e.X[var5]);
         }

         for (int var9 = 0; var9 < S.length; var9++) {
            var4.writeByte(S[var9]);
         }

         for (int var10 = 0; var10 < main.e.u.length; var10++) {
            var4.writeBoolean(main.e.u[var10]);
         }

         var4.writeInt(main.e.q);
         var4.writeInt(main.e.r);

         for (int var11 = 0; var11 < main.e.D.length; var11 += 8) {
            var4.writeInt(main.e.D[var11]);
            var4.writeInt(main.e.D[var11 + 1]);
            var4.writeInt(main.e.D[var11 + 2]);
            var4.writeInt(main.e.D[var11 + 3]);
         }

         var4.writeInt(main.e.C);

         for (int var12 = 0; var12 < main.e.x.length; var12++) {
            var4.writeInt(main.e.x[var12]);
         }

         var4.writeByte(main.e.I);
         var4.writeInt(main.a.c[c].c);
         var4.writeInt(main.a.c[c].d);

         for (int var13 = 0; var13 < main.e.F.length; var13++) {
            var4.writeByte(main.e.F[var13]);
         }

         var4.writeInt(main.e.s);
         var4.writeInt(main.e.t);
         var4.writeInt(main.e.i);
         var4.writeInt(main.e.j);
         var4.writeInt(aG);
         var4.writeInt(Q);
         var4.writeInt(main.e.N);
         var4.writeInt(main.e.O);
         var4.writeInt(main.e.P);
         var4.writeInt(main.e.Q);
         var4.writeInt(main.e.R);
         var2 = var3.toByteArray();
         var3.close();
         var4.close();
      } catch (Exception var7) {
      }

      try {
         RecordStore var8;
         if ((var8 = RecordStore.openRecordStore(this.aW + var1, true)).getNumRecords() > 0) {
            var8.setRecord(1, var2, 0, var2.length);
         } else {
            var8.addRecord(var2, 0, var2.length);
         }

         var8.closeRecordStore();
      } catch (Exception var6) {
      }
   }

   private boolean j(int var1) {
      RecordStore var2 = null;

      try {
         if ((var2 = RecordStore.openRecordStore(this.aW + var1, true)).getNumRecords() > 0) {
            var2.closeRecordStore();
            return true;
         }

         var2.closeRecordStore();
      } catch (Exception var3) {
      }

      return false;
   }

   private boolean k(int var1) {
      RecordStore var2 = null;

      try {
         if ((var2 = RecordStore.openRecordStore(this.aW + var1, true)).getNumRecords() > 0) {
            byte[] var5 = var2.getRecord(1);
            ByteArrayInputStream var6 = new ByteArrayInputStream(var5);
            DataInputStream var7;
            K = (var7 = new DataInputStream(var6)).readInt();
            main.e.K = var7.readInt();
            main.e.M = var7.readInt();
            main.e.L = var7.readInt();
            main.e.J = var7.readInt();

            for (int var3 = 0; var3 < main.e.X.length; var3++) {
               main.e.X[var3] = var7.readInt();
            }

            for (int var9 = 0; var9 < S.length; var9++) {
               S[var9] = var7.readByte();
            }

            for (int var10 = 0; var10 < main.e.u.length; var10++) {
               main.e.u[var10] = var7.readBoolean();
            }

            main.e.q = var7.readInt();
            main.e.r = var7.readInt();

            for (int var11 = 0; var11 < main.e.D.length; var11 += 8) {
               main.e.D[var11] = var7.readInt();
               main.e.D[var11 + 1] = var7.readInt();
               main.e.D[var11 + 2] = var7.readInt();
               main.e.D[var11 + 3] = var7.readInt();
            }

            main.e.C = var7.readInt();

            for (int var12 = 0; var12 < main.e.x.length; var12++) {
               main.e.x[var12] = var7.readInt();
            }

            main.e.I = var7.readByte();
            main.e.S = var7.readInt();
            main.e.T = var7.readInt();

            for (int var13 = 0; var13 < main.e.F.length; var13++) {
               main.e.F[var13] = var7.readByte();
            }

            main.e.s = var7.readInt();
            main.e.t = var7.readInt();
            var7.readInt();
            main.e.j = var7.readInt();
            aG = var7.readInt();
            Q = var7.readInt();
            main.e.N = var7.readInt();
            main.e.O = var7.readInt();
            main.e.P = var7.readInt();
            main.e.Q = var7.readInt();
            main.e.R = var7.readInt();
            P = true;
            var6.close();
            var7.close();
            var2.closeRecordStore();
            return true;
         }

         var2.closeRecordStore();
      } catch (Exception var4) {
      }

      return false;
   }

   static int a(InputStream var0) {
      try {
         return var0.read();
      } catch (Exception var1) {
         return -1;
      }
   }

   static final int a(byte[] var0, int var1) {
      int var2;
      if ((var2 = var0[var1++]) < 0) {
         var2 += 256;
      }

      int var4;
      var2 = (var4 = var2 << 8) + var0[var1];
      if (var0[var1] < 0) {
         var2 += 256;
      }

      return var2;
   }

   private int n() {
      try {
         InputStream var11;
         int var1 = engine.e.a(var11 = compat.Res.open("/a.bin"));
         int var2 = 2;
         main.a.e = new c[var1];

         for (int var3 = 0; var3 < var1; var3++) {
            c var4 = new c();
            main.a.e[var3] = var4;
            InputStream var13 = var11;
            c var12 = var4;
            int var5 = 0;
            var4.b = engine.e.a(var11);
            int var6 = engine.e.a(var11);
            var4.c = new byte[var6 << 2];
            var5 = 4 + engine.e.a(var11, var4.c, 0, var6 << 2);
            var6 = engine.e.a(var11);
            var5 += 2;
            var4.d = new byte[var6 << 3];
            var4.e = new byte[var6][];

            for (int var7 = 0; var7 < var6; var7++) {
               a(var13);
               boolean var8 = false;
               int var9 = a(var13);
               var5 += 2;
               var12.e[var7] = new byte[var9 << 2];
               var5 = var5 + engine.e.a(var13, var12.e[var7], 0, var9 << 2) + engine.e.a(var13, var12.d, var7 << 3, 8);
            }

            var6 = engine.e.a(var13);
            var5 += 2;
            var12.g = new byte[var6];
            var12.f = new byte[var6][];
            var12.h = new byte[var6];
            var12.i = new short[var6 << 2];

            for (int var22 = 0; var22 < var6; var22++) {
               int var23 = a(var13);
               int var25 = a(var13);
               var5 += 2;
               var12.g[var22] = (byte)var25;
               var12.f[var22] = new byte[var25 << 1];
               var5 += engine.e.a(var13, var12.f[var22], 0, var25 << 1);
               var12.h[var22] = (byte)a(var13);
               var5++;
               var23 = (var23 - 1 - (var25 << 1) - 1) / 2;

               for (int var26 = 0; var26 < var23; var26++) {
                  byte var10002 = 2;
                  var12.i[(var22 << 2) + var26] = (short)engine.e.a(var13);
                  var5 += 2;
               }
            }

            var2 += var5;
         }

         var11.close();
         return var2;
      } catch (Exception var10) {
         System.out.println("Anim_err");
         return 0;
      }
   }

   private static void c(String var0) {
      try {
         short var1;
         DataInputStream var4;
         aX = new byte[var1 = (var4 = new DataInputStream(compat.Res.open(var0))).readShort()];

         for (short var2 = 0; var2 < var1; var2++) {
            aX[var2] = var4.readByte();
         }
      } catch (Exception var3) {
      }
   }

   private void o() {
      switch (this.ba) {
         case 0:
            engine.h.a(g, 0);
            engine.h.a(g, 0, 0, 240, 320);
            g.drawImage(ay[2], 0, 0, 20);
            a(new String[]{"Помощь ", "Статус ", "Советы: "}, this.aZ, true, true);
            if (d(49184)) {
               switch (this.aZ) {
                  case 0:
                     engine.d.a(false);
                     main.e.b(1);
                     this.ba = 1;
                     break;
                  case 1:
                     this.ba = 2;
               }
            }

            if (d(65536)) {
               k = 5;
               return;
            }

            if (d(5140)) {
               this.aZ--;
               if (this.aZ < 0) {
                  this.aZ = 1;
                  return;
               }
            } else if (d(10560)) {
               this.aZ++;
               if (this.aZ > 1) {
                  this.aZ = 0;
                  return;
               }
            }
            break;
         case 1:
            engine.h.a(g, 0);
            engine.h.a(g, 0, 0, 240, 320);
            g.drawImage(ay[2], 0, 0, 20);
            engine.h.a(g, h, ay[0], 213, 298, 27, 22, 0, 0);
            engine.h.a(g, ay[3], 221, 303, 17, 15, 17, 0);
            engine.d.b(g, "Статус ", -1, 30 - engine.g.b >> 1, 15597476, 6895442, 20);
            engine.d.a(g, main.e.y, null, main.e.A, 12, 46, 214, 6);
            engine.h.a(g, 12, 222, 214, 68, 6907220, 14593146);
            engine.h.a(g, 14, 224, 210, 64, 9600109, 8020827);
            engine.d.a(g, main.e.z[engine.d.m()], 15597476, 16, 225, 206, 62);
            if (engine.d.c() && engine.a.b(20)) {
               engine.d.d();
            }

            if (d(1028)) {
               engine.d.a(false);
               engine.d.j();
               return;
            }

            if (d(2304)) {
               engine.d.a(false);
               engine.d.k();
               return;
            }

            if (d(65536)) {
               engine.d.a(false);
               engine.d.l();
               main.e.d();
               this.ba = 0;
               return;
            }
            break;
         case 2:
            engine.d.a(g, main.e.a, 120, 50, ay[2], null);
            engine.d.b(g, "Советы: ", -1, 30 - engine.g.b >> 1, 15597476, 6895442, 20);
            if (d(65536)) {
               this.ba = 0;
               engine.d.i();
               return;
            }

            if (d(5140)) {
               engine.d.g();
               return;
            }

            if (d(10560)) {
               engine.d.h();
            }
      }
   }

   public final void c(int var1) {
      main.e.B(var1);
      this.j();
      k = 24;
   }

   private void p() {
      engine.h.a(g, ay[2], 0, 0);
      a(main.e.y, this.bj, true, true);

      for (int var1 = 1; var1 < main.e.y.length; var1++) {
         engine.h.a(g, at, (240 - engine.g.a.stringWidth(main.e.y[var1]) >> 1) - 28, 48 + (var1 - 1) * 24, 12, 17, 12 * (main.e.q(main.e.B[var1]) - 1), 0);
      }

      if (d(49184)) {
         if (main.e.q(main.e.B[this.bj + 1]) == 1) {
            V = main.e.B[this.bj + 1];
         } else {
            if (main.e.q(main.e.B[this.bj + 1]) != 3) {
               return;
            }

            V = main.e.B[this.bj + 1];
         }

         U = true;
         this.bj = 0;
         engine.d.a(false);
         main.e.d();
         this.c(false);
         this.g(K);

         for (int var3 = 0; var3 < main.a.e.length; var3++) {
            main.a.e[var3].a();
         }

         k = 7;
      } else if (!d(65536)) {
         if (d(5140)) {
            this.bj--;
            if (this.bj < 0) {
               this.bj = main.e.y.length - 2;
               return;
            }
         } else if (d(10560)) {
            this.bj++;
            if (this.bj > main.e.y.length - 2) {
               this.bj = 0;
            }
         }
      } else {
         this.bj = 0;
         engine.d.a(false);
         main.e.d();
         this.c(false);
         this.g(K);

         for (int var2 = 0; var2 < main.a.e.length; var2++) {
            main.a.e[var2].a();
         }

         k = 7;
      }
   }

   public static void d() {
      aQ = true;
   }

   public final void e() {
      this.c(false);

      try {
         if (this.aj == null) {
            this.aj = Image.createImage("/mapworld.png");
         }
      } catch (IOException var1) {
      }

      if (aN) {
         this.ab.a("menu", true, 1);
      }

      k = 21;
   }

   public final void f() {
      this.c(true);

      try {
         this.aj = Image.createImage("/mapworld.png");
         this.ak = Image.createImage("/selectmap.png");
         if (ay[0] == null) {
            a(0, "/splash0.png");
         }

         if (ay[3] == null) {
            a(3, "/splash3.png");
         }
      } catch (IOException var1) {
      }

      k = 22;
   }

   private void q() {
      engine.h.a(g, this.aj, 0, 0);

      for (int var1 = 0; var1 < 9; var1++) {
         if (S[var1] > 0) {
            if (S[var1] % 2 == 0) {
               engine.h.a(g, this.ak, this.bb[var1 << 1], this.bb[(var1 << 1) + 1], 41, 44, var1 * 41, 0);
            }

            switch (S[var1]) {
               case 3:
               case 8:
                  engine.h.a(g, this.ak, this.bb[var1 << 1] + 10, this.bb[(var1 << 1) + 1] + 11, 20, 22, 114, 44);
                  break;
               case 4:
               case 7:
                  engine.h.a(g, this.ak, this.bb[var1 << 1] + 10, this.bb[(var1 << 1) + 1] + 11, 20, 22, 134, 44);
                  break;
               case 5:
               case 6:
                  engine.h.a(g, this.ak, this.bb[var1 << 1] + 10, this.bb[(var1 << 1) + 1] + 11, 20, 22, 154, 44);
            }

            if (S[var1] > 1 && S[var1] <= 9) {
               S[var1]--;
               if (S[var1] == 1) {
                  S[var1] = 9;
               }
            }
         }
      }

      engine.h.a(g, this.ak, this.bb[this.bc[Q] << 1] + 15, this.bb[(this.bc[Q] << 1) + 1], 11, 11, 103, 44);
      engine.h.a(g, this.ak, 71, 282, 103, 22, 0, 44);
      engine.h.a(g, ay[0], 0, 320 - ay[0].getHeight());
      engine.h.a(g, ay[3], 2, 303, 17, 15, 0, 0);
      engine.d.b(g, R[this.bc[Q]], -1, 282 + (22 - engine.g.b >> 1), 16777165, 4923904, 20);
      if (d(49184)) {
         if (K == -1) {
            main.e.g = 7;
         }

         if ((K = this.bd[this.bc[Q]]) == 0) {
            main.e.g = 18;
         }

         S[this.bc[Q]] = 0;
         k = 2;
         if (this.bc[Q] == 2 && !main.e.W) {
            main.b.a(5);
            return;
         }
      } else if (d(1028)) {
         if (Q >= 3) {
            Q -= 3;
            if (S[this.bc[Q]] > 9) {
               Q += 3;
               return;
            }
         }
      } else if (d(2304)) {
         if (Q <= 5) {
            Q += 3;
            if (S[this.bc[Q]] > 9) {
               Q -= 3;
               return;
            }
         }
      } else if (d(4112)) {
         if (--Q < 0) {
            Q = 0;
         }

         if (S[this.bc[Q]] > 9) {
            Q++;
            return;
         }
      } else if (d(8256)) {
         if (++Q > 8) {
            Q = 8;
         }

         if (S[this.bc[Q]] > 9) {
            Q--;
         }
      }
   }

   public static void a(String var0) {
      for (int var1 = 0; var1 < be.length; var1++) {
         if (be[var1] == null) {
            be[var1] = var0;
            T = true;
            return;
         }
      }
   }

   public final void a(boolean var1) {
      if (var1) {
         this.bf = new String[4];
         this.bf[0] = "Аптека ";
         this.bf[2] = "Купить ";
         this.bf[3] = "Продать ";
         this.bf[1] = "   Задача   ";
      } else {
         this.bf = new String[3];
         this.bf[0] = "Аптека ";
         this.bf[1] = "Купить ";
         this.bf[2] = "Продать ";
      }

      engine.d.a(false);
      this.j();
      k = 19;
   }

   private void r() {
      a(this.bf, this.bj, true, true);
      if (d(49184)) {
         if (this.bf.length == 3) {
            if (this.bj == 0) {
               this.bh = 1;
               main.e.n(13);
            } else if (this.bj == 2) {
               this.bj = 0;
               this.bf = null;
               this.bh = 0;
               engine.d.a(false);
               this.c(11);
            } else {
               this.bh = 2;
               main.e.n(14);
            }
         } else if (this.bj == 1) {
            this.bh = 1;
            main.e.n(13);
         } else if (this.bj == 0) {
            this.bj = 0;
            this.bf = null;
            this.bh = 0;
            engine.d.a(false);
            this.c(11);
         } else {
            this.bh = 2;
            main.e.n(14);
         }

         engine.d.a(false);
      } else if (!d(65536)) {
         if (d(5140)) {
            this.bj--;
            if (this.bj < 0) {
               this.bj = this.bf.length - 2;
               return;
            }
         } else if (d(10560)) {
            this.bj++;
            if (this.bj > this.bf.length - 2) {
               this.bj = 0;
            }
         }
      } else {
         this.bj = 0;
         this.bf = null;
         engine.d.a(false);
         this.c(false);
         this.g(K);

         for (int var1 = 0; var1 < main.a.e.length; var1++) {
            main.a.e[var1].a();
         }

         k = 7;
      }
   }

   private void s() {
      engine.h.a(g, ay[0], 0, 320 - ay[0].getHeight());
      engine.h.a(g, ay[3], 2, 303, 17, 15, 0, 0);
      engine.h.a(g, h, ay[0], 213, 298, 27, 22, 0, 0);
      engine.h.a(g, ay[3], 221, 303, 17, 15, 17, 0);
      engine.d.b(g, this.bf[this.bj + 1], -1, 30 - engine.g.b >> 1, 15597476, 6764371, 20);
      engine.h.a(g, 80, 290, 78, 21, 7299920, 14658680);
      engine.h.a(g, 82, 291, 74, 19, 14658680, 16708041);
      engine.h.a(g, this.ar, 82, 292);
      engine.h.b(g, as, aG, 102, 297, 7, 7, 0);
      engine.d.a(g, main.e.y, null, main.e.z, 12, 56, 214, 6);
      if (L) {
         g(164, 60);
      } else if (this.bp == 1) {
         boolean var3 = false;
         engine.h.a(g, 32, 130, 176, 60, 6907220, 15580812);
         engine.h.a(g, 34, 132, 172, 56, 15580812, 16707534);
         g.setColor(13549230);
         g.fillRect(36, 138, 64, 20);
         g.fillRect(101, 138, 101, 20);
         engine.h.a(g, au, 146, 129, 11, 11, 22, 0);
         engine.h.a(g, au, 146, 155, 11, 11, 33, 0);
         engine.d.b(g, "Всего ", 36 + (64 - engine.g.a.stringWidth("Всего ") >> 1), 138 + (20 - engine.g.b >> 1), 15597476, 7366729, 20);
         engine.d.b(g, String.valueOf(this.bo), 101 + (101 - engine.g.a.stringWidth(String.valueOf(this.bo)) >> 1), 138 + (20 - engine.g.b >> 1), 15597476, 6895186, 20);
         if (this.bh == 1) {
            engine.d.b(g, "Всего " + main.e.a(main.e.B[engine.d.m()], 8, false) * this.bo + "Золота ", -1, 168, 15597476, 6895186, 20);
         } else {
            engine.d.b(g, "Всего " + main.e.a(main.e.B[engine.d.m()], 8, false) / 4 * this.bo + "Золота ", -1, 168, 15597476, 6895186, 20);
         }

         if (d(65536)) {
            engine.d.a(false);
            this.bp = 0;
         } else if (d(49184)) {
            engine.d.a(false);
            this.bp = 2;
         } else {
            if (d(6416)) {
               if (this.bo > 1) {
                  this.bo--;
                  return;
               }
            } else if (d(9284)) {
               if (this.bh == 1) {
                  this.bo++;
                  return;
               }

               if (this.bo < main.e.a(main.e.B[engine.d.m()], 6, false)) {
                  this.bo++;
               }
            }
         }
      } else if (this.bp == 2) {
         int var1 = 0;
         if (this.bh == 1) {
            var1 = this.a("Подтверждаете " + main.e.y[engine.d.m()] + "выбор? ", "Да ", "Нет ");
         } else {
            var1 = this.a("Подтверждаете " + main.e.y[engine.d.m()] + "выбор? ", "Да ", "Нет ");
         }

         if (var1 == 1) {
            if (this.bh == 1) {
               if (aG >= main.e.a(main.e.B[engine.d.m()], 8, false) * this.bo) {
                  bs = main.e.y[engine.d.m()] + "Заходите еще ";
                  main.e.a(main.e.B[engine.d.m()], this.bo);
                  aG = aG - main.e.a(main.e.B[engine.d.m()], 8, false) * this.bo;
               } else {
                  bs = "Недостаточно денег ";
               }
            } else {
               bs = main.e.y[engine.d.m()] + "Продано. ";
               main.e.a(main.e.B[engine.d.m()], -this.bo);
               if (main.e.B[engine.d.m()] == main.e.s && main.e.a(main.e.B[engine.d.m()], 6, false) == 0) {
                  main.e.s = -1;
               }

               if (main.e.B[engine.d.m()] == main.e.t && main.e.a(main.e.B[engine.d.m()], 6, false) == 0) {
                  main.e.t = -1;
               }

               a(main.e.a(main.e.B[engine.d.m()], 8, false) / 4 * this.bo);
               main.e.d();
               main.e.n(14);
            }

            engine.d.a(false);
            L = true;
            this.bp = 0;
         } else {
            if (var1 == 2) {
               this.bp = 0;
            }
         }
      } else {
         engine.h.a(g, 12, 212, 214, 68, 6907220, 14593146);
         engine.h.a(g, 14, 214, 210, 64, 9600109, 8020827);
         engine.d.a(g, main.e.h(main.e.B[engine.d.m()]), 15597476, 16, 215, 206, 62);
         if (engine.d.c() && engine.a.b(20)) {
            engine.d.d();
         }

         if (d(65536)) {
            this.bo = 0;
            this.bh = 0;
            engine.d.l();
            main.e.d();
         } else {
            if (d(49184)) {
               this.bo = 1;
               if (this.bh != 2 || main.e.B[engine.d.m()] > 0) {
                  this.bp = 1;
                  return;
               }
            } else {
               if (d(1028)) {
                  engine.d.a(false);
                  engine.d.j();
                  return;
               }

               if (d(2304)) {
                  engine.d.a(false);
                  engine.d.k();
               }
            }
         }
      }
   }

   public final void b(boolean var1) {
      if (var1) {
         this.bg = new String[5];
         this.bg[0] = "Кузница ";
         this.bg[2] = "Ковка ";
         this.bg[3] = "Купить ";
         this.bg[4] = "Продать ";
         this.bg[1] = "   Задача   ";
      } else {
         this.bg = new String[4];
         this.bg[0] = "Кузница ";
         this.bg[1] = "Ковка ";
         this.bg[2] = "Купить ";
         this.bg[3] = "Продать ";
      }

      engine.d.a(false);
      this.j();
      k = 20;
   }

   private void t() {
      a(this.bg, this.bj, true, true);
      if (d(49184)) {
         if (this.bg.length == 4) {
            this.bh = this.bj + 1 + 100;
            if (this.bj == 3) {
               this.bg = null;
               this.bj = 0;
               this.bh = 0;
               engine.d.a(false);
               this.c(13);
               return;
            }
         } else {
            if (this.bj == 0) {
               this.bg = null;
               this.bj = 0;
               this.bh = 0;
               engine.d.a(false);
               this.c(13);
            }

            if (this.bj == 1) {
               this.bh = 101;
               return;
            }

            if (this.bj == 2) {
               this.bh = 102;
               return;
            }

            if (this.bj == 3) {
               this.bh = 103;
               return;
            }
         }
      } else {
         if (d(65536)) {
            this.bg = null;
            this.bj = 0;
            engine.d.a(false);
            this.c(false);
            this.g(K);

            for (int var1 = 0; var1 < main.a.e.length; var1++) {
               main.a.e[var1].a();
            }

            k = 7;
            return;
         }

         if (d(5140)) {
            this.bj--;
            if (this.bj < 0) {
               this.bj = this.bg.length - 2;
               return;
            }
         } else if (d(10560)) {
            this.bj++;
            if (this.bj > this.bg.length - 2) {
               this.bj = 0;
            }
         }
      }
   }

   private void u() {
      if (this.bg.length == 4) {
         if (this.bj == 1) {
            main.e.n(12);
            this.bh -= 100;
            engine.d.a(false);
            return;
         }
      } else if (this.bj == 2) {
         main.e.n(12);
         this.bh -= 100;
         engine.d.a(false);
         return;
      }

      a(new String[]{this.bg[this.bj + 1], "Оружие ", "Шлем ", "Броня ", "Амулет "}, this.bo, true, true);

      for (int var1 = 0; var1 < 5; var1++) {
         engine.h.a(g, aw, 64, 49 + var1 * 24, 16, 15, var1 + 1 << 4, 0);
      }

      if (d(65536)) {
         this.bh = 0;
         this.bo = 0;
      } else if (d(49184)) {
         main.e.n(this.bo + 5);
         this.bh -= 100;
         engine.d.a(false);
      }

      if (d(5140)) {
         this.bo--;
         if (this.bo < 0) {
            this.bo = 3;
            return;
         }
      } else if (d(10560)) {
         this.bo++;
         if (this.bo > 3) {
            this.bo = 0;
         }
      }
   }

   private void v() {
      engine.h.a(g, ay[0], 0, 320 - ay[0].getHeight());
      engine.h.a(g, ay[3], 2, 303, 17, 15, 0, 0);
      engine.h.a(g, h, ay[0], 213, 298, 27, 22, 0, 0);
      engine.h.a(g, ay[3], 221, 303, 17, 15, 17, 0);
      engine.d.b(g, this.bg[this.bj + 1], -1, 30 - engine.g.b >> 1, 15597476, 6764371, 20);
      engine.h.a(g, 80, 290, 78, 21, 7299920, 14658680);
      engine.h.a(g, 82, 291, 74, 19, 14658680, 16708041);
      engine.h.a(g, this.ar, 82, 292);
      engine.h.b(g, as, aG, 102, 297, 7, 7, 0);
      engine.d.a(g, main.e.y, null, main.e.z, 12, 56, 214, 6);
      engine.h.a(g, 12, 212, 214, 68, 6907220, 14593146);
      engine.h.a(g, 14, 214, 210, 64, 9600109, 8020827);
      engine.d.a(g, main.e.h(main.e.B[engine.d.m()]), 15597476, 16, 215, 206, 62);
      if (engine.d.c() && engine.a.b(20)) {
         engine.d.d();
      }

      if (d(65536)) {
         this.bh += 100;
         if (this.bg.length == 4) {
            if (this.bj == 1) {
               this.bh = 0;
               this.bo = 0;
            }
         } else if (this.bj == 2) {
            this.bh = 0;
            this.bo = 0;
         }

         engine.d.l();
         main.e.d();
      } else {
         if (d(49184)) {
            if (main.e.B[engine.d.m()] >= 0) {
               this.bh += 10;
               engine.d.a(false);
               return;
            }
         } else {
            if (d(1028)) {
               engine.d.a(false);
               engine.d.j();
               return;
            }

            if (d(2304)) {
               engine.d.a(false);
               engine.d.k();
            }
         }
      }
   }

   private void w() {
      engine.h.a(g, ay[0], 0, 320 - ay[0].getHeight());
      engine.h.a(g, ay[3], 2, 303, 17, 15, 0, 0);
      engine.h.a(g, h, ay[0], 213, 298, 27, 22, 0, 0);
      engine.h.a(g, ay[3], 221, 303, 17, 15, 17, 0);
      engine.d.b(g, main.e.y[engine.d.m()], -1, 5 + (20 - engine.g.b >> 1), 15597476, 6362880, 20);
      engine.h.a(g, 12, 46, 214, 144, 6907220, 14593146);
      engine.h.a(g, 14, 48, 210, 140, 9600109, 8020827);
      engine.h.a(g, 80, 290, 78, 21, 7299920, 14658680);
      engine.h.a(g, 82, 291, 74, 19, 14658680, 16708041);
      engine.h.a(g, this.ar, 82, 292);
      engine.h.b(g, as, aG, 102, 297, 7, 7, 0);
      if (L) {
         g(200, 60);
      } else {
         if (this.bp == 1) {
            int var1;
            if ((var1 = this.a("Подтверждаете " + main.e.y[engine.d.m()] + "выбор? ", "Да ", "Нет ")) != 1) {
               if (var1 == 2) {
                  this.bp = 0;
               }

               return;
            }

            if (aG >= main.e.l(main.e.B[engine.d.m()])) {
               bs = main.e.y[engine.d.m()] + "Успех обновления. ";
               aG = aG - main.e.l(main.e.B[engine.d.m()]);
               main.e.k(main.e.B[engine.d.m()]);
               if (main.e.a(main.e.B[engine.d.m()], 6, true) >= 5) {
                  main.e.a(11);
               }

               if (main.e.a(main.e.B[engine.d.m()], 6, true) >= 9) {
                  main.e.a(12);
               }

               if (main.e.a(main.e.B[engine.d.m()], 6, true) >= 15) {
                  main.e.a(13);
               }

               this.bp = 0;
            } else {
               bs = "Неудача, нехватка денег ";
               this.bp = 2;
            }

            engine.d.a(false);
            L = true;
         } else {
            if (this.bp == 2) {
               main.b.a(0);
               this.bp = 0;
               return;
            }

            engine.d.a(g, "Стоимость ковки  " + main.e.l(main.e.B[engine.d.m()]) + " Золотых монет " + main.e.h(main.e.B[engine.d.m()]), 15597476, 16, 49, 206, 138);
            if (d(65536)) {
               engine.d.a(false);
               if (k == 20) {
                  this.bh -= 10;
                  return;
               }

               this.bk = (byte)(this.bk - 10);
               return;
            }

            if (d(49184)) {
               if (engine.d.c()) {
                  if (!engine.d.d()) {
                     engine.d.a(false);
                     this.bp = 1;
                     return;
                  }
               } else {
                  engine.d.b();
               }
            }
         }
      }
   }

   private void x() {
      engine.h.a(g, ay[0], 0, 320 - ay[0].getHeight());
      engine.h.a(g, ay[3], 2, 303, 17, 15, 0, 0);
      engine.h.a(g, h, ay[0], 213, 298, 27, 22, 0, 0);
      engine.h.a(g, ay[3], 221, 303, 17, 15, 17, 0);
      engine.d.b(g, this.bg[this.bj + 1], -1, 30 - engine.g.b >> 1, 15597476, 6764371, 20);
      engine.h.a(g, 80, 290, 78, 21, 7299920, 14658680);
      engine.h.a(g, 82, 291, 74, 19, 14658680, 16708041);
      engine.h.a(g, this.ar, 82, 292);
      engine.h.b(g, as, aG, 102, 297, 7, 7, 0);
      if (L) {
         g(200, 60);
         if (!L) {
            engine.d.a(false);
            this.bh -= 10;
         }
      } else {
         int var1;
         if ((var1 = this.a(main.e.a(main.e.B[engine.d.m()], 8, false) + "Купить " + main.e.v[main.e.B[engine.d.m()]] + "? ", "Да ", "Нет ")) == 1) {
            if (aG >= main.e.a(main.e.B[engine.d.m()], 8, false)) {
               aG = aG - main.e.a(main.e.B[engine.d.m()], 8, false);
               main.e.a(main.e.B[engine.d.m()], 1);
               bs = "Заходите еще ";
            } else {
               bs = "Недостаточно денег ";
            }

            L = true;
            engine.d.a(false);
         } else {
            if (var1 == 2) {
               engine.d.a(false);
               this.bh -= 10;
            }
         }
      }
   }

   private void y() {
      engine.h.a(g, ay[0], 0, 320 - ay[0].getHeight());
      engine.h.a(g, ay[3], 2, 303, 17, 15, 0, 0);
      engine.h.a(g, h, ay[0], 213, 298, 27, 22, 0, 0);
      engine.h.a(g, ay[3], 221, 303, 17, 15, 17, 0);
      engine.d.b(g, this.bg[this.bj + 1], -1, 30 - engine.g.b >> 1, 15597476, 6764371, 20);
      engine.h.a(g, 80, 290, 78, 21, 7299920, 14658680);
      engine.h.a(g, 82, 291, 74, 19, 14658680, 16708041);
      engine.h.a(g, this.ar, 82, 292);
      engine.h.b(g, as, aG, 102, 297, 7, 7, 0);
      if (L) {
         g(164, 60);
      } else {
         int var1;
         if ((var1 = this.a(main.e.a(main.e.B[engine.d.m()], 8, false) / 2 + "Продать " + main.e.v[main.e.B[engine.d.m()]] + "? ", "Да ", "Нет ")) == 1) {
            if (main.e.B[engine.d.m()] == main.e.X[1]) {
               bs = "Используется ";
               engine.d.a(false);
               L = true;
            } else if (main.e.a(main.e.B[engine.d.m()], 8, false) == 0) {
               bs = "Этот пункт нельзя продать ";
               engine.d.a(false);
               L = true;
            } else {
               a(main.e.a(main.e.B[engine.d.m()], 8, false) / 2);
               main.e.j(main.e.B[engine.d.m()]);
               engine.d.a(false);
               this.bh -= 10;
               main.e.d();
               main.e.n(this.bo + 5);
            }
         } else {
            if (var1 == 2) {
               engine.d.a(false);
               this.bh -= 10;
            }
         }
      }
   }

   private void z() {
      a(new String[]{"Ковка ", "Оружие ", "Шлем ", "Броня ", "Амулет "}, this.bo, true, true);

      for (int var1 = 0; var1 < 5; var1++) {
         engine.h.a(g, aw, 64, 49 + var1 * 24, 16, 15, var1 + 1 << 4, 0);
      }

      if (d(65536)) {
         this.bh = 0;
         this.bo = 0;
         engine.d.a(false);
      } else if (d(49184)) {
         main.e.n(this.bo + 5);
         this.bk = (byte)(this.bk - 100);
         engine.d.a(false);
      }

      if (d(5140)) {
         this.bo--;
         if (this.bo < 0) {
            this.bo = 3;
            return;
         }
      } else if (d(10560)) {
         this.bo++;
         if (this.bo > 3) {
            this.bo = 0;
         }
      }
   }

   private void A() {
      engine.h.a(g, ay[0], 0, 320 - ay[0].getHeight());
      engine.h.a(g, ay[3], 2, 303, 17, 15, 0, 0);
      engine.h.a(g, h, ay[0], 213, 298, 27, 22, 0, 0);
      engine.h.a(g, ay[3], 221, 303, 17, 15, 17, 0);
      engine.d.b(g, "Реквизит ", -1, 30 - engine.g.b >> 1, 15597476, 6764371, 20);
      engine.h.a(g, 80, 290, 78, 21, 7299920, 14658680);
      engine.h.a(g, 82, 291, 74, 19, 14658680, 16708041);
      engine.h.a(g, this.ar, 84, 292);
      engine.h.b(g, as, aG, 102, 297, 7, 7, 0);
      engine.d.a(
         g,
         new String[]{"Лотерея ", "Телепорт ", "Стальные небеса ", "Летающий меч ", "Сила Титана ", "Небесная броня ", "Зелье прочности "},
         this.bl,
         null,
         12,
         66,
         214,
         6
      );
      if (L) {
         g(200, 60);
      } else if (this.bn == 1) {
         boolean var3 = false;
         var3 = false;
         engine.h.a(g, 32, 130, 176, 60, 6907220, 15580812);
         engine.h.a(g, 34, 132, 172, 56, 15580812, 16707534);
         g.setColor(13549230);
         g.fillRect(36, 138, 64, 20);
         g.fillRect(101, 138, 101, 20);
         engine.h.a(g, au, 146, 129, 11, 11, 22, 0);
         engine.h.a(g, au, 146, 155, 11, 11, 33, 0);
         engine.d.b(g, "Всего ", 36 + (64 - engine.g.a.stringWidth("Всего ") >> 1), 138 + (20 - engine.g.b >> 1), 15597476, 7366729, 20);
         engine.d.b(g, String.valueOf(this.bo), 101 + (101 - engine.g.a.stringWidth(String.valueOf(this.bo)) >> 1), 138 + (20 - engine.g.b >> 1), 15597476, 6895186, 20);
         engine.d.b(g, "Всего " + this.bl[engine.d.m()] * this.bo + "Золота ", -1, 168, 15597476, 6895186, 20);
         if (d(65536)) {
            engine.d.a(false);
            this.bn = 0;
         } else if (d(49184)) {
            engine.d.a(false);
            this.bn = 2;
         } else {
            if (d(6416)) {
               if (this.bo > 1) {
                  this.bo--;
                  return;
               }
            } else if (d(9284) && engine.d.m() != 0 && engine.d.m() != 2 && engine.d.m() != 3) {
               this.bo++;
            }
         }
      } else if (this.bn == 2) {
         int var1;
         if ((var1 = this.a("Потратить " + this.bl[engine.d.m()] * this.bo + "золота? ", "Да ", "Нет ")) == 1) {
            if (aG >= this.bl[engine.d.m()]) {
               aG = aG - this.bl[engine.d.m()] * this.bo;
               bs = "Заходите еще ";
               switch (engine.d.m()) {
                  case 0:
                     if ((var1 = engine.a.a(1000)) < 911) {
                        bs = "Поздравляем, читер, с призом 500 золотых ";
                        a(500);
                     } else if (var1 < 961) {
                        bs = "Поздравляем, читер, с призом 1000 золотых ";
                        a(1000);
                     } else if (var1 < 991) {
                        bs = "Поздравляем, читер, с призом 2000 золотых ";
                        a(2000);
                     } else if (var1 < 996) {
                        bs = "Поздравляем, читер, с призом 10000 золотых ";
                        a(10000);
                     } else if (var1 < 999) {
                        bs = "Поздравляем, читер, с призом 100 000 золотых ";
                        a(100000);
                     } else if (var1 < 1000) {
                        bs = "Поздравляем, читер, с призом 5000000 золотых ";
                        a(5000000);
                     }
                     break;
                  case 1:
                     main.e.a(53, this.bo);
                     break;
                  case 2:
                     main.e.c(1);
                     break;
                  case 3:
                     main.e.c(2);
                     break;
                  case 4:
                     main.e.a(50, this.bo);
                     break;
                  case 5:
                     main.e.a(51, this.bo);
                     break;
                  case 6:
                     main.e.a(52, this.bo);
               }

               this.bo = 0;
               this.bn = 0;
            } else {
               bs = "Денег недостаточно ";
               this.bn = 3;
            }

            engine.d.a(false);
            L = true;
         } else {
            if (var1 == 2) {
               this.bo = 0;
               this.bn = 0;
               engine.d.a(false);
            }
         }
      } else if (this.bn == 3) {
         main.b.a(0);
         this.bo = 0;
         this.bn = 0;
         engine.d.a(false);
      } else {
         engine.h.a(g, 12, 222, 214, 68, 6907220, 14593146);
         engine.h.a(g, 14, 224, 210, 64, 9600109, 8020827);
         engine.d.a(g, this.bm[engine.d.m()], 15597476, 16, 225, 208, 62);
         if (engine.d.c() && engine.a.b(20)) {
            engine.d.d();
         }

         if (d(65536)) {
            engine.d.a(false);
            engine.d.l();
            this.bh = 0;
            this.bo = 0;
         } else if (!d(49184)) {
            if (d(1028)) {
               engine.d.a(false);
               engine.d.j();
            } else {
               if (d(2304)) {
                  engine.d.a(false);
                  engine.d.k();
               }
            }
         } else {
            if ((!main.e.u[1] || engine.d.m() != 2) && (!main.e.u[2] || engine.d.m() != 3)) {
               this.bo = 1;
               this.bn = 1;
            } else {
               bs = "Этот навык уже изучен ";
               engine.d.a(false);
               L = true;
            }

            engine.d.a(false);
         }
      }
   }

   private void B() {
      this.D();
      switch (this.bj) {
         case 0:
            a(new String[]{"", "Магазин ", "Ковка ", "Джек Пот ", "Удача ", "Статус ", "Крит "}, this.bo, true, true);
            if (d(65536)) {
               this.bh = 0;
               this.bo = 0;
            } else if (d(49184)) {
               switch (this.bo) {
                  case 0:
                     this.bh = 8;
                     break;
                  case 1:
                     this.bh = 9;
                     this.bk = 101;
                     this.bo = 0;
                     break;
                  case 2:
                     main.b.a(0);
                     break;
                  case 3:
                     main.b.a(1);
                     break;
                  case 4:
                     main.b.a(2);
                     break;
                  case 5:
                     main.b.a(4);
               }
            }

            if (d(5140)) {
               this.bo--;
               if (this.bo < 0) {
                  this.bo = 5;
               }
            } else if (d(10560)) {
               this.bo++;
               if (this.bo > 5) {
                  this.bo = 0;
               }
            }
            break;
         case 1:
            g.setColor(6831623);
            g.fillRect(43, 86, 56, 29);
            engine.h.a(g, this.ap, 43, 55);
            engine.h.a(g, 44, 146, 150, 24, 7299920, 14658680);
            g.setColor(16708041);
            g.fillRect(47, 148, 50, 20);
            g.fillRect(99, 148, 92, 20);
            g.setColor(0);
            g.fillRect(43, 181, 152, 84);

            for (int var6 = 0; var6 < 4; var6++) {
               engine.h.a(g, 44, 184 + var6 * 21, 150, 15, 7096386, 6110524);
            }

            engine.h.a(g, 80, 276, 78, 21, 7299920, 14658680);
            engine.h.a(g, 82, 277, 74, 19, 14658680, 16708041);
            engine.h.a(g, this.ar, 84, 278);
            engine.h.b(g, as, aG, 102, 283, 7, 7, 0);
            engine.h.a(g, this.am, 103, 80, 25, 13, 0, 0);
            engine.h.a(g, 135, 81, 61, 4, 2497292, 5252865);
            engine.h.a(g, 135, 80, 61 * main.e.M / main.e.h(), 6, 2497292, 16364836);
            engine.h.a(g, 136, 81, 59 * main.e.M / main.e.h(), 4, 16364836, 16375322);
            engine.h.b(g, as, main.e.M, 162, 87, 7, 7, 1);
            engine.h.a(g, as, 162, 87, 7, 7, 70, 0);
            engine.h.b(g, as, main.e.h(), 169, 87, 7, 7, 0);
            engine.h.a(g, this.am, 103, 100, 25, 13, 0, 13);
            engine.h.a(g, 135, 101, 61, 4, 2497292, 5252865);
            engine.h.a(g, 135, 100, 61 * main.e.L / main.e.i(), 6, 2497292, 33254);
            engine.h.a(g, 136, 101, 59 * main.e.L / main.e.i(), 4, 33254, 5022438);
            engine.h.b(g, as, main.e.L, 162, 107, 7, 7, 1);
            engine.h.a(g, as, 162, 107, 7, 7, 70, 0);
            engine.h.b(g, as, main.e.i(), 169, 107, 7, 7, 0);
            engine.h.a(g, this.am, 103, 120, 25, 13, 0, 104);
            engine.h.a(g, 135, 121, 61, 4, 2497292, 5252865);
            engine.h.a(g, 135, 120, 61 * main.e.J / main.e.p(), 6, 2497292, 44836);
            engine.h.a(g, 136, 121, 59 * main.e.J / main.e.p(), 4, 44836, 59697);
            engine.h.b(g, as, main.e.J, 162, 127, 7, 7, 1);
            engine.h.a(g, as, 162, 127, 7, 7, 70, 0);
            engine.h.b(g, as, main.e.p(), 169, 127, 7, 7, 0);
            engine.h.a(g, this.am, 49, 121, 25, 13, 0, 26);
            engine.h.b(g, as, main.e.K, 83, 125, 7, 7, 0);
            engine.h.a(g, this.am, 59, 152, 25, 13, 0, 39);
            if (main.e.X[0] > 0) {
               engine.d.b(g, main.e.h[main.e.X[0] * 3], 143, 146 + (24 - engine.g.b >> 1), 15597476, 7085131, 17);
            } else {
               engine.d.b(g, "Нажмите 5 ", 143, 146 + (24 - engine.g.b >> 1), 15597476, 7085131, 17);
            }

            engine.h.a(g, this.am, 49, 185, 25, 13, 0, 52);
            engine.h.b(g, as, main.e.k(), 103, 188, 7, 7, 0);
            engine.h.a(g, this.am, 49, 206, 25, 13, 0, 65);
            engine.h.b(g, as, main.e.m(), 103, 209, 7, 7, 0);
            engine.h.a(g, this.am, 49, 227, 25, 13, 0, 78);
            engine.h.b(g, as, main.e.n(), 103, 230, 7, 7, 0);
            engine.h.a(g, this.am, 49, 248, 25, 13, 0, 91);
            engine.h.b(g, as, main.e.o(), 103, 251, 7, 7, 0);
            if (d(49184)) {
               engine.d.a(false);
               main.e.b(0);
               this.bh = 3;
            }
            break;
         case 2:
            a(new String[]{"", "Оружие ", "Шлем ", "Броня ", "Амулет "}, this.bo, true, true);

            for (int var5 = 0; var5 < 5; var5++) {
               engine.h.a(g, aw, 64, 49 + var5 * 24, 16, 15, var5 + 1 << 4, 0);
            }

            if (d(65536)) {
               this.bh = 0;
               this.bo = 0;
            } else if (d(49184)) {
               main.e.n(this.bo + 5);
               this.bh = 6;
            }

            if (d(5140)) {
               this.bo--;
               if (this.bo < 0) {
                  this.bo = 3;
               }
            } else if (d(10560)) {
               this.bo++;
               if (this.bo > 3) {
                  this.bo = 0;
               }
            }
            break;
         case 3:
            a(new String[]{"", "Вещи ", "Помощь ", "Материал "}, this.bo, true, true);
            if (d(65536)) {
               this.bh = 0;
               this.bo = 0;
            } else if (d(49184)) {
               this.bh = 7;
               main.e.n(this.bo + 9);
            }

            if (d(5140)) {
               this.bo--;
               if (this.bo < 0) {
                  this.bo = 2;
               }
            } else if (d(10560)) {
               this.bo++;
               if (this.bo > 2) {
                  this.bo = 0;
               }
            }
            break;
         case 4:
            engine.h.a(g, ay[0], 0, 320 - ay[0].getHeight());
            engine.h.a(g, ay[3], 2, 303, 17, 15, 0, 0);
            engine.h.a(g, h, ay[0], 213, 298, 27, 22, 0, 0);
            engine.h.a(g, ay[3], 221, 303, 17, 15, 17, 0);
            engine.d.a(g, main.e.y, null, null, 12, 56, 210, 4);
            engine.h.a(g, 12, 198, 210, 68, 6907220, 14593146);
            engine.h.a(g, 14, 200, 206, 64, 9600109, 8020827);
            if (L) {
               int var4;
               if ((var4 = this.a("Выберите клавишу для быстрого доступа", "7 ", "9 ")) == 1) {
                  if ((main.e.q = main.e.B[engine.d.m()]) == main.e.r) {
                     main.e.r = -1;
                     X = Y;
                     Y = 0;
                  }

                  engine.d.a(false);
                  L = false;
               } else if (var4 == 2) {
                  main.e.r = main.e.B[engine.d.m()];
                  if (main.e.q == main.e.r) {
                     main.e.q = -1;
                     Y = X;
                     X = 0;
                  }

                  engine.d.a(false);
                  L = false;
               }
            } else {
               if (main.e.B[engine.d.m()] < 0) {
                  engine.d.a(g, "Навыки не изучены ", 15597476, 16, 201, 206, 62);
               } else {
                  engine.d.a(g, main.e.p[main.e.B[engine.d.m()]], 15597476, 16, 201, 206, 62);
               }

               if (engine.d.c() && engine.a.b(20)) {
                  engine.d.d();
               }

               if (d(65536)) {
                  engine.d.a(false);
                  engine.d.l();
                  this.bh = 0;
               } else if (d(49184)) {
                  if (main.e.B[engine.d.m()] >= 0) {
                     L = true;
                  }

                  engine.d.a(false);
               } else if (d(1028)) {
                  engine.d.a(false);
                  engine.d.j();
               } else if (d(2304)) {
                  engine.d.a(false);
                  engine.d.k();
               }
            }
            break;
         case 5:
            if (!main.e.i(54)) {
               engine.d.b(g, "Навыки синтеза недоступны ", -1, 320 - engine.g.b >> 1, 15597476, 6764371, 20);
            } else {
               a(this.br, this.bo, true, true);

               for (int var2 = 0; var2 < 5; var2++) {
                  engine.h.a(g, aw, 64, 49 + var2 * 24, 16, 15, var2 << 4, 0);
               }

               if (d(65536)) {
                  this.bh = 0;
                  this.bo = 0;
               } else if (d(49184)) {
                  main.e.n(this.bo);
                  this.bh = 4;
               }

               if (d(5140)) {
                  this.bo--;
                  if (this.bo < 0) {
                     this.bo = 4;
                  }
               } else if (d(10560)) {
                  this.bo++;
                  if (this.bo > 4) {
                     this.bo = 0;
                  }
               }
            }
            break;
         case 6:
            engine.h.a(g, ay[0], 0, 320 - ay[0].getHeight());
            engine.h.a(g, ay[3], 2, 303, 17, 15, 0, 0);
            engine.h.a(g, h, ay[0], 213, 298, 27, 22, 0, 0);
            engine.h.a(g, ay[3], 221, 303, 17, 15, 17, 0);
            engine.h.a(g, 12, 46, 214, 24, 7299920, 14658680);
            g.setColor(16708041);
            g.fillRect(15, 48, 208, 20);
            engine.d.b(g, "Список задач ", -1, 46 + (24 - engine.g.b >> 1), 15597476, 7085131, 20);
            engine.d.a(g, main.e.y, null, null, 12, 71, 214, 7);
            if (L) {
               g(176, 120);
            } else if (d(65536)) {
               engine.d.a(false);
               engine.d.l();
               this.bh = 0;
            } else if (d(49184) && main.e.B[engine.d.m()] >= 0) {
               bs = main.e.D(main.e.B[engine.d.m()]);
               L = true;
               engine.d.a(false);
            } else if (d(1028)) {
               engine.d.a(false);
               engine.d.j();
            } else if (d(2304)) {
               engine.d.a(false);
               engine.d.k();
            }
      }

      if (!L) {
         if (!d(65536)) {
            if (d(4112)) {
               this.bh = 1;
               f = 0;
               this.bo = 0;
               engine.d.l();
               engine.d.a(false);
            } else {
               if (d(8256)) {
                  this.bh = 2;
                  f = 0;
                  this.bo = 0;
                  engine.d.a(false);
               }
            }
         } else {
            this.bj = 0;
            this.bo = 0;
            engine.d.l();
            engine.d.a(false);
            this.c(false);
            this.g(K);

            for (int var3 = 0; var3 < main.a.e.length; var3++) {
               main.a.e[var3].a();
            }

            k = 7;
         }
      }
   }

   private void C() {
      engine.h.a(g, ay[0], 0, 320 - ay[0].getHeight());
      engine.h.a(g, ay[3], 2, 303, 17, 15, 0, 0);
      engine.h.a(g, h, ay[0], 213, 298, 27, 22, 0, 0);
      engine.h.a(g, ay[3], 221, 303, 17, 15, 17, 0);
      engine.d.b(g, main.e.y[engine.d.m()], -1, 5 + (20 - engine.g.b >> 1), 15597476, 6362880, 20);
      engine.h.a(g, 12, 76, 214, 144, 6907220, 14593146);
      engine.h.a(g, 14, 78, 210, 140, 9600109, 8020827);
      engine.h.a(g, 80, 290, 78, 21, 7299920, 14658680);
      engine.h.a(g, 82, 291, 74, 19, 14658680, 16708041);
      engine.h.a(g, this.ar, 82, 292);
      engine.h.b(g, as, aG, 102, 297, 7, 7, 0);
      if (L) {
         g(200, 60);
      } else {
         int var1 = 0;
         if (this.bp == 1) {
            engine.d.a(g, main.e.d(main.e.a(main.e.B[engine.d.m()], 7, false)), 15597476, 16, 79, 206, 138);
            if (d(65536)) {
               engine.d.a(false);
               this.bh = 4;
               this.bp = 0;
               return;
            }

            if (d(49184)) {
               if (!engine.d.c()) {
                  engine.d.b();
                  return;
               }

               if (!engine.d.d()) {
                  engine.d.a(false);
                  this.bp = 3;
                  return;
               }
            }
         } else if (this.bp == 2) {
            engine.d.a(g, "Синтез требует " + main.e.g(main.e.B[engine.d.m()]) + " Золотых монет ", 15597476, 16, 79, 206, 138);
            if (d(65536)) {
               engine.d.a(false);
               this.bh = 4;
               this.bp = 0;
               return;
            }

            if (d(49184)) {
               if (!engine.d.c()) {
                  engine.d.b();
                  return;
               }

               if (!engine.d.d()) {
                  engine.d.a(false);
                  this.bp = 4;
                  return;
               }
            }
         } else if (this.bp == 3) {
            if ((var1 = this.a("Синтез " + main.e.y[engine.d.m()] + "? ", "Да ", "Нет ")) == 1) {
               if (main.e.e(main.e.a(main.e.B[engine.d.m()], 7, false))) {
                  bs = main.e.y[engine.d.m()] + "Синтезировано ";
                  main.e.a(main.e.B[engine.d.m()], 1);
                  main.e.f(main.e.a(main.e.B[engine.d.m()], 7, false));

                  for (int var3 = 1; var3 < main.e.X.length; var3++) {
                     if (!main.e.i(main.e.X[var3])) {
                        main.e.X[var3] = -1;
                     }
                  }

                  g();
               } else {
                  bs = "Недостаточно материалов для синтеза ";
               }

               engine.d.a(false);
               L = true;
               this.bp = 6;
               return;
            }

            if (var1 == 2) {
               this.bp = 0;
               engine.d.a(false);
               this.bh = 4;
               return;
            }
         } else if (this.bp == 4) {
            if ((var1 = this.a("Синтез " + main.e.y[engine.d.m()] + "? ", "Да ", "Нет ")) == 1) {
               if (aG >= main.e.g(main.e.B[engine.d.m()])) {
                  aG = aG - main.e.g(main.e.B[engine.d.m()]);
                  bs = main.e.y[engine.d.m()] + "Синтезировано ";
                  main.e.a(main.e.B[engine.d.m()], 1);

                  for (int var5 = 1; var5 < main.e.X.length; var5++) {
                     if (!main.e.i(main.e.X[var5])) {
                        main.e.X[var5] = -1;
                     }
                  }

                  g();
                  this.bp = 6;
               } else {
                  bs = "Недостаточно денег для синтеза ";
                  this.bp = 5;
               }

               engine.d.a(false);
               L = true;
               return;
            }

            if (var1 == 2) {
               this.bp = 0;
               engine.d.a(false);
               this.bh = 4;
               return;
            }
         } else {
            if (this.bp == 5) {
               main.b.a(0);
               this.bp = 6;
               engine.d.a(false);
               return;
            }

            if (this.bp == 6) {
               this.bp = 0;
               engine.d.a(false);
               this.bh = 4;
               return;
            }

            if ((var1 = this.a("Выберите метод синтеза ", "Материал ", "Золота ")) == 1) {
               this.bp = 1;
               engine.d.a(false);
               return;
            }

            if (var1 == 2) {
               this.bp = 2;
               engine.d.a(false);
            }
         }
      }
   }

   private void D() {
      engine.h.a(g, ay[0], 0, 320 - ay[0].getHeight());
      engine.h.a(g, ay[3], 2, 303, 17, 15, 0, 0);
      engine.h.a(g, h, ay[0], 213, 298, 27, 22, 0, 0);
      engine.h.a(g, ay[3], 221, 303, 17, 15, 17, 0);
      engine.h.a(g, av, 50, 3);
      if (this.bj > 0) {
         engine.d.b(g, this.bi[this.bj - 1], 32 + f, 3 + (24 - engine.g.b >> 1), 14918185, 6764371, 17);
         engine.h.a(g, au, 39, 9, 11, 11, 0, 0);
      } else if (this.bj == 0) {
         engine.d.b(g, this.bi[6], 32 + f, 3 + (24 - engine.g.b >> 1), 14918185, 6764371, 17);
         engine.h.a(g, au, 39, 9, 11, 11, 0, 0);
      }

      if (this.bh != 1 && this.bh != 2) {
         engine.d.b(g, this.bi[this.bj], 72 + f, 3 + (24 - engine.g.b >> 1), 16239730, 6764371, 17);
      } else {
         engine.d.b(g, this.bi[this.bj], 72 + f, 3 + (24 - engine.g.b >> 1), 14918185, 6764371, 17);
      }

      if (this.bj < 6) {
         engine.d.b(g, this.bi[this.bj + 1], 112 + f, 3 + (24 - engine.g.b >> 1), 14918185, 6764371, 17);
         engine.h.a(g, au, 94, 9, 11, 11, 11, 0);
      } else {
         if (this.bj == 6) {
            engine.d.b(g, this.bi[0], 112 + f, 3 + (24 - engine.g.b >> 1), 14918185, 6764371, 17);
            engine.h.a(g, au, 94, 9, 11, 11, 11, 0);
         }
      }
   }

   private void E() {
      engine.h.a(g, ay[0], 0, 320 - ay[0].getHeight());
      engine.h.a(g, ay[3], 2, 303, 17, 15, 0, 0);
      engine.h.a(g, h, ay[0], 213, 298, 27, 22, 0, 0);
      engine.h.a(g, ay[3], 221, 303, 17, 15, 17, 0);
      engine.d.b(g, "Вещи ", -1, 30 - engine.g.b >> 1, 15597476, 6764371, 20);
      engine.h.a(g, 12, 46, 214, 24, 7299920, 14658680);
      g.setColor(16708041);
      g.fillRect(15, 48, 82, 20);
      g.fillRect(99, 48, 124, 20);
      engine.d.b(g, "Оружие ", 58, 46 + (24 - engine.g.b >> 1), 15597476, 6764371, 17);
      engine.d.b(g, main.e.X[this.bo + 1] < 0 ? "Не оборудовано " : main.e.v[main.e.X[this.bo + 1]], 161, 46 + (24 - engine.g.b >> 1), 15597476, 7085131, 17);
      engine.d.a(g, main.e.y, null, null, 12, 71, 214, 5);
      engine.h.a(g, 12, 222, 214, 68, 6907220, 14593146);
      engine.h.a(g, 14, 224, 210, 64, 9600109, 8020827);
      if (L) {
         g(200, 60);
      } else {
         engine.d.a(g, main.e.h(main.e.B[engine.d.m()]), 15597476, 16, 225, 208, 62);
         if (engine.d.c() && engine.a.b(20)) {
            engine.d.d();
         }

         if (d(65536)) {
            engine.d.a(false);
            engine.d.l();
            main.e.d();
            this.bh = 0;
         } else if (d(49184) && main.e.B[engine.d.m()] > -2) {
            if (main.e.B[engine.d.m()] < 0 && this.bo == 0) {
               bs = "Не может быть удалена, оружие можно только заменить. ";
            } else {
               main.e.X[this.bo + 1] = main.e.B[engine.d.m()];
               if (main.e.X[this.bo + 1] < 0) {
                  bs = "Оборудование удалено ";
               } else {
                  bs = main.e.v[main.e.X[this.bo + 1]] + "Экипировано ";
                  if (this.bo == 0) {
                     g();
                     m[1] = null;
                     m[2] = null;
                     m[3] = null;
                     System.gc();
                     int var2 = main.e.I / 4 + 1;

                     try {
                        if (m[var2] == null) {
                           m[var2] = Image.createImage("/zhujiao" + (var2 + 1) + ".png");
                        }
                     } catch (Exception var1) {
                     }

                     for (int var3 = 0; var3 < 5; var3++) {
                        main.a.e[var3].a();
                     }
                  }
               }
            }

            L = true;
            engine.d.a(false);
         } else if (d(1028)) {
            engine.d.a(false);
            engine.d.j();
         } else {
            if (d(2304)) {
               engine.d.a(false);
               engine.d.k();
            }
         }
      }
   }

   public static void g() {
      switch (main.e.X[1]) {
         case 0:
         case 1:
         case 2:
         case 3:
         case 4:
            main.e.I = main.e.X[1] + 1;
            break;
         case 5:
         case 6:
         case 7:
         case 8:
         case 9:
            main.e.I = main.e.X[1] + 2;
            break;
         case 10:
            main.e.I = 0;
            break;
         case 11:
            main.e.I = 6;
      }

      d var0 = main.a.c[c];
      if (c == 0 && (var0.g == 0 || var0.g == 3 || var0.g >= 20 && var0.g <= 41)) {
         main.a.c[c].b(0, main.e.G[main.e.I]);
         main.a.c[c].c(main.e.G[main.e.I], 1);
      }
   }

   private void F() {
      engine.h.a(g, 0);
      g.drawImage(ay[2], 0, 0, 20);
      engine.d.b(g, "Летопись ", -1, 30 - engine.g.b >> 1, 15597476, 6764371, 20);

      for (int var1 = 0; var1 < 3; var1++) {
         engine.h.a(g, -1, 97 + var1 * 54, 162, 52, 6907220, 14593146);
         if (bt == var1) {
            engine.h.a(g, -1, 99 + var1 * 54, 158, 48, 14593146, 16708041);
         } else {
            engine.h.a(g, -1, 99 + var1 * 54, 158, 48, 14593146, 13549230);
         }

         if (this.bu[var1]) {
            engine.d.b(g, "Летопись " + (var1 + 1), -1, 97 + (52 - engine.g.b >> 1) + var1 * 54, 15597476, 7366729, 20);
         } else {
            engine.d.b(g, "Нет архива ", -1, 97 + (52 - engine.g.b >> 1) + var1 * 54, 0, 10395294, 20);
         }
      }

      engine.h.a(g, ay[0], 0, 320 - ay[0].getHeight());
      engine.h.a(g, ay[3], 2, 303, 17, 15, 0, 0);
      engine.h.a(g, h, ay[0], 213, 298, 27, 22, 0, 0);
      engine.h.a(g, ay[3], 221, 303, 17, 15, 17, 0);
      g.drawImage(ay[9], 0, 24, 20);
      switch (aE) {
         case 0:
            if (d(49184)) {
               if (this.bu[bt]) {
                  engine.d.a(false);
                  aE = 1;
               } else {
                  this.I();
                  engine.d.a(false);
                  k = 2;
               }
            } else if (d(65536)) {
               k = 5;
            }

            if (d(5140)) {
               if (--bt < 0) {
                  bt = 2;
                  return;
               }
            } else if (d(10560) && ++bt > 2) {
               bt = 0;
               return;
            }
            break;
         case 1:
            int var4;
            if ((var4 = this.a("Архив " + (bt + 1), "Загр ", "Уд ")) == 1) {
               this.I();
               this.k(bt);
               engine.d.a(false);
               k = 2;
            } else if (var4 == 2) {
               engine.d.a(false);
               aE = 2;
            }

            if (d(65536)) {
               aE = 0;
               return;
            }
            break;
         case 2:
            int var3;
            if ((var3 = this.a("Уверены, что хотите удалить " + (bt + 1) + "данные? ", "Да ", "Назад ")) == 1) {
               try {
                  RecordStore.deleteRecordStore(this.aW + bt);
               } catch (RecordStoreException var2) {
               }

               this.bu[bt] = false;
               engine.d.a(false);
               aE = 0;
            } else if (var3 == 2) {
               aE = 0;
               engine.d.a(false);
            }

            if (d(65536)) {
               aE = 0;
            }
      }
   }

   public static boolean d(int var0) {
      return (i & var0) != 0;
   }

   private static void e(int var0, int var1) {
      var0 = bw.length * engine.g.b;
      var0 = 160 - var0 / 2;
      var1 = 0;
      int var2 = 1;

      for (int var6 = var0 - 13; var1 < bw.length; var1++) {
         String var3 = bw[var1];
         if (var1 == 2) {
            var3 = bw[var1] + aD;
         }

         engine.d.b(g, var3, 120, var6 + var2 * engine.g.b, 0, 16777215, 17);
         var2++;
      }
   }

   private static void f(int var0, int var1) {
      if (aJ > 0) {
         var0 = bw.length * engine.g.b;
         var0 = 160 - var0 / 2 - 13;
         if ((aH[0] & 65535) != 39) {
            var0 += 10;
         }

         var1 = ae - 1;

         for (int var2 = 0; var2 < ae; var2++) {
            if ((aH[var2] & 131072) != 0) {
               var1--;
            }
         }

         String var6 = bw[var1];
         if (var1 == 2) {
            var6 = bw[var1] + aD;
         }

         engine.d.b(g, var6, 120, var0 + var1 * engine.g.b + engine.g.b, 0, 6461906, 17);
      }
   }

   public static void h() {
      f = 0;
      bx = true;
      k = 9;
   }

   public static void a(int var0, int var1) {
      if (var0 < 0) {
         bD[0] = var0;
         bD[1] = var0;
         bD[2] = var0;
         bD[3] = var0;
         aP = false;
      } else {
         bE = c;
         bD[0] = var0 % 10;
         bD[1] = var0 / 10 % 10;
         bD[2] = var0 / 100 % 10;
         bD[3] = var0 / 1000;
         aP = true;
      }
   }

   private void G() {
      if (aP && k == 7 && K != 610) {
         int var1 = (main.a.c[bE].c >> 8) - main.a.a - 9;
         int var2 = (main.a.c[bE].d >> 8) - main.a.b - 18;
         int var3 = 0;
         int var4 = 0;

         for (int var5 = 0; var5 < bD.length; var5++) {
            if (bD[var5] > 0) {
               if (bE == c) {
                  switch (bD[var5]) {
                     case 1:
                        var3 = var1;
                        var4 = var2 - 18 + main.a.c[c].b[1];
                        break;
                     case 2:
                        var3 = var1 - 18;
                        var4 = var2 - 14;
                        break;
                     case 3:
                     default:
                        var3 = var1;
                        var4 = var2 + main.a.c[c].b[1];
                        break;
                     case 4:
                        var3 = var1 + 18;
                        var4 = var2 - 14;
                  }
               } else {
                  var3 = var1;
                  var4 = var2 + main.a.c[bE].b[1];
               }

               g.setClip(var3, var4, 18, 18);
               if (this.bC % 6 < 3) {
                  g.drawImage(B, var3, var4 - 24, 20);
                  int var10000 = var3 + 3;
                  int var10001 = var4 + 3;
                  int var6 = bD[var5] - 1;
                  var4 = var10001;
                  var3 = var10000;
                  g.setClip(var3, var4, 12, 12);
                  g.drawImage(B, var3 - var6 * 12, var4, 20);
               } else {
                  g.drawImage(B, var3 - 18, var4 - 24, 20);
                  int var14 = var3 + 3;
                  int var15 = var4 + 3;
                  int var13 = bD[var5] - 1;
                  var4 = var15;
                  var3 = var14;
                  g.setClip(var3, var4, 12, 12);
                  g.drawImage(B, var3 - var13 * 12, var4 - 12, 20);
               }
            }
         }

         this.bC++;
      }
   }

   private void H() {
      if (!engine.c.e) {
         if (main.d.uiIconFor != main.e.I) {
            main.d.uiBuildWeaponIcon();
         }
         if (main.a.c[c].a[3] || K != 701) {
            g.translate(-engine.View.extra(), 0); // портрет и шкалы — у левого края широкого экрана
            engine.h.a(g, this.al, 0, 0);
            engine.h.a(g, 32, 21, 66 * main.e.M / main.e.h(), 5, 16375322, 16364836);
            engine.h.a(g, 32, 31, 52 * main.e.L / main.e.i(), 2, 33254, 5022438);
            engine.h.a(g, 32, 38, 37 * main.e.J / main.e.p(), 2, 11927296, 11927296);
            g.translate(engine.View.extra(), 0);
            if (!L && k == 7 && !T && !M && !aQ) {
               main.e.j();
               engine.h.a(g, this.ao, 80, 299, 20, 20, 0, 11);
               engine.h.a(g, this.ao, 100, 299, 20, 20, 0, 11);
               engine.h.a(g, this.ao, 120, 299, 20, 20, 0, 11);
               engine.h.a(g, this.ao, 140, 299, 20, 20, 0, 11);
               if (main.e.s >= 0) {
                  engine.h.a(g, this.an, 84, 302, 12, 12, (main.e.s - 42) * 12, 0);
               }

               if (main.e.t >= 0) {
                  engine.h.a(g, this.an, 104, 302, 12, 12, (main.e.t - 42) * 12, 0);
               }

               if (main.e.q >= 0) {
                  engine.h.a(g, this.an, 124, 302, 12, 12, 144 + main.e.q * 12, 0);
               }

               if (main.e.r >= 0) {
                  engine.h.a(g, this.an, 144, 302, 12, 12, 144 + main.e.r * 12, 0);
               }

               if (X > 0) {
                  engine.h.a(g, this.ao, 124, 301, 12, X, 20, 11);
                  if (this.l(10)) {
                     X--;
                  }
               }

               if (Y > 0) {
                  engine.h.a(g, this.ao, 144, 301, 12, Y, 20, 11);
                  if (this.l(10)) {
                     Y--;
                  }
               }

               engine.h.a(g, this.ao, 88, 309, 11, 11, 0, 0);
               engine.h.a(g, this.ao, 108, 309, 11, 11, 11, 0);
               engine.h.a(g, this.ao, 128, 309, 11, 11, 22, 0);
               engine.h.a(g, this.ao, 148, 309, 11, 11, 33, 0);
               if (k == 7 && K != 0 && K != 610 && K != 701 && K != 702 && this.bH++ > 100) {
                  this.bH = 0;
                  b(this.bF[this.bG]);
                  this.bG++;
                  if (this.bG >= this.bF.length) {
                     this.bG = 0;
                  }
               }

               if ((i & 65536) != 0 && main.e.M > 0) {
                  engine.d.a(false);
                  this.j();
                  k = 17;
               }
            }
         }

         for (int var2 = 0; var2 < bI.length; var2++) {
            if (bI[var2][0] == 1) {
               g.setClip(0, 0, 240, 60);
               g.setColor(16777215);
               g.setFont(engine.g.a);
               g.drawString(bJ[var2], 240 - engine.g.a.stringWidth(bJ[var2]), bI[var2][1], 20);
               bI[var2][1] = bI[var2][1] - 2;
               if (bI[var2][1] < -20) {
                  bI[var2][0] = 0;
               }
            }
         }
      }
   }

   public static void b(String var0) {
      for (int var1 = 0; var1 < bI.length; var1++) {
         if (bI[var1][0] == 0) {
            bJ[var1] = var0;
            bI[var1][0] = 1;
            bI[var1][1] = 60;
            if (60 - bI[bK][1] <= 20) {
               bI[var1][1] = 80 - (60 - bI[bK][1]);
            }

            bK = var1;
            return;
         }
      }
   }

   public static void e(int var0) {
      switch (var0) {
         case 1:
            X = 14;
            return;
         case 2:
            Y = 14;
      }
   }

   private boolean l(int var1) {
      this.bL++;
      if (this.bL >= 10) {
         this.bL = 0;
         return true;
      } else {
         return false;
      }
   }

   private static void a(String[] var0, int var1, boolean var2, boolean var3) {
      engine.d.b(g, var0[0], -1, 30 - engine.g.b >> 1, 15597476, 6764371, 20);
      engine.h.a(g, ay[5], (240 - ay[6].getWidth() >> 1) + 8, 32);
      engine.h.a(g, h, ay[5], (240 + ay[6].getWidth() >> 1) - 8 - 15, 32, 15, 28, 0, 0);
      engine.h.a(g, ay[7], (240 - ay[6].getWidth() >> 1) + 10, 42 + (var0.length - 1) * 24);
      engine.h.a(g, h, ay[7], (240 + ay[6].getWidth() >> 1) - 10 - 10, 42 + (var0.length - 1) * 24, 10, 20, 0, 0);

      for (int var4 = 0; var4 < var0.length - 1; var4++) {
         if (var4 < var0.length - 2) {
            engine.h.a(g, ay[8], (240 - ay[6].getWidth() >> 1) + 13, 56 + var4 * 24);
            engine.h.a(g, ay[8], (240 + ay[6].getWidth() >> 1) - 17, 56 + var4 * 24);
         }

         if (var1 == var4) {
            engine.h.a(g, ay[6], 240 - ay[6].getWidth() >> 1, 46 + var4 * 24, 148, 21, 0, 0);
         } else {
            engine.h.a(g, ay[6], 240 - ay[6].getWidth() >> 1, 46 + var4 * 24, 148, 21, 0, 21);
         }

         engine.d.b(g, var0[var4 + 1], -1, 46 + var4 * 24 + (21 - engine.g.b >> 1), 15597476, 6764371, 20);
      }

      engine.h.a(g, ay[4], (240 - engine.g.a.stringWidth(var0[var1 + 1]) >> 1) - 14, 48 + var1 * 24);
      engine.h.a(g, h, ay[4], (240 + engine.g.a.stringWidth(var0[var1 + 1]) >> 1) + 2, 48 + var1 * 24, 12, 17, 0, 0);
      engine.h.a(g, ay[0], 0, 320 - ay[0].getHeight());
      engine.h.a(g, ay[3], 2, 303, 17, 15, 0, 0);
      engine.h.a(g, h, ay[0], 213, 298, 27, 22, 0, 0);
      engine.h.a(g, ay[3], 221, 303, 17, 15, 17, 0);
   }

   public final void i() {
      this.c(true);

      for (int var1 = 0; var1 < ay.length; var1++) {
         if (ay[var1] == null) {
            a(var1, "/splash" + var1 + ".png");
         }
      }

      f = 0;
      ae = 1;
      this.bA = false;
      aI = -1;
      this.aR = 0;
      bx = false;
      N = false;
      if (aN) {
         this.ab.a("menu", true, 1);
      }

      k = 5;
   }

   private void I() {
      main.e.x = new int[main.e.w.length];
      System.arraycopy(main.e.w, 0, main.e.x, 0, main.e.x.length);
      main.e.D = new int[main.e.E.length];
      System.arraycopy(main.e.E, 0, main.e.D, 0, main.e.D.length);
      aG = 0;
      main.e.X[0] = 0;
      main.e.X[1] = 10;

      for (int var1 = 2; var1 < main.e.X.length; var1++) {
         main.e.X[var1] = -1;
      }

      for (int var2 = 0; var2 < main.e.u.length; var2++) {
         main.e.u[var2] = false;
      }

      S[0] = 0;

      for (int var3 = 1; var3 < S.length; var3++) {
         S[var3] = 10;
      }

      main.e.J = 0;
      main.e.K = 1;
      main.e.L = main.e.i();
      main.e.M = main.e.h();
      main.e.C = 0;
      main.e.g = 0;
      main.e.I = 0;
      main.e.s = -1;
      main.e.t = -1;
      main.e.q = -1;
      main.e.r = -1;
      main.e.N = 0;
      main.e.O = 0;
      main.e.P = 0;
      main.e.Q = 0;
      main.e.R = 0;
      G = true;
      main.e.j = 0;
      V = -1;
      K = 701;
      main.e.g();
      Q = 4;
      L = false;
      C = false;
      this.aR = 0;
      T = false;
      H = 0;
      aP = false;
      this.bC = 0;
      this.aU = 0;
   }

   private void m(int var1) {
      switch (k) {
         case 9:
            switch (var1 & 65535) {
               case 1:
               case 36:
                  k = 7;
                  this.by = 0;
                  f = 0;
                  if (aN) {
                     if (K != 0 && K != 610 && K != 701 && K != 702) {
                        this.ab.a("gate", true, 1);
                        return;
                     }

                     this.ab.a("menu", true, 1);
                     return;
                  }

                  this.ab.a();
                  return;
               case 2:
                  this.i();
                  this.by = 0;
                  return;
               case 3:
                  aD = (aN = !aN) ? "На " : "Близко ";
                  return;
               case 4:
                  k = 11;
                  aO = 3;
                  return;
               case 5:
                  k = 0;
            }
      }
   }

   public static void f(int var0) {
      ah = var0;
      j = 0;
      i = 0;
      af = 0;
   }

   private void J() {
      if (aJ > 1) {
         if ((i & 5140) != 0) {
            while (true) {
               if (--ae <= 0) {
                  ae = aH.length - 3;
               }

               if ((aH[ae] & 131072) == 0) {
                  f = 0;
                  break;
               }
            }
         } else if ((i & 10560) != 0) {
            do {
               if (++ae > aH.length - 3) {
                  ae = 1;
               }
            } while ((aH[ae] & 131072) != 0);

            f = 0;
         }

         if (((i & 16416) != 0 || (i & 32768) != 0) && aJ > 1) {
            aI = aH[ae];
            bM = 3;
            return;
         }
      } else {
         aI = aH[aH.length - 1];
         bM = 3;
         if (aJ == 0) {
            this.m(aI);
            return;
         }
      }
   }

   private static void n(int var0) {
      ae = 1;
      aH = aF;
      aJ = 0;

      for (int var1 = 1; var1 <= aH.length - 3; var1++) {
         if ((aH[var1] & 131072) == 0) {
            aJ++;
         }
      }

      if (aJ > 0) {
         while ((aH[ae] & 131072) != 0) {
            if (++ae > aH.length - 3) {
               ae = 1;
            }
         }
      }

      bM = 0;
      aI = -1;
   }

   public static void b(int var0, int var1) {
      if (var0 != bQ || bS != var1) {
         if (!L) {
            bS = var1;
            bR = 0;
            bQ = var0;
            L = true;
            engine.d.a(false);
            switch (bS) {
               case 0:
                  bT = main.e.F(bQ);
                  return;
               case 1:
                  bT = main.e.C(bQ);
                  return;
               case 2:
                  bT = main.e.E(bQ);
            }
         }
      }
   }

   /** Окно диалога вверху экрана: портрет говорящего слева, имя и текст справа. */
   private void drawDialog(int color) {
      String[] sp = splitSpeaker(bT[bR]);
      int ex = Math.min(engine.View.extra(), 40);
      int x = -ex;
      int w = 240 + ex * 2;
      int y = 6;
      int h = 84;
      engine.d.panel(g, x, y, w, h);
      int tx = x + 12;
      Image face = this.bU ? this.aq : null;
      if (face != null) {
         int fw = face.getWidth();
         int fh = face.getHeight();
         // рамка портрета
         g.setColor(0x2A1B10);
         g.fillRect(x + 8, y + 8, 64, h - 16);
         g.setColor(0xC9A04A);
         g.fillRect(x + 9, y + 9, 62, h - 18);
         g.setColor(0x6E5A7A);
         g.fillRect(x + 10, y + 10, 60, h - 20);
         g.setColor(0x8F7BA0);
         g.fillRect(x + 10, y + 10, 60, (h - 20) / 2);
         g.setClip(x + 10, y + 10, 60, h - 20);
         g.drawImage(face, x + 10 + (60 - fw >> 1), y + h - 10 - fh, 20);
         g.setClip(0, 0, 240, 320);
         tx = x + 80;
      }
      int tw = x + w - 12 - tx;
      int ty = y + 8;
      if (sp[0] != null) {
         engine.d.b(g, sp[0], tx, y + 6, 0x9A3412, 0xFEEFCE, 20);
         g.setColor(0xC9A04A);
         g.fillRect(tx, y + 7 + engine.g.b, tw, 1);
         ty = y + 11 + engine.g.b;
      }
      int lines = Math.max(1, (y + h - 8 - ty) / engine.g.b);
      engine.d.a(g, sp[1], color, tx, ty, tw, lines * engine.g.b);
      if (engine.d.c() && (System.currentTimeMillis() / 350 & 1) == 0) {
         int ax = x + w - 18;
         int ay = y + h - 14;
         g.setColor(0x9A3412);
         g.fillRect(ax, ay, 9, 2);
         g.fillRect(ax + 1, ay + 2, 7, 2);
         g.fillRect(ax + 2, ay + 4, 5, 2);
         g.fillRect(ax + 3, ay + 6, 3, 2);
      }
   }

   /** Делит реплику "Имя: текст" на имя и текст. Если имени нет - имя null. */
   private static String[] splitSpeaker(String line) {
      int n = Math.min(line.length(), 18);
      for (int i = 1; i < n; i++) {
         char c = line.charAt(i);
         if (c == ':' || c == '\uFF1A') {
            String name = line.substring(0, i).trim();
            if (name.length() > 0 && name.indexOf(' ') < 0) {
               return new String[]{name, line.substring(i + 1).trim()};
            }
            break;
         }
         if (c == '.' || c == '!' || c == '?' || c == ',' || c == ' ') {
            break;
         }
      }
      return new String[]{null, line.trim()};
   }

   private void K() {
      String[] sp = splitSpeaker(bT[bR]);
      String var1 = sp[0] == null ? "" : sp[0] + ": ";
      String var4 = "";
      this.bU = true;
      if (var1.equals("Atlantida: ")) {
         var4 = "head2.png";
      } else if (var1.equals("virusfon: ")) {
         if (main.a.c[c].a[3] || K != 701 && K != 702) {
            var4 = "head0.png";
         } else {
            var4 = "head1.png";
         }
      } else if (var1.equals("Радуга: ")) {
         var4 = "head3.png";
      } else if (var1.equals("Etty: ")) {
         var4 = "head4.png";
      } else if (var1.equals("BlackFan: ")) {
         var4 = "head5.png";
      } else if (var1.equals("Девочка: ")) {
         var4 = "head6.png";
      } else if (var1.equals("Фуксия: ")) {
         var4 = "head7.png";
      } else {
         this.bU = false;
      }

      try {
         if (this.bU) {
            this.aq = Image.createImage("/" + var4);
         }
      } catch (Exception var3) {
      }
   }

   private static void g(int var0, int var1) {
      engine.d.panel(g, 240 - var0 >> 1, 320 - var1 >> 1, var0, var1);
      engine.d.a(g, bs, 6764371, (240 - var0 >> 1) + 12, (320 - var1 >> 1) + 10, var0 - 24, var1 - 20);
      if (d(114720)) {
         if (engine.d.c()) {
            if (!engine.d.d()) {
               engine.d.a(false);
               L = false;
               f(0);
               return;
            }
         } else {
            engine.d.b();
         }
      }
   }

   private int a(String var1, String var2, String var3) {
      engine.d.panel(g, 14, 104, 212, 88);
      engine.h.a(g, -1, 112, 196, 40, 16707534, 13549230);
      engine.d.a(g, var1, 6764371, 26, 117, 188, engine.g.b * 2);
      if (this.bV == 0) {
         engine.h.a(g, 28, 159, 54, 25, 16707534, 13549230);
      } else if (this.bV == 1) {
         engine.h.a(g, 159, 159, 54, 25, 16707534, 13549230);
      }

      engine.d.c(g, var2.trim(), 28 + (54 - engine.g.a.stringWidth(var2.trim()) >> 1), 159 + (25 - engine.g.b >> 1), 15597476, 6764371, 20);
      engine.d.c(g, var3.trim(), 159 + (54 - engine.g.a.stringWidth(var3.trim()) >> 1), 159 + (25 - engine.g.b >> 1), 15597476, 6764371, 20);
      if (engine.d.c() && engine.a.b(10)) {
         engine.d.d();
      }

      if (d(49184)) {
         engine.d.a(false);
         if (this.bV == 0) {
            this.bV = 0;
            return 1;
         } else {
            this.bV = 0;
            return 2;
         }
      } else {
         if (d(4112)) {
            this.bV = 0;
         } else if (d(8256)) {
            this.bV = 1;
         }

         return 0;
      }
   }

   static {
      String[] var10000 = new String[]{"Жизнь ", "Атака ", "Защита ", "Крит "};
      int[] var0 = new int[]{0, 1};
      int[] var1 = new int[]{5, 6, 11, 12, 17};
      int[] var2 = new int[]{8, 13, 14, 15, 16};
      int[] var3 = new int[]{7, 8, 14, 15, 16};
      int[] var4 = new int[]{16711680, 14811136, 12517376, 10485760, 0, 0, 0, 0};
   }
}
