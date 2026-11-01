package javax.microedition.lcdui;

/**
 * Запись команд рисования одного кадра. Нужна для интерполяции: кадр можно "проиграть" заново,
 * сдвинув помеченные группы (карта, каждый персонаж) назад к их положению в предыдущем кадре.
 * Использует только публичный API Graphics.
 */
final class Rec {
   static final int CAP = 24000, S = 7;
   private final int[] o = new int[CAP * S];
   private final Object[] r = new Object[CAP];
   int n, tag;
   boolean overflow, tagged;

   void clear() {
      n = 0;
      tag = 0;
      overflow = false;
      tagged = false;
   }

   void add(int op, int a, int b, int c, int d, int e, int f, Object ref) {
      if (n >= CAP) {
         overflow = true;
         return;
      }
      int i = n * S;
      o[i] = op | (tag << 8);
      o[i + 1] = a;
      o[i + 2] = b;
      o[i + 3] = c;
      o[i + 4] = d;
      o[i + 5] = e;
      o[i + 6] = f;
      r[n++] = ref;
   }

   /** Проиграть кадр на g. Помеченные группы сдвигаются на -(1-alpha)*delta (alpha 0 = прошлый кадр, 1 = этот). */
   void replay(Graphics g, int[] dx, int[] dy, float alpha) {
      g.reset();
      float k = 1f - alpha;
      for (int j = 0; j < n; j++) {
         int i = j * S;
         int op = o[i] & 255, t = o[i] >> 8;
         int a = o[i + 1], b = o[i + 2], c = o[i + 3], d = o[i + 4], e = o[i + 5], f = o[i + 6];
         int sx = 0, sy = 0;
         if (t != 0) {
            sx = Math.round(-k * dx[t]);
            sy = Math.round(-k * dy[t]);
         }
         switch (op) {
            case 1: g.setColor(a); break;
            case 2: g.setFont((Font) r[j]); break;
            case 3: g.setStrokeStyle(a); break;
            case 4: g.translate(a, b); break;
            case 5:
               if (t != 0 && !(a == 0 && b == 0 && c == 240 && d == 320)) {
                  g.setClip(a + sx, b + sy, c, d);
               } else {
                  g.setClip(a, b, c, d);
               }
               break;
            case 6: g.clipRect((a == 0 && c == 240) ? a : a + sx, b + sy, c, d); break;
            case 7: g.fillRect((a == 0 && c == 240) ? a : a + sx, b + sy, c, d); break;
            case 8: g.drawRect(a + sx, b + sy, c, d); break;
            case 9: g.drawLine(a + sx, b + sy, c + sx, d + sy); break;
            case 10: g.fillArc(a + sx, b + sy, c, d, e, f); break;
            case 11: g.drawArc(a + sx, b + sy, c, d, e, f); break;
            case 12: g.fillTriangle(a + sx, b + sy, c + sx, d + sy, e + sx, f + sy); break;
            case 13: g.drawRGB((int[]) r[j], 0, c, a + sx, b + sy, c, d, e == 1); break;
            case 14: g.drawScaled((Image) r[j], a + sx, b + sy, c, d); break;
            case 15: g.fillRectArgb(a + sx, b + sy, c, d, e); break;
            case 16: g.drawImage((Image) r[j], a + sx, b + sy, c); break;
            case 17: g.drawImageManip((Image) r[j], a + sx, b + sy, c, d); break;
            case 18: g.drawString((String) r[j], a + sx, b + sy, c); break;
            default: break;
         }
      }
   }
}
