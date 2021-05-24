#!/usr/bin/env bash

set -eu
set -o pipefail

cd "$(dirname "$0")/.."

bin/build.sh

while inotifywait -r -e modify src; do
  bin/build.sh || :
done
