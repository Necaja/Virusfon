/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.nokia.mid.ui.DirectUtils
 *  javax.microedition.lcdui.Graphics
 *  javax.microedition.lcdui.Image
 */
package a;

import a.e;
import a.h;
import com.nokia.mid.ui.DirectUtils;
import java.io.IOException;
import java.io.InputStream;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.f;

public final class c {
    private static byte[] f;
    public static int a;
    public static int b;
    private static int g;
    private static int[] h;
    public static int c;
    public static int d;
    public static boolean e;
    private static Image[] i;
    private static int j;
    private static int k;
    private static int l;

    public static void a(String string, String string2, String string3) {
        try {
            a.c.i[0] = Image.createImage((String)string);
            a.c.i[1] = Image.createImage((String)string2);
            a.c.i[2] = Image.createImage((String)string3);
            a.c.h[0] = i[0].getWidth() / c;
            a.c.h[1] = i[1].getWidth() / c;
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    public static void a() {
        a.c.i[0] = null;
        a.c.i[1] = null;
        a.c.i[2] = null;
        System.gc();
    }

    public static int a(String object) {
        int n = 0;
        try {
            object = "a".getClass().getResourceAsStream((String)object);
            a = a.e.a((InputStream)object);
            b = a.e.a((InputStream)object);
            c = a.e.a((InputStream)object);
            d = a.e.a((InputStream)object);
            n = b;
            int n2 = a;
            n = n * n2 << 1;
            n2 = n << 1;
            g = n;
            f = new byte[n2];
            n = 8 + a.e.a((InputStream)object, f, 0, n2);
            ((InputStream)object).close();
            return n;
        }
        catch (Exception exception) {
            System.out.println("Map_err");
            return -1;
        }
    }

    /*
     * Unable to fully structure code
     */
    public static void a(int var0, int var1_2, Graphics var2_3) {
        block10: {
            block12: {
                block11: {
                    var2_4 = var1_2;
                    var1_2 = var0;
                    var0_1 = var2_3;
                    if (a.c.e || a.c.i[0] == null || a.c.i[1] == null) {
                        return;
                    }
                    var3_5 = DirectUtils.getDirectGraphics((Graphics)var0_1);
                    a.h.a(var0_1, 0);
                    var4_6 = var1_2 / a.c.c;
                    var5_7 = var4_6 + 240 / a.c.c;
                    var6_8 = var2_4 / a.c.d;
                    var7_9 = var6_8 + 320 / a.c.d;
                    if (a.c.i[2] == null) break block10;
                    if (main.f.K != 0) break block11;
                    a.h.a(var0_1, 0xB9DBDD);
                    var0_1.drawImage(a.c.i[2], 0, 320 - a.c.i[2].getHeight(), 20);
                    var0_1.drawImage(a.c.i[2], a.c.i[2].getWidth(), 320 - a.c.i[2].getHeight(), 20);
                    var0_1.drawImage(a.c.i[2], a.c.i[2].getWidth() << 1, 320 - a.c.i[2].getHeight(), 20);
                    var0_1.drawImage(a.c.i[2], a.c.i[2].getWidth() * 3, 320 - a.c.i[2].getHeight(), 20);
                    break block10;
                }
                if (main.f.K != 701) break block12;
                a.h.a(var0_1, 7631791);
                ** GOTO lbl-1000
            }
            if (main.f.K == 702) {
                a.h.a(var0_1, 0);
                var0_1.drawImage(a.c.i[2], 0, 0, 20);
                var0_1.drawImage(a.c.i[2], 0, 52, 20);
                var0_1.drawImage(a.c.i[2], 0, 104, 20);
                var0_1.drawImage(a.c.i[2], 0, 156, 20);
                a.h.b();
            } else lbl-1000:
            // 2 sources

            {
                var0_1.drawImage(a.c.i[2], 0, 0, 20);
            }
        }
        while (var6_8 <= var7_9) {
            for (var8_10 = var4_6; var8_10 <= var5_7; ++var8_10) {
                var10_12 = var6_8;
                var9_11 = var8_10;
                var9_11 = var9_11 < 0 || var9_11 >= a.c.a || var10_12 < 0 || var10_12 >= a.c.b ? -1 : var10_12 * a.c.a + var9_11 << 1;
                if (var9_11 == -1) continue;
                var10_12 = var8_10 * a.c.c - var1_2;
                var11_13 = var6_8 * a.c.d - var2_4;
                var0_1.setClip(var10_12, var11_13, a.c.c, a.c.d);
                for (var12_14 = 0; var12_14 <= 1; var12_14 = (int)((byte)(var12_14 + 1))) {
                    var13_15 = 0;
                    if (var12_14 < 1) {
                        var13_15 = a.c.g;
                    }
                    if (a.c.f[var9_11 + var13_15 + 1] == -1 || (var14_16 = a.c.f[var9_11 + var13_15]) == -1) continue;
                    var15_17 = var12_14 == 1 ? a.c.h[0] : a.c.h[1];
                    var13_15 = (a.c.f[var9_11 + var13_15 + 1] & 255) + ((var14_16 & 1) << 8);
                    var16_18 = var13_15 / var15_17 * a.c.d;
                    a.c.k = var13_15 = var13_15 % var15_17 * a.c.c;
                    a.c.l = var16_18;
                    if (var12_14 > 0) {
                        if ((var14_16 & 192) == 0) {
                            var0_1.drawImage(a.c.i[0], var10_12 - var13_15, var11_13 - var16_18, 20);
                            continue;
                        }
                        var15_17 = a.c.a((int)var14_16, a.c.i[0].getWidth(), a.c.i[0].getHeight());
                        var3_5.drawImage(a.c.i[0], var10_12 - a.c.k, var11_13 - a.c.l, 20, var15_17);
                        continue;
                    }
                    if ((var14_16 & 192) == 0) {
                        var0_1.drawImage(a.c.i[1], var10_12 - var13_15, var11_13 - var16_18, 20);
                        continue;
                    }
                    var15_17 = a.c.a((int)var14_16, a.c.i[1].getWidth(), a.c.i[1].getHeight());
                    var3_5.drawImage(a.c.i[1], var10_12 - a.c.k, var11_13 - a.c.l, 20, var15_17);
                }
            }
            ++var6_8;
        }
    }

    private static int a(int n, int n2, int n3) {
        int n4 = 0;
        if ((n & 0x40) != 0) {
            if ((n & 0x80) != 0) {
                n4 = 180;
                k = n2 - k - c;
                l = n3 - l - d;
            } else {
                n4 = 8192;
                k = n2 - k - c;
            }
        } else if ((n & 0x80) != 0) {
            n4 = 16384;
            l = n3 - l - d;
        }
        return n4;
    }

    public static byte a(int n, int n2) {
        if (n < 0 || n >= a) {
            return 1;
        }
        if (n2 < 0 || n2 >= b) {
            return 3;
        }
        byte by = (byte)((f[n2 * a + n << 1] & 0x3E) >> 1);
        n = by;
        if (by == 2) {
            return 1;
        }
        if (n == 1) {
            return 3;
        }
        return (byte)n;
    }

    static {
        h = new int[2];
        c = 16;
        d = 16;
        e = false;
        i = new Image[3];
        j = 0;
    }
}

