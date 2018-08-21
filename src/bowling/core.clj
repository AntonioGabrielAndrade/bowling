(ns bowling.core)

(defn strike? [rolls]
  (= 10 (first rolls)))

(defn skip-frame [rolls]
  (if (strike? rolls)
    (drop 1 rolls)
    (drop 2 rolls)))

(defn take-next-frame [rolls]
  )

(defn group-frames [rolls]
  (loop [rem-rolls rolls
         frames []]
    (if (= 10 (count frames))
      frames
      (recur
        (skip-frame rem-rolls)
        (conj frames (take-next-frame rem-rolls))))))

(defn frame-score [frame]
  frame)

(defn score [rolls]
  (reduce + (map frame-score (group-frames rolls))))

