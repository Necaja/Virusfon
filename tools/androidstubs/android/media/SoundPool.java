package android.media;
public class SoundPool { public static class Builder { public Builder setMaxStreams(int n){return this;} public SoundPool build(){return new SoundPool();} }
 public int load(String p,int prio){return 0;} public int play(int id,float l,float r,int prio,int loop,float rate){return 0;} }
