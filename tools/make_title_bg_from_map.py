#!/usr/bin/env python3
"""Фон главного меню из настоящей карты деревни (K=0): кадр pano.png снимается харнессом (-Dpano=1), затем
небо заменяется закатным, остальное окрашивается тёплым закатным светом.
Запуск: python3 tools/make_title_bg_from_map.py pano.png app/src/main/assets/title_bg.png [x_старта=450]"""
import sys, math
import numpy as np
from PIL import Image

src, out = sys.argv[1], sys.argv[2]
X0 = int(sys.argv[3]) if len(sys.argv) > 3 else 450
W, H = 720, 320
im = Image.open(src).convert("RGB")
a = np.asarray(im.crop((X0, 0, X0 + W, H))).astype(np.float32)

SKYC = np.array([185, 221, 221], dtype=np.float32)
dist = np.abs(a - SKYC).sum(axis=2)
sky = dist < 14                                   # чистое небо карты
# небо рядом с сияющей кромкой (сглаженные пиксели) тоже считаем небом, если светлое и голубоватое
sky |= (a[:, :, 2] > a[:, :, 0] + 18) & (a[:, :, 1] > 190) & (dist < 40)

# дефекты карты (обрубки верхушек деревьев и крыш в верхней части кадра) закрашиваем небом
PATCH = [(150, 0, 302, 118), (500, 0, 630, 46)]
for (px0, py0, px1, py1) in PATCH:
    sky[py0:py1, px0:px1] = True

HOR = 205.0
def hexc(h):
    return np.array([(h >> 16) & 255, (h >> 8) & 255, h & 255], dtype=np.float32)
SK = [(0.00, hexc(0x2a1f55)), (0.28, hexc(0x663070)), (0.52, hexc(0xc34e6c)), (0.74, hexc(0xf6944e)), (1.00, hexc(0xffd986))]
def grad(v):
    for i in range(len(SK) - 1):
        p0, c0 = SK[i]; p1, c1 = SK[i + 1]
        if v <= p1:
            t = (v - p0) / (p1 - p0)
            return c0 + (c1 - c0) * t
    return SK[-1][1]

BAYER = np.array([[0, 8, 2, 10], [12, 4, 14, 6], [3, 11, 1, 9], [15, 7, 13, 5]], dtype=np.float32) / 16.0
skyimg = np.zeros((H, W, 3), dtype=np.float32)
for y in range(H):
    c = grad(min(1.0, y / HOR))
    row = np.tile(c, (W, 1))
    d = BAYER[y % 4][np.arange(W) % 4] - 0.5
    skyimg[y] = row + (d * 7.0)[:, None]

# солнце за горами (диск рисуется только в области неба)
SX, SY = 190, 176
yy, xx = np.mgrid[0:H, 0:W]
r = np.hypot(xx - SX, yy - SY)
for rad, col, k in ((27, (255, 214, 120), 1.0), (21, (255, 240, 176), 1.0)):
    m = r < rad
    skyimg[m] = np.array(col, dtype=np.float32)
halo = np.clip(1 - r / 90.0, 0, 1) ** 2 * 0.35
skyimg += halo[:, :, None] * (np.array([255, 190, 110]) - skyimg)

# остальное: тёплый закатный свет. Верх — розово-пурпурный, у горизонта — оранжевый, земля темнее и фиолетовее
out_img = a.copy()
lum = (a[:, :, 0] * 0.3 + a[:, :, 1] * 0.59 + a[:, :, 2] * 0.11) / 255.0
tint_top = np.array([1.00, 0.72, 0.78], dtype=np.float32)
tint_hor = np.array([1.12, 0.78, 0.55], dtype=np.float32)
tint_low = np.array([0.88, 0.66, 0.74], dtype=np.float32)
for y in range(H):
    if y < HOR:
        t = y / HOR
        tint = tint_top + (tint_hor - tint_top) * (t ** 1.6)
    else:
        t = min(1.0, (y - HOR) / (H - HOR))
        tint = tint_hor + (tint_low - tint_hor) * t
    out_img[y] = a[y] * tint
# контрастнее и чуть темнее (вечер), тёплая подсветка слева (солнце)
out_img *= 0.88
glow = np.clip(1 - np.hypot(xx - SX, (yy - SY) * 1.4) / 260.0, 0, 1) ** 1.5
out_img += glow[:, :, None] * np.array([46, 20, 0], dtype=np.float32)
# вечерняя дымка у горизонта на дальних слоях (озеро, горы)
haze = np.clip(1 - np.abs(yy - 190) / 40.0, 0, 1) * 0.22
out_img += haze[:, :, None] * (np.array([255, 160, 100], dtype=np.float32) - out_img)

res = np.where(sky[:, :, None], skyimg, out_img)
# верёвка между столбами, закрашенная вместе с дефектами (цвет берём с соседнего участка)
rc = res[70, 70].copy()
for x in range(148, 314):
    t = (x - 148) / 166.0
    y = int(round(69 + 4 * math.sin(math.pi * t)))
    res[y, x] = rc
    res[y + 1, x] = rc * 0.8
Image.fromarray(np.clip(res, 0, 255).astype(np.uint8), "RGB").save(out)
