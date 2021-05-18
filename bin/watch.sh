#!/usr/bin/env bash

set -eu
set -o pipefail

cd "$(dirname "$0")/.."

while inotifywait -r -e modify src; do
  clj -X main/run || :
done
