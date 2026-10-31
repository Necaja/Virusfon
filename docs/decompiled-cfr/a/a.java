/*
 * Decompiled with CFR 0.152.
 */
package a;

import java.util.Random;

public final class a {
    private static Random a = new Random();
    private static int b = 0;
    private static int c = 0;

    public static int a(int n) {
        return Math.abs(a.nextInt() % n);
    }

    public static boolean b(int n) {
        if (++b >= n) {
            b = 0;
            return true;
        }
        return false;
    }

    public static boolean c(int n) {
        if (++c >= n) {
            c = 0;
            return true;
        }
        return false;
    }
}

