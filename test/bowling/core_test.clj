(ns bowling.core-test
  (:require [clojure.test :refer :all]
            [bowling.core :refer :all]))


(deftest score-test
  (testing "zero score game"
    (is (= 0 (score (repeat 20 0))))))