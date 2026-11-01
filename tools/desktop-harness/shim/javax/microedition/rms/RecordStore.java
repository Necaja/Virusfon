package javax.microedition.rms;
import java.io.*; import java.util.*;
public class RecordStore { private final String name; private final ArrayList<byte[]> r=new ArrayList<>();
  private RecordStore(String n){name=n;} private static File f(String n){ compat.Res.files.mkdirs(); return new File(compat.Res.files,n.replaceAll("[^A-Za-z0-9_.-]","_")+".rms");}
  public static RecordStore openRecordStore(String n,boolean c) throws RecordStoreException { RecordStore s=new RecordStore(n); File x=f(n); if(x.exists()){ try(DataInputStream in=new DataInputStream(new FileInputStream(x))){int k=in.readInt(); for(int i=0;i<k;i++){byte[] b=new byte[in.readInt()]; in.readFully(b); s.r.add(b);} }catch(IOException e){throw new RecordStoreException(e.toString());} } else if(!c) throw new RecordStoreException("nf"); return s;}
  public static void deleteRecordStore(String n) throws RecordStoreException { f(n).delete(); }
  private void flush() throws RecordStoreException { try(DataOutputStream o=new DataOutputStream(new FileOutputStream(f(name)))){o.writeInt(r.size()); for(byte[] b:r){o.writeInt(b.length);o.write(b);} }catch(IOException e){throw new RecordStoreException(e.toString());} }
  public int getNumRecords() throws RecordStoreException {return r.size();}
  public byte[] getRecord(int id) throws RecordStoreException { if(id<1||id>r.size()) throw new RecordStoreException("id"); return r.get(id-1).clone(); }
  public int addRecord(byte[] d,int o,int l) throws RecordStoreException { r.add(Arrays.copyOfRange(d,o,o+l)); flush(); return r.size(); }
  public void setRecord(int id,byte[] d,int o,int l) throws RecordStoreException { r.set(id-1,Arrays.copyOfRange(d,o,o+l)); flush(); }
  public void closeRecordStore() throws RecordStoreException {} }
