/*
 * Decompiled with CFR 0.152.
 */
package main;

import main.c;
import main.cMIDlet;
import main.d;
import main.e;
import main.f;

public final class a {
    public static int a = 0;
    public static int b = 0;
    private static d[] i;
    private static short[] j;
    private static boolean[] k;
    static d[] c;
    private static d l;
    static int d;
    static c[] e;
    private static byte[] m;
    private static byte[] n;
    private static byte[] o;
    private static int[] p;
    private static int[][] q;
    private static int r;
    private static int s;
    static boolean f;
    private static int t;
    private static int u;
    static int g;
    static int h;
    private static int v;
    private static int w;

    public a() {
        i = new d[100];
        j = new short[100];
        k = new boolean[100];
        for (int i = 0; i < 100; ++i) {
            main.a.i[i] = new d();
            main.a.j[i] = -1;
            main.a.k[i] = false;
        }
    }

    private static d b(int n) {
        d d2;
        d d3;
        block1: {
            int n2 = n;
            for (int i = 0; i < 100; ++i) {
                if (k[i]) continue;
                main.a.j[i] = (short)n2;
                main.a.k[i] = true;
                main.a.i[i].a();
                d3 = main.a.i[i];
                break block1;
            }
            d3 = null;
        }
        main.a.c[n] = d2 = d3;
        System.arraycopy(main.a.n, 0, m, 0, main.a.n.length);
        d2.a(m, p[n], n);
        return d2;
    }

    static d a(d d2) {
        for (int i = d - 1; i >= 0; --i) {
            d d3 = c[i];
            if (d3 == null || !d3.a[3] || d3 == d2 || d3.h >= 5 || !d2.a(d3)) continue;
            return d3;
        }
        return null;
    }

    public static void a() {
        int n;
        if (e != null) {
            for (n = 0; n < e.length; ++n) {
                main.a.e[n].a = null;
            }
        }
        if (c != null) {
            for (n = 0; n < d; ++n) {
                if (c[n] == null || n < 5 || main.a.c[n].k != 0) continue;
                main.a.c[n] = null;
            }
        }
        for (n = 0; n < 100; ++n) {
            main.a.j[n] = -1;
            main.a.k[n] = false;
        }
    }

    public final void b() {
        int n;
        for (n = 0; n < e.length; ++n) {
            e[n].a();
        }
        System.arraycopy(main.a.n, 0, m, 0, main.a.n.length);
        System.arraycopy(main.a.n, 0, o, 0, main.a.n.length);
        l.a();
        for (n = 0; n < 5; ++n) {
            c[n].a();
        }
        for (n = 0; n < d; ++n) {
            d d2 = c[n];
            if (d2 == null) continue;
            d2.a(m, p[n], n);
        }
        for (n = 0; n < d; ++n) {
            if (!main.a.a(a, b, n) || c[n] != null) continue;
            main.a.b(n);
        }
        main.a.a(true, c[main.f.d]);
        c[main.f.c].a(true);
    }

    public static int a(byte[] byArray, int n) {
        main.a.n = new byte[n];
        o = new byte[n];
        m = new byte[n];
        System.arraycopy(byArray, 0, m, 0, n);
        System.arraycopy(m, 0, main.a.n, 0, n);
        d = n / 19;
        p = new int[d];
        q = new int[d][];
        c = new d[d];
        n = 0;
        for (int i = 0; i < d; ++i) {
            main.a.p[i] = n;
            if (i < 5) {
                main.a.c[i] = new d();
            } else if ((m[i * 19 + 2] & 0x10) != 0) {
                main.a.c[i] = new d();
                main.a.c[i].k = 1;
            }
            main.a.q[i] = new int[4];
            main.a.q[i][0] = main.f.a(m, n + 7) - 150;
            main.a.q[i][1] = main.f.a(m, n + 9) - 150;
            main.a.q[i][2] = main.f.a(m, n + 7) + 150;
            main.a.q[i][3] = main.f.a(m, n + 9) + 150;
            n += 19;
        }
        return 0;
    }

    public static void c() {
        int n;
        int n2;
        d d2;
        int n3;
        if (a.c.e) {
            return;
        }
        int[] nArray = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        int n4 = 0;
        for (n3 = d - 1; n3 >= 0; --n3) {
            d2 = c[n3];
            if (d2 == null || !d2.a[3]) continue;
            if (d2.h == 8 && d2.g == 0 || d2.h == 4 && d2.g == 1 || d2.h == 4 && d2.g == 3 || d2.h == 59 && (d2.g == 7 || d2.g == 12) || d2.h == 61 && d2.g == 6 || d2.h == 62 && (d2.g == 7 || d2.g == 9) || d2.h == 63 && (d2.g == 7 || d2.g == 9) || d2.h == 64 && (d2.g == 7 || d2.g == 9) || d2.h == 65 && d2.g >= 11 && d2.g <= 17 || d2.h == 66 && (d2.g == 8 || d2.g == 10)) {
                nArray[n4] = n3;
                ++n4;
                continue;
            }
            n2 = a;
            n = b;
            d2.a(n2, n);
        }
        for (n3 = 0; n3 < nArray.length; ++n3) {
            if (nArray[n3] <= 0 || (d2 = c[nArray[n3]]) == null || !d2.a[3]) continue;
            n2 = a;
            n = b;
            d2.a(n2, n);
        }
        main.f.g.setClip(0, 0, 240, 320);
    }

    private static boolean a(int n, int n2, int n3) {
        return n <= q[n3][2] && n2 <= q[n3][3] && n + 240 >= q[n3][0] && n2 + 320 >= q[n3][1];
    }

    public final void a(boolean bl) {
        block0: for (int i = d - 1; i >= 0; --i) {
            d d2 = c[i];
            if (main.a.a(a, b, i)) {
                if (d2 == null) {
                    d2 = main.a.b(i);
                }
            } else if (d2 != null && i >= 5 && !d2.a[2] && !d2.equals(l)) {
                int n = i;
                int n2 = p[n];
                byte[] byArray = m;
                d d3 = c[n];
                ++n2;
                ++n2;
                int n3 = 0;
                if (d3.a[0]) {
                    n3 = 1;
                }
                if (d3.a[1]) {
                    n3 = (byte)(n3 + 2);
                }
                if (d3.a[2]) {
                    n3 = (byte)(n3 + 4);
                }
                if (d3.a[3]) {
                    n3 = (byte)(n3 + 8);
                }
                byArray[n2] = n3;
                main.a.c[n] = null;
                int n4 = n;
                for (int j = 0; j < 100; ++j) {
                    if (main.a.j[j] != n4) continue;
                    main.a.k[j] = false;
                    main.a.i[j].a();
                    continue block0;
                }
                continue;
            }
            if (d2 == null || !bl) continue;
            d2.b();
        }
        main.a.a(false, c[main.f.d]);
    }

    private static int b(int n, int n2) {
        if (Math.abs(n) > Math.abs(n2)) {
            if (n2 != 0 && n / n2 > 0) {
                n -= n2;
            }
            if (n > 0) {
                n = n < 8 ? 1 : (n < 16 ? 2 : (n < 32 ? 4 : (n < 64 ? 8 : (n < 128 ? 16 : 32))));
                if (n2 > 0) {
                    n += n2;
                }
            } else {
                n = n > -8 ? -1 : (n > -16 ? -2 : (n > -32 ? -4 : (n > -64 ? -8 : (n > -128 ? -16 : -32))));
                if (n2 < 0) {
                    n += n2;
                }
            }
        }
        return n;
    }

    static void b(boolean n) {
        System.arraycopy(o, 0, m, 0, m.length);
        for (n = 0; n < d; ++n) {
            if (c[n] == null || c[n].equals(c) || n < 5 || main.a.c[n].k != 0) continue;
            main.a.c[n] = null;
            main.a.k[n] = false;
        }
        if (l != null) {
            main.a.l.a[3] = false;
        }
    }

    static void a(int n) {
        s %= 2;
        r %= 2;
        s += (n <<= 1);
        r += n;
    }

    public static void a(int n, int n2) {
        if (n == -1 && n2 == -1) {
            g = a;
            h = a;
        } else {
            g = n;
            if (g < 0) {
                g = 0;
            }
            if ((h = n2 - 240) > a.c.a * a.c.c - 240) {
                h = a.c.a * a.c.c - 240;
            }
        }
        f = true;
    }

    public static void d() {
        g = 0;
        h = a.c.a * a.c.c - 240;
        v = 0;
        w = a.c.b * a.c.c - 320;
        f = false;
    }

    /*
     * WARNING - void declaration
     */
    private static void a(boolean bl, d d2) {
        void n3;
        int n = 0;
        int n2 = 0;
        n = (n3.c >> 8) - 120;
        n2 = (n3.d >> 8) - 160;
        if (n3.h < 5) {
            n += n3.i - a;
            n2 += n3.j - b;
        } else {
            n -= a;
            n2 -= b;
        }
        if (bl) {
            a += n;
            b += n2;
        } else {
            int n4 = main.a.b(n, n3.e >> 8);
            int n5 = main.a.b(n2, n3.f >> 8);
            a += n4;
            b += n5;
            if (r > 0) {
                b += r % 2 != 1 ? -12 : 12;
                --r;
            }
            if (s > 0) {
                a += s % 2 != 1 ? -12 : 12;
                --s;
            }
        }
        if (a < g) {
            a = g;
        }
        if (main.a.c[main.f.c].c >> 8 < g + 16 && main.a.c[main.f.c].l) {
            main.a.c[main.f.c].c = g + 16 << 8;
        }
        if (a > h) {
            a = h;
            if (main.a.c[main.f.c].c >> 8 >= h + 240 - 16 && main.a.c[main.f.c].l) {
                main.a.c[main.f.c].c = h + 240 - 16 << 8;
            }
        }
        if (b < 0) {
            b = 0;
        }
        if (b > w) {
            b = w;
        }
        if (t != a || u != b) {
            t = a;
            u = b;
            main.f.e = true;
        } else {
            main.f.e = false;
        }
        if (main.f.E) {
            if (main.f.K == 610) {
                main.f.f = 0;
                main.f.E = false;
                a.c.e = true;
                main.f.N = true;
                return;
            }
            if (main.f.K == -1) {
                cMIDlet.b.f();
                main.f.f = 0;
                a.c.e = true;
                main.f.E = false;
                return;
            }
            if (main.f.K == 701) {
                cMIDlet.b.e();
                main.f.f = 0;
                a.c.e = true;
                main.f.E = false;
                return;
            }
            if (main.f.K == 702) {
                cMIDlet.b.i();
                main.f.f = 0;
                a.c.e = true;
                main.f.E = false;
                return;
            }
            if (main.f.K == 609 && main.e.q(39) > 2) {
                if (!main.e.i(32)) {
                    main.f.f = 0;
                    main.f.E = false;
                    a.c.e = true;
                    main.f.N = true;
                    return;
                }
                main.f.K = 610;
                main.f.f = 0;
                a.c.e = true;
                main.f.E = false;
                main.f.k = 2;
                return;
            }
            main.f.f = 0;
            main.f.E = false;
            a.c.e = true;
            main.f.k = 2;
        }
        if (main.f.C) {
            main.f.K = 0;
            main.f.f = 0;
            a.c.e = true;
            main.e.g = 18;
            main.f.C = false;
            main.f.k = 2;
        }
    }

    static {
        l = new d();
        f = false;
    }
}

