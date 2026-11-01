#!/usr/bin/env bash
# Запуск игры на обычной JVM (без Android): рисует кадры в PNG и умеет "нажимать" клавиши.
# Нужен только JDK. Использование:
#   tools/desktop-harness/run.sh "<шаги>" [ширина=711] [пауза_мс=800] [время_мс=40000]
# Шаги: "состояние:клавиша,..." (клавиша — J2ME-код: -6/-7 софт, -1..-4 стрелки, -5 fire, 48..57 цифры).
# Пример (звук "Да" → меню → "Игра" → выбор сохранения):   "8:-6,5:-5,18:-5"
# Системные свойства (-D...) можно передать через JAVA_OPTS: jump=101 (сразу загрузить уровень K), probe=-7@22000
# Кадры сохраняются в $TMPDIR/frames (по умолчанию /tmp/frames).
set -e
ROOT="$(cd "$(dirname "$0")/../.." && pwd)"
J="$ROOT/app/src/main/java"
OUT="$(mktemp -d)"
cp -r "$ROOT/tools/desktop-harness/shim" "$OUT/shim"
mkdir -p "$OUT/shim/javax/microedition/lcdui" "$OUT/shim/javax/microedition/midlet" "$OUT/shim/com/nokia/mid/ui"
cp "$J"/javax/microedition/lcdui/{Display,Displayable,Canvas}.java "$OUT/shim/javax/microedition/lcdui/"
cp "$J"/javax/microedition/midlet/*.java "$OUT/shim/javax/microedition/midlet/"
cp "$J"/com/nokia/mid/ui/DirectGraphics.java "$OUT/shim/com/nokia/mid/ui/"
mkdir -p "$OUT/classes"
javac -encoding UTF-8 -nowarn -d "$OUT/classes" $(find "$OUT/shim" "$J/main" "$J/engine" -name '*.java') 2>&1 | grep -v "JAVA_TOOL\|Note:" || true
cd "$ROOT"
java -Djava.awt.headless=true -Dassets="$ROOT/app/src/main/assets" ${JAVA_OPTS:-} -cp "$OUT/classes" harness.Run "${1:-8:-6,5:-5,18:-5}" "${2:-711}" "${3:-800}" "${4:-40000}"
