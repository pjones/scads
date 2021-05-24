#!/usr/bin/env bash

set -eu
set -o pipefail

cd "$(realpath "$(dirname "$0")/..")"
clj -X main/run
bin/scad-to-stl.sh
