/*
 * Decompiled with CFR 0.152.
 */
package a;

import java.io.InputStream;

public final class e {
    public static int a(InputStream inputStream) {
        int n = (inputStream.read() & 0xFF) << 8;
        int n2 = inputStream.read() & 0xFF;
        return n | n2;
    }

    public static int a(InputStream inputStream, byte[] byArray, int n, int n2) {
        try {
            for (int i = 0; i < n2; ++i) {
                byArray[n + i] = (byte)inputStream.read();
            }
            return n2;
        }
        catch (Exception exception) {
            return -1;
        }
    }
}

