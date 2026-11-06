"""Пара героев у костра: собирается из НАСТОЯЩИХ спрайтов игры (zhujiao1.png — Вирусфон, npc2.png — Атлантида).
Детали вырезаются из атласов, поворачиваются/отражаются и ставятся в позу «сидят у костра». Рисуется в родном
разрешении игры и увеличивается x2 без сглаживания, потому что остальная графика меню тоже пиксельная."""
import math, os
import numpy as np
from PIL import Image, ImageDraw

ASSETS = os.path.join(os.path.dirname(os.path.abspath(__file__)), "..", "app", "src", "main", "assets")
HERO = Image.open(os.path.join(ASSETS, "zhujiao1.png")).convert("RGBA")
ATL = Image.open(os.path.join(ASSETS, "npc2.png")).convert("RGBA")
S = 2
NW, NH, NF = 84, 66, 12
DY = 9          # кадр в родных пикселях
FW, FH = NW * S, NH * S
FIRE_X, GROUND = 44, 58


def C(h, a=255):
    return ((h >> 16) & 255, (h >> 8) & 255, h & 255, a)


def part(img, atlas, box, x, y, ang=0, flip=False, clear=()):
    """Вставить деталь атласа: левый верх (x,y) после поворота; clear — прямоугольники внутри box, которые стереть."""
    p = atlas.crop(box)
    p.putalpha(p.getchannel('A').point(lambda v: 255 if v >= 128 else 0))
    if clear:
        px = p.load()
        for (cx0, cy0, cx1, cy1) in clear:
            for yy in range(cy0, cy1):
                for xx in range(cx0, cx1):
                    px[xx, yy] = (0, 0, 0, 0)
    if flip:
        p = p.transpose(Image.FLIP_LEFT_RIGHT)
    if ang:
        p = p.rotate(ang, resample=Image.NEAREST, expand=True)
    img.alpha_composite(p, (int(x), int(y)))


OL = (0x1f, 0x1c, 0x2e, 255)


def K(h):
    return ((h >> 16) & 255, (h >> 8) & 255, h & 255, 255)


RED, RED_D, LB, MB, BLU, BOOT, ORG, SKH, WHT, GREY, PUR = (K(0xbe313e), K(0x8c2036), K(0xb3daf2), K(0x67a6cd), K(0x2562d2), K(0x564561),
                                                         K(0xf1a259), K(0xfad587), K(0xecf0f3), K(0xcac8d2), K(0x50128d))
Y1, Y2, Y3, SK, SKD, DK = K(0xfcf157), K(0xf1ce44), K(0xdc990c), K(0xf1b689), K(0xcb9779), K(0x681c26)
SASH = K(0x2f8fd8)


def outline_nat(img):
    src = img.copy().load()
    px = img.load()
    w, h = img.size
    for y in range(h):
        for x in range(w):
            if src[x, y][3] == 0:
                for dx, dy in ((1, 0), (-1, 0), (0, 1), (0, -1)):
                    nx, ny = x + dx, y + dy
                    if 0 <= nx < w and 0 <= ny < h and src[nx, ny][3] > 0 and src[nx, ny] != OL:
                        px[x, y] = OL
                        break


def hero_sit(img, i, talk):
    ph = i / NF * math.tau
    b = 1 if (talk and i % 2) else 0
    g = math.sin(ph * 2) if talk else 0.3 * math.sin(ph)
    Y = 5
    body = Image.new("RGBA", img.size, (0, 0, 0, 0))
    d = ImageDraw.Draw(body)

    def P(pts, c):
        d.polygon([(x, y + Y) for x, y in pts], fill=c)

    # дальняя нога вытянута к костру, сапог с оранжевой окантовкой
    P([(6, 36), (27, 35), (28, 38), (6, 39)], LB)
    P([(6, 38), (28, 38), (29, 42), (6, 42)], BLU)
    P([(6, 39), (28, 39), (28, 40), (6, 40)], MB)
    P([(27, 34), (34, 35), (36, 42), (27, 42)], BOOT)
    P([(27, 36), (35, 37), (35, 38), (27, 37)], ORG)
    # корпус: красная куртка, голубой воротник и пояс
    P([(5, 17), (14, 16), (17, 22), (16, 36), (4, 37), (3, 24)], RED)
    P([(3, 24), (5, 17), (6, 18), (5, 36), (4, 37)], PUR)
    P([(8, 17), (12, 24), (15, 23), (13, 17)], LB)
    P([(6, 14), (13, 14), (15, 19), (8, 20)], LB)
    P([(4, 31), (16, 30), (16, 33), (4, 34)], BLU)
    # ближняя нога: колено вверх, голень вниз, сапог
    P([(6, 40), (9, 35), (20, 29), (25, 32), (17, 40)], LB)
    P([(9, 35), (20, 29), (21, 31), (10, 37)], WHT)
    P([(20, 30), (25, 32), (28, 40), (23, 41)], BLU)
    P([(23, 38), (31, 38), (32, 42), (22, 42)], BOOT)
    P([(23, 39), (31, 39), (31, 40), (23, 40)], ORG)
    # рука: белый рукав лежит на колене, предплечье жестикулирует
    ex, ey = 17, 28
    hx, hy = 25 + g * 2, 22 - g * 3
    d.line([(12, 20 + Y), (ex, ey + Y)], fill=WHT, width=4)
    d.line([(ex, ey + Y), (hx, hy + Y)], fill=WHT, width=3)
    d.line([(hx - 3, hy + Y + 0.5), (hx - 1, hy + Y)], fill=OL, width=3)
    d.rectangle([hx, hy + Y - 1, hx + 2, hy + Y + 1], fill=SKH)
    outline_nat(body)
    body.paste((0, 0, 0, 0), (0, GROUND + 1, body.width, body.height))
    img.alpha_composite(body)
    part(img, HERO, (0, 0, 14, 21), 1, 0 + Y + b - 2)


def atlantida_sit(img, i, talk):
    ph = i / NF * math.tau
    b = 1 if (talk and i % 2) else 0
    g = math.sin(ph * 2 + 0.5) if talk else 0.3 * math.sin(ph)
    body = Image.new("RGBA", img.size, (0, 0, 0, 0))
    d = ImageDraw.Draw(body)

    def P(pts, c):
        d.polygon(pts, fill=c)

    # босая ступня выглядывает из-под платья
    P([(34, 43), (41, 42), (42, 47), (34, 47)], SK)
    P([(34, 45), (41, 44), (41, 45), (34, 46)], DK)
    # платье: торс, пояс, широкая юбка с коленом
    P([(45, 20), (54, 20), (57, 29), (55, 40), (44, 40), (42, 28)], Y2)
    P([(45, 20), (47, 20), (45, 40), (44, 40), (42, 28)], Y1)
    P([(52, 21), (54, 20), (57, 29), (55, 40), (52, 40)], Y3)
    P([(43, 31), (56, 30), (56, 33), (43, 34)], SASH)
    P([(41, 36), (46, 33), (56, 34), (63, 43), (64, 47), (37, 47), (38, 41)], Y2)
    P([(38, 41), (41, 36), (46, 33), (47, 38), (44, 44)], Y1)
    P([(56, 36), (63, 43), (64, 47), (52, 47), (56, 40)], Y3)
    d.line([(48, 40), (50, 47)], fill=Y3)
    d.line([(55, 42), (57, 47)], fill=Y3)
    # голая рука жестикулирует к костру, на запястье браслет
    ex, ey = 44, 31
    hx, hy = 38 - g * 2, 27 - g * 3
    d.line([(46, 23), (ex, ey)], fill=SK, width=3)
    d.line([(ex, ey), (hx, hy)], fill=SK, width=3)
    d.rectangle([hx + 2, hy - 1, hx + 3, hy + 1], fill=Y3)
    d.rectangle([hx - 1, hy - 1, hx + 1, hy + 1], fill=SK)
    P([(46, 17), (51, 17), (51, 22), (46, 22)], SK)
    outline_nat(body)
    body.paste((0, 0, 0, 0), (0, GROUND + 1, body.width, body.height))
    img.alpha_composite(body)
    part(img, ATL, (16, 0, 31, 17), 41, 7 + b)


def hero_stand(img, i, talk):
    b = 1 if (talk and i % 2) else 0
    G = GROUND
    body = Image.new("RGBA", img.size, (0, 0, 0, 0))
    d = ImageDraw.Draw(body)

    def P(pts, c):
        d.polygon(pts, fill=c)

    x0 = 6
    # ноги: синие штаны, сапоги с оранжевой окантовкой (дальняя нога чуть позади)
    P([(x0 + 3, G - 15), (x0 + 11, G - 15), (x0 + 11, G - 5), (x0 + 4, G - 5)], MB)
    P([(x0 + 4, G - 15), (x0 + 8, G - 15), (x0 + 8, G - 5), (x0 + 4, G - 5)], BLU)
    P([(x0 + 3, G - 5), (x0 + 11, G - 5), (x0 + 13, G), (x0 + 3, G)], BOOT)
    P([(x0 + 3, G - 3), (x0 + 12, G - 3), (x0 + 12, G - 2), (x0 + 3, G - 2)], ORG)
    P([(x0 + 5, G - 16), (x0 + 13, G - 16), (x0 + 14, G - 5), (x0 + 6, G - 5)], LB)
    P([(x0 + 10, G - 16), (x0 + 13, G - 16), (x0 + 14, G - 5), (x0 + 11, G - 5)], BLU)
    P([(x0 + 5, G - 5), (x0 + 15, G - 5), (x0 + 17, G), (x0 + 5, G)], BOOT)
    P([(x0 + 5, G - 3), (x0 + 16, G - 3), (x0 + 16, G - 2), (x0 + 5, G - 2)], ORG)
    # подол и корпус: красная куртка
    P([(x0 + 1, G - 22), (x0 + 15, G - 22), (x0 + 16, G - 13), (x0 + 3, G - 12)], RED)
    P([(x0 + 1, G - 22), (x0 + 3, G - 22), (x0 + 4, G - 12), (x0 + 3, G - 12)], PUR)
    P([(x0 + 2, G - 32), (x0 + 14, G - 32), (x0 + 16, G - 22), (x0 + 1, G - 22)], RED)
    P([(x0 + 2, G - 32), (x0 + 4, G - 32), (x0 + 2, G - 22), (x0 + 1, G - 22)], PUR)
    P([(x0 + 7, G - 32), (x0 + 11, G - 32), (x0 + 12, G - 25), (x0 + 9, G - 23)], LB)
    P([(x0 + 1, G - 25), (x0 + 16, G - 25), (x0 + 16, G - 22), (x0 + 1, G - 22)], BLU)
    P([(x0 + 4, G - 34), (x0 + 12, G - 34), (x0 + 14, G - 30), (x0 + 3, G - 30)], WHT)
    P([(x0 + 4, G - 31), (x0 + 12, G - 31), (x0 + 13, G - 30), (x0 + 3, G - 30)], GREY)
    # рука с белым рукавом и перчаткой, жестикулирует
    g = math.sin(i / NF * math.tau * 2) if talk else 0
    ex, ey = x0 + 15, G - 24
    hx, hy = x0 + 22, G - 28 - g * 2
    d.line([(x0 + 12, G - 31), (ex, ey)], fill=WHT, width=3)
    d.line([(ex, ey), (hx, hy)], fill=WHT, width=3)
    d.line([(hx - 2, hy + 0.5), (hx, hy)], fill=OL, width=3)
    d.rectangle([hx + 1, hy - 1, hx + 3, hy + 1], fill=SKH)
    outline_nat(body)
    body.paste((0, 0, 0, 0), (0, GROUND + 1, body.width, body.height))
    img.alpha_composite(body)
    part(img, HERO, (48, 0, 64, 16), x0 + 0, G - 49 + b)


def atlantida_stand(img, i, talk):
    b = 1 if (talk and i % 2) else 0
    G = GROUND
    body = Image.new("RGBA", img.size, (0, 0, 0, 0))
    d = ImageDraw.Draw(body)

    def P(pts, c):
        d.polygon(pts, fill=c)

    x0 = 41
    # ноги, сандалии
    P([(x0 + 3, G - 12), (x0 + 6, G - 12), (x0 + 6, G - 3), (x0 + 3, G - 3)], SK)
    P([(x0 + 8, G - 12), (x0 + 11, G - 12), (x0 + 11, G - 3), (x0 + 8, G - 3)], SK)
    P([(x0 + 3, G - 12), (x0 + 4, G - 12), (x0 + 4, G - 3), (x0 + 3, G - 3)], SKD)
    P([(x0 + 8, G - 12), (x0 + 9, G - 12), (x0 + 9, G - 3), (x0 + 8, G - 3)], SKD)
    P([(x0 + 1, G - 3), (x0 + 6, G - 3), (x0 + 6, G), (x0 + 1, G)], PUR)
    P([(x0 + 7, G - 3), (x0 + 12, G - 3), (x0 + 12, G), (x0 + 7, G)], PUR)
    P([(x0 + 1, G - 1), (x0 + 6, G - 1), (x0 + 6, G), (x0 + 1, G)], ORG)
    P([(x0 + 7, G - 1), (x0 + 12, G - 1), (x0 + 12, G), (x0 + 7, G)], ORG)
    # тёмные шорты и жёлтое короткое платье с голубым поясом
    P([(x0 + 2, G - 14), (x0 + 12, G - 14), (x0 + 12, G - 11), (x0 + 2, G - 11)], K(0x2a1850))
    P([(x0 + 1, G - 28), (x0 + 12, G - 28), (x0 + 14, G - 14), (x0 + 0, G - 14)], Y2)
    P([(x0 + 1, G - 28), (x0 + 4, G - 28), (x0 + 2, G - 14), (x0 + 0, G - 14)], Y1)
    P([(x0 + 10, G - 28), (x0 + 12, G - 28), (x0 + 14, G - 14), (x0 + 10, G - 14)], Y3)
    P([(x0 + 1, G - 22), (x0 + 13, G - 22), (x0 + 13, G - 20), (x0 + 1, G - 20)], SASH)
    # рука на поясе / жест, лента-браслет
    g = math.sin(i / NF * math.tau * 2 + 0.5) if not talk else 0
    d.line([(x0 + 3, G - 27), (x0 - 4, G - 21), (x0 - 7, G - 25 - g * 2)], fill=SK, width=2)
    d.rectangle([x0 - 9, G - 27 - g * 2, x0 - 7, G - 24 - g * 2], fill=SK)
    d.line([(x0 - 5, G - 23), (x0 - 4, G - 22)], fill=Y3, width=2)
    d.line([(x0 + 11, G - 26), (x0 + 15, G - 20), (x0 + 11, G - 17)], fill=SK, width=2)
    outline_nat(body)
    body.paste((0, 0, 0, 0), (0, GROUND + 1, body.width, body.height))
    img.alpha_composite(body)
    part(img, ATL, (16, 0, 31, 17), x0 - 3, G - 45 + b)


MODE = "sitgame"


CH = os.path.join(os.path.dirname(os.path.abspath(__file__)), "title_chars")
HERO_G = Image.open(os.path.join(CH, "hero.png")).convert("RGBA").transpose(Image.FLIP_LEFT_RIGHT)  # лицом к Атлантиде   # кадры из самой игры (стоят в деревне), без изменений
ATL_G = Image.open(os.path.join(CH, "atl.png")).convert("RGBA")


def hero(img, i, talk):
    if MODE == "sitgame":
        up = HERO_G.crop((0, 0, 34, 35))                       # голова, торс, руки из игры (уже лицом вправо)
        up.paste((0, 0, 0, 0), (0, 22, 8, 35))                 # убрать рукоять меча
        # ноги из атласа лёжа на земле: дальняя вытянута к костру, ближняя — тоже, с сапогом на земле
        leg = HERO.crop((0, 50, 12, 78)).rotate(90, expand=True)
        back = leg.copy()
        bp = back.load()
        for yy in range(back.height):
            for xx in range(back.width):
                r, g, b, a = bp[xx, yy]
                if a:
                    bp[xx, yy] = (int(r * 0.75), int(g * 0.75), int(b * 0.8), a)
        img.alpha_composite(back, (14, GROUND - 13))
        img.alpha_composite(leg, (11, GROUND - 12))
        # подол халата лежит на земле под корпусом (как у сидящего), чтобы не было просвета под спиной
        dr = ImageDraw.Draw(img)
        dr.rectangle([12, GROUND - 10, 23, GROUND - 1], fill=(0xbe, 0x31, 0x3e, 255))
        dr.rectangle([12, GROUND - 10, 13, GROUND - 1], fill=(0x50, 0x12, 0x8d, 255))
        dr.rectangle([14, GROUND - 3, 23, GROUND - 1], fill=(0x8c, 0x20, 0x36, 255))
        dr.rectangle([11, GROUND - 10, 11, GROUND - 1], fill=(0x1f, 0x1c, 0x2e, 255))
        dr.line([(11, GROUND), (23, GROUND)], fill=(0x1f, 0x1c, 0x2e, 255))
        img.alpha_composite(up, (3, GROUND - 12 - 28))
        return
    if MODE == "game":
        img.alpha_composite(HERO_G, (3, GROUND - HERO_G.height + 7))
        return
    (hero_stand if MODE == "stand" else hero_sit)(img, i, talk)


def atlantida(img, i, talk):
    if MODE == "sitgame":
        up = ATL_G.crop((0, 0, 20, 36))
        x0 = NW - 24
        lg = ATL.crop((0, 20, 7, 31)).rotate(-90, expand=True)   # ноги подогнуты в невидимую сторону — видны только голени у края платья
        img.alpha_composite(lg, (x0 - 3, GROUND - 9))
        img.alpha_composite(lg, (x0 - 5, GROUND - 6))
        img.alpha_composite(up, (x0, GROUND - 36))
        return
    if MODE == "game":
        img.alpha_composite(ATL_G, (NW - ATL_G.width - 3, GROUND - ATL_G.height + 1))
        return
    (atlantida_stand if MODE == "stand" else atlantida_sit)(img, i, talk)


def fire(img, i):
    d = ImageDraw.Draw(img)
    ph = i / NF * math.tau
    h = 8 + 1.6 * math.sin(ph * 3) + math.sin(ph * 5 + 1)
    sw = math.sin(ph * 2)
    cx = FIRE_X
    base = GROUND
    d.polygon([(cx - 8, base), (cx - 7, base - 3), (cx + 8, base), (cx + 7, base + 1)], fill=C(0x6a4430))
    d.polygon([(cx + 8, base - 2), (cx + 7, base - 3), (cx - 8, base - 1), (cx - 7, base)], fill=C(0x3a2418))
    for (k, col) in ((1.0, C(0xd8402a)), (0.75, C(0xf2862c)), (0.5, C(0xffd24a)), (0.25, C(0xfff4b0))):
        w = 5 * k
        d.polygon([(cx - w, base - 1), (cx - w * 0.7, base - 1 - h * k * 0.5), (cx + sw * k, base - 1 - h * k), (cx + w * 0.7, base - 1 - h * k * 0.5), (cx + w, base - 1)], fill=col)
    for s in range(4):
        t = (i / NF + s * 0.25) % 1.0
        x = cx + 2 * math.sin(s * 2.3 + t * 5) + (s - 1.5) * 1.5
        y = base - 8 - t * 14
        d.point((int(x), int(y)), fill=C(0xffd870, int(255 * (1 - t))))


def glow(i):
    ph = i / NF * math.tau
    a = 0.8 + 0.2 * math.sin(ph * 3) * math.cos(ph)
    lay = Image.new("RGBA", (FW, FH), (0, 0, 0, 0))
    px = lay.load()
    cx, cy = FIRE_X * S, (GROUND - 4) * S
    R = 34 * S
    for y in range(FH):
        for x in range(FW):
            d = math.hypot(x - cx, (y - cy) * 1.25) / R
            if d < 1:
                px[x, y] = (255, 170, 70, int(100 * a * (1 - d) ** 1.6))
    return lay


def firelight(img, i):
    k = 0.45 + 0.2 * math.sin(i / NF * math.tau * 3)
    px = img.load()
    src = img.copy().load()
    for y in range(img.height):
        for x in range(img.width):
            c = src[x, y]
            if c[3] == 0 or y > GROUND - 1:
                continue
            nx = x + (1 if x < FIRE_X else -1)
            if 0 <= nx < img.width and src[nx, y][3] == 0:
                px[x, y] = tuple(min(255, int(c[j] * (1 - k) + [255, 190, 100][j] * k)) for j in range(3)) + (255,)


def wind(img, box, phase, a0, a1, lag=0.45):
    """Лёгкий ветер: строки области сдвигаются по синусоиде (к низу/краю сильнее). Оригинал остаётся под сдвинутым — дыр не бывает."""
    x0, y0, x1, y1 = box
    base = img.copy()
    for y in range(y0, y1):
        t = (y - y0) / max(1, y1 - y0 - 1)
        d = round((a0 + (a1 - a0) * t) * math.sin(phase + (y - y0) * lag))
        if d == 0:
            continue
        seg = base.crop((x0, y, x1, y + 1))
        img.alpha_composite(seg, (x0 + d, y))


def epx2(img):
    """Scale2x/EPX: увеличение вдвое со сглаживанием диагоналей (как игра сглаживает свои спрайты); игра потом ещё раз сглаживает при выводе."""
    a = np.array(img.convert("RGBA")).astype(np.uint32)
    k = (a[:, :, 0] << 24) | (a[:, :, 1] << 16) | (a[:, :, 2] << 8) | a[:, :, 3]
    k = np.where(a[:, :, 3] == 0, 0, k)
    pad = np.pad(k, 1, mode="edge")
    A, D = pad[:-2, 1:-1], pad[2:, 1:-1]
    C, B = pad[1:-1, :-2], pad[1:-1, 2:]
    P = k
    o1 = np.where((C == A) & (C != D) & (A != B), A, P)
    o2 = np.where((A == B) & (A != C) & (B != D), B, P)
    o3 = np.where((D == C) & (D != B) & (C != A), C, P)
    o4 = np.where((B == D) & (B != A) & (D != C), D, P)
    h, w = k.shape
    out = np.zeros((h * 2, w * 2), dtype=np.uint32)
    out[0::2, 0::2], out[0::2, 1::2], out[1::2, 0::2], out[1::2, 1::2] = o1, o2, o3, o4
    rgba = np.stack([(out >> 24) & 255, (out >> 16) & 255, (out >> 8) & 255, out & 255], axis=-1).astype(np.uint8)
    return Image.fromarray(rgba, "RGBA")


def frame(i):
    nat = Image.new("RGBA", (NW, NH), (0, 0, 0, 0))
    talk_h = i < 6
    hero(nat, i, talk_h)
    atlantida(nat, i, not talk_h)
    ph = i / NF * math.tau
    if MODE == "sitgame":
        top_h, top_a = GROUND - 40, GROUND - 36
        wind(nat, (1, top_h, 13, top_h + 17), ph, 0.3, 1.8)              # хвост и волосы Вирусфона
        wind(nat, (1, top_h + 15, 12, top_h + 30), ph + 1.0, 0.4, 1.0, 0.6)  # рукав/шарф
        wind(nat, (NW - 14, top_a, NW + 4, top_a + 20), ph + 0.7, 0.3, 2.0)  # волосы Атлантиды
        wind(nat, (NW - 24, top_a + 27, NW - 3, top_a + 36), ph + 0.3, 0.4, 1.1, 0.8)  # подол платья
    firelight(nat, i)
    fire(nat, i)
    big = epx2(nat)
    out = glow(i)
    out.alpha_composite(big)
    return out, nat


def make_couple(outdir, hill_y, fire_bg_x):
    strip = Image.new("RGBA", (FW * NF, FH), (0, 0, 0, 0))
    for i in range(NF):
        strip.alpha_composite(frame(i)[0], (i * FW, 0))
    strip.save(os.path.join(outdir, "title_couple.png"), optimize=True)
    return int(fire_bg_x - FIRE_X * S), int(hill_y(fire_bg_x) + 4 - GROUND * S), FW, FH, NF


if __name__ == "__main__":
    import sys
    f = frame(int(sys.argv[2]) if len(sys.argv) > 2 else 2)[1]
    bg = Image.new("RGBA", f.size, (200, 120, 90, 255)); bg.alpha_composite(f)
    bg.resize((f.width * 10, f.height * 10), Image.NEAREST).save(sys.argv[1])
