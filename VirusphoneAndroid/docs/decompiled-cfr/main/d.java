/*
 * Decompiled with CFR 0.152.
 */
package main;

import a.h;
import main.a;
import main.b;
import main.c;
import main.cMIDlet;
import main.e;
import main.f;

public final class d {
    private c m;
    private c n;
    boolean[] a = new boolean[4];
    int[] b = new int[4];
    int c;
    int d;
    private int o;
    private int p;
    int e;
    int f;
    private int q;
    private byte r;
    int g;
    private int s;
    int h;
    private int t;
    private int u;
    private int v;
    private int w;
    private boolean x;
    private boolean y;
    private boolean z;
    private int A;
    private int B;
    private int C;
    private int[] D;
    private int[] E;
    private int F;
    int i = 24;
    private int G = 24;
    int j = -44;
    private int[] H = new int[4];
    int k;
    private int I;
    private int J;
    boolean l;
    private boolean K = false;
    private int L = 0;
    private int M = 0;
    private int N;
    private int O;
    private int P;
    private int Q;
    private int R = 0;
    private int S = 0;
    private int T = 0;

    public d() {
        this.D = new int[2];
        this.E = new int[4];
    }

    public final void a() {
        this.m = null;
        this.n = null;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.t = 0;
        this.u = 0;
        this.v = 0;
        for (int i = 0; i < 4; ++i) {
            this.a[i] = false;
            this.b[i] = 0;
            this.H[i] = 0;
        }
        this.q = 0;
        this.r = 0;
        this.g = -1;
        this.s = 0;
        this.h = 0;
        this.z = false;
        this.I = -1;
        this.x = false;
        this.y = false;
        this.F = 0;
        this.l = true;
    }

    public final void a(byte[] byArray, int n, int n2) {
        this.n = new c();
        this.n.o = false;
        this.n.j = -1;
        this.J = n2;
        this.h = byArray[n++];
        this.m = main.a.e[this.h];
        this.g = byArray[n++];
        this.a[0] = ((n2 = byArray[n++]) & 1) != 0;
        this.a[1] = (n2 & 2) != 0;
        this.a[2] = (n2 & 4) != 0;
        boolean bl = this.a[3] = (n2 & 8) != 0;
        if (main.f.K == 0) {
            if (this.h == 5) {
                this.a[3] = main.e.q(43) >= 3;
            } else if (this.h == 14) {
                this.a[3] = main.e.q(21) >= 3;
            } else if (this.h == 15) {
                this.a[3] = main.e.q(10) >= 3;
            } else if (this.h == 10) {
                this.a[3] = main.e.q(21) < 3;
            }
        } else if (main.f.K == 501) {
            if (this.h == 74) {
                this.a[3] = main.e.q(29) < 4;
            }
        } else if (main.f.K != 610 && main.f.K != 702) {
            if (this.h == 58) {
                this.a[3] = main.e.q(10) < 3;
            } else if (this.h == 59 && this.g != 7 && this.g != 12) {
                this.a[3] = main.e.q(43) < 3;
            } else if (this.h == 60) {
                this.a[3] = main.e.q(21) < 3;
            } else if (this.h == 61 && this.g != 6 && this.g != 2) {
                this.a[3] = main.e.q(24) < 3;
            } else if (this.h == 10 && main.f.K != 609) {
                this.a[3] = main.e.q(24) < 3;
            }
        }
        this.i = this.a[0] ? -this.G : this.G;
        this.A = byArray[n++];
        if (this.A < 0) {
            this.A += 256;
        }
        this.B = this.h == 8 ? this.A : main.e.e(this.A, this.h);
        this.C = byArray[n++];
        this.D[0] = byArray[n++];
        this.D[1] = byArray[n++];
        this.c = main.f.a(byArray, n) << 8;
        this.d = main.f.a(byArray, n += 2) << 8;
        this.o = main.f.a(byArray, n += 2) << 8;
        this.p = main.f.a(byArray, n += 2) << 8;
        n += 2;
        for (n2 = 0; n2 < 4; ++n2) {
            this.E[n2] = byArray[n + n2];
        }
        if (main.f.K != 701 && main.f.K != 702 && main.f.K != 610) {
            if (main.e.g == 0) {
                if (this.J == main.f.c) {
                    this.a[3] = true;
                    if (main.f.P) {
                        main.a.c[main.f.c].c = main.e.S;
                        main.a.c[main.f.c].d = main.e.T;
                    }
                }
            } else if (this.J == main.e.g) {
                main.a.c[main.f.c].c = this.c;
                main.a.c[main.f.c].d = this.d;
                this.a[3] = true;
            }
        }
        if (this.h == 0 && this.g == 0) {
            main.f.g();
        } else {
            this.c(this.g, 1);
        }
        this.j = this.b[1];
        this.l = true;
    }

    public final void a(int n, int n2) {
        Object object;
        int n3;
        if (this.h == 6) {
            return;
        }
        if (this.h < 5 || this.k == 1 || main.d.b(this)) {
            n = (this.c >> 8) - n;
            n2 = (this.d >> 8) - n2;
            n3 = this.j;
            int n4 = n2;
            int n5 = n;
            object = this.n;
            if (((c)object).j > 4) {
                if (((c)object).j < main.e.Y.length) {
                    a.d.a(main.f.g, main.e.Y[((c)object).j], n5, n4 + n3, 0xFFFFFF, 33);
                }
            } else if (((c)object).j >= 0 && main.e.X[0] > 0) {
                a.d.a(main.f.g, main.e.h[main.e.X[0] * 3], n5, n4 + n3 - 6, 0xFFFF00, 33);
            }
            int n6 = n;
            int n7 = n2;
            n2 = this.q;
            n = this.a[1];
            n3 = this.a[0];
            n4 = n7;
            n5 = n6;
            object = this.m;
            byte[] byArray = ((c)object).e[n2];
            int n8 = ((c)object).a.getWidth();
            int n9 = ((c)object).a.getHeight();
            for (int i = 0; i < byArray.length; i += 4) {
                int n10;
                int n11;
                int n12 = (byArray[i] & 0xFF) << 2;
                int n13 = byArray[i + 1] & 0xFF;
                int n14 = ((c)object).c[n12] & 0xFF;
                int n15 = ((c)object).c[n12 + 1] & 0xFF;
                int n16 = ((c)object).c[n12 + 2] & 0xFF;
                n12 = ((c)object).c[n12 + 3] & 0xFF;
                if (n14 + n16 > n8) {
                    n16 = n8 - n14;
                }
                if (n15 + n12 > n9) {
                    n12 = n9 - n15;
                }
                if (n16 <= 0 || n12 <= 0) continue;
                int n17 = n5;
                int n18 = n4;
                if (n3 != 0) {
                    n17 -= byArray[i + 2];
                    n13 ^= 1;
                } else {
                    n17 += byArray[i + 2];
                }
                if (n != 0) {
                    n18 -= byArray[i + 3];
                    n13 ^= 2;
                } else {
                    n18 += byArray[i + 3];
                }
                if ((n13 & 4) != 0) {
                    if ((n13 & 1) == 0) {
                        n17 -= n12;
                    }
                    if ((n13 & 2) != 0) {
                        n18 -= n16;
                    }
                    n11 = n12;
                    n10 = n16;
                } else {
                    if ((n13 & 1) != 0) {
                        n17 -= n16;
                    }
                    if ((n13 & 2) != 0) {
                        n18 -= n12;
                    }
                    n11 = n16;
                    n10 = n12;
                }
                switch (n13) {
                    case 1: {
                        n13 = 8192;
                        n14 = n8 - n14 - n16;
                        break;
                    }
                    case 2: {
                        n13 = 16384;
                        n15 = n9 - n15 - n12;
                        break;
                    }
                    case 3: {
                        n13 = 180;
                        n14 = n8 - n14 - n16;
                        n15 = n9 - n15 - n12;
                        break;
                    }
                    case 4: {
                        n13 = 270;
                        n16 = n14;
                        n14 = n9 - n15 - n12;
                        n15 = n16;
                        break;
                    }
                    case 5: {
                        n13 = 8462;
                        n12 = n14;
                        n14 = n15;
                        n15 = n12;
                        break;
                    }
                    case 6: {
                        n13 = 16654;
                        int n19 = n14;
                        n14 = n9 - n15 - n12;
                        n15 = n8 - n19 - n16;
                        break;
                    }
                    case 7: {
                        n13 = 90;
                        n12 = n14;
                        n14 = n15;
                        n15 = n8 - n12 - n16;
                        break;
                    }
                    default: {
                        n13 = 0;
                    }
                }
                if (n18 + n10 < 0 || n18 >= 320) continue;
                if (n18 < 0) {
                    main.f.g.setClip(n17, 0, n11, n10 + n18);
                    main.f.g.clipRect(n17, 0, n11, n10 + n18);
                } else if (n18 + n10 > 320) {
                    main.f.g.setClip(n17, n18, n11, 320 - n18);
                    main.f.g.clipRect(n17, n18, n11, 320 - n18);
                } else {
                    main.f.g.setClip(n17, n18, n11, n10);
                    main.f.g.clipRect(n17, n18, n11, n10);
                }
                if (n13 == 0) {
                    main.f.g.drawImage(((c)object).a, n17 - n14, n18 - n15, 20);
                    continue;
                }
                main.f.h.drawImage(((c)object).a, n17 - n14, n18 - n15, 20, n13);
            }
            Object object2 = object = this.n;
            object2 = object;
            if (((c)object2).t) {
                switch (((c)object2).s) {
                    case 0: {
                        if (((c)object2).u) {
                            a.h.a(main.f.g, main.f.n, ((c)object2).q - main.a.a, ((c)object2).r - main.a.b, 75, 75, 0, 0);
                            break;
                        }
                        a.h.a(main.f.g, main.f.h, main.f.n, ((c)object2).q - main.a.a, ((c)object2).r - main.a.b, 75, 75, 154, 0);
                        break;
                    }
                    case 1: {
                        if (((c)object2).u) {
                            a.h.a(main.f.g, main.f.n, ((c)object2).q - 5 - main.a.a, ((c)object2).r - 5 - main.a.b, 42, 75, 75, 0);
                            break;
                        }
                        a.h.a(main.f.g, main.f.h, main.f.n, ((c)object2).q + 38 - main.a.a, ((c)object2).r - 5 - main.a.b, 42, 75, 112, 0);
                        break;
                    }
                    case 2: {
                        if (((c)object2).u) {
                            a.h.a(main.f.g, main.f.n, ((c)object2).q - 6 - main.a.a, ((c)object2).r - 8 - main.a.b, 53, 75, 117, 0);
                            break;
                        }
                        a.h.a(main.f.g, main.f.h, main.f.n, ((c)object2).q + 29 - main.a.a, ((c)object2).r - 8 - main.a.b, 53, 75, 59, 0);
                        break;
                    }
                    case 3: {
                        if (((c)object2).u) {
                            a.h.a(main.f.g, main.f.n, ((c)object2).q - 12 - main.a.a, ((c)object2).r - 15 - main.a.b, 59, 75, 170, 0);
                            break;
                        }
                        a.h.a(main.f.g, main.f.h, main.f.n, ((c)object2).q + 19 - main.a.a, ((c)object2).r - 15 - main.a.b, 59, 75, 0, 0);
                    }
                }
                ++((c)object2).s;
                if (((c)object2).s > 3) {
                    ((c)object2).t = false;
                }
            }
            object2 = object;
            if (((c)object2).o) {
                switch (((c)object2).m) {
                    case 0: 
                    case 1: {
                        if (!((c)object2).p) {
                            a.h.b(main.f.g, main.f.o[1], ((c)object2).n, ((c)object2).k - main.a.a, ((c)object2).l - 10 - main.a.b, 18, 25, 2);
                            break;
                        }
                        a.h.a(main.f.g, main.f.p, ((c)object2).k - 43 - main.a.a, ((c)object2).l - 45 + 29 - main.a.b, 86, 45, 0, 0);
                        a.h.b(main.f.g, main.f.o[1], ((c)object2).n, ((c)object2).k - main.a.a, ((c)object2).l - 10 - main.a.b, 18, 25, 2);
                        break;
                    }
                    case 2: {
                        if (((c)object2).p) {
                            a.h.a(main.f.g, main.f.p, ((c)object2).k - 31 - main.a.a, ((c)object2).l - 30 + 21 - main.a.b, 62, 30, 0, 45);
                        }
                        a.h.b(main.f.g, main.f.o[0], ((c)object2).n, ((c)object2).k - main.a.a, ((c)object2).l - 8 - main.a.b, 13, 18, 2);
                        break;
                    }
                    case 3: {
                        if (((c)object2).p) {
                            a.h.a(main.f.g, main.f.p, ((c)object2).k - 31 - main.a.a, ((c)object2).l - 30 + 17 - main.a.b, 62, 30, 0, 45);
                        }
                        a.h.b(main.f.g, main.f.o[0], ((c)object2).n, ((c)object2).k - main.a.a, ((c)object2).l - 12 - main.a.b, 13, 18, 2);
                        break;
                    }
                    case 4: {
                        if (((c)object2).p) {
                            a.h.a(main.f.g, main.f.p, ((c)object2).k - 31 - main.a.a, ((c)object2).l - 30 + 13 - main.a.b, 62, 30, 0, 45);
                        }
                        a.h.b(main.f.g, main.f.o[0], ((c)object2).n, ((c)object2).k - main.a.a, ((c)object2).l - 16 - main.a.b, 13, 18, 2);
                    }
                }
                ++((c)object2).m;
                if (((c)object2).m > 4) {
                    ((c)object2).o = false;
                }
            }
        }
        if (main.f.k == 7 && !main.f.L && !main.f.T) {
            int n20;
            boolean bl = false;
            object = this;
            if (((d)object).q == -1) {
                n20 = -1;
            } else if (((d)object).r < 0) {
                n20 = -1;
            } else {
                ((d)object).r = (byte)(((d)object).r + 1);
                n = ((d)object).s;
                n3 = ((d)object).g;
                c c2 = ((d)object).m;
                if (((d)object).r < (n3 < 0 || n3 >= c2.g.length ? -1 : (n < 0 || n >= c2.g[n3] ? -1 : c2.f[n3][(n << 1) + 1]))) {
                    n20 = ((d)object).q;
                } else {
                    ++((d)object).s;
                    if (((d)object).s >= ((d)object).m.g[((d)object).g]) {
                        ((d)object).s = 0;
                        ((d)object).y = true;
                    }
                    ((d)object).q = ((d)object).m.a(((d)object).g, ((d)object).s) & 0xFF;
                    ((d)object).r = 0;
                    n20 = ((d)object).q;
                }
            }
        }
    }

    private boolean c() {
        return this.y;
    }

    private boolean d() {
        if (this.o == 0 && this.p == 0) {
            return false;
        }
        return this.c <= this.o && !this.a[0] || this.c >= this.p && this.a[0];
    }

    private static boolean a(int n, boolean bl) {
        return (n += bl ? 16 : -16) >= main.a.h + 240 && bl || n <= main.a.g && !bl;
    }

    private boolean c(boolean bl) {
        return this.b(-1, true) && !bl || this.b(1, true) && bl;
    }

    private boolean d(boolean bl) {
        return !this.l(bl) || this.c(this.a[0]) || main.d.a(this.c >> 8, this.a[0]);
    }

    private void e() {
        this.L = 0;
        this.M = a.a.a(5) * 20 + 20;
    }

    private boolean f() {
        ++this.L;
        if (this.L >= this.M) {
            this.L = 0;
            return true;
        }
        return false;
    }

    public final void b(int n, int n2) {
        if (main.f.c == n) {
            this.c(n2, 1);
            return;
        }
        main.f.d = main.f.c = n;
        d d2 = main.a.c[main.f.c];
        d2.a[0] = this.a[0];
        d2.a[1] = this.a[1];
        d2.a[2] = this.a[2];
        d2.a[3] = this.a[3];
        d2.c = this.c;
        d2.d = this.d;
        d2.i = this.i;
        d2.c(n2, 1);
        this.a[2] = false;
        this.a[3] = false;
        this.g = -1;
        d2.n.o = this.n.o;
        d2.n.m = this.n.m;
        d2.n.k = this.n.k;
        d2.n.l = this.n.l;
        d2.n.n = this.n.n;
        d2.n.p = this.n.p;
        if (d2.n.p) {
            d2.n.l -= 15;
        }
        this.n.o = false;
    }

    private void d(int n, int n2) {
        main.e.t(this.h);
        main.e.K(this.A);
        main.e.a();
        if (this.h == 35) {
            if (main.e.q(8) == 3 && main.e.F[2] == 0) {
                main.f.b(26, 0);
                main.e.F[2] = (byte)(main.e.F[2] + 1);
            }
        } else if (this.h == 36) {
            if (main.e.q(29) == 3 && main.e.F[5] == 0) {
                main.f.b(47, 0);
                main.e.F[5] = (byte)(main.e.F[5] + 1);
            }
            main.a.d();
        }
        this.I = this.h;
        this.h = 23;
        this.m = main.a.e[this.h];
        this.c(0, 1);
    }

    private static boolean b(d d2) {
        return (d2.c >> 8) + d2.b[0] <= main.a.a + 240 && (d2.c >> 8) + d2.b[2] >= main.a.a && (d2.d >> 8) + d2.b[1] <= main.a.b + 320 && (d2.d >> 8) + d2.b[3] >= main.a.b;
    }

    private static boolean c(d d2) {
        return (d2.c >> 8) + d2.b[0] <= main.a.a + 240 + 120 && (d2.c >> 8) + d2.b[2] >= main.a.a - 120 && (d2.d >> 8) + d2.b[1] <= main.a.b + 320 + 160 && (d2.d >> 8) + d2.b[3] >= main.a.b - 160;
    }

    /*
     * Unable to fully structure code
     */
    public final boolean b() {
        block273: {
            if (!(this.a[3] || this.h == 4 && this.g == 1 && main.e.l || this.h == 4 && this.g == 3 && main.e.m)) {
                return false;
            }
            if (this.q == -1) {
                return false;
            }
            if (this.h >= 5 && this.k != 1 && !main.d.c(this)) {
                return false;
            }
            if (main.f.L) {
                return false;
            }
            this.n.j = this.h;
            if (this.F > 0) {
                --this.F;
            }
            switch (this.h) {
                default: {
                    break;
                }
                case 0: 
                case 1: 
                case 2: 
                case 3: 
                case 4: 
                case 7: 
                case 10: 
                case 12: 
                case 22: 
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
                case 35: 
                case 36: 
                case 37: 
                case 38: 
                case 39: 
                case 40: 
                case 41: 
                case 42: 
                case 43: 
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
                case 64: 
                case 65: 
                case 66: 
                case 67: {
                    this.a(false);
                }
            }
            this.e += this.t;
            this.f += this.u;
            if (this.f > 4096) {
                this.f = 4096;
            }
            block3 : switch (this.h) {
                case 0: {
                    if (main.f.F) {
                        main.f.F = false;
                    }
                    if (main.f.H > 0) {
                        --main.f.H;
                    }
                    if (main.e.M > 0 && this.g != 7 && this.g != 1 && this.g != 2 && this.g != 18) {
                        var1_1 = this.e(false);
                        if (var1_1 == -1) {
                            main.f.a(1, -1);
                            this.z = true;
                            if (this.h(true)) {
                                this.e(true);
                                this.c(7, 1);
                                main.f.a(1234, -1);
                                break;
                            }
                        } else if (var1_1 == 1) {
                            main.f.a(3, -1);
                            this.z = true;
                            if (this.g(true)) {
                                this.e(true);
                                if (this.g >= 4 && this.g <= 6 || this.g == 17) {
                                    this.c(7, 1);
                                    main.f.a(1234, -1);
                                    break;
                                }
                                if (this.g == 19) break;
                                this.c(19, 1);
                                break;
                            }
                        } else if (this.z) {
                            main.f.a(-1, -1);
                            this.z = false;
                        }
                    }
                    var1_1 = 0;
                    var1_1 = this.g;
                    if (var1_1 >= 31 && var1_1 <= 41) {
                        var1_1 = 0;
                    } else if (var1_1 >= 20 && var1_1 <= 30) {
                        var1_1 = 3;
                    }
                    switch (var1_1) {
                        case 0: {
                            if (this.k(true) && ++this.v > 2) {
                                var1_1 = this.G;
                                var3_15 = main.e.H[main.e.I];
                                var2_22 = this;
                                var4_28 = main.f.j;
                                if ((var4_28 & 4112) != 0) {
                                    var2_22.a[0] = true;
                                    var2_22.i = -var1_1;
                                } else if ((var4_28 & 8256) != 0) {
                                    var2_22.i = var1_1;
                                    var2_22.a[0] = false;
                                }
                                var2_22.v = 0;
                                var2_22.c(var3_15, 1);
                                this.I = 0;
                                break;
                            }
                            if (this.k(false)) {
                                this.b(this.i(true));
                                this.c(this.g, 1);
                                this.I = 0;
                                break;
                            }
                            if (this.h(true)) {
                                this.c(4, 1);
                                break;
                            }
                            if (this.f(true)) {
                                this.b(main.e.I / 4 + 1, main.e.I % 4 * 3);
                                main.f.I = this.a[0];
                                break;
                            }
                            var2_23 = this;
                            var4_29 = false;
                            var1_2 = var2_23;
                            if (!(main.e.M < 0 || main.f.L != false || main.f.D != false ? false : main.d.b(var1_3 = main.f.i) == false && (var1_3 & 512) != 0) || main.e.r < 0 || main.f.Y != 0) ** GOTO lbl122
                            switch (main.e.r) {
                                case 0: {
                                    if (!main.e.l && main.e.H(20)) {
                                        var2_23.b(4, 0);
                                        main.f.e(2);
                                        break;
                                    }
                                    ** GOTO lbl164
                                }
                                case 1: {
                                    if (!main.e.m && main.e.H(40)) {
                                        main.e.m = true;
                                        main.e.o = 0;
                                        var2_23.b(4, 2);
                                        main.f.G = false;
                                        for (var3_16 = 0; var3_16 < main.e.n.length; ++var3_16) {
                                            main.e.n[var3_16] = 0;
                                        }
                                        main.f.e(2);
                                        break;
                                    }
                                    ** GOTO lbl164
                                }
                                case 2: {
                                    if (main.e.H(1)) {
                                        main.f.a(-1, -1);
                                        var2_23.b(4, 5);
                                    } else {
                                        break;
                                    }
                                }
                            }
                            ** GOTO lbl164
lbl122:
                            // 1 sources

                            var4_29 = false;
                            var1_4 = var2_23;
                            if (!(main.e.M < 0 || main.f.L != false || main.f.D != false ? false : main.d.b(var1_5 = main.f.i) == false && (var1_5 & 128) != 0) || main.e.q < 0 || main.f.X != 0) ** GOTO lbl149
                            switch (main.e.q) {
                                case 0: {
                                    if (!main.e.l && main.e.H(20)) {
                                        var2_23.b(4, 0);
                                        main.f.e(1);
                                        break;
                                    }
                                    ** GOTO lbl164
                                }
                                case 1: {
                                    if (!main.e.m && main.e.H(40)) {
                                        main.e.m = true;
                                        main.e.o = 0;
                                        var2_23.b(4, 2);
                                        main.f.G = false;
                                        for (var3_17 = 0; var3_17 < main.e.n.length; ++var3_17) {
                                            main.e.n[var3_17] = 0;
                                        }
                                        main.f.e(1);
                                        break;
                                    }
                                    ** GOTO lbl164
                                }
                                case 2: {
                                    if (main.e.H(1)) {
                                        main.f.a(-1, -1);
                                        var2_23.b(4, 5);
                                    } else {
                                        break;
                                    }
                                }
                            }
                            ** GOTO lbl164
lbl149:
                            // 1 sources

                            var4_29 = false;
                            var1_6 = var2_23;
                            if ((main.e.M < 0 || main.f.L != false || main.f.D != false ? false : main.d.b(var1_7 = main.f.i) == false && (var1_7 & 2) != 0) && main.e.s >= 0) {
                                main.e.m(main.e.s);
                                if (!main.e.i(main.e.s)) {
                                    main.e.s = -1;
                                }
                            } else {
                                var4_29 = false;
                                var1_8 = var2_23;
                                if ((main.e.M < 0 || main.f.L != false || main.f.D != false ? false : main.d.b(var1_9 = main.f.i) == false && (var1_9 & 8) != 0) && main.e.t >= 0) {
                                    main.e.m(main.e.t);
                                    if (!main.e.i(main.e.t)) {
                                        main.e.t = -1;
                                    }
                                }
                            }
lbl164:
                            // 12 sources

                            this.c(1, true);
                            if (this.O >= 3 && this.O != 7 || !this.a(1) || main.d.E()) break;
                            this.c(6, 1);
                            break;
                        }
                        case 3: {
                            if (this.h(true)) {
                                this.c(4, 1);
                                break;
                            }
                            if (!this.k(true) && !main.f.D) {
                                this.c(main.e.G[main.e.I], 1);
                            }
                            if (this.O >= 3 && this.O != 7 || !this.a(1) || main.d.E()) break;
                            this.c(6, 1);
                            break;
                        }
                        case 4: {
                            if (this.f(true) && this.C == 0) {
                                this.C = 1;
                                this.c(42, 1);
                                break;
                            }
                            var1_10 = this;
                            if (!var1_10.y) break;
                            this.c(5, 1);
                            break;
                        }
                        case 5: {
                            if (this.f(true) && this.C == 0) {
                                this.C = 1;
                                this.c(42, 1);
                                break;
                            }
                            if (!this.c()) break;
                            this.c(6, 1);
                            break;
                        }
                        case 6: {
                            var3_18 = var2_24 = this;
                            var1_1 = ((var2_24.c >> 8) + (var3_18.a[0] != false ? var3_18.b[0] : var3_18.b[2])) / a.c.c;
                            var4_30 = ((var3_18.d >> 8) + var3_18.b[1]) / a.c.d;
                            if (a.c.a(var1_1, var4_30 - 1) < 3 && a.c.a(var1_1, var4_30) == 4) {
                                var3_18.c = var3_18.a[0] != false ? (var1_1 + 1) * a.c.c << 8 : var1_1 * a.c.c - 1 << 8;
                                var3_18.d = var4_30 * a.c.d - 1 << 8;
                                v0 = true;
                            } else {
                                v0 = false;
                            }
                            if (v0) {
                                this.c(15, 1);
                                main.f.a(13, -1);
                                break;
                            }
                            if (this.f(true) && this.C == 0) {
                                this.C = 1;
                                this.c(42, 1);
                                break;
                            }
                            if (this.O < 3 || this.O > 6) break;
                            this.C = 0;
                            this.c(8, 1);
                            main.f.a(-1, -1);
                            break;
                        }
                        case 1: {
                            if (!this.h(false)) {
                                this.c(7, 1);
                                main.f.a(1234, -1);
                            }
                            if (!this.a(-1)) break;
                            this.c(18, 1);
                            break;
                        }
                        case 2: {
                            if (!this.g(false)) {
                                this.c(7, 1);
                                main.f.a(1234, -1);
                            }
                            if (!this.a(1)) break;
                            this.c(17, 1);
                            break;
                        }
                        case 7: {
                            if (this.h(true)) {
                                this.c(1, 1);
                                main.f.a(-1, -1);
                                break;
                            }
                            if (this.k(false)) {
                                this.b(this.i(true));
                                this.c(6, 1);
                                main.f.a(-1, -1);
                                break;
                            }
                            if (!this.g(true)) break;
                            this.c(2, 1);
                            main.f.a(-1, -1);
                            break;
                        }
                        case 17: {
                            if (this.f(true) && this.C == 0) {
                                this.C = 2;
                                this.c(42, 1);
                                break;
                            }
                            if (this.O < 3 || this.O > 6) break;
                            this.C = 0;
                            this.c(8, 1);
                            main.f.a(-1, -1);
                            break;
                        }
                        case 8: {
                            if (!this.c()) break;
                            if (main.e.M > 0) {
                                this.c(main.e.G[main.e.I], 1);
                                break;
                            }
                            this.c(13, 1);
                            break;
                        }
                        case 9: 
                        case 10: 
                        case 11: 
                        case 12: {
                            if (this.O < 3 || this.O == 7) {
                                this.c(17, 1);
                                break;
                            }
                            if (!this.c()) break;
                            if (main.e.M > 0) {
                                this.c(main.e.G[main.e.I], 1);
                                break;
                            }
                            this.c(13, 1);
                            break;
                        }
                        case 13: {
                            main.e.M = 0;
                            if (!this.c()) break;
                            ++main.e.i;
                            this.c(14, 1);
                            this.I = 0;
                            break;
                        }
                        case 14: {
                            if (!this.c()) break;
                            if (this.I == 0) {
                                main.b.a(3);
                                ++this.I;
                                break;
                            }
                            if (this.I != 1) break;
                            if (main.e.M > 0) {
                                this.c(main.e.G[main.e.I], 1);
                                break;
                            }
                            main.f.h();
                            this.I = 2;
                            break;
                        }
                        case 15: {
                            if (!this.c()) break;
                            if (this.h(true)) {
                                this.C = 0;
                                this.c(16, 1);
                                main.f.a(-1, -1);
                                break;
                            }
                            if (!this.g(true)) break;
                            this.C = 0;
                            this.d -= this.j << 8;
                            this.c += (this.a[0] != false ? 12 : -12) << 8;
                            this.c(17, 1);
                            main.f.a(-1, -1);
                            break;
                        }
                        case 16: {
                            if (!this.c()) break;
                            this.c += (this.a[0] != false ? -16 : 16) << 8;
                            this.c(main.e.G[main.e.I], 1);
                            break;
                        }
                        case 18: {
                            if (!this.c()) break;
                            this.c(17, 1);
                            break;
                        }
                        case 19: {
                            if (!this.c()) break;
                            this.d += 15360;
                            this.c(7, 1);
                            main.f.a(1234, -1);
                            break;
                        }
                        case 42: {
                            if (!this.c()) break;
                            this.c(6, 1);
                        }
                    }
                    break;
                }
                case 1: 
                case 2: 
                case 3: {
                    if (main.f.H > 0) {
                        --main.f.H;
                    }
                    switch (this.g) {
                        case 0: 
                        case 1: 
                        case 3: 
                        case 4: 
                        case 6: 
                        case 7: 
                        case 9: 
                        case 10: {
                            if (main.f.F && this.f(false)) {
                                main.f.F = false;
                                this.K = true;
                            }
                            if (!this.c()) break;
                            if (this.K) {
                                this.b(main.f.I);
                                this.c(this.g + 1, 1);
                                this.K = false;
                                break;
                            }
                            this.b(0, main.e.G[main.e.I]);
                            break;
                        }
                        case 2: 
                        case 5: 
                        case 8: 
                        case 11: {
                            if (!this.c()) break;
                            this.b(0, main.e.G[main.e.I]);
                        }
                    }
                    break;
                }
                case 4: {
                    if (main.f.H > 0) {
                        --main.f.H;
                    }
                    switch (this.g) {
                        case 0: {
                            if (!this.c()) break;
                            this.b(0, main.e.G[main.e.I]);
                            main.e.l = true;
                            break;
                        }
                        case 1: {
                            this.n.j = -1;
                            if (!this.a[3]) {
                                this.a[3] = main.e.l;
                                this.b(main.a.c[4].a[0]);
                                this.c(1, 1);
                                this.c = main.a.c[4].c + ((this.a[0] != false ? -64 : 64) << 8);
                                this.d = main.a.c[4].d - 8960;
                            }
                            if (main.d.b(this)) break;
                            this.a[3] = false;
                            main.e.l = false;
                            break;
                        }
                        case 2: {
                            if (main.e.m) break;
                            this.b(0, main.e.G[main.e.I]);
                            break;
                        }
                        case 3: {
                            this.n.j = -1;
                            if (!this.a[3]) {
                                if (main.e.o >= 10 || !a.a.c(50)) break;
                                this.a[3] = main.e.m;
                                this.J = main.e.o;
                                this.c = main.e.n[this.J];
                                if (this.c == 0) {
                                    this.c = a.a.a(240) + main.a.a << 8;
                                }
                                this.d = main.a.b << 8;
                                ++main.e.o;
                                this.c(3, 1);
                                break;
                            }
                            if (main.d.b(this)) break;
                            this.a[3] = false;
                            if (this.J < 9) break;
                            main.e.m = false;
                            main.f.G = true;
                            break;
                        }
                        case 4: {
                            this.n.j = -1;
                            if (!this.c()) break;
                            this.c(3, 1);
                            this.a[3] = false;
                            if (this.J < 9) break;
                            main.e.m = false;
                            main.f.G = true;
                            break;
                        }
                        case 5: 
                        case 6: 
                        case 7: 
                        case 8: {
                            if (!this.c()) break;
                            this.c(this.g + 1, 1);
                            if (this.g != 9) break;
                            this.d -= 4096;
                            break;
                        }
                        case 9: {
                            if (this.v++ >= 5) {
                                if (!main.e.H(1)) {
                                    this.b(0, 5);
                                    break;
                                }
                                this.v = 0;
                            }
                            if (this.k(true)) {
                                this.b(this.i(true));
                                this.c(10, 1);
                            }
                            if (this.h(true)) {
                                this.c(11, 1);
                                break;
                            }
                            if (!this.g(true)) break;
                            this.c(12, 1);
                            break;
                        }
                        case 10: {
                            if (this.v++ >= 5) {
                                if (!main.e.H(1)) {
                                    this.b(0, 5);
                                    break;
                                }
                                this.v = 0;
                            }
                            if (this.k(true)) break;
                            this.c(9, 1);
                            break;
                        }
                        case 11: {
                            if (this.v++ >= 5) {
                                if (!main.e.H(1)) {
                                    this.b(0, 5);
                                    break;
                                }
                                this.v = 0;
                            }
                            if (this.h(false)) break;
                            this.c(9, 1);
                            break;
                        }
                        case 12: {
                            if (this.v++ >= 5) {
                                if (!main.e.H(1)) {
                                    this.b(0, 5);
                                    break;
                                }
                                this.v = 0;
                            }
                            if (!this.g(false)) {
                                this.c(9, 1);
                            }
                            if (this.O < 3 || this.O > 6) break;
                            this.b(0, 6);
                            break;
                        }
                        case 13: {
                            if (!this.c()) break;
                            this.b(0, main.e.G[main.e.I]);
                        }
                    }
                    break;
                }
                case 6: {
                    var1_11 = main.a.c[main.f.c];
                    switch (this.g) {
                        case 0: {
                            if (var1_11.g == 9) break;
                            if (this.y()) {
                                if (this.B == 0) {
                                    if (this.I != -1) break;
                                    main.a.c[1].c(6, 1);
                                    ++this.I;
                                    break;
                                }
                                if (this.I != -1) break;
                                main.a.c[2].c(11, 1);
                                ++this.I;
                                break;
                            }
                            if (this.I != 0) break;
                            if (this.B == 0) {
                                main.a.c[1].c(5, 1);
                            } else {
                                main.a.c[2].c(10, 1);
                            }
                            this.I = -1;
                            a.d.a(false);
                            break;
                        }
                        case 1: {
                            if (var1_11.g == 9) break;
                            if (this.y()) {
                                if (this.I != -1) break;
                                main.a.c[3].c(8, 1);
                                ++this.I;
                                break;
                            }
                            if (this.I != 0) break;
                            main.a.c[3].c(7, 1);
                            this.I = -1;
                            a.d.a(false);
                            break;
                        }
                        case 2: {
                            if (var1_11.g == 9) break;
                            if (this.y()) {
                                if (this.I != -1) break;
                                main.a.c[4].c(4, 1);
                                ++this.I;
                                break;
                            }
                            if (this.I != 0) break;
                            main.a.c[4].c(3, 1);
                            this.I = -1;
                            a.d.a(false);
                            break;
                        }
                        case 3: {
                            if (!this.y() || main.a.f) break;
                            this.a[3] = false;
                            main.f.K = this.B;
                            main.f.E = true;
                            break;
                        }
                        case 4: {
                            if (var1_11.g < 4 && this.y()) {
                                if (var1_11.a[0] == this.a[0]) {
                                    main.f.a(this.B, -1);
                                    this.I = 1;
                                    break;
                                }
                                main.f.a(-1, -1);
                                break;
                            }
                            if (this.I != 1 || !var1_11.a(this)) break;
                            main.f.a(-1, -1);
                            this.I = 0;
                            break;
                        }
                        case 5: {
                            if (main.f.c != 0 || var1_11.g >= 4 || !this.c(46080) || !this.d(25600) || !main.d.e(this.J)) break;
                            var1_11.b(0, main.e.G[main.e.I]);
                            this.c(6, 1);
                            if (this.B <= 0) break;
                            main.f.b(this.B, 0);
                            break;
                        }
                        case 6: {
                            if (!main.d.i()) break;
                            if (this.D[0] == 0) {
                                var1_11.b(0, 21);
                            }
                            if (this.C > 0) {
                                main.f.b(this.C, 0);
                            }
                            this.a[3] = false;
                            break;
                        }
                        case 7: {
                            if (!this.c(8192) || this.d - var1_11.d > 25600 || this.d - var1_11.d < 0) break;
                            for (var2_25 = 1; var2_25 <= this.C; ++var2_25) {
                                main.a.c[this.J + var2_25].a[3] = true;
                                if (this.D[1] == 0) {
                                    var3_19 = var2_25 % 2;
                                    main.a.c[this.J + var2_25].a[0] = var3_19 == 1;
                                    main.a.c[this.J + var2_25].c = var3_19 == 1 ? main.a.a + (var2_25 << 4) << 8 : main.a.a + 240 - (var2_25 << 4) << 8;
                                } else if (this.D[1] == 1) {
                                    main.a.c[this.J + var2_25].a[0] = false;
                                    main.a.c[this.J + var2_25].c = main.a.a + 240 + (var2_25 << 3) << 8;
                                }
                                if (this.D[0] <= 0) continue;
                                main.a.c[this.J + var2_25].o = main.a.a << 8;
                                main.a.c[this.J + var2_25].p = main.a.a + 240 << 8;
                            }
                            if (this.B > 0) {
                                main.f.b(this.B, 0);
                            }
                            if (this.D[0] > 0) {
                                main.f.J += this.C;
                                main.a.a(-1, -1);
                            }
                            for (var2_25 = 0; var2_25 < 4; var2_25 += 2) {
                                if (this.E[var2_25] <= 0) continue;
                                main.a.c[this.E[var2_25]].a[3] = true;
                                main.a.c[this.E[var2_25]].c(this.E[var2_25 + 1], 1);
                            }
                            if (var1_11.g == 21) {
                                var1_11.b(0, main.e.G[main.e.I]);
                            }
                            this.a[3] = false;
                            break;
                        }
                        case 8: {
                            if (this.B > 0) {
                                if (!main.d.e(this.J)) break;
                                if (this.B == 2) {
                                    main.a.c[this.J + 1].a[3] = true;
                                    --this.B;
                                    this.a[3] = false;
                                    break;
                                }
                                if (this.B == 1 && this.C == 1) {
                                    main.a.c[this.J - 1].a[3] = true;
                                    --this.B;
                                    this.a[3] = false;
                                    break;
                                }
                                if (this.C == 0) {
                                    this.B = 0;
                                    break;
                                }
                                if (!main.d.i()) break;
                                this.B = 0;
                                this.a[3] = false;
                                break;
                            }
                            if (!main.d.i()) break;
                            this.a[3] = false;
                            break;
                        }
                        case 9: {
                            if (this.y()) {
                                if (this.v != 1) break;
                                var1_11.b(0, main.e.G[main.e.I]);
                                main.f.D = true;
                                main.a.c[this.J + 1].a[3] = true;
                                main.a.c[this.J + 1].c = main.a.a - 80 << 8;
                                main.f.a(1, -1);
                                main.f.b(27, 0);
                                this.v = 2;
                                break;
                            }
                            if (!this.c(15360) || this.v != 0) break;
                            main.a.a(-1, -1);
                            this.v = 1;
                        }
                    }
                    break;
                }
                case 8: {
                    var1_12 = main.a.c[main.f.c];
                    switch (this.g) {
                        case 0: {
                            this.n.j = -1;
                            if (main.f.K == 0) {
                                if (this.y()) {
                                    if (!main.e.i(32) && !main.e.i(33)) {
                                        main.f.f(3);
                                        main.f.b(18, 0);
                                    } else if (main.e.q(2) < 2) {
                                        if (!this.z) {
                                            main.f.a("\u0421\u0435\u0439\u0447\u0430\u0441 \u044d\u0442\u043e \u0441\u043b\u0438\u0448\u043a\u043e\u043c \u043e\u043f\u0430\u0441\u043d\u043e");
                                        }
                                        this.z = true;
                                        break;
                                    }
                                } else {
                                    this.z = false;
                                }
                            } else if (main.f.K == 104 && this.y() && main.e.q(5) == 3 && main.e.F[1] == -1) {
                                main.f.f(3);
                                main.a.c[22].a[3] = true;
                                main.e.F[1] = (byte)(main.e.F[1] + 1);
                            }
                            if (!this.c(2560) || !this.d(0) || main.e.M <= 0) ** GOTO lbl711
                            main.f.H = 6;
                            main.f.a(1, -1);
                            if (!this.h(true)) break;
                            if (main.f.K != 103) ** GOTO lbl638
                            if (var1_12.a[3] && this.J == 9 && main.e.q(5) < 2) {
                                main.f.a("\u041c\u0438\u0441\u0441\u0438\u044f \u043d\u0435 \u0432\u044b\u043f\u043e\u043b\u043d\u0435\u043d\u0430");
                                main.f.f(0);
                                break;
                            }
                            ** GOTO lbl704
lbl638:
                            // 1 sources

                            if (main.f.K != 107) ** GOTO lbl644
                            if (var1_12.a[3] && this.J == 9 && main.e.q(23) < 2) {
                                main.f.a("\u041c\u0438\u0441\u0441\u0438\u044f \u043d\u0435 \u0432\u044b\u043f\u043e\u043b\u043d\u0435\u043d\u0430");
                                main.f.f(0);
                                break;
                            }
                            ** GOTO lbl704
lbl644:
                            // 1 sources

                            if (main.f.K != 108) ** GOTO lbl659
                            if (!var1_12.a[3] || this.J != 9) ** GOTO lbl704
                            if (main.e.q(24) >= 3 && !main.e.i(11)) {
                                main.f.b(45, 0);
                                main.f.f(0);
                                break;
                            }
                            if (main.e.q(24) != 4) {
                                main.f.a("\u041c\u0438\u0441\u0441\u0438\u044f \u043d\u0435 \u0432\u044b\u043f\u043e\u043b\u043d\u0435\u043d\u0430");
                                main.f.f(0);
                                break;
                            }
                            if (main.f.S[7] != 10) ** GOTO lbl704
                            main.f.S[7] = 9;
                            main.f.a("\u041e\u0442\u043a\u0440\u044b\u0442\u0430 \u043d\u043e\u0432\u0430\u044f \u0441\u0446\u0435\u043d\u0430" + main.f.R[7]);
                            main.f.f(0);
                            ** GOTO lbl704
lbl659:
                            // 1 sources

                            if (main.f.K != 203) ** GOTO lbl665
                            if (var1_12.a[3] && this.J == 9 && main.e.q(8) < 2) {
                                main.f.a("\u041c\u0438\u0441\u0441\u0438\u044f \u043d\u0435 \u0432\u044b\u043f\u043e\u043b\u043d\u0435\u043d\u0430");
                                main.f.f(0);
                                break;
                            }
                            ** GOTO lbl704
lbl665:
                            // 1 sources

                            if (main.f.K != 207) ** GOTO lbl671
                            if (var1_12.a[3] && this.J == 9 && main.e.q(43) < 2) {
                                main.f.a("\u041c\u0438\u0441\u0441\u0438\u044f \u043d\u0435 \u0432\u044b\u043f\u043e\u043b\u043d\u0435\u043d\u0430");
                                main.f.f(0);
                                break;
                            }
                            ** GOTO lbl704
lbl671:
                            // 1 sources

                            if (main.f.K != 303) ** GOTO lbl677
                            if (var1_12.a[3] && this.J == 9 && main.e.q(10) < 2) {
                                main.f.a("\u041c\u0438\u0441\u0441\u0438\u044f \u043d\u0435 \u0432\u044b\u043f\u043e\u043b\u043d\u0435\u043d\u0430");
                                main.f.f(0);
                                break;
                            }
                            ** GOTO lbl704
lbl677:
                            // 1 sources

                            if (main.f.K != 403) ** GOTO lbl683
                            if (var1_12.a[3] && this.J == 9 && main.e.q(21) < 2) {
                                main.f.a("\u041c\u0438\u0441\u0441\u0438\u044f \u043d\u0435 \u0432\u044b\u043f\u043e\u043b\u043d\u0435\u043d\u0430");
                                main.f.f(0);
                                break;
                            }
                            ** GOTO lbl704
lbl683:
                            // 1 sources

                            if (main.f.K != 505) ** GOTO lbl694
                            if (!var1_12.a[3] || this.J != 9) ** GOTO lbl704
                            if (main.e.F[6] < 1) {
                                main.f.b(48, 0);
                                main.f.f(0);
                                break;
                            }
                            if (main.f.S[8] != 10) ** GOTO lbl704
                            main.f.S[8] = 9;
                            main.f.a("\u041e\u0442\u043a\u0440\u044b\u0442\u0430 \u043d\u043e\u0432\u0430\u044f \u0441\u0446\u0435\u043d\u0430" + main.f.R[8]);
                            main.f.f(0);
                            ** GOTO lbl704
lbl694:
                            // 1 sources

                            if (main.f.K == 604) {
                                if (var1_12.a[3] && this.J == 9 && main.e.q(38) < 2) {
                                    main.f.a("\u041c\u0438\u0441\u0441\u0438\u044f \u043d\u0435 \u0432\u044b\u043f\u043e\u043b\u043d\u0435\u043d\u0430");
                                    main.f.f(0);
                                    break;
                                }
                            } else if (main.f.K == 605 && var1_12.a[3] && this.J == 9 && main.e.q(39) < 2) {
                                main.f.a("\u041c\u0438\u0441\u0441\u0438\u044f \u043d\u0435 \u0432\u044b\u043f\u043e\u043b\u043d\u0435\u043d\u0430");
                                main.f.f(0);
                                break;
                            }
lbl704:
                            // 15 sources

                            if (var1_12.g != main.e.H[main.e.I] && var1_12.g != main.e.G[main.e.I]) break;
                            var1_12.a[3] = false;
                            main.a.c[this.J + 1].a[3] = true;
                            main.a.c[this.J + 1].a[0] = var1_12.a[0];
                            main.f.f(0);
                            main.f.a(-1, -1);
                            break;
lbl711:
                            // 1 sources

                            if (!this.c(5120) || !this.d(5120)) break;
                            main.f.a(-1, -1);
                            break;
                        }
                        case 1: {
                            this.n.j = -1;
                            if (!this.c()) break;
                            main.f.E = true;
                            main.f.K = this.B * 100 + this.C;
                            main.e.g = this.D[0];
                            break;
                        }
                        case 2: {
                            this.n.j = -1;
                            if (!this.c()) break;
                            var1_12.a[3] = this.a[3];
                            var1_12.c = this.c;
                            var1_12.d = this.d;
                            this.a[3] = false;
                        }
                    }
                    break;
                }
                case 7: 
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
                case 35: 
                case 36: 
                case 37: 
                case 50: 
                case 51: 
                case 52: 
                case 53: 
                case 54: 
                case 55: 
                case 56: 
                case 57: {
                    this.j();
                    break;
                }
                case 38: 
                case 39: 
                case 40: 
                case 41: 
                case 42: 
                case 43: 
                case 44: 
                case 45: 
                case 46: 
                case 47: 
                case 48: 
                case 49: {
                    this.k();
                    break;
                }
                case 58: {
                    this.n();
                    break;
                }
                case 59: {
                    this.o();
                    break;
                }
                case 60: {
                    this.p();
                    break;
                }
                case 61: {
                    this.q();
                    break;
                }
                case 62: {
                    this.r();
                    break;
                }
                case 63: {
                    this.s();
                    break;
                }
                case 64: {
                    this.t();
                    break;
                }
                case 65: {
                    this.u();
                    break;
                }
                case 66: {
                    this.v();
                    break;
                }
                case 5: 
                case 9: 
                case 10: 
                case 11: 
                case 13: 
                case 14: 
                case 15: 
                case 16: 
                case 17: 
                case 18: 
                case 19: 
                case 20: 
                case 21: {
                    this.l();
                    break;
                }
                case 12: {
                    this.m();
                    break;
                }
                case 22: {
                    this.z();
                    break;
                }
                case 23: {
                    v1.n.j = -1;
                    switch (this.g) {
                        case 0: {
                            if (!this.c()) break;
                            this.A();
                            if (this.z) {
                                this.c(1, 1);
                                break;
                            }
                            this.a[3] = false;
                            break;
                        }
                        case 2: 
                        case 4: {
                            if (!this.c()) break;
                            this.a[3] = false;
                            break;
                        }
                        case 1: 
                        case 3: {
                            if (this.y()) {
                                main.f.a(5, -1);
                                this.v = 1;
                                if (!this.f(true)) break;
                                this.c(this.g + 1, 1);
                                this.A();
                                main.f.a(-1, -1);
                                main.f.f(0);
                                break;
                            }
                            if (this.v != 1) break;
                            main.f.a(-1, -1);
                            this.v = 0;
                        }
                    }
                    break;
                }
                case 67: {
                    v2.n.j = -1;
                    this.l = false;
                    switch (this.g) {
                        case 0: 
                        case 2: {
                            if (this.B()) {
                                this.c(this.g + 1, 1);
                            }
                            this.D();
                            break;
                        }
                        case 1: 
                        case 3: {
                            if (this.B()) {
                                this.c(this.g - 1, 1);
                            }
                            this.D();
                            break;
                        }
                        case 4: 
                        case 6: {
                            if (this.C()) {
                                this.c(this.g + 1, 1);
                            }
                            this.D();
                            break;
                        }
                        case 5: 
                        case 7: {
                            if (this.C()) {
                                this.c(this.g - 1, 1);
                            }
                            this.D();
                        }
                    }
                    break;
                }
                case 68: {
                    v3.n.j = -1;
                    var1_13 = main.a.c[main.f.c];
                    var2_26 = var1_13.a(this);
                    if (!var2_26 || !main.d.e(var1_13)) break;
                    var1_13.a(main.e.h() / 10 + main.e.m(), var1_13.c < this.c, false);
                    break;
                }
                case 69: {
                    if (this.y()) {
                        if (this.I >= 0) break;
                        if (main.f.P) {
                            this.I = 0;
                            main.f.P = false;
                            break;
                        }
                        this.I = 0;
                        main.f.d();
                        main.f.f(0);
                        break;
                    }
                    this.I = -1;
                    break;
                }
                case 70: {
                    v4.n.j = -1;
                    main.f.f(3);
                    switch (this.g) {
                        case 0: {
                            if (!this.c()) break;
                            this.c(1, 1);
                            main.f.b(21, 0);
                            break;
                        }
                        case 1: {
                            if (!this.c(10240) || !this.d(0)) break;
                            main.f.b(23, 0);
                            this.c(2, 1);
                            main.f.D = false;
                            break;
                        }
                        case 2: {
                            if (!this.c()) break;
                            main.a.c[main.f.c].c(main.e.G[main.e.I], 1);
                            main.f.b(24, 0);
                            this.a[3] = false;
                        }
                    }
                    break;
                }
                case 71: {
                    v5.n.j = -1;
                    main.f.f(3);
                    switch (this.g) {
                        case 0: {
                            if (!this.c()) break;
                            this.c(1, 1);
                            main.f.b(29, 0);
                            break;
                        }
                        case 1: {
                            if (!this.c()) break;
                            this.c(2, 1);
                            break;
                        }
                        case 2: {
                            if (!this.c()) break;
                            main.f.b(30, 0);
                            this.a[3] = false;
                        }
                    }
                    break;
                }
                case 72: {
                    v6.n.j = -1;
                    main.f.f(3);
                    switch (this.g) {
                        case 0: {
                            if (!this.c()) break;
                            this.c(1, 1);
                            main.f.b(34, 0);
                            break;
                        }
                        case 1: {
                            if (!this.c()) break;
                            this.c(2, 1);
                            break;
                        }
                        case 2: {
                            if (!this.c()) break;
                            main.f.b(35, 0);
                            this.a[3] = false;
                        }
                    }
                    break;
                }
                case 73: {
                    v7.n.j = -1;
                    main.f.f(3);
                    switch (this.g) {
                        case 0: {
                            if (!this.c()) break;
                            this.c(1, 1);
                            if (main.f.K == 609) {
                                if (!main.e.i(32)) {
                                    main.f.b(68, 0);
                                    break;
                                }
                                main.f.b(65, 0);
                                break;
                            }
                            main.f.b(40, 0);
                            break;
                        }
                        case 1: {
                            if (!this.c() || main.f.K == 609 && !main.e.i(32)) break;
                            this.c(2, 1);
                            break;
                        }
                        case 2: {
                            if (!this.c()) break;
                            if (main.f.K == 404) {
                                main.f.b(41, 0);
                            }
                            this.a[3] = false;
                        }
                    }
                    break;
                }
                case 74: {
                    v8.n.j = -1;
                    switch (this.g) {
                        case 0: {
                            var1_14 = this;
                            if (!var1_14.a[3]) ** GOTO lbl-1000
                            var2_27 = main.a.c[main.f.c];
                            if (var1_14.d + (var1_14.b[1] << 8) > var2_27.d + (var2_27.b[3] << 8) || var1_14.d + (var1_14.b[3] << 8) < var2_27.d + (var2_27.b[1] << 8)) ** GOTO lbl-1000
                            if (var1_14.c <= var2_27.c) ** GOTO lbl955
                            var3_20 = var1_14.c + (var1_14.b[0] - var2_27.x()[2] << 8);
                            if (var2_27.c <= var3_20) ** GOTO lbl-1000
                            var2_27.c = var2_27.c - var3_20 > 2048 ? (var2_27.c -= 2048 + var2_27.e) : var3_20;
                            var2_27.c(1, false);
                            var2_27.b(-1, false);
                            v9 = true;
                            ** GOTO lbl965
lbl955:
                            // 1 sources

                            var3_21 = var1_14.c + (var1_14.b[2] - var2_27.x()[0] << 8);
                            if (var2_27.c < var3_21) {
                                var2_27.c = var3_21 - var2_27.c > 2048 ? (var2_27.c += 2048 - var2_27.e) : var3_21;
                                var2_27.c(1, false);
                                var2_27.b(1, false);
                                v9 = true;
                            } else lbl-1000:
                            // 4 sources

                            {
                                v9 = false;
                            }
lbl965:
                            // 3 sources

                            if (main.e.q(29) == 4) {
                                this.c(1, 1);
                                break block3;
                            }
                            break block273;
                        }
                        case 1: {
                            if (main.d.e(this.J)) {
                                this.c(2, 1);
                                break block3;
                            }
                            break block273;
                        }
                        case 2: {
                            if (this.c()) {
                                this.c(3, 1);
                                break block3;
                            }
                            break block273;
                        }
                        case 3: {
                            if (main.d.i()) {
                                this.a[3] = false;
                            } else {
                                ** GOTO lbl982
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    private boolean b(int n, boolean bl) {
        if (this.h == 4 && (this.g == 1 || this.g == 3)) {
            return false;
        }
        int n2 = this.c >> 8;
        if (n == -1) {
            n2 += this.b[0];
            if (bl) {
                --n2;
            }
        } else {
            n2 += this.b[2];
            if (bl) {
                ++n2;
            }
        }
        n2 = n2 < 0 ? -1 : (n2 /= a.c.c);
        int n3 = ((this.d >> 8) + this.b[1] + 1) / a.c.d;
        int n4 = ((this.d >> 8) + this.b[3]) / a.c.d;
        byte by = 0;
        while (n4 >= n3) {
            by = a.c.a(n2, n4);
            if (by == 3) {
                this.c = n == -1 || n == 0 && this.a[0] ? (n2 + 1) * a.c.c - this.b[0] << 8 : n2 * a.c.c - 1 - this.b[2] << 8;
                bl = true;
                break;
            }
            --n4;
        }
        if (bl) {
            if (n == -1) {
                this.P = by;
            } else if (n == 1) {
                this.Q = by;
            }
        }
        return by == 3;
    }

    /*
     * Unable to fully structure code
     */
    private boolean c(int var1_1, boolean var2_2) {
        block24: {
            block26: {
                block28: {
                    block30: {
                        block29: {
                            block27: {
                                block25: {
                                    if (this.h == 4 && (this.g == 1 || this.g == 3) || this.h == 59 && (this.g == 12 || this.g == 10) || this.h == 62 && (this.g == 7 || this.g == 9) || this.h == 64 && (this.g == 7 || this.g == 9) || this.h == 63 && (this.g == 7 || this.g == 9) || this.h == 65 && (this.g != 7 || this.d < 69632) || this.h == 66 && (this.g == 8 || this.g == 10)) {
                                        return false;
                                    }
                                    var3_3 = ((this.c >> 8) + this.b[0]) / a.c.c;
                                    var4_4 = ((this.c >> 8) + this.b[2]) / a.c.c;
                                    var5_5 = this.d >> 8;
                                    if (var1_1 < 0) {
                                        var5_5 += this.b[1];
                                        if (var2_2) {
                                            --var5_5;
                                        }
                                    } else if (var1_1 > 0) {
                                        var5_5 += this.b[3];
                                        if (var2_2) {
                                            ++var5_5;
                                        }
                                    }
                                    var5_5 /= a.c.d;
                                    var6_6 = 0;
                                    if (this.f < 0 || this.h >= 5) break block24;
                                    var7_7 = this;
                                    var8_8 = var7_7.a[0];
                                    var9_9 = ((var7_7.c >> 8) + var7_7.b[2]) / a.c.c;
                                    var10_10 = a.c.c - 1 - ((var7_7.c >> 8) + var7_7.b[2]) % a.c.c;
                                    var11_11 = ((var7_7.d >> 8) + (var8_8 != false ? 1 : 0)) / a.c.d;
                                    var12_12 = ((var7_7.c >> 8) + var7_7.b[0]) / a.c.c;
                                    var13_13 = ((var7_7.c >> 8) + var7_7.b[0]) % a.c.c;
                                    var14_14 = ((var7_7.d >> 8) + (var8_8 != false ? 0 : 1)) / a.c.d;
                                    if (a.c.a(var9_9, var11_11) != 5) break block25;
                                    var7_7.d = var11_11 * a.c.d - 1 - var7_7.b[3] + var10_10 << 8;
                                    v0 = true;
                                    break block26;
                                }
                                if (a.c.a(var12_12, var14_14) != 6) break block27;
                                var7_7.d = var8_8 == false ? var14_14 * a.c.d - 1 - var7_7.b[3] + var13_13 << 8 : var14_14 * a.c.d + 1 - var7_7.b[3] + var13_13 << 8;
                                v0 = true;
                                break block26;
                            }
                            if (!var8_8) break block28;
                            if (a.c.a(var9_9, var11_11 + 1) != 5) break block29;
                            var7_7.d = (var11_11 + 1) * a.c.d - var7_7.b[3] + var10_10 << 8;
                            v0 = true;
                            break block26;
                        }
                        if (a.c.a(var9_9 + 1, var11_11) != 5) break block30;
                        var7_7.d = (var11_11 + 1) * a.c.d - 1 - var7_7.b[3] << 8;
                        v0 = true;
                        break block26;
                    }
                    if (a.c.a(var12_12, var14_14 - 1) != 6) ** GOTO lbl-1000
                    var7_7.d = (var14_14 - 1) * a.c.d - 1 - var7_7.b[3] + var13_13 << 8;
                    v0 = true;
                    break block26;
                }
                if (a.c.a(var9_9, var11_11 - 1) == 5) {
                    var7_7.d = (var11_11 - 1) * a.c.d - 1 - var7_7.b[3] + var10_10 << 8;
                    v0 = true;
                } else if (a.c.a(var12_12, var14_14 + 1) == 6) {
                    var7_7.d = (var14_14 + 1) * a.c.d - var7_7.b[3] + var13_13 << 8;
                    v0 = true;
                } else if (a.c.a(var12_12 - 1, var14_14) == 6) {
                    var7_7.d = (var14_14 + 1) * a.c.d - 1 - var7_7.b[3] << 8;
                    v0 = true;
                } else lbl-1000:
                // 2 sources

                {
                    v0 = false;
                }
            }
            if (v0) {
                var6_6 = 5;
                var2_2 = true;
            }
        }
        if (var6_6 != 5) {
            while (var3_3 <= var4_4) {
                var6_6 = a.c.a(var3_3, var5_5);
                if ((var1_1 >= 0 || var6_6 == 3) && (var1_1 <= 0 || var6_6 >= 3 && var6_6 <= 4)) {
                    if (var1_1 == -1) {
                        this.d = (var5_5 + 1) * a.c.d - this.b[1] << 8;
                    } else if (var1_1 == 1) {
                        this.d = var5_5 * a.c.d - 1 - this.b[3] << 8;
                    }
                    var2_2 = true;
                    break;
                }
                ++var3_3;
            }
        }
        if (var2_2) {
            if (var1_1 < 0) {
                this.N = var6_6;
            } else if (var1_1 > 0) {
                this.O = var6_6;
            }
        }
        if (var1_1 == -1) {
            return var6_6 == 3;
        }
        return var6_6 >= 3 && var6_6 <= 4;
    }

    private int e(boolean bl) {
        int n = this.c >> 8;
        int n2 = ((this.d >> 8) + this.b[1] + 1) / a.c.d;
        int n3 = ((this.d >> 8) + this.b[3] + 1) / a.c.d;
        byte by = 0;
        by = a.c.a(n /= a.c.c, n2);
        if (by == 7) {
            if (bl) {
                this.c = n * a.c.c + a.c.c / 2 << 8;
            }
            return -1;
        }
        by = a.c.a(n, n3);
        if (by == 7) {
            if (bl) {
                this.c = n * a.c.c + a.c.c / 2 << 8;
            }
            return 1;
        }
        return 0;
    }

    private boolean a(int n) {
        int n2 = this.c >> 8;
        int n3 = ((this.d >> 8) + this.b[1] + 1) / a.c.d;
        int n4 = ((this.d >> 8) + this.b[3]) / a.c.d;
        byte by = 0;
        return n == -1 ? (by = a.c.a(n2, n4 = n3)) != 7 : n == 1 && (by = a.c.a(n2 /= a.c.c, n4)) != 7;
    }

    public final boolean a(boolean n) {
        int n2;
        if (n == 0 && this.e == 0 && this.f == 0) {
            return false;
        }
        n = Math.max(Math.abs(this.e / a.c.c) >> 8, Math.abs(this.f / a.c.d) >> 8) + 1;
        int n3 = this.e / n;
        int n4 = this.f / n;
        this.P = -1;
        this.Q = -1;
        this.N = -1;
        this.O = -1;
        if (this.h >= 5 && this.h != 22) {
            if (this.l && (!this.l(n3 > 0) && n4 == 0 || this.c(n3 > 0) || main.d.a(this.c >> 8, n3 > 0))) {
                n3 = 0;
            }
            if (this.o > 0 && this.p > 0) {
                if (this.c < this.o && n3 < 0) {
                    n3 = 0;
                }
                if (this.c > this.p && n3 > 0) {
                    n3 = 0;
                }
            }
        }
        for (n2 = 0; n2 < n; ++n2) {
            boolean bl;
            this.c += n3;
            if (this.e != 0 && (bl = this.e > 0 ? this.b(1, false) : this.b(-1, false))) {
                n3 = 0;
            }
            this.d += n4;
            if (this.f == 0 || !(bl = this.f > 0 ? this.c(1, false) : this.c(-1, false))) continue;
            n4 = 0;
        }
        if (this.h == 67) {
            n2 = n4;
            d d2 = this;
            if (d2.z) {
                d2 = main.a.c[main.f.c];
                d2.c += n3;
                d2.d += n2;
            }
        }
        if (n4 == 0) {
            if (this.f > 0) {
                this.u = 0;
            }
            this.f = 0;
        }
        if (this.P == -1 && this.e <= 0) {
            this.b(-1, true);
        }
        if (this.Q == -1 && this.e >= 0) {
            this.b(1, true);
        }
        if (this.N == -1 && this.f <= 0) {
            this.c(-1, true);
        }
        if (this.O == -1 && this.f >= 0) {
            this.c(1, true);
        }
        return true;
    }

    private boolean f(boolean bl) {
        if (main.e.M < 0 || main.f.L || main.f.D) {
            return false;
        }
        int n = bl ? main.f.i : main.f.j;
        if (main.d.b(n)) {
            return false;
        }
        return (n & 0x4020) != 0;
    }

    private boolean g(boolean bl) {
        if (main.e.M < 0 || main.f.L || main.f.D) {
            return false;
        }
        int n = bl ? main.f.i : main.f.j;
        if (main.d.b(n)) {
            return false;
        }
        return (n & 0x900) != 0;
    }

    private boolean h(boolean bl) {
        if (main.e.M < 0 || main.f.L || main.f.D) {
            return false;
        }
        int n = bl ? main.f.i : main.f.j;
        if (main.d.b(n)) {
            return false;
        }
        return (n & 0x404) != 0;
    }

    private boolean i(boolean bl) {
        if (main.e.M < 0 || main.f.L || main.f.D) {
            return false;
        }
        int n = bl ? main.f.i : main.f.j;
        if (main.d.b(n)) {
            return false;
        }
        return (n & 0x1010) != 0;
    }

    private boolean j(boolean bl) {
        if (main.e.M < 0 || main.f.L || main.f.D) {
            return false;
        }
        int n = main.f.j;
        if (main.d.b(n)) {
            return false;
        }
        return (n & 0x2040) != 0;
    }

    private boolean k(boolean bl) {
        if (main.e.M < 0 || main.f.L || main.f.D) {
            return false;
        }
        int n = bl ? main.f.j : main.f.i;
        if (main.d.b(n)) {
            return false;
        }
        return (n & 0x3050) != 0;
    }

    private static boolean b(int n) {
        return main.f.O > 0 && (main.f.O & n) == 0;
    }

    public final void b(boolean bl) {
        if (this.a[0] == bl) {
            return;
        }
        this.a[0] = bl;
        this.e = -this.e;
        this.t = -this.t;
        this.i = -this.i;
        this.g();
    }

    final void c(int n, int n2) {
        this.y = false;
        this.g = n;
        if (this.g == -1) {
            this.q = -1;
            this.s = -1;
            this.g();
            return;
        }
        this.s = 0;
        this.r = 0;
        this.q = this.m.a(this.g, this.s);
        this.x = false;
        this.g();
        this.e = this.m.i[this.g << 2];
        if (this.a[0]) {
            this.e = -this.e;
        }
        this.f = this.m.i[(this.g << 2) + 1];
        if (this.a[1]) {
            this.f = -this.f;
        }
        this.t = this.m.i[(this.g << 2) + 2];
        if (this.a[0]) {
            this.t = -this.t;
        }
        this.u = this.m.i[(this.g << 2) + 3];
        if (this.a[1]) {
            this.u = -this.u;
        }
    }

    private int[] g() {
        for (int i = 0; i < 4; ++i) {
            this.b[i] = 0;
        }
        byte[] byArray = this.m.d;
        if (this.q != -1 && byArray != null) {
            this.q &= 0xFF;
            this.b[1] = byArray[(this.q << 3) + 1];
            this.b[3] = byArray[(this.q << 3) + 3];
            if (this.a[0]) {
                this.b[0] = -byArray[(this.q << 3) + 2];
                this.b[2] = -byArray[this.q << 3];
            } else {
                this.b[0] = byArray[this.q << 3];
                this.b[2] = byArray[(this.q << 3) + 2];
            }
        }
        return this.b;
    }

    private boolean h() {
        return Math.abs(this.c - main.a.c[main.f.c].c) >> 8 < 360;
    }

    private boolean c(int n) {
        return Math.abs(this.c - main.a.c[main.f.c].c) <= n;
    }

    private boolean e(int n, int n2) {
        return Math.abs(this.c - main.a.c[n2].c) <= 7680;
    }

    private boolean d(int n) {
        return Math.abs(this.d - main.a.c[main.f.c].d) <= n;
    }

    private boolean l(boolean bl) {
        int n = this.d >> 8;
        n += this.b[3];
        ++n;
        n /= a.c.d;
        int n2 = 0;
        if (!bl) {
            n2 = ((this.c >> 8) + this.b[0] - 1) / a.c.c;
        } else {
            n2 = ((this.c >> 8) + this.b[2] + 1) / a.c.c;
            if ((this.c >> 8) + this.b[2] + 1 >= a.c.a * a.c.c) {
                return false;
            }
        }
        return a.c.a(n2, n) >= 3 && a.c.a(n2, n) != 5 && a.c.a(n2, n) != 6;
    }

    private static boolean e(int n) {
        main.f.D = true;
        if (main.f.d != n) {
            main.f.d = n;
        } else if (!main.f.e) {
            return true;
        }
        return false;
    }

    private static boolean i() {
        if (main.f.d != main.f.c) {
            main.f.d = main.f.c;
        } else if (!main.f.e) {
            main.f.D = false;
            return true;
        }
        return false;
    }

    private boolean f(int n, int n2) {
        d d2 = main.a.c[main.f.c];
        return this.c(n << 8) && this.d(n2 << 8) && this.d(d2) && main.d.e(d2);
    }

    private boolean d(d d2) {
        return this.c - d2.c < 0 ? this.a[0] : !this.a[0];
    }

    private static boolean e(d d2) {
        if (main.f.c == 0) {
            if (d2.g == 0 || d2.g == 3 || d2.g >= 20 && d2.g <= 41) {
                return true;
            }
        } else {
            if (main.f.c < 4) {
                return true;
            }
            if (main.f.c == 4 && (d2.g == 0 || d2.g >= 5 && d2.g <= 12)) {
                return true;
            }
        }
        return false;
    }

    private void j() {
        int n;
        d d2 = main.a.c[main.f.c];
        if (this.h == 35) {
            if (main.e.q(8) == 2 && main.e.F[2] == -1) {
                if (this.c(20480) && this.d(0)) {
                    main.f.b(25, 0);
                    main.e.F[2] = (byte)(main.e.F[2] + 1);
                }
                return;
            }
        } else if (this.h == 36 && main.e.q(29) == 2 && main.e.F[5] == -1) {
            if (this.c(20480) && this.d(0)) {
                d2.b(0, main.e.G[main.e.I]);
                this.b(true);
                main.f.b(46, 0);
                main.a.a(0, 460);
                main.e.F[5] = (byte)(main.e.F[5] + 1);
            }
            return;
        }
        if (main.e.m && main.d.b(this) && this.B > 0) {
            for (n = 0; n < main.e.n.length; ++n) {
                if (main.e.n[n] != 0) continue;
                main.e.n[n] = this.c;
                break;
            }
        }
        if ((n = d2.a(this)) != 0 && main.d.e(d2)) {
            d2.a(main.e.I(this.A), d2.c < this.c, false);
        }
        switch (this.g) {
            case 0: {
                if (main.f.D || !this.h() || this.w() || !main.f.G) break;
                d d3 = this;
                if (!d3.y) break;
                if (this.f(50, 16)) {
                    ++this.v;
                    if (this.v <= 6) break;
                    if (a.a.a(500) <= this.A * 5 + 100) {
                        this.c(3, 1);
                    } else {
                        this.c(2, 1);
                    }
                    this.v = 0;
                    return;
                }
                if (this.c(25600) && this.d(4096) && main.d.e(d2) && !this.d(d2)) {
                    this.b(!this.a[0]);
                    this.c(0, 1);
                    return;
                }
                ++this.I;
                if (this.I <= 6) break;
                this.c(1, 1);
                this.I = 0;
                this.e();
                return;
            }
            case 1: {
                if (main.f.D) {
                    this.c(0, 1);
                    return;
                }
                if (!this.h() || this.w()) break;
                if (!main.f.G) {
                    this.c(0, 1);
                    return;
                }
                if (this.f(50, 16)) {
                    this.c(0, 1);
                    return;
                }
                if (this.c(25600) && this.d(4096) && main.d.e(d2)) {
                    if (this.d(d2)) break;
                    this.b(!this.a[0]);
                    this.c(0, 1);
                    return;
                }
                if (!this.d(this.a[0]) && !this.f() && !this.d()) break;
                this.b(!this.a[0]);
                this.c(0, 1);
                return;
            }
            case 2: {
                if (this.w()) break;
                if (!main.f.G) {
                    this.c(0, 1);
                    return;
                }
                d d4 = this;
                if (!d4.y) break;
                this.c(0, 1);
                return;
            }
            case 3: {
                if (this.w()) break;
                d d5 = this;
                if (!d5.y) break;
                this.c(0, 1);
                return;
            }
            case 4: {
                if (this.w()) break;
                d d6 = this;
                if (!d6.y) break;
                if (this.B <= 0) {
                    this.d(23, 0);
                    return;
                }
                this.c(0, 1);
                return;
            }
            case 5: {
                d d7 = this;
                if (!d7.y) break;
                if (this.B <= 0) {
                    this.d(23, 0);
                    return;
                }
                this.c(6, 1);
                return;
            }
            case 6: {
                d d8 = this;
                if (!d8.y) break;
                this.c(0, 1);
            }
        }
    }

    private void k() {
        int n;
        d d2 = main.a.c[main.f.c];
        if (this.h == 47 && main.e.q(5) == 2 && main.e.F[0] == -1) {
            if (this.c(20480) && this.d(0)) {
                main.f.b(20, 0);
                main.e.F[0] = (byte)(main.e.F[0] + 1);
                main.e.F[1] = -1;
            }
            return;
        }
        if (main.e.m && main.d.b(this) && this.B > 0) {
            for (n = 0; n < main.e.n.length; ++n) {
                if (main.e.n[n] != 0) continue;
                main.e.n[n] = this.c;
                break;
            }
        }
        switch (this.g) {
            case 0: {
                if (main.f.D || !this.h() || this.w() || !main.f.G) break;
                d d3 = this;
                if (!d3.y) break;
                if (this.f(100, 16)) {
                    ++this.v;
                    if (this.v <= 6) break;
                    if (a.a.a(500) <= this.A * 5 + 100 && !main.a.c[this.J + 1].a[3]) {
                        this.c(3, 1);
                    } else {
                        this.c(2, 1);
                    }
                    this.v = 0;
                    return;
                }
                if (this.c(30720) && this.d(4096) && main.d.e(d2) && !this.d(d2)) {
                    this.b(!this.a[0]);
                    this.c(0, 1);
                    return;
                }
                ++this.I;
                if (this.I <= 6) break;
                this.c(1, 1);
                this.I = 0;
                this.e();
                return;
            }
            case 1: {
                if (main.f.D) {
                    this.c(0, 1);
                    return;
                }
                if (!this.h() || this.w()) break;
                if (!main.f.G) {
                    this.c(0, 1);
                    return;
                }
                if (this.f(100, 16)) {
                    this.c(0, 1);
                    return;
                }
                if (this.c(30720) && this.d(4096) && main.d.e(d2)) {
                    if (this.d(d2)) break;
                    this.b(!this.a[0]);
                    this.c(0, 1);
                    return;
                }
                if (!this.d(this.a[0]) && !this.f() && !this.d()) break;
                this.b(!this.a[0]);
                this.c(0, 1);
                return;
            }
            case 2: {
                if (this.w()) break;
                if (!main.f.G) {
                    this.c(0, 1);
                    return;
                }
                d d4 = this;
                if (!d4.y) break;
                this.c(0, 1);
                return;
            }
            case 3: {
                if (this.w()) break;
                d d5 = this;
                if (!d5.y) break;
                this.c(0, 1);
                main.a.c[this.J + 1].a[3] = true;
                main.a.c[this.J + 1].c = this.c;
                main.a.c[this.J + 1].d = this.d;
                main.a.c[this.J + 1].b(this.a[0]);
                return;
            }
            case 4: {
                if (this.w()) break;
                d d6 = this;
                if (!d6.y) break;
                if (this.B <= 0) {
                    this.d(23, 0);
                    return;
                }
                this.c(0, 1);
                return;
            }
            case 5: {
                d d7 = this;
                if (!d7.y) break;
                if (this.B <= 0) {
                    this.d(23, 0);
                    return;
                }
                this.c(6, 1);
                return;
            }
            case 6: {
                d d8 = this;
                if (!d8.y) break;
                this.c(0, 1);
                return;
            }
            case 7: {
                this.n.j = -1;
                this.l = false;
                boolean bl = d2.a(this);
                n = bl ? 1 : 0;
                if (bl && main.d.e(d2)) {
                    d2.a(main.e.I(this.A), d2.c < this.c, false);
                }
                if (main.d.b(this) && this.P != 3 && this.Q != 3) break;
                this.a[3] = false;
            }
        }
    }

    private void l() {
        d d2 = main.a.c[main.f.c];
        if (this.g < 4 && this.h()) {
            if (!this.y() && this.I == 1) {
                main.f.a(-1, -1);
                this.I = -1;
            }
            if (main.f.V < 0) {
                for (int i = 44; i < 81; ++i) {
                    if (main.e.q(i) <= 0 || main.e.r(i) != this.h || this.g == main.e.q(i) % 4 || this.g >= main.e.q(i) % 4) continue;
                    this.c(main.e.q(i) % 4, 1);
                }
                if (this.g != main.e.q(main.e.C) % 4 && main.e.r(main.e.C) == this.h) {
                    if (this.g < main.e.q(main.e.C) % 4) {
                        this.c(main.e.q(main.e.C) % 4, 1);
                    }
                    return;
                }
            } else if (main.e.q(main.f.V) > 0 && main.e.r(main.f.V) == this.h && this.g != main.e.q(main.f.V) % 4) {
                this.c(main.e.q(main.f.V) % 4, 1);
            }
        }
        switch (this.g) {
            case 0: {
                if (!this.h() || !this.y() || main.f.c != 0 || d2.g != main.e.G[main.e.I] && d2.g != main.e.H[main.e.I]) break;
                if (this.h == 11 || this.h == 13) {
                    main.f.a(5, -1);
                    this.I = 1;
                }
                if (!this.f(true) || d2.g != main.e.G[main.e.I] && d2.g != main.e.H[main.e.I]) break;
                if (this.h == 11) {
                    cMIDlet.b.a(false);
                    main.f.f(0);
                    return;
                }
                if (this.h != 13) break;
                cMIDlet.b.b(false);
                main.f.f(0);
                return;
            }
            case 1: {
                if (!this.h() || !this.y() || main.f.c != 0 || d2.g != main.e.G[main.e.I] && d2.g != main.e.H[main.e.I]) break;
                main.f.a(5, -1);
                this.I = 1;
                if (this.f(true) && (d2.g == main.e.G[main.e.I] || d2.g == main.e.H[main.e.I])) {
                    if (this.h == 11) {
                        cMIDlet.b.a(true);
                    } else if (this.h == 13) {
                        cMIDlet.b.b(true);
                    } else {
                        cMIDlet.b.c(this.h);
                    }
                    main.f.f(0);
                }
                if (!main.f.U) break;
                main.e.s(main.f.V);
                if (main.e.r(main.f.V) != this.h) {
                    this.c(0, 1);
                }
                main.f.b(main.f.V, 1);
                main.f.U = false;
                main.f.V = -1;
                return;
            }
            case 2: {
                if (!this.h() || !this.y() || main.f.c != 0 || d2.g != main.e.G[main.e.I] && d2.g != main.e.H[main.e.I]) break;
                main.f.a(5, -1);
                this.I = 1;
                if (this.f(true) && (d2.g == main.e.G[main.e.I] || d2.g == main.e.H[main.e.I])) {
                    if (this.h == 11) {
                        cMIDlet.b.a(true);
                    } else if (this.h == 13) {
                        cMIDlet.b.b(true);
                    } else {
                        cMIDlet.b.c(this.h);
                    }
                    main.f.f(0);
                }
                if (!main.f.U) break;
                if (main.e.q(main.f.V) == 1) {
                    main.e.s(main.f.V);
                    if (main.e.r(main.f.V) != this.h) {
                        this.c(0, 1);
                    }
                    main.f.b(main.f.V, 1);
                    main.f.U = false;
                    main.f.V = -1;
                    return;
                }
                if (main.e.q(main.f.V) != 3) break;
                if (main.e.d(main.f.V, this.h)) {
                    this.c(0, 1);
                    main.f.b(main.f.V, 2);
                }
                main.f.U = false;
                main.f.V = -1;
                return;
            }
            case 3: {
                if (!this.h() || !this.y() || main.f.c != 0 || d2.g != main.e.G[main.e.I] && d2.g != main.e.H[main.e.I]) break;
                main.f.a(5, -1);
                this.I = 1;
                if (this.f(true) && (d2.g == main.e.G[main.e.I] || d2.g == main.e.H[main.e.I])) {
                    if (this.h == 11) {
                        cMIDlet.b.a(true);
                    } else if (this.h == 13) {
                        cMIDlet.b.b(true);
                    } else {
                        cMIDlet.b.c(this.h);
                    }
                    main.f.f(0);
                }
                if (!main.f.U) break;
                if (main.e.d(main.f.V, this.h)) {
                    this.c(0, 1);
                    main.f.b(main.f.V, 2);
                }
                main.f.U = false;
                main.f.V = -1;
                return;
            }
            case 4: {
                if (this.h == 10) {
                    this.l = false;
                    if (main.f.K == 0) {
                        main.d.e(this.J);
                        if (!this.y()) break;
                        main.d.i();
                        main.f.D = false;
                        main.f.b(19, 0);
                        return;
                    }
                    if (main.f.K == 108) {
                        if (!this.y()) {
                            main.f.a(-1, -1);
                        }
                        if (main.d.b(this)) break;
                        this.a[3] = false;
                        d2.b(true);
                        main.f.b(43, 0);
                        return;
                    }
                    if (main.f.K != 609 || !this.c(10240)) break;
                    d2.b(0, main.e.G[main.e.I]);
                    this.c(0, 1);
                    main.f.b(64, 0);
                    main.a.c[this.J - 1].a[3] = true;
                    main.a.c[this.J - 1].c = main.a.a + 120 << 8;
                    main.a.c[this.J - 1].d = main.a.b + 160 << 8;
                    return;
                }
                if (this.h != 13) break;
                this.n.j = -1;
            }
        }
    }

    private void m() {
        d d2 = main.a.c[main.f.c];
        if (this.g != 8 && this.h()) {
            if (!this.y() && this.I == 1) {
                main.f.a(-1, -1);
                this.I = -1;
            }
            if (main.f.V < 0) {
                if (this.g % 2 == 0) {
                    for (int i = 44; i < 81; ++i) {
                        if (main.e.q(i) <= 0 || main.e.r(i) != this.h || this.g == main.e.q(i) % 4 << 1 || this.g >= main.e.q(i) % 4 << 1) continue;
                        this.c(main.e.q(i) % 4 << 1, 1);
                    }
                }
            } else if (this.g % 2 == 0 && main.e.q(main.f.V) > 0 && main.e.r(main.f.V) == this.h && this.g != main.e.q(main.f.V) % 4 << 1) {
                this.c(main.e.q(main.f.V) % 4 << 1, 1);
            }
        }
        switch (this.g) {
            case 0: {
                if (!this.h() || this.y()) break;
                this.c(this.g + 1, 1);
                return;
            }
            case 2: {
                if (!this.h()) break;
                if (!this.y()) {
                    this.c(this.g + 1, 1);
                    return;
                }
                if (main.f.c != 0 || d2.g != main.e.G[main.e.I] && d2.g != main.e.H[main.e.I]) break;
                main.f.a(5, -1);
                this.I = 1;
                if (this.f(true)) {
                    cMIDlet.b.c(this.h);
                    main.f.f(0);
                }
                if (!main.f.U) break;
                main.e.s(main.f.V);
                if (main.e.r(main.f.V) != this.h) {
                    this.c(0, 1);
                }
                main.f.b(main.f.V, 1);
                main.f.U = false;
                main.f.V = -1;
                return;
            }
            case 4: {
                if (!this.h()) break;
                if (!this.y()) {
                    this.c(this.g + 1, 1);
                    return;
                }
                if (main.f.c != 0 || d2.g != main.e.G[main.e.I] && d2.g != main.e.H[main.e.I]) break;
                main.f.a(5, -1);
                this.I = 1;
                if (this.f(true) && (d2.g == main.e.G[main.e.I] || d2.g == main.e.H[main.e.I])) {
                    cMIDlet.b.c(this.h);
                    main.f.f(0);
                }
                if (!main.f.U) break;
                if (main.e.q(main.f.V) == 1) {
                    main.e.s(main.f.V);
                    if (main.e.r(main.f.V) != this.h) {
                        this.c(0, 1);
                    }
                    main.f.b(main.f.V, 1);
                    main.f.U = false;
                    main.f.V = -1;
                    return;
                }
                if (main.e.q(main.f.V) != 3) break;
                if (main.e.d(main.f.V, this.h)) {
                    this.c(0, 1);
                    main.f.b(main.f.V, 2);
                }
                main.f.U = false;
                main.f.V = -1;
                return;
            }
            case 6: {
                if (!this.h()) break;
                if (!this.y()) {
                    this.c(this.g + 1, 1);
                    return;
                }
                if (main.f.c != 0 || d2.g != main.e.G[main.e.I] && d2.g != main.e.H[main.e.I]) break;
                main.f.a(5, -1);
                this.I = 1;
                if (this.f(true) && (d2.g == main.e.G[main.e.I] || d2.g == main.e.H[main.e.I])) {
                    cMIDlet.b.c(this.h);
                    main.f.f(0);
                }
                if (!main.f.U) break;
                if (main.e.d(main.f.V, this.h)) {
                    this.c(0, 1);
                    main.f.b(main.f.V, 2);
                }
                main.f.U = false;
                main.f.V = -1;
                return;
            }
            case 1: 
            case 3: 
            case 5: 
            case 7: {
                if (!this.h()) break;
                if (this.y() && main.f.c == 0 && (d2.g == main.e.G[main.e.I] || d2.g == main.e.H[main.e.I])) {
                    if (this.g != 1) {
                        main.f.a(5, -1);
                    }
                    this.I = 1;
                    if (this.f(true)) {
                        if (!this.d(d2)) {
                            this.b(!this.a[0]);
                        }
                        this.c(this.g - 1, 1);
                        main.f.f(0);
                        return;
                    }
                }
                if (!this.d()) break;
                this.b(!this.a[0]);
                this.c(this.g - 1, 1);
            }
        }
    }

    private void n() {
        d d2;
        boolean bl;
        if (main.e.q(10) == 2 && main.e.F[3] == -1) {
            if (this.c(20480) && this.d(0)) {
                main.f.b(27, 0);
                main.e.F[3] = (byte)(main.e.F[3] + 1);
                main.a.a(228, 488);
            }
            return;
        }
        if (main.e.F[3] == 0) {
            this.c(7, 1);
            main.e.F[3] = (byte)(main.e.F[3] + 1);
        }
        if (main.e.m && main.d.b(this) && this.B > 0) {
            for (int i = 0; i < main.e.n.length; ++i) {
                if (main.e.n[i] != 0) continue;
                main.e.n[i] = this.c;
                break;
            }
        }
        if (bl = (d2 = main.a.c[main.f.c]).a(this)) {
            if (main.d.e(d2)) {
                d2.a(main.e.I(this.A), d2.c < this.c, false);
            }
        } else if (this.y() && this.g < 10 && this.B > 0 && main.d.e(d2)) {
            d2.a(main.e.I(this.A) / 2, d2.c < this.c, false);
        }
        switch (this.g) {
            case 0: {
                if (main.f.D || !this.h() || this.w() || !main.f.G) break;
                d d3 = this;
                if (!d3.y) break;
                if (this.w++ > 150) {
                    this.w = 0;
                    this.v = 0;
                    this.I = 0;
                    this.c(7, 1);
                    return;
                }
                if (this.f(56, 0)) {
                    ++this.v;
                    if (this.v <= 6) break;
                    if (a.a.a(500) <= this.A * 5 + 100) {
                        this.c(3, 1);
                    } else {
                        this.c(2, 1);
                    }
                    this.v = 0;
                    return;
                }
                if (this.c(25600) && this.d(0) && main.d.e(d2) && !this.d(d2)) {
                    this.b(!this.a[0]);
                    this.c(0, 1);
                    return;
                }
                ++this.I;
                if (this.I <= 6) break;
                this.c(1, 1);
                this.I = 0;
                this.e();
                return;
            }
            case 1: {
                if (main.f.D) {
                    this.c(0, 1);
                    return;
                }
                if (!this.h() || this.w()) break;
                if (!main.f.G) {
                    this.c(0, 1);
                    return;
                }
                if (this.w++ > 150) {
                    this.w = 0;
                    this.v = 0;
                    this.I = 0;
                    this.c(7, 1);
                    return;
                }
                if (this.f(56, 0)) {
                    this.c(0, 1);
                    return;
                }
                if (this.c(25600) && this.d(0) && main.d.e(d2)) {
                    if (this.d(d2)) break;
                    this.b(!this.a[0]);
                    this.c(0, 1);
                    return;
                }
                if (!this.d(this.a[0]) && !this.f() && !this.d()) break;
                this.b(!this.a[0]);
                this.c(0, 1);
                return;
            }
            case 2: {
                if (this.w()) break;
                if (!main.f.G) {
                    this.c(0, 1);
                    return;
                }
                d d4 = this;
                if (!d4.y) break;
                this.c(0, 1);
                return;
            }
            case 3: {
                d d5 = this;
                if (!d5.y) break;
                this.c(0, 1);
                return;
            }
            case 4: {
                if (this.w()) break;
                d d6 = this;
                if (!d6.y) break;
                if (this.B <= 0) {
                    this.c(10, 1);
                    return;
                }
                this.c(0, 1);
                return;
            }
            case 5: {
                d d7 = this;
                if (!d7.y) break;
                if (this.B <= 0) {
                    this.c(10, 1);
                    return;
                }
                if (a.a.a(100) <= 60) {
                    this.c(7, 1);
                    return;
                }
                this.c(6, 1);
                return;
            }
            case 6: 
            case 9: {
                d d8 = this;
                if (!d8.y) break;
                this.c(0, 1);
                return;
            }
            case 7: {
                d d9 = this;
                if (!d9.y) break;
                this.c(8, 1);
                return;
            }
            case 8: {
                d d10 = this;
                if (!d10.y) break;
                this.c(9, 1);
                return;
            }
            case 10: {
                main.f.f(3);
                if (main.e.F[3] == 1) {
                    d2.b(0, main.e.G[main.e.I]);
                    main.f.b(28, 0);
                    main.e.F[3] = (byte)(main.e.F[3] + 1);
                    main.a.d();
                    return;
                }
                this.c(11, 1);
                return;
            }
            case 11: {
                this.l = false;
                main.f.f(3);
                if (main.d.c(this)) break;
                this.a[3] = false;
                main.e.t(this.h);
                main.e.K(this.A);
                main.a.c[this.J + 1].a[3] = true;
                main.a.c[this.J + 1].b(d2.a[0]);
                if (d2.a[0]) {
                    main.a.c[this.J + 1].c = main.a.a + 40 << 8;
                    return;
                }
                main.a.c[this.J + 1].c = main.a.a + 240 - 40 << 8;
            }
        }
    }

    private void o() {
        int n;
        d d2 = main.a.c[main.f.c];
        if (main.e.q(43) == 2 && main.e.F[4] == -1) {
            if (this.c(20480) && this.d(0)) {
                d2.b(0, main.e.G[main.e.I]);
                main.f.b(31, 0);
                main.e.F[4] = (byte)(main.e.F[4] + 1);
                main.a.a(120, 560);
                return;
            }
            main.f.D = true;
            if (d2.a[3] && d2.g != main.e.H[main.e.I]) {
                d2.b(0, main.e.H[main.e.I]);
            }
            return;
        }
        if (main.e.F[4] == 0) {
            this.c(3, 1);
            d2.b(true);
            d2.b(0, main.e.G[main.e.I]);
            main.e.F[4] = (byte)(main.e.F[4] + 1);
            main.f.f(3);
        } else if (main.e.F[4] == 2 && this.g != 7) {
            main.f.f(3);
            if (d2.g == main.e.G[main.e.I]) {
                main.f.b(32, 0);
                main.e.F[4] = (byte)(main.e.F[4] + 1);
                main.f.D = false;
            }
            return;
        }
        if (main.e.m && main.d.b(this) && this.B > 0) {
            for (n = 0; n < main.e.n.length; ++n) {
                if (main.e.n[n] != 0) continue;
                main.e.n[n] = this.c;
                break;
            }
        }
        if (this.g != 7 && this.g != 12 && this.g != 15 && this.y() && this.B > 0 && main.d.e(d2)) {
            d2.a(main.e.I(this.A) / 2, d2.c < this.c, false);
        }
        this.l = false;
        switch (this.g) {
            case 0: {
                if (main.f.D || !this.h() || this.w() || !main.f.G) break;
                d d3 = this;
                if (!d3.y || this.w++ <= 50) break;
                this.w = 0;
                this.v = 0;
                this.I = 0;
                this.c(1, 1);
                return;
            }
            case 1: {
                if (main.f.D) {
                    this.c(0, 1);
                    return;
                }
                if (!this.h() || this.w()) break;
                if (!main.f.G) {
                    this.c(0, 1);
                    return;
                }
                if (this.d >> 8 > main.a.b + 80) break;
                this.c(10, 1);
                return;
            }
            case 2: {
                this.w();
                if (this.O < 3 || this.O > 6) break;
                this.c(3, 1);
                return;
            }
            case 3: {
                d d4 = this;
                if (!d4.y) break;
                this.c(0, 1);
                main.a.c[this.J + 1].a[3] = true;
                main.a.c[this.J + 1].c = this.c;
                main.a.c[this.J + 1].d = this.d;
                main.a.c[this.J + 1].b(this.a[0]);
                if (main.e.F[4] != 1) break;
                d2.b(false);
                d2.b(0, 4);
                main.e.F[4] = (byte)(main.e.F[4] + 1);
                return;
            }
            case 4: {
                d d5 = this;
                if (!d5.y) break;
                if (this.B <= 0) {
                    this.c(13, 1);
                    main.f.f(3);
                    return;
                }
                this.c(0, 1);
                return;
            }
            case 5: {
                d d6 = this;
                if (!d6.y) break;
                if (this.B <= 0) {
                    this.c(13, 1);
                    main.f.f(3);
                    return;
                }
                this.c(6, 1);
                return;
            }
            case 6: {
                d d7 = this;
                if (!d7.y) break;
                if (a.a.a(100) <= 60 && !main.a.c[this.J + 1].a[3]) {
                    this.c(3, 1);
                    return;
                }
                this.c(0, 1);
                return;
            }
            case 7: 
            case 12: {
                this.n.j = -1;
                boolean bl = d2.a(this);
                n = bl ? 1 : 0;
                if (bl && main.d.e(d2)) {
                    d2.a(main.e.I(this.A), d2.c < this.c, false);
                }
                if (main.d.b(this) && this.P != 3 && this.Q != 3) break;
                this.a[3] = false;
                return;
            }
            case 8: 
            case 9: {
                d d8 = this;
                if (!d8.y) break;
                if (this.B <= 0) {
                    this.c(13, 1);
                    main.f.f(3);
                    return;
                }
                this.c(this.E[0], 1);
                return;
            }
            case 10: {
                this.w();
                if (this.a[0]) {
                    if (this.I < 4 && this.c - this.v >= 17408) {
                        this.v = this.c;
                        main.a.c[this.J + 2 + this.I].a[3] = true;
                        main.a.c[this.J + 2 + this.I].c = this.c;
                        main.a.c[this.J + 2 + this.I].d = this.d;
                        ++this.I;
                    }
                    if (this.c < this.p) break;
                    this.c = this.p;
                    this.b(!this.a[0]);
                    this.c(2, 1);
                    return;
                }
                if (this.p - this.c < 69632) break;
                this.b(!this.a[0]);
                this.c(10, 1);
                this.v = this.c;
                main.a.c[this.J + 2 + this.I].a[3] = true;
                main.a.c[this.J + 2 + this.I].c = this.c;
                main.a.c[this.J + 2 + this.I].d = this.d;
                ++this.I;
                return;
            }
            case 11: {
                this.w();
                d d9 = this;
                if (!d9.y) break;
                this.c(10, 1);
                return;
            }
            case 13: {
                main.f.f(3);
                if (this.O < 3 || this.O > 6) break;
                this.c(14, 1);
                return;
            }
            case 14: {
                if (main.e.F[4] == 3) {
                    main.f.b(33, 0);
                    main.e.F[4] = (byte)(main.e.F[4] + 1);
                    return;
                }
                if (main.e.F[4] != 4) break;
                this.b(false);
                this.c(15, 1);
                main.e.F[4] = (byte)(main.e.F[4] + 1);
                return;
            }
            case 15: {
                main.f.f(3);
                if (main.d.c(this)) break;
                this.a[3] = false;
                main.e.t(this.h);
                main.e.K(this.A);
                main.a.c[this.J + 6].a[3] = true;
                main.a.c[this.J + 6].b(d2.a[0]);
                main.a.c[this.J + 6].d = d2.d;
                main.a.c[this.J + 6].c = d2.a[0] ? main.a.a + 40 << 8 : main.a.a + 240 - 40 << 8;
                main.a.d();
            }
        }
    }

    private void p() {
        d d2;
        boolean bl;
        if (main.e.m && main.d.b(this) && this.B > 0) {
            for (int i = 0; i < main.e.n.length; ++i) {
                if (main.e.n[i] != 0) continue;
                main.e.n[i] = this.c;
                break;
            }
        }
        if (bl = (d2 = main.a.c[main.f.c]).a(this)) {
            if (main.d.e(d2)) {
                d2.a(main.e.I(this.A), d2.c < this.c, false);
            }
        } else if (this.g < 8 && this.y() && this.B > 0 && main.d.e(d2)) {
            d2.a(main.e.I(this.A) / 2, d2.c < this.c, false);
        }
        switch (this.g) {
            case 0: {
                if (main.f.D || !this.h() || this.w() || !main.f.G) break;
                d d3 = this;
                if (!d3.y) break;
                if (this.w++ > 100) {
                    this.w = 0;
                    this.v = 0;
                    this.I = 0;
                    this.c(7, 1);
                    return;
                }
                if (this.f(60, 0)) {
                    ++this.v;
                    if (this.v <= 6) break;
                    if (a.a.a(500) <= this.A * 5 + 100) {
                        this.c(3, 1);
                    } else {
                        this.c(2, 1);
                    }
                    this.v = 0;
                    return;
                }
                if (this.c(30720) && this.d(0) && main.d.e(d2) && !this.d(d2)) {
                    this.b(!this.a[0]);
                    this.c(0, 1);
                    return;
                }
                ++this.I;
                if (this.I <= 6) break;
                this.c(1, 1);
                this.I = 0;
                this.e();
                return;
            }
            case 1: {
                if (main.f.D) {
                    this.c(0, 1);
                    return;
                }
                if (!this.h() || this.w()) break;
                if (!main.f.G) {
                    this.c(0, 1);
                    return;
                }
                if (this.w++ > 100) {
                    this.w = 0;
                    this.v = 0;
                    this.I = 0;
                    this.c(7, 1);
                    return;
                }
                if (this.f(60, 0)) {
                    this.c(0, 1);
                    return;
                }
                if (this.c(30720) && this.d(0) && main.d.e(d2)) {
                    if (this.d(d2)) break;
                    this.b(!this.a[0]);
                    this.c(0, 1);
                    return;
                }
                if (!this.d(this.a[0]) && !this.f() && !this.d()) break;
                this.b(!this.a[0]);
                this.c(0, 1);
                return;
            }
            case 2: {
                if (this.w()) break;
                if (!main.f.G) {
                    this.c(0, 1);
                    return;
                }
                d d4 = this;
                if (!d4.y) break;
                this.c(0, 1);
                return;
            }
            case 3: {
                d d5 = this;
                if (!d5.y) break;
                this.c(0, 1);
                return;
            }
            case 4: {
                if (this.w()) break;
                d d6 = this;
                if (!d6.y) break;
                if (this.B <= 0) {
                    this.c(11, 1);
                    return;
                }
                if (a.a.a(100) <= 5) {
                    this.c(7, 1);
                    return;
                }
                this.c(0, 1);
                return;
            }
            case 5: {
                d d7 = this;
                if (!d7.y) break;
                if (this.B <= 0) {
                    this.c(11, 1);
                    return;
                }
                if (a.a.a(100) <= 10) {
                    this.c(7, 1);
                    return;
                }
                this.c(6, 1);
                return;
            }
            case 6: 
            case 7: {
                d d8 = this;
                if (!d8.y) break;
                this.c(0, 1);
                return;
            }
            case 8: {
                if (!this.c(20480) || !this.d(0)) break;
                this.c(10, 1);
                main.f.b(36, 0);
                main.a.a(100, 560);
                return;
            }
            case 9: {
                main.f.f(3);
                d d9 = this;
                if (!d9.y) break;
                this.c(12, 1);
                main.f.b(38, 0);
                return;
            }
            case 10: {
                d d10 = this;
                if (!d10.y) break;
                this.c(1, 1);
                main.f.b(37, 0);
                return;
            }
            case 11: {
                main.f.f(3);
                d d11 = this;
                if (!d11.y) break;
                this.b(false);
                this.c(9, 1);
                return;
            }
            case 12: {
                this.l = false;
                main.f.f(3);
                if (main.d.c(this)) break;
                this.a[3] = false;
                main.e.t(this.h);
                main.e.K(this.A);
                main.a.d();
                main.f.b(39, 0);
                main.a.c[this.J + 1].a[3] = true;
                main.a.c[this.J + 1].d = main.a.b + 160 << 8;
                main.a.c[this.J + 1].c = main.a.a + 120 << 8;
            }
        }
    }

    private void q() {
        if (main.e.m && main.d.b(this) && this.B > 0) {
            for (int i = 0; i < main.e.n.length; ++i) {
                if (main.e.n[i] != 0) continue;
                main.e.n[i] = this.c;
                break;
            }
        }
        d d2 = main.a.c[main.f.c];
        if ((this.g == 0 || this.g == 5) && this.y() && this.B > 0 && main.d.e(d2)) {
            d2.a(main.e.I(this.A) / 2, d2.c < this.c, false);
        }
        this.l = false;
        this.n.j = this.h;
        switch (this.g) {
            case 0: {
                if (main.f.D || !this.h()) break;
                this.w();
                if (!main.f.G) break;
                d d3 = this;
                if (!d3.y || this.J != 29) break;
                if (this.w++ > 100) {
                    this.w = 0;
                    this.v = 0;
                    this.I = 0;
                    this.c(1, 1);
                    if (main.a.c[27].g != 7 && main.a.c[27].g != 4) {
                        main.a.c[27].c(1, 1);
                    }
                    if (main.a.c[25].g == 7 || main.a.c[27].g == 4) break;
                    main.a.c[25].c(1, 1);
                    return;
                }
                if (main.a.c[28].a[3] || main.a.c[26].a[3] || main.a.c[30].a[3] || this.v++ <= 30) break;
                this.c(5, 1);
                this.v = 0;
                if (main.a.c[27].g != 7 && main.a.c[27].g != 4) {
                    main.a.c[27].c(5, 1);
                }
                if (main.a.c[25].g == 7 || main.a.c[27].g == 4) break;
                main.a.c[25].c(5, 1);
                return;
            }
            case 1: {
                d d4 = this;
                if (!d4.y) break;
                if (this.J == 29) {
                    if (main.a.c[27].g == 7) {
                        main.a.c[27].c(2, 1);
                    }
                    if (main.a.c[25].g == 7) {
                        main.a.c[25].c(2, 1);
                    }
                }
                this.c(2, 1);
                return;
            }
            case 2: {
                d d5 = this;
                if (!d5.y) break;
                if (this.J == 29) {
                    switch (a.a.a(3)) {
                        case 0: {
                            this.c = 47616;
                            this.d = 61184;
                            main.a.c[27].c = 68096;
                            main.a.c[27].d = 40704;
                            main.a.c[25].c = 88064;
                            main.a.c[25].d = 61184;
                            break;
                        }
                        case 1: {
                            this.c = 68096;
                            this.d = 40704;
                            main.a.c[27].c = 88064;
                            main.a.c[27].d = 61184;
                            main.a.c[25].c = 47616;
                            main.a.c[25].d = 61184;
                            break;
                        }
                        case 2: {
                            this.c = 88064;
                            this.d = 61184;
                            main.a.c[27].c = 47616;
                            main.a.c[27].d = 61184;
                            main.a.c[25].c = 68096;
                            main.a.c[25].d = 40704;
                        }
                    }
                }
                this.c(0, 1);
                return;
            }
            case 3: {
                ++this.w;
                d d6 = this;
                if (!d6.y) break;
                if (this.B <= 0) {
                    main.a.c[25].a[3] = false;
                    main.a.c[27].a[3] = false;
                    this.c(12, 1);
                    main.f.b(44, 0);
                    return;
                }
                this.c(0, 1);
                return;
            }
            case 4: {
                d d7 = this;
                if (!d7.y) break;
                this.c(7, 1);
                return;
            }
            case 5: {
                d d8 = this;
                if (!d8.y) break;
                this.c(0, 1);
                main.a.c[this.J + 1].a[3] = true;
                main.a.c[this.J + 1].c = this.c;
                main.a.c[this.J + 1].d = this.d;
                main.a.c[this.J + 1].b(this.a[0]);
                main.a.c[this.J + 1].T = this.c - d2.c > 0 ? -1 : (this.c - d2.c == 0 ? 0 : 1);
                main.a.c[this.J + 1].S = this.d - d2.d < 0 ? 1 : (this.d - d2.d == 0 ? 0 : -1);
                main.a.c[this.J + 1].R = Math.abs(this.d - d2.d >> 8) / 4 == 0 ? 4 : Math.abs(this.c - d2.c >> 8) / (Math.abs(this.d - d2.d >> 8) / 4);
                if (main.a.c[this.J + 1].S != 0 || main.a.c[this.J + 1].R != 0) break;
                main.a.c[this.J + 1].R = 4;
                return;
            }
            case 6: {
                this.n.j = -1;
                boolean bl = d2.a(this);
                if (bl && main.d.e(d2)) {
                    d2.a(main.e.I(this.A), d2.c < this.c, false);
                }
                this.c += this.R * this.T << 8;
                this.d += 4 * this.S << 8;
                if (main.d.c(this)) break;
                this.a[3] = false;
                return;
            }
            case 7: {
                this.n.j = -1;
                return;
            }
            case 8: {
                main.f.f(3);
                return;
            }
            case 9: {
                d d9 = this;
                if (!d9.y) break;
                main.a.c[29].a[3] = true;
                main.a.c[27].a[3] = true;
                main.a.c[25].a[3] = true;
                this.a[3] = false;
                main.a.a(80, 480);
                return;
            }
            case 10: {
                this.n.j = -1;
                if (main.e.q(24) != 2) break;
                this.c(11, 1);
                return;
            }
            case 11: {
                main.f.f(3);
                d d10 = this;
                if (!d10.y) break;
                this.c(8, 1);
                d2.b(true);
                main.a.c[this.J + 7].b(true);
                main.f.b(42, 0);
                return;
            }
            case 12: {
                main.f.f(3);
                d d11 = this;
                if (!d11.y) break;
                main.e.t(this.h);
                main.e.K(this.A);
                main.a.d();
                this.a[3] = false;
            }
        }
    }

    private void r() {
        int n;
        d d2 = main.a.c[main.f.c];
        if (main.e.F[6] == -1) {
            if (this.c(20480) && this.d(0)) {
                d2.b(0, main.e.G[main.e.I]);
                this.b(true);
                main.f.b(49, 0);
                main.a.a(0, 350);
                main.e.F[6] = (byte)(main.e.F[6] + 1);
            }
            return;
        }
        if (main.e.m && main.d.b(this) && this.B > 0) {
            for (n = 0; n < main.e.n.length; ++n) {
                if (main.e.n[n] != 0) continue;
                main.e.n[n] = this.c;
                break;
            }
        }
        if (this.g != 7 && this.g != 9 && this.y() && this.B > 0 && main.d.e(d2)) {
            d2.a(main.e.I(this.A) / 2, d2.c < this.c, false);
        }
        switch (this.g) {
            case 0: {
                if (main.f.D || !this.h() || this.w() || !main.f.G) break;
                d d3 = this;
                if (!d3.y) break;
                if (this.f(100, 0)) {
                    ++this.v;
                    if (this.v <= 15) break;
                    if (a.a.a(500) <= this.A * 5 + 100) {
                        if (a.a.a(100) < 50 && !main.a.c[this.J + 1].a[3]) {
                            this.c(3, 1);
                        } else if (!main.a.c[this.J + 6].a[3]) {
                            this.c(8, 1);
                        }
                    } else {
                        this.c(2, 1);
                    }
                    this.v = 0;
                    return;
                }
                if (this.c(30720) && this.d(0) && main.d.e(d2) && !this.d(d2)) {
                    this.b(!this.a[0]);
                    this.c(0, 1);
                    return;
                }
                ++this.I;
                if (this.I <= 6) break;
                this.c(1, 1);
                this.I = 0;
                this.e();
                return;
            }
            case 1: {
                if (main.f.D) {
                    this.c(0, 1);
                    return;
                }
                if (!this.h() || this.w()) break;
                if (!main.f.G) {
                    this.c(0, 1);
                    return;
                }
                ++this.v;
                if (this.v > 15) {
                    if (a.a.a(500) <= this.A * 5 + 100) {
                        if (a.a.a(100) < 50 && !main.a.c[this.J + 1].a[3]) {
                            this.c(3, 1);
                        } else if (!main.a.c[this.J + 6].a[3]) {
                            this.c(8, 1);
                        }
                    }
                    this.v = 0;
                    return;
                }
                if (this.f(100, 0)) {
                    this.c(0, 1);
                    return;
                }
                if (this.c(30720) && this.d(0) && main.d.e(d2)) {
                    if (this.d(d2)) break;
                    this.b(!this.a[0]);
                    this.c(0, 1);
                    return;
                }
                if (!this.d(this.a[0]) && !this.f() && !this.d()) break;
                this.b(!this.a[0]);
                this.c(0, 1);
                return;
            }
            case 2: {
                if (this.w()) break;
                if (!main.f.G) {
                    this.c(0, 1);
                    return;
                }
                d d4 = this;
                if (!d4.y) break;
                this.c(0, 1);
                return;
            }
            case 3: {
                d d5 = this;
                if (!d5.y) break;
                this.c(0, 1);
                main.a.c[this.J + 1].a[3] = true;
                main.a.c[this.J + 1].c = this.c;
                main.a.c[this.J + 1].d = this.d;
                main.a.c[this.J + 1].b(this.a[0]);
                return;
            }
            case 4: {
                d d6 = this;
                if (!d6.y) break;
                if (this.B <= 0) {
                    main.a.a(6);
                    this.v = 0;
                    this.c(10, 1);
                    return;
                }
                this.c(0, 1);
                return;
            }
            case 5: {
                d d7 = this;
                if (!d7.y) break;
                if (this.B <= 0) {
                    main.a.a(6);
                    this.v = 0;
                    this.c(10, 1);
                    return;
                }
                this.c(6, 1);
                return;
            }
            case 6: {
                d d8 = this;
                if (!d8.y) break;
                this.c(3, 1);
                return;
            }
            case 7: {
                this.n.j = -1;
                this.l = false;
                boolean bl = d2.a(this);
                n = bl ? 1 : 0;
                if (bl && main.d.e(d2)) {
                    d2.a(main.e.I(this.A), d2.c < this.c, false);
                }
                if ((this.c >> 8) + this.b[0] <= main.a.a + 240 && (this.c >> 8) + this.b[2] >= main.a.a && this.P != 3 && this.Q != 3) break;
                this.a[3] = false;
                return;
            }
            case 8: {
                ++this.v;
                if (this.v == 1) {
                    main.a.c[this.J + 2].a[3] = true;
                    main.a.c[this.J + 2].c = main.a.a + a.a.a(10) * 24 << 8;
                    main.a.c[this.J + 2].d = main.a.b + 320 << 8;
                    main.a.c[this.J + 2].b(this.a[0]);
                } else if (this.v == 7) {
                    main.a.c[this.J + 3].a[3] = true;
                    main.a.c[this.J + 3].c = main.a.a + a.a.a(10) * 24 << 8;
                    main.a.c[this.J + 3].d = main.a.b + 320 << 8;
                    main.a.c[this.J + 3].b(this.a[0]);
                } else if (this.v == 13) {
                    main.a.c[this.J + 4].a[3] = true;
                    main.a.c[this.J + 4].c = main.a.a + a.a.a(10) * 24 << 8;
                    main.a.c[this.J + 4].d = main.a.b + 320 << 8;
                    main.a.c[this.J + 4].b(this.a[0]);
                } else if (this.v == 19) {
                    main.a.c[this.J + 5].a[3] = true;
                    main.a.c[this.J + 5].c = main.a.a + a.a.a(10) * 24 << 8;
                    main.a.c[this.J + 5].d = main.a.b + 320 << 8;
                    main.a.c[this.J + 5].b(this.a[0]);
                } else if (this.v == 25) {
                    main.a.c[this.J + 6].a[3] = true;
                    main.a.c[this.J + 6].c = main.a.a + a.a.a(10) * 24 << 8;
                    main.a.c[this.J + 6].d = main.a.b + 320 << 8;
                    main.a.c[this.J + 6].b(this.a[0]);
                }
                d d9 = this;
                if (!d9.y) break;
                System.out.println(this.v);
                this.c(0, 1);
                this.v = 0;
                return;
            }
            case 9: {
                this.n.j = -1;
                this.l = false;
                if (d2.a(this) && main.d.e(d2)) {
                    d2.a(main.e.I(this.A), d2.c < this.c, false);
                }
                if ((d2.d >> 8) + d2.b[3] >= main.a.b - 160) break;
                this.a[3] = false;
                return;
            }
            case 10: {
                ++this.v;
                if (this.v == 13) {
                    if (main.e.F[6] == 0) {
                        main.f.b(50, 0);
                        main.e.F[6] = (byte)(main.e.F[6] + 1);
                    }
                    main.a.d();
                    return;
                }
                if (this.v <= 13) break;
                this.v = 0;
                this.d(23, 0);
                main.a.d();
            }
        }
    }

    private void s() {
        int n;
        d d2 = main.a.c[main.f.c];
        if (main.e.F[7] == -1) {
            main.f.f(3);
            main.f.D = true;
            d2.b(0, main.e.H[main.e.I]);
            main.e.F[7] = (byte)(main.e.F[7] + 1);
            return;
        }
        if (main.e.F[7] == 0) {
            if (this.c(20480) && this.d(0)) {
                d2.b(0, main.e.G[main.e.I]);
                if (main.e.q(38) == 2) {
                    main.f.b(51, 0);
                }
                main.a.a(0, 480);
                main.f.D = false;
                main.e.F[7] = (byte)(main.e.F[7] + 1);
            }
            return;
        }
        if (main.e.m && main.d.b(this) && this.B > 0) {
            for (n = 0; n < main.e.n.length; ++n) {
                if (main.e.n[n] != 0) continue;
                main.e.n[n] = this.c;
                break;
            }
        }
        if (this.g != 7 && this.g != 9 && this.y() && this.B > 0 && main.d.e(d2)) {
            d2.a(main.e.I(this.A) / 2, d2.c < this.c, false);
        }
        switch (this.g) {
            case 0: {
                if (main.f.D || !this.h() || this.w() || !main.f.G) break;
                d d3 = this;
                if (!d3.y) break;
                if (this.f(100, 0)) {
                    ++this.v;
                    if (this.v <= 15) break;
                    if (a.a.a(500) <= this.A * 5 + 100) {
                        if (a.a.a(100) < 50 && !main.a.c[this.J + 1].a[3]) {
                            this.c(3, 1);
                        } else if (!main.a.c[this.J + 7].a[3]) {
                            this.c(8, 1);
                        }
                    } else {
                        this.c(2, 1);
                    }
                    this.v = 0;
                    return;
                }
                if (this.c(30720) && this.d(0) && main.d.e(d2) && !this.d(d2)) {
                    this.b(!this.a[0]);
                    this.c(0, 1);
                    return;
                }
                ++this.I;
                if (this.I <= 6) break;
                this.c(1, 1);
                this.I = 0;
                this.e();
                return;
            }
            case 1: {
                if (main.f.D) {
                    this.c(0, 1);
                    return;
                }
                if (!this.h() || this.w()) break;
                if (!main.f.G) {
                    this.c(0, 1);
                    return;
                }
                ++this.v;
                if (this.v > 15) {
                    if (a.a.a(500) <= this.A * 5 + 100) {
                        if (a.a.a(100) < 50 && !main.a.c[this.J + 1].a[3]) {
                            this.c(3, 1);
                        } else if (!main.a.c[this.J + 7].a[3]) {
                            this.c(8, 1);
                        }
                    }
                    this.v = 0;
                    return;
                }
                if (this.f(100, 0)) {
                    this.c(0, 1);
                    return;
                }
                if (this.c(30720) && this.d(0) && main.d.e(d2)) {
                    if (this.d(d2)) break;
                    this.b(!this.a[0]);
                    this.c(0, 1);
                    return;
                }
                if (!this.d(this.a[0]) && !this.f() && !this.d()) break;
                this.b(!this.a[0]);
                this.c(0, 1);
                return;
            }
            case 2: {
                if (this.w()) break;
                if (!main.f.G) {
                    this.c(0, 1);
                    return;
                }
                d d4 = this;
                if (!d4.y) break;
                this.c(0, 1);
                return;
            }
            case 3: {
                d d5 = this;
                if (!d5.y) break;
                if (this.v < 1) {
                    this.c(3, 1);
                } else {
                    this.c(0, 1);
                }
                if (this.v < 2) {
                    main.a.c[this.J + 1 + this.v].a[3] = true;
                    main.a.c[this.J + 1 + this.v].c = this.c;
                    main.a.c[this.J + 1 + this.v].d = this.d;
                    main.a.c[this.J + 1 + this.v].b(this.a[0]);
                }
                ++this.v;
                return;
            }
            case 4: {
                d d6 = this;
                if (!d6.y) break;
                if (this.B <= 0) {
                    main.a.a(6);
                    this.v = 0;
                    this.c(10, 1);
                    return;
                }
                this.c(0, 1);
                return;
            }
            case 5: {
                d d7 = this;
                if (!d7.y) break;
                if (this.B <= 0) {
                    main.a.a(6);
                    this.v = 0;
                    this.c(10, 1);
                    return;
                }
                this.c(0, 1);
                return;
            }
            case 6: {
                d d8 = this;
                if (!d8.y) break;
                if (!main.a.c[this.J + 7].a[3]) {
                    this.c(8, 1);
                } else {
                    this.c(3, 1);
                }
                this.v = 0;
                return;
            }
            case 7: {
                this.n.j = -1;
                this.l = false;
                boolean bl = d2.a(this);
                n = bl ? 1 : 0;
                if (bl && main.d.e(d2)) {
                    d2.a(main.e.I(this.A), d2.c < this.c, false);
                }
                if ((this.c >> 8) + this.b[0] <= main.a.a + 240 && (this.c >> 8) + this.b[2] >= main.a.a && this.P != 3 && this.Q != 3) break;
                this.a[3] = false;
                return;
            }
            case 8: {
                ++this.v;
                if (this.v == 25) {
                    main.a.c[this.J + 7].a[3] = true;
                    main.a.c[this.J + 7].c = main.a.a + a.a.a(10) * 24 << 8;
                    main.a.c[this.J + 7].d = main.a.b << 8;
                    main.a.c[this.J + 7].b(this.a[0]);
                } else if (this.v == 1) {
                    main.a.c[this.J + 3].a[3] = true;
                    main.a.c[this.J + 3].c = main.a.a + a.a.a(10) * 24 << 8;
                    main.a.c[this.J + 3].d = main.a.b << 8;
                    main.a.c[this.J + 3].b(this.a[0]);
                } else if (this.v == 7) {
                    main.a.c[this.J + 4].a[3] = true;
                    main.a.c[this.J + 4].c = main.a.a + a.a.a(10) * 24 << 8;
                    main.a.c[this.J + 4].d = main.a.b << 8;
                    main.a.c[this.J + 4].b(this.a[0]);
                } else if (this.v == 13) {
                    main.a.c[this.J + 5].a[3] = true;
                    main.a.c[this.J + 5].c = main.a.a + a.a.a(10) * 24 << 8;
                    main.a.c[this.J + 5].d = main.a.b << 8;
                    main.a.c[this.J + 5].b(this.a[0]);
                } else if (this.v == 19) {
                    main.a.c[this.J + 6].a[3] = true;
                    main.a.c[this.J + 6].c = main.a.a + a.a.a(10) * 24 << 8;
                    main.a.c[this.J + 6].d = main.a.b << 8;
                    main.a.c[this.J + 6].b(this.a[0]);
                }
                d d9 = this;
                if (!d9.y) break;
                this.c(0, 1);
                this.v = 0;
                return;
            }
            case 9: {
                this.n.j = -1;
                this.l = false;
                if (d2.a(this) && main.d.e(d2)) {
                    d2.a(main.e.I(this.A), d2.c < this.c, false);
                }
                if ((this.d >> 8) + this.b[1] <= main.a.b + 320) break;
                this.a[3] = false;
                return;
            }
            case 10: {
                ++this.v;
                if (this.v == 13) {
                    if (main.e.q(38) == 2 && main.e.F[7] == 1) {
                        main.f.b(52, 0);
                        main.e.F[7] = (byte)(main.e.F[7] + 1);
                    }
                    main.a.d();
                    return;
                }
                if (this.v <= 13) break;
                this.v = 0;
                this.d(23, 0);
                main.a.d();
            }
        }
    }

    private void t() {
        int n;
        d d2 = main.a.c[main.f.c];
        if (main.e.F[8] == -1) {
            main.f.f(3);
            main.f.D = true;
            d2.b(0, main.e.H[main.e.I]);
            main.e.F[8] = (byte)(main.e.F[8] + 1);
            return;
        }
        if (main.e.F[8] == 0) {
            if (this.c(20480) && this.d(0)) {
                d2.b(0, main.e.G[main.e.I]);
                if (main.e.q(38) == 2) {
                    main.f.b(53, 0);
                }
                main.a.a(0, 480);
                main.f.D = false;
                main.e.F[8] = (byte)(main.e.F[8] + 1);
            }
            return;
        }
        if (main.e.m && main.d.b(this) && this.B > 0) {
            for (n = 0; n < main.e.n.length; ++n) {
                if (main.e.n[n] != 0) continue;
                main.e.n[n] = this.c;
                break;
            }
        }
        if (this.g != 7 && this.g != 9 && this.y() && this.B > 0 && main.d.e(d2)) {
            d2.a(main.e.I(this.A) / 2, d2.c < this.c, false);
        }
        switch (this.g) {
            case 0: {
                if (main.f.D || !this.h() || this.w() || !main.f.G) break;
                d d3 = this;
                if (!d3.y) break;
                if (this.f(100, 0)) {
                    ++this.v;
                    if (this.v <= 15) break;
                    if (a.a.a(500) <= this.A * 5 + 100) {
                        if (a.a.a(100) < 50 && !main.a.c[this.J + 1].a[3]) {
                            this.c(3, 1);
                        } else if (!main.a.c[this.J + 8].a[3]) {
                            this.c(8, 1);
                        }
                    } else {
                        this.c(2, 1);
                    }
                    this.v = 0;
                    return;
                }
                if (this.c(30720) && this.d(0) && main.d.e(d2) && !this.d(d2)) {
                    this.b(!this.a[0]);
                    this.c(0, 1);
                    return;
                }
                ++this.I;
                if (this.I <= 6) break;
                this.c(1, 1);
                this.I = 0;
                this.e();
                return;
            }
            case 1: {
                if (main.f.D) {
                    this.c(0, 1);
                    return;
                }
                if (!this.h() || this.w()) break;
                if (!main.f.G) {
                    this.c(0, 1);
                    return;
                }
                if (this.f(100, 0)) {
                    this.c(0, 1);
                    return;
                }
                if (this.c(30720) && this.d(0) && main.d.e(d2)) {
                    if (this.d(d2)) break;
                    this.b(!this.a[0]);
                    this.c(0, 1);
                    return;
                }
                if (!this.d(this.a[0]) && !this.f() && !this.d()) break;
                this.b(!this.a[0]);
                this.c(0, 1);
                return;
            }
            case 2: {
                if (this.w()) break;
                if (!main.f.G) {
                    this.c(0, 1);
                    return;
                }
                d d4 = this;
                if (!d4.y) break;
                this.c(0, 1);
                return;
            }
            case 3: {
                d d5 = this;
                if (!d5.y) break;
                if (this.v < 1) {
                    this.c(3, 1);
                } else {
                    this.c(0, 1);
                }
                if (this.v < 2) {
                    main.a.c[this.J + 1 + this.v].a[3] = true;
                    main.a.c[this.J + 1 + this.v].c = this.c;
                    main.a.c[this.J + 1 + this.v].d = this.d;
                    main.a.c[this.J + 1 + this.v].b(this.a[0]);
                }
                ++this.v;
                return;
            }
            case 4: {
                d d6 = this;
                if (!d6.y) break;
                if (this.B <= 0) {
                    this.v = 0;
                    this.c(10, 1);
                    return;
                }
                this.c(0, 1);
                return;
            }
            case 5: {
                d d7 = this;
                if (!d7.y) break;
                if (this.B <= 0) {
                    this.v = 0;
                    this.c(10, 1);
                    return;
                }
                this.c(0, 1);
                return;
            }
            case 6: {
                d d8 = this;
                if (!d8.y) break;
                if (!main.a.c[this.J + 8].a[3]) {
                    this.c(8, 1);
                } else {
                    this.c(3, 1);
                }
                this.v = 0;
                return;
            }
            case 7: {
                this.n.j = -1;
                this.l = false;
                boolean bl = d2.a(this);
                n = bl ? 1 : 0;
                if (bl && main.d.e(d2)) {
                    d2.a(main.e.I(this.A), d2.c < this.c, false);
                }
                if ((this.c >> 8) + this.b[0] <= main.a.a + 240 && (this.c >> 8) + this.b[2] >= main.a.a && this.P != 3 && this.Q != 3) break;
                this.a[3] = false;
                return;
            }
            case 8: {
                ++this.v;
                if (this.v == 31) {
                    main.a.c[this.J + 8].a[3] = true;
                    main.a.c[this.J + 8].c = main.a.a + a.a.a(10) * 24 << 8;
                    main.a.c[this.J + 8].d = this.d - (a.a.a(4) * 20 << 8);
                    main.a.c[this.J + 8].b(this.a[0]);
                } else if (this.v == 25) {
                    main.a.c[this.J + 7].a[3] = true;
                    main.a.c[this.J + 7].c = main.a.a + a.a.a(10) * 24 << 8;
                    main.a.c[this.J + 7].d = this.d - (a.a.a(4) * 20 << 8);
                    main.a.c[this.J + 7].b(this.a[0]);
                } else if (this.v == 1) {
                    main.a.c[this.J + 3].a[3] = true;
                    main.a.c[this.J + 3].c = main.a.a + a.a.a(10) * 24 << 8;
                    main.a.c[this.J + 3].d = this.d - (a.a.a(4) * 20 << 8);
                    main.a.c[this.J + 3].b(this.a[0]);
                } else if (this.v == 7) {
                    main.a.c[this.J + 4].a[3] = true;
                    main.a.c[this.J + 4].c = main.a.a + a.a.a(10) * 24 << 8;
                    main.a.c[this.J + 4].d = this.d - (a.a.a(4) * 20 << 8);
                    main.a.c[this.J + 4].b(this.a[0]);
                } else if (this.v == 13) {
                    main.a.c[this.J + 5].a[3] = true;
                    main.a.c[this.J + 5].c = main.a.a + a.a.a(10) * 24 << 8;
                    main.a.c[this.J + 5].d = this.d - (a.a.a(4) * 20 << 8);
                    main.a.c[this.J + 5].b(this.a[0]);
                } else if (this.v == 19) {
                    main.a.c[this.J + 6].a[3] = true;
                    main.a.c[this.J + 6].c = main.a.a + a.a.a(10) * 24 << 8;
                    main.a.c[this.J + 6].d = this.d - (a.a.a(4) * 20 << 8);
                    main.a.c[this.J + 6].b(this.a[0]);
                }
                d d9 = this;
                if (!d9.y) break;
                this.c(0, 1);
                this.v = 0;
                return;
            }
            case 9: {
                this.n.j = -1;
                if (d2.a(this) && main.d.e(d2)) {
                    d2.a(main.e.I(this.A), d2.c < this.c, false);
                }
                d d10 = this;
                if (!d10.y) break;
                this.c(9, 1);
                this.a[3] = false;
                return;
            }
            case 10: {
                ++this.v;
                if (this.v == 13) {
                    if (main.e.q(38) == 2 && main.e.F[8] == 1) {
                        main.f.b(54, 0);
                        main.e.F[8] = (byte)(main.e.F[8] + 1);
                    }
                    main.a.d();
                    return;
                }
                if (this.v <= 13) break;
                main.a.d();
                this.v = 0;
                this.d(23, 0);
            }
        }
    }

    private void u() {
        d d2 = main.a.c[main.f.c];
        if (main.e.F[9] == -1) {
            main.f.f(5);
            main.f.D = true;
            d2.b(0, main.e.H[main.e.I]);
            main.e.F[9] = (byte)(main.e.F[9] + 1);
            return;
        }
        if (main.e.F[9] == 0) {
            main.f.f(5);
            if (this.c(25600)) {
                d2.b(0, main.e.G[main.e.I]);
                this.l = false;
                this.c(1, 1);
                main.f.b(56, 0);
                main.a.a(80, 490);
                main.f.D = false;
                main.e.F[9] = (byte)(main.e.F[9] + 1);
            }
            return;
        }
        if (main.e.F[9] == 1) {
            main.f.f(5);
            if (this.c(17920)) {
                main.f.b(57, 0);
                main.e.F[9] = (byte)(main.e.F[9] + 1);
            }
            return;
        }
        if (main.e.m && main.d.b(this) && this.B > 0) {
            for (int i = 0; i < main.e.n.length; ++i) {
                if (main.e.n[i] != 0) continue;
                main.e.n[i] = this.c;
                break;
            }
        }
        if (this.g < 6 && this.y() && this.B > 0 && main.d.e(d2)) {
            d2.a(main.e.I(this.A) / 2, d2.c < this.c, false);
        }
        switch (this.g) {
            case 0: {
                if (main.f.D || main.a.c[this.J + 1].a[3] || main.a.c[this.J + 2].a[3] || main.a.c[this.J + 3].a[3] || !this.h()) break;
                this.w();
                if (!main.f.G) break;
                d d3 = this;
                if (!d3.y) break;
                if (this.w++ > 100) {
                    this.w = 0;
                    this.v = 0;
                    this.I = 0;
                    int n = a.a.a(100);
                    if (n < 30) {
                        this.c(3, 1);
                        return;
                    }
                    if (n < 60) {
                        this.c(4, 1);
                        return;
                    }
                    this.c(5, 1);
                    return;
                }
                ++this.I;
                if (this.I <= 6) break;
                this.c(1, 1);
                this.I = 0;
                this.e();
                return;
            }
            case 1: {
                this.l = false;
                if (main.f.D) {
                    this.c(0, 1);
                    return;
                }
                if (this.h()) {
                    this.w();
                    if (!main.f.G) {
                        this.c(0, 1);
                        return;
                    }
                    if (this.w++ > 100) {
                        this.w = 0;
                        this.v = 0;
                        this.I = 0;
                        int n = a.a.a(100);
                        if (n < 30) {
                            this.c(3, 1);
                            return;
                        }
                        if (n < 60) {
                            this.c(4, 1);
                            return;
                        }
                        this.c(5, 1);
                        return;
                    }
                }
                if (!this.c(this.a[0]) && !main.d.a(this.c >> 8, this.a[0]) && !this.f() && !this.d()) break;
                this.b(!this.a[0]);
                this.c(0, 1);
                return;
            }
            case 3: {
                d d4 = this;
                if (!d4.y) break;
                this.c(0, 1);
                main.a.c[this.J + 3].a[3] = true;
                main.a.c[this.J + 3].c = d2.c;
                main.a.c[this.J + 3].c(11, 1);
                return;
            }
            case 4: {
                d d5 = this;
                if (!d5.y) break;
                this.c(0, 1);
                main.a.c[this.J + 1].a[3] = true;
                main.a.c[this.J + 1].c = main.a.a - 60 << 8;
                main.a.c[this.J + 1].b(true);
                main.a.c[this.J + 1].c(13, 1);
                return;
            }
            case 5: {
                d d6 = this;
                if (!d6.y) break;
                this.c(0, 1);
                main.a.c[this.J + 2].a[3] = true;
                main.a.c[this.J + 2].c = d2.c;
                main.a.c[this.J + 2].c(14, 1);
                return;
            }
            case 6: {
                ++this.w;
                d d7 = this;
                if (!d7.y) break;
                if (this.B <= 0) {
                    this.c(7, 1);
                    if (!this.d(d2)) {
                        this.b(!this.a[0]);
                    }
                    main.a.a(0, 490);
                    return;
                }
                this.c(0, 1);
                return;
            }
            case 7: {
                main.f.f(5);
                if (this.d < 69632 || this.O < 3 || this.O > 6) break;
                this.c(8, 1);
                this.v = 0;
                return;
            }
            case 8: {
                main.f.f(5);
                if (this.v == 0) {
                    main.f.f(3);
                    main.f.D = true;
                    if (this.c - d2.c > 0) {
                        d2.b(false);
                    } else {
                        d2.b(true);
                    }
                    d2.b(0, main.e.H[main.e.I]);
                    this.v = 1;
                }
                if (main.f.c == 0 && d2.g == 15) {
                    d2.d -= this.j << 8;
                    d2.c = d2.c + ((this.a[0] ? 12 : -12) << 8);
                    d2.c(17, 1);
                    main.f.a(-1, -1);
                }
                d d8 = this;
                if (!d8.y || !this.d(0)) break;
                if (this.c - d2.c > 0) {
                    d2.b(false);
                } else {
                    d2.b(true);
                }
                if (!main.e.i(32)) {
                    main.f.b(58, 0);
                    this.c(10, 1);
                } else {
                    main.f.b(60, 0);
                    this.c(9, 1);
                }
                main.f.D = false;
                return;
            }
            case 9: {
                main.f.f(5);
                d d9 = this;
                if (!d9.y) break;
                this.c(18, 1);
                main.f.b(61, 0);
                this.v = 0;
                return;
            }
            case 18: {
                this.n.j = -1;
                if (this.v == 0) {
                    main.f.f(3);
                    main.f.D = true;
                    d2.b(0, main.e.H[main.e.I]);
                    this.v = 1;
                    return;
                }
                if (this.v != 1 || !this.c(5120)) break;
                d2.b(0, main.e.G[main.e.I]);
                main.f.b(62, 0);
                main.f.D = false;
                this.v = 2;
                return;
            }
            case 10: {
                main.f.f(3);
                d d10 = this;
                if (!d10.y) break;
                main.e.t(this.h);
                main.e.K(this.A);
                this.a[3] = false;
                main.f.b(59, 0);
                return;
            }
            case 11: {
                this.n.j = -1;
                d d11 = this;
                if (!d11.y) break;
                this.c(12, 1);
                main.a.a(3);
                return;
            }
            case 12: {
                this.n.j = -1;
                if (d2.a(this) && main.d.e(d2)) {
                    d2.a(main.e.I(this.A), d2.c < this.c, false);
                }
                d d12 = this;
                if (!d12.y) break;
                ++this.v;
                if (this.v > 5) {
                    this.v = 0;
                    this.a[3] = false;
                    return;
                }
                this.c(11, 1);
                this.c = d2.c;
                return;
            }
            case 13: {
                this.n.j = -1;
                this.l = false;
                if (d2.a(this) && main.d.e(d2)) {
                    d2.a(main.e.I(this.A), d2.c < this.c, false);
                }
                if ((this.c >> 8) + this.b[0] <= main.a.a + 240) break;
                this.a[3] = false;
                return;
            }
            case 14: {
                this.n.j = -1;
                d d13 = this;
                if (!d13.y) break;
                this.c(15, 1);
                return;
            }
            case 15: {
                this.n.j = -1;
                if (d2.a(this) && main.d.e(d2)) {
                    d2.a[3] = false;
                    this.c(16, 1);
                    return;
                }
                d d14 = this;
                if (!d14.y) break;
                this.c(17, 1);
                return;
            }
            case 16: {
                this.n.j = -1;
                if (this.v++ <= 50) break;
                this.v = 0;
                d2.a[3] = true;
                d2.a(main.e.I(this.A), d2.c < this.c, false);
                this.c(17, 1);
                return;
            }
            case 17: {
                this.n.j = -1;
                d d15 = this;
                if (!d15.y) break;
                this.a[3] = false;
            }
        }
    }

    private void v() {
        int n;
        d d2 = main.a.c[main.f.c];
        if (main.e.F[10] == -1) {
            main.f.f(5);
            main.f.D = true;
            d2.b(0, main.e.H[main.e.I]);
            main.e.F[10] = (byte)(main.e.F[10] + 1);
            return;
        }
        if (main.e.F[10] == 0) {
            main.f.f(5);
            if (this.c(20480)) {
                d2.b(0, main.e.G[main.e.I]);
                main.f.b(63, 0);
                main.a.a(0, 620);
                main.f.D = false;
                main.e.F[10] = (byte)(main.e.F[10] + 1);
            }
            return;
        }
        if (main.e.m && main.d.b(this) && this.B > 0) {
            for (n = 0; n < main.e.n.length; ++n) {
                if (main.e.n[n] != 0) continue;
                main.e.n[n] = this.c;
                break;
            }
        }
        if ((n = d2.a(this)) != 0) {
            if (main.d.e(d2)) {
                d2.a(main.e.I(this.A), d2.c < this.c, false);
            }
        } else if (this.y() && this.B > 0 && main.d.e(d2)) {
            d2.a(main.e.I(this.A) / 2, d2.c < this.c, false);
        }
        switch (this.g) {
            case 0: {
                if (main.f.D || !this.h() || this.w() || !main.f.G) break;
                d d3 = this;
                if (!d3.y) break;
                if (this.w++ > 60) {
                    this.w = 0;
                    this.v = 0;
                    this.I = 0;
                    if (a.a.a(2) == 1) {
                        this.c(7, 1);
                        return;
                    }
                    this.c(9, 1);
                    return;
                }
                if (this.f(64, 0)) {
                    ++this.v;
                    if (this.v <= 6) break;
                    if (a.a.a(500) <= this.A * 5 + 100) {
                        this.c(3, 1);
                    } else {
                        this.c(2, 1);
                    }
                    this.v = 0;
                    return;
                }
                if (this.c(128 << 8) && this.d(0) && main.d.e(d2) && !this.d(d2)) {
                    this.b(!this.a[0]);
                    this.c(0, 1);
                    return;
                }
                ++this.I;
                if (this.I <= 6) break;
                this.c(1, 1);
                this.I = 0;
                this.e();
                return;
            }
            case 1: {
                if (main.f.D) {
                    this.c(0, 1);
                    return;
                }
                if (!this.h() || this.w()) break;
                if (!main.f.G) {
                    this.c(0, 1);
                    return;
                }
                if (this.w++ > 60) {
                    this.w = 0;
                    this.v = 0;
                    this.I = 0;
                    if (a.a.a(2) == 1) {
                        this.c(7, 1);
                        return;
                    }
                    this.c(9, 1);
                    return;
                }
                if (this.f(64, 0)) {
                    this.c(0, 1);
                    return;
                }
                if (this.c(128 << 8) && this.d(0) && main.d.e(d2)) {
                    if (this.d(d2)) break;
                    this.b(!this.a[0]);
                    this.c(0, 1);
                    return;
                }
                if (!this.d(this.a[0]) && !this.f() && !this.d()) break;
                this.b(!this.a[0]);
                this.c(0, 1);
                return;
            }
            case 2: {
                if (this.w()) break;
                if (!main.f.G) {
                    this.c(0, 1);
                    return;
                }
                d d4 = this;
                if (!d4.y) break;
                this.c(0, 1);
                return;
            }
            case 3: {
                d d5 = this;
                if (!d5.y) break;
                this.c(0, 1);
                return;
            }
            case 4: {
                if (this.w()) break;
                d d6 = this;
                if (!d6.y) break;
                if (this.B <= 0) {
                    main.e.t(this.h);
                    main.e.K(this.A);
                    if (!main.e.i(32)) {
                        this.c(12, 1);
                    } else {
                        this.c(11, 1);
                    }
                    if (main.e.i == 0) {
                        main.e.a(2);
                    }
                    this.v = 0;
                    return;
                }
                this.c(0, 1);
                return;
            }
            case 5: {
                d d7 = this;
                if (!d7.y) break;
                if (this.B <= 0) {
                    main.e.t(this.h);
                    main.e.K(this.A);
                    if (!main.e.i(32)) {
                        this.c(12, 1);
                    } else {
                        this.c(11, 1);
                    }
                    if (main.e.i == 0) {
                        main.e.a(2);
                    }
                    this.v = 0;
                    return;
                }
                this.c(0, 1);
                return;
            }
            case 11: {
                if (this.v != 0) break;
                main.a.c[this.J - 1].a[3] = true;
                main.a.c[this.J - 1].c = main.a.a + 240 << 8;
                main.a.c[this.J - 1].b(false);
                this.v = 1;
                return;
            }
            case 12: {
                d d8 = this;
                if (!d8.y) break;
                d2.b(0, main.e.G[main.e.I]);
                this.c(13, 1);
                main.f.b(67, 0);
                main.a.a(-1, -1);
                return;
            }
            case 13: {
                main.f.f(5);
                if (this.v == 12) {
                    main.a.c[this.J - 2].a[3] = true;
                    main.a.c[this.J - 2].c = main.a.a + 120 << 8;
                    main.a.c[this.J - 2].d = main.a.b + 160 << 8;
                } else if (this.v == 40) {
                    main.f.D = true;
                    d2.b(false);
                    d2.b(0, main.e.H[main.e.I]);
                } else if (this.v == 46) {
                    d2.l = false;
                    main.f.b(69, 0);
                }
                if (!main.d.b(d2)) {
                    main.a.c[this.J - 2].c(2, 1);
                    main.f.b(70, 0);
                }
                ++this.v;
                return;
            }
            case 6: {
                d d9 = this;
                if (!d9.y) break;
                this.c(0, 1);
                return;
            }
            case 7: {
                ++this.v;
                if (this.v == 71) {
                    main.a.c[this.J + 1].a[3] = true;
                    main.a.c[this.J + 1].c = main.a.a + (a.a.a(7) << 5) << 8;
                    main.a.c[this.J + 1].d = main.a.b << 8;
                    main.a.c[this.J + 1].b(this.a[0]);
                } else if (this.v == 61) {
                    main.a.c[this.J + 2].a[3] = true;
                    main.a.c[this.J + 2].c = main.a.a + (a.a.a(7) << 5) << 8;
                    main.a.c[this.J + 2].d = main.a.b << 8;
                    main.a.c[this.J + 2].b(this.a[0]);
                }
                if (this.v == 51) {
                    main.a.c[this.J + 8].a[3] = true;
                    main.a.c[this.J + 8].c = main.a.a + (a.a.a(7) << 5) << 8;
                    main.a.c[this.J + 8].d = main.a.b << 8;
                    main.a.c[this.J + 8].b(this.a[0]);
                } else if (this.v == 41) {
                    main.a.c[this.J + 7].a[3] = true;
                    main.a.c[this.J + 7].c = main.a.a + (a.a.a(7) << 5) << 8;
                    main.a.c[this.J + 7].d = main.a.b << 8;
                    main.a.c[this.J + 7].b(this.a[0]);
                } else if (this.v == 1) {
                    main.a.c[this.J + 3].a[3] = true;
                    main.a.c[this.J + 3].c = main.a.a + (a.a.a(7) << 5) << 8;
                    main.a.c[this.J + 3].d = main.a.b << 8;
                    main.a.c[this.J + 3].b(this.a[0]);
                } else if (this.v == 11) {
                    main.a.c[this.J + 4].a[3] = true;
                    main.a.c[this.J + 4].c = main.a.a + (a.a.a(7) << 5) << 8;
                    main.a.c[this.J + 4].d = main.a.b << 8;
                    main.a.c[this.J + 4].b(this.a[0]);
                } else if (this.v == 21) {
                    main.a.c[this.J + 5].a[3] = true;
                    main.a.c[this.J + 5].c = main.a.a + (a.a.a(7) << 5) << 8;
                    main.a.c[this.J + 5].d = main.a.b << 8;
                    main.a.c[this.J + 5].b(this.a[0]);
                } else if (this.v == 31) {
                    main.a.c[this.J + 6].a[3] = true;
                    main.a.c[this.J + 6].c = main.a.a + (a.a.a(7) << 5) << 8;
                    main.a.c[this.J + 6].d = main.a.b << 8;
                    main.a.c[this.J + 6].b(this.a[0]);
                }
                if (this.v <= 50) break;
                this.c(0, 1);
                this.v = 0;
                return;
            }
            case 9: {
                if (this.v == 0) {
                    main.a.c[this.J + 9].c = !this.a[0] ? main.a.a + 240 - this.b[0] << 8 : main.a.a - this.b[2] << 8;
                    main.a.c[this.J + 9].d = this.d - ((a.a.a(4) + 1) * 20 << 8);
                    main.a.c[this.J + 9].b(this.a[0]);
                    main.a.c[this.J + 9].a[3] = true;
                }
                ++this.v;
                if (main.a.c[this.J + 9].a[3]) break;
                this.v = 0;
                this.c(0, 1);
                return;
            }
            case 8: {
                this.n.j = -1;
                this.l = false;
                if (d2.a(this) && main.d.e(d2)) {
                    d2.a(main.e.I(this.A), d2.c < this.c, false);
                }
                if ((this.d >> 8) + this.b[1] <= main.a.b + 320) break;
                this.a[3] = false;
                return;
            }
            case 10: {
                this.n.j = -1;
                this.l = false;
                if (d2.a(this) && main.d.e(d2)) {
                    d2.a(main.e.I(this.A), d2.c < this.c, false);
                }
                if ((this.c >> 8) + this.b[0] <= main.a.a + 240 && (this.c >> 8) + this.b[2] >= main.a.a) break;
                ++this.v;
                if (this.v > 5) {
                    this.v = 0;
                    this.a[3] = false;
                    return;
                }
                this.c(10, 1);
                this.d = main.a.c[this.J - 9].d - ((a.a.a(4) + 1) * 20 << 8);
                if (!main.a.c[this.J - 9].a[0]) {
                    this.c = main.a.a + 240 - this.b[0] << 8;
                    return;
                }
                this.c = main.a.a - this.b[2] << 8;
            }
        }
    }

    private boolean w() {
        d d2 = main.a.a(this);
        if (d2 == null) {
            return false;
        }
        main.f.F = true;
        if (this.F != 0) {
            return false;
        }
        boolean bl = false;
        block0 : switch (d2.h) {
            case 0: 
            case 1: 
            case 2: 
            case 3: {
                this.F = 3;
                this.f(main.e.l() - main.e.J(this.A));
                this.n.a((this.c >> 8) + (d2.a[0] ? 20 : -20), (this.d >> 8) + this.b[1] / 2, !d2.a[0]);
                switch (d2.g) {
                    case 2: 
                    case 5: 
                    case 8: 
                    case 11: {
                        bl = true;
                        break block0;
                    }
                }
                break;
            }
            case 4: {
                this.n.a((this.c >> 8) + (d2.a[0] ? 20 : -20), (this.d >> 8) + this.b[1] / 2, !d2.a[0]);
                switch (d2.g) {
                    case 1: {
                        this.F = 8;
                        this.f(main.e.l() - main.e.J(this.A));
                        break block0;
                    }
                    case 3: {
                        this.f(main.e.l() / 2 - main.e.J(this.A));
                        d2.c(4, 1);
                        break block0;
                    }
                    case 13: {
                        bl = true;
                    }
                }
            }
        }
        switch (this.h) {
            case 7: 
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
            case 35: 
            case 36: 
            case 37: 
            case 38: 
            case 39: 
            case 40: 
            case 41: 
            case 42: 
            case 43: 
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
            case 60: 
            case 62: 
            case 63: 
            case 64: 
            case 66: {
                if (bl) {
                    this.c(5, 1);
                    break;
                }
                this.c(4, 1);
                break;
            }
            case 59: {
                if (this.g == 0) {
                    if (bl) {
                        this.c(5, 1);
                        break;
                    }
                    this.c(4, 1);
                    break;
                }
                if (this.g < 3) {
                    this.E[0] = this.g;
                    this.c(8, 1);
                    break;
                }
                if (this.g != 10 && this.g != 11) break;
                this.E[0] = this.g;
                this.c(9, 1);
                break;
            }
            case 61: {
                if (this.J == 29) {
                    this.c(3, 1);
                    break;
                }
                this.c(4, 1);
                break;
            }
            case 65: {
                this.c(6, 1);
            }
        }
        return true;
    }

    private void f(int n) {
        if (this.h == 12) {
            return;
        }
        this.B -= n;
        this.n.a(this.c >> 8, (this.d >> 8) + this.b[1], n, n > main.e.k());
    }

    private int[] x() {
        if (this.b == null) {
            this.g();
        }
        return this.b;
    }

    private boolean y() {
        int n;
        int n2;
        if (!this.a[3]) {
            return false;
        }
        d d2 = main.a.c[main.f.c];
        if (this.d + (this.b[1] << 8) > d2.d + (d2.b[3] << 8)) {
            return false;
        }
        if (this.d + (this.b[3] << 8) < d2.d + (d2.b[1] << 8)) {
            return false;
        }
        return this.c > d2.c ? d2.c >= (n2 = this.c + (this.b[0] - d2.x()[2] << 8)) : d2.c <= (n = this.c + (this.b[2] - d2.x()[0] << 8));
    }

    final boolean a(d object) {
        int n;
        Object object2 = object;
        byte[] byArray = ((d)object2).m.d;
        for (n = 0; n < 4; ++n) {
            ((d)object2).H[n] = 0;
        }
        if (((d)object2).q != -1 && byArray != null) {
            int n2 = (((d)object2).q << 3) + 4 + 1;
            byArray[n2] = byArray[n2];
            int n3 = (((d)object2).q << 3) + 4 + 3;
            byArray[n3] = byArray[n3];
            if (byArray[(((d)object2).q << 3) + 4 + 2] > 0) {
                int n4 = (((d)object2).q << 3) + 4 + 2;
                byArray[n4] = byArray[n4];
            }
            if (byArray[(((d)object2).q << 3) + 4] > 0) {
                int n5 = (((d)object2).q << 3) + 4;
                byArray[n5] = byArray[n5];
            }
            if (((d)object2).a[0]) {
                ((d)object2).H[0] = -byArray[(((d)object2).q << 3) + 4 + 2];
                ((d)object2).H[2] = -byArray[(((d)object2).q << 3) + 4];
            } else {
                ((d)object2).H[0] = byArray[(((d)object2).q << 3) + 4];
                ((d)object2).H[2] = byArray[(((d)object2).q << 3) + 4 + 2];
            }
            ((d)object2).H[1] = byArray[(((d)object2).q << 3) + 4 + 1];
            ((d)object2).H[3] = byArray[(((d)object2).q << 3) + 4 + 3];
        }
        object2 = ((d)object2).H;
        boolean bl = false;
        Object object3 = object2;
        n = ((d)object).d;
        int n6 = ((d)object).c;
        object2 = this;
        if (object3[0] != object3[2]) {
            object = super.x();
            n6 = n6 - ((d)object2).c >> 8;
            n = n - ((d)object2).d >> 8;
            if (n6 + object3[0] > object[2] || n + object3[1] > object[3]) {
                return false;
            }
            if (n6 + object3[2] >= object[0] && n + object3[3] >= object[1]) {
                return true;
            }
        }
        return false;
    }

    private void a(int n, boolean bl, boolean bl2) {
        if (main.f.H > 0) {
            return;
        }
        if (n > 0) {
            if ((n -= main.e.m()) <= 0) {
                n = 1;
            }
            this.n.a(this.c >> 8, (this.d >> 8) + this.b[1] - this.b[3], n, false);
            main.e.M -= n;
        }
        if (bl) {
            if (!this.a[0]) {
                this.b(0, 9);
            } else {
                this.b(0, 11);
            }
        } else if (this.a[0]) {
            this.b(0, 9);
        } else {
            this.b(0, 11);
        }
        main.f.H = 20;
    }

    private void z() {
        this.n.j = -1;
        if (this.g == 25) {
            main.d.e(this.J);
        }
        if (main.f.K == 702) {
            return;
        }
        switch (this.g) {
            case 0: {
                return;
            }
            case 1: {
                if (!this.e(7680, this.J + 1)) break;
                this.c(18, 1);
                main.f.d = this.J;
                return;
            }
            case 2: {
                if (!this.e(7680, this.J + 1)) break;
                this.c(0, 1);
                main.f.b(4, 0);
                main.a.c[this.J + 2].c(21, 1);
                return;
            }
            case 20: {
                d d2 = this;
                if (!d2.y) break;
                if (this.v == 1) {
                    main.a.c[this.J + 3].c = main.a.a + 120 << 8;
                    main.a.c[this.J + 3].d = main.a.b + 170 << 8;
                    main.a.c[this.J + 3].a[3] = true;
                    this.c(0, 1);
                    main.f.b(5, 0);
                    return;
                }
                this.c(2, 1);
                main.f.b(16, 0);
                this.v = 1;
                return;
            }
            case 24: {
                d d3 = this;
                if (!d3.y) break;
                this.a[3] = false;
                main.f.d = main.f.c;
                d3 = main.a.c[main.f.c];
                d3.a[2] = true;
                d3.a[3] = true;
                d3.c = this.c - 512;
                d3.d = this.d;
                d3.c(main.e.G[main.e.I], 1);
                main.a.a(-1, -1);
                main.f.b(7, 0);
                main.a.c[this.J + 3].I = 1;
                return;
            }
            case 19: {
                d d4 = this;
                if (!d4.y) break;
                this.c(5, 1);
                main.f.b(15, 0);
                return;
            }
            case 18: {
                d d5 = this;
                if (!d5.y) break;
                if (this.I == 1) {
                    this.c(17, 1);
                    main.a.c[this.J + 1].c(19, 1);
                    this.I = 2;
                    main.f.b(14, 0);
                    return;
                }
                this.c(18, 1);
                main.f.b(1, 0);
                this.I = 1;
                return;
            }
            case 3: {
                d d6 = this;
                if (!d6.y) break;
                this.c(4, 1);
                main.a.c[this.J - 1].c(1, 1);
                main.f.b(0, 0);
                return;
            }
            case 5: {
                if (this.I == 1) {
                    if (!this.e(7680, this.J + 1)) break;
                    this.c(6, 1);
                    main.a.c[this.J - 1].c(20, 1);
                    main.f.b(3, 0);
                    return;
                }
                if (main.d.b(this)) break;
                this.I = 1;
                main.f.b(2, 0);
                return;
            }
            case 7: {
                d d7 = this;
                if (!d7.y) break;
                this.c(8, 1);
                main.f.b(6, 0);
                return;
            }
            case 8: {
                d d8 = this;
                if (!d8.y) break;
                this.c(9, 1);
                main.a.c[this.J - 3].c(24, 1);
                return;
            }
            case 9: {
                d d9 = this;
                if (!d9.y) break;
                if (this.I == 1) {
                    main.f.D = false;
                    main.f.b(4112);
                    main.f.a(2, -1);
                    this.I = 2;
                    return;
                }
                if (this.I == 2) {
                    if (this.i(false)) {
                        this.I = 3;
                        return;
                    }
                    if (main.f.i == 0) break;
                    main.f.a("\u041d\u0435\u043f\u0440\u0430\u0432\u0438\u043b\u044c\u043d\u043e!");
                    return;
                }
                if (this.I != 3 || this.i(false)) break;
                this.c(10, 1);
                this.I = 0;
                main.f.a(-1, -1);
                return;
            }
            case 10: {
                d d10 = this;
                if (!d10.y) break;
                if (this.I == 1) {
                    main.f.b(8256);
                    main.f.a(4, -1);
                    this.I = 2;
                    return;
                }
                if (this.I == 2) {
                    if (this.j(false)) {
                        this.I = 3;
                        return;
                    }
                    if (main.f.i == 0) break;
                    main.f.a("\u041d\u0435\u043f\u0440\u0430\u0432\u0438\u043b\u044c\u043d\u043e!");
                    return;
                }
                if (this.I == 3) {
                    if (this.j(false)) break;
                    this.c(11, 1);
                    this.I = 0;
                    main.f.a(-1, -1);
                    return;
                }
                main.f.b(8, 0);
                this.I = 1;
                return;
            }
            case 11: {
                d d11 = this;
                if (!d11.y) break;
                if (this.I == 1) {
                    main.f.b(1028);
                    main.f.a(1, -1);
                    this.I = 2;
                    return;
                }
                if (this.I == 2) {
                    if (this.h(false)) {
                        this.I = 3;
                        return;
                    }
                    if (main.f.i == 0) break;
                    main.f.a("\u041d\u0435\u043f\u0440\u0430\u0432\u0438\u043b\u044c\u043d\u043e!");
                    return;
                }
                if (this.I == 3) {
                    if (main.a.c[main.f.c].g != main.e.G[main.e.I] && main.a.c[main.f.c].g != main.e.H[main.e.I]) break;
                    this.c(12, 1);
                    this.I = 0;
                    main.f.a(-1, -1);
                    return;
                }
                main.f.b(9, 0);
                this.I = 1;
                return;
            }
            case 12: {
                d d12 = this;
                if (!d12.y) break;
                if (this.I == 1) {
                    main.f.b(16416);
                    main.f.a(5, -1);
                    this.I = 2;
                    return;
                }
                if (this.I == 2) {
                    if (this.f(false)) {
                        this.I = 3;
                        return;
                    }
                    if (main.f.i == 0) break;
                    main.f.a("\u041d\u0435\u043f\u0440\u0430\u0432\u0438\u043b\u044c\u043d\u043e!");
                    return;
                }
                if (this.I == 3) {
                    if (main.f.c != 0 || main.a.c[main.f.c].g != main.e.G[main.e.I] && main.a.c[main.f.c].g != main.e.H[main.e.I]) break;
                    this.c(13, 1);
                    this.I = 0;
                    main.f.a(-1, -1);
                    main.a.c[6].c(0, 1);
                    return;
                }
                main.f.b(10, 0);
                this.I = 1;
                return;
            }
            case 13: {
                if (this.I == 1) {
                    if (main.a.c[main.f.c].g != main.e.G[main.e.I] && main.a.c[main.f.c].g != main.e.H[main.e.I] || main.a.c[5].a[3] || main.a.c[6].a[3]) break;
                    main.f.D = true;
                    main.f.b(12, 0);
                    this.I = 2;
                    return;
                }
                if (this.I == 2) {
                    main.a.c[this.J - 1].c(16, 1);
                    this.I = 3;
                    return;
                }
                if (this.I == 3) break;
                if (this.I == 4) {
                    if (!this.c(2560)) break;
                    main.a.c[main.f.c].c(main.e.G[main.e.I], 1);
                    main.f.D = false;
                    main.f.b(13, 0);
                    this.I = 5;
                    return;
                }
                if (this.I == 5 || main.a.c[main.f.c].g != main.e.G[main.e.I] && main.a.c[main.f.c].g != main.e.H[main.e.I]) break;
                main.f.b(0);
                main.f.b(11, 0);
                this.I = 1;
                return;
            }
            case 15: {
                d d13 = this;
                if (!d13.y || this.I == 1) break;
                if (this.I == 2) {
                    this.I = 3;
                    return;
                }
                if (this.I == 3) break;
                main.a.c[5].a[3] = true;
                this.I = 1;
                return;
            }
            case 16: {
                d d14 = this;
                if (!d14.y) break;
                this.a[3] = false;
                main.a.c[this.J + 1].I = 4;
                main.a.c[main.f.c].b(0, main.e.H[main.e.I]);
                if (main.a.c[this.J + 1].c - main.a.c[main.f.c].c < 0) {
                    main.a.c[main.f.c].b(true);
                    return;
                }
                main.a.c[main.f.c].b(false);
                return;
            }
            case 21: {
                d d15 = this;
                if (!d15.y) break;
                this.c(15, 1);
                return;
            }
            case 22: {
                d d16 = this;
                if (!d16.y) break;
                this.c(23, 1);
                main.a.c[6].a[3] = true;
                return;
            }
            case 23: {
                d d17 = this;
                if (!d17.y) break;
                main.a.c[this.J + 2].c(20, 1);
                main.a.c[this.J + 4].I = 2;
                this.a[3] = false;
            }
        }
    }

    private void A() {
        switch (this.I) {
            case 7: {
                this.g(30, 88);
                return;
            }
            case 24: {
                this.g(50, 76);
                return;
            }
            case 25: {
                this.g(40, 107);
                this.g(50, 72);
                return;
            }
            case 26: {
                this.g(80, 63);
                return;
            }
            case 27: {
                this.g(60, 105);
                return;
            }
            case 28: {
                this.g(50, 77);
                return;
            }
            case 29: {
                this.g(50, 79);
                this.g(50, 78);
                return;
            }
            case 30: {
                this.g(50, 82);
                return;
            }
            case 31: {
                this.g(50, 83);
                this.g(60, 84);
                return;
            }
            case 32: {
                this.g(15, 94);
                this.g(30, 93);
                return;
            }
            case 33: {
                this.g(4, 96);
                this.g(30, 103);
                return;
            }
            case 34: {
                this.g(50, 85);
                return;
            }
            case 35: {
                this.g(60, 70);
                this.g(60, 71);
                return;
            }
            case 36: {
                this.g(20, 91);
                this.g(30, 90);
                return;
            }
            case 37: {
                this.g(30, 89);
                return;
            }
            case 38: {
                this.g(30, 108);
                return;
            }
            case 39: {
                this.g(30, 92);
                return;
            }
            case 40: {
                this.g(50, 80);
                this.g(60, 81);
                return;
            }
            case 41: {
                this.g(80, 60);
                return;
            }
            case 42: {
                this.g(80, 61);
                this.g(80, 62);
                return;
            }
            case 43: {
                this.g(60, 67);
                return;
            }
            case 44: {
                this.g(50, 109);
                return;
            }
            case 45: {
                this.g(60, 68);
                this.g(60, 69);
                return;
            }
            case 46: {
                this.g(15, 110);
                this.g(20, 102);
                return;
            }
            case 47: {
                this.g(80, 64);
                this.g(80, 65);
                return;
            }
            case 48: {
                this.g(15, 98);
                this.g(30, 97);
                return;
            }
            case 49: {
                this.g(4, 96);
                this.g(30, 95);
                return;
            }
            case 50: {
                this.g(40, 111);
                return;
            }
            case 51: {
                this.g(20, 87);
                this.g(40, 86);
                return;
            }
            case 52: {
                this.g(40, 112);
                return;
            }
            case 53: {
                this.g(60, 66);
                return;
            }
            case 54: {
                this.g(50, 73);
                return;
            }
            case 55: {
                this.g(50, 74);
                this.g(60, 75);
                return;
            }
            case 56: {
                this.g(4, 96);
                this.g(30, 99);
                return;
            }
            case 57: {
                this.g(15, 101);
                this.g(30, 100);
                return;
            }
            case 62: {
                this.g(50, 104);
                return;
            }
            case 63: 
            case 64: {
                this.g(100, 104);
            }
        }
    }

    private void g(int n, int n2) {
        if (this.g == 0) {
            if (!this.z) {
                this.C = a.a.a(100);
                if (main.e.U) {
                    this.C = 0;
                }
                if (this.C < n) {
                    this.z = true;
                    return;
                }
            }
        } else if (this.C < n) {
            main.e.a(n2, 1);
        }
    }

    private boolean B() {
        if (this.o == 0 && this.p == 0) {
            return false;
        }
        return this.c <= this.o || this.c >= this.p;
    }

    private boolean C() {
        if (this.o == 0 && this.p == 0) {
            return false;
        }
        return this.d <= this.o || this.d >= this.p;
    }

    private boolean D() {
        if (!this.a[3]) {
            return false;
        }
        d d2 = main.a.c[main.f.c];
        if (this.d + (this.b[1] << 8) > d2.d + (d2.b[3] << 8) || this.d + (this.b[3] << 8) < d2.d + (d2.b[1] << 8) || this.c + (this.b[0] << 8) > d2.c + 3072 || this.c + (this.b[2] << 8) < d2.c + -3072) {
            this.z = false;
            return false;
        }
        if (this.z) {
            return false;
        }
        if (this.d + (this.b[3] << 8) >= d2.d) {
            if (d2.g == 6) {
                d2.d = this.d;
                this.z = true;
                d2.c(8, 1);
            } else if (d2.g == main.e.H[main.e.I] || d2.g == main.e.G[main.e.I]) {
                this.z = true;
            }
            return true;
        }
        if (this.d + (this.b[1] << 8) > d2.d + (d2.b[3] << 8) || this.d + (this.b[3] << 8) < d2.d + (d2.b[1] << 8) || this.c + (this.b[0] << 8) > d2.c || this.c + (this.b[2] << 8) < d2.c) {
            this.z = false;
            return false;
        }
        if (d2.g == 6) {
            d2.d = this.d;
            d2.c(15, 1);
            main.f.a(13, -1);
            this.z = true;
        }
        return true;
    }

    private static boolean E() {
        for (int i = main.a.d - 1; i >= 0; --i) {
            d d2 = main.a.c[i];
            if (d2 == null || !d2.a[3] || d2.h != 67 || !d2.z) continue;
            return true;
        }
        return false;
    }
}

