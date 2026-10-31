/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Font
 *  javax.microedition.lcdui.Graphics
 *  javax.microedition.lcdui.Image
 */
package a;

import a.g;
import a.h;
import java.util.Vector;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class d {
    private static int a = 0;
    private static int b = 0;
    private static int c = 0;
    private static int d;
    private static byte e;
    private static byte f;
    private static boolean g;
    private static String[][] h;
    private static int i;
    private static int j;
    private static int k;
    private static int l;
    private static boolean m;
    private static boolean n;

    public static boolean a(Graphics graphics, String[] stringArray) {
        int n = 260 / (a.g.b + 2) + 2;
        if (c == 0) {
            if (a < 30) {
                ++a;
            } else {
                graphics.setClip(0, 15, 240, 260);
                graphics.setFont(a.g.a);
                graphics.setColor(0xFFFFFF);
                int n2 = 0;
                if (30 - (290 - b) > 0) {
                    n2 = (30 - (290 - b)) / (a.g.b + 2);
                }
                int n3 = n = n2 + n > stringArray.length ? stringArray.length : n2 + n;
                while (n2 < n) {
                    a.d.b(graphics, stringArray[n2], -1, 290 - b + n2 * (a.g.b + 2), 0xFFFFFF, 0, 20);
                    ++n2;
                }
                if ((b += 2) > (stringArray.length + 1) * (a.g.b + 2) + 320 - 60) {
                    c = 1;
                }
            }
        } else if (a > 0) {
            --a;
        } else {
            c = 0;
            b = 0;
            return true;
        }
        a.h.a(graphics, 0, 0, 240, 320);
        graphics.setColor(0);
        graphics.fillRect(0, 0, 240, a);
        graphics.fillRect(0, 320 - a, 240, a);
        a.d.a(graphics, null, "\u041f\u0440\u043e\u043f\u0443\u0441\u0442\u0438\u0442\u044c");
        return false;
    }

    public static void a() {
        c = 1;
    }

    public static void a(Graphics graphics, String object, int n, int n2, int n3, int n4, int n5) {
        if (h == null) {
            Object[] objectArray;
            Object object2 = object;
            int n6 = n4;
            Font font = a.g.a;
            object = object2;
            if (object2 == null) {
                objectArray = null;
            } else {
                if (n6 < font.charWidth('\u54c8')) {
                    n6 = font.charWidth('\u54c8');
                }
                int n7 = 0;
                int n8 = 0;
                Vector<Object> vector = new Vector<Object>();
                Object var11_13 = null;
                boolean bl = false;
                block7: while (((String)object).length() > n7) {
                    char c2 = ((String)object).charAt(n7);
                    switch (c2) {
                        case '\n': {
                            vector.addElement(((String)object).substring(0, n7));
                            object = ((String)object).substring(n7 + 1);
                            n8 = 0;
                            n7 = 0;
                            continue block7;
                        }
                        case '\t': {
                            StringBuffer stringBuffer = new StringBuffer((String)object);
                            stringBuffer.deleteCharAt(n7);
                            stringBuffer.insert(n7, "\u3000\u3000");
                            object = stringBuffer.toString();
                            continue block7;
                        }
                        case '\r': {
                            StringBuffer stringBuffer = new StringBuffer((String)object);
                            stringBuffer.deleteCharAt(n7);
                            object = stringBuffer.toString();
                            continue block7;
                        }
                        case '\b': {
                            StringBuffer stringBuffer = new StringBuffer((String)object);
                            stringBuffer.deleteCharAt(n7);
                            object = stringBuffer.toString();
                            continue block7;
                        }
                        case '\f': {
                            StringBuffer stringBuffer = new StringBuffer((String)object);
                            stringBuffer.deleteCharAt(n7);
                            object = stringBuffer.toString();
                            vector.addElement("\u0414\u0430\u043b\u044c\u0448\u0435");
                            continue block7;
                        }
                    }
                    if (n8 + font.charWidth(c2) > n6) {
                        vector.addElement(((String)object).substring(0, n7));
                        object = ((String)object).substring(n7);
                        n8 = 0;
                        n7 = 0;
                        continue;
                    }
                    n8 += font.charWidth(c2);
                    ++n7;
                }
                vector.addElement(object);
                object = new String[vector.size()];
                vector.copyInto((Object[])object);
                objectArray = object;
            }
            h = a.d.a(objectArray, n5 / a.g.b);
            f = 0;
            e = 0;
            d = 0;
            if (g) {
                a.d.b();
            }
            g = false;
        }
        int n9 = d;
        graphics.setFont(a.g.a);
        graphics.setColor(n);
        for (n = 0; n < h[f].length; ++n) {
            if (n >= e) continue;
            graphics.drawString(h[f][n], n2, n3 + a.g.b * n, 20);
        }
        if (e < h[f].length) {
            if (n9 > 0) {
                graphics.drawSubstring(h[f][e], 0, n9, n2, n3 + a.g.b * e, 20);
            }
            if (n9 < h[f][e].length()) {
                ++d;
                return;
            }
            d = 0;
            e = (byte)(e + 1);
        }
    }

    public static void b() {
        e = (byte)h[f].length;
    }

    public static boolean c() {
        return e >= h[f].length;
    }

    public static boolean d() {
        if (f < h.length - 1) {
            f = (byte)(f + 1);
            d = 0;
            e = 0;
            return true;
        }
        return false;
    }

    public static void e() {
        if (f > 0) {
            f = (byte)(f - 1);
            d = 0;
            e = 0;
        }
    }

    public static boolean f() {
        return f < h.length - 1;
    }

    public static void a(boolean bl) {
        h = null;
        g = false;
    }

    private static String[][] a(String[] stringArray, int n) {
        int n2 = 0;
        int n3 = 0;
        for (int i = 0; i < stringArray.length; ++i) {
            if (!(stringArray[i].equals("\u0414\u0430\u043b\u044c\u0448\u0435") ? n2 != 0 : ++n2 % n == 0 || i == stringArray.length - 1)) continue;
            ++n3;
            n2 = 0;
        }
        if (n3 == 0) {
            n3 = 1;
        }
        Vector<String> vector = new Vector<String>();
        String[][] stringArray2 = new String[n3][];
        int n4 = 0;
        n2 = 0;
        for (int i = 0; i < stringArray.length; ++i) {
            if (stringArray[i].equals("\u0414\u0430\u043b\u044c\u0448\u0435")) {
                if (n2 == 0) continue;
            } else {
                vector.addElement(stringArray[i]);
                if (++n2 % n != 0 && i != stringArray.length - 1) continue;
            }
            stringArray2[n4] = new String[vector.size()];
            vector.copyInto(stringArray2[n4]);
            vector.removeAllElements();
            ++n4;
            n2 = 0;
        }
        System.gc();
        return stringArray2;
    }

    public static void b(Graphics graphics, String string, int n, int n2, int n3, int n4, int n5) {
        if (n == -1) {
            n = (240 - a.g.a.stringWidth(string)) / 2;
        }
        graphics.setFont(a.g.a);
        graphics.setClip(0, 0, 240, 320);
        if (n4 >= 0) {
            graphics.setColor(n4);
            graphics.drawString(string, n + 1, n2, n5);
            graphics.drawString(string, n - 1, n2, n5);
            graphics.drawString(string, n, n2 + 1, n5);
            graphics.drawString(string, n, n2 - 1, n5);
        }
        graphics.setColor(n3);
        graphics.drawString(string, n, n2, n5);
    }

    public static void c(Graphics graphics, String string, int n, int n2, int n3, int n4, int n5) {
        graphics.setFont(a.g.a);
        graphics.setClip(0, 0, 240, 320);
        graphics.setColor(n4);
        graphics.drawString(string, n + 1, n2, 20);
        graphics.drawString(string, n - 1, n2, 20);
        graphics.drawString(string, n, n2 + 1, 20);
        graphics.drawString(string, n, n2 - 1, 20);
        graphics.setColor(n3);
        graphics.drawString(string, n, n2, 20);
    }

    public static void a(Graphics graphics, String string, int n, int n2, int n3, int n4) {
        graphics.setFont(a.g.a);
        graphics.setClip(0, 0, 240, 320);
        graphics.setColor(n3);
        graphics.drawString(string, n, n2, 33);
    }

    public static void a(Graphics graphics, String string, String string2) {
        if (string != null) {
            a.d.b(graphics, string, 3, 320 - a.g.b, 15597476, 6362880, 20);
        }
        if (string2 != null) {
            a.d.b(graphics, string2, 240 - a.g.a.stringWidth(string2) - 2, 320 - a.g.b, 15597476, 6362880, 20);
        }
    }

    public static void a(Graphics graphics, String[] stringArray, int n, int n2, Image image, Image image2) {
        n = 0;
        n2 = 270 / (a.g.b + 2) - 1;
        j = stringArray.length % n2 == 0 ? stringArray.length / n2 : stringArray.length / n2 + 1;
        n = (i + 1) * n2 >= stringArray.length ? stringArray.length - n2 * i : n2;
        a.h.a(graphics, 0);
        if (image != null) {
            a.h.a(graphics, image, 0, 0);
        }
        graphics.setFont(a.g.a);
        for (int i = 0; i < n; ++i) {
            graphics.setColor(0xFFFFFF);
            graphics.drawString(stringArray[i + a.d.i * n2], 120, 50 + i * (a.g.b + 2), 17);
        }
        a.d.a(graphics, i + 1 + "/" + j, "\u041d\u0430\u0437\u0430\u0434");
    }

    public static void g() {
        if (i > 0) {
            --i;
        }
    }

    public static void h() {
        if (i < j - 1) {
            ++i;
        }
    }

    public static void i() {
        i = 0;
    }

    public static void a(Graphics graphics, String[] stringArray, int[] nArray, String[] stringArray2, int n, int n2, int n3, int n4) {
        if (stringArray == null) {
            return;
        }
        if (stringArray.length < n4) {
            n4 = stringArray.length;
        }
        a.h.a(graphics, 12, n2, n3, n4 * (a.g.b + 4) + 4, 6907220, 14593146);
        a.h.a(graphics, 14, n2 + 1, n3 - 4, n4 * (a.g.b + 4) + 2, 14593146, 16708041);
        for (n = 0; n < n4; ++n) {
            graphics.setColor(13549230);
            graphics.fillRect(16, n2 + 4 + n * (a.g.b + 4), n3 - 12, (int)a.g.b);
            if (stringArray != null) {
                if (n == k) {
                    a.d.b(graphics, stringArray[n + l], 17, n2 + 4 + n * (a.g.b + 4), 16433179, 7366729, 20);
                } else {
                    a.d.b(graphics, stringArray[n + l], 17, n2 + 4 + n * (a.g.b + 4), 15597476, 7366729, 20);
                }
            }
            if (nArray != null) {
                if (n == k) {
                    a.d.b(graphics, String.valueOf(nArray[n + l]), n3 + 12 - 10 - a.g.a.stringWidth(String.valueOf(nArray[n + l])), n2 + 4 + n * (a.g.b + 4), 16433179, 7366729, 20);
                } else {
                    a.d.b(graphics, String.valueOf(nArray[n + l]), n3 + 12 - 10 - a.g.a.stringWidth(String.valueOf(nArray[n + l])), n2 + 4 + n * (a.g.b + 4), 15597476, 7366729, 20);
                }
            }
            if (stringArray2 == null) continue;
            if (n == k) {
                a.d.b(graphics, stringArray2[n + l], n3 + 12 - 10 - a.g.a.stringWidth(stringArray2[n + l]), n2 + 4 + n * (a.g.b + 4), 16433179, 7366729, 20);
                continue;
            }
            a.d.b(graphics, stringArray2[n + l], n3 + 12 - 10 - a.g.a.stringWidth(stringArray2[n + l]), n2 + 4 + n * (a.g.b + 4), 15597476, 7366729, 20);
        }
        a.h.a(graphics, n3 + 12 - 6, n2 + 2, 4, n4 * (a.g.b + 4), 3022349, 7085131);
        a.h.a(graphics, n3 + 12 - 7, n2 + 2 + (l + k) * n4 * (a.g.b + 4) / stringArray.length, 6, n4 * (a.g.b + 4) / stringArray.length, 3022349, 14918185);
        graphics.setColor(7085131);
        graphics.fillArc(22 + a.g.a.stringWidth(stringArray[l + k]), n2 + 4 + k * (a.g.b + 4) + (a.g.b - 10 >> 1), 10, 10, 0, 360);
        graphics.setColor(4243435);
        graphics.fillArc(23 + a.g.a.stringWidth(stringArray[l + k]), n2 + 5 + k * (a.g.b + 4) + (a.g.b - 9 >> 1), 8, 8, 0, 360);
        if (m) {
            if (k > 0) {
                --k;
            } else if (k == 0 && l > 0) {
                --l;
            }
            m = false;
        }
        if (a.d.n) {
            if (k < n4 - 1) {
                ++k;
            } else if (k == n4 - 1 && l + k < stringArray.length - 1) {
                ++l;
            }
            a.d.n = false;
        }
    }

    public static void j() {
        m = true;
    }

    public static void k() {
        n = true;
    }

    public static void l() {
        k = 0;
        l = 0;
    }

    public static int m() {
        return l + k;
    }

    public static final String[] a(String objectArray, int n) {
        Vector<String> vector = new Vector<String>();
        int n2 = 0;
        int n3 = 0;
        int n4 = objectArray.length();
        while (n3 <= n4) {
            if (n3 - n2 >= n) {
                vector.addElement(objectArray.substring(n2, n3));
                n2 = n3;
            } else {
                n3 += n;
            }
            if (n3 <= n4) continue;
            vector.addElement(objectArray.substring(n2, n4));
        }
        objectArray = new String[vector.size()];
        vector.copyInto(objectArray);
        return objectArray;
    }

    static {
        i = 0;
        k = 0;
        l = 0;
        m = false;
        n = false;
    }
}

