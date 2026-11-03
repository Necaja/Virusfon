/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.nokia.mid.ui.DirectGraphics
 *  com.nokia.mid.ui.DirectUtils
 *  javax.microedition.lcdui.Canvas
 *  javax.microedition.lcdui.Display
 *  javax.microedition.lcdui.Displayable
 *  javax.microedition.lcdui.Graphics
 *  javax.microedition.lcdui.Image
 *  javax.microedition.midlet.MIDlet
 *  javax.microedition.rms.RecordStore
 *  javax.microedition.rms.RecordStoreException
 */
package main;

import a.g;
import a.h;
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
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.midlet.MIDlet;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;
import main.a;
import main.b;
import main.c;
import main.cMIDlet;
import main.d;
import main.e;

public final class f
extends Canvas
implements g,
Runnable {
    private static f Z;
    private static b aa;
    private a.f ab = new a.f();
    private static a ac;
    public static int c;
    public static int d;
    public static boolean e;
    private static int ad;
    public static int f;
    private static int ae;
    public static Graphics g;
    public static DirectGraphics h;
    private static int af;
    public static int i;
    public static int j;
    private static int ag;
    private static int ah;
    public static int k;
    public static boolean l;
    private static boolean ai;
    public static Image[] m;
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
    public static Image[] o;
    public static Image p;
    private static Image at;
    private static Image au;
    private static Image av;
    private static Image aw;
    private static Image ax;
    public static Image[] q;
    public static Image r;
    public static Image s;
    public static Image t;
    public static Image u;
    public static Image[] v;
    private static Image[] ay;
    private static Image az;
    private static Image aA;
    private static Image aB;
    private static Image aC;
    public static Image w;
    public static Image x;
    public static Image y;
    public static Image[] z;
    public static Image A;
    public static Image B;
    public static boolean C;
    public static boolean D;
    public static boolean E;
    private static String aD;
    private static int aE;
    private static int[] aF;
    static boolean F;
    static boolean G;
    static int H;
    static boolean I;
    private static int aG;
    static int J;
    private static int[] aH;
    private static int aI;
    private static int aJ;
    private static int aK;
    private long aL;
    private static int aM;
    public static int K;
    private static boolean aN;
    private static byte aO;
    public static boolean L;
    private static boolean aP;
    private static boolean aQ;
    public static boolean M;
    public static boolean N;
    private int aR;
    private int aS;
    private String[] aT;
    private int aU;
    private byte[] aV;
    static int O;
    private String aW;
    static boolean P;
    private static byte[] aX;
    private static boolean aY;
    private int aZ;
    private int ba;
    static int Q;
    public static String[] R;
    private int[] bb;
    private int[] bc;
    private int[] bd;
    static byte[] S;
    static boolean T;
    private static String[] be;
    private String[] bf;
    private String[] bg;
    static boolean U;
    static int V;
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
    private static int bt;
    private boolean[] bu;
    private int bv;
    private static String[] bw;
    private static boolean bx;
    private int by;
    private byte bz;
    private boolean bA;
    public static boolean W;
    private int bB;
    private int bC;
    private static int[] bD;
    private static int bE;
    private String[] bF;
    private int bG;
    private int bH;
    private static int[][] bI;
    private static String[] bJ;
    private static int bK;
    public static int X;
    public static int Y;
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
    private int bV;

    static void a(int n) {
        if ((aG += n) >= 10000) {
            main.e.a(4);
        }
        if (aG >= 100000) {
            main.e.a(5);
        }
    }

    public f() {
        new e();
        String[] stringArray = new String[]{"\u0412\u044b\u0439\u0442\u0438? ", "\u041d\u043e\u0432\u0430\u044f \u0438\u0433\u0440\u0430 ", "\u041f\u0440\u043e\u0434\u043e\u043b\u0436\u0438\u0442\u044c \u0438\u0433\u0440\u0443 ", "\u0412\u044b\u0437\u043e\u0432 \u0440\u0435\u0436\u0438\u043c\u0430 ", "\u041a\u043e\u0434\u044b \u0438\u0433\u0440\u044b ", "\u041d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438 ", "\u0418\u043d\u0441\u0442\u0440\u0443\u043a\u0446\u0438\u0438 ", "\u041e\u0431 \u0438\u0433\u0440\u0435 ", "\u0412\u044b\u0445\u043e\u0434 "};
        this.aT = new String[]{"\u0416\u0435\u043b\u0430\u0435\u043c \u043f\u0440\u0438\u044f\u0442\u043d\u043e\u0439 \u0438\u0433\u0440\u044b ", "\u0416\u0435\u043b\u0430\u0435\u043c \u043f\u0440\u0438\u044f\u0442\u043d\u043e\u0439 \u0438\u0433\u0440\u044b ", "\u041e\u0441\u0442\u0430\u0432\u0430\u0439\u0442\u0435\u0441\u044c \u0441 \u043d\u0430\u043c\u0438 ", "\u041e\u0441\u0442\u0430\u0432\u0430\u0439\u0442\u0435\u0441\u044c \u0441 \u043d\u0430\u043c\u0438 ", "\u041c\u0435\u0447\u0442\u044b \u0432 \u0440\u0435\u0430\u043b\u044c\u043d\u043e\u0441\u0442\u044c ", "\u041c\u044b \u0440\u0430\u0431\u043e\u0442\u0430\u0435\u043c \u0434\u043b\u044f \u0432\u0430\u0441 ", "\u0416\u0435\u043b\u0430\u0435\u043c \u043f\u0440\u0438\u044f\u0442\u043d\u043e\u0439 \u0438\u0433\u0440\u044b", "\u041e\u0441\u0442\u0430\u0432\u0430\u0439\u0442\u0435\u0441\u044c \u0441 \u043d\u0430\u043c\u0438 ", "\u041c\u0435\u0447\u0442\u044b \u0432 \u0440\u0435\u0430\u043b\u044c\u043d\u043e\u0441\u0442\u044c ", "\u0411\u0435\u0437 \u0437\u0432\u0443\u043a\u0430 \u0431\u043e\u043b\u0435\u0435 \u0431\u044b\u0441\u0442\u0440\u0430\u044f \u0438\u0433\u0440\u0430 ", "\u041f\u0435\u0440\u0435\u0432\u043e\u0434 \u043e\u0442 Fonzo Team ", "\u041b\u0443\u0447\u0448\u0438\u0435 \u0438\u0433\u0440\u044b \u0434\u043b\u044f \u0432\u0430\u0441 ", "\u0423\u0434\u0430\u0447\u0430 - \u0431\u043e\u043b\u044c\u0448\u0435 \u0441\u043e\u043a\u0440\u043e\u0432\u0438\u0449 "};
        this.aU = 0;
        this.aV = new byte[]{1, 2, 3, 5, 5, 6, 7, 8};
        this.aW = "shanhaiyouxia";
        this.aZ = 0;
        this.ba = 0;
        this.bb = new int[]{107, 134, 164, 109, 155, 26, 174, 223, 117, 228, 28, 232, 14, 131, 52, 59, 19, 23};
        this.bc = new int[]{8, 7, 2, 6, 0, 1, 5, 4, 3};
        this.bd = new int[]{0, 101, 201, 301, 205, 401, 105, 501, 601};
        this.bh = 0;
        this.bi = new String[]{"\u0427\u0438\u0442\u044b ", "\u0413\u0435\u0440\u043e\u0439 ", "\u0412\u0435\u0449\u0438 ", "\u0420\u0435\u043a\u0432\u0438\u0437\u0438\u0442 ", "\u041c\u0430\u0433\u0438\u044f ", "\u0421\u0438\u043d\u0442\u0435\u0437 ", "\u0417\u0430\u0434\u0430\u0447\u0430 "};
        this.bj = 0;
        this.bk = 0;
        this.bl = new int[]{1000, 2000, 10000, 15000, 3000, 3000, 5000};
        this.bm = new String[]{"\u0421\u0442\u043e\u0438\u043c\u043e\u0441\u0442\u044c \u043b\u043e\u0442\u0435\u0440\u0435\u0439\u043d\u043e\u0433\u043e \u0431\u0438\u043b\u0435\u0442\u0430 1000 \u0437\u043e\u043b\u043e\u0442\u044b\u0445, 100% \u0432\u044b\u0438\u0433\u0440\u044b\u0448", "\u041d\u0435\u043c\u0435\u0434\u043b\u0435\u043d\u043d\u043e \u0432\u043e\u0437\u0432\u0440\u0430\u0449\u0430\u0435\u0442 \u0432 \u0434\u0435\u0440\u0435\u0432\u043d\u044e ", "\u0410\u0442\u0430\u043a\u0443\u0435\u0442 \u0432\u0441\u0435\u0445 \u0432\u0440\u0430\u0433\u043e\u0432 \u0443\u0434\u0430\u0440\u0430\u043c\u0438 \u0441 \u043d\u0435\u0431\u0430", "\u041f\u0435\u0440\u0435\u043d\u0435\u0441\u0435\u0442 \u0432\u0430\u0441 \u0432 \u043b\u044e\u0431\u0443\u044e \u0442\u043e\u0447\u043a\u0443 \u043d\u0430 \u043b\u043e\u043a\u0430\u0446\u0438\u0438 ", "\u0410\u0442\u0430\u043a\u0430 +5, \u043f\u043e\u0441\u0442\u043e\u044f\u043d\u043d\u044b\u0439 \u043f\u0440\u043e\u0433\u0440\u0435\u0441\u0441 ", "\u0417\u0430\u0449\u0438\u0442\u0430 +5, \u043f\u043e\u0441\u0442\u043e\u044f\u043d\u043d\u044b\u0439 \u043f\u0440\u043e\u0433\u0440\u0435\u0441\u0441 ", "\u0417\u0430\u0449\u0438\u0442\u0430 +4, \u043a\u0440\u0438\u0442 +3, \u043f\u043e\u0441\u0442\u043e\u044f\u043d\u043d\u044b\u0439 \u043f\u0440\u043e\u0433\u0440\u0435\u0441\u0441 "};
        this.bn = 0;
        this.bo = 0;
        this.bp = 0;
        this.bq = 0;
        this.br = new String[]{"", "\u0421\u0438\u043d\u0442\u0435\u0437 \u0437\u0435\u043b\u0438\u0439 ", "\u0421\u0438\u043d\u0442\u0435\u0437 \u043c\u0435\u0447\u0435\u0439 ", "\u0421\u0438\u043d\u0442\u0435\u0437 \u0448\u043b\u0435\u043c\u0430 ", "\u0421\u0438\u043d\u0442\u0435\u0437 \u0431\u0440\u043e\u043d\u0438 ", "\u0421\u0438\u043d\u0442\u0435\u0437 \u043a\u043e\u043b\u0435\u0446 "};
        this.bu = new boolean[]{false, false, false};
        this.bv = 0;
        this.by = 0;
        this.bz = 0;
        this.bB = 0;
        this.bC = 0;
        this.bF = new String[]{"\u0418\u043d\u0444\u043e - \u0441\u0432\u0435\u0434\u0435\u043d\u0438\u044f \u043e \u0433\u0435\u0440\u043e\u0435 ", "virusfon \u043d\u0430\u0432\u0441\u0435\u0433\u0434\u0430 ", "Etty - \u043a\u043e\u0432\u043a\u0430 \u0438 \u043e\u0440\u0443\u0436\u0438\u0435 ", "\u0422\u0435\u043b\u0435\u043f\u043e\u0440\u0442 \u0441\u044d\u043a\u043e\u043d\u043e\u043c\u0438\u0442 \u0432\u0440\u0435\u043c\u044f ", "\u0421\u0438\u043d\u0442\u0435\u0437 - \u0432\u044b\u0441\u043e\u043a\u043e\u0435 \u043a\u0430\u0447\u0435\u0441\u0442\u0432\u043e ", "\u041f\u0435\u0440\u0435\u0432\u043e\u0434\u044b Fonzo Team ", "\u041c\u0430\u0433\u0430\u0437\u0438\u043d - \u0432\u044b\u0433\u043e\u0434\u043d\u044b\u0435 \u0446\u0435\u043d\u044b ", "\u0418\u043d\u0444\u043e - \u043c\u0430\u0442\u0435\u0440\u0438\u0430\u043b\u044b \u0438 \u0432\u0435\u0449\u0438 ", "\u0418\u043d\u0444\u043e - \u0441\u0432\u0435\u0434\u0435\u043d\u0438\u044f \u043e \u0437\u0430\u0434\u0430\u0447\u0435 "};
        this.bG = 0;
        this.bH = 0;
        this.bL = 0;
        this.bN = new String[]{"\u0418\u0433\u0440\u0430 ", "\u041f\u043e\u043c\u043e\u0449\u044c ", "\u041d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438 ", "\u0418\u043d\u0441\u0442\u0440\u0443\u043a\u0446\u0438\u0438 ", "\u041e\u0431 \u0438\u0433\u0440\u0435 ", "\u0412\u044b\u0445\u043e\u0434 "};
        this.bO = 0;
        this.bP = 0;
        this.bU = false;
        String[] stringArray2 = new String[]{"\u0410\u043c\u0438\u0442\u0430\u0431\u0445\u0430 ... ... \u0442\u043e \u0434\u0435\u043b\u0430\u0442\u044c? ", "\u041e\u0431\u043d\u043e\u0432\u043b\u0435\u043d\u0438\u0435 \u043e\u0440\u0443\u0436\u0438\u044f \u043e\u0431\u043b\u0435\u0433\u0447\u0438\u0442 \u0438\u0441\u043f\u044b\u0442\u0430\u043d\u0438\u044f ", "\u0418\u043d\u0444\u043e - \u0438\u0437\u043c\u0435\u043d\u0438\u0442\u044c \u0441\u0442\u0430\u0442\u0443\u0441 ", "\u0423\u0440\u043e\u043a\u0438 \u043f\u0435\u0440\u0435\u0432\u043e\u0434\u043e\u0432 "};
        this.bV = 0;
        this.setFullScreenMode(true);
        this.setFullScreenMode(true);
        Z = this;
        this.ab.b("menu", true, 1);
    }

    private void j() {
        try {
            this.c(false);
            for (int i = 0; i < ay.length; ++i) {
                if (i == 1 || ay[i] != null) continue;
                main.f.a(i, "/splash" + i + ".png");
            }
            if (aw == null) {
                aw = Image.createImage((String)"/weapsmllicon.png");
            }
            if (au == null) {
                au = Image.createImage((String)"/point.png");
            }
            if (as == null) {
                as = Image.createImage((String)"/num.png");
            }
            if (this.ar == null) {
                this.ar = Image.createImage((String)"/money.png");
            }
            if (av == null) {
                av = Image.createImage((String)"/kuang1.png");
            }
            if (at == null) {
                at = Image.createImage((String)"/tash.png");
            }
            if (this.am == null) {
                this.am = Image.createImage((String)"/cool2.png");
            }
            if (this.ap == null) {
                this.ap = Image.createImage((String)"/head0.png");
            }
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void g(int n) {
        try {
            int n2;
            if (aC == null) {
                aC = Image.createImage((String)"/dalog.png");
            }
            if (t == null) {
                t = Image.createImage((String)"/ceo.png");
            }
            if (this.an == null) {
                this.an = Image.createImage((String)"/res.png");
            }
            if (this.ao == null) {
                this.ao = Image.createImage((String)"/key.png");
            }
            if (this.al == null) {
                this.al = Image.createImage((String)"/cool.png");
            }
            if (m[0] == null) {
                main.f.m[0] = Image.createImage((String)"/zhujiao1.png");
            }
            if (m[n2 = main.e.I / 4 + 1] == null) {
                main.f.m[n2] = Image.createImage((String)("/zhujiao" + (n2 + 1) + ".png"));
            }
            if (m[4] == null) {
                main.f.m[4] = Image.createImage((String)"/zhujiao5.png");
            }
            if (aC == null) {
                aC = Image.createImage((String)"/dalog.png");
            }
            if (y == null) {
                y = Image.createImage((String)"/die.png");
            }
            if (r == null) {
                r = Image.createImage((String)"/magicdoor.png");
            }
            if (main.f.n == null) {
                main.f.n = Image.createImage((String)"/attackpro.png");
            }
            if (o[0] == null) {
                main.f.o[0] = Image.createImage((String)"/num2.png");
            }
            if (o[1] == null) {
                main.f.o[1] = Image.createImage((String)"/num3.png");
            }
            if (p == null) {
                p = Image.createImage((String)"/numflash.png");
            }
            if (B == null) {
                B = Image.createImage((String)"/keyhelp.png");
            }
            if (K == 702) {
                a.c.a("/level" + (K / 100 + 1) + "_tile.png", "/level" + (K / 100 + 1) + "_0_tile.png", "/map9.png");
            } else {
                a.c.a("/level" + (K / 100 + 1) + "_tile.png", "/level" + (K / 100 + 1) + "_0_tile.png", "/map" + this.aV[K / 100] + ".png");
            }
            switch (n) {
                case 701: {
                    if (u == null) {
                        u = Image.createImage((String)"/story1.png");
                    }
                    if (v[0] != null) return;
                    main.f.v[0] = Image.createImage((String)"/enemy1.png");
                    return;
                }
                case 702: {
                    if (u == null) {
                        u = Image.createImage((String)"/story1.png");
                    }
                    if (A != null) return;
                    A = Image.createImage((String)"/star.png");
                    return;
                }
                case 0: {
                    if (w == null) {
                        w = Image.createImage((String)"/save.png");
                    }
                    for (int i = 0; i < 9; ++i) {
                        if (q[i] != null) continue;
                        main.f.q[i] = Image.createImage((String)("/npc" + (i + 1) + ".png"));
                    }
                    return;
                }
                case 101: {
                    if (v[4] == null) {
                        main.f.v[4] = Image.createImage((String)"/enemy5.png");
                    }
                    if (v[7] != null) return;
                    main.f.v[7] = Image.createImage((String)"/enemy8.png");
                    return;
                }
                case 102: {
                    if (v[1] == null) {
                        main.f.v[1] = Image.createImage((String)"/enemy2.png");
                    }
                    if (v[4] == null) {
                        main.f.v[4] = Image.createImage((String)"/enemy5.png");
                    }
                    if (v[7] != null) return;
                    main.f.v[7] = Image.createImage((String)"/enemy8.png");
                    return;
                }
                case 103: {
                    if (v[4] == null) {
                        main.f.v[4] = Image.createImage((String)"/enemy5.png");
                    }
                    if (v[1] == null) {
                        main.f.v[1] = Image.createImage((String)"/enemy2.png");
                    }
                    if (w != null) return;
                    w = Image.createImage((String)"/save.png");
                    return;
                }
                case 104: {
                    if (v[6] == null) {
                        main.f.v[6] = Image.createImage((String)"/enemy7.png");
                    }
                    if (z[3] != null) return;
                    main.f.z[3] = Image.createImage((String)"/boss4.png");
                    return;
                }
                case 105: 
                case 106: 
                case 107: {
                    if (w == null) {
                        w = Image.createImage((String)"/save.png");
                    }
                    if (x == null) {
                        x = Image.createImage((String)"/dici.png");
                    }
                    if (v[0] == null) {
                        main.f.v[0] = Image.createImage((String)"/enemy1.png");
                    }
                    if (v[8] != null) return;
                    main.f.v[8] = Image.createImage((String)"/enemy9.png");
                    return;
                }
                case 108: {
                    if (z[3] == null) {
                        main.f.z[3] = Image.createImage((String)"/boss4.png");
                    }
                    if (q[1] != null) return;
                    main.f.q[1] = Image.createImage((String)"/npc2.png");
                    return;
                }
                case 201: {
                    if (v[5] == null) {
                        main.f.v[5] = Image.createImage((String)"/enemy6.png");
                    }
                    if (v[9] != null) return;
                    main.f.v[9] = Image.createImage((String)"/enemy10.png");
                    return;
                }
                case 202: {
                    if (v[1] == null) {
                        main.f.v[1] = Image.createImage((String)"/enemy2.png");
                    }
                    if (v[5] == null) {
                        main.f.v[5] = Image.createImage((String)"/enemy6.png");
                    }
                    if (v[9] != null) return;
                    main.f.v[9] = Image.createImage((String)"/enemy10.png");
                    return;
                }
                case 203: {
                    if (v[1] == null) {
                        main.f.v[1] = Image.createImage((String)"/enemy2.png");
                    }
                    if (v[5] == null) {
                        main.f.v[5] = Image.createImage((String)"/enemy6.png");
                    }
                    if (w != null) return;
                    w = Image.createImage((String)"/save.png");
                    return;
                }
                case 204: {
                    if (v[3] != null) return;
                    main.f.v[3] = Image.createImage((String)"/enemy4.png");
                    return;
                }
                case 205: {
                    if (x == null) {
                        x = Image.createImage((String)"/dici.png");
                    }
                    if (v[2] == null) {
                        main.f.v[2] = Image.createImage((String)"/enemy3.png");
                    }
                    if (v[5] != null) return;
                    main.f.v[5] = Image.createImage((String)"/enemy6.png");
                    return;
                }
                case 206: 
                case 207: {
                    if (w == null) {
                        w = Image.createImage((String)"/save.png");
                    }
                    if (x == null) {
                        x = Image.createImage((String)"/dici.png");
                    }
                    if (v[1] == null) {
                        main.f.v[1] = Image.createImage((String)"/enemy2.png");
                    }
                    if (v[2] == null) {
                        main.f.v[2] = Image.createImage((String)"/enemy3.png");
                    }
                    if (v[5] != null) return;
                    main.f.v[5] = Image.createImage((String)"/enemy6.png");
                    return;
                }
                case 208: {
                    if (z[1] == null) {
                        main.f.z[1] = Image.createImage((String)"/boss2.png");
                    }
                    if (z[3] != null) return;
                    main.f.z[3] = Image.createImage((String)"/boss4.png");
                    return;
                }
                case 301: 
                case 302: 
                case 303: {
                    if (w == null) {
                        w = Image.createImage((String)"/save.png");
                    }
                    if (x == null) {
                        x = Image.createImage((String)"/dici.png");
                    }
                    if (v[1] == null) {
                        main.f.v[1] = Image.createImage((String)"/enemy2.png");
                    }
                    if (v[9] != null) return;
                    main.f.v[9] = Image.createImage((String)"/enemy10.png");
                    return;
                }
                case 304: {
                    if (z[0] == null) {
                        main.f.z[0] = Image.createImage((String)"/boss1.png");
                    }
                    if (z[3] != null) return;
                    main.f.z[3] = Image.createImage((String)"/boss4.png");
                    return;
                }
                case 401: {
                    if (x == null) {
                        x = Image.createImage((String)"/dici.png");
                    }
                    if (v[2] == null) {
                        main.f.v[2] = Image.createImage((String)"/enemy3.png");
                    }
                    if (v[4] != null) return;
                    main.f.v[4] = Image.createImage((String)"/enemy5.png");
                    return;
                }
                case 402: 
                case 403: {
                    if (w == null) {
                        w = Image.createImage((String)"/save.png");
                    }
                    if (x == null) {
                        x = Image.createImage((String)"/dici.png");
                    }
                    if (v[2] == null) {
                        main.f.v[2] = Image.createImage((String)"/enemy3.png");
                    }
                    if (v[4] == null) {
                        main.f.v[4] = Image.createImage((String)"/enemy5.png");
                    }
                    if (v[3] != null) return;
                    main.f.v[3] = Image.createImage((String)"/enemy4.png");
                    return;
                }
                case 404: {
                    if (z[2] == null) {
                        main.f.z[2] = Image.createImage((String)"/boss3.png");
                    }
                    if (q[0] != null) return;
                    main.f.q[0] = Image.createImage((String)"/story2.png");
                    return;
                }
                case 501: {
                    if (w == null) {
                        w = Image.createImage((String)"/save.png");
                    }
                    if (q[12] == null) {
                        main.f.q[12] = Image.createImage((String)"/npc13.png");
                    }
                    if (q[13] == null) {
                        main.f.q[13] = Image.createImage((String)"/npc14.png");
                    }
                    if (s != null) return;
                    s = Image.createImage((String)"/door.png");
                    return;
                }
                case 502: 
                case 503: 
                case 504: {
                    if (x == null) {
                        x = Image.createImage((String)"/dici.png");
                    }
                    if (v[0] != null) return;
                    main.f.v[0] = Image.createImage((String)"/enemy1.png");
                    return;
                }
                case 505: {
                    if (z[4] != null) return;
                    main.f.z[4] = Image.createImage((String)"/boss5.png");
                    return;
                }
                case 601: {
                    for (int i = 9; i < 12; ++i) {
                        if (q[i] != null) continue;
                        main.f.q[i] = Image.createImage((String)("/npc" + (i + 1) + ".png"));
                    }
                    if (w != null) return;
                    w = Image.createImage((String)"/save.png");
                    return;
                }
                case 602: {
                    if (x == null) {
                        x = Image.createImage((String)"/dici.png");
                    }
                    if (v[3] == null) {
                        main.f.v[3] = Image.createImage((String)"/enemy4.png");
                    }
                    if (v[6] != null) return;
                    main.f.v[6] = Image.createImage((String)"/enemy7.png");
                    return;
                }
                case 603: {
                    if (x == null) {
                        x = Image.createImage((String)"/dici.png");
                    }
                    if (v[3] == null) {
                        main.f.v[3] = Image.createImage((String)"/enemy4.png");
                    }
                    if (v[6] == null) {
                        main.f.v[6] = Image.createImage((String)"/enemy7.png");
                    }
                    if (v[9] != null) return;
                    main.f.v[9] = Image.createImage((String)"/enemy10.png");
                    return;
                }
                case 604: 
                case 605: {
                    if (x == null) {
                        x = Image.createImage((String)"/dici.png");
                    }
                    if (v[6] == null) {
                        main.f.v[6] = Image.createImage((String)"/enemy7.png");
                    }
                    if (v[9] != null) return;
                    main.f.v[9] = Image.createImage((String)"/enemy10.png");
                    return;
                }
                case 606: {
                    if (z[4] != null) return;
                    main.f.z[4] = Image.createImage((String)"/boss5.png");
                    return;
                }
                case 607: {
                    if (z[4] != null) return;
                    main.f.z[4] = Image.createImage((String)"/boss5.png");
                    return;
                }
                case 608: {
                    if (z[5] != null) return;
                    main.f.z[5] = Image.createImage((String)"/boss6.png");
                    return;
                }
                case 609: {
                    if (z[6] == null) {
                        main.f.z[6] = Image.createImage((String)"/boss7.png");
                    }
                    if (q[0] == null) {
                        main.f.q[0] = Image.createImage((String)"/story2.png");
                    }
                    if (q[1] != null) return;
                    main.f.q[1] = Image.createImage((String)"/npc2.png");
                    return;
                }
                case 610: {
                    for (int i = 0; i < 8; ++i) {
                        if (i == 3 || q[i] != null) continue;
                        main.f.q[i] = Image.createImage((String)("/npc" + (i + 1) + ".png"));
                    }
                    return;
                }
                case 4: {
                    if (ax != null) return;
                    ax = Image.createImage((String)"/bossBlood.png");
                }
                default: {
                    return;
                }
            }
        }
        catch (Exception exception) {}
    }

    private void c(boolean bl) {
        int n;
        main.f.m[0] = null;
        main.f.m[1] = null;
        main.f.m[2] = null;
        main.f.m[3] = null;
        main.f.m[4] = null;
        w = null;
        x = null;
        main.f.o[0] = null;
        main.f.o[1] = null;
        this.al = null;
        this.am = null;
        this.ap = null;
        this.ar = null;
        t = null;
        au = null;
        for (n = 0; n < q.length; ++n) {
            main.f.q[n] = null;
        }
        for (n = 0; n < v.length; ++n) {
            main.f.v[n] = null;
        }
        for (n = 0; n < z.length; ++n) {
            main.f.z[n] = null;
        }
        u = null;
        this.aj = null;
        this.ak = null;
        as = null;
        for (n = 0; n < ay.length; ++n) {
            main.f.ay[n] = null;
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
        main.f.n = null;
        p = null;
        if (bl) {
            a.a();
        } else {
            for (n = 0; n < a.e.length; ++n) {
                a.e[n].a = null;
            }
        }
        a.c.a();
        System.gc();
    }

    private static boolean a(int n, String string) {
        try {
            main.f.ay[n] = Image.createImage((String)string);
            return true;
        }
        catch (Exception exception) {
            return false;
        }
    }

    public final void a() {
        Display.getDisplay((MIDlet)cMIDlet.a).setCurrent((Displayable)this);
        new Thread(this).start();
    }

    public static void b() {
        Display.getDisplay((MIDlet)cMIDlet.a).setCurrent(null);
    }

    /*
     * Unable to fully structure code
     */
    public final void paint(Graphics var1_10) {
        main.f.i = ~main.f.j & main.f.af;
        main.f.j = main.f.af;
        main.f.g = var1_10;
        main.f.h = DirectUtils.getDirectGraphics((Graphics)main.f.g);
        a.h.a(main.f.g, 0, 0, 240, 320);
        try {
            block253: {
                if (b.a()) {
                    if (main.f.ag != 0) {
                        main.f.af = 0;
                    }
                    main.f.ag = 0;
                    main.f.g = null;
                    return;
                }
                block1 : switch (main.f.k) {
                    case 1: {
                        main.f.g.setColor(-1);
                        main.f.g.fillRect(0, 0, 240, 320);
                        if (main.f.ad == 2) {
                            if (main.f.aA != null) {
                                main.f.g.drawImage(main.f.aA, 120, 160, 3);
                            }
                            var1_10 = this;
                            if (var1_10.bP <= 0) {
                                ++var1_10.bP;
                                break;
                            }
                            if (var1_10.bP < 20) {
                                ++var1_10.bP;
                                break;
                            }
                            main.f.k = 3;
                            break;
                        }
                        if (main.f.az == null) break;
                        main.f.g.drawImage(main.f.az, 120, 160, 3);
                        break;
                    }
                    case 5: {
                        a.h.a(main.f.g, 0xFF0000);
                        a.h.a(main.f.g, 0, 0, 240, 320);
                        main.f.g.drawImage(main.f.ay[1], 0, 0, 20);
                        a.h.a(main.f.g, main.f.ay[4], 160 - this.bO / 3 % 3, 271);
                        a.h.a(main.f.g, main.f.h, main.f.ay[4], 68 + this.bO / 3 % 3, 271, 12, 17, 0, 0);
                        ++this.bO;
                        this.bO %= 12;
                        a.d.b(main.f.g, this.bN[main.f.ae - 1], -1, 267 + (26 - a.g.b >> 1), 15597476, 6764371, 20);
                        if (main.f.d(49184)) {
                            switch (main.f.ae) {
                                case 1: {
                                    for (var1_11 = 0; var1_11 < this.bu.length; ++var1_11) {
                                        this.bu[var1_11] = super.j(var1_11);
                                    }
                                    main.f.k = 18;
                                    main.e.i = 0;
                                    break;
                                }
                                case 2: {
                                    main.f.k = 25;
                                    break;
                                }
                                case 3: 
                                case 4: 
                                case 5: {
                                    var0_1 = main.f.ae;
                                    main.f.f = 0;
                                    main.f.aO = (byte)(var0_1 - 1);
                                    main.f.k = 11;
                                    break;
                                }
                                case 6: {
                                    main.f.k = 0;
                                }
                            }
                            main.f.f = 0;
                            main.f.aE = 0;
                        }
                        if (main.f.d(5140)) {
                            if (--main.f.ae >= 1) break;
                            main.f.ae = 6;
                            break;
                        }
                        if (!main.f.d(10560) || ++main.f.ae <= 6) break;
                        main.f.ae = 1;
                        break;
                    }
                    case 4: {
                        break;
                    }
                    case 6: {
                        a.h.a(main.f.g, 0);
                        main.f.g.drawImage(main.f.ay[1], 0, 0, 20);
                        a.d.b(main.f.g, "\u0417\u0430\u0433\u0440\u0443\u0437\u043a\u0430 \u0441 forum.fonzo.ru ... ", -1, 267 + (26 - a.g.b >> 1), 15597476, 6362880, 20);
                        var1_12 = 240 * main.f.aM / 16;
                        main.f.g.setColor(0xFF0000);
                        main.f.g.drawLine(0, 319, 240, 319);
                        main.f.g.setColor(0xFFFFFF);
                        main.f.g.drawLine(0, 319, var1_12, 319);
                        if (main.f.aM != 0) {
                            if (main.f.aM == 1) {
                                main.f.aA = null;
                                main.f.az = null;
                                main.f.aB = null;
                                System.gc();
                            } else if (main.f.aM != 2) {
                                if (main.f.aM == 3) {
                                    super.n();
                                } else if (main.f.aM <= 3 || main.f.aM > 14) {
                                    if (main.f.aM == 15) {
                                        main.f.m();
                                    } else {
                                        main.f.f = 1;
                                        this.i();
                                        break;
                                    }
                                }
                            }
                        }
                        ++main.f.aM;
                        break;
                    }
                    case 7: {
                        if (main.f.W) {
                            if (!a.h.a(main.f.g, true, 2)) break;
                            main.f.W = false;
                            break;
                        }
                        if (main.f.N) {
                            var1_10 = this;
                            super.c(true);
                            if (main.f.ay[2] == null) {
                                main.f.a(2, "/splash2.png");
                            }
                            if (main.f.aN) {
                                var1_10.ab.a("menu", true, 1);
                            }
                            main.f.k = 16;
                            break;
                        }
                        if (!main.f.aQ) ** GOTO lbl137
                        var1_10 = this;
                        a.c.a(a.a, a.b, main.f.g);
                        a.c();
                        super.H();
                        var0_2 = 0;
                        var0_2 = main.f.K == 0 ? super.a("\u0417\u0430\u043f\u0438\u0441\u0430\u0442\u044c \u0438\u0433\u0440\u0443? ", "\u0414\u0430 ", "\u041d\u0435\u0442 ") : super.a("\u0426\u0435\u043d\u0430 500 \u0437\u043e\u043b\u043e\u0442\u044b\u0445, \u0441\u043e\u0445\u0440\u0430\u043d\u0438\u0442\u044c? ", "\u0414\u0430 ", "\u041d\u0435\u0442 ");
                        if (var0_2 != 1) ** GOTO lbl134
                        if (main.f.K == 0) ** GOTO lbl130
                        if (main.f.aG < 500) {
                            main.f.a("\u041d\u0435\u0434\u043e\u0441\u0442\u0430\u0442\u043e\u0447\u043d\u043e \u0434\u0435\u043d\u0435\u0433 \u0434\u043b\u044f \u0441\u043e\u0445\u0440\u0430\u043d\u0435\u043d\u0438\u044f ");
                        } else {
                            main.f.aG -= 500;
lbl130:
                            // 2 sources

                            super.i(main.f.bt);
                            main.f.a("\u041f\u0440\u043e\u0433\u0440\u0435\u0441\u0441 \u0441\u043e\u0445\u0440\u0430\u043d\u0435\u043d ");
                        }
                        main.f.aQ = false;
                        break;
lbl134:
                        // 1 sources

                        if (var0_2 != 2) break;
                        main.f.aQ = false;
                        break;
lbl137:
                        // 1 sources

                        if (main.f.T) {
                            a.c.a(a.a, a.b, main.f.g);
                            a.c();
                            super.H();
                            for (var1_13 = 0; var1_13 < main.f.be.length; ++var1_13) {
                                if (main.f.be[var1_13] == null) continue;
                                var0_3 = 145;
                                var0_3 = 30;
                                var2_14 = 240;
                                var0_3 = var1_13;
                                a.h.a(main.f.g, 0, 145, 240, 30, 6907220, 16635556);
                                a.h.a(main.f.g, 3, 148, 234, 24, 16568212, 0xFEEFCE);
                                a.d.a(main.f.g, main.f.be[var0_3], 6764371, 240 - (238 - a.g.a.stringWidth("\u0412\u0432\u043e\u0434\u0438\u0442\u044c ")) + 4 >> 1, 150 + (20 - a.g.b >> 1), 240 - a.g.a.stringWidth("\u0412\u0432\u043e\u0434\u0438\u0442\u044c "), a.g.b * (24 / a.g.b));
                                if (!main.f.d(49184)) break block1;
                                if (a.d.c()) {
                                    if (a.d.d()) break block1;
                                    a.d.a(false);
                                    main.f.be[var0_3] = null;
                                    break block1;
                                }
                                a.d.b();
                                break block1;
                            }
                            main.f.T = false;
                            break;
                        }
                        if (main.f.M) {
                            var1_10 = this;
                            a.c.a(a.a, a.b, main.f.g);
                            a.c();
                            super.H();
                            var0_4 = 0;
                            if (main.f.K == 0) {
                                var0_4 = super.a("\u041f\u0440\u043e\u0438\u0437\u0432\u0435\u0441\u0442\u0438 \u043e\u0431\u043c\u0435\u043d? ", "\u0414\u0430 ", "\u041d\u0435\u0442 ");
                                if (var0_4 == 1) {
                                    main.f.b(73, 0);
                                    main.f.M = false;
                                    break;
                                }
                                if (var0_4 != 2) break;
                                main.f.b(74, 0);
                                main.f.M = false;
                                break;
                            }
                            var0_4 = super.a("\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u044c \u0434\u043b\u044f \u0432\u043e\u0437\u0432\u0440\u0430\u0449\u0435\u043d\u0438\u044f \u0432 \u0434\u0435\u0440\u0435\u0432\u043d\u044e? ", "\u0414\u0430 ", "\u041d\u0435\u0442 ");
                            if (var0_4 == 1) {
                                main.e.m(53);
                                main.f.M = false;
                                break;
                            }
                            if (var0_4 != 2) break;
                            main.f.M = false;
                            break;
                        }
                        if (main.f.L) {
                            a.c.a(a.a, a.b, main.f.g);
                            a.c();
                            super.H();
                            var1_10 = this;
                            if (!main.f.L) break;
                            var0_5 = 0x2B2B2B;
                            if (!var1_10.bU) {
                                super.K();
                            }
                            if (var1_10.bU) {
                                a.h.a(main.f.g, var1_10.aq, 0, 272 - var1_10.aq.getHeight());
                            }
                            a.h.a(main.f.g, main.f.aC, 0, 270);
                            a.d.a(main.f.g, main.f.bT[main.f.bR], var0_5, 10, (42 - (a.g.b << 1) >> 1) + 320 - 47, 220, a.g.b << 1);
                            if (!main.f.d(49184)) break;
                            if (a.d.c()) {
                                if (a.d.d()) break;
                                a.d.a(false);
                                var1_10.aq = null;
                                var1_10.bU = false;
                                System.gc();
                                if (++main.f.bR < main.f.bT.length) break;
                                main.f.bR = 0;
                                main.f.L = false;
                                main.f.bT = null;
                                switch (main.f.bS) {
                                    case 0: {
                                        switch (main.f.bQ) {
                                            case 3: {
                                                if (!main.f.aN) break;
                                                var1_10.ab.a("gate", true, 1);
                                                break;
                                            }
                                            case 13: {
                                                main.f.W = true;
                                                main.f.E = true;
                                                break;
                                            }
                                            case 18: {
                                                a.c[7].c(4, 1);
                                                a.c[7].b(true);
                                                main.f.g();
                                                a.c[main.f.c].b(true);
                                                break;
                                            }
                                            case 19: {
                                                a.c[7].c(0, 1);
                                                main.e.a(32, 1);
                                                break;
                                            }
                                            case 21: {
                                                a.c[main.f.c].b(false);
                                                main.f.b(22, 0);
                                                break;
                                            }
                                            case 22: {
                                                a.c[main.f.c].b(0, main.e.H[main.e.I]);
                                                a.c[main.f.c].c(main.e.H[main.e.I], 1);
                                                a.c[main.f.c].b(false);
                                                main.f.D = true;
                                                break;
                                            }
                                            case 23: {
                                                main.f.g();
                                                break;
                                            }
                                            case 35: {
                                                main.e.c(54, 1);
                                                main.e.c(55, 1);
                                                break;
                                            }
                                            case 42: {
                                                a.c[31].b(false);
                                                a.c[31].c(4, 1);
                                                break;
                                            }
                                            case 43: {
                                                a.c[24].c(9, 1);
                                                break;
                                            }
                                            case 64: {
                                                a.a(6);
                                                break;
                                            }
                                            case 65: {
                                                main.f.W = true;
                                                main.f.E = true;
                                                break;
                                            }
                                            case 66: {
                                                main.f.W = true;
                                                main.f.E = true;
                                                main.f.f(5);
                                                break;
                                            }
                                            case 67: {
                                                a.a(6);
                                                break;
                                            }
                                            case 70: {
                                                main.f.W = true;
                                                main.f.E = true;
                                                main.f.f(5);
                                                break;
                                            }
                                            case 71: {
                                                a.c[7].a[3] = true;
                                                a.h.a();
                                                break;
                                            }
                                            case 73: {
                                                main.e.a(33, 1);
                                                main.e.b(32, 1);
                                            }
                                        }
                                        break;
                                    }
                                    case 1: {
                                        if (main.e.p(main.f.bQ) == 2) {
                                            main.e.c(main.f.bQ, 3);
                                        } else {
                                            main.e.c(main.f.bQ, 2);
                                            if (main.e.p(main.f.bQ) == 1) {
                                                main.e.e();
                                            }
                                        }
                                        if (main.f.bQ == 2) {
                                            main.f.S[1] = 9;
                                            main.f.a("\u041e\u0442\u043a\u0440\u044b\u0442\u0430 \u043d\u043e\u0432\u0430\u044f \u0441\u0446\u0435\u043d\u0430 " + main.f.R[1]);
                                            break;
                                        }
                                        if (main.f.bQ == 7) {
                                            main.f.S[2] = 9;
                                            main.f.a("\u041e\u0442\u043a\u0440\u044b\u0442\u0430 \u043d\u043e\u0432\u0430\u044f \u0441\u0446\u0435\u043d\u0430 " + main.f.R[2]);
                                            break;
                                        }
                                        if (main.f.bQ == 10) {
                                            main.f.S[3] = 9;
                                            main.f.a("\u041e\u0442\u043a\u0440\u044b\u0442\u0430 \u043d\u043e\u0432\u0430\u044f \u0441\u0446\u0435\u043d\u0430 " + main.f.R[3]);
                                            break;
                                        }
                                        if (main.f.bQ == 13) {
                                            main.f.S[4] = 9;
                                            main.f.a("\u041e\u0442\u043a\u0440\u044b\u0442\u0430 \u043d\u043e\u0432\u0430\u044f \u0441\u0446\u0435\u043d\u0430 " + main.f.R[4]);
                                            break;
                                        }
                                        if (main.f.bQ == 18) {
                                            main.f.S[5] = 9;
                                            main.f.a("\u041e\u0442\u043a\u0440\u044b\u0442\u0430 \u043d\u043e\u0432\u0430\u044f \u0441\u0446\u0435\u043d\u0430 " + main.f.R[5]);
                                            break;
                                        }
                                        if (main.f.bQ != 23) break;
                                        main.f.S[6] = 9;
                                        main.f.a("\u041e\u0442\u043a\u0440\u044b\u0442\u0430 \u043d\u043e\u0432\u0430\u044f \u0441\u0446\u0435\u043d\u0430 " + main.f.R[6]);
                                        break;
                                    }
                                    case 2: {
                                        main.e.c(main.f.bQ, 4);
                                        main.e.A(main.f.bQ);
                                        main.e.a(main.e.w(main.f.bQ), main.e.x(main.f.bQ));
                                        if (main.e.z(main.f.bQ) > 0) {
                                            main.f.a(main.e.z(main.f.bQ));
                                            main.f.a("\u041f\u043e\u043b\u0443\u0447\u0435\u043d\u043e " + main.e.z(main.f.bQ) + "\u0417\u043e\u043b\u043e\u0442\u0430 ");
                                        }
                                        if (main.e.y(main.f.bQ) > 0) {
                                            main.e.G(main.e.y(main.f.bQ));
                                            main.f.a("\u041f\u043e\u043b\u0443\u0447\u0435\u043d\u043e " + main.e.y(main.f.bQ) + "\u041e\u043f\u044b\u0442\u0430 ");
                                        }
                                        if (main.f.bQ == 44) {
                                            main.f.M = true;
                                        } else if (main.f.bQ == 0) {
                                            main.e.c(0);
                                            main.f.a("\u0412 \u043c\u0430\u0433\u0430\u0437\u0438\u043d\u0435 \u043c\u043e\u0436\u043d\u043e \u0438\u0437\u0443\u0447\u0438\u0442\u044c \u0434\u0440\u0443\u0433\u0438\u0435 \u043d\u0430\u0432\u044b\u043a\u0438 ");
                                            main.f.a("\u0412 \u043a\u0443\u0437\u043d\u0438\u0446\u0435 \u043c\u043e\u0436\u043d\u043e \u043c\u043e\u0434\u0435\u0440\u043d\u0438\u0437\u0438\u0440\u043e\u0432\u0430\u0442\u044c \u043f\u0440\u0435\u0434\u043c\u0435\u0442\u044b \u044d\u043a\u0438\u043f\u0438\u0440\u043e\u0432\u043a\u0438 ");
                                            main.f.a("\u041c\u044b \u043d\u0435 \u0438\u0449\u0435\u043c \u043b\u0435\u0433\u043a\u0438\u0445 \u043f\u0443\u0442\u0435\u0439.");
                                            main.f.a("\u0423\u0441\u0442\u0430\u043d\u043e\u0432\u0438\u0442\u0435 \u0431\u044b\u0441\u0442\u0440\u044b\u0439 \u0434\u043e\u0441\u0442\u0443\u043f \u043a \u043d\u0430\u0432\u044b\u043a\u0430\u043c \u043d\u0430 \u0441\u043e\u0447\u0435\u0442\u0430\u043d\u0438\u044f \u043a\u043b\u0430\u0432\u0438\u0448");
                                        } else if (main.f.bQ == 1) {
                                            main.f.a("\u041c\u044b \u043d\u0435 \u043f\u043e\u043b\u044c\u0437\u0443\u0435\u043c\u0441\u044f \u0447\u0438\u0442\u0430\u043c\u0438.");
                                        } else if (main.f.bQ == 2) {
                                            main.f.a("\u041e\u0442\u043a\u0440\u044b\u0442 \u0434\u043e\u0441\u0442\u0443\u043f \u043a \u0441\u0438\u043d\u0442\u0435\u0437\u0443 \u043e\u0431\u043e\u0440\u0443\u0434\u043e\u0432\u0430\u043d\u0438\u044f \u0438 \u043f\u0440\u0435\u043f\u0430\u0440\u0430\u0442\u043e\u0432");
                                        } else if (main.f.bQ == 24) {
                                            main.e.c(2);
                                        } else if (main.f.bQ == 43) {
                                            main.e.c(1);
                                        }
                                        if (main.e.o(main.f.bQ)) {
                                            main.e.C = main.e.u(main.f.bQ);
                                            main.e.c(main.e.C, 1);
                                            main.e.s(main.e.C);
                                            main.f.b(main.e.C, 1);
                                            if (main.e.v(main.f.bQ) > 0) {
                                                main.e.c(main.e.v(main.f.bQ), 1);
                                            }
                                            if (main.f.bQ == 29) {
                                                main.e.c(65, 1);
                                                main.e.c(66, 1);
                                                main.e.c(67, 1);
                                                break;
                                            }
                                            if (main.f.bQ == 35) {
                                                main.e.c(68, 1);
                                                main.e.c(69, 1);
                                                main.e.c(70, 1);
                                                break;
                                            }
                                            if (main.f.bQ != 38) break;
                                            main.e.c(71, 1);
                                            main.e.c(72, 1);
                                            main.e.c(73, 1);
                                            main.e.c(74, 1);
                                            break;
                                        }
                                        if (main.e.u(main.f.bQ) > 0) {
                                            main.e.c(main.e.u(main.f.bQ), 1);
                                        }
                                        if (main.f.bQ == 45) {
                                            main.e.c(76, 1);
                                            main.e.c(77, 1);
                                            main.e.c(78, 1);
                                            main.e.c(79, 1);
                                            main.e.c(80, 1);
                                        } else if (main.f.bQ == 76) {
                                            main.e.a(14);
                                        } else if (main.f.bQ == 77) {
                                            main.e.a(15);
                                        } else if (main.f.bQ == 78) {
                                            main.e.a(16);
                                        } else if (main.f.bQ == 79) {
                                            main.e.a(17);
                                        } else if (main.f.bQ == 80) {
                                            main.e.a(18);
                                        }
                                        main.e.a(8);
                                        main.e.b();
                                    }
                                }
                                break;
                            }
                            a.d.b();
                            break;
                        }
                        var1_10 = this;
                        main.f.ac.a(true);
                        a.c.a(a.a, a.b, main.f.g);
                        if (main.f.k != 7) break;
                        a.c();
                        this = var1_10;
                        if (this.bB > 30) {
                            v0 = false;
                        } else {
                            ++this.bB;
                            if (main.f.K != 701 && main.f.K != 702 && main.f.K != 610) {
                                var2_15 = "";
                                if (main.f.K != 0) {
                                    var2_15 = "- " + main.f.K % 100 + "  \u0441\u0446\u0435\u043d\u0430 ";
                                }
                                if (this.bc[main.f.Q] == 4) {
                                    var2_15 = "- " + (main.f.K % 100 - 4) + "  \u0441\u0446\u0435\u043d\u0430 ";
                                } else if (this.bc[main.f.Q] == 6) {
                                    var2_15 = "- " + (main.f.K % 100 - 4) + "  \u0441\u0446\u0435\u043d\u0430 ";
                                }
                                a.d.b(main.f.g, main.f.R[this.bc[main.f.Q]] + var2_15, -1, 320 - a.g.b >> 1, 0, 0xFFFFFF, 20);
                            }
                            v0 = true;
                        }
                        super.G();
                        super.H();
                        if (!main.f.d(32768)) break;
                        main.f.k = 9;
                        main.f.n(1);
                        main.f.f = 0;
                        var1_10.ab.a();
                        break;
                    }
                    case 9: {
                        v1 = main.f.aD = main.f.aN != false ? ": \u0412\u043a\u043b " : ": \u0412\u044b\u043a\u043b ";
                        if (main.f.f == 0) {
                            if (!main.f.bx) {
                                a.c.a(a.a, a.b, main.f.g);
                                a.c();
                                super.H();
                            } else {
                                a.c.a(a.a, a.b, main.f.g);
                                a.c();
                                a.d.b(main.f.g, "\u041a\u043e\u043d\u0435\u0446 \u0438\u0433\u0440\u044b ", -1, 160, 0, 0xFFFFFF, 20);
                                super.H();
                            }
                            if (!main.f.bx) {
                                a.d.a(main.f.g, "\u0412\u044b\u0431\u043e\u0440 ", null);
                            } else {
                                a.d.a(main.f.g, "\u0412\u044b\u0445\u043e\u0434 ", "\u041f\u0440\u043e\u0434\u043e\u043b\u0436\u0438\u0442\u044c \u0438\u0433\u0440\u0443 ");
                            }
                            ++main.f.f;
                        }
                        if (!main.f.bx) {
                            a.h.a(main.f.g, 0, 160 - this.by, 240, this.by << 1);
                            main.f.e(120, 160);
                            main.f.f(120, 160);
                            if (this.bz == 0) {
                                if (this.by < a.g.b * (main.f.bw.length + 1) / 2) {
                                    this.by += a.g.b * (main.f.bw.length + 1) / 2;
                                    break;
                                }
                            } else if (this.bz == 1 && this.by > 0) {
                                this.by -= a.g.b * (main.f.bw.length + 1) / 2;
                                main.f.f = 0;
                                break;
                            }
                            super.J();
                            if (this.by != 0 && main.f.bM > 0 && (main.f.aI == 1 || main.f.aI == 2 || main.f.aI == 4 || main.f.aI == 5 || main.f.aI == 36)) {
                                this.bz = 1;
                                break;
                            }
                            if (main.f.bM <= 0) break;
                            super.m(main.f.aI);
                            main.f.f = 0;
                            main.f.bM = 0;
                            this.bz = 0;
                            break;
                        }
                        if (main.f.d(65536)) {
                            this.aR = 0;
                            if (super.j(main.f.bt)) {
                                super.I();
                                super.k(main.f.bt);
                                main.f.k = 2;
                                break;
                            }
                            this.i();
                            break;
                        }
                        if (!main.f.d(32768)) break;
                        this.i();
                        break;
                    }
                    case 11: {
                        if ((main.f.i & 65536) != 0) {
                            if (!this.bA) {
                                main.f.k = 5;
                            } else {
                                main.f.f = 0;
                                main.f.k = 9;
                            }
                            a.d.i();
                            break;
                        }
                        if (main.f.aO == 2) {
                            a.h.a(main.f.g, main.f.ay[2], 0, 0);
                            a.d.b(main.f.g, "\u041d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438 ", -1, 5 + (20 - a.g.b >> 1), 15597476, 6895442, 20);
                            main.f.aD = main.f.aN != false ? "\u0417\u0432\u0443\u043a: \u0432\u043a\u043b " : "\u0417\u0432\u0443\u043a: \u0432\u044b\u043a\u043b ";
                            a.d.b(main.f.g, main.f.aD, 240 - a.g.a.stringWidth(main.f.aD) >> 1, 160, 0, 0xFFFFFF, 20);
                            a.d.a(main.f.g, "\u0418\u0437\u043c\u0435\u043d\u0438\u0442\u044c ", "\u041d\u0430\u0437\u0430\u0434 ");
                            if (!main.f.d(49184)) break;
                            if (main.f.aN = main.f.aN == false) {
                                this.ab.a("menu", true, 1);
                                break;
                            }
                            this.ab.a();
                            break;
                        }
                        if (main.f.aO == 4) {
                            a.d.a(main.f.g, main.e.b, 120, 50, main.f.ay[2], null);
                            a.d.b(main.f.g, "\u041e\u0431 \u0438\u0433\u0440\u0435 ", -1, 30 - a.g.b >> 1, 15597476, 6895442, 20);
                            if (main.f.d(5140)) {
                                a.d.g();
                            }
                            if (!main.f.d(10560)) break;
                            a.d.h();
                            break;
                        }
                        if (main.f.aO != 3) break;
                        a.d.a(main.f.g, main.e.c, 120, 50, main.f.ay[2], null);
                        a.d.b(main.f.g, "\u0418\u043d\u0441\u0442\u0440\u0443\u043a\u0446\u0438\u0438 ", -1, 30 - a.g.b >> 1, 15597476, 6895442, 20);
                        if (main.f.d(5140)) {
                            a.d.g();
                        }
                        if (!main.f.d(10560)) break;
                        a.d.h();
                        break;
                    }
                    case 2: {
                        super.k();
                        break;
                    }
                    case 3: {
                        if (!a.h.a(main.f.g, main.f.aB)) break;
                        main.f.k = 8;
                        main.f.f = 0;
                        main.f.aE = 0;
                        break;
                    }
                    case 12: {
                        break;
                    }
                    case 8: {
                        switch (this.bv) {
                            case 0: {
                                this.bv = 1;
                                break;
                            }
                            case 1: {
                                a.h.a(main.f.g, 0);
                                main.f.g.drawImage(main.f.ay[1], 0, 0, 20);
                                a.d.b(main.f.g, "\u0411\u0435\u0437 \u0437\u0432\u0443\u043a\u0430 \u0431\u043e\u043b\u0435\u0435 \u0431\u044b\u0441\u0442\u0440\u0430\u044f \u0438\u0433\u0440\u0430 ", -1, 320 - a.g.b - 60, 16770143, 0, 20);
                                a.d.b(main.f.g, "\u0410\u043a\u0442\u0438\u0432\u0438\u0440\u043e\u0432\u0430\u0442\u044c \u0437\u0432\u0443\u043a? ", -1, 267 + (26 - a.g.b >> 1), 16770143, 0, 20);
                                a.d.a(main.f.g, "\u0414\u0430 ", "\u041d\u0435\u0442 ");
                                if ((main.f.i & 32768) != 0) {
                                    main.f.k = 6;
                                    this.ab.a("menu", true, 1);
                                    main.f.aN = true;
                                    this.bv = 0;
                                    break;
                                }
                                if ((main.f.i & 65536) == 0) break;
                                main.f.k = 6;
                                main.f.aN = false;
                                this.bv = 0;
                            }
                        }
                        break;
                    }
                    case 17: {
                        a.h.a(main.f.g, main.f.ay[2], 0, 0);
                        block57 : switch (this.bh) {
                            case 0: {
                                super.B();
                                break;
                            }
                            case 1: {
                                super.D();
                                if ((main.f.f += 8) >= 40) {
                                    main.f.f = 0;
                                    if (this.bj > 0) {
                                        --this.bj;
                                    } else {
                                        this.bj = 6;
                                        main.e.f();
                                    }
                                    this.bh = 0;
                                    if (this.bj == 4) {
                                        main.e.c();
                                        break;
                                    }
                                }
                                break block253;
                            }
                            case 2: {
                                super.D();
                                if ((main.f.f -= 8) <= -40) {
                                    main.f.f = 0;
                                    this.bj = this.bj < 6 ? ++this.bj : 0;
                                    this.bh = 0;
                                    if (this.bj == 4) {
                                        main.e.c();
                                        break;
                                    }
                                    if (this.bj == 6) {
                                        main.e.f();
                                        break;
                                    }
                                }
                                break block253;
                            }
                            case 3: {
                                var1_10 = this;
                                a.h.a(main.f.g, main.f.ay[0], 0, 320 - main.f.ay[0].getHeight());
                                a.h.a(main.f.g, main.f.ay[3], 2, 303, 17, 15, 0, 0);
                                a.h.a(main.f.g, main.f.h, main.f.ay[0], 213, 298, 27, 22, 0, 0);
                                a.h.a(main.f.g, main.f.ay[3], 221, 303, 17, 15, 17, 0);
                                a.d.b(main.f.g, "\u0421\u0442\u0430\u0442\u0443\u0441 ", -1, 5 + (20 - a.g.b >> 1), 15597476, 6362880, 20);
                                a.h.a(main.f.g, 12, 46, 214, 24, 7299920, 14658680);
                                main.f.g.setColor(16708041);
                                main.f.g.fillRect(15, 48, 82, 20);
                                main.f.g.fillRect(99, 48, 124, 20);
                                a.h.a(main.f.g, var1_10.am, 43, 52, 25, 13, 0, 39);
                                a.d.b(main.f.g, main.e.h[main.e.X[0] * 3], 161, 46 + (24 - a.g.b >> 1), 15597476, 7085131, 17);
                                a.d.a(main.f.g, main.e.y, null, main.e.A, 12, 71, 214, 6);
                                a.h.a(main.f.g, 12, 222, 214, 68, 6907220, 14593146);
                                a.h.a(main.f.g, 14, 224, 210, 64, 9600109, 8020827);
                                if (main.f.L) {
                                    main.f.g(200, 60);
                                    break;
                                }
                                a.d.a(main.f.g, main.e.z[main.e.B[a.d.m()]], 15597476, 16, 225, 216, 62);
                                if (a.d.c() && a.a.b(20)) {
                                    a.d.d();
                                }
                                if (main.f.d(65536)) {
                                    a.d.a(false);
                                    a.d.l();
                                    main.e.d();
                                    var1_10.bh = 0;
                                    break;
                                }
                                if (main.f.d(49184)) {
                                    if (main.e.k[main.e.B[a.d.m()]]) {
                                        main.e.X[0] = main.e.B[a.d.m()];
                                        main.e.b(0);
                                        main.f.bs = "\u0421\u0442\u0430\u0442\u0443\u0441 \u0438\u0437\u043c\u0435\u043d\u0435\u043d ";
                                    } else {
                                        main.f.bs = "\u0421\u0442\u0430\u0442\u0443\u0441 \u043d\u0435 \u0430\u043a\u0442\u0438\u0432\u0438\u0440\u043e\u0432\u0430\u043d ";
                                    }
                                    main.f.L = true;
                                    a.d.a(false);
                                    break;
                                }
                                if (main.f.d(1028)) {
                                    a.d.a(false);
                                    a.d.j();
                                    break;
                                }
                                if (!main.f.d(2304)) break block1;
                                a.d.a(false);
                                a.d.k();
                                break;
                            }
                            case 4: {
                                var1_10 = this;
                                a.h.a(main.f.g, main.f.ay[0], 0, 320 - main.f.ay[0].getHeight());
                                a.h.a(main.f.g, main.f.ay[3], 2, 303, 17, 15, 0, 0);
                                a.h.a(main.f.g, main.f.h, main.f.ay[0], 213, 298, 27, 22, 0, 0);
                                a.h.a(main.f.g, main.f.ay[3], 221, 303, 17, 15, 17, 0);
                                a.d.b(main.f.g, var1_10.br[var1_10.bo + 1], -1, 5 + (20 - a.g.b >> 1), 15597476, 6362880, 20);
                                a.h.a(main.f.g, 80, 290, 78, 21, 7299920, 14658680);
                                a.h.a(main.f.g, 82, 291, 74, 19, 14658680, 16708041);
                                a.h.a(main.f.g, var1_10.ar, 82, 292);
                                a.h.b(main.f.g, main.f.as, main.f.aG, 102, 297, 7, 7, 0);
                                a.d.a(main.f.g, main.e.y, null, null, 12, 46, 214, 6);
                                a.h.a(main.f.g, 12, 222, 214, 68, 6907220, 14593146);
                                a.h.a(main.f.g, 14, 224, 210, 64, 9600109, 8020827);
                                if (main.f.L) {
                                    main.f.g(200, 60);
                                    break;
                                }
                                a.d.a(main.f.g, main.e.h(main.e.B[a.d.m()]), 15597476, 16, 225, 206, 62);
                                if (a.d.c() && a.a.b(20)) {
                                    a.d.d();
                                }
                                if (main.f.d(65536)) {
                                    main.e.d();
                                    a.d.a(false);
                                    a.d.l();
                                    var1_10.bh = 0;
                                    break;
                                }
                                if (main.f.d(49184)) {
                                    var1_10.bh = 5;
                                    a.d.a(false);
                                    break;
                                }
                                if (main.f.d(1028)) {
                                    a.d.a(false);
                                    a.d.j();
                                    break;
                                }
                                if (!main.f.d(2304)) break block1;
                                a.d.a(false);
                                a.d.k();
                                break;
                            }
                            case 5: {
                                super.C();
                                break;
                            }
                            case 6: {
                                super.E();
                                break;
                            }
                            case 7: {
                                var1_10 = this;
                                a.h.a(main.f.g, main.f.ay[0], 0, 320 - main.f.ay[0].getHeight());
                                a.h.a(main.f.g, main.f.ay[3], 2, 303, 17, 15, 0, 0);
                                a.h.a(main.f.g, main.f.h, main.f.ay[0], 213, 298, 27, 22, 0, 0);
                                a.h.a(main.f.g, main.f.ay[3], 221, 303, 17, 15, 17, 0);
                                a.d.b(main.f.g, "\u0420\u0435\u043a\u0432\u0438\u0437\u0438\u0442 ", -1, 30 - a.g.b >> 1, 15597476, 6764371, 20);
                                a.d.a(main.f.g, main.e.y, null, main.e.z, 12, 66, 214, 6);
                                a.h.a(main.f.g, 12, 222, 214, 68, 6907220, 14593146);
                                a.h.a(main.f.g, 14, 224, 210, 64, 9600109, 8020827);
                                if (!main.f.L) ** GOTO lbl795
                                if (var1_10.bo != 1) ** GOTO lbl778
                                var0_6 = 0;
                                switch (var1_10.bq) {
                                    case 0: {
                                        var4_17 = "\u0423\u0434 ";
                                        var3_18 = "\u041a\u043b ";
                                        var2_16 = "\u0414\u0430 ";
                                        var0_7 = var1_10;
                                        a.h.a(main.f.g, 38, 139, 164, 42, 6907220, 16635556);
                                        a.h.a(main.f.g, 41, 142, 158, 36, 16568212, 0xFEEFCE);
                                        if (var0_7.bV == 0) {
                                            a.h.a(main.f.g, 46, 149, 46, 25, 0xFEEFCE, 13549230);
                                        } else if (var0_7.bV == 1) {
                                            a.h.a(main.f.g, 92, 149, 46, 25, 0xFEEFCE, 13549230);
                                        } else if (var0_7.bV == 2) {
                                            a.h.a(main.f.g, 138, 149, 46, 25, 0xFEEFCE, 13549230);
                                        }
                                        a.d.c(main.f.g, var2_16, 46 + (46 - a.g.a.stringWidth(var2_16) >> 1), 149 + (25 - a.g.b >> 1), 15597476, 6764371, 20);
                                        a.d.c(main.f.g, var3_18, 92 + (46 - a.g.a.stringWidth(var3_18) >> 1), 149 + (25 - a.g.b >> 1), 15597476, 6764371, 20);
                                        a.d.c(main.f.g, var4_17, 138 + (46 - a.g.a.stringWidth(var4_17) >> 1), 149 + (25 - a.g.b >> 1), 15597476, 6764371, 20);
                                        if (main.f.d(49184)) {
                                            a.d.a(false);
                                            if (var0_7.bV == 0) {
                                                var0_7.bV = 0;
                                                v2 = 1;
                                            } else if (var0_7.bV == 1) {
                                                var0_7.bV = 0;
                                                v2 = 2;
                                            } else {
                                                var0_7.bV = 0;
                                                v2 = 3;
                                            }
                                        } else {
                                            if (main.f.d(4112)) {
                                                if (var0_7.bV > 0) {
                                                    --var0_7.bV;
                                                }
                                            } else if (main.f.d(8256) && var0_7.bV < 2) {
                                                ++var0_7.bV;
                                            }
                                            v2 = var0_8 = 0;
                                        }
                                        if (v2 == 1) {
                                            main.e.m(main.e.B[a.d.m()]);
                                            main.f.L = false;
                                            main.e.d();
                                            main.e.n(var1_10.bo + 9);
                                            break;
                                        }
                                        if (var0_8 == 2) {
                                            a.d.a(false);
                                            var1_10.bq = 1;
                                            break;
                                        }
                                        if (var0_8 == 3) {
                                            a.d.a(false);
                                            var1_10.bq = 2;
                                            break;
                                        }
                                        ** GOTO lbl791
                                    }
                                    case 1: {
                                        var0_6 = super.a("\u0412\u044b\u0431\u0435\u0440\u0438\u0442\u0435 \u043a\u043b\u0430\u0432\u0438\u0448\u0443 \u0434\u043b\u044f \u0431\u044b\u0441\u0442\u0440\u043e\u0433\u043e \u0434\u043e\u0441\u0442\u0443\u043f\u0430", "1 ", "3 ");
                                        if (var0_6 == 1) {
                                            main.e.s = main.e.B[a.d.m()];
                                            if (main.e.s == main.e.t) {
                                                main.e.t = -1;
                                            }
                                            a.d.a(false);
                                            main.f.L = false;
                                            var1_10.bq = 0;
                                            break;
                                        }
                                        if (var0_6 == 2) {
                                            main.e.t = main.e.B[a.d.m()];
                                            if (main.e.s == main.e.t) {
                                                main.e.s = -1;
                                            }
                                            a.d.a(false);
                                            main.f.L = false;
                                            var1_10.bq = 0;
                                            break;
                                        }
                                        ** GOTO lbl791
                                    }
                                    case 2: {
                                        var0_6 = super.a("\u0411\u0440\u043e\u0441\u0438\u0442\u044c? ", "\u0414\u0430 ", "\u041d\u0435\u0442 ");
                                        if (var0_6 == 1) {
                                            main.e.j(main.e.B[a.d.m()]);
                                            main.e.d();
                                            main.e.n(var1_10.bo + 9);
                                            a.d.a(false);
                                            main.f.L = false;
                                            var1_10.bq = 0;
                                            break;
                                        }
                                        if (var0_6 == 2) {
                                            a.d.a(false);
                                            main.f.L = false;
                                            var1_10.bq = 0;
                                        } else {
                                            break;
                                        }
                                    }
                                }
                                ** GOTO lbl791
lbl778:
                                // 1 sources

                                var0_9 = 0;
                                var0_9 = main.e.a(main.e.B[a.d.m()], 8, false) > 0 ? super.a("\u0411\u0440\u043e\u0441\u0438\u0442\u044c? ", "\u0414\u0430 ", "\u041d\u0435\u0442 ") : super.a("\u041d\u0435\u043b\u044c\u0437\u044f \u0431\u0440\u043e\u0441\u0438\u0442\u044c ", "\u0414\u0430 ", "\u041d\u0430\u0437\u0430\u0434 ");
                                if (var0_9 == 1) {
                                    if (main.e.a(main.e.B[a.d.m()], 8, false) > 0) {
                                        main.e.j(main.e.B[a.d.m()]);
                                        main.e.d();
                                        main.e.n(var1_10.bo + 9);
                                    }
                                    a.d.a(false);
                                    main.f.L = false;
                                } else if (var0_9 == 2) {
                                    a.d.a(false);
                                    main.f.L = false;
                                }
lbl791:
                                // 7 sources

                                if (!main.f.d(65536)) break block1;
                                main.f.L = false;
                                a.d.a(false);
                                break;
lbl795:
                                // 1 sources

                                a.d.a(main.f.g, main.e.h(main.e.B[a.d.m()]), 15597476, 16, 225, 208, 62);
                                if (a.d.c() && a.a.b(20)) {
                                    a.d.d();
                                }
                                if (main.f.d(65536)) {
                                    a.d.a(false);
                                    a.d.l();
                                    main.e.d();
                                    var1_10.bh = 0;
                                    break;
                                }
                                if (main.f.d(49184)) {
                                    if (main.e.B[0] < 0) break block1;
                                    main.f.L = true;
                                    a.d.a(false);
                                    break;
                                }
                                if (main.f.d(1028)) {
                                    a.d.a(false);
                                    a.d.j();
                                    break;
                                }
                                if (!main.f.d(2304)) break block1;
                                a.d.a(false);
                                a.d.k();
                                break;
                            }
                            case 8: {
                                super.A();
                                break;
                            }
                            case 9: {
                                var1_10 = this;
                                switch (var1_10.bk) {
                                    case 1: {
                                        this = var1_10;
                                        a.h.a(main.f.g, main.f.ay[0], 0, 320 - main.f.ay[0].getHeight());
                                        a.h.a(main.f.g, main.f.ay[3], 2, 303, 17, 15, 0, 0);
                                        a.h.a(main.f.g, main.f.h, main.f.ay[0], 213, 298, 27, 22, 0, 0);
                                        a.h.a(main.f.g, main.f.ay[3], 221, 303, 17, 15, 17, 0);
                                        a.d.b(main.f.g, "\u041a\u043e\u0432\u043a\u0430 ", -1, 30 - a.g.b >> 1, 15597476, 6764371, 20);
                                        a.h.a(main.f.g, 80, 290, 78, 21, 7299920, 14658680);
                                        a.h.a(main.f.g, 82, 291, 74, 19, 14658680, 16708041);
                                        a.h.a(main.f.g, this.ar, 82, 292);
                                        a.h.b(main.f.g, main.f.as, main.f.aG, 102, 297, 7, 7, 0);
                                        a.d.a(main.f.g, main.e.y, null, main.e.z, 12, 56, 214, 6);
                                        a.h.a(main.f.g, 12, 212, 214, 68, 6907220, 14593146);
                                        a.h.a(main.f.g, 14, 214, 210, 64, 9600109, 8020827);
                                        a.d.a(main.f.g, main.e.h(main.e.B[a.d.m()]), 15597476, 16, 215, 206, 62);
                                        if (a.d.c() && a.a.b(20)) {
                                            a.d.d();
                                        }
                                        if (main.f.d(65536)) {
                                            this.bk = (byte)(this.bk + 100);
                                            a.d.l();
                                            main.e.d();
                                            break block57;
                                        }
                                        if (main.f.d(49184)) {
                                            if (main.e.B[a.d.m()] < 0) break block1;
                                            this.bk = (byte)(this.bk + 10);
                                            a.d.a(false);
                                            break block57;
                                        }
                                        if (main.f.d(1028)) {
                                            a.d.a(false);
                                            a.d.j();
                                            break block57;
                                        }
                                        if (!main.f.d(2304)) break block1;
                                        a.d.a(false);
                                        a.d.k();
                                        break block57;
                                    }
                                    case 11: {
                                        super.w();
                                        break block57;
                                    }
                                    case 101: {
                                        super.z();
                                    }
                                }
                            }
                        }
                        break;
                    }
                    case 16: {
                        a.h.a(main.f.g, main.f.ay[2], 0, 0);
                        if (!main.e.i(32)) {
                            if (a.d.a(main.f.g, main.e.f)) {
                                main.f.K = 702;
                                main.f.N = false;
                                main.f.k = 2;
                                break;
                            }
                            if (!main.f.d(65536)) break;
                            a.d.a();
                            break;
                        }
                        if (a.d.a(main.f.g, main.e.e)) {
                            this.i();
                            break;
                        }
                        if (!main.f.d(65536)) break;
                        a.d.a();
                        break;
                    }
                    case 19: {
                        a.h.a(main.f.g, main.f.ay[2], 0, 0);
                        switch (this.bh) {
                            case 0: {
                                super.r();
                                break;
                            }
                            case 1: 
                            case 2: {
                                super.s();
                            }
                        }
                        break;
                    }
                    case 20: {
                        a.h.a(main.f.g, main.f.ay[2], 0, 0);
                        switch (this.bh) {
                            case 0: {
                                super.t();
                                break;
                            }
                            case 1: 
                            case 2: 
                            case 3: {
                                super.v();
                                break;
                            }
                            case 11: {
                                super.w();
                                break;
                            }
                            case 12: {
                                super.x();
                                break;
                            }
                            case 13: {
                                super.y();
                                break;
                            }
                            case 101: 
                            case 102: 
                            case 103: {
                                super.u();
                            }
                        }
                        break;
                    }
                    case 21: {
                        a.h.a(main.f.g, this.aj, 0, 0);
                        if (a.d.a(main.f.g, main.e.d)) {
                            main.f.K = 0;
                            main.f.k = 2;
                            break;
                        }
                        if (!main.f.d(65536)) break;
                        a.d.a();
                        break;
                    }
                    case 18: {
                        super.F();
                        break;
                    }
                    case 22: {
                        super.q();
                        break;
                    }
                    case 24: {
                        super.p();
                        break;
                    }
                    case 25: {
                        super.o();
                    }
                }
            }
            if (main.f.ag != 0) {
                main.f.af = 0;
            }
            main.f.ag = 0;
            main.f.g = null;
            return;
        }
        catch (Exception v3) {
            this = v3;
            v3.printStackTrace();
            return;
        }
    }

    private void c(int n, int n2) {
        g.setColor(0);
        a.h.a(g, 0, 0, 240, 320);
        if (n2 == 1) {
            ++this.aS;
            if (this.aS > 16) {
                this.aR = 7;
                return;
            }
        } else {
            --this.aS;
            if (this.aS < 0) {
                this.aR = 8;
                return;
            }
        }
        for (n = 0; n < 15; ++n) {
            g.fillRect(n << 4, 0, this.aS, 320);
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
            a.c.e = false;
            E = false;
            J = 0;
            this.bB = 0;
            main.e.l = false;
            main.e.m = false;
            main.e.o = 0;
            G = true;
            X = 0;
            Y = 0;
            main.f.a(-1, -1);
            a.d.a(false);
            a.a(0);
            if (main.e.i >= 10) {
                main.e.a(2);
            }
            if (K == 0 && !P && main.e.q(0) == 1) {
                main.f.b(17, 0);
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
                main.f.b(66, 0);
            } else if (K == 702) {
                main.f.b(71, 0);
            }
            main.f.c("/script" + K + ".bin");
            a.a(aX, aX.length);
            a.b(false);
            if (f == 0) {
                f = 1;
            }
            this.aR = 1;
            return;
        }
        if (this.aR == 1) {
            a.h.a(g, 0);
            a.h.a(g, 0, 77, 240, 120, 16745472, 16434560);
            a.h.a(g, 1, 78, 238, 118, 16434560, 0xFEEFCE);
            a.d.b(g, "\u0421\u043e\u0432\u0435\u0442: ", -1, 82, 25011, 8962304, 20);
            String[] stringArray = a.d.a(this.aT[this.aU], 240 / a.g.a.stringWidth("\u0412\u0432\u043e\u0434\u0438\u0442\u044c ") - 1);
            for (int i = 0; i < stringArray.length; ++i) {
                a.d.b(g, stringArray[i], -1, 102 + i * 20, 25011, 8962304, 20);
            }
            a.d.b(g, "\u0417\u0430\u0433\u0440\u0443\u0437\u043a\u0430 \u0441 forum.fonzo.ru ... ", -1, 275, 0xFFFFFF, 0, 20);
            if (a.a.b(20)) {
                this.aR = 2;
            }
            return;
        }
        if (this.aR == 2) {
            c = 0;
            a.a = 0;
            a.b = 0;
            E = false;
            this.c(true);
            this.g(K);
            a.c.a("/p" + K + ".DAT");
            a.d();
            ac.b();
            this.aR = 6;
            return;
        }
        if (this.aR == 6) {
            this.c(15, 1);
            return;
        }
        if (this.aR == 7) {
            ac.a(false);
            a.c.a(a.a, a.b, g);
            a.c();
            this.H();
            this.c(15, 2);
            return;
        }
        if (this.aR == 8) {
            this.aR = 0;
            f = 0;
            if (aN) {
                if (K == 0 || K == 610 || K == 701 || K == 702) {
                    this.ab.a("menu", true, 1);
                } else {
                    this.ab.a("gate", true, 1);
                }
            }
            ++this.aU;
            this.aU %= this.aT.length;
            k = 7;
            return;
        }
    }

    public static void b(int n) {
        O = n;
    }

    public final void keyPressed(int n) {
        int n2;
        if (ah > 0) {
            return;
        }
        af = n2 = main.f.h(n);
    }

    public final void keyReleased(int n) {
        int n2 = main.f.h(n);
        if ((j & n2) != 0) {
            af &= ~n2;
            return;
        }
        ag |= n2;
    }

    public final void keyRepeated(int n) {
        int n2;
        if (ah > 0) {
            return;
        }
        af = n2 = main.f.h(n);
    }

    private static int h(int n) {
        switch (n) {
            case -1: {
                return 1028;
            }
            case -2: {
                return 2304;
            }
            case -3: {
                return 4112;
            }
            case -4: {
                return 8256;
            }
            case -5: {
                return 16416;
            }
            case -6: {
                return 32768;
            }
            case -7: {
                return 65536;
            }
        }
        switch (n) {
            case 49: {
                return 2;
            }
            case 50: {
                return 4;
            }
            case 51: {
                return 8;
            }
            case 52: {
                return 16;
            }
            case 53: {
                return 32;
            }
            case 54: {
                return 64;
            }
            case 55: {
                return 128;
            }
            case 56: {
                return 256;
            }
            case 57: {
                return 512;
            }
            case 42: {
                return 262144;
            }
            case 48: {
                return 1;
            }
            case 35: {
                return 524288;
            }
        }
        return 0;
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
            main.f.n(1);
            main.f.f(2);
            return;
        }
        if (k == 5 || k == 11 || k == 16 || k == 18 || k == 21 || k == 22 || k == 25) {
            if (aN) {
                this.ab.a("menu", true, 1);
                return;
            }
        } else if ((k == 17 || k == 19 || k == 20 || k == 23 || k == 24) && aN) {
            if (K == 0 || K == 610 || K == 701 || K == 702) {
                this.ab.a("menu", true, 1);
                return;
            }
            this.ab.a("gate", true, 1);
        }
    }

    private static void l() {
        Z.repaint();
        Z.serviceRepaints();
    }

    private static void d(int n, int n2) {
        long l = System.currentTimeMillis();
        aK = -1;
        while (aK < 1) {
            long l2;
            Thread.yield();
            if (main.f.l) continue;
            main.f.l();
            ++aK;
            do {
                Thread.yield();
            } while ((l2 = System.currentTimeMillis() - l) < (long)n2 && l2 >= 0L);
            l = System.currentTimeMillis();
        }
    }

    public final void run() {
        f f2;
        Thread.yield();
        b.b();
        if (k == 1) {
            try {
                az = Image.createImage((String)"/bbox.png");
                aA = Image.createImage((String)"/red.png");
                aB = Image.createImage((String)"/king86.png");
                if (ay[1] == null) {
                    main.f.a(1, "/splash1.png");
                }
            }
            catch (Exception exception) {}
            f2 = this;
            this.bP = -8;
            ad = 1;
            main.f.d(1, 300);
            ad = 2;
            main.f.d(1, 200);
        }
        f2 = this;
        while (k != 0) {
            long l;
            Thread.yield();
            if (main.f.l) continue;
            if (ah > 0) {
                --ah;
            }
            f2.aL = System.currentTimeMillis();
            main.f.l();
            if (ai) continue;
            do {
                Thread.yield();
            } while ((l = System.currentTimeMillis() - f2.aL) < 50L && l > 0L);
        }
        f2.ab.a();
        cMIDlet.a.destroyApp(true);
    }

    private static void m() {
        RecordStore recordStore = null;
        try {
            recordStore = RecordStore.openRecordStore((String)"shanhaiyouxia_Title", (boolean)true);
            if (recordStore.getNumRecords() > 0) {
                Object object = recordStore.getRecord(1);
                object = new ByteArrayInputStream((byte[])object);
                DataInputStream dataInputStream = new DataInputStream((InputStream)object);
                for (int i = 0; i < main.e.k.length; ++i) {
                    main.e.k[i] = dataInputStream.readBoolean();
                }
                ((ByteArrayInputStream)object).close();
                dataInputStream.close();
                recordStore.closeRecordStore();
                recordStore = null;
            }
            recordStore.closeRecordStore();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    static void c() {
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] byArray = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            for (int i = 0; i < main.e.k.length; ++i) {
                dataOutputStream.writeBoolean(main.e.k[i]);
            }
            byArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            dataOutputStream.close();
        }
        catch (Exception exception) {
            // empty catch block
        }
        try {
            byteArrayOutputStream = RecordStore.openRecordStore((String)"shanhaiyouxia_Title", (boolean)true);
            if (byteArrayOutputStream.getNumRecords() > 0) {
                byteArrayOutputStream.setRecord(1, byArray, 0, byArray.length);
            } else {
                byteArrayOutputStream.addRecord(byArray, 0, byArray.length);
            }
            byteArrayOutputStream.closeRecordStore();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    private void i(int n) {
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] byArray = null;
        try {
            int n2;
            byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeInt(K);
            dataOutputStream.writeInt(main.e.K);
            dataOutputStream.writeInt(main.e.M);
            dataOutputStream.writeInt(main.e.L);
            dataOutputStream.writeInt(main.e.J);
            for (n2 = 0; n2 < main.e.X.length; ++n2) {
                dataOutputStream.writeInt(main.e.X[n2]);
            }
            for (n2 = 0; n2 < S.length; ++n2) {
                dataOutputStream.writeByte(S[n2]);
            }
            for (n2 = 0; n2 < main.e.u.length; ++n2) {
                dataOutputStream.writeBoolean(main.e.u[n2]);
            }
            dataOutputStream.writeInt(main.e.q);
            dataOutputStream.writeInt(main.e.r);
            for (n2 = 0; n2 < main.e.D.length; n2 += 8) {
                dataOutputStream.writeInt(main.e.D[n2]);
                dataOutputStream.writeInt(main.e.D[n2 + 1]);
                dataOutputStream.writeInt(main.e.D[n2 + 2]);
                dataOutputStream.writeInt(main.e.D[n2 + 3]);
            }
            dataOutputStream.writeInt(main.e.C);
            for (n2 = 0; n2 < main.e.x.length; ++n2) {
                dataOutputStream.writeInt(main.e.x[n2]);
            }
            dataOutputStream.writeByte(main.e.I);
            dataOutputStream.writeInt(a.c[main.f.c].c);
            dataOutputStream.writeInt(a.c[main.f.c].d);
            for (n2 = 0; n2 < main.e.F.length; ++n2) {
                dataOutputStream.writeByte(main.e.F[n2]);
            }
            dataOutputStream.writeInt(main.e.s);
            dataOutputStream.writeInt(main.e.t);
            dataOutputStream.writeInt(main.e.i);
            dataOutputStream.writeInt(main.e.j);
            dataOutputStream.writeInt(aG);
            dataOutputStream.writeInt(Q);
            dataOutputStream.writeInt(main.e.N);
            dataOutputStream.writeInt(main.e.O);
            dataOutputStream.writeInt(main.e.P);
            dataOutputStream.writeInt(main.e.Q);
            dataOutputStream.writeInt(main.e.R);
            byArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            dataOutputStream.close();
        }
        catch (Exception exception) {
            // empty catch block
        }
        try {
            byteArrayOutputStream = RecordStore.openRecordStore((String)(this.aW + n), (boolean)true);
            if (byteArrayOutputStream.getNumRecords() > 0) {
                byteArrayOutputStream.setRecord(1, byArray, 0, byArray.length);
            } else {
                byteArrayOutputStream.addRecord(byArray, 0, byArray.length);
            }
            byteArrayOutputStream.closeRecordStore();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    private boolean j(int n) {
        RecordStore recordStore = null;
        try {
            recordStore = RecordStore.openRecordStore((String)(this.aW + n), (boolean)true);
            if (recordStore.getNumRecords() > 0) {
                recordStore.closeRecordStore();
                return true;
            }
            recordStore.closeRecordStore();
        }
        catch (Exception exception) {}
        return false;
    }

    private boolean k(int n) {
        RecordStore recordStore = null;
        try {
            recordStore = RecordStore.openRecordStore((String)(((f)object).aW + n), (boolean)true);
            if (recordStore.getNumRecords() > 0) {
                int n2;
                Object object = recordStore.getRecord(1);
                object = new ByteArrayInputStream((byte[])object);
                DataInputStream dataInputStream = new DataInputStream((InputStream)object);
                K = dataInputStream.readInt();
                main.e.K = dataInputStream.readInt();
                main.e.M = dataInputStream.readInt();
                main.e.L = dataInputStream.readInt();
                main.e.J = dataInputStream.readInt();
                for (n2 = 0; n2 < main.e.X.length; ++n2) {
                    main.e.X[n2] = dataInputStream.readInt();
                }
                for (n2 = 0; n2 < S.length; ++n2) {
                    main.f.S[n2] = dataInputStream.readByte();
                }
                for (n2 = 0; n2 < main.e.u.length; ++n2) {
                    main.e.u[n2] = dataInputStream.readBoolean();
                }
                main.e.q = dataInputStream.readInt();
                main.e.r = dataInputStream.readInt();
                for (n2 = 0; n2 < main.e.D.length; n2 += 8) {
                    main.e.D[n2] = dataInputStream.readInt();
                    main.e.D[n2 + 1] = dataInputStream.readInt();
                    main.e.D[n2 + 2] = dataInputStream.readInt();
                    main.e.D[n2 + 3] = dataInputStream.readInt();
                }
                main.e.C = dataInputStream.readInt();
                for (n2 = 0; n2 < main.e.x.length; ++n2) {
                    main.e.x[n2] = dataInputStream.readInt();
                }
                main.e.I = dataInputStream.readByte();
                main.e.S = dataInputStream.readInt();
                main.e.T = dataInputStream.readInt();
                for (n2 = 0; n2 < main.e.F.length; ++n2) {
                    main.e.F[n2] = dataInputStream.readByte();
                }
                main.e.s = dataInputStream.readInt();
                main.e.t = dataInputStream.readInt();
                dataInputStream.readInt();
                main.e.j = dataInputStream.readInt();
                aG = dataInputStream.readInt();
                Q = dataInputStream.readInt();
                main.e.N = dataInputStream.readInt();
                main.e.O = dataInputStream.readInt();
                main.e.P = dataInputStream.readInt();
                main.e.Q = dataInputStream.readInt();
                main.e.R = dataInputStream.readInt();
                P = true;
                ((ByteArrayInputStream)object).close();
                dataInputStream.close();
                recordStore.closeRecordStore();
                return true;
            }
            recordStore.closeRecordStore();
        }
        catch (Exception exception) {}
        return false;
    }

    static int a(InputStream inputStream) {
        try {
            return inputStream.read();
        }
        catch (Exception exception) {
            return -1;
        }
    }

    static final int a(byte[] byArray, int n) {
        int n2;
        if ((n2 = byArray[n++]) < 0) {
            n2 += 256;
        }
        n2 <<= 8;
        n2 += byArray[n];
        if (byArray[n] < 0) {
            n2 += 256;
        }
        return n2;
    }

    private int n() {
        try {
            InputStream inputStream = inputStream.getClass().getResourceAsStream("/a.bin");
            int n = a.e.a(inputStream);
            int n2 = 2;
            a.e = new c[n];
            for (int i = 0; i < n; ++i) {
                int n3;
                int n4;
                int n5;
                Object object = new c();
                a.e[i] = object;
                c c2 = object;
                object = inputStream;
                c c3 = c2;
                int n6 = 0;
                c3.b = a.e.a((InputStream)object);
                int n7 = a.e.a((InputStream)object);
                c3.c = new byte[n7 << 2];
                n6 = 4 + a.e.a((InputStream)object, c3.c, 0, n7 << 2);
                n7 = a.e.a((InputStream)object);
                n6 += 2;
                c3.d = new byte[n7 << 3];
                c3.e = new byte[n7][];
                for (n5 = 0; n5 < n7; ++n5) {
                    main.f.a((InputStream)object);
                    n4 = 0;
                    n3 = main.f.a((InputStream)object);
                    n6 += 2;
                    c3.e[n5] = new byte[n3 << 2];
                    n6 += a.e.a((InputStream)object, c3.e[n5], 0, n3 << 2);
                    n6 += a.e.a((InputStream)object, c3.d, n5 << 3, 8);
                }
                n7 = a.e.a((InputStream)object);
                n6 += 2;
                c3.g = new byte[n7];
                c3.f = new byte[n7][];
                c3.h = new byte[n7];
                c3.i = new short[n7 << 2];
                for (n5 = 0; n5 < n7; ++n5) {
                    n4 = main.f.a((InputStream)object);
                    n3 = main.f.a((InputStream)object);
                    n6 += 2;
                    c3.g[n5] = (byte)n3;
                    c3.f[n5] = new byte[n3 << 1];
                    n6 += a.e.a((InputStream)object, c3.f[n5], 0, n3 << 1);
                    c3.h[n5] = (byte)main.f.a((InputStream)object);
                    ++n6;
                    n4 = (n4 - 1 - (n3 << 1) - 1) / 2;
                    for (n3 = 0; n3 < n4; ++n3) {
                        c3.i[(n5 << 2) + n3] = (short)a.e.a((InputStream)object);
                        n6 += 2;
                    }
                }
                n2 += n6;
            }
            inputStream.close();
            return n2;
        }
        catch (Exception exception) {
            System.out.println("Anim_err");
            return 0;
        }
    }

    private static void c(String object) {
        try {
            object = new DataInputStream(object.getClass().getResourceAsStream((String)object));
            short s = ((DataInputStream)object).readShort();
            aX = new byte[s];
            for (short s2 = 0; s2 < s; s2 = (short)(s2 + 1)) {
                main.f.aX[s2] = ((DataInputStream)object).readByte();
            }
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    private void o() {
        switch (this.ba) {
            case 0: {
                a.h.a(g, 0);
                a.h.a(g, 0, 0, 240, 320);
                g.drawImage(ay[2], 0, 0, 20);
                main.f.a(new String[]{"\u041f\u043e\u043c\u043e\u0449\u044c ", "\u0421\u0442\u0430\u0442\u0443\u0441 ", "\u0421\u043e\u0432\u0435\u0442\u044b: "}, this.aZ, true, true);
                if (main.f.d(49184)) {
                    switch (this.aZ) {
                        case 0: {
                            a.d.a(false);
                            main.e.b(1);
                            this.ba = 1;
                            break;
                        }
                        case 1: {
                            this.ba = 2;
                        }
                    }
                }
                if (main.f.d(65536)) {
                    k = 5;
                    return;
                }
                if (main.f.d(5140)) {
                    --this.aZ;
                    if (this.aZ >= 0) break;
                    this.aZ = 1;
                    return;
                }
                if (!main.f.d(10560)) break;
                ++this.aZ;
                if (this.aZ <= 1) break;
                this.aZ = 0;
                return;
            }
            case 1: {
                a.h.a(g, 0);
                a.h.a(g, 0, 0, 240, 320);
                g.drawImage(ay[2], 0, 0, 20);
                a.h.a(g, h, ay[0], 213, 298, 27, 22, 0, 0);
                a.h.a(g, ay[3], 221, 303, 17, 15, 17, 0);
                a.d.b(g, "\u0421\u0442\u0430\u0442\u0443\u0441 ", -1, 30 - a.g.b >> 1, 15597476, 6895442, 20);
                a.d.a(g, main.e.y, null, main.e.A, 12, 46, 214, 6);
                a.h.a(g, 12, 222, 214, 68, 6907220, 14593146);
                a.h.a(g, 14, 224, 210, 64, 9600109, 8020827);
                a.d.a(g, main.e.z[a.d.m()], 15597476, 16, 225, 206, 62);
                if (a.d.c() && a.a.b(20)) {
                    a.d.d();
                }
                if (main.f.d(1028)) {
                    a.d.a(false);
                    a.d.j();
                    return;
                }
                if (main.f.d(2304)) {
                    a.d.a(false);
                    a.d.k();
                    return;
                }
                if (!main.f.d(65536)) break;
                a.d.a(false);
                a.d.l();
                main.e.d();
                this.ba = 0;
                return;
            }
            case 2: {
                a.d.a(g, main.e.a, 120, 50, ay[2], null);
                a.d.b(g, "\u0421\u043e\u0432\u0435\u0442\u044b: ", -1, 30 - a.g.b >> 1, 15597476, 6895442, 20);
                if (main.f.d(65536)) {
                    this.ba = 0;
                    a.d.i();
                    return;
                }
                if (main.f.d(5140)) {
                    a.d.g();
                    return;
                }
                if (!main.f.d(10560)) break;
                a.d.h();
            }
        }
    }

    public final void c(int n) {
        main.e.B(n);
        this.j();
        k = 24;
    }

    private void p() {
        int n;
        a.h.a(g, ay[2], 0, 0);
        main.f.a(main.e.y, this.bj, true, true);
        for (n = 1; n < main.e.y.length; ++n) {
            a.h.a(g, at, (240 - a.g.a.stringWidth(main.e.y[n]) >> 1) - 28, 48 + (n - 1) * 24, 12, 17, 12 * (main.e.q(main.e.B[n]) - 1), 0);
        }
        if (main.f.d(49184)) {
            if (main.e.q(main.e.B[this.bj + 1]) == 1) {
                V = main.e.B[this.bj + 1];
            } else if (main.e.q(main.e.B[this.bj + 1]) == 3) {
                V = main.e.B[this.bj + 1];
            } else {
                return;
            }
            U = true;
            this.bj = 0;
            a.d.a(false);
            main.e.d();
            this.c(false);
            this.g(K);
            for (n = 0; n < a.e.length; ++n) {
                a.e[n].a();
            }
            k = 7;
            return;
        }
        if (main.f.d(65536)) {
            this.bj = 0;
            a.d.a(false);
            main.e.d();
            this.c(false);
            this.g(K);
            for (n = 0; n < a.e.length; ++n) {
                a.e[n].a();
            }
            k = 7;
            return;
        }
        if (main.f.d(5140)) {
            --this.bj;
            if (this.bj < 0) {
                this.bj = main.e.y.length - 2;
                return;
            }
        } else if (main.f.d(10560)) {
            ++this.bj;
            if (this.bj > main.e.y.length - 2) {
                this.bj = 0;
            }
        }
    }

    public static void d() {
        aQ = true;
    }

    public final void e() {
        this.c(false);
        try {
            if (this.aj == null) {
                this.aj = Image.createImage((String)"/mapworld.png");
            }
        }
        catch (IOException iOException) {}
        if (aN) {
            this.ab.a("menu", true, 1);
        }
        k = 21;
    }

    public final void f() {
        this.c(true);
        try {
            this.aj = Image.createImage((String)"/mapworld.png");
            this.ak = Image.createImage((String)"/selectmap.png");
            if (ay[0] == null) {
                main.f.a(0, "/splash0.png");
            }
            if (ay[3] == null) {
                main.f.a(3, "/splash3.png");
            }
        }
        catch (IOException iOException) {}
        k = 22;
    }

    private void q() {
        a.h.a(g, this.aj, 0, 0);
        for (int i = 0; i < 9; ++i) {
            if (S[i] <= 0) continue;
            if (S[i] % 2 == 0) {
                a.h.a(g, this.ak, this.bb[i << 1], this.bb[(i << 1) + 1], 41, 44, i * 41, 0);
            }
            switch (S[i]) {
                case 3: 
                case 8: {
                    a.h.a(g, this.ak, this.bb[i << 1] + 10, this.bb[(i << 1) + 1] + 11, 20, 22, 114, 44);
                    break;
                }
                case 4: 
                case 7: {
                    a.h.a(g, this.ak, this.bb[i << 1] + 10, this.bb[(i << 1) + 1] + 11, 20, 22, 134, 44);
                    break;
                }
                case 5: 
                case 6: {
                    a.h.a(g, this.ak, this.bb[i << 1] + 10, this.bb[(i << 1) + 1] + 11, 20, 22, 154, 44);
                }
            }
            if (S[i] <= 1 || S[i] > 9) continue;
            int n = i;
            S[n] = (byte)(S[n] - 1);
            if (S[i] != 1) continue;
            main.f.S[i] = 9;
        }
        a.h.a(g, this.ak, this.bb[this.bc[Q] << 1] + 15, this.bb[(this.bc[Q] << 1) + 1], 11, 11, 103, 44);
        a.h.a(g, this.ak, 71, 282, 103, 22, 0, 44);
        a.h.a(g, ay[0], 0, 320 - ay[0].getHeight());
        a.h.a(g, ay[3], 2, 303, 17, 15, 0, 0);
        a.d.b(g, R[this.bc[Q]], -1, 282 + (22 - a.g.b >> 1), 0xFFFFCD, 4923904, 20);
        if (main.f.d(49184)) {
            if (K == -1) {
                main.e.g = 7;
            }
            if ((K = this.bd[this.bc[Q]]) == 0) {
                main.e.g = 18;
            }
            main.f.S[this.bc[main.f.Q]] = 0;
            k = 2;
            if (this.bc[Q] == 2 && !main.e.W) {
                b.a(5);
                return;
            }
        } else if (main.f.d(1028)) {
            if (Q >= 3 && S[this.bc[Q -= 3]] > 9) {
                Q += 3;
                return;
            }
        } else if (main.f.d(2304)) {
            if (Q <= 5 && S[this.bc[Q += 3]] > 9) {
                Q -= 3;
                return;
            }
        } else if (main.f.d(4112)) {
            if (--Q < 0) {
                Q = 0;
            }
            if (S[this.bc[Q]] > 9) {
                ++Q;
                return;
            }
        } else if (main.f.d(8256)) {
            if (++Q > 8) {
                Q = 8;
            }
            if (S[this.bc[Q]] > 9) {
                --Q;
            }
        }
    }

    public static void a(String string) {
        for (int i = 0; i < be.length; ++i) {
            if (be[i] != null) continue;
            main.f.be[i] = string;
            T = true;
            return;
        }
    }

    public final void a(boolean bl) {
        if (bl) {
            this.bf = new String[4];
            this.bf[0] = "\u0410\u043f\u0442\u0435\u043a\u0430 ";
            this.bf[2] = "\u041a\u0443\u043f\u0438\u0442\u044c ";
            this.bf[3] = "\u041f\u0440\u043e\u0434\u0430\u0442\u044c ";
            this.bf[1] = "   \u0417\u0430\u0434\u0430\u0447\u0430   ";
        } else {
            this.bf = new String[3];
            this.bf[0] = "\u0410\u043f\u0442\u0435\u043a\u0430 ";
            this.bf[1] = "\u041a\u0443\u043f\u0438\u0442\u044c ";
            this.bf[2] = "\u041f\u0440\u043e\u0434\u0430\u0442\u044c ";
        }
        a.d.a(false);
        this.j();
        k = 19;
    }

    private void r() {
        main.f.a(this.bf, this.bj, true, true);
        if (main.f.d(49184)) {
            if (this.bf.length == 3) {
                if (this.bj == 0) {
                    this.bh = 1;
                    main.e.n(13);
                } else if (this.bj == 2) {
                    this.bj = 0;
                    this.bf = null;
                    this.bh = 0;
                    a.d.a(false);
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
                a.d.a(false);
                this.c(11);
            } else {
                this.bh = 2;
                main.e.n(14);
            }
            a.d.a(false);
            return;
        }
        if (main.f.d(65536)) {
            this.bj = 0;
            this.bf = null;
            a.d.a(false);
            this.c(false);
            this.g(K);
            for (int i = 0; i < a.e.length; ++i) {
                a.e[i].a();
            }
            k = 7;
            return;
        }
        if (main.f.d(5140)) {
            --this.bj;
            if (this.bj < 0) {
                this.bj = this.bf.length - 2;
                return;
            }
        } else if (main.f.d(10560)) {
            ++this.bj;
            if (this.bj > this.bf.length - 2) {
                this.bj = 0;
            }
        }
    }

    private void s() {
        a.h.a(g, ay[0], 0, 320 - ay[0].getHeight());
        a.h.a(g, ay[3], 2, 303, 17, 15, 0, 0);
        a.h.a(g, h, ay[0], 213, 298, 27, 22, 0, 0);
        a.h.a(g, ay[3], 221, 303, 17, 15, 17, 0);
        a.d.b(g, this.bf[this.bj + 1], -1, 30 - a.g.b >> 1, 15597476, 6764371, 20);
        a.h.a(g, 80, 290, 78, 21, 7299920, 14658680);
        a.h.a(g, 82, 291, 74, 19, 14658680, 16708041);
        a.h.a(g, this.ar, 82, 292);
        a.h.b(g, as, aG, 102, 297, 7, 7, 0);
        a.d.a(g, main.e.y, null, main.e.z, 12, 56, 214, 6);
        if (L) {
            main.f.g(164, 60);
            return;
        }
        if (this.bp == 1) {
            boolean bl = false;
            a.h.a(g, 32, 130, 176, 60, 6907220, 15580812);
            a.h.a(g, 34, 132, 172, 56, 15580812, 0xFEEFCE);
            g.setColor(13549230);
            g.fillRect(36, 138, 64, 20);
            g.fillRect(101, 138, 101, 20);
            a.h.a(g, au, 146, 129, 11, 11, 22, 0);
            a.h.a(g, au, 146, 155, 11, 11, 33, 0);
            a.d.b(g, "\u0412\u0441\u0435\u0433\u043e ", 36 + (64 - a.g.a.stringWidth("\u0412\u0441\u0435\u0433\u043e ") >> 1), 138 + (20 - a.g.b >> 1), 15597476, 7366729, 20);
            a.d.b(g, String.valueOf(this.bo), 101 + (101 - a.g.a.stringWidth(String.valueOf(this.bo)) >> 1), 138 + (20 - a.g.b >> 1), 15597476, 6895186, 20);
            if (this.bh == 1) {
                a.d.b(g, "\u0412\u0441\u0435\u0433\u043e " + main.e.a(main.e.B[a.d.m()], 8, false) * this.bo + "\u0417\u043e\u043b\u043e\u0442\u0430 ", -1, 168, 15597476, 6895186, 20);
            } else {
                a.d.b(g, "\u0412\u0441\u0435\u0433\u043e " + main.e.a(main.e.B[a.d.m()], 8, false) / 4 * this.bo + "\u0417\u043e\u043b\u043e\u0442\u0430 ", -1, 168, 15597476, 6895186, 20);
            }
            if (main.f.d(65536)) {
                a.d.a(false);
                this.bp = 0;
                return;
            }
            if (main.f.d(49184)) {
                a.d.a(false);
                this.bp = 2;
                return;
            }
            if (main.f.d(6416)) {
                if (this.bo > 1) {
                    --this.bo;
                    return;
                }
            } else if (main.f.d(9284)) {
                if (this.bh == 1) {
                    ++this.bo;
                    return;
                }
                if (this.bo < main.e.a(main.e.B[a.d.m()], 6, false)) {
                    ++this.bo;
                }
            }
            return;
        }
        if (this.bp == 2) {
            int n = 0;
            n = this.bh == 1 ? this.a("\u041f\u043e\u0434\u0442\u0432\u0435\u0440\u0436\u0434\u0430\u0435\u0442\u0435 " + main.e.y[a.d.m()] + "\u0432\u044b\u0431\u043e\u0440? ", "\u0414\u0430 ", "\u041d\u0435\u0442 ") : this.a("\u041f\u043e\u0434\u0442\u0432\u0435\u0440\u0436\u0434\u0430\u0435\u0442\u0435 " + main.e.y[a.d.m()] + "\u0432\u044b\u0431\u043e\u0440? ", "\u0414\u0430 ", "\u041d\u0435\u0442 ");
            if (n == 1) {
                if (this.bh == 1) {
                    if (aG >= main.e.a(main.e.B[a.d.m()], 8, false) * this.bo) {
                        bs = main.e.y[a.d.m()] + "\u0417\u0430\u0445\u043e\u0434\u0438\u0442\u0435 \u0435\u0449\u0435 ";
                        main.e.a(main.e.B[a.d.m()], this.bo);
                        aG -= main.e.a(main.e.B[a.d.m()], 8, false) * this.bo;
                    } else {
                        bs = "\u041d\u0435\u0434\u043e\u0441\u0442\u0430\u0442\u043e\u0447\u043d\u043e \u0434\u0435\u043d\u0435\u0433 ";
                    }
                } else {
                    bs = main.e.y[a.d.m()] + "\u041f\u0440\u043e\u0434\u0430\u043d\u043e. ";
                    main.e.a(main.e.B[a.d.m()], -this.bo);
                    if (main.e.B[a.d.m()] == main.e.s && main.e.a(main.e.B[a.d.m()], 6, false) == 0) {
                        main.e.s = -1;
                    }
                    if (main.e.B[a.d.m()] == main.e.t && main.e.a(main.e.B[a.d.m()], 6, false) == 0) {
                        main.e.t = -1;
                    }
                    main.f.a(main.e.a(main.e.B[a.d.m()], 8, false) / 4 * this.bo);
                    main.e.d();
                    main.e.n(14);
                }
                a.d.a(false);
                L = true;
                this.bp = 0;
                return;
            }
            if (n == 2) {
                this.bp = 0;
            }
            return;
        }
        a.h.a(g, 12, 212, 214, 68, 6907220, 14593146);
        a.h.a(g, 14, 214, 210, 64, 9600109, 8020827);
        a.d.a(g, main.e.h(main.e.B[a.d.m()]), 15597476, 16, 215, 206, 62);
        if (a.d.c() && a.a.b(20)) {
            a.d.d();
        }
        if (main.f.d(65536)) {
            this.bo = 0;
            this.bh = 0;
            a.d.l();
            main.e.d();
            return;
        }
        if (main.f.d(49184)) {
            this.bo = 1;
            if (this.bh != 2 || main.e.B[a.d.m()] > 0) {
                this.bp = 1;
                return;
            }
        } else {
            if (main.f.d(1028)) {
                a.d.a(false);
                a.d.j();
                return;
            }
            if (main.f.d(2304)) {
                a.d.a(false);
                a.d.k();
            }
        }
    }

    public final void b(boolean bl) {
        if (bl) {
            this.bg = new String[5];
            this.bg[0] = "\u041a\u0443\u0437\u043d\u0438\u0446\u0430 ";
            this.bg[2] = "\u041a\u043e\u0432\u043a\u0430 ";
            this.bg[3] = "\u041a\u0443\u043f\u0438\u0442\u044c ";
            this.bg[4] = "\u041f\u0440\u043e\u0434\u0430\u0442\u044c ";
            this.bg[1] = "   \u0417\u0430\u0434\u0430\u0447\u0430   ";
        } else {
            this.bg = new String[4];
            this.bg[0] = "\u041a\u0443\u0437\u043d\u0438\u0446\u0430 ";
            this.bg[1] = "\u041a\u043e\u0432\u043a\u0430 ";
            this.bg[2] = "\u041a\u0443\u043f\u0438\u0442\u044c ";
            this.bg[3] = "\u041f\u0440\u043e\u0434\u0430\u0442\u044c ";
        }
        a.d.a(false);
        this.j();
        k = 20;
    }

    private void t() {
        main.f.a(this.bg, this.bj, true, true);
        if (main.f.d(49184)) {
            if (this.bg.length == 4) {
                this.bh = this.bj + 1 + 100;
                if (this.bj == 3) {
                    this.bg = null;
                    this.bj = 0;
                    this.bh = 0;
                    a.d.a(false);
                    this.c(13);
                    return;
                }
            } else {
                if (this.bj == 0) {
                    this.bg = null;
                    this.bj = 0;
                    this.bh = 0;
                    a.d.a(false);
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
            if (main.f.d(65536)) {
                this.bg = null;
                this.bj = 0;
                a.d.a(false);
                this.c(false);
                this.g(K);
                for (int i = 0; i < a.e.length; ++i) {
                    a.e[i].a();
                }
                k = 7;
                return;
            }
            if (main.f.d(5140)) {
                --this.bj;
                if (this.bj < 0) {
                    this.bj = this.bg.length - 2;
                    return;
                }
            } else if (main.f.d(10560)) {
                ++this.bj;
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
                a.d.a(false);
                return;
            }
        } else if (this.bj == 2) {
            main.e.n(12);
            this.bh -= 100;
            a.d.a(false);
            return;
        }
        main.f.a(new String[]{this.bg[this.bj + 1], "\u041e\u0440\u0443\u0436\u0438\u0435 ", "\u0428\u043b\u0435\u043c ", "\u0411\u0440\u043e\u043d\u044f ", "\u0410\u043c\u0443\u043b\u0435\u0442 "}, this.bo, true, true);
        for (int i = 0; i < 5; ++i) {
            a.h.a(g, aw, 64, 49 + i * 24, 16, 15, i + 1 << 4, 0);
        }
        if (main.f.d(65536)) {
            this.bh = 0;
            this.bo = 0;
        } else if (main.f.d(49184)) {
            main.e.n(this.bo + 5);
            this.bh -= 100;
            a.d.a(false);
        }
        if (main.f.d(5140)) {
            --this.bo;
            if (this.bo < 0) {
                this.bo = 3;
                return;
            }
        } else if (main.f.d(10560)) {
            ++this.bo;
            if (this.bo > 3) {
                this.bo = 0;
            }
        }
    }

    private void v() {
        a.h.a(g, ay[0], 0, 320 - ay[0].getHeight());
        a.h.a(g, ay[3], 2, 303, 17, 15, 0, 0);
        a.h.a(g, h, ay[0], 213, 298, 27, 22, 0, 0);
        a.h.a(g, ay[3], 221, 303, 17, 15, 17, 0);
        a.d.b(g, this.bg[this.bj + 1], -1, 30 - a.g.b >> 1, 15597476, 6764371, 20);
        a.h.a(g, 80, 290, 78, 21, 7299920, 14658680);
        a.h.a(g, 82, 291, 74, 19, 14658680, 16708041);
        a.h.a(g, this.ar, 82, 292);
        a.h.b(g, as, aG, 102, 297, 7, 7, 0);
        a.d.a(g, main.e.y, null, main.e.z, 12, 56, 214, 6);
        a.h.a(g, 12, 212, 214, 68, 6907220, 14593146);
        a.h.a(g, 14, 214, 210, 64, 9600109, 8020827);
        a.d.a(g, main.e.h(main.e.B[a.d.m()]), 15597476, 16, 215, 206, 62);
        if (a.d.c() && a.a.b(20)) {
            a.d.d();
        }
        if (main.f.d(65536)) {
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
            a.d.l();
            main.e.d();
            return;
        }
        if (main.f.d(49184)) {
            if (main.e.B[a.d.m()] >= 0) {
                this.bh += 10;
                a.d.a(false);
                return;
            }
        } else {
            if (main.f.d(1028)) {
                a.d.a(false);
                a.d.j();
                return;
            }
            if (main.f.d(2304)) {
                a.d.a(false);
                a.d.k();
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void w() {
        a.h.a(g, ay[0], 0, 320 - ay[0].getHeight());
        a.h.a(g, ay[3], 2, 303, 17, 15, 0, 0);
        a.h.a(g, h, ay[0], 213, 298, 27, 22, 0, 0);
        a.h.a(g, ay[3], 221, 303, 17, 15, 17, 0);
        a.d.b(g, main.e.y[a.d.m()], -1, 5 + (20 - a.g.b >> 1), 15597476, 6362880, 20);
        a.h.a(g, 12, 46, 214, 144, 6907220, 14593146);
        a.h.a(g, 14, 48, 210, 140, 9600109, 8020827);
        a.h.a(g, 80, 290, 78, 21, 7299920, 14658680);
        a.h.a(g, 82, 291, 74, 19, 14658680, 16708041);
        a.h.a(g, this.ar, 82, 292);
        a.h.b(g, as, aG, 102, 297, 7, 7, 0);
        if (L) {
            main.f.g(200, 60);
            return;
        }
        if (this.bp == 1) {
            int n = this.a("\u041f\u043e\u0434\u0442\u0432\u0435\u0440\u0436\u0434\u0430\u0435\u0442\u0435 " + main.e.y[a.d.m()] + "\u0432\u044b\u0431\u043e\u0440? ", "\u0414\u0430 ", "\u041d\u0435\u0442 ");
            if (n != 1) {
                if (n != 2) return;
                this.bp = 0;
                return;
            }
            if (aG >= main.e.l(main.e.B[a.d.m()])) {
                bs = main.e.y[a.d.m()] + "\u0423\u0441\u043f\u0435\u0445 \u043e\u0431\u043d\u043e\u0432\u043b\u0435\u043d\u0438\u044f. ";
                aG -= main.e.l(main.e.B[a.d.m()]);
                main.e.k(main.e.B[a.d.m()]);
                if (main.e.a(main.e.B[a.d.m()], 6, true) >= 5) {
                    main.e.a(11);
                }
                if (main.e.a(main.e.B[a.d.m()], 6, true) >= 9) {
                    main.e.a(12);
                }
                if (main.e.a(main.e.B[a.d.m()], 6, true) >= 15) {
                    main.e.a(13);
                }
                this.bp = 0;
            } else {
                bs = "\u041d\u0435\u0443\u0434\u0430\u0447\u0430, \u043d\u0435\u0445\u0432\u0430\u0442\u043a\u0430 \u0434\u0435\u043d\u0435\u0433 ";
                this.bp = 2;
            }
            a.d.a(false);
            L = true;
            return;
        }
        if (this.bp == 2) {
            b.a(0);
            this.bp = 0;
            return;
        }
        a.d.a(g, "\u0421\u0442\u043e\u0438\u043c\u043e\u0441\u0442\u044c \u043a\u043e\u0432\u043a\u0438  " + main.e.l(main.e.B[a.d.m()]) + " \u0417\u043e\u043b\u043e\u0442\u044b\u0445 \u043c\u043e\u043d\u0435\u0442 " + main.e.h(main.e.B[a.d.m()]), 15597476, 16, 49, 206, 138);
        if (main.f.d(65536)) {
            a.d.a(false);
            if (k == 20) {
                this.bh -= 10;
                return;
            }
            this.bk = (byte)(this.bk - 10);
            return;
        }
        if (!main.f.d(49184)) return;
        if (a.d.c()) {
            if (a.d.d()) return;
            a.d.a(false);
            this.bp = 1;
            return;
        }
        a.d.b();
    }

    private void x() {
        a.h.a(g, ay[0], 0, 320 - ay[0].getHeight());
        a.h.a(g, ay[3], 2, 303, 17, 15, 0, 0);
        a.h.a(g, h, ay[0], 213, 298, 27, 22, 0, 0);
        a.h.a(g, ay[3], 221, 303, 17, 15, 17, 0);
        a.d.b(g, this.bg[this.bj + 1], -1, 30 - a.g.b >> 1, 15597476, 6764371, 20);
        a.h.a(g, 80, 290, 78, 21, 7299920, 14658680);
        a.h.a(g, 82, 291, 74, 19, 14658680, 16708041);
        a.h.a(g, this.ar, 82, 292);
        a.h.b(g, as, aG, 102, 297, 7, 7, 0);
        if (L) {
            main.f.g(200, 60);
            if (!L) {
                a.d.a(false);
                this.bh -= 10;
            }
            return;
        }
        int n = this.a(main.e.a(main.e.B[a.d.m()], 8, false) + "\u041a\u0443\u043f\u0438\u0442\u044c " + main.e.v[main.e.B[a.d.m()]] + "? ", "\u0414\u0430 ", "\u041d\u0435\u0442 ");
        if (n == 1) {
            if (aG >= main.e.a(main.e.B[a.d.m()], 8, false)) {
                aG -= main.e.a(main.e.B[a.d.m()], 8, false);
                main.e.a(main.e.B[a.d.m()], 1);
                bs = "\u0417\u0430\u0445\u043e\u0434\u0438\u0442\u0435 \u0435\u0449\u0435 ";
            } else {
                bs = "\u041d\u0435\u0434\u043e\u0441\u0442\u0430\u0442\u043e\u0447\u043d\u043e \u0434\u0435\u043d\u0435\u0433 ";
            }
            L = true;
            a.d.a(false);
            return;
        }
        if (n == 2) {
            a.d.a(false);
            this.bh -= 10;
        }
    }

    private void y() {
        a.h.a(g, ay[0], 0, 320 - ay[0].getHeight());
        a.h.a(g, ay[3], 2, 303, 17, 15, 0, 0);
        a.h.a(g, h, ay[0], 213, 298, 27, 22, 0, 0);
        a.h.a(g, ay[3], 221, 303, 17, 15, 17, 0);
        a.d.b(g, this.bg[this.bj + 1], -1, 30 - a.g.b >> 1, 15597476, 6764371, 20);
        a.h.a(g, 80, 290, 78, 21, 7299920, 14658680);
        a.h.a(g, 82, 291, 74, 19, 14658680, 16708041);
        a.h.a(g, this.ar, 82, 292);
        a.h.b(g, as, aG, 102, 297, 7, 7, 0);
        if (L) {
            main.f.g(164, 60);
            return;
        }
        int n = this.a(main.e.a(main.e.B[a.d.m()], 8, false) / 2 + "\u041f\u0440\u043e\u0434\u0430\u0442\u044c " + main.e.v[main.e.B[a.d.m()]] + "? ", "\u0414\u0430 ", "\u041d\u0435\u0442 ");
        if (n == 1) {
            if (main.e.B[a.d.m()] == main.e.X[1]) {
                bs = "\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u0443\u0435\u0442\u0441\u044f ";
                a.d.a(false);
                L = true;
                return;
            }
            if (main.e.a(main.e.B[a.d.m()], 8, false) == 0) {
                bs = "\u042d\u0442\u043e\u0442 \u043f\u0443\u043d\u043a\u0442 \u043d\u0435\u043b\u044c\u0437\u044f \u043f\u0440\u043e\u0434\u0430\u0442\u044c ";
                a.d.a(false);
                L = true;
                return;
            }
            main.f.a(main.e.a(main.e.B[a.d.m()], 8, false) / 2);
            main.e.j(main.e.B[a.d.m()]);
            a.d.a(false);
            this.bh -= 10;
            main.e.d();
            main.e.n(this.bo + 5);
            return;
        }
        if (n == 2) {
            a.d.a(false);
            this.bh -= 10;
        }
    }

    private void z() {
        main.f.a(new String[]{"\u041a\u043e\u0432\u043a\u0430 ", "\u041e\u0440\u0443\u0436\u0438\u0435 ", "\u0428\u043b\u0435\u043c ", "\u0411\u0440\u043e\u043d\u044f ", "\u0410\u043c\u0443\u043b\u0435\u0442 "}, this.bo, true, true);
        for (int i = 0; i < 5; ++i) {
            a.h.a(g, aw, 64, 49 + i * 24, 16, 15, i + 1 << 4, 0);
        }
        if (main.f.d(65536)) {
            this.bh = 0;
            this.bo = 0;
            a.d.a(false);
        } else if (main.f.d(49184)) {
            main.e.n(this.bo + 5);
            this.bk = (byte)(this.bk - 100);
            a.d.a(false);
        }
        if (main.f.d(5140)) {
            --this.bo;
            if (this.bo < 0) {
                this.bo = 3;
                return;
            }
        } else if (main.f.d(10560)) {
            ++this.bo;
            if (this.bo > 3) {
                this.bo = 0;
            }
        }
    }

    private void A() {
        a.h.a(g, ay[0], 0, 320 - ay[0].getHeight());
        a.h.a(g, ay[3], 2, 303, 17, 15, 0, 0);
        a.h.a(g, h, ay[0], 213, 298, 27, 22, 0, 0);
        a.h.a(g, ay[3], 221, 303, 17, 15, 17, 0);
        a.d.b(g, "\u0420\u0435\u043a\u0432\u0438\u0437\u0438\u0442 ", -1, 30 - a.g.b >> 1, 15597476, 6764371, 20);
        a.h.a(g, 80, 290, 78, 21, 7299920, 14658680);
        a.h.a(g, 82, 291, 74, 19, 14658680, 16708041);
        a.h.a(g, this.ar, 84, 292);
        a.h.b(g, as, aG, 102, 297, 7, 7, 0);
        a.d.a(g, new String[]{"\u041b\u043e\u0442\u0435\u0440\u0435\u044f ", "\u0422\u0435\u043b\u0435\u043f\u043e\u0440\u0442 ", "\u0421\u0442\u0430\u043b\u044c\u043d\u044b\u0435 \u043d\u0435\u0431\u0435\u0441\u0430 ", "\u041b\u0435\u0442\u0430\u044e\u0449\u0438\u0439 \u043c\u0435\u0447 ", "\u0421\u0438\u043b\u0430 \u0422\u0438\u0442\u0430\u043d\u0430 ", "\u041d\u0435\u0431\u0435\u0441\u043d\u0430\u044f \u0431\u0440\u043e\u043d\u044f ", "\u0417\u0435\u043b\u044c\u0435 \u043f\u0440\u043e\u0447\u043d\u043e\u0441\u0442\u0438 "}, this.bl, null, 12, 66, 214, 6);
        if (L) {
            main.f.g(200, 60);
            return;
        }
        if (this.bn == 1) {
            boolean bl = false;
            bl = false;
            a.h.a(g, 32, 130, 176, 60, 6907220, 15580812);
            a.h.a(g, 34, 132, 172, 56, 15580812, 0xFEEFCE);
            g.setColor(13549230);
            g.fillRect(36, 138, 64, 20);
            g.fillRect(101, 138, 101, 20);
            a.h.a(g, au, 146, 129, 11, 11, 22, 0);
            a.h.a(g, au, 146, 155, 11, 11, 33, 0);
            a.d.b(g, "\u0412\u0441\u0435\u0433\u043e ", 36 + (64 - a.g.a.stringWidth("\u0412\u0441\u0435\u0433\u043e ") >> 1), 138 + (20 - a.g.b >> 1), 15597476, 7366729, 20);
            a.d.b(g, String.valueOf(this.bo), 101 + (101 - a.g.a.stringWidth(String.valueOf(this.bo)) >> 1), 138 + (20 - a.g.b >> 1), 15597476, 6895186, 20);
            a.d.b(g, "\u0412\u0441\u0435\u0433\u043e " + this.bl[a.d.m()] * this.bo + "\u0417\u043e\u043b\u043e\u0442\u0430 ", -1, 168, 15597476, 6895186, 20);
            if (main.f.d(65536)) {
                a.d.a(false);
                this.bn = 0;
                return;
            }
            if (main.f.d(49184)) {
                a.d.a(false);
                this.bn = (byte)2;
                return;
            }
            if (main.f.d(6416)) {
                if (this.bo > 1) {
                    --this.bo;
                    return;
                }
            } else if (main.f.d(9284) && a.d.m() != 0 && a.d.m() != 2 && a.d.m() != 3) {
                ++this.bo;
            }
            return;
        }
        if (this.bn == 2) {
            int n = this.a("\u041f\u043e\u0442\u0440\u0430\u0442\u0438\u0442\u044c " + this.bl[a.d.m()] * this.bo + "\u0437\u043e\u043b\u043e\u0442\u0430? ", "\u0414\u0430 ", "\u041d\u0435\u0442 ");
            if (n == 1) {
                if (aG >= this.bl[a.d.m()]) {
                    aG -= this.bl[a.d.m()] * this.bo;
                    bs = "\u0417\u0430\u0445\u043e\u0434\u0438\u0442\u0435 \u0435\u0449\u0435 ";
                    switch (a.d.m()) {
                        case 0: {
                            n = a.a.a(1000);
                            if (n < 911) {
                                bs = "\u041f\u043e\u0437\u0434\u0440\u0430\u0432\u043b\u044f\u0435\u043c, \u0447\u0438\u0442\u0435\u0440, \u0441 \u043f\u0440\u0438\u0437\u043e\u043c 500 \u0437\u043e\u043b\u043e\u0442\u044b\u0445 ";
                                main.f.a(500);
                                break;
                            }
                            if (n < 961) {
                                bs = "\u041f\u043e\u0437\u0434\u0440\u0430\u0432\u043b\u044f\u0435\u043c, \u0447\u0438\u0442\u0435\u0440, \u0441 \u043f\u0440\u0438\u0437\u043e\u043c 1000 \u0437\u043e\u043b\u043e\u0442\u044b\u0445 ";
                                main.f.a(1000);
                                break;
                            }
                            if (n < 991) {
                                bs = "\u041f\u043e\u0437\u0434\u0440\u0430\u0432\u043b\u044f\u0435\u043c, \u0447\u0438\u0442\u0435\u0440, \u0441 \u043f\u0440\u0438\u0437\u043e\u043c 2000 \u0437\u043e\u043b\u043e\u0442\u044b\u0445 ";
                                main.f.a(2000);
                                break;
                            }
                            if (n < 996) {
                                bs = "\u041f\u043e\u0437\u0434\u0440\u0430\u0432\u043b\u044f\u0435\u043c, \u0447\u0438\u0442\u0435\u0440, \u0441 \u043f\u0440\u0438\u0437\u043e\u043c 10000 \u0437\u043e\u043b\u043e\u0442\u044b\u0445 ";
                                main.f.a(10000);
                                break;
                            }
                            if (n < 999) {
                                bs = "\u041f\u043e\u0437\u0434\u0440\u0430\u0432\u043b\u044f\u0435\u043c, \u0447\u0438\u0442\u0435\u0440, \u0441 \u043f\u0440\u0438\u0437\u043e\u043c 100 000 \u0437\u043e\u043b\u043e\u0442\u044b\u0445 ";
                                main.f.a(100000);
                                break;
                            }
                            if (n >= 1000) break;
                            bs = "\u041f\u043e\u0437\u0434\u0440\u0430\u0432\u043b\u044f\u0435\u043c, \u0447\u0438\u0442\u0435\u0440, \u0441 \u043f\u0440\u0438\u0437\u043e\u043c 5000000 \u0437\u043e\u043b\u043e\u0442\u044b\u0445 ";
                            main.f.a(5000000);
                            break;
                        }
                        case 1: {
                            main.e.a(53, this.bo);
                            break;
                        }
                        case 2: {
                            main.e.c(1);
                            break;
                        }
                        case 3: {
                            main.e.c(2);
                            break;
                        }
                        case 4: {
                            main.e.a(50, this.bo);
                            break;
                        }
                        case 5: {
                            main.e.a(51, this.bo);
                            break;
                        }
                        case 6: {
                            main.e.a(52, this.bo);
                        }
                    }
                    this.bo = 0;
                    this.bn = 0;
                } else {
                    bs = "\u0414\u0435\u043d\u0435\u0433 \u043d\u0435\u0434\u043e\u0441\u0442\u0430\u0442\u043e\u0447\u043d\u043e ";
                    this.bn = (byte)3;
                }
                a.d.a(false);
                L = true;
                return;
            }
            if (n == 2) {
                this.bo = 0;
                this.bn = 0;
                a.d.a(false);
            }
            return;
        }
        if (this.bn == 3) {
            b.a(0);
            this.bo = 0;
            this.bn = 0;
            a.d.a(false);
            return;
        }
        a.h.a(g, 12, 222, 214, 68, 6907220, 14593146);
        a.h.a(g, 14, 224, 210, 64, 9600109, 8020827);
        a.d.a(g, this.bm[a.d.m()], 15597476, 16, 225, 208, 62);
        if (a.d.c() && a.a.b(20)) {
            a.d.d();
        }
        if (main.f.d(65536)) {
            a.d.a(false);
            a.d.l();
            this.bh = 0;
            this.bo = 0;
            return;
        }
        if (main.f.d(49184)) {
            if (main.e.u[1] && a.d.m() == 2 || main.e.u[2] && a.d.m() == 3) {
                bs = "\u042d\u0442\u043e\u0442 \u043d\u0430\u0432\u044b\u043a \u0443\u0436\u0435 \u0438\u0437\u0443\u0447\u0435\u043d ";
                a.d.a(false);
                L = true;
            } else {
                this.bo = 1;
                this.bn = 1;
            }
            a.d.a(false);
            return;
        }
        if (main.f.d(1028)) {
            a.d.a(false);
            a.d.j();
            return;
        }
        if (main.f.d(2304)) {
            a.d.a(false);
            a.d.k();
        }
    }

    private void B() {
        this.D();
        switch (this.bj) {
            case 1: {
                int n;
                f f2 = this;
                g.setColor(6831623);
                g.fillRect(43, 86, 56, 29);
                a.h.a(g, f2.ap, 43, 55);
                a.h.a(g, 44, 146, 150, 24, 7299920, 14658680);
                g.setColor(16708041);
                g.fillRect(47, 148, 50, 20);
                g.fillRect(99, 148, 92, 20);
                g.setColor(0);
                g.fillRect(43, 181, 152, 84);
                for (n = 0; n < 4; ++n) {
                    a.h.a(g, 44, 184 + n * 21, 150, 15, 7096386, 6110524);
                }
                a.h.a(g, 80, 276, 78, 21, 7299920, 14658680);
                a.h.a(g, 82, 277, 74, 19, 14658680, 16708041);
                a.h.a(g, f2.ar, 84, 278);
                a.h.b(g, as, aG, 102, 283, 7, 7, 0);
                a.h.a(g, f2.am, 103, 80, 25, 13, 0, 0);
                a.h.a(g, 135, 81, 61, 4, 2497292, 5252865);
                a.h.a(g, 135, 80, 61 * main.e.M / main.e.h(), 6, 2497292, 16364836);
                a.h.a(g, 136, 81, 59 * main.e.M / main.e.h(), 4, 16364836, 16375322);
                a.h.b(g, as, main.e.M, 162, 87, 7, 7, 1);
                a.h.a(g, as, 162, 87, 7, 7, 70, 0);
                a.h.b(g, as, main.e.h(), 169, 87, 7, 7, 0);
                a.h.a(g, f2.am, 103, 100, 25, 13, 0, 13);
                a.h.a(g, 135, 101, 61, 4, 2497292, 5252865);
                a.h.a(g, 135, 100, 61 * main.e.L / main.e.i(), 6, 2497292, 33254);
                a.h.a(g, 136, 101, 59 * main.e.L / main.e.i(), 4, 33254, 5022438);
                a.h.b(g, as, main.e.L, 162, 107, 7, 7, 1);
                a.h.a(g, as, 162, 107, 7, 7, 70, 0);
                a.h.b(g, as, main.e.i(), 169, 107, 7, 7, 0);
                a.h.a(g, f2.am, 103, 120, 25, 13, 0, 104);
                a.h.a(g, 135, 121, 61, 4, 2497292, 5252865);
                a.h.a(g, 135, 120, 61 * main.e.J / main.e.p(), 6, 2497292, 44836);
                a.h.a(g, 136, 121, 59 * main.e.J / main.e.p(), 4, 44836, 59697);
                a.h.b(g, as, main.e.J, 162, 127, 7, 7, 1);
                a.h.a(g, as, 162, 127, 7, 7, 70, 0);
                a.h.b(g, as, main.e.p(), 169, 127, 7, 7, 0);
                a.h.a(g, f2.am, 49, 121, 25, 13, 0, 26);
                a.h.b(g, as, main.e.K, 83, 125, 7, 7, 0);
                a.h.a(g, f2.am, 59, 152, 25, 13, 0, 39);
                if (main.e.X[0] > 0) {
                    a.d.b(g, main.e.h[main.e.X[0] * 3], 143, 146 + (24 - a.g.b >> 1), 15597476, 7085131, 17);
                } else {
                    a.d.b(g, "\u041d\u0430\u0436\u043c\u0438\u0442\u0435 5 ", 143, 146 + (24 - a.g.b >> 1), 15597476, 7085131, 17);
                }
                a.h.a(g, f2.am, 49, 185, 25, 13, 0, 52);
                a.h.b(g, as, main.e.k(), 103, 188, 7, 7, 0);
                a.h.a(g, f2.am, 49, 206, 25, 13, 0, 65);
                a.h.b(g, as, main.e.m(), 103, 209, 7, 7, 0);
                a.h.a(g, f2.am, 49, 227, 25, 13, 0, 78);
                a.h.b(g, as, main.e.n(), 103, 230, 7, 7, 0);
                a.h.a(g, f2.am, 49, 248, 25, 13, 0, 91);
                a.h.b(g, as, main.e.o(), 103, 251, 7, 7, 0);
                if (!main.f.d(49184)) break;
                a.d.a(false);
                main.e.b(0);
                f2.bh = 3;
                break;
            }
            case 2: {
                int n;
                f f2 = this;
                main.f.a(new String[]{"", "\u041e\u0440\u0443\u0436\u0438\u0435 ", "\u0428\u043b\u0435\u043c ", "\u0411\u0440\u043e\u043d\u044f ", "\u0410\u043c\u0443\u043b\u0435\u0442 "}, f2.bo, true, true);
                for (n = 0; n < 5; ++n) {
                    a.h.a(g, aw, 64, 49 + n * 24, 16, 15, n + 1 << 4, 0);
                }
                if (main.f.d(65536)) {
                    f2.bh = 0;
                    f2.bo = 0;
                } else if (main.f.d(49184)) {
                    main.e.n(f2.bo + 5);
                    f2.bh = 6;
                }
                if (main.f.d(5140)) {
                    --f2.bo;
                    if (f2.bo >= 0) break;
                    f2.bo = 3;
                    break;
                }
                if (!main.f.d(10560)) break;
                ++f2.bo;
                if (f2.bo <= 3) break;
                f2.bo = 0;
                break;
            }
            case 3: {
                f f2 = this;
                main.f.a(new String[]{"", "\u0412\u0435\u0449\u0438 ", "\u041f\u043e\u043c\u043e\u0449\u044c ", "\u041c\u0430\u0442\u0435\u0440\u0438\u0430\u043b "}, f2.bo, true, true);
                if (main.f.d(65536)) {
                    f2.bh = 0;
                    f2.bo = 0;
                } else if (main.f.d(49184)) {
                    f2.bh = 7;
                    main.e.n(f2.bo + 9);
                }
                if (main.f.d(5140)) {
                    --f2.bo;
                    if (f2.bo >= 0) break;
                    f2.bo = 2;
                    break;
                }
                if (!main.f.d(10560)) break;
                ++f2.bo;
                if (f2.bo <= 2) break;
                f2.bo = 0;
                break;
            }
            case 4: {
                int n;
                f f2 = this;
                a.h.a(g, ay[0], 0, 320 - ay[0].getHeight());
                a.h.a(g, ay[3], 2, 303, 17, 15, 0, 0);
                a.h.a(g, h, ay[0], 213, 298, 27, 22, 0, 0);
                a.h.a(g, ay[3], 221, 303, 17, 15, 17, 0);
                a.d.a(g, main.e.y, null, null, 12, 56, 210, 4);
                a.h.a(g, 12, 198, 210, 68, 6907220, 14593146);
                a.h.a(g, 14, 200, 206, 64, 9600109, 8020827);
                if (L) {
                    n = f2.a("\u0412\u044b\u0431\u0435\u0440\u0438\u0442\u0435 \u043a\u043b\u0430\u0432\u0438\u0448\u0443 \u0434\u043b\u044f \u0431\u044b\u0441\u0442\u0440\u043e\u0433\u043e \u0434\u043e\u0441\u0442\u0443\u043f\u0430", "7 ", "9 ");
                    if (n == 1) {
                        main.e.q = main.e.B[a.d.m()];
                        if (main.e.q == main.e.r) {
                            main.e.r = -1;
                            X = Y;
                            Y = 0;
                        }
                        a.d.a(false);
                        L = false;
                        break;
                    }
                    if (n != 2) break;
                    main.e.r = main.e.B[a.d.m()];
                    if (main.e.q == main.e.r) {
                        main.e.q = -1;
                        Y = X;
                        X = 0;
                    }
                    a.d.a(false);
                    L = false;
                    break;
                }
                if (main.e.B[a.d.m()] < 0) {
                    a.d.a(g, "\u041d\u0430\u0432\u044b\u043a\u0438 \u043d\u0435 \u0438\u0437\u0443\u0447\u0435\u043d\u044b ", 15597476, 16, 201, 206, 62);
                } else {
                    a.d.a(g, main.e.p[main.e.B[a.d.m()]], 15597476, 16, 201, 206, 62);
                }
                if (a.d.c() && a.a.b(20)) {
                    a.d.d();
                }
                if (main.f.d(65536)) {
                    a.d.a(false);
                    a.d.l();
                    f2.bh = 0;
                    break;
                }
                if (main.f.d(49184)) {
                    if (main.e.B[a.d.m()] >= 0) {
                        L = true;
                    }
                    a.d.a(false);
                    break;
                }
                if (main.f.d(1028)) {
                    a.d.a(false);
                    a.d.j();
                    break;
                }
                if (!main.f.d(2304)) break;
                a.d.a(false);
                a.d.k();
                break;
            }
            case 5: {
                int n;
                f f2 = this;
                if (!main.e.i(54)) {
                    a.d.b(g, "\u041d\u0430\u0432\u044b\u043a\u0438 \u0441\u0438\u043d\u0442\u0435\u0437\u0430 \u043d\u0435\u0434\u043e\u0441\u0442\u0443\u043f\u043d\u044b ", -1, 320 - a.g.b >> 1, 15597476, 6764371, 20);
                    break;
                }
                main.f.a(f2.br, f2.bo, true, true);
                for (n = 0; n < 5; ++n) {
                    a.h.a(g, aw, 64, 49 + n * 24, 16, 15, n << 4, 0);
                }
                if (main.f.d(65536)) {
                    f2.bh = 0;
                    f2.bo = 0;
                } else if (main.f.d(49184)) {
                    main.e.n(f2.bo);
                    f2.bh = 4;
                }
                if (main.f.d(5140)) {
                    --f2.bo;
                    if (f2.bo >= 0) break;
                    f2.bo = 4;
                    break;
                }
                if (!main.f.d(10560)) break;
                ++f2.bo;
                if (f2.bo <= 4) break;
                f2.bo = 0;
                break;
            }
            case 6: {
                f f2 = this;
                a.h.a(g, ay[0], 0, 320 - ay[0].getHeight());
                a.h.a(g, ay[3], 2, 303, 17, 15, 0, 0);
                a.h.a(g, h, ay[0], 213, 298, 27, 22, 0, 0);
                a.h.a(g, ay[3], 221, 303, 17, 15, 17, 0);
                a.h.a(g, 12, 46, 214, 24, 7299920, 14658680);
                g.setColor(16708041);
                g.fillRect(15, 48, 208, 20);
                a.d.b(g, "\u0421\u043f\u0438\u0441\u043e\u043a \u0437\u0430\u0434\u0430\u0447 ", -1, 46 + (24 - a.g.b >> 1), 15597476, 7085131, 20);
                a.d.a(g, main.e.y, null, null, 12, 71, 214, 7);
                if (L) {
                    main.f.g(176, 120);
                    break;
                }
                if (main.f.d(65536)) {
                    a.d.a(false);
                    a.d.l();
                    f2.bh = 0;
                    break;
                }
                if (main.f.d(49184) && main.e.B[a.d.m()] >= 0) {
                    bs = main.e.D(main.e.B[a.d.m()]);
                    L = true;
                    a.d.a(false);
                    break;
                }
                if (main.f.d(1028)) {
                    a.d.a(false);
                    a.d.j();
                    break;
                }
                if (!main.f.d(2304)) break;
                a.d.a(false);
                a.d.k();
                break;
            }
            case 0: {
                f f2 = this;
                main.f.a(new String[]{"", "\u041c\u0430\u0433\u0430\u0437\u0438\u043d ", "\u041a\u043e\u0432\u043a\u0430 ", "\u0414\u0436\u0435\u043a \u041f\u043e\u0442 ", "\u0423\u0434\u0430\u0447\u0430 ", "\u0421\u0442\u0430\u0442\u0443\u0441 ", "\u041a\u0440\u0438\u0442 "}, f2.bo, true, true);
                if (main.f.d(65536)) {
                    f2.bh = 0;
                    f2.bo = 0;
                } else if (main.f.d(49184)) {
                    switch (f2.bo) {
                        case 0: {
                            f2.bh = 8;
                            break;
                        }
                        case 1: {
                            f2.bh = 9;
                            f2.bk = (byte)101;
                            f2.bo = 0;
                            break;
                        }
                        case 2: {
                            b.a(0);
                            break;
                        }
                        case 3: {
                            b.a(1);
                            break;
                        }
                        case 4: {
                            b.a(2);
                            break;
                        }
                        case 5: {
                            b.a(4);
                        }
                    }
                }
                if (main.f.d(5140)) {
                    --f2.bo;
                    if (f2.bo >= 0) break;
                    f2.bo = 5;
                    break;
                }
                if (!main.f.d(10560)) break;
                ++f2.bo;
                if (f2.bo <= 5) break;
                f2.bo = 0;
            }
        }
        if (L) {
            return;
        }
        if (main.f.d(65536)) {
            this.bj = 0;
            this.bo = 0;
            a.d.l();
            a.d.a(false);
            this.c(false);
            this.g(K);
            for (int i = 0; i < a.e.length; ++i) {
                a.e[i].a();
            }
            k = 7;
            return;
        }
        if (main.f.d(4112)) {
            this.bh = 1;
            f = 0;
            this.bo = 0;
            a.d.l();
            a.d.a(false);
            return;
        }
        if (main.f.d(8256)) {
            this.bh = 2;
            f = 0;
            this.bo = 0;
            a.d.a(false);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void C() {
        a.h.a(g, ay[0], 0, 320 - ay[0].getHeight());
        a.h.a(g, ay[3], 2, 303, 17, 15, 0, 0);
        a.h.a(g, h, ay[0], 213, 298, 27, 22, 0, 0);
        a.h.a(g, ay[3], 221, 303, 17, 15, 17, 0);
        a.d.b(g, main.e.y[a.d.m()], -1, 5 + (20 - a.g.b >> 1), 15597476, 6362880, 20);
        a.h.a(g, 12, 76, 214, 144, 6907220, 14593146);
        a.h.a(g, 14, 78, 210, 140, 9600109, 8020827);
        a.h.a(g, 80, 290, 78, 21, 7299920, 14658680);
        a.h.a(g, 82, 291, 74, 19, 14658680, 16708041);
        a.h.a(g, this.ar, 82, 292);
        a.h.b(g, as, aG, 102, 297, 7, 7, 0);
        if (L) {
            main.f.g(200, 60);
            return;
        }
        int n = 0;
        if (this.bp == 1) {
            a.d.a(g, main.e.d(main.e.a(main.e.B[a.d.m()], 7, false)), 15597476, 16, 79, 206, 138);
            if (main.f.d(65536)) {
                a.d.a(false);
                this.bh = 4;
                this.bp = 0;
                return;
            }
            if (!main.f.d(49184)) return;
            if (a.d.c()) {
                if (a.d.d()) return;
                a.d.a(false);
                this.bp = 3;
                return;
            }
            a.d.b();
            return;
        }
        if (this.bp == 2) {
            a.d.a(g, "\u0421\u0438\u043d\u0442\u0435\u0437 \u0442\u0440\u0435\u0431\u0443\u0435\u0442 " + main.e.g(main.e.B[a.d.m()]) + " \u0417\u043e\u043b\u043e\u0442\u044b\u0445 \u043c\u043e\u043d\u0435\u0442 ", 15597476, 16, 79, 206, 138);
            if (main.f.d(65536)) {
                a.d.a(false);
                this.bh = 4;
                this.bp = 0;
                return;
            }
            if (!main.f.d(49184)) return;
            if (a.d.c()) {
                if (a.d.d()) return;
                a.d.a(false);
                this.bp = 4;
                return;
            }
            a.d.b();
            return;
        }
        if (this.bp == 3) {
            n = this.a("\u0421\u0438\u043d\u0442\u0435\u0437 " + main.e.y[a.d.m()] + "? ", "\u0414\u0430 ", "\u041d\u0435\u0442 ");
            if (n == 1) {
                if (main.e.e(main.e.a(main.e.B[a.d.m()], 7, false))) {
                    bs = main.e.y[a.d.m()] + "\u0421\u0438\u043d\u0442\u0435\u0437\u0438\u0440\u043e\u0432\u0430\u043d\u043e ";
                    main.e.a(main.e.B[a.d.m()], 1);
                    main.e.f(main.e.a(main.e.B[a.d.m()], 7, false));
                    for (n = 1; n < main.e.X.length; ++n) {
                        if (main.e.i(main.e.X[n])) continue;
                        main.e.X[n] = -1;
                    }
                    main.f.g();
                } else {
                    bs = "\u041d\u0435\u0434\u043e\u0441\u0442\u0430\u0442\u043e\u0447\u043d\u043e \u043c\u0430\u0442\u0435\u0440\u0438\u0430\u043b\u043e\u0432 \u0434\u043b\u044f \u0441\u0438\u043d\u0442\u0435\u0437\u0430 ";
                }
                a.d.a(false);
                L = true;
                this.bp = 6;
                return;
            }
            if (n != 2) return;
            this.bp = 0;
            a.d.a(false);
            this.bh = 4;
            return;
        }
        if (this.bp == 4) {
            n = this.a("\u0421\u0438\u043d\u0442\u0435\u0437 " + main.e.y[a.d.m()] + "? ", "\u0414\u0430 ", "\u041d\u0435\u0442 ");
            if (n == 1) {
                if (aG >= main.e.g(main.e.B[a.d.m()])) {
                    aG -= main.e.g(main.e.B[a.d.m()]);
                    bs = main.e.y[a.d.m()] + "\u0421\u0438\u043d\u0442\u0435\u0437\u0438\u0440\u043e\u0432\u0430\u043d\u043e ";
                    main.e.a(main.e.B[a.d.m()], 1);
                    for (n = 1; n < main.e.X.length; ++n) {
                        if (main.e.i(main.e.X[n])) continue;
                        main.e.X[n] = -1;
                    }
                    main.f.g();
                    this.bp = 6;
                } else {
                    bs = "\u041d\u0435\u0434\u043e\u0441\u0442\u0430\u0442\u043e\u0447\u043d\u043e \u0434\u0435\u043d\u0435\u0433 \u0434\u043b\u044f \u0441\u0438\u043d\u0442\u0435\u0437\u0430 ";
                    this.bp = 5;
                }
                a.d.a(false);
                L = true;
                return;
            }
            if (n != 2) return;
            this.bp = 0;
            a.d.a(false);
            this.bh = 4;
            return;
        }
        if (this.bp == 5) {
            b.a(0);
            this.bp = 6;
            a.d.a(false);
            return;
        }
        if (this.bp == 6) {
            this.bp = 0;
            a.d.a(false);
            this.bh = 4;
            return;
        }
        n = this.a("\u0412\u044b\u0431\u0435\u0440\u0438\u0442\u0435 \u043c\u0435\u0442\u043e\u0434 \u0441\u0438\u043d\u0442\u0435\u0437\u0430 ", "\u041c\u0430\u0442\u0435\u0440\u0438\u0430\u043b ", "\u0417\u043e\u043b\u043e\u0442\u0430 ");
        if (n == 1) {
            this.bp = 1;
            a.d.a(false);
            return;
        }
        if (n != 2) return;
        this.bp = 2;
        a.d.a(false);
    }

    private void D() {
        a.h.a(g, ay[0], 0, 320 - ay[0].getHeight());
        a.h.a(g, ay[3], 2, 303, 17, 15, 0, 0);
        a.h.a(g, h, ay[0], 213, 298, 27, 22, 0, 0);
        a.h.a(g, ay[3], 221, 303, 17, 15, 17, 0);
        a.h.a(g, av, 50, 3);
        if (this.bj > 0) {
            a.d.b(g, this.bi[this.bj - 1], 32 + f, 3 + (24 - a.g.b >> 1), 14918185, 6764371, 17);
            a.h.a(g, au, 39, 9, 11, 11, 0, 0);
        } else if (this.bj == 0) {
            a.d.b(g, this.bi[6], 32 + f, 3 + (24 - a.g.b >> 1), 14918185, 6764371, 17);
            a.h.a(g, au, 39, 9, 11, 11, 0, 0);
        }
        if (this.bh != 1 && this.bh != 2) {
            a.d.b(g, this.bi[this.bj], 72 + f, 3 + (24 - a.g.b >> 1), 16239730, 6764371, 17);
        } else {
            a.d.b(g, this.bi[this.bj], 72 + f, 3 + (24 - a.g.b >> 1), 14918185, 6764371, 17);
        }
        if (this.bj < 6) {
            a.d.b(g, this.bi[this.bj + 1], 112 + f, 3 + (24 - a.g.b >> 1), 14918185, 6764371, 17);
            a.h.a(g, au, 94, 9, 11, 11, 11, 0);
            return;
        }
        if (this.bj == 6) {
            a.d.b(g, this.bi[0], 112 + f, 3 + (24 - a.g.b >> 1), 14918185, 6764371, 17);
            a.h.a(g, au, 94, 9, 11, 11, 11, 0);
        }
    }

    private void E() {
        a.h.a(g, ay[0], 0, 320 - ay[0].getHeight());
        a.h.a(g, ay[3], 2, 303, 17, 15, 0, 0);
        a.h.a(g, h, ay[0], 213, 298, 27, 22, 0, 0);
        a.h.a(g, ay[3], 221, 303, 17, 15, 17, 0);
        a.d.b(g, "\u0412\u0435\u0449\u0438 ", -1, 30 - a.g.b >> 1, 15597476, 6764371, 20);
        a.h.a(g, 12, 46, 214, 24, 7299920, 14658680);
        g.setColor(16708041);
        g.fillRect(15, 48, 82, 20);
        g.fillRect(99, 48, 124, 20);
        a.d.b(g, "\u041e\u0440\u0443\u0436\u0438\u0435 ", 58, 46 + (24 - a.g.b >> 1), 15597476, 6764371, 17);
        a.d.b(g, main.e.X[this.bo + 1] < 0 ? "\u041d\u0435 \u043e\u0431\u043e\u0440\u0443\u0434\u043e\u0432\u0430\u043d\u043e " : main.e.v[main.e.X[this.bo + 1]], 161, 46 + (24 - a.g.b >> 1), 15597476, 7085131, 17);
        a.d.a(g, main.e.y, null, null, 12, 71, 214, 5);
        a.h.a(g, 12, 222, 214, 68, 6907220, 14593146);
        a.h.a(g, 14, 224, 210, 64, 9600109, 8020827);
        if (L) {
            main.f.g(200, 60);
            return;
        }
        a.d.a(g, main.e.h(main.e.B[a.d.m()]), 15597476, 16, 225, 208, 62);
        if (a.d.c() && a.a.b(20)) {
            a.d.d();
        }
        if (main.f.d(65536)) {
            a.d.a(false);
            a.d.l();
            main.e.d();
            this.bh = 0;
            return;
        }
        if (main.f.d(49184) && main.e.B[a.d.m()] > -2) {
            if (main.e.B[a.d.m()] < 0 && this.bo == 0) {
                bs = "\u041d\u0435 \u043c\u043e\u0436\u0435\u0442 \u0431\u044b\u0442\u044c \u0443\u0434\u0430\u043b\u0435\u043d\u0430, \u043e\u0440\u0443\u0436\u0438\u0435 \u043c\u043e\u0436\u043d\u043e \u0442\u043e\u043b\u044c\u043a\u043e \u0437\u0430\u043c\u0435\u043d\u0438\u0442\u044c. ";
            } else {
                main.e.X[this.bo + 1] = main.e.B[a.d.m()];
                if (main.e.X[this.bo + 1] < 0) {
                    bs = "\u041e\u0431\u043e\u0440\u0443\u0434\u043e\u0432\u0430\u043d\u0438\u0435 \u0443\u0434\u0430\u043b\u0435\u043d\u043e ";
                } else {
                    bs = main.e.v[main.e.X[this.bo + 1]] + "\u042d\u043a\u0438\u043f\u0438\u0440\u043e\u0432\u0430\u043d\u043e ";
                    if (this.bo == 0) {
                        main.f.g();
                        main.f.m[1] = null;
                        main.f.m[2] = null;
                        main.f.m[3] = null;
                        System.gc();
                        int n = main.e.I / 4 + 1;
                        try {
                            if (m[n] == null) {
                                main.f.m[n] = Image.createImage((String)("/zhujiao" + (n + 1) + ".png"));
                            }
                        }
                        catch (Exception exception) {
                            // empty catch block
                        }
                        for (int i = 0; i < 5; ++i) {
                            a.e[i].a();
                        }
                    }
                }
            }
            L = true;
            a.d.a(false);
            return;
        }
        if (main.f.d(1028)) {
            a.d.a(false);
            a.d.j();
            return;
        }
        if (main.f.d(2304)) {
            a.d.a(false);
            a.d.k();
        }
    }

    public static void g() {
        switch (main.e.X[1]) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: {
                main.e.I = main.e.X[1] + 1;
                break;
            }
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: {
                main.e.I = main.e.X[1] + 2;
                break;
            }
            case 10: {
                main.e.I = 0;
                break;
            }
            case 11: {
                main.e.I = 6;
            }
        }
        d d2 = a.c[c];
        if (c == 0 && (d2.g == 0 || d2.g == 3 || d2.g >= 20 && d2.g <= 41)) {
            a.c[c].b(0, main.e.G[main.e.I]);
            a.c[c].c(main.e.G[main.e.I], 1);
        }
    }

    private void F() {
        int n;
        a.h.a(g, 0);
        g.drawImage(ay[2], 0, 0, 20);
        a.d.b(g, "\u041b\u0435\u0442\u043e\u043f\u0438\u0441\u044c ", -1, 30 - a.g.b >> 1, 15597476, 6764371, 20);
        for (n = 0; n < 3; ++n) {
            a.h.a(g, -1, 97 + n * 54, 162, 52, 6907220, 14593146);
            if (bt == n) {
                a.h.a(g, -1, 99 + n * 54, 158, 48, 14593146, 16708041);
            } else {
                a.h.a(g, -1, 99 + n * 54, 158, 48, 14593146, 13549230);
            }
            if (this.bu[n]) {
                a.d.b(g, "\u041b\u0435\u0442\u043e\u043f\u0438\u0441\u044c " + (n + 1), -1, 97 + (52 - a.g.b >> 1) + n * 54, 15597476, 7366729, 20);
                continue;
            }
            a.d.b(g, "\u041d\u0435\u0442 \u0430\u0440\u0445\u0438\u0432\u0430 ", -1, 97 + (52 - a.g.b >> 1) + n * 54, 0, 0x9E9E9E, 20);
        }
        a.h.a(g, ay[0], 0, 320 - ay[0].getHeight());
        a.h.a(g, ay[3], 2, 303, 17, 15, 0, 0);
        a.h.a(g, h, ay[0], 213, 298, 27, 22, 0, 0);
        a.h.a(g, ay[3], 221, 303, 17, 15, 17, 0);
        g.drawImage(ay[9], 0, 24, 20);
        switch (aE) {
            case 0: {
                if (main.f.d(49184)) {
                    if (this.bu[bt]) {
                        a.d.a(false);
                        aE = 1;
                    } else {
                        this.I();
                        a.d.a(false);
                        k = 2;
                    }
                } else if (main.f.d(65536)) {
                    k = 5;
                }
                if (main.f.d(5140)) {
                    if (--bt >= 0) break;
                    bt = 2;
                    return;
                }
                if (!main.f.d(10560) || ++bt <= 2) break;
                bt = 0;
                return;
            }
            case 1: {
                n = this.a("\u0410\u0440\u0445\u0438\u0432 " + (bt + 1), "\u0417\u0430\u0433\u0440 ", "\u0423\u0434 ");
                if (n == 1) {
                    this.I();
                    this.k(bt);
                    a.d.a(false);
                    k = 2;
                } else if (n == 2) {
                    a.d.a(false);
                    aE = 2;
                }
                if (!main.f.d(65536)) break;
                aE = 0;
                return;
            }
            case 2: {
                n = this.a("\u0423\u0432\u0435\u0440\u0435\u043d\u044b, \u0447\u0442\u043e \u0445\u043e\u0442\u0438\u0442\u0435 \u0443\u0434\u0430\u043b\u0438\u0442\u044c " + (bt + 1) + "\u0434\u0430\u043d\u043d\u044b\u0435? ", "\u0414\u0430 ", "\u041d\u0430\u0437\u0430\u0434 ");
                if (n == 1) {
                    try {
                        RecordStore.deleteRecordStore((String)(this.aW + bt));
                    }
                    catch (RecordStoreException recordStoreException) {}
                    this.bu[main.f.bt] = false;
                    a.d.a(false);
                    aE = 0;
                } else if (n == 2) {
                    aE = 0;
                    a.d.a(false);
                }
                if (!main.f.d(65536)) break;
                aE = 0;
            }
        }
    }

    public static boolean d(int n) {
        return (i & n) != 0;
    }

    private static void e(int n, int n2) {
        n = bw.length * a.g.b;
        n = 160 - n / 2;
        int n3 = 1;
        n -= 13;
        for (n2 = 0; n2 < bw.length; ++n2) {
            String string = bw[n2];
            if (n2 == 2) {
                string = bw[n2] + aD;
            }
            a.d.b(g, string, 120, n + n3 * a.g.b, 0, 0xFFFFFF, 17);
            ++n3;
        }
    }

    private static void f(int n, int n2) {
        if (aJ <= 0) {
            return;
        }
        n = bw.length * a.g.b;
        n = 160 - n / 2 - 13;
        if ((aH[0] & 0xFFFF) != 39) {
            n += 10;
        }
        n2 = ae - 1;
        for (int i = 0; i < ae; ++i) {
            if ((aH[i] & 0x20000) == 0) continue;
            --n2;
        }
        String string = bw[n2];
        if (n2 == 2) {
            string = bw[n2] + aD;
        }
        a.d.b(g, string, 120, n + n2 * a.g.b + a.g.b, 0, 6461906, 17);
    }

    public static void h() {
        f = 0;
        bx = true;
        k = 9;
    }

    public static void a(int n, int n2) {
        if (n < 0) {
            main.f.bD[0] = n;
            main.f.bD[1] = n;
            main.f.bD[2] = n;
            main.f.bD[3] = n;
            aP = false;
            return;
        }
        bE = c;
        main.f.bD[0] = n % 10;
        main.f.bD[1] = n / 10 % 10;
        main.f.bD[2] = n / 100 % 10;
        main.f.bD[3] = n / 1000;
        aP = true;
    }

    private void G() {
        if (!aP || k != 7 || K == 610) {
            return;
        }
        int n = (a.c[main.f.bE].c >> 8) - a.a - 9;
        int n2 = (a.c[main.f.bE].d >> 8) - a.b - 18;
        int n3 = 0;
        int n4 = 0;
        for (int i = 0; i < bD.length; ++i) {
            int n5;
            if (bD[i] <= 0) continue;
            if (bE == c) {
                switch (bD[i]) {
                    case 1: {
                        n3 = n;
                        n4 = n2 - 18 + a.c[main.f.c].b[1];
                        break;
                    }
                    case 2: {
                        n3 = n - 18;
                        n4 = n2 - 14;
                        break;
                    }
                    case 4: {
                        n3 = n + 18;
                        n4 = n2 - 14;
                        break;
                    }
                    default: {
                        n3 = n;
                        n4 = n2 + a.c[main.f.c].b[1];
                        break;
                    }
                }
            } else {
                n3 = n;
                n4 = n2 + a.c[main.f.bE].b[1];
            }
            g.setClip(n3, n4, 18, 18);
            if (this.bC % 6 < 3) {
                g.drawImage(B, n3, n4 - 24, 20);
                n5 = bD[i] - 1;
                g.setClip(n3 += 3, n4 += 3, 12, 12);
                g.drawImage(B, n3 - n5 * 12, n4, 20);
                continue;
            }
            g.drawImage(B, n3 - 18, n4 - 24, 20);
            n5 = bD[i] - 1;
            g.setClip(n3 += 3, n4 += 3, 12, 12);
            g.drawImage(B, n3 - n5 * 12, n4 - 12, 20);
        }
        ++this.bC;
    }

    private void H() {
        if (a.c.e) {
            return;
        }
        if (!a.c[main.f.c].a[3] && K == 701) {
            if (!L && k == 7 && !T) {
                a.d.a(g, "\u041c\u0435\u043d\u044e ", null);
            }
        } else {
            a.h.a(g, this.al, 0, 0);
            a.h.a(g, 32, 21, 66 * main.e.M / main.e.h(), 5, 16375322, 16364836);
            a.h.a(g, 32, 31, 52 * main.e.L / main.e.i(), 2, 33254, 5022438);
            a.h.a(g, 32, 38, 37 * main.e.J / main.e.p(), 2, 11927296, 11927296);
            if (!(L || k != 7 || T || M || aQ)) {
                main.e.j();
                f f2 = this;
                a.h.a(g, f2.ao, 80, 299, 20, 20, 0, 11);
                a.h.a(g, f2.ao, 100, 299, 20, 20, 0, 11);
                a.h.a(g, f2.ao, 120, 299, 20, 20, 0, 11);
                a.h.a(g, f2.ao, 140, 299, 20, 20, 0, 11);
                if (main.e.s >= 0) {
                    a.h.a(g, f2.an, 84, 302, 12, 12, (main.e.s - 42) * 12, 0);
                }
                if (main.e.t >= 0) {
                    a.h.a(g, f2.an, 104, 302, 12, 12, (main.e.t - 42) * 12, 0);
                }
                if (main.e.q >= 0) {
                    a.h.a(g, f2.an, 124, 302, 12, 12, 144 + main.e.q * 12, 0);
                }
                if (main.e.r >= 0) {
                    a.h.a(g, f2.an, 144, 302, 12, 12, 144 + main.e.r * 12, 0);
                }
                if (X > 0) {
                    a.h.a(g, f2.ao, 124, 301, 12, X, 20, 11);
                    if (f2.l(10)) {
                        --X;
                    }
                }
                if (Y > 0) {
                    a.h.a(g, f2.ao, 144, 301, 12, Y, 20, 11);
                    if (f2.l(10)) {
                        --Y;
                    }
                }
                a.h.a(g, f2.ao, 88, 309, 11, 11, 0, 0);
                a.h.a(g, f2.ao, 108, 309, 11, 11, 11, 0);
                a.h.a(g, f2.ao, 128, 309, 11, 11, 22, 0);
                a.h.a(g, f2.ao, 148, 309, 11, 11, 33, 0);
                f2 = this;
                if (k == 7 && K != 0 && K != 610 && K != 701 && K != 702 && f2.bH++ > 100) {
                    f2.bH = 0;
                    main.f.b(f2.bF[f2.bG]);
                    ++f2.bG;
                    if (f2.bG >= f2.bF.length) {
                        f2.bG = 0;
                    }
                }
                a.d.a(g, "\u041c\u0435\u043d\u044e ", "\u0418\u043d\u0444\u043e ");
                if ((i & 0x10000) != 0 && main.e.M > 0) {
                    a.d.a(false);
                    this.j();
                    k = 17;
                }
            }
        }
        for (int i = 0; i < bI.length; ++i) {
            if (bI[i][0] != 1) continue;
            g.setClip(0, 0, 240, 60);
            g.setColor(0xFFFFFF);
            g.setFont(a.g.a);
            g.drawString(bJ[i], 240 - a.g.a.stringWidth(bJ[i]), bI[i][1], 20);
            int[] nArray = bI[i];
            nArray[1] = nArray[1] - 2;
            if (bI[i][1] >= -20) continue;
            main.f.bI[i][0] = 0;
        }
    }

    public static void b(String string) {
        for (int i = 0; i < bI.length; ++i) {
            if (bI[i][0] != 0) continue;
            main.f.bJ[i] = string;
            main.f.bI[i][0] = 1;
            main.f.bI[i][1] = 60;
            if (60 - bI[bK][1] <= 20) {
                main.f.bI[i][1] = 80 - (60 - bI[bK][1]);
            }
            bK = i;
            return;
        }
    }

    public static void e(int n) {
        switch (n) {
            case 1: {
                X = 14;
                return;
            }
            case 2: {
                Y = 14;
            }
        }
    }

    private boolean l(int n) {
        ++this.bL;
        if (this.bL >= 10) {
            this.bL = 0;
            return true;
        }
        return false;
    }

    private static void a(String[] stringArray, int n, boolean n2, boolean bl) {
        a.d.b(g, stringArray[0], -1, 30 - a.g.b >> 1, 15597476, 6764371, 20);
        a.h.a(g, ay[5], (240 - ay[6].getWidth() >> 1) + 8, 32);
        a.h.a(g, h, ay[5], (240 + ay[6].getWidth() >> 1) - 8 - 15, 32, 15, 28, 0, 0);
        a.h.a(g, ay[7], (240 - ay[6].getWidth() >> 1) + 10, 42 + (stringArray.length - 1) * 24);
        a.h.a(g, h, ay[7], (240 + ay[6].getWidth() >> 1) - 10 - 10, 42 + (stringArray.length - 1) * 24, 10, 20, 0, 0);
        for (n2 = 0; n2 < stringArray.length - 1; ++n2) {
            if (n2 < stringArray.length - 2) {
                a.h.a(g, ay[8], (240 - ay[6].getWidth() >> 1) + 13, 56 + n2 * 24);
                a.h.a(g, ay[8], (240 + ay[6].getWidth() >> 1) - 17, 56 + n2 * 24);
            }
            if (n == n2) {
                a.h.a(g, ay[6], 240 - ay[6].getWidth() >> 1, 46 + n2 * 24, 148, 21, 0, 0);
            } else {
                a.h.a(g, ay[6], 240 - ay[6].getWidth() >> 1, 46 + n2 * 24, 148, 21, 0, 21);
            }
            a.d.b(g, stringArray[n2 + 1], -1, 46 + n2 * 24 + (21 - a.g.b >> 1), 15597476, 6764371, 20);
        }
        a.h.a(g, ay[4], (240 - a.g.a.stringWidth(stringArray[n + 1]) >> 1) - 14, 48 + n * 24);
        a.h.a(g, h, ay[4], (240 + a.g.a.stringWidth(stringArray[n + 1]) >> 1) + 2, 48 + n * 24, 12, 17, 0, 0);
        a.h.a(g, ay[0], 0, 320 - ay[0].getHeight());
        a.h.a(g, ay[3], 2, 303, 17, 15, 0, 0);
        a.h.a(g, h, ay[0], 213, 298, 27, 22, 0, 0);
        a.h.a(g, ay[3], 221, 303, 17, 15, 17, 0);
    }

    public final void i() {
        this.c(true);
        for (int i = 0; i < ay.length; ++i) {
            if (ay[i] != null) continue;
            main.f.a(i, "/splash" + i + ".png");
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
        int n;
        main.e.x = new int[main.e.w.length];
        System.arraycopy(main.e.w, 0, main.e.x, 0, main.e.x.length);
        main.e.D = new int[main.e.E.length];
        System.arraycopy(main.e.E, 0, main.e.D, 0, main.e.D.length);
        aG = 0;
        main.e.X[0] = 0;
        main.e.X[1] = 10;
        for (n = 2; n < main.e.X.length; ++n) {
            main.e.X[n] = -1;
        }
        for (n = 0; n < main.e.u.length; ++n) {
            main.e.u[n] = false;
        }
        main.f.S[0] = 0;
        for (n = 1; n < S.length; ++n) {
            main.f.S[n] = 10;
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

    private void m(int n) {
        switch (k) {
            case 9: {
                switch (n & 0xFFFF) {
                    case 1: 
                    case 36: {
                        k = 7;
                        this.by = 0;
                        f = 0;
                        if (aN) {
                            if (K == 0 || K == 610 || K == 701 || K == 702) {
                                this.ab.a("menu", true, 1);
                                return;
                            }
                            this.ab.a("gate", true, 1);
                            return;
                        }
                        this.ab.a();
                        return;
                    }
                    case 2: {
                        this.i();
                        this.by = 0;
                        return;
                    }
                    case 3: {
                        aN = !aN;
                        aD = aN ? "\u041d\u0430 " : "\u0411\u043b\u0438\u0437\u043a\u043e ";
                        return;
                    }
                    case 4: {
                        k = 11;
                        aO = (byte)3;
                        return;
                    }
                    case 5: {
                        k = 0;
                    }
                }
            }
        }
    }

    public static void f(int n) {
        ah = n;
        j = 0;
        i = 0;
        af = 0;
    }

    private void J() {
        if (aJ > 1) {
            if ((i & 0x1414) != 0) {
                do {
                    if (--ae > 0) continue;
                    ae = aH.length - 3;
                } while ((aH[ae] & 0x20000) != 0);
                f = 0;
            } else if ((i & 0x2940) != 0) {
                do {
                    if (++ae <= aH.length - 3) continue;
                    ae = 1;
                } while ((aH[ae] & 0x20000) != 0);
                f = 0;
            }
            if (((i & 0x4020) != 0 || (i & 0x8000) != 0) && aJ > 1) {
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

    private static void n(int n) {
        ae = 1;
        aH = aF;
        aJ = 0;
        for (n = 1; n <= aH.length - 3; ++n) {
            if ((aH[n] & 0x20000) != 0) continue;
            ++aJ;
        }
        if (aJ > 0) {
            while ((aH[ae] & 0x20000) != 0) {
                if (++ae <= aH.length - 3) continue;
                ae = 1;
            }
        }
        bM = 0;
        aI = -1;
    }

    public static void b(int n, int n2) {
        if (n == bQ && bS == n2) {
            return;
        }
        if (!L) {
            bS = n2;
            bR = 0;
            bQ = n;
            L = true;
            a.d.a(false);
            switch (bS) {
                case 0: {
                    bT = main.e.F(bQ);
                    return;
                }
                case 1: {
                    bT = main.e.C(bQ);
                    return;
                }
                case 2: {
                    bT = main.e.E(bQ);
                }
            }
        }
    }

    private void K() {
        String string = "";
        int n = 0;
        do {
            string = string + bT[bR].charAt(n);
        } while (bT[bR].charAt(n++) != '\uff1a' && n < bT[bR].length());
        String string2 = "";
        this.bU = true;
        if (string.equals("Atlantida: ")) {
            string2 = "head2.png";
        } else if (string.equals("virusfon: ")) {
            string2 = !(a.c[main.f.c].a[3] || K != 701 && K != 702) ? "head1.png" : "head0.png";
        } else if (string.equals("\u0420\u0430\u0434\u0443\u0433\u0430: ")) {
            string2 = "head3.png";
        } else if (string.equals("Etty: ")) {
            string2 = "head4.png";
        } else if (string.equals("BlackFan: ")) {
            string2 = "head5.png";
        } else if (string.equals("\u0414\u0435\u0432\u043e\u0447\u043a\u0430: ")) {
            string2 = "head6.png";
        } else if (string.equals("\u0424\u0443\u043a\u0441\u0438\u044f: ")) {
            string2 = "head7.png";
        } else {
            this.bU = false;
        }
        try {
            if (this.bU) {
                this.aq = Image.createImage((String)("/" + string2));
            }
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    private static void g(int n, int n2) {
        a.h.a(g, 240 - n >> 1, 320 - n2 >> 1, n, n2, 6907220, 15580812);
        a.h.a(g, 240 - (n - 4) >> 1, 320 - (n2 - 4) >> 1, n - 4, n2 - 4, 15580812, 0xFEEFCE);
        a.d.a(g, bs, 6764371, 240 - (n - 2 - a.g.a.stringWidth("\u0412\u0432\u043e\u0434\u0438\u0442\u044c ")) + 4 >> 1, 320 - (n2 - 8) + 4 >> 1, n - a.g.a.stringWidth("\u0412\u0432\u043e\u0434\u0438\u0442\u044c "), n2 - 8);
        if (main.f.d(114720)) {
            if (a.d.c()) {
                if (!a.d.d()) {
                    a.d.a(false);
                    L = false;
                    main.f.f(0);
                    return;
                }
            } else {
                a.d.b();
            }
        }
    }

    private int a(String string, String string2, String string3) {
        a.h.a(g, 20, 129, 200, 62, 6907220, 16635556);
        a.h.a(g, 23, 132, 194, 56, 16568212, 0xFEEFCE);
        a.h.a(g, -1, 134, 190, 24, 0xFEEFCE, 13549230);
        a.d.a(g, string, 6764371, 240 - (198 - a.g.a.stringWidth("\u0412\u0432\u043e\u0434\u0438\u0442\u044c ")) + 4 >> 1, 134 + (24 - a.g.b >> 1), 200 - a.g.a.stringWidth("\u0412\u0432\u043e\u0434\u0438\u0442\u044c "), a.g.b);
        if (this.bV == 0) {
            a.h.a(g, 28, 159, 54, 25, 0xFEEFCE, 13549230);
        } else if (this.bV == 1) {
            a.h.a(g, 159, 159, 54, 25, 0xFEEFCE, 13549230);
        }
        a.d.c(g, string2, 28 + (54 - a.g.a.stringWidth("\u0414\u0430 ") >> 1), 159 + (25 - a.g.b >> 1), 15597476, 6764371, 20);
        a.d.c(g, string3, 159 + (54 - a.g.a.stringWidth("\u0414\u0430 ") >> 1), 159 + (25 - a.g.b >> 1), 15597476, 6764371, 20);
        if (a.d.c() && a.a.b(10)) {
            a.d.d();
        }
        if (main.f.d(49184)) {
            a.d.a(false);
            if (this.bV == 0) {
                this.bV = 0;
                return 1;
            }
            this.bV = 0;
            return 2;
        }
        if (main.f.d(4112)) {
            this.bV = 0;
        } else if (main.f.d(8256)) {
            this.bV = 1;
        }
        return 0;
    }

    static {
        aa = new b();
        ac = new a();
        ae = 1;
        k = 1;
        m = new Image[5];
        o = new Image[2];
        q = new Image[14];
        v = new Image[10];
        ay = new Image[10];
        z = new Image[7];
        C = false;
        D = false;
        E = false;
        aD = "";
        aF = new int[]{39, 1, 2, 3, 4, 5, 35, 36};
        F = false;
        G = true;
        I = false;
        J = 0;
        aN = true;
        L = false;
        aP = false;
        aQ = false;
        M = false;
        O = 0;
        P = false;
        aY = false;
        Q = 4;
        R = new String[]{"Fonzo Team ", "\u041b\u0435\u0441 \u041c\u0438\u043d\u0433\u0430 ", "\u0417\u043b\u043e\u0439 \u0440\u043e\u043a ", "\u041a\u0430\u043f\u0435\u0446 ", "\u0414\u0435\u043c\u043e\u043d-\u0425\u0438\u043b\u043b ", "\u0422\u0443\u043c\u0430\u043d\u044b ", "\u041c\u0438\u0440 \u0425\u0430\u043e\u0441\u0430 ", "\u0421\u043d\u0435\u0433\u0430 ", "\u041b\u0435\u0434\u043e\u0432\u044b\u0439 \u0434\u0432\u043e\u0440\u0435\u0446 "};
        S = new byte[]{0, 10, 10, 10, 10, 10, 10, 10, 10};
        T = false;
        be = new String[]{null, null, null, null, null, null, null, null, null, null};
        U = false;
        V = -1;
        String[] stringArray = new String[]{"\u0416\u0438\u0437\u043d\u044c ", "\u0410\u0442\u0430\u043a\u0430 ", "\u0417\u0430\u0449\u0438\u0442\u0430 ", "\u041a\u0440\u0438\u0442 "};
        bt = 0;
        bw = new String[]{"\u0412\u043e\u0437\u043e\u0431\u043d\u043e\u0432\u0438\u0442\u044c ", "\u0413\u043b\u0430\u0432\u043d\u043e\u0435 \u043c\u0435\u043d\u044e ", "\u0417\u0432\u0443\u043a ", "\u0418\u043d\u0441\u0442\u0440\u0443\u043a\u0446\u0438\u0438 ", "\u0412\u044b\u0445\u043e\u0434 "};
        W = false;
        bD = new int[]{0, 0, 0, 0};
        bE = 0;
        bI = new int[10][2];
        bJ = new String[]{null, null, null, null, null, null, null, null, null, null};
        X = 0;
        Y = 0;
        int[] nArray = new int[]{0, 1};
        int[] nArray2 = new int[]{5, 6, 11, 12, 17};
        int[] nArray3 = new int[]{8, 13, 14, 15, 16};
        int[] nArray4 = new int[]{7, 8, 14, 15, 16};
        int[] nArray5 = new int[]{0xFF0000, 0xE20000, 0xBF0000, 0xA00000, 0, 0, 0, 0};
    }
}

