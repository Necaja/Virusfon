# Разбор игры

## Манифест
```
MIDlet-1: Вирусфон Навсегда, /ico.png, main.cMIDlet
MicroEdition-Configuration: CLDC-1.0, Profile: MIDP-1.0
```
Экран 240×320 жёстко прошит в коде (`fillRect(0,0,240,320)`, `setClip(0,0,240,320)` и т.п.).

## Жизненный цикл
`cMIDlet` создаёт `main.f` (наследник `Canvas`, `Runnable`). `startApp()` → `f.a()`: `Display.setCurrent(f)` + старт потока.
**Вся игровая логика выполняется внутри `f.paint(Graphics)`**: поток `run()` в цикле вызывает `repaint(); serviceRepaints();`,
а `paint` читает состояние клавиш, обновляет мир и рисует кадр. Главная переменная состояния — `f.k`:
1 — загрузка/логотип, 2 — прогресс загрузки, 3 — заставка king86, 5 — главное меню (по анимации и вызову `menu`-музыки), 8 — сюжет/интро, 17–24 — предположительно игра на уровне (по `showNotify`),
остальное — карта мира, магазин, титры и т.д. (точный смысл каждого значения — предстоит выяснить, см. `switch (k)` в `f.paint`).

Клавиши: `f.h(keyCode)` переводит J2ME-коды в битовую маску (65536 = правая софт, 32768 = левая софт, 16416 = fire,
1028/2304/4112/8256 = вверх/вниз/влево/вправо, 1…512 = цифры 0–9, 262144 = `*`, 524288 = `#`).

## Данные
| Файл | Загрузчик | Формат (по коду) |
|---|---|---|
| `a.bin` | `main.f.n()` | Анимации спрайтов: `u16 count`, затем для каждого: `u16 id`, кадры/части (`byte[]` по 4 и 8 байт на запись), последовательности (`short[]`). Результат — `main.a.e[]` (`main.c`) |
| `p<K>.DAT` | `engine.c.a(String)` | Карта уровня K: `u16 width(tiles)`, `u16 height`, `u16 tileW`, `u16 tileH`, затем два слоя `width*height*2` байт (пары «тайл/подтип»; `-1` = пусто) |
| `script<K>.bin` | `main.f.c(String)` (в `aX`) | Скрипт уровня K: `u16 length` + `byte[]`; интерпретируется в `main.e` (диалоги, спавн, триггеры) |
| `level<N>_tile.png`, `level<N>_0_tile.png` | `engine.c.a(String,String,String)` | Тайлсеты слоёв (тайл 16×16 по умолчанию, `engine.c.c/d`), `map<N>.png` — задник |
| `enemy*.png`, `boss*.png`, `npc*.png`, `head*.png`, `zhujiao*.png` | `main.f` | Спрайт-листы персонажей |
| `splash*.png`, `story*.png`, `king86.png`, `bbox.png`, `red.png` | `main.f` | Заставки, сюжет |
| `menu.mid`, `gate.mid` | `engine.f` | Фоновая музыка (петля) |

Идентификатор уровня `K`: `K/100 + 1` — номер мира (tileset/map), полный `K` — номер файлов `p<K>.DAT`/`script<K>.bin`
(101…108, 201…208, 301…304, 401…404, 501…505, 601…610, 701/702, 0 — стартовый). Названия миров (`main.f.R`):
Fonzo Team, Лес Минга, Злой рок, Капец, Демон-Хилл, Туманы, Мир Хаоса, Снега, Ледовый дворец.

Сохранения: RMS-хранилища (в слое совместимости — файлы `files/rms/*.rms`); имена: `shaolin2MessBank` (счётчик «SMS»),
`buylike` (покупки), + сейв прогресса в `main.f` (около строки 2325).

## Слой совместимости: что покрыто
`Canvas` (paint/repaint/serviceRepaints/keyPressed/Released/Repeated/showNotify/hideNotify), `Graphics` (clip/translate,
fill/draw Rect/Line/Arc/Triangle, drawImage, drawString, drawRGB), `Image` (PNG из assets, mutable, RGB), `Font`
(системный шрифт; размеры в `Font.PX_*`), `Display`, `MIDlet`, `RecordStore`, `Player/Manager` (MIDI через `MediaPlayer`),
Nokia `DirectGraphics.drawImage` с флипами/поворотами.

Известные места, которые стоит проверить на устройстве: метрики шрифта (вёрстка рассчитана на пиксельный шрифт Nokia —
возможно, понадобится bitmap/TTF-шрифт), громкость/зацикливание MIDI на разных ROM, производительность `drawRGB` на весь экран.

## План ремейка (предложение)
1. Запустить текущий проект на устройстве, снять скриншоты/видео эталонного поведения.
2. Вынести логику из `paint()`: отдельные `update(dt)` и `render()` (самая важная переделка).
3. Расшифровать `switch (k)` в именованный enum состояний; переименовать классы: `main.f`→`Game`, `main.d`→`Entity`,
   `main.e`→`GameData/Script`, `main.a`→`Camera/World`, `engine.c`→`TileMap`, `engine.d`→`TextUi`, и т.д.
4. Написать конвертеры `p*.DAT`/`script*.bin` в читаемые форматы (JSON/TMX) — тогда уровни можно редактировать.
5. Заменить слой `javax.microedition.*` на нативный рендер (libGDX / свой SurfaceView/OpenGL), добавить масштабирование,
   сенсорное управление, сохранения в нормальном формате, замену SMS-бонусов на внутриигровую валюту.
