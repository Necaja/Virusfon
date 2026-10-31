/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.midlet.MIDlet
 */
package main;

import javax.microedition.midlet.MIDlet;
import main.f;

public class cMIDlet
extends MIDlet {
    static cMIDlet a;
    static f b;

    public cMIDlet() {
        a = this;
        b = new f();
    }

    public void startApp() {
        if (!f.l) {
            b.a();
            return;
        }
        b.showNotify();
    }

    public void pauseApp() {
        if (!f.l) {
            b.hideNotify();
        }
    }

    public void destroyApp(boolean bl) {
        f.b();
        this.notifyDestroyed();
    }
}

