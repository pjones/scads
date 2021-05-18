(ns main
  (:require [misc.table-umbrella-plug]
            [scad-clj.scad :as scad]
            [scad-clj.model :as model]
            [datoteka.core :as fs]))

(defn scad-to-file
  [file scad]
  (if (not (fs/exists? "scad"))
    (fs/create-dir "scad"))
  (spit
   (fs/join "scad" file)
   (scad/write-scad
    (model/fa! 1.0)
    (model/fs! 0.5)
    scad)))

(defn run
  [_]
  (scad-to-file "table-umbrella-plug.scad" table-umbrella-plug/plug))
