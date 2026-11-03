#!/usr/bin/env bash
# Быстрая проверка, что весь Java-код компилируется БЕЗ Android SDK
# (используются крошечные заглушки android.* из tools/androidstubs; в APK они не попадают).
set -e
cd "$(dirname "$0")/.."
OUT=$(mktemp -d)
javac -encoding UTF-8 -nowarn -d "$OUT" $(find tools/androidstubs app/src/main/java -name '*.java')
echo "OK: $(find "$OUT" -name '*.class' | wc -l) классов"
