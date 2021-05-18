let
  sources = import nix/sources.nix;
in
{ pkgs ? import sources.nixpkgs { } }:

pkgs.mkShell {
  name = "scad";

  buildInputs = with pkgs; [
    clojure
    clj-kondo
  ];
}
