package android.content.res;
import java.io.*;
public class AssetManager { public static File dir; public InputStream open(String s) throws IOException { return new FileInputStream(new File(dir, s)); } }
