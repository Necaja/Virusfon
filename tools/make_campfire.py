"""Пара героев у костра (сидят, болтают) — спрайт-лента title_couple.png, 12 кадров. Вызывается из make_title_scene.py."""
import math, os
from PIL import Image, ImageDraw

Z = 1.4
FW, FH, NF = 150, 84, 12
FIRE_X, GROUND = 52, 54


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
BOOT, BOOT_L = C(0x241a2c), C(0x4a3c58)
BL_L, BL_M, BL_D = C(0xc4e4f8), C(0x84aaea), C(0x5c48b8)
GOLD, GOLD_D = C(0xeac84e), C(0xa87c2c)
YEL, YEL_D, YEL_L = C(0xf6cc2e), C(0xc8961c), C(0xffe36a)
SASH, SASH_D = C(0x3f8be0), C(0x2a5aa8)
SIL, SIL_D, SIL_L = C(0xa9a9bd), C(0x6a6a84), C(0xd8d8e6)
TEAL = C(0x4fd6dc)
STRAP = C(0x5a3d6a)
LOG, LOG_D = C(0x6a4430), C(0x3a2418)
EYE, MOUTH = C(0x2a1a30), C(0x7a2a30)


class P:
    def __init__(self, img):
        self.d = ImageDraw.Draw(img)

    def t(self, x, y):
        return (round(x * Z), round(y * Z))

    def rect(self, x0, y0, x1, y1, c):
        a, b = self.t(x0, y0), self.t(x1, y1)
        self.d.rectangle([a[0], a[1], max(a[0], b[0] - 1), max(a[1], b[1] - 1)], fill=c)

    def poly(self, pts, c):
        self.d.polygon([self.t(x, y) for x, y in pts], fill=c)

    def ell(self, x0, y0, x1, y1, c):
        a, b = self.t(x0, y0), self.t(x1, y1)
        self.d.ellipse([a[0], a[1], max(a[0] + 1, b[0] - 1), max(a[1] + 1, b[1] - 1)], fill=c)

    def line(self, x0, y0, x1, y1, c, w=1):
        self.d.line([self.t(x0, y0), self.t(x1, y1)], fill=c, width=w)


def sword(p):
    # огромный меч воткнут клинком вверх позади героя
    p.poly([(4.5, 54), (3.3, 22), (7.5, 14), (11.5, 22), (10, 54)], BL_M)
    p.poly([(4.5, 54), (3.3, 22), (7.5, 14), (7.5, 54)], BL_L)
    p.poly([(7.5, 54), (7.5, 14), (11.5, 22), (10, 54)], BL_D)
    p.rect(1.5, 34, 13, 36.5, GOLD); p.rect(1.5, 35.5, 13, 36.5, GOLD_D)
    p.rect(5.2, 36.5, 9, 44, STRAP)


def hero(p, i, talking):
    ph = i / NF * math.tau
    bob = 0.5 * math.sin(ph * 2) + (0.5 if talking and i % 2 else 0)
    g = math.sin(ph * 2) if talking else 0.2 * math.sin(ph)
    # ноги: колено вверх, голень вперёд, чёрный сапог
    p.poly([(12, 44), (28, 40), (40, 40), (44, 46), (44, 52), (36, 53), (33, 48), (22, 50), (12, 50)], PANT)
    p.poly([(12, 48), (22, 49), (33, 47), (36, 52), (36, 53), (12, 52)], PANT_D)
    p.poly([(28, 41), (40, 40), (43, 44), (30, 44)], PANT_L)
    p.poly([(39, 47), (45, 47), (49, 52), (50, 54), (38, 54)], BOOT)
    p.rect(39, 47, 44, 48.5, BOOT_L)
    # торс: красный халат, наклон вперёд
    p.poly([(12, 28), (25, 26), (30, 34), (29, 44), (10, 47), (8, 36)], RED)
    p.poly([(8, 36), (14, 34), (14, 47), (10, 47)], RED_D)
    p.poly([(24, 26), (27, 28), (30, 34), (28, 36)], RED_L)
    p.rect(9, 39, 29.5, 41.5, UND); p.rect(9, 40.7, 29.5, 41.5, UND_D)
    p.poly([(26, 43), (34, 45), (33, 49), (24, 47)], RED_D)
    # шарф
    p.poly([(17, 23), (28, 23), (30, 28), (22, 31), (15, 28)], UND)
    p.poly([(19, 27), (28, 28), (22, 31), (15, 28)], UND_D)
    p.poly([(14, 28), (10, 33 + g), (13, 35 + g), (17, 30)], UND)
    # рука с жестом
    ex, ey = 31, 36
    hx, hy = 38 + 2 * g, 32 - 2.5 * g
    p.poly([(23, 28), (28, 27), (ex + 1.5, ey), (ex - 3, ey + 1)], WHT)
    p.line(ex, ey, hx, hy, WHT, 4)
    p.ell(hx - 2, hy - 2, hx + 2, hy + 2, SKIN)
    # голова
    cy = 15.5 + bob
    p.rect(22, cy + 5, 27, cy + 9, SKIN_D)
    p.ell(21, cy - 5, 33, cy + 7, SKIN)
    p.ell(18.5, cy - 8, 32.5, cy + 2.5, HAIR)
    p.poly([(21, cy - 2), (25, cy - 2), (24, cy + 6), (20, cy + 5)], HAIR)
    p.poly([(27, cy - 7), (35, cy - 4.5), (32.5, cy - 3), (34, cy - 1), (29, cy - 2.5)], HAIR)
    p.poly([(23, cy - 8), (28, cy - 8), (27, cy - 12), (24, cy - 11)], HAIR)
    p.ell(14.5, cy - 11, 22, cy - 4, HAIR)
    p.ell(16, cy - 10, 21, cy - 6, HAIR_L)
    p.rect(19, cy - 7, 23, cy - 5.6, BAND); p.rect(19, cy - 7, 23, cy - 6.3, BAND_L)
    p.rect(23, cy - 8, 32, cy - 6.5, BAND)
    p.ell(24, cy - 7, 30, cy - 5.4, BAND_L)
    p.rect(30, cy - 0.5, 31.6, cy + 1, EYE)
    p.rect(33, cy + 1, 34.4, cy + 2.4, SKIN_D)
    if talking and i % 2 == 0:
        p.rect(30.3, cy + 3.8, 32.6, cy + 5.4, MOUTH)
    else:
        p.rect(30.3, cy + 4.3, 32.6, cy + 5, SKIN_D)
    p.rect(24.4, cy + 0.4, 26, cy + 2.6, SKIN_D)


def atlantida(p, i, talking):
    ph = i / NF * math.tau
    bob = 0.5 * math.sin(ph * 2 + 1) + (0.5 if talking and i % 2 else 0)
    g = math.sin(ph * 2 + 0.5) if talking else 0.2 * math.sin(ph)
    # босая ступня
    p.poly([(63, 50), (68, 49), (69, 54), (62, 54)], SKIN)
    p.rect(63, 51.4, 68.5, 52.4, STRAP)
    # платье
    p.poly([(72, 38), (66, 47), (66, 52), (97, 54), (99, 44), (93, 30), (80, 30)], YEL)
    p.poly([(80, 46), (97, 47), (99, 44), (99, 54), (80, 54)], YEL_D)
    p.poly([(72, 38), (66, 47), (68, 50), (77, 43)], YEL_L)
    p.line(78, 44, 84, 53, YEL_D); p.line(88, 42, 90, 53, YEL_D)
    p.poly([(77, 24), (90, 25), (95, 34), (91, 43), (76, 43), (73, 32)], YEL)
    p.poly([(85, 25), (90, 25), (95, 34), (91, 43), (85, 43)], YEL_D)
    p.rect(74, 35, 93, 38, SASH); p.rect(74, 37, 93, 38, SASH_D)
    p.poly([(88, 36), (96, 40), (95, 45), (87, 39)], SASH)
    # рука с жестом (голая, с браслетом)
    ex, ey = 74, 37
    hx, hy = 67 - 2 * g, 32 - 2.5 * g
    p.line(79, 28, ex, ey, SKIN, 4)
    p.line(ex, ey, hx, hy, SKIN, 3)
    mx, my = (ex + hx) / 2, (ey + hy) / 2
    p.ell(mx - 2, my - 2, mx + 2, my + 2, GOLD)
    p.ell(hx - 2, hy - 2, hx + 2, hy + 2, SKIN)
    # голова: серебристое каре, лицом к огню (влево)
    cy = 16 + bob
    p.rect(79, cy + 5, 84, cy + 9, SKIN_D)
    p.ell(74, cy - 5, 86, cy + 7, SKIN)
    p.ell(75, cy - 9, 90, cy + 3, SIL)
    p.poly([(82, cy - 2), (91, cy - 2), (92, cy + 8), (84, cy + 8)], SIL)
    p.poly([(86, cy), (91, cy), (92, cy + 8), (87, cy + 8)], SIL_D)
    p.poly([(74, cy - 6), (82, cy - 9), (80, cy - 3), (76, cy - 1)], SIL_L)
    p.ell(88, cy - 8, 94, cy - 2, SIL)
    p.ell(89, cy - 6, 92, cy - 3.5, TEAL)
    p.poly([(91, cy - 3), (95, cy + 3), (93 + 0.6 * g, cy + 8), (90, cy + 2)], SIL_D)
    p.rect(76.2, cy - 0.5, 77.8, cy + 1, EYE)
    p.rect(73.6, cy + 1, 75, cy + 2.4, SKIN_D)
    if talking and i % 2 == 0:
        p.rect(75.2, cy + 3.8, 77.5, cy + 5.4, MOUTH)
    else:
        p.rect(75.2, cy + 4.3, 77.5, cy + 5, SKIN_D)


def fire(img, i):
    p = P(img)
    ph = i / NF * math.tau
    # поленья
    p.poly([(43, 53), (44, 51), (60, 54), (59, 55)], LOG)
    p.poly([(60, 53), (59, 51), (44, 54), (45, 55)], LOG_D)
    p.ell(42, 51.6, 45, 55, LOG)
    h = 11 + 2.2 * math.sin(ph * 3) + 1.3 * math.sin(ph * 5 + 1)
    sw = 1.6 * math.sin(ph * 2)
    for (k, col) in ((1.0, C(0xd8402a)), (0.78, C(0xf2862c)), (0.5, C(0xffd24a)), (0.26, C(0xfff4b0))):
        w = 7 * k
        p.poly([(FIRE_X - w, 53), (FIRE_X - w * 0.7, 53 - h * k * 0.55), (FIRE_X + sw * k - 1, 53 - h * k), (FIRE_X + w * 0.7, 53 - h * k * 0.5), (FIRE_X + w, 53)], col)
    p.poly([(FIRE_X - 8, 53 - h * 0.25), (FIRE_X - 10, 53 - h * 0.7 + sw), (FIRE_X - 6, 53 - h * 0.35)], C(0xf2862c))
    # искры
    for s in range(5):
        t = (i / NF * 1.0 + s * 0.21) % 1.0
        x = FIRE_X + 3 * math.sin(s * 2.3 + t * 5) + (s - 2) * 1.8
        y = 50 - t * 30
        p.rect(x, y, x + 0.9, y + 0.9, C(0xffd870, int(255 * (1 - t))))


def glow(i):
    ph = i / NF * math.tau
    a = 0.78 + 0.22 * math.sin(ph * 3) * math.cos(ph)
    lay = Image.new("RGBA", (FW, FH), (0, 0, 0, 0))
    px = lay.load()
    cx, cy = FIRE_X * Z, 50 * Z
    R = 30 * Z
    for y in range(FH):
        for x in range(FW):
            d = math.hypot((x - cx), (y - cy) * 1.25) / R
            if d < 1:
                px[x, y] = (255, 170, 70, int(110 * a * (1 - d) ** 1.6))
    return lay


def outline(img):
    px = img.load()
    src = img.copy().load()
    w, h = img.size
    for y in range(h):
        for x in range(w):
            if src[x, y][3] == 0:
                for dx, dy in ((1, 0), (-1, 0), (0, 1), (0, -1)):
                    nx, ny = x + dx, y + dy
                    if 0 <= nx < w and 0 <= ny < h and src[nx, ny][3] > 200:
                        px[x, y] = OUTL
                        break


def firelight(img, i):
    """Кромка силуэтов, обращённая к огню, теплеет и мерцает."""
    k = 0.55 + 0.25 * math.sin(i / NF * math.tau * 3)
    px = img.load()
    src = img.copy().load()
    w, h = img.size
    fx = FIRE_X * Z
    for y in range(h):
        for x in range(w):
            c = src[x, y]
            if c[3] == 0 or c == OUTL or y > 54 * Z:
                continue
            nx = x + (1 if x < fx else -1)
            if 0 <= nx < w:
                n = src[nx, y]
                if n[3] == 0 or n == OUTL:
                    px[x, y] = tuple(min(255, int(c[j] * (1 - k) + [255, 190, 100][j] * k)) for j in range(3)) + (255,)


def frame(i):
    img = Image.new("RGBA", (FW, FH), (0, 0, 0, 0))
    p = P(img)
    talk_h = i < 6
    sword(p)
    hero(p, i, talk_h)
    atlantida(p, i, not talk_h)
    chars = img.copy()
    outline(chars)
    firelight(chars, i)
    out = glow(i)
    out.alpha_composite(chars)
    fire(out, i)
    return out


def make_couple(outdir, hill_y, fire_bg_x):
    strip = Image.new("RGBA", (FW * NF, FH), (0, 0, 0, 0))
    for i in range(NF):
        strip.alpha_composite(frame(i), (i * FW, 0))
    strip.save(os.path.join(outdir, "title_couple.png"), optimize=True)
    return int(fire_bg_x - FIRE_X * Z), int(hill_y(fire_bg_x) + 4 - GROUND * Z), FW, FH, NF
