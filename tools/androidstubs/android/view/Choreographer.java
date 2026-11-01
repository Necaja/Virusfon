package android.view;
public class Choreographer {
   public interface FrameCallback { void doFrame(long frameTimeNanos); }
   public static Choreographer getInstance() { return null; }
   public void postFrameCallback(FrameCallback cb) {}
}
