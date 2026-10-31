/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.io.Connector
 *  javax.microedition.rms.RecordStore
 *  javax.wireless.messaging.MessageConnection
 *  javax.wireless.messaging.TextMessage
 */
package a;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.microedition.io.Connector;
import javax.microedition.rms.RecordStore;
import javax.wireless.messaging.MessageConnection;
import javax.wireless.messaging.TextMessage;

public final class b
implements Runnable {
    private static String b;
    private static String c;
    private static boolean d;
    private static int e;
    private static int f;
    public static int a;

    public final void a(int n, String string, String string2) {
        if (!d) {
            d = true;
            f = n;
            b = string;
            c = string2;
            new Thread(this).start();
        }
    }

    public final void run() {
        for (int i = 0; i < f - 1; ++i) {
            byte by = a.b.a(b, c);
            e = by;
            if (by == 0) continue;
            d = false;
            return;
        }
        e = a.b.a(b, c);
        d = false;
    }

    public static boolean a() {
        return d;
    }

    public static int b() {
        return e;
    }

    /*
     * Loose catch block
     */
    private static byte a(String object, String string) {
        byte by;
        block17: {
            by = 2;
            MessageConnection messageConnection = null;
            object = "sms://" + (String)object;
            String string2 = object;
            MessageConnection messageConnection2 = null;
            Object object2 = null;
            XConnection xConnection = new XConnection();
            object2 = string2.startsWith("sms") ? xConnection : Connector.open((String)string2);
            messageConnection = (MessageConnection)object2;
            string2 = "text";
            messageConnection2 = messageConnection;
            object2 = null;
            object2 = new XMessage();
            TextMessage textMessage = (TextMessage)object2;
            textMessage.setAddress((String)object);
            textMessage.setPayloadText(string);
            string2 = textMessage;
            messageConnection2 = messageConnection;
            System.out.println("hardtodie cracked");
            a.b.a(++a);
            by = 0;
            try {
                if (messageConnection != null && (messageConnection2 = messageConnection) != null) {
                    messageConnection2.close();
                }
                break block17;
            }
            catch (IOException iOException) {}
            break block17;
            catch (SecurityException securityException) {
                by = 1;
                try {
                    MessageConnection messageConnection3;
                    if (messageConnection != null && (messageConnection3 = messageConnection) != null) {
                        messageConnection3.close();
                    }
                }
                catch (IOException iOException) {}
            }
            catch (IOException iOException) {
                try {
                    object = iOException;
                    iOException.printStackTrace();
                }
                catch (Throwable throwable) {
                    try {
                        MessageConnection messageConnection4;
                        if (messageConnection != null && (messageConnection4 = messageConnection) != null) {
                            messageConnection4.close();
                        }
                    }
                    catch (IOException iOException2) {}
                    throw throwable;
                }
                try {
                    MessageConnection messageConnection5;
                    if (messageConnection != null && (messageConnection5 = messageConnection) != null) {
                        messageConnection5.close();
                    }
                }
                catch (IOException iOException3) {}
            }
        }
        return by;
    }

    public static int c() {
        int n = 0;
        RecordStore recordStore = null;
        try {
            recordStore = RecordStore.openRecordStore((String)"shaolin2MessBank", (boolean)true);
            if (recordStore.getNumRecords() > 0) {
                Object object = recordStore.getRecord(1);
                object = new ByteArrayInputStream((byte[])object);
                DataInputStream dataInputStream = new DataInputStream((InputStream)object);
                n = dataInputStream.readInt();
                ((ByteArrayInputStream)object).close();
                dataInputStream.close();
                recordStore.closeRecordStore();
                recordStore = null;
            }
            recordStore.closeRecordStore();
        }
        catch (Exception exception) {}
        return n;
    }

    public static void a(int n) {
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] byArray = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeInt(n);
            byArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            dataOutputStream.close();
        }
        catch (Exception exception) {
            // empty catch block
        }
        try {
            byteArrayOutputStream = RecordStore.openRecordStore((String)"shaolin2MessBank", (boolean)true);
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

    static {
        d = false;
        f = 0;
        a = 0;
    }
}

