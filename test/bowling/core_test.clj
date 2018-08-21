(ns bowling.core-test
  (:require [clojure.test :refer :all]
            [bowling.core :refer :all]))


(deftest score-test
  (testing "zero score game"
    (is (= 0 (score (repeat 20 0)))))

  (testing "score for simple game"
    (is (= 20 (score (repeat 20 1))))))
