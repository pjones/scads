;; A plug to cover the umbrella hole in my patio table.
(ns table-umbrella-plug
  (:use [scad-clj.model :exclude [import use]]))

(defn leg-ring-cut-blocks
  "Several (elongated) cubes which are used to cut the leg-ring into
  individual legs."
  [radius height]
  (let [count 8] ;; The count should really be based on the radius.
    (map (fn [n] (->> (cube (/ radius 4) (* radius 2) height)
                      (rotate (deg->rad (* (/ 360 count) n)) [0 0 1])))
         (range 1 count))))

(defn leg-ring
  "A ring going around the plug that snaps the plug into place."
  [leg-thickness leg-height inner-bottom-radius]
  (let [catch-height (* leg-thickness 2)
        catch-radius (* inner-bottom-radius 1.05)]
    (difference
     (union
      (cylinder inner-bottom-radius leg-height)
      (->> (cylinder [catch-radius inner-bottom-radius] catch-height)
           (translate [0 0 (- (/ leg-height 2))])))
     (cylinder (- inner-bottom-radius leg-thickness)
               (+ leg-height catch-height))
     (union (leg-ring-cut-blocks
             catch-radius
             (+ leg-height catch-height))))))

(def plug
  "The plug."
  (let [outer-dia 62
        outer-radius (/ outer-dia 2)
        inner-top-dia 57.5
        inner-top-radius (/ inner-top-dia 2)
        inner-bottom-dia 55.5
        inner-bottom-radius (/ inner-bottom-dia 2)
        hole-depth 18
        plug-depth (/ hole-depth 2)
        leg-height (- hole-depth plug-depth)
        plate-thickness 1
        leg-thickness 1.3

        ;; The parts:
        plug (cylinder [inner-bottom-radius inner-top-radius] plug-depth)
        plate (cylinder outer-radius plate-thickness)
        legs (leg-ring leg-thickness leg-height inner-bottom-radius)]

    (union
     plug
     (->> plate
          (translate [0 0 (/ plate-thickness 2)])
          (translate [0 0 (/ plug-depth 2)]))
     (->> legs
          (translate [0 0 (- (/ leg-height 2))])
          (translate [0 0 (- (/ plug-depth 2))])))))

