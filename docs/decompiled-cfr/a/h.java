/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.nokia.mid.ui.DirectGraphics
 *  javax.microedition.lcdui.Graphics
 *  javax.microedition.lcdui.Image
 */
package a;

import a.a;
import com.nokia.mid.ui.DirectGraphics;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.f;

public final class h {
    private static int a = 0;
    private static int b = 0;
    private static int c;
    private static int[][] d;
    private static boolean e;

    public static final void a(Graphics graphics, Image image, int n, int n2, int n3, int n4, int n5, int n6) {
        graphics.setClip(n, n2, n3, n4);
        graphics.drawImage(image, n - n5, n2 - n6, 20);
        h.a(graphics, 0, 0, 240, 320);
    }

    public static final void a(Graphics graphics, DirectGraphics directGraphics, Image image, int n, int n2, int n3, int n4, int n5, int n6) {
        graphics.setClip(n, n2, n3, n4);
        directGraphics.drawImage(image, n - n5, n2, 20, 8192);
        h.a(graphics, 0, 0, 240, 320);
    }

    public static final void a(Graphics graphics, Image image, int n, int n2) {
        graphics.setClip(n, n2, image.getWidth(), image.getHeight());
        graphics.drawImage(image, n, n2, 20);
        h.a(graphics, 0, 0, 240, 320);
    }

    public static final void b(Graphics graphics, Image image, int n, int n2, int n3, int n4, int n5, int n6) {
        int n7;
        if (n > 99999999 || n < 0) {
            n = 0;
        }
        int n8 = n3;
        int[] nArray = new int[8];
        int[] nArray2 = nArray;
        nArray[7] = n / 10000000 % 10;
        nArray2[6] = n / 1000000 % 10;
        nArray2[5] = n / 100000 % 10;
        nArray2[4] = n / 10000 % 10;
        nArray2[3] = n / 1000 % 10;
        nArray2[2] = n / 100 % 10;
        nArray2[1] = n / 10 % 10;
        nArray2[0] = n % 10;
        for (n7 = 8; n7 > 1 && nArray2[n7 - 1] <= 0; --n7) {
        }
        if (n6 == 1) {
            n2 -= n7 * n4;
        } else if (n6 == 2) {
            n2 -= n7 * n4 / n6;
        }
        n = n2;
        for (n6 = 0; n6 < n7; ++n6) {
            graphics.setClip(n2 + n6 * n4, n3, n4, n5);
            graphics.drawImage(image, n + (n6 - nArray2[n7 - 1 - n6]) * n4, n8, 20);
        }
        h.a(graphics, 0, 0, 240, 320);
    }

    private static void a(Graphics graphics, int n, int n2, int n3, int n4, int n5) {
        if ((n5 & 0xFF000000) == -16777216) {
            graphics.setColor(n5);
            graphics.fillRect(0, 0, 240, 320);
            return;
        }
        if ((n5 & 0xFF000000) != 0) {
            int[] nArray = new int[240 * 320];
            int[] nArray2 = nArray;
            nArray[0] = n5;
            for (n2 = 1; n2 < nArray2.length; n2 += n3) {
                n3 = n2;
                if (n2 + n3 > nArray2.length) {
                    n3 = nArray2.length - n2;
                }
                System.arraycopy(nArray2, 0, nArray2, n2, n3);
            }
            graphics.drawRGB(nArray2, 0, 240, 0, 0, 240, 320, true);
        }
    }

    public static final boolean a(Graphics graphics, boolean bl, int n) {
        switch (a + 2) {
            case 0: {
                h.a(graphics, 0, 0, 240, 320, 0 | 15 - b << 28 | 15 - b << 24);
                if (b >= 15) {
                    b = 0;
                    ++a;
                    break;
                }
                ++b;
                break;
            }
            case 1: {
                if (!a.a.b(6)) break;
                ++a;
                break;
            }
            case 2: {
                h.a(graphics, 0, 0, 240, 320, 0 | b << 28 | b << 24);
                if (b >= 15) {
                    b = 0;
                    ++a;
                    break;
                }
                ++b;
                break;
            }
            case 3: {
                h.a(graphics, 0, 0, 240, 320, 0 | 15 - b << 28 | 15 - b << 24);
                a = 0;
                return true;
            }
        }
        return false;
    }

    public static final boolean a(Graphics graphics, Image image) {
        h.a(graphics, 0xEAE9E9);
        switch (c) {
            case 0: {
                break;
            }
            case 1: {
                graphics.setClip(-10, 109, 67, 69);
                graphics.drawImage(image, -10, 109, 20);
                break;
            }
            case 2: {
                graphics.setClip(32, 109, 67, 69);
                graphics.drawImage(image, 32, 109, 20);
                break;
            }
            case 3: {
                graphics.setClip(41, 108, 67, 69);
                graphics.drawImage(image, -26, 108, 20);
                break;
            }
            case 4: {
                graphics.setClip(41, 108, 67, 69);
                graphics.drawImage(image, -94, 108, 20);
                break;
            }
            case 5: {
                graphics.setClip(53, 118, 48, 47);
                graphics.drawImage(image, 53, 48, 20);
                break;
            }
            case 6: {
                graphics.setClip(63, 130, 108, 50);
                graphics.drawImage(image, 15, 60, 20);
                break;
            }
            case 7: {
                graphics.setClip(67, 136, 104, 46);
                graphics.drawImage(image, 67, 14, 20);
                break;
            }
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: {
                graphics.setClip(69, 138, 102, 44);
                graphics.drawImage(image, -35, 16, 20);
                break;
            }
            case 13: {
                graphics.setClip(69, 138, 102, 44);
                graphics.drawImage(image, -35, 16, 20);
                c = 0;
                return true;
            }
        }
        if (a.a.b(2)) {
            ++c;
        }
        return false;
    }

    public static final void a(Graphics graphics, int n) {
        graphics.setClip(0, 0, 240, 320);
        graphics.setColor(n);
        graphics.fillRect(0, 0, 240, 320);
    }

    public static final void a(Graphics graphics, int n, int n2, int n3, int n4) {
        graphics.setClip(0, n2, 240, n4);
    }

    public static final void a(Graphics graphics, int n, int n2, int n3, int n4, int n5, int n6) {
        if (n == -1) {
            n = 240 - n3 >> 1;
        }
        Graphics graphics2 = graphics;
        graphics2.setClip(0, 0, 240, 320);
        graphics.setColor(n5);
        graphics.fillRect(n, n2, n3, n4);
        graphics.setColor(n6);
        graphics.fillRect(n + 1, n2 + 1, n3 - 2, n4 - 2);
    }

    public static void a() {
        e = true;
    }

    public static void b() {
        int n;
        if (!e) {
            return;
        }
        for (n = 0; n < d.length; ++n) {
            if (d[n][4] == 0) continue;
            h.a(f.g, f.A, d[n][0], d[n][1], 36, 37, d[n][2] * 36, 0);
            int[] nArray = d[n];
            nArray[2] = nArray[2] + 1;
            int[] nArray2 = d[n];
            nArray2[2] = nArray2[2] % 3;
            h.d[n][3] = 0;
            int[] nArray3 = d[n];
            nArray3[0] = nArray3[0] - 8;
            int[] nArray4 = d[n];
            nArray4[1] = nArray4[1] + 8;
            if (d[n][0] + 36 >= 0 && d[n][1] <= 320) continue;
            h.d[n][4] = 0;
        }
        if (a.a.c(10)) {
            for (n = 0; n < d.length; ++n) {
                if (d[n][4] != 0) continue;
                h.d[n][4] = 1;
                h.d[n][3] = 0;
                h.d[n][0] = a.a.a(24) * 10 + 120;
                h.d[n][1] = -37;
                break;
            }
        }
        if (a.a.b(100)) {
            f.W = true;
            f.E = true;
        }
    }

    static {
        d = new int[10][5];
        e = false;
    }
}

