(ns bowling.core)

(defn group-frames [rolls]
  (partition 2 rolls))

(defn frame-score [frame]
  frame)

(defn score [rolls]
  (reduce + (map frame-score (group-frames rolls))))

