/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.rms.RecordStore
 */
package main;

import a.d;
import a.g;
import a.h;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import javax.microedition.rms.RecordStore;
import main.cMIDlet;
import main.e;
import main.f;

public final class b {
    private static String[] a = new String[]{"\u041d\u0443\u0436\u043d\u044b \u043a\u0430\u043a \u0432\u043e\u0437\u0434\u0443\u0445 \u0432\u0441\u0435\u0433\u0434\u0430 \u043a \u043e\u043f\u043b\u0430\u0442\u0435 \u043f\u0440\u0438\u0433\u043e\u0440\u0448\u043d\u0438 \u0434\u0435\u043d\u0435\u0433, \u0430 \u0442\u044b \u0440\u0430\u0441\u0442\u0440\u0430\u0442\u0438\u043b. \u0410 \u043c\u043e\u0436\u0435\u0442 \u043f\u0440\u043e\u0441\u0442\u043e \u043d\u0435 \u0437\u0430\u0440\u0430\u0431\u043e\u0442\u0430\u043b. \u0414\u0435\u0440\u0436\u0438, \u0434\u0440\u0443\u0436\u0438\u0449\u0435, \u043e\u0442\u0434\u0430\u0448\u044c \u0432 \u0441\u0443\u0431\u0431\u043e\u0442\u0443. \u041b\u0435\u0442 \u0447\u0435\u0440\u0435\u0437 \u0434\u0432\u0435\u0441\u0442\u0438, \u043a\u043e\u0433\u0434\u0430 \u0442\u044b \u0441\u0442\u0430\u043d\u0435\u0448\u044c \u043c\u0438\u043b\u043b\u0438\u043e\u043d\u0435\u0440\u043e\u043c", "\u041d\u0430\u0434 \u0441\u0443\u043d\u0434\u0443\u043a\u0430\u043c\u0438 \u0432\u0440\u0430\u0433\u0438 \u0442\u0440\u044f\u0441\u0443\u0442\u0441\u044f. \u041c\u044b \u0443\u0432\u0435\u043b\u0438\u0447\u0438\u043c \u043f\u0440\u0438\u0440\u043e\u0441\u0442 \u0440\u0435\u0441\u0443\u0440\u0441\u0430. \u0417\u0430\u0431\u0440\u0430\u0442\u044c \u0434\u043e\u0431\u044b\u0447\u0443 \u0433\u043e\u0442\u043e\u0432\u044c\u0442\u0435\u0441\u044c \u0441\u0430\u043c\u0438, \u0435\u0434\u0438\u043d\u043e\u043b\u0438\u0447\u043d\u043e", "\u0422\u044b \u0445\u043e\u0447\u0435\u0448\u044c \u0441\u0442\u0430\u0442\u0443\u0441 \u0441\u0435\u0431\u0435 \u043e\u0442\u043b\u0438\u0447\u043d\u044b\u0439, \u0447\u0442\u043e\u0431 \u0432\u044b\u0431\u043e\u0440 \u0431\u044b\u043b \u0442\u0432\u043e\u0439 \u043d\u0435\u043e\u0433\u0440\u0430\u043d\u0438\u0447\u0435\u043d? \u041e\u0442\u043a\u0440\u043e\u0435\u0442 \u0434\u043e\u0441\u0442\u0443\u043f \u043a\u043e \u0432\u0441\u0435\u043c \u043d\u0430\u0437\u0432\u0430\u043d\u044c\u044f\u043c \u0432 \u043a\u0430\u0440\u044c\u0435\u0440\u043d\u043e\u043c \u0440\u043e\u0441\u0442\u0435", "\u041c\u043e\u043d\u0430\u0445\u0438 \u0432 \u0425\u0440\u0430\u043c\u0435 \u043f\u0440\u043e\u0431\u0438\u043b\u0438 \u043f\u043e\u043b\u043d\u043e\u0447\u044c. \u042d\u0439, \u0447\u0442\u043e \u0441 \u0420\u0443\u0441\u043b\u0430\u043d\u043e\u043c? \u0421\u043a\u043e\u0440\u0435\u0439 \u043d\u0430 \u043f\u043e\u043c\u043e\u0449\u044c! \u0411\u0430\u043b\u044c\u0437\u0430\u043c \u043d\u0430 \u0448\u0440\u0430\u043c\u044b \u043f\u0440\u043e\u043b\u044c\u0435\u0442\u0441\u044f \u043f\u0435\u0441\u043d\u0435\u0439. \u0422\u0441\u0441... \u0414\u044b\u0448\u0438\u0442 \u0441\u0430\u043c \u043e\u043d. \u0420\u0443\u0441\u043b\u0430\u043d, \u0432\u043e\u0441\u043a\u0440\u0435\u0441\u043d\u0438! \u041d\u0430 \u043f\u044f\u0442\u044c \u043c\u0438\u043d\u0443\u0442 \u043b\u0438\u0448\u044c \u0432\u0440\u0430\u0433 \u0442\u0438\u0448\u0435 \u0441\u0442\u0430\u043d\u0435\u0442. \u0423\u0441\u043f\u0435\u0435\u0448\u044c? \u0422\u0443\u0442 \u0443\u0436", "\u0420\u0430\u0437\u0431\u0438\u0442\u043e \u0441\u0435\u0440\u0434\u0446\u0435? \u0414\u0443\u0448\u0430 \u0440\u0430\u0437\u0431\u0438\u0442\u0430? \u0423 \u0432\u0430\u0441 \u0432\u0441\u0435\u0433\u043e \u043b\u0438\u0448\u044c \u043d\u0435\u0445\u0432\u0430\u0442\u043a\u0430 \u043a\u0440\u0438\u0442\u0430! \u041c\u044b \u0432\u0430\u043c \u0431\u0435\u0441\u043f\u043b\u0430\u0442\u043d\u043e \u0441\u0434\u0430\u0434\u0438\u043c \u0432 \u0430\u0440\u0435\u043d\u0434\u0443 \u043a\u0440\u0438\u0442 100 \u043f\u0440\u043e\u0446\u0435\u043d\u0442\u043e\u0432. \u0410\u043f\u043b\u043e\u0434\u0438\u0441\u043c\u0435\u043d\u0442\u044b! \u0410\u0442\u0430\u043a\u0430 \u0432\u0434\u0432\u043e\u0435 \u0441\u0438\u043b\u044c\u043d\u0435\u0435 \u0441\u0442\u0430\u043d\u0435\u0442. \u041d\u0443 \u0447\u0442\u043e, \u0434\u043e\u0432\u043e\u043b\u044c\u043d\u044b?", "\u0422\u044b \u0431\u044b\u043b \u043e\u0442\u0432\u0430\u0436\u043d\u044b\u043c, \u0442\u044b \u0431\u044b\u043b \u0431\u0435\u0441\u0441\u0442\u0440\u0430\u0448\u043d\u044b\u043c. \u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c \u0432\u0430\u0436\u043d\u043e, \u0447\u0442\u043e \u0431\u0443\u0434\u0435\u0442 \u0434\u0430\u043b\u044c\u0448\u0435? \u0412\u0434\u043e\u0445\u043d\u0443\u043b\u0438 \u0433\u043b\u0443\u0431\u0436\u0435, \u043f\u0440\u044f\u043c\u0435\u0435 \u043f\u043b\u0435\u0447\u0438. \u041d\u0430\u0448 forum.fonzo \u0432\u0441\u0435 \u0440\u0430\u043d\u044b \u043b\u0435\u0447\u0438\u0442. \u0417\u0430\u0436\u043c\u0438 \u043c\u043e\u043d\u0435\u0442\u0443, \u0420\u0443\u0441\u043b\u0430\u043d, \u0432 \u043a\u0430\u0440\u043c\u0430\u043d\u0435. \u0421\u0442\u0440\u0435\u043b\u043e\u0439 \u043f\u043e \u0441\u0432\u0435\u0442\u0443"};
    private static int[] b = new int[]{1, 1, 1, 1, 1, 2};
    private static int[] c = new int[]{-1, 1, 1, -1, 1, 1};
    private static int d = 0;
    private static int e = 0;
    private static boolean f = false;
    private static a.b g = new a.b();
    private static String[] h = new String[]{"06", "03", "04", "02", "10", "01"};

    public static void a(int n) {
        a.d.a(false);
        d = n;
        f = true;
    }

    /*
     * Unable to fully structure code
     */
    public static boolean a() {
        block25: {
            if (!main.b.f) break block25;
            a.h.a(main.f.g, 536648);
            switch (main.b.e) {
                case 0: 
                case 1: {
                    if (main.b.c[main.b.d] != 0) ** GOTO lbl9
                    main.b.a("\u042d\u0442\u0430 \u0444\u0443\u043d\u043a\u0446\u0438\u044f \u0432\u043a\u043b\u044e\u0447\u0435\u043d\u0430", 240, 150, 85);
                    if (!a.d.c()) break;
                    ** GOTO lbl86
lbl9:
                    // 1 sources

                    var0 = null;
                    var0 = main.b.a[main.b.d] + ".";
                    main.b.a(var0, 240, 150, 85);
                    if (!a.d.c() || a.d.f()) break;
                    a.d.a(main.f.g, "\u0414\u0430", "\u041d\u0435\u0442");
                    if (main.b.e == 1) {
                        if (main.f.d(49184)) {
                            a.b.a = a.b.c();
                            if (main.b.b[main.b.d] - a.b.a <= 0) {
                                main.b.e = 3;
                            } else {
                                var0 = "106610989";
                                var1_2 = "6200301yhuo001," + cMIDlet.a.getAppProperty("GameID") + "," + cMIDlet.a.getAppProperty("Code") + "," + "0001," + cMIDlet.a.getAppProperty("Term") + "," + main.b.h[main.b.d];
                                main.b.g.a(main.b.b[main.b.d] - a.b.a, var0, var1_2);
                                main.b.e = 2;
                            }
                            a.d.a(false);
                            break;
                        }
                        if (!main.f.d(65536)) break;
                        main.b.e = 5;
                        break;
                    }
                    main.b.e = 1;
                    break;
                }
                case 2: {
                    main.b.a("\u041e\u0442\u043f\u0440\u0430\u0432\u043a\u0430 \u043c\u0430\u043d\u0438 ...", 240, 150, 85);
                    if (!a.d.c() || a.b.a()) break;
                    a.d.a(false);
                    if (a.b.b() == 0) {
                        main.b.e = 3;
                        break;
                    }
                    main.b.e = 4;
                    break;
                }
                case 3: {
                    main.b.a("\u0423\u0441\u043f\u0435\u0445 \u043e\u043f\u043b\u0430\u0442\u044b. \u0412\u043f\u0435\u0440\u0435\u0434, \u0440\u0435\u0431\u044f\u0442\u0430!", 240, 150, 85);
                    if (!a.d.c()) break;
                    switch (main.b.d) {
                        case 0: {
                            main.f.a(20000);
                            main.f.a("\u041f\u043e\u043b\u0443\u0447\u0435\u043d\u043e 20000 \u0437\u043e\u043b\u043e\u0442\u0430");
                            main.e.a(53, 2);
                            break;
                        }
                        case 1: {
                            main.e.U = true;
                            break;
                        }
                        case 2: {
                            for (var0_1 = 0; var0_1 < main.e.k.length; ++var0_1) {
                                main.e.a(var0_1);
                            }
                            break;
                        }
                        case 3: {
                            main.e.L = main.e.i();
                            main.e.M = main.e.h();
                            main.f.H = 30000;
                            break;
                        }
                        case 4: {
                            main.e.V = true;
                            break;
                        }
                        case 5: {
                            main.e.W = true;
                            main.f.a(5000);
                            main.e.a(53, 3);
                        }
                    }
                    a.b.a(a.b.a -= main.b.b[main.b.d]);
                    if (main.b.c[main.b.d] > 0) {
                        v0 = main.b.d;
                        main.b.c[v0] = main.b.c[v0] - 1;
                    }
                    main.b.c();
                    ** GOTO lbl86
                }
                case 4: {
                    main.b.a("\u0417\u0430\u0431\u044b\u043b\u0438 \u0434\u0435\u043d\u044c\u0433\u0438? \u041d\u0435 \u043e\u0433\u043e\u0440\u0447\u0430\u0439\u0442\u0435\u0441\u044c. \u0427\u0443\u0442\u044c \u043e\u0442\u0434\u043e\u0445\u043d\u0438\u0442\u0435 \u0438 \u0432\u043e\u0437\u0432\u0440\u0430\u0449\u0430\u0439\u0442\u0435\u0441\u044c!", 240, 150, 85);
                    if (!a.d.c()) break;
                    main.b.e = 0;
                    a.d.a(false);
                    break;
                }
                case 5: {
                    if (!a.d.c()) break;
                    switch (main.b.d) {
                        case 5: {
                            cMIDlet.b.f();
                        }
                    }
lbl86:
                    // 4 sources

                    main.b.e = 0;
                    main.b.f = false;
                    a.d.a(false);
                }
            }
        }
        return main.b.f;
    }

    private static void c() {
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] byArray = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            for (int i = 0; i < c.length; ++i) {
                dataOutputStream.writeInt(c[i]);
            }
            dataOutputStream.writeBoolean(main.e.U);
            dataOutputStream.writeBoolean(main.e.V);
            dataOutputStream.writeBoolean(main.e.W);
            byArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            dataOutputStream.close();
        }
        catch (Exception exception) {
            // empty catch block
        }
        try {
            byteArrayOutputStream = RecordStore.openRecordStore((String)"buylike", (boolean)true);
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

    public static void b() {
        RecordStore recordStore = null;
        try {
            recordStore = RecordStore.openRecordStore((String)"buylike", (boolean)true);
            if (recordStore.getNumRecords() > 0) {
                Object object = recordStore.getRecord(1);
                object = new ByteArrayInputStream((byte[])object);
                DataInputStream dataInputStream = new DataInputStream((InputStream)object);
                for (int i = 0; i < c.length; ++i) {
                    main.b.c[i] = dataInputStream.readInt();
                }
                main.e.U = dataInputStream.readBoolean();
                main.e.V = dataInputStream.readBoolean();
                main.e.W = dataInputStream.readBoolean();
                ((ByteArrayInputStream)object).close();
                dataInputStream.close();
            }
            recordStore.closeRecordStore();
            return;
        }
        catch (Exception exception) {
            System.out.println(exception.toString());
            return;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static void a(String string, int n, int n2, int n3) {
        a.h.a(main.f.g, 0, 85, 240, 150, 4263240, 16706981);
        a.h.a(main.f.g, 1, 86, 238, 148, 16706981, 0x8C8000);
        a.d.a(main.f.g, string, 15597476, 240 - (238 - a.g.a.stringWidth("\u0432\u0432\u043e\u0434\u0438\u0442\u044c")) + 4 >> 1, 91, 240 - a.g.a.stringWidth("\u0432\u0432\u043e\u0434\u0438\u0442\u044c"), 142);
        if (main.f.d(51488)) {
            if (a.d.c()) {
                if (a.d.d()) return;
                main.f.L = false;
                return;
            }
            a.d.b();
            return;
        }
        if (!main.f.d(1028)) return;
        if (a.d.c()) {
            a.d.e();
            return;
        }
        a.d.b();
    }
}

