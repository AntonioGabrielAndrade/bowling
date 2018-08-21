(ns bowling.core)

(defn score [rolls]
  (reduce + rolls))

