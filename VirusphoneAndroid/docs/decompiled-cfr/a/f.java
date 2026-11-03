/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.media.Manager
 *  javax.microedition.media.Player
 */
package a;

import java.io.InputStream;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;

public final class f {
    private Player a;
    private String[] b = new String[]{"audio/x-tone-seq", "audio/midi", "audio/x-wav"};
    private String c = "";

    public final void a(String string, boolean bl, int n) {
        n = 1;
        bl = true;
        if (!((f)((Object)exception2)).c.equals(string)) {
            ((f)((Object)exception2)).a();
            ((f)((Object)exception2)).b(string, bl, n);
            try {
                if (((f)((Object)exception2)).a != null) {
                    ((f)((Object)exception2)).a.realize();
                    ((f)((Object)exception2)).a.prefetch();
                    ((f)((Object)exception2)).a.start();
                    ((f)((Object)exception2)).c = string;
                }
                return;
            }
            catch (Exception exception) {
                Exception exception2 = exception;
                exception.printStackTrace();
            }
        }
    }

    public final void b(String object, boolean bl, int n) {
        try {
            object = this.getClass().getResourceAsStream("/" + (String)object + ".mid");
            if (object != null) {
                this.a = Manager.createPlayer((InputStream)object, (String)this.b[n]);
                this.a.realize();
                if (bl) {
                    this.a.setLoopCount(-1);
                }
            }
            System.gc();
            return;
        }
        catch (Exception exception) {
            object = exception;
            exception.printStackTrace();
            return;
        }
    }

    public final void a() {
        try {
            if (this.a != null) {
                this.a.stop();
                this.a.deallocate();
                this.a.close();
                this.a = null;
                this.c = "";
                System.gc();
            }
            return;
        }
        catch (Exception exception) {
            return;
        }
    }
}

