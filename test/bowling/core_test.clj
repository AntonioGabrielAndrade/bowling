(ns bowling.core-test
  (:require [clojure.test :refer :all]
            [bowling.core :refer :all]))

(deftest group-frames-test
  (testing "group frames for simple game"
    (is (= '((1 0) (1 0) (1 0) (1 0) (1 0) (1 0) (1 0) (1 0) (1 0) (1 0))
           (group-frames [1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0])))))

(deftest score-test
  (testing "zero score game"
    '(is (= 0 (score (repeat 20 0)))))

  (testing "score for simple game"
    '(is (= 20 (score (repeat 20 1)))))

  (testing "score for one spare game"
    '(is (= 14 (score (concat [5 5 2] (repeat 17 0)))))))
