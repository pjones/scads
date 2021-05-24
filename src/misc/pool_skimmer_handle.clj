;; A handle for a skimmer basket.
(ns pool-skimmer-handle
  (:use [scad-clj.model :exclude [import use]]))

(defn handle
  [basket-inside-diameter
   basket-outside-diameter
   basket-leg-diameter]
  (let [inside-radius (/ basket-inside-diameter 2)
        outside-radius (/ basket-outside-diameter 2)
        handle-width (- basket-outside-diameter basket-inside-diameter)
        leg-width (/ handle-width 2)
        thickness basket-leg-diameter

        ;; The overall handle structure with attachment legs:
        handle-and-legs
        (difference
         (union (cylinder inside-radius thickness)
                (->> (cube thickness
                           (+ (* inside-radius 2)
                              (* leg-width 2))
                           thickness)
                     (translate [(- (/ thickness 2)) 0 0])))
         (cylinder (- outside-radius handle-width) thickness)
         (->> (cube inside-radius (* inside-radius 2) thickness)
              (translate [(/ inside-radius 2) 0 0])))

        ;; A little tab that keeps the handle from falling into the basket.
        handle-tab
        (->> (cube handle-width (* handle-width 2) thickness)
             (translate [(- inside-radius) 0 0]))]

    ;; Put it all together:
    (union handle-and-legs
           handle-tab)))

(def model
  (handle 184 195.25 3.25))
