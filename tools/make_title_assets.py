#!/usr/bin/env python3
"""Генератор ресурсов нового главного меню (закат в деревне).

Запуск:  python3 tools/make_title_assets.py <assets_dir> [<кадр_деревни.png>]
Кадр деревни — скриншот карты K=0 из tools/desktop-harness (нужен только чтобы вырезать настоящее розовое дерево).
Создаёт: title_bg.png, title_tree.png, title_hero.png, title_atl.png, title_cloud.png, title_glow.png, title_logo.png.
"""
import math, random, sys, os
import numpy as np
from PIL import Image, ImageDraw, ImageChops, ImageFilter, ImageFont

OUT = sys.argv[1]
FRAME = sys.argv[2] if len(sys.argv) > 2 else None
BW, BH = 720, 320
COLX = 360          # центр центральной колонки в координатах фона
SUN = (190, 176)
OUTLINE = (42, 22, 38, 255)


def hexc(h):
    return ((h >> 16) & 255, (h >> 8) & 255, h & 255)


def lerpc(a, b, t):
    return tuple(int(round(a[i] + (b[i] - a[i]) * t)) for i in range(3))


BAYER = np.array([[0, 8, 2, 10], [12, 4, 14, 6], [3, 11, 1, 9], [15, 7, 13, 5]]) / 16.0
SKY = [(0.00, hexc(0x281d52)), (0.30, hexc(0x652f6e)), (0.55, hexc(0xc34e6a)), (0.75, hexc(0xf6944e)), (1.00, hexc(0xffd986))]


def grad(stops, v):
    for i in range(len(stops) - 1):
        a, ca = stops[i]
        b, cb = stops[i + 1]
        if v <= b:
            return lerpc(ca, cb, (v - a) / (b - a))
    return stops[-1][1]


# ---------------------------------------------------------------- фон
def make_bg():
    img = np.zeros((BH, BW, 3), dtype=np.uint8)
    horizon = 205.0
    for y in range(int(horizon) + 1):
        c = grad(SKY, y / horizon)
        row = np.zeros((BW, 3), dtype=np.float32)
        row[:] = c
        d = BAYER[y % 4][np.arange(BW) % 4] - 0.5
        row += (d * 7.0)[:, None]
        img[y] = np.clip(row, 0, 255).astype(np.uint8)
    im = Image.fromarray(img, "RGB").convert("RGBA")
    d = ImageDraw.Draw(im)
    # солнце (диск; свечение — отдельный спрайт)
    d.ellipse([SUN[0] - 27, SUN[1] - 27, SUN[0] + 27, SUN[1] + 27], fill=(255, 214, 120, 255))
    d.ellipse([SUN[0] - 21, SUN[1] - 21, SUN[0] + 21, SUN[1] + 21], fill=(255, 238, 170, 255))

    def ridge(seed, base, amp, step):
        rnd = random.Random(seed)
        pts, x, y = [], -20, base
        while x < BW + 40:
            pts.append((x, y))
            x += rnd.randint(step // 2, step)
            y = base + rnd.uniform(-amp, amp)
        return pts

    for pts, col, rim in [(ridge(1, 175, 22, 48), hexc(0x8c4a78), hexc(0xd0707a)),
                          (ridge(2, 188, 16, 34), hexc(0x6b3a6c), hexc(0xb95f72)),
                          (ridge(3, 200, 10, 26), hexc(0x4a2c5e), hexc(0x8a4a6c))]:
        d.polygon(pts + [(BW + 40, 215), (-20, 215)], fill=(*col, 255))
        for i in range(len(pts) - 1):
            d.line([pts[i], pts[i + 1]], fill=(*rim, 255), width=1)
    # озеро
    for y in range(205, 262):
        v = (y - 205) / 57.0
        d.line([(0, y), (BW, y)], fill=(*lerpc(hexc(0xf29a64), hexc(0x4a2a63), min(1, v * 1.15)), 255))
    # деревня: хижины на сваях, столбы с рогами и верёвкой
    for (x, w, h) in HUTS:
        col = hexc(0x2b1a3a)
        y = 233
        d.rectangle([x - w / 2 + 2, y - h * 0.45, x + w / 2 - 2, y], fill=(*col, 255))
        d.polygon([(x - w / 2 - 4, y - h * 0.4), (x, y - h), (x + w / 2 + 4, y - h * 0.4)], fill=(*hexc(0x1e1230), 255))
        d.line([(x - w / 2 - 4, y - h * 0.4), (x, y - h)], fill=(*hexc(0xb8723a), 255))
        d.line([(x + w / 2 + 4, y - h * 0.4), (x, y - h)], fill=(*hexc(0x7a4a3a), 255))
        d.rectangle([x - w / 2 + 3, y, x - w / 2 + 5, y + 8], fill=(*col, 255))
        d.rectangle([x + w / 2 - 5, y, x + w / 2 - 3, y + 8], fill=(*col, 255))
    for x in POSTS:
        d.rectangle([x - 2, 190, x + 2, 238], fill=(*hexc(0x3a2236), 255))
        d.polygon([(x - 9, 196), (x - 2, 192), (x - 2, 197)], fill=(*hexc(0xd9b87a), 255))
        d.polygon([(x + 9, 196), (x + 2, 192), (x + 2, 197)], fill=(*hexc(0xd9b87a), 255))
    for a, b in zip(POSTS, POSTS[1:]):
        d.arc([a, 194, b, 214], 0, 180, fill=(*hexc(0x7a4a3a), 255))
    # земля и трава
    for y in range(262, BH):
        d.line([(0, y), (BW, y)], fill=(*lerpc(hexc(0x6a4a52), hexc(0x24213a), (y - 262) / (BH - 262)), 255))
    d.rectangle([0, 270, BW, 290], fill=(*hexc(0x8a5a4e), 255))
    for y in range(270, 291):
        v = (y - 270) / 20
        d.line([(0, y), (BW, y)], fill=(*lerpc(hexc(0x9a6a56), hexc(0x6a4a52), v), 255))
    rnd = random.Random(5)
    for i in range(520):
        x = rnd.uniform(0, BW)
        y = rnd.uniform(262, BH - 2)
        hh = rnd.uniform(5, 12) * (0.7 + (y - 262) / 80)
        c = lerpc(hexc(0x3b3a4a), hexc(0x8fa05a), rnd.random() * 0.6)
        sw = rnd.uniform(-2, 2)
        d.line([(x, y), (x + sw, y - hh)], fill=(*c, 255))
    im.convert("RGB").save(os.path.join(OUT, "title_bg.png"), optimize=True)


HUTS = [(30, 40, 38), (92, 34, 30), (150, 28, 26), (226, 30, 30), (300, 30, 28), (352, 36, 34), (418, 30, 26), (478, 40, 36), (545, 34, 30), (610, 36, 32), (676, 30, 28)]
POSTS = [68, 128, 262, 400, 520, 700]


# ---------------------------------------------------------------- настоящее дерево из игры
def make_tree():
    if not FRAME:
        return False
    im = Image.open(FRAME).convert("RGB")
    X0, Y0, X1, Y1 = 362, 84, 520, 258
    px = im.load()
    out = Image.new("RGBA", (X1 - X0, Y1 - Y0), (0, 0, 0, 0))
    op = out.load()
    for y in range(Y0, Y1):
        for x in range(X0, X1):
            r, g, b = px[x, y]
            keep = False
            if r >= 170 and r - g >= 95 and b >= 40:                    # цветы
                keep = True
            elif g - b >= 12 and r > g and r < 215 and 25 < b < 125:     # кора и ветви
                if y < 200:
                    keep = not (x < 396 and y > 160) and x < 492
                else:
                    keep = 428 <= x <= 478
            if keep:
                op[x - X0, y - Y0] = (r, g, b, 255)
    # дыры в стволе от подписи «Atlantida»: закрыть по горизонтали
    a = np.array(out)
    for y in range(a.shape[0]):
        row = a[y, :, 3]
        xs = np.where(row > 0)[0]
        if len(xs) and 195 - Y0 <= y + 0 and y + Y0 >= 196 and y + Y0 <= 258:
            lo, hi = xs.min(), xs.max()
            # ствол — самый широкий связный кусок в диапазоне x 428..478
            seg = [x for x in xs if 428 - X0 <= x <= 478 - X0]
            if seg:
                s0, s1 = min(seg), max(seg)
                for x in range(s0, s1 + 1):
                    if a[y, x, 3] == 0:
                        a[y, x] = a[y, s0 + (x - s0) % max(1, (s1 - s0))]
    out = Image.fromarray(a)
    # закатный тон: тёплое смягчение, левый край (со стороны солнца) светлее
    arr = np.array(out).astype(np.float32)
    m = arr[:, :, 3] > 0
    warm = np.array([255, 170, 110], dtype=np.float32)
    arr[:, :, :3][m] = arr[:, :, :3][m] * 0.84 + warm * 0.16
    left = np.zeros_like(m)
    left[:, 1:] = m[:, 1:] & ~m[:, :-1]
    arr[:, :, :3][left] = arr[:, :, :3][left] * 0.4 + np.array([255, 200, 130], dtype=np.float32) * 0.6
    out = Image.fromarray(np.clip(arr, 0, 255).astype(np.uint8))
    bbox = out.getbbox()
    out = out.crop(bbox)
    out.save(os.path.join(OUT, "title_tree.png"), optimize=True)
    print("tree", out.size, "trunk rel", bbox)
    return True


# ---------------------------------------------------------------- персонажи со спины (в стиле игры)
class Layer:
    def __init__(self, w, h):
        self.w, self.h = w, h
        self.img = Image.new("RGBA", (w, h), (0, 0, 0, 0))

    def part(self, pts, base, shade=None, light=None, width=None):
        """Закрасить многоугольник/линию; тень справа, блик слева (ступенчатая мультяшная светотень, как в игре)."""
        m = Image.new("L", (self.w, self.h), 0)
        md = ImageDraw.Draw(m)
        if width:
            md.line(pts, fill=255, width=width)
        else:
            md.polygon(pts, fill=255)
        self.img.paste(Image.new("RGBA", (self.w, self.h), (*base, 255)), (0, 0), m)
        if shade is not None:
            sh = ImageChops.subtract(m, ImageChops.offset(m, -2, 0))
            sh = ImageChops.multiply(sh, m)
            self.img.paste(Image.new("RGBA", (self.w, self.h), (*shade, 255)), (0, 0), sh)
        if light is not None:
            li = ImageChops.subtract(m, ImageChops.offset(m, 1, 0))
            li = ImageChops.multiply(li, m)
            self.img.paste(Image.new("RGBA", (self.w, self.h), (*light, 255)), (0, 0), li)

    def finish(self):
        a = np.array(self.img)
        op = a[:, :, 3] > 0
        edge = np.zeros_like(op)
        edge[1:, :] |= op[:-1, :]
        edge[:-1, :] |= op[1:, :]
        edge[:, 1:] |= op[:, :-1]
        edge[:, :-1] |= op[:, 1:]
        edge &= ~op
        a[edge] = OUTLINE
        # закат слева: тёплая кромка поверх контура лица силуэта
        lm = op.copy()
        left = np.zeros_like(op)
        left[:, 1:] = lm[:, 1:] & ~lm[:, :-1]
        a[left, 0] = np.clip(a[left, 0].astype(int) * 0.5 + 255 * 0.5, 0, 255).astype(np.uint8)
        a[left, 1] = np.clip(a[left, 1].astype(int) * 0.5 + 190 * 0.5, 0, 255).astype(np.uint8)
        a[left, 2] = np.clip(a[left, 2].astype(int) * 0.5 + 110 * 0.5, 0, 255).astype(np.uint8)
        self.img = Image.fromarray(a)
        return self.img


def dusk(c, k=0.78):
    """Лёгкое затемнение: персонажи стоят против солнца, но цвета узнаваемы."""
    return lerpc(hexc(0x2a1838), c, k)


FW, FH = 72, 96
FRAMES = 4


def hero_frame(f):
    L = Layer(FW, FH)
    ph = f * math.pi / 2
    w1 = math.sin(ph)
    w2 = math.sin(ph + 1.3)
    cx, fy = 42, FH - 3
    skin = dusk(hexc(0xe6a77c))
    skin_s = dusk(hexc(0xb97558))
    # сандалии
    for ox in (-6, 6):
        L.part([(cx + ox - 6, fy - 4), (cx + ox + 5, fy - 4), (cx + ox + 6, fy), (cx + ox - 7, fy)], dusk(hexc(0x7a4a2a)), dusk(hexc(0x4a2a18)), dusk(hexc(0xb07a46)))
    # ноги: штаны тёмно-синие с голубой вставкой
    for ox in (-6, 2):
        L.part([(cx + ox - 1, fy - 5), (cx + ox + 7, fy - 5), (cx + ox + 7, fy - 27), (cx + ox - 1, fy - 27)], dusk(hexc(0x3d3f8a)), dusk(hexc(0x2b2766)), dusk(hexc(0x6a86d0)))
    # красная жилетка-туника (спина) с белыми рукавами
    L.part([(cx - 11, fy - 56), (cx + 11, fy - 56), (cx + 10, fy - 27), (cx - 10, fy - 27)], dusk(hexc(0xc02a3a)), dusk(hexc(0x8a1c34)), dusk(hexc(0xe2505a)))
    L.part([(cx - 10, fy - 33), (cx + 10, fy - 33), (cx + 13, fy - 24), (cx - 13, fy - 24)], dusk(hexc(0xc02a3a)), dusk(hexc(0x8a1c34)), dusk(hexc(0xe2505a)))
    # оранжево-коричневая окантовка жилета
    L.part([(cx - 11, fy - 56), (cx + 11, fy - 56), (cx + 11, fy - 54), (cx - 11, fy - 54)], dusk(hexc(0xd8883a)))
    # рукава белые, руки (правая тянется к Атлантиде)
    L.part([(cx - 17, fy - 55), (cx - 10, fy - 56), (cx - 10, fy - 42), (cx - 17, fy - 42)], dusk(hexc(0xf0ecf2)), dusk(hexc(0xb8b4d0)), dusk(hexc(0xffffff)))
    L.part([(cx + 10, fy - 56), (cx + 17, fy - 55), (cx + 18, fy - 40), (cx + 11, fy - 42)], dusk(hexc(0xf0ecf2)), dusk(hexc(0xb8b4d0)), dusk(hexc(0xffffff)))
    L.part([(cx - 17, fy - 43), (cx - 10, fy - 43), (cx - 11, fy - 31), (cx - 18, fy - 31)], skin, skin_s)
    L.part([(cx + 11, fy - 42), (cx + 18, fy - 41), (cx + 22, fy - 31), (cx + 15, fy - 30)], skin, skin_s)
    # пояс-шарф синий с узлом и хвостами по ветру
    blue, blue_s, blue_l = dusk(hexc(0x3a86d8)), dusk(hexc(0x2a58a8)), dusk(hexc(0x8ac4ff))
    L.part([(cx - 11, fy - 33), (cx + 11, fy - 33), (cx + 11, fy - 28), (cx - 11, fy - 28)], blue, blue_s, blue_l)
    L.part([(cx + 3, fy - 31), (cx + 14 + w1 * 3, fy - 27 + w2), (cx + 18 + w1 * 4, fy - 20 + w2 * 2), (cx + 10 + w1 * 3, fy - 22), (cx + 2, fy - 28)], blue, blue_s, blue_l)
    L.part([(cx - 1, fy - 29), (cx + 6 + w2 * 3, fy - 17), (cx + 10 + w2 * 3, fy - 10 + w1), (cx + 4 + w2 * 2, fy - 11), (cx - 3, fy - 26)], blue, blue_s, blue_l)
    # шея
    L.part([(cx - 3, fy - 62), (cx + 3, fy - 62), (cx + 3, fy - 56), (cx - 3, fy - 56)], skin, skin_s)
    # длинные чёрные волосы до лопаток + хвост по ветру
    hair, hair_s, hair_l = dusk(hexc(0x1d1a2e), 0.95), dusk(hexc(0x0e0c18), 0.95), dusk(hexc(0x4a4a8a), 0.85)
    L.part([(cx - 9, fy - 76), (cx + 9, fy - 76), (cx + 10, fy - 60), (cx + 8, fy - 48), (cx + 3, fy - 44), (cx - 3, fy - 44), (cx - 8, fy - 48), (cx - 10, fy - 60)], hair, hair_s, hair_l)
    L.part([(cx - 7, fy - 82), (cx + 7, fy - 82), (cx + 10, fy - 74), (cx - 10, fy - 74)], hair, hair_s, hair_l)
    # пряди у затылка
    for i, ox in enumerate((-8, -4, 0, 4, 8)):
        L.part([(cx + ox, fy - 52), (cx + ox + 3, fy - 52), (cx + ox + 1 + (i - 2) * 0.6 + w1 * 1.2, fy - 42 + i % 2 * 2)], hair, hair_s)
    # синяя повязка с двумя хвостиками, развевающимися
    L.part([(cx - 10, fy - 72), (cx + 10, fy - 72), (cx + 10, fy - 68), (cx - 10, fy - 68)], blue, blue_s, blue_l)
    for k in range(2):
        pts = [(cx + 8, fy - 72 + k * 2)]
        for i in range(1, 9):
            pts.append((cx + 8 + i * 2.6, fy - 72 + k * 2 + math.sin(ph + i * 0.6 + k) * (1 + i * 0.35) + i * 0.3))
        L.part(pts, blue, width=3)
    # большой меч в левой руке остриём вниз (как в игре клинок широкий, голубо-фиолетовый)
    blade, blade_s, blade_l = dusk(hexc(0x9ec4f4)), dusk(hexc(0x6a64d0)), dusk(hexc(0xe0f0ff))
    hx, hy = cx - 15, fy - 31
    L.part([(hx - 2, hy), (hx + 5, hy), (hx + 7, hy + 6), (hx - 18, fy - 1), (hx - 22, fy - 4), (hx - 6, hy + 3)], blade, blade_s, blade_l)
    L.part([(hx - 1, hy + 2), (hx + 3, hy + 2), (hx - 16, fy - 3), (hx - 19, fy - 5)], dusk(hexc(0x7a58d8)))
    L.part([(hx - 6, hy - 3), (hx + 8, hy - 3), (hx + 8, hy + 1), (hx - 6, hy + 1)], dusk(hexc(0xd9ae4f)), dusk(hexc(0x9c7424)), dusk(hexc(0xf4d889)))
    L.part([(hx - 1, hy - 8), (hx + 3, hy - 8), (hx + 3, hy - 3), (hx - 1, hy - 3)], dusk(hexc(0x4a2a18)), dusk(hexc(0x2a1810)))
    # рука (кулак) на рукояти
    L.part([(hx - 3, hy - 4), (hx + 5, hy - 4), (hx + 5, hy + 2), (hx - 3, hy + 2)], skin, skin_s)
    return L.finish()


def atl_frame(f):
    L = Layer(FW, FH)
    ph = f * math.pi / 2 + 0.7
    w1 = math.sin(ph)
    w2 = math.sin(ph + 1.1)
    cx, fy = 22, FH - 3
    skin = dusk(hexc(0xeab08e))
    skin_s = dusk(hexc(0xb97862))
    skin_l = dusk(hexc(0xffd2b0))
    # сандалии с ремешками
    for ox in (-5, 3):
        L.part([(cx + ox - 3, fy - 3), (cx + ox + 4, fy - 3), (cx + ox + 5, fy), (cx + ox - 4, fy)], dusk(hexc(0x8a5430)), dusk(hexc(0x4a2a18)))
        L.part([(cx + ox - 1, fy - 12), (cx + ox + 2, fy - 12), (cx + ox + 2, fy - 3), (cx + ox - 1, fy - 3)], dusk(hexc(0x6a3a22)))
    # длинные ноги
    for ox in (-5, 2):
        L.part([(cx + ox - 1, fy - 4), (cx + ox + 4, fy - 4), (cx + ox + 4, fy - 33), (cx + ox - 1, fy - 33)], skin, skin_s, skin_l)
    # фиолетовые шорты/нижняя юбка
    L.part([(cx - 8, fy - 36), (cx + 8, fy - 36), (cx + 9, fy - 30), (cx - 9, fy - 30)], dusk(hexc(0x4a2a6a)), dusk(hexc(0x2e1a48)), dusk(hexc(0x7a56a8)))
    # жёлтое платье (спина) с развевающимся подолом
    y1, y2 = dusk(hexc(0xf8d82a)), dusk(hexc(0xc89a14))
    L.part([(cx - 7, fy - 56), (cx + 7, fy - 56), (cx + 8, fy - 44), (cx - 8, fy - 44)], y1, y2, dusk(hexc(0xfff070)))
    L.part([(cx - 8, fy - 45), (cx + 8, fy - 45), (cx + 12 + w1 * 1.5, fy - 33), (cx - 12 + w1 * 1.5, fy - 33)], y1, y2, dusk(hexc(0xfff070)))
    # бирюзовый поясок
    L.part([(cx - 8, fy - 46), (cx + 8, fy - 46), (cx + 8, fy - 43), (cx - 8, fy - 43)], dusk(hexc(0x2ab4c0)), dusk(hexc(0x1a7890)), dusk(hexc(0x7aeaf0)))
    L.part([(cx + 2, fy - 44), (cx + 9 + w2 * 2, fy - 40), (cx + 11 + w2 * 3, fy - 34), (cx + 6 + w2 * 2, fy - 36)], dusk(hexc(0x2ab4c0)), dusk(hexc(0x1a7890)))
    # плечи и спина голые, лямки платья
    L.part([(cx - 8, fy - 62), (cx + 8, fy - 62), (cx + 8, fy - 55), (cx - 8, fy - 55)], skin, skin_s, skin_l)
    L.part([(cx - 6, fy - 62), (cx - 4, fy - 62), (cx - 4, fy - 56), (cx - 6, fy - 56)], y1)
    L.part([(cx + 4, fy - 62), (cx + 6, fy - 62), (cx + 6, fy - 56), (cx + 4, fy - 56)], y1)
    # руки: правая на бедре (локоть наружу), левая вдоль тела к герою
    L.part([(cx + 7, fy - 61), (cx + 11, fy - 60), (cx + 15, fy - 50), (cx + 11, fy - 47)], skin, skin_s, skin_l)
    L.part([(cx + 11, fy - 49), (cx + 15, fy - 49), (cx + 9, fy - 42), (cx + 6, fy - 44)], skin, skin_s)
    L.part([(cx - 11, fy - 61), (cx - 7, fy - 61), (cx - 9, fy - 46), (cx - 13, fy - 46)], skin, skin_s, skin_l)
    L.part([(cx - 14, fy - 46), (cx - 9, fy - 46), (cx - 9, fy - 40), (cx - 13, fy - 40)], skin, skin_s)
    # шея
    L.part([(cx - 2, fy - 66), (cx + 3, fy - 66), (cx + 3, fy - 62), (cx - 2, fy - 62)], skin, skin_s)
    # серебристо-белые волосы: объём + высокий хвост с бирюзовой резинкой, текущий по ветру
    hh, hs, hl = dusk(hexc(0xe6e8f4), 0.9), dusk(hexc(0xa4abc8), 0.85), dusk(hexc(0xffffff), 0.95)
    L.part([(cx - 8, fy - 82), (cx + 8, fy - 82), (cx + 9, fy - 68), (cx + 7, fy - 62), (cx - 7, fy - 62), (cx - 9, fy - 68)], hh, hs, hl)
    L.part([(cx - 7, fy - 86), (cx + 7, fy - 86), (cx + 9, fy - 80), (cx - 9, fy - 80)], hh, hs, hl)
    pts = [(cx + 1, fy - 82)]
    for i in range(1, 10):
        pts.append((cx + 1 + i * 1.0 + w1 * i * 0.6, fy - 82 + i * 3.2 + (i % 2)))
    L.part(pts, hh, width=6)
    L.part([(cx + 1 + w1 * 6, fy - 55), (cx + 4 + w1 * 7, fy - 55), (cx + 5 + w1 * 8, fy - 48)], hs, width=2)
    L.part([(cx - 2, fy - 83), (cx + 4, fy - 83), (cx + 4, fy - 80), (cx - 2, fy - 80)], dusk(hexc(0x2ac8c8)), dusk(hexc(0x1a8a9a)), dusk(hexc(0x8af4f0)))
    return L.finish()


def make_chars():
    hero = Image.new("RGBA", (FW * FRAMES, FH), (0, 0, 0, 0))
    atl = Image.new("RGBA", (FW * FRAMES, FH), (0, 0, 0, 0))
    for f in range(FRAMES):
        hero.alpha_composite(hero_frame(f), (f * FW, 0))
        atl.alpha_composite(atl_frame(f), (f * FW, 0))
    hero.save(os.path.join(OUT, "title_hero.png"), optimize=True)
    atl.save(os.path.join(OUT, "title_atl.png"), optimize=True)
    # проверочная сцена: оба кадра рядом
    prev = Image.new("RGBA", (FW * 2 + 20, FH), (110, 70, 110, 255))
    prev.alpha_composite(hero_frame(0), (0, 0))
    prev.alpha_composite(atl_frame(0), (FW - 10, 0))
    prev.resize((prev.width * 5, prev.height * 5), Image.NEAREST).save("/tmp/chars_preview.png")


# ---------------------------------------------------------------- облако, свечение, логотип
def make_cloud():
    im = Image.new("RGBA", (150, 18), (0, 0, 0, 0))
    d = ImageDraw.Draw(im)
    for i in range(4):
        w = 150 * (1 - i * 0.16)
        y = 6 + i * 3
        c = lerpc(hexc(0xa0507a), hexc(0xffb878), 0.2 + i * 0.25)
        d.rectangle([(150 - w) / 2, y, (150 + w) / 2, y + 2], fill=(*c, 255))
    d.rectangle([40, 3, 105, 5], fill=(*hexc(0xb4587c), 255))
    im.save(os.path.join(OUT, "title_cloud.png"), optimize=True)


def make_glow():
    frames = []
    for k, pulse in enumerate((0.97, 1.0, 1.03)):
        im = Image.new("RGBA", (200, 200), (0, 0, 0, 0))
        d = ImageDraw.Draw(im)
        for r, a in [(95, 22), (74, 30), (56, 40), (42, 55)]:
            rr = r * pulse
            d.ellipse([100 - rr, 100 - rr, 100 + rr, 100 + rr], fill=(255, 190, 110, a))
        # слои накладываются поверх друг друга без смешения: приводим к честному свечению
        frames.append(im)
    strip = Image.new("RGBA", (600, 200), (0, 0, 0, 0))
    for i, f in enumerate(frames):
        strip.paste(f, (i * 200, 0))
    strip.save(os.path.join(OUT, "title_glow.png"), optimize=True)


def make_logo():
    S = 3
    im = Image.new("RGBA", (240 * S, 76 * S), (0, 0, 0, 0))
    d = ImageDraw.Draw(im)
    f1 = ImageFont.truetype("/usr/share/fonts/truetype/dejavu/DejaVuSans-Bold.ttf", 40 * S)
    f2 = ImageFont.truetype("/usr/share/fonts/truetype/dejavu/DejaVuSerif-Bold.ttf", 20 * S)
    for (txt, f, y, col) in (("virusfon", f1, 24 * S, (255, 252, 240)), ("навсегда", f2, 60 * S, (255, 226, 150))):
        tw = d.textlength(txt, font=f)
        x = (240 * S - tw) / 2
        for ox, oy in ((-3, 0), (3, 0), (0, -3), (0, 3), (-3, -3), (3, 3), (-3, 3), (3, -3)):
            d.text((x + ox, y + oy), txt, font=f, fill=(60, 24, 50, 255), anchor="lm")
        d.text((x, y), txt, font=f, fill=(*col, 255), anchor="lm")
    im = im.resize((240 * 2, 76 * 2), Image.LANCZOS)
    im.save(os.path.join(OUT, "title_logo.png"), optimize=True)


if __name__ == "__main__":
    make_bg()
    ok = make_tree()
    make_chars()
    make_cloud()
    make_glow()
    make_logo()
    print("done", ok)
