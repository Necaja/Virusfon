package android.content;
public interface SharedPreferences {
   boolean getBoolean(String k, boolean d);
   Editor edit();
   interface Editor { Editor putBoolean(String k, boolean v); void apply(); }
}
