package javax.microedition.rms;

import compat.Res;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/** RMS поверх файлов в filesDir/rms/<name>.rms. Записи нумеруются с 1, как в J2ME. */
public class RecordStore {
   private final String name;
   private final ArrayList<byte[]> records = new ArrayList<byte[]>();

   private RecordStore(String name) {
      this.name = name;
   }

   private static File file(String name) {
      File dir = new File(Res.context().getFilesDir(), "rms");
      dir.mkdirs();
      return new File(dir, name.replaceAll("[^A-Za-z0-9_.-]", "_") + ".rms");
   }

   public static synchronized RecordStore openRecordStore(String name, boolean createIfNecessary) throws RecordStoreException {
      File f = file(name);
      RecordStore rs = new RecordStore(name);
      if (f.exists()) {
         try {
            DataInputStream in = new DataInputStream(new FileInputStream(f));
            try {
               int n = in.readInt();
               for (int i = 0; i < n; i++) {
                  byte[] b = new byte[in.readInt()];
                  in.readFully(b);
                  rs.records.add(b);
               }
            } finally {
               in.close();
            }
         } catch (IOException e) {
            throw new RecordStoreException(e.toString());
         }
      } else if (!createIfNecessary) {
         throw new RecordStoreException("not found: " + name);
      }
      return rs;
   }

   public static synchronized void deleteRecordStore(String name) throws RecordStoreException {
      file(name).delete();
   }

   private synchronized void flush() throws RecordStoreException {
      try {
         DataOutputStream out = new DataOutputStream(new FileOutputStream(file(name)));
         try {
            out.writeInt(records.size());
            for (byte[] b : records) {
               out.writeInt(b.length);
               out.write(b);
            }
         } finally {
            out.close();
         }
      } catch (IOException e) {
         throw new RecordStoreException(e.toString());
      }
   }

   public synchronized int getNumRecords() throws RecordStoreException {
      return records.size();
   }

   public synchronized byte[] getRecord(int id) throws RecordStoreException {
      if (id < 1 || id > records.size()) {
         throw new RecordStoreException("invalid record id " + id);
      }
      return records.get(id - 1).clone();
   }

   public synchronized int addRecord(byte[] data, int off, int len) throws RecordStoreException {
      byte[] b = new byte[len];
      System.arraycopy(data, off, b, 0, len);
      records.add(b);
      flush();
      return records.size();
   }

   public synchronized void setRecord(int id, byte[] data, int off, int len) throws RecordStoreException {
      if (id < 1 || id > records.size()) {
         throw new RecordStoreException("invalid record id " + id);
      }
      byte[] b = new byte[len];
      System.arraycopy(data, off, b, 0, len);
      records.set(id - 1, b);
      flush();
   }

   public synchronized void closeRecordStore() throws RecordStoreException {
      // данные пишутся сразу при add/set — закрывать нечего
   }
}
