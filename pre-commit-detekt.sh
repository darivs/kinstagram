#!/usr/bin/env bash
set -eu

readonly PREVIOUS_PATH="$(pwd)"
readonly CHANGED_FILES="$(git --no-pager diff --name-status --no-color --cached | awk '$1 != "D" && $2 ~ /\.kts|\.kt/ { print $2}')"

if [ -z "$CHANGED_FILES" ]; then
  echo "No Kotlin staged files."
  exit 0
fi

echo "Running detekt..."

cd "$(dirname "$0")"
./gradlew --quiet detekt
cd "$PREVIOUS_PATH"

echo "Completed detekt run."
