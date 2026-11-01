#!/usr/bin/env bash
# Запуск игры в обычной JVM (без Android) с имитацией нажатий — для поиска исключений/зависаний.
# Пример: tools/harness/run.sh "5000:-6,8000:-5,10000:-5" 30000
#   (время_мс:код_клавиши через запятую; -5 fire, -6/-7 софт, -1..-4 стрелки; затем длительность прогона в мс)
set -e
cd "$(dirname "$0")/../.."
OUT=$(mktemp -d); P=app/src/main/java
javac -encoding UTF-8 -nowarn -d "$OUT" $(find tools/harness/sim -name '*.java') $(find $P/javax $P/com $P/engine $P/main -name '*.java') $P/compat/Res.java tools/harness/src/Sim.java 2>&1 | grep -v "JAVA_TOOL\|Note:" || true
java -Djava.awt.headless=true -cp "$OUT" Sim app/src/main/assets "$OUT/rms" "${1:-5000:-6,8000:-5,10000:-5}" "${2:-30000}"
