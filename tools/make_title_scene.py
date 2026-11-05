#!/usr/bin/env python3
"""Ресурсы нового главного меню: закат, пара героев на горе, деревня Фонзо Тим вдали.

Запуск:  python3 tools/make_title_scene.py <assets_dir> [tools/title_pano.png]
  title_pano.png — панорама карты деревни (K=0), снятая harness-ом: JAVA_OPTS="-Djump=0 -Dpano=1" tools/desktop-harness/run.sh
  (настоящие дома и розовое дерево вырезаются из неё).
Создаёт: title_bg.png, title_tree.png, title_couple.png (+ печатает параметры для engine/TitleScene.java).
Облако, свечение и логотип делает прежний tools/make_title_assets.py.
"""
import math, random, sys, os
sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
import numpy as np
from PIL import Image, ImageDraw

OUT = sys.argv[1]
PANO = sys.argv[2] if len(sys.argv) > 2 else os.path.join(os.path.dirname(os.path.abspath(__file__)), "title_pano.png")
BW, BH = 720, 320
SUN = (190, 176)


def hexc(h):
    return ((h >> 16) & 255, (h >> 8) & 255, h & 255)


def lerpc(a, b, t):
    t = max(0.0, min(1.0, t))
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


def smooth(x):
    x = max(0.0, min(1.0, x))
    return x * x * (3 - 2 * x)


# ---------------------------------------------------------------- рельеф переднего плана (возвышенность)
def hill_y(x):
    """Верхняя кромка горы, на которой стоят герои: слева склон уходит вниз, справа вершина."""
    base = 304 - 52 * smooth((x - 30) / 420)
    return base + 2.5 * math.sin(x * 0.045) + 1.5 * math.sin(x * 0.13 + 1)


COUPLE_X = 536           # центр пары (координата фона)
TREE_X = 588


# ---------------------------------------------------------------- настоящие дома и дерево из панорамы
def warm_mask(im, box, keep_dark=True):
    """Вырезать постройку: тёплые/тёмные пиксели остаются, синее небо, горы и озеро фона отбрасываются."""
    X0, Y0, X1, Y1 = box
    px = im.load()
    out = Image.new("RGBA", (X1 - X0, Y1 - Y0), (0, 0, 0, 0))
    op = out.load()
    for y in range(Y0, Y1):
        for x in range(X0, X1):
            r, g, b = px[x, y]
            warm = r >= b + 6 or (g >= b + 14)
            dark = (r + g + b) < 150
            if warm or (keep_dark and dark):
                op[x - X0, y - Y0] = (r, g, b, 255)
    return out


def clean(img, passes=1):
    """Убрать одиночные пиксели (остатки фона) и закрыть дырки на 1 пиксель."""
    a = np.array(img)
    for _ in range(passes):
        al = a[:, :, 3] > 0
        n = np.zeros(al.shape, dtype=int)
        for dy in (-1, 0, 1):
            for dx in (-1, 0, 1):
                if dx or dy:
                    n += np.roll(np.roll(al, dy, 0), dx, 1)
        a[al & (n <= 2), 3] = 0
    return Image.fromarray(a)


def dusk_grade(img, k):
    """Дальние постройки: фиолетовая дымка, чем дальше (k больше) — тем сильнее; кромка закатного света слева."""
    a = np.array(img).astype(np.float32)
    m = a[:, :, 3] > 0
    haze = np.array([120, 70, 120], dtype=np.float32)
    a[:, :, :3][m] = a[:, :, :3][m] * (1 - k) + haze * k
    a[:, :, :3][m] *= 0.82
    left = np.zeros_like(m)
    left[:, 1:] = m[:, 1:] & ~m[:, :-1]
    a[:, :, :3][left] = a[:, :, :3][left] * 0.35 + np.array([255, 190, 120], dtype=np.float32) * 0.65
    return Image.fromarray(np.clip(a, 0, 255).astype(np.uint8))


def make_scene():
    pano = Image.open(PANO).convert("RGB")
    # дом на земле (рядом с деревом) и два дома на помостах — чистые, без персонажей и подписей
    hut_a = clean(warm_mask(pano, (350, 146, 484, 254)))
    hut_b = clean(warm_mask(pano, (988, 66, 1126, 176)))
    hut_c = clean(warm_mask(pano, (1266, 66, 1408, 176)))
    huts = [(hut_a, hut_a.getbbox()), (hut_b, hut_b.getbbox()), (hut_c, hut_c.getbbox())]
    huts = [(i.crop(b), b) for i, b in huts]

    # ---------- небо, солнце, горы, долина
    img = np.zeros((BH, BW, 3), dtype=np.uint8)
    horizon = 205.0
    for y in range(int(horizon) + 1):
        c = grad(SKY, y / horizon)
        row = np.zeros((BW, 3), dtype=np.float32)
        row[:] = c
        row += ((BAYER[y % 4][np.arange(BW) % 4] - 0.5) * 7.0)[:, None]
        img[y] = np.clip(row, 0, 255).astype(np.uint8)
    im = Image.fromarray(img, "RGB").convert("RGBA")
    d = ImageDraw.Draw(im)
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

    for pts, col, rim in [(ridge(1, 176, 22, 48), hexc(0x8c4a78), hexc(0xd0707a)),
                          (ridge(2, 189, 16, 34), hexc(0x6b3a6c), hexc(0xb95f72)),
                          (ridge(3, 200, 9, 26), hexc(0x4a2c5e), hexc(0x8a4a6c))]:
        d.polygon(pts + [(BW + 40, 232), (-20, 232)], fill=(*col, 255))
        for i in range(len(pts) - 1):
            d.line([pts[i], pts[i + 1]], fill=(*rim, 255), width=1)

    # озеро в долине (узкая полоса): небо отражается, внизу темнеет
    LAKE0, LAKE1 = 207, 238
    for y in range(LAKE0, LAKE1):
        v = (y - LAKE0) / (LAKE1 - LAKE0)
        d.line([(0, y), (BW, y)], fill=(*lerpc(hexc(0x4a2c5e), hexc(0x3b2a52), v), 255))

    # дальний берег с деревней Фонзо Тим: пологий холм, на нём настоящие дома игры вдали
    far = [(0, 222), (60, 216), (130, 213), (210, 217), (290, 221), (360, 225), (430, 229), (520, 233), (620, 236), (720, 238)]
    d.polygon(far + [(720, BH), (0, BH)], fill=(*hexc(0x3b2a52), 255))
    for y in range(240, BH):
        d.line([(0, y), (BW, y)], fill=(*lerpc(hexc(0x3b2a52), hexc(0x1c1630), (y - 240) / 70.0), 255))
    for i in range(len(far) - 1):
        d.line([far[i], far[i + 1]], fill=(*hexc(0x8a4a6c), 255))
    # деревья дальнего берега (тёмные шапки)
    rnd = random.Random(8)
    for i in range(46):
        x = rnd.uniform(0, 700)
        yy = np.interp(x, [p[0] for p in far], [p[1] for p in far])
        r = rnd.uniform(3, 6)
        d.ellipse([x - r, yy - r * 1.3, x + r, yy + r * 0.4], fill=(*hexc(0x2c2044), 255))

    windows = []      # прямоугольники светящихся окон (координаты фона) для мерцания
    plan = [(0, 0.46, 18), (1, 0.38, 74), (0, 0.34, 120), (2, 0.42, 168), (0, 0.30, 214), (1, 0.30, 262), (2, 0.28, 318), (0, 0.26, 376)]
    for (hi, sc, cx) in plan:
        h, bb = huts[hi]
        w2, h2 = max(1, int(h.width * sc)), max(1, int(h.height * sc))
        small = h.resize((w2, h2), Image.LANCZOS)
        small = dusk_grade(small, 0.28 + (0.46 - sc) * 0.9)
        gy = np.interp(cx, [p[0] for p in far], [p[1] for p in far]) + 3
        im.alpha_composite(small, (int(cx - w2 / 2), int(gy - h2)))
        # окно: тёмный проём в нижней трети — подсветим тёплым светом
        wx0, wy0 = int(cx - w2 / 2 + w2 * 0.30), int(gy - h2 + h2 * 0.58)
        ww, wh = max(2, int(w2 * 0.2)), max(2, int(h2 * 0.2))
        windows.append((wx0, wy0, ww, wh))
        d2 = ImageDraw.Draw(im)
        d2.rectangle([wx0, wy0, wx0 + ww - 1, wy0 + wh - 1], fill=(255, 188, 90, 255))

    # дымка над долиной
    haze = Image.new("RGBA", (BW, BH), (0, 0, 0, 0))
    hd = ImageDraw.Draw(haze)
    for y in range(206, 246):
        a = int(70 * (1 - abs(y - 226) / 20.0))
        if a > 0:
            hd.line([(0, y), (BW, y)], fill=(255, 190, 170, a))
    im.alpha_composite(haze)

    # ---------- возвышенность на переднем плане
    fg = Image.new("RGBA", (BW, BH), (0, 0, 0, 0))
    fd = ImageDraw.Draw(fg)
    pts = [(x, hill_y(x)) for x in range(0, BW + 1, 2)]
    fd.polygon(pts + [(BW, BH), (0, BH)], fill=(40, 40, 60, 255))
    a = np.array(fg)
    for x in range(BW):
        top = int(round(hill_y(x)))
        for y in range(top, BH):
            v = (y - top) / 60.0
            c = lerpc(hexc(0x4c5a48), hexc(0x1f1a30), v)
            # лёгкое зерно (дизеринг) — «пиксельная» текстура склона
            c = tuple(int(np.clip(c[i] + (BAYER[y % 4][x % 4] - 0.5) * 9, 0, 255)) for i in range(3))
            a[y, x] = (*c, 255)
    fg = Image.fromarray(a)
    fd = ImageDraw.Draw(fg)
    # кромка заката по гребню, трава, камни, цветы
    for x in range(1, BW):
        y0 = int(round(hill_y(x)))
        slope = hill_y(x) - hill_y(x - 1)
        warm = (255, 196, 120) if slope >= -0.2 else (190, 120, 96)
        fd.point((x, y0), fill=(*warm, 255))
        fd.point((x, y0 + 1), fill=(*lerpc(warm, hexc(0x4c5a48), 0.6), 255))
    rnd = random.Random(5)
    for i in range(900):
        x = rnd.uniform(0, BW)
        y = hill_y(x) + rnd.uniform(1, 55)
        hh = rnd.uniform(3, 8) * (0.7 + (y - hill_y(x)) / 40)
        c = lerpc(hexc(0x35402f), hexc(0x9aae62), rnd.random() * 0.8)
        sw = rnd.uniform(-1.5, 1.5)
        fd.line([(x, y), (x + sw, y - hh)], fill=(*c, 255))
    for i in range(34):
        x = rnd.uniform(0, BW)
        y = hill_y(x) + rnd.uniform(6, 50)
        c = rnd.choice([hexc(0xffd860), hexc(0xff9cc0), hexc(0xffffff)])
        fd.rectangle([x, y, x + 1, y + 1], fill=(*c, 255))
    for i in range(12):
        x = rnd.uniform(20, BW - 20)
        y = hill_y(x) + rnd.uniform(14, 48)
        rw, rh = rnd.uniform(5, 11), rnd.uniform(3, 6)
        fd.ellipse([x - rw, y - rh, x + rw, y + rh * 0.6], fill=(*hexc(0x5a4a62), 255))
        fd.ellipse([x - rw, y - rh, x + rw * 0.4, y - rh * 0.1], fill=(*hexc(0x8a7a8e), 255))
    im.alpha_composite(fg)
    im.convert("RGB").save(os.path.join(OUT, "title_bg.png"), optimize=True)

    # ---------- розовое дерево с листьями (из панорамы)
    X0, Y0, X1, Y1 = 452, 90, 612, 258
    t = warm_mask(pano, (X0, Y0, X1, Y1), keep_dark=False)
    ta = np.array(t)
    # справа от x=484 только дерево; слева от него остатки дома: отрезаем крышу хижины
    for y in range(Y1 - Y0):
        for x in range(X1 - X0):
            px = ta[y, x]
            if px[3] == 0:
                continue
            r, g, b = int(px[0]), int(px[1]), int(px[2])
            flower = r >= 170 and r - g >= 95 and b >= 40
            bark = g - b >= 12 and r > g and r < 215 and 25 < b < 125
            if not (flower or bark):
                ta[y, x, 3] = 0
            elif x + X0 < 486 and y + Y0 > 135 and not flower:
                ta[y, x, 3] = 0
    tree = clean(Image.fromarray(ta), 1)
    from scipy import ndimage
    aa = np.array(tree)
    lab, n = ndimage.label(aa[:, :, 3] > 0, structure=np.ones((3, 3)))
    if n > 1:
        sizes = ndimage.sum(np.ones(lab.shape), lab, range(1, n + 1))
        aa[lab != (1 + int(np.argmax(sizes))), 3] = 0
        tree = Image.fromarray(aa)
    bb = tree.getbbox()
    tree = tree.crop(bb)
    tree = dusk_grade(tree, 0.0)
    TS = 1.8   # дерево в масштабе героев (они x2)
    tree = tree.resize((int(tree.width * TS), int(tree.height * TS)), Image.NEAREST)
    tree.save(os.path.join(OUT, "title_tree.png"), optimize=True)
    # центр ствола: самый широкий ряд пикселей коры в нижней трети
    ta2 = np.array(tree)
    rows = []
    for y in range(int(tree.height * 0.82), tree.height):
        xs = np.where(ta2[y, :, 3] > 0)[0]
        if len(xs):
            rows.append((xs.min() + xs.max()) / 2)
    trunk_cx = float(np.mean(rows)) if rows else tree.width / 2
    tree_x = int(TREE_X - trunk_cx)
    tree_y = int(hill_y(TREE_X) + 7 - tree.height)
    return windows, (tree_x, tree_y, tree.size)


# ---------------------------------------------------------------- герои со спины (стиль игры)
Z = 1.5
FW, FH = 112, 104
NF = 12


def C(h, a=255):
    return ((h >> 16) & 255, (h >> 8) & 255, h & 255, a)


OUTL = C(0x2a1a30)
HAIR, HAIR_L, HAIR_D = C(0x6e432c), C(0xa8744c), C(0x3e2518)
SKIN, SKIN_D = C(0xeab58c), C(0xc88a66)
BAND, BAND_L = C(0x3b8ae6), C(0x86c0f8)
RED, RED_D, RED_L = C(0xc6403f), C(0x8c2a36), C(0xe0605a)
WHT, WHT_D = C(0xefe4dc), C(0xb8a8b8)
UND, UND_D = C(0xa4c8ee), C(0x6f98cc)
PANT, PANT_D, PANT_L = C(0x4a60ac), C(0x34478c), C(0x7a98dc)
WRAP, WRAP_D, SOLE = C(0xe0dcee), C(0x9c96bc), C(0xe48a3e)
BL_L, BL_M, BL_D = C(0xc4e4f8), C(0x84aaea), C(0x5c48b8)
GOLD, GOLD_D = C(0xeac84e), C(0xa87c2c)
YEL, YEL_D, YEL_L = C(0xf6cc2e), C(0xc8961c), C(0xffe36a)
SASH, SASH_D = C(0x3f8be0), C(0x2a5aa8)
SIL, SIL_D, SIL_L = C(0xa9a9bd), C(0x6a6a84), C(0xd8d8e6)
TEAL = C(0x4fd6dc)
STRAP, STRAP_D = C(0x5a3d6a), C(0x3a2448)
TIE = C(0x7ab0e8)


class P:
    def __init__(self, img, ox, oy):
        self.d = ImageDraw.Draw(img)
        self.ox, self.oy = ox, oy

    def t(self, x, y):
        return (round(self.ox + x * Z), round(self.oy + y * Z))

    def rect(self, x0, y0, x1, y1, c):
        a, b = self.t(x0, y0), self.t(x1, y1)
        self.d.rectangle([a[0], a[1], b[0] - 1, b[1] - 1], fill=c)

    def poly(self, pts, c):
        self.d.polygon([self.t(x, y) for x, y in pts], fill=c)

    def ell(self, x0, y0, x1, y1, c):
        a, b = self.t(x0, y0), self.t(x1, y1)
        self.d.ellipse([a[0], a[1], b[0] - 1, b[1] - 1], fill=c)

    def line(self, x0, y0, x1, y1, c, w=1):
        self.d.line([self.t(x0, y0), self.t(x1, y1)], fill=c, width=w)


def blade(p, x0, y0, x1, y1, w):
    dx, dy = x1 - x0, y1 - y0
    L = math.hypot(dx, dy)
    nx, ny = -dy / L * w / 2, dx / L * w / 2
    p.poly([(x0 - nx, y0 - ny), (x0 + nx, y0 + ny), (x1 + nx, y1 + ny), (x1 - nx, y1 - ny)], BL_M)
    p.poly([(x0 - nx, y0 - ny), (x0 - nx * 0.15, y0 - ny * 0.15), (x1 - nx * 0.15, y1 - ny * 0.15), (x1 - nx, y1 - ny)], BL_L)
    p.poly([(x0 + nx * 0.2, y0 + ny * 0.2), (x0 + nx * 0.62, y0 + ny * 0.62), (x1 + nx * 0.62, y1 + ny * 0.62), (x1 + nx * 0.2, y1 + ny * 0.2)], BL_D)
    p.poly([(x0 - nx, y0 - ny), (x0 + nx, y0 + ny), (x0 - dx / L * 5, y0 - dy / L * 5)], BL_L)


def hero(p, ph):
    w = math.sin(ph * math.tau)
    w2 = math.sin(ph * math.tau + 1.3)
    # ноги, обувь
    p.rect(14, 40, 19.6, 49, PANT); p.rect(20.4, 40, 26, 49, PANT)
    p.rect(17.5, 40, 19.6, 49, PANT_D); p.rect(23.8, 40, 26, 49, PANT_D)
    p.rect(14, 44, 19.6, 46, PANT_L); p.rect(20.4, 44, 26, 46, PANT_L)
    p.rect(13.5, 47, 19.8, 51.5, WRAP); p.rect(20.2, 47, 26.5, 51.5, WRAP)
    p.rect(17.5, 47, 19.8, 51.5, WRAP_D); p.rect(24.2, 47, 26.5, 51.5, WRAP_D)
    p.rect(13.5, 51, 19.8, 52.4, SOLE); p.rect(20.2, 51, 26.5, 52.4, SOLE)
    # подол куртки
    p.poly([(12.5, 36), (20, 36), (20 + w * 0.4, 44.5), (14 + w * 0.6, 43)], RED)
    p.poly([(20, 36), (27.5, 36), (26 + w * 0.6, 43), (20 + w * 0.4, 44.5)], RED_D)
    # торс (красная жилетка), голубой пояс с узлом
    p.poly([(11, 24), (29, 24), (28, 36.5), (12, 36.5)], RED)
    p.poly([(21, 24), (29, 24), (28, 36.5), (21, 36.5)], RED_D)
    p.rect(12, 25, 13.5, 35, RED_L)
    p.rect(11.5, 33, 28.5, 36, UND); p.rect(11.5, 35, 28.5, 36, UND_D)
    p.poly([(26.5, 33.5), (31 + w2 * 1.2, 35), (32 + w2 * 1.6, 39), (28.5, 37)], UND)
    p.poly([(27, 35), (29.5 + w2, 38.5), (29 + w2 * 1.4, 42 + w2), (27, 38)], UND_D)
    p.rect(15.5, 22.8, 24.5, 25.3, UND); p.rect(15.5, 24.4, 24.5, 25.3, UND_D)
    # ремни и меч на спине
    p.poly([(12, 24), (14.2, 24), (28, 36), (26, 37)], STRAP)
    p.poly([(26, 24), (28, 24), (14.5, 35), (13, 34)], STRAP_D)
    blade(p, 8.5, 46.5, 31.5, 17.5, 4.6)
    p.poly([(29.2, 16.8), (33.8, 13.4), (36.4, 16.4), (31.6, 19.8)], GOLD)
    p.poly([(31.2, 16.8), (33.8, 13.4), (35, 14.8), (32.4, 18.2)], GOLD_D)
    p.poly([(33.5, 12.6), (35, 11.4), (37.6, 8.6), (36.2, 7.6), (32.4, 10.8)], GOLD_D)
    p.ell(35.3, 6.2, 38.6, 9.4, GOLD)
    # руки: белые рукава, наручи, кисти (правая тянется к Atlantida)
    p.poly([(7.5, 25.5), (12, 24.5), (12.2, 33), (8.2, 34)], WHT)
    p.poly([(8.2, 31), (12.2, 31), (12.2, 33), (8.2, 34)], WHT_D)
    p.rect(8.4, 33.5, 12, 37.5, STRAP_D); p.ell(8.4, 36.5, 12, 40, SKIN)
    p.poly([(28, 24.5), (32.6, 25.5), (33.6, 34), (28.4, 33)], WHT)
    p.poly([(29, 30.5), (33.4, 31.5), (33.6, 34), (28.4, 33)], WHT_D)
    p.rect(28.6, 33, 33, 36.5, STRAP_D); p.ell(29, 36, 33.6, 39.8, SKIN)
    # шея и каштановые волосы с высоким хвостом и синим кольцом (как на портрете)
    p.rect(17, 19.5, 23.2, 23.6, SKIN_D)
    p.ell(11.5, 6.5, 28.8, 22.2, HAIR)
    p.ell(10.8, 14.5, 13.8, 18.8, SKIN); p.ell(26.6, 14.5, 29.6, 18.8, SKIN)
    p.ell(14, 7.5, 24, 14, HAIR_L)
    for (bx, by, tx, ty) in ((11.6, 15, 8.0 + w * 0.5, 21), (13, 18, 11.2 + w * 0.6, 25), (28.4, 15, 32 + w * 0.6, 20.5), (27.2, 18, 29.6 + w * 0.7, 25)):
        p.poly([(bx - 1.6, by), (bx + 1.6, by), (tx, ty)], HAIR)
    p.poly([(18.2, 8.6), (21.8, 8.6), (22.6 + w * 0.6, 2.6), (20 + w * 0.9, 0.4), (18 + w * 0.4, 3.0)], HAIR)
    p.poly([(17.4, 9), (22.6, 9), (24.4 + w, 18), (23.4 + w * 1.5, 29), (21 + w * 1.2, 32.4), (18.6 + w * 1.2, 29.4), (16.4 + w * 0.8, 18)], HAIR)
    p.poly([(20.2, 10), (22.6, 10), (23.8 + w, 18), (22.8 + w * 1.4, 28.6), (21.4 + w * 1.2, 30)], HAIR_L)
    p.poly([(17.6, 12), (19.4, 12), (18.6 + w * 0.9, 24), (17 + w * 0.7, 18)], HAIR_D)
    p.rect(17.2, 8.2, 22.8, 11, BAND); p.rect(17.2, 8.2, 22.8, 9.1, BAND_L); p.rect(17.2, 10.1, 22.8, 11, SASH_D)


def atlantida(p, ph):
    w = math.sin(ph * math.tau + 0.7)
    w2 = math.sin(ph * math.tau + 2.0)
    p.rect(42, 42, 45, 50, SKIN); p.rect(48.2, 42, 51.2, 50, SKIN)
    p.rect(44, 42, 45, 50, SKIN_D); p.rect(50.2, 42, 51.2, 50, SKIN_D)
    p.rect(41.4, 49.6, 45.6, 51.4, STRAP_D); p.rect(47.6, 49.6, 51.8, 51.4, STRAP_D)
    p.rect(41.4, 51, 45.6, 52.3, SOLE); p.rect(47.6, 51, 51.8, 52.3, SOLE)
    p.line(42, 48, 45, 49.6, STRAP, 1); p.line(48.4, 48, 51.4, 49.6, STRAP, 1)
    hem = [(38.5 + w * 0.8, 42.6), (40.6 + w * 0.6, 44.2), (42.6, 42.4), (44.6, 44.4), (46.6, 42.4), (48.6, 44.6), (50.6, 42.5), (52.6 + w * 0.6, 44.3), (54.4 + w * 0.8, 42.6)]
    p.poly([(41, 26), (51.8, 26), (54.4 + w * 0.8, 42.6)] + hem[::-1][:-1] + [(38.5 + w * 0.8, 42.6)], YEL)
    p.poly([(46.6, 26), (51.8, 26), (54.4 + w * 0.8, 42.6), (50.6, 42.5), (46.6, 42.4)], YEL_D)
    p.rect(41.5, 27, 43, 38, YEL_L)
    p.line(46.4, 32, 46.2 + w * 0.3, 42, YEL_D)
    p.rect(41.2, 32.2, 51.6, 35, SASH); p.rect(41.2, 34, 51.6, 35, SASH_D)
    p.poly([(46, 33), (41.6 + w2 * 0.8, 30.4), (40.4 + w2 * 0.8, 36.4), (45.6, 34.4)], SASH)
    p.poly([(46.8, 33), (52.4 + w2 * 0.8, 30.2), (53.4 + w2 * 0.8, 36.6), (47.2, 34.4)], SASH_D)
    p.poly([(45.6, 34.2), (43 + w2, 40.6), (44.6 + w2, 41.6), (46.8, 35)], SASH)
    p.ell(45, 32.4, 48.4, 35.6, SASH_D)
    p.rect(40.2, 21.8, 52.8, 27.4, SKIN); p.rect(40.8, 26.4, 52.2, 27.4, SKIN_D)
    p.rect(37.4, 25, 40.8, 29, SKIN); p.rect(37.6, 28.4, 40.6, 36.6, SKIN); p.rect(39.6, 28.4, 40.6, 36.6, SKIN_D)
    p.ell(37.2, 35.8, 40.8, 39.2, SKIN)
    p.rect(52.2, 25, 55.6, 29, SKIN)
    p.poly([(52.6, 28), (56.4, 29.4), (55.2, 35.6), (52, 33)], SKIN)
    p.poly([(54.6, 28.8), (56.4, 29.4), (55.2, 35.6), (54, 34.2)], SKIN_D)
    p.ell(50.2, 33.2, 53.6, 36.4, SKIN)
    p.rect(44.4, 20.4, 48.8, 23.6, SKIN_D)
    # серебристо-серое каре и маленький хвостик с голубой резинкой (как на портрете)
    p.ell(40.4, 7.6, 52.8, 21.6, SIL)
    p.poly([(40.8, 15), (52.4, 15), (53 + w * 0.6, 23.8), (51 + w * 0.4, 24.8), (49.6, 21.6), (43.6, 21.6), (42.2 + w * 0.4, 24.8), (40.2 + w * 0.6, 23.8)], SIL)
    p.poly([(47.2, 14), (52.4, 15), (53 + w * 0.6, 23.8), (51 + w * 0.4, 24.8), (49.6, 21.6), (47.2, 21.6)], SIL_D)
    p.ell(41.2, 8.4, 48.4, 13.8, SIL_L)
    p.poly([(41.2, 9.0), (46.8, 8.2), (44.2, 12.4)], SIL_L)
    p.poly([(43.8, 17), (46.4, 17), (45 + w * 0.4, 22.6)], SIL_D)
    p.poly([(41.6, 8.6), (44.4, 8.6), (42.4 + w * 0.6, 17.4), (40.2 + w * 0.9, 16)], SIL)
    p.poly([(43, 9.6), (44.4, 9.6), (43 + w * 0.6, 16.2)], SIL_L)
    p.rect(41.4, 8.6, 44.6, 10.4, TIE)
    p.ell(44.8, 10.4, 47.4, 12.6, TEAL)


def outline(img):
    px = img.load()
    src = img.copy().load()
    w, h = img.size
    for y in range(h):
        for x in range(w):
            if src[x, y][3] == 0:
                for dx, dy in ((1, 0), (-1, 0), (0, 1), (0, -1)):
                    nx, ny = x + dx, y + dy
                    if 0 <= nx < w and 0 <= ny < h and src[nx, ny][3] > 0:
                        px[x, y] = OUTL
                        break


def rim(img):
    """Закатный свет слева: кромка силуэта теплеет."""
    px = img.load()
    src = img.copy().load()
    w, h = img.size
    for y in range(h):
        for x in range(w):
            c = src[x, y]
            if c[3] == 0 or c == OUTL:
                continue
            lx = src[x - 1, y] if x > 0 else (0, 0, 0, 0)
            if lx[3] == 0 or lx == OUTL:
                px[x, y] = tuple(min(255, int(c[i] * 0.3 + [255, 190, 120][i] * 0.7)) for i in range(3)) + (255,)


def couple_frame(i):
    img = Image.new("RGBA", (FW, FH), (0, 0, 0, 0))
    p = P(img, 10, 14)
    hero(p, i / NF)
    atlantida(p, i / NF)
    outline(img)
    rim(img)
    return img


FEET_Y = 14 + 52.4 * Z   # низ подошвы в кадре
CENTER_X = 10 + 36 * Z   # середина пары в кадре


def make_couple():
    import make_campfire
    return make_campfire.make_couple(OUT, hill_y, 560)[:2]


def make_couple_old():
    strip = Image.new("RGBA", (FW * NF, FH), (0, 0, 0, 0))
    for i in range(NF):
        strip.alpha_composite(couple_frame(i), (i * FW, 0))
    strip.save(os.path.join(OUT, "title_couple.png"), optimize=True)
    return int(COUPLE_X - CENTER_X), int(hill_y(COUPLE_X) + 6 - FEET_Y)


if __name__ == "__main__":
    windows, (tx, ty, tsize) = make_scene()
    cx, cy = make_couple()
    print("WINDOWS", windows)
    print("TREE", tx, ty, tsize)
    print("COUPLE", cx, cy, FW, FH, NF)
    # просмотр
    if len(sys.argv) > 3:
        bg = Image.open(os.path.join(OUT, "title_bg.png")).convert("RGBA")
        tr = Image.open(os.path.join(OUT, "title_tree.png"))
        bg.alpha_composite(tr, (tx, ty))
        bg.alpha_composite(Image.open(os.path.join(OUT, "title_couple.png")).crop((3 * 168, 0, 4 * 168, 132)), (cx, cy))
        bg.save(sys.argv[3])
