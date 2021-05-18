#!/usr/bin/env bash

set -eu
set -o pipefail

top=$(realpath "$(dirname "$0")/..")
scad_dir="$top/scad"

for scad in "$scad_dir"/*.scad; do
  basename "$scad"
  openscad -o "$top/stl/$(basename "$scad" .scad).stl" "$scad"
done
