#!/usr/bin/env python3
"""Пиксель-арт пары со спины в стиле игры: контур, двухтонная заливка, подсветка закатом. Кадры анимации ветра."""
import math, sys
from PIL import Image, ImageDraw

Z = 1.35                 # масштаб рисования относительно 48-пиксельного эскиза
FW, FH = 104, 92          # размер кадра
NF = 12                  # кадров в цикле

def C(h, a=255):
    return ((h >> 16) & 255, (h >> 8) & 255, h & 255, a)

OUT = C(0x2a1a30)
# палитра, снятая с игровых спрайтов (Вирусфон и Atlantida)
HAIR, HAIR_L, HAIR_D = C(0x2c2236), C(0x55406c), C(0x1c1426)
SKIN, SKIN_D = C(0xeab58c), C(0xc88a66)
BAND, BAND_L = C(0x3b7fe0), C(0x86b8f4)
RED, RED_D, RED_L = C(0xc6403f), C(0x8c2a36), C(0xe0605a)
WHT, WHT_D = C(0xefe4dc), C(0xb8a8b8)
UND, UND_D = C(0xa4c8ee), C(0x6f98cc)
PANT, PANT_D, PANT_L = C(0x5e7ccc), C(0x42589e), C(0x86a2e4)
WRAP, WRAP_D, SOLE = C(0xe0dcee), C(0x9c96bc), C(0xe48a3e)
BL_L, BL_M, BL_D = C(0xc4e4f8), C(0x84aaea), C(0x5c48b8)
GOLD, GOLD_D = C(0xeac84e), C(0xa87c2c)
YEL, YEL_D, YEL_L = C(0xf6cc2e), C(0xc8961c), C(0xffe36a)
SASH, SASH_D = C(0x3f8be0), C(0x2a5aa8)
SIL, SIL_D, SIL_L = C(0xe9e9f4), C(0x8f98c6), C(0xffffff)
TEAL = C(0x4fd6dc)
STRAP, STRAP_D = C(0x5a3d6a), C(0x3a2448)

class P:
    def __init__(self, img, ox, oy):
        self.d = ImageDraw.Draw(img)
        self.ox, self.oy = ox, oy
    def t(self, x, y):
        return (self.ox + x * Z, self.oy + y * Z)
    def rect(self, x0, y0, x1, y1, c):
        a = self.t(x0, y0)
        b = self.t(x1, y1)
        self.d.rectangle([round(a[0]), round(a[1]), round(b[0]) - 1, round(b[1]) - 1], fill=c)
    def poly(self, pts, c):
        self.d.polygon([(round(self.t(x, y)[0]), round(self.t(x, y)[1])) for x, y in pts], fill=c)
    def ell(self, x0, y0, x1, y1, c):
        a = self.t(x0, y0)
        b = self.t(x1, y1)
        self.d.ellipse([round(a[0]), round(a[1]), round(b[0]) - 1, round(b[1]) - 1], fill=c)
    def line(self, x0, y0, x1, y1, c, w=1):
        a = self.t(x0, y0)
        b = self.t(x1, y1)
        self.d.line([round(a[0]), round(a[1]), round(b[0]), round(b[1])], fill=c, width=w)

def blade(p, x0, y0, x1, y1, w):
    dx, dy = x1 - x0, y1 - y0
    L = math.hypot(dx, dy)
    nx, ny = -dy / L * w / 2, dx / L * w / 2
    p.poly([(x0 - nx, y0 - ny), (x0 + nx, y0 + ny), (x1 + nx, y1 + ny), (x1 - nx, y1 - ny)], BL_M)
    p.poly([(x0 - nx, y0 - ny), (x0 - nx * 0.15, y0 - ny * 0.15), (x1 - nx * 0.15, y1 - ny * 0.15), (x1 - nx, y1 - ny)], BL_L)
    p.poly([(x0 + nx * 0.2, y0 + ny * 0.2), (x0 + nx * 0.62, y0 + ny * 0.62), (x1 + nx * 0.62, y1 + ny * 0.62), (x1 + nx * 0.2, y1 + ny * 0.2)], BL_D)
    # остриё
    tip = (x0 - dx / L * 5, y0 - dy / L * 5)
    p.poly([(x0 - nx, y0 - ny), (x0 + nx, y0 + ny), tip], BL_L)

def hero(p, ph):
    w = math.sin(ph * math.tau)
    w2 = math.sin(ph * math.tau + 1.3)
    # --- ноги и обувь
    p.rect(14, 40, 19.6, 49, PANT)
    p.rect(20.4, 40, 26, 49, PANT)
    p.rect(17.5, 40, 19.6, 49, PANT_D)
    p.rect(23.8, 40, 26, 49, PANT_D)
    p.rect(14, 44, 19.6, 46, PANT_L)
    p.rect(20.4, 44, 26, 46, PANT_L)
    p.rect(13.5, 47, 19.8, 51.5, WRAP)
    p.rect(20.2, 47, 26.5, 51.5, WRAP)
    p.rect(17.5, 47, 19.8, 51.5, WRAP_D)
    p.rect(24.2, 47, 26.5, 51.5, WRAP_D)
    p.rect(13.5, 51, 19.8, 52.4, SOLE)
    p.rect(20.2, 51, 26.5, 52.4, SOLE)
    # --- подол куртки (два лоскута, колышутся)
    p.poly([(12.5, 36), (20, 36), (20 + w * 0.4, 44.5), (14 + w * 0.6, 43)], RED)
    p.poly([(20, 36), (27.5, 36), (26 + w * 0.6, 43), (20 + w * 0.4, 44.5)], RED_D)
    p.line(20, 36, 20 + w * 0.4, 44, RED_D)
    # --- торс со спины
    p.poly([(11, 24), (29, 24), (28, 36.5), (12, 36.5)], RED)
    p.poly([(21, 24), (29, 24), (28, 36.5), (21, 36.5)], RED_D)
    p.rect(12, 25, 13.5, 35, RED_L)
    # голубой пояс и узел
    p.rect(11.5, 33, 28.5, 36, UND)
    p.rect(11.5, 35, 28.5, 36, UND_D)
    p.poly([(26.5, 33.5), (31 + w2 * 1.2, 35), (32 + w2 * 1.6, 39), (28.5, 37)], UND)
    p.poly([(27, 35), (29.5 + w2, 38.5), (29 + w2 * 1.4, 42 + w2), (27, 38)], UND_D)
    # воротник
    p.rect(15.5, 22.8, 24.5, 25.3, UND)
    p.rect(15.5, 24.4, 24.5, 25.3, UND_D)
    # --- ножны/ремни и меч на спине
    p.poly([(12, 24), (14.2, 24), (28, 36), (26, 37)], STRAP)
    p.poly([(26, 24), (28, 24), (14.5, 35), (13, 34)], STRAP_D)
    blade(p, 8.5, 46.5, 31.5, 17.5, 4.6)
    p.poly([(29.2, 16.8), (33.8, 13.4), (36.4, 16.4), (31.6, 19.8)], GOLD)       # гарда
    p.poly([(31.2, 16.8), (33.8, 13.4), (35, 14.8), (32.4, 18.2)], GOLD_D)
    p.poly([(33.5, 12.6), (35, 11.4), (37.6, 8.6), (36.2, 7.6), (32.4, 10.8)], GOLD_D)   # рукоять
    p.ell(35.3, 6.2, 38.6, 9.4, GOLD)
    # --- руки: белые рукава, тёмные наручи, кисти
    p.poly([(7.5, 25.5), (12, 24.5), (12.2, 33), (8.2, 34)], WHT)
    p.poly([(8.2, 31), (12.2, 31), (12.2, 33), (8.2, 34)], WHT_D)
    p.rect(8.4, 33.5, 12, 37.5, STRAP_D)
    p.ell(8.4, 36.5, 12, 40, SKIN)
    p.poly([(28, 24.5), (32.6, 25.5), (33.6, 34), (28.4, 33)], WHT)
    p.poly([(29, 30.5), (33.4, 31.5), (33.6, 34), (28.4, 33)], WHT_D)
    p.rect(28.6, 33, 33, 36.5, STRAP_D)
    p.ell(29, 36, 33.6, 39.8, SKIN)
    # --- шея, голова, волосы
    p.rect(17, 19.5, 23.2, 23.6, SKIN_D)
    p.ell(11.5, 6.5, 28.8, 22.2, HAIR)
    p.ell(10.8, 14.5, 13.8, 18.8, SKIN)          # уши
    p.ell(26.6, 14.5, 29.6, 18.8, SKIN)
    p.ell(14, 7.5, 22, 14, HAIR_L)
    # пряди и шипы (качаются)
    spikes = [(12, 14, 8.8, 8 + w * 0.8), (15.5, 9, 13, 2.4 + w * 1.0), (19.5, 7.2, 19.4 + w * 0.6, 0.6), (23.5, 8.6, 26.4 + w * 0.8, 2.8), (27.2, 12, 30.4 + w, 7.8)]
    for (bx, by, tx, ty) in spikes:
        p.poly([(bx - 2.4, by + 1.5), (bx + 2.4, by + 1.5), (tx, ty)], HAIR)
    p.poly([(15.5 - 1.4, 10), (15.5 + 0.4, 10), (13 + 0.4, 4.2 + w)], HAIR_L)
    p.poly([(19.5 - 1.2, 8.4), (19.5 + 0.6, 8.4), (19.4 + w * 0.6 + 0.2, 2.2)], HAIR_L)
    # затылок: длинные пряди вниз
    p.poly([(13.5, 18), (17, 19), (15.5 + w * 0.5, 25.5)], HAIR)
    p.poly([(23, 19), (27, 18), (25.5 + w * 0.7, 26.5)], HAIR_D)
    # повязка
    p.rect(11.4, 13.4, 28.6, 16, BAND)
    p.rect(11.4, 15.1, 28.6, 16, SASH_D)
    p.rect(11.4, 13.4, 28.6, 14.2, BAND_L)
    p.ell(9.4, 12.6, 13, 16.8, BAND)
    for k, (oy, ln) in enumerate(((13.6, 9), (15.2, 11))):
        top = []
        bot = []
        for i in range(0, 9):
            xx = 10.4 - i * ln / 8
            yy = oy + math.sin(ph * math.tau * 1.0 + i * 0.7 + k) * (0.6 + i * 0.42) + i * 0.35
            top.append((xx, yy - 0.5))
            bot.append((xx, yy + 1.4 - i * 0.12))
        p.poly(top + bot[::-1], BAND if k == 0 else SASH)

def atlantida(p, ph):
    w = math.sin(ph * math.tau + 0.7)
    w2 = math.sin(ph * math.tau + 2.0)
    ox = 0
    # --- ноги и сандалии
    p.rect(42, 42, 45, 50, SKIN)
    p.rect(48.2, 42, 51.2, 50, SKIN)
    p.rect(44, 42, 45, 50, SKIN_D)
    p.rect(50.2, 42, 51.2, 50, SKIN_D)
    p.rect(41.4, 49.6, 45.6, 51.4, STRAP_D)
    p.rect(47.6, 49.6, 51.8, 51.4, STRAP_D)
    p.rect(41.4, 51, 45.6, 52.3, SOLE)
    p.rect(47.6, 51, 51.8, 52.3, SOLE)
    p.line(42, 48, 45, 49.6, STRAP, 1)
    p.line(48.4, 48, 51.4, 49.6, STRAP, 1)
    # --- платье: юбка с рваным подолом, колышется
    hem = [(38.5 + w * 0.8, 42.6), (40.6 + w * 0.6, 44.2), (42.6, 42.4), (44.6, 44.4), (46.6, 42.4), (48.6, 44.6), (50.6, 42.5), (52.6 + w * 0.6, 44.3), (54.4 + w * 0.8, 42.6)]
    p.poly([(41, 26), (51.8, 26), (54.4 + w * 0.8, 42.6)] + hem[::-1][:-1] + [(38.5 + w * 0.8, 42.6)], YEL)
    p.poly([(46.6, 26), (51.8, 26), (54.4 + w * 0.8, 42.6), (50.6, 42.5), (46.6, 42.4)], YEL_D)
    p.rect(41.5, 27, 43, 38, YEL_L)
    # складка
    p.line(46.4, 32, 46.2 + w * 0.3, 42, YEL_D)
    # пояс и бант на спине
    p.rect(41.2, 32.2, 51.6, 35, SASH)
    p.rect(41.2, 34, 51.6, 35, SASH_D)
    p.poly([(46, 33), (41.6 + w2 * 0.8, 30.4), (40.4 + w2 * 0.8, 36.4), (45.6, 34.4)], SASH)
    p.poly([(46.8, 33), (52.4 + w2 * 0.8, 30.2), (53.4 + w2 * 0.8, 36.6), (47.2, 34.4)], SASH_D)
    p.poly([(45.6, 34.2), (43 + w2, 40.6), (44.6 + w2, 41.6), (46.8, 35)], SASH)
    p.ell(45, 32.4, 48.4, 35.6, SASH_D)
    # --- плечи (платье без бретелей) и руки
    p.rect(40.2, 21.8, 52.8, 27.4, SKIN)
    p.rect(40.8, 26.4, 52.2, 27.4, SKIN_D)
    p.rect(37.4, 25, 40.8, 29, SKIN)
    p.rect(37.6, 28.4, 40.6, 36.6, SKIN)
    p.rect(39.6, 28.4, 40.6, 36.6, SKIN_D)
    p.ell(37.2, 35.8, 40.8, 39.2, SKIN)          # кисть тянется к герою
    p.rect(52.2, 25, 55.6, 29, SKIN)
    p.poly([(52.6, 28), (56.4, 29.4), (55.2, 35.6), (52, 33)], SKIN)    # рука на поясе (локоть наружу)
    p.poly([(54.6, 28.8), (56.4, 29.4), (55.2, 35.6), (54, 34.2)], SKIN_D)
    p.ell(50.2, 33.2, 53.6, 36.4, SKIN)
    # --- шея
    p.rect(44.4, 20.4, 48.8, 23.6, SKIN_D)
    # --- волосы серебристые: каре до плеч, чёлка не видна (вид со спины)
    p.ell(40.4, 7.6, 52.8, 21.6, SIL)
    p.poly([(40.8, 15), (52.4, 15), (53 + w * 0.6, 23.8), (51 + w * 0.4, 24.8), (49.6, 21.6), (43.6, 21.6), (42.2 + w * 0.4, 24.8), (40.2 + w * 0.6, 23.8)], SIL)
    p.poly([(47.2, 14), (52.4, 15), (53 + w * 0.6, 23.8), (51 + w * 0.4, 24.8), (49.6, 21.6), (47.2, 21.6)], SIL_D)
    p.ell(41.2, 8.4, 48.4, 13.8, SIL_L)
    p.poly([(41.2, 9.0), (46.8, 8.2), (44.2, 12.4)], SIL_L)
    p.poly([(43.8, 17), (46.4, 17), (45 + w * 0.4, 22.6)], SIL_D)
    # бирюзовая заколка
    p.ell(41.8, 9.6, 44.6, 12.2, TEAL)
    p.ell(42.4, 10.1, 43.4, 11.1, SIL_L)

def outline(img):
    px = img.load()
    w, h = img.size
    src = img.copy().load()
    for y in range(h):
        for x in range(w):
            if src[x, y][3] == 0:
                for dx, dy in ((1, 0), (-1, 0), (0, 1), (0, -1)):
                    nx, ny = x + dx, y + dy
                    if 0 <= nx < w and 0 <= ny < h and src[nx, ny][3] > 0:
                        px[x, y] = OUT
                        break

def rim(img, strength=1.0):
    """Подсветка закатом: левая кромка силуэта и верх (солнце слева-впереди)."""
    px = img.load()
    src = img.copy().load()
    w, h = img.size
    for y in range(h):
        for x in range(w):
            c = src[x, y]
            if c[3] == 0 or c == OUT:
                continue
            lx = src[x - 1, y] if x > 0 else (0, 0, 0, 0)
            if lx[3] == 0 or lx == OUT:
                px[x, y] = tuple(min(255, int(c[i] * 0.25 + [255, 196, 120][i] * 0.75)) for i in range(3)) + (255,)

def render_frame(i):
    ph = i / NF
    img = Image.new("RGBA", (FW, FH), (0, 0, 0, 0))
    oy = 12
    p = P(img, 8, oy)
    hero(p, ph)
    atlantida(p, ph)
    outline(img)
    rim(img)
    return img

if __name__ == "__main__":
    out = sys.argv[1]
    strip = Image.new("RGBA", (FW * NF, FH), (0, 0, 0, 0))
    for i in range(NF):
        strip.alpha_composite(render_frame(i), (i * FW, 0))
    strip.save(out)
    # крупный просмотр кадра 0 и 6 на закатном фоне
    if len(sys.argv) > 2:
        bg = Image.new("RGBA", (FW * 2, FH), (150, 80, 110, 255))
        bg.alpha_composite(render_frame(0), (0, 0))
        bg.alpha_composite(render_frame(6), (FW, 0))
        bg.resize((FW * 2 * 6, FH * 6), Image.NEAREST).save(sys.argv[2])
