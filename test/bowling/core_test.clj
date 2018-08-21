(ns bowling.core-test
  (:require [clojure.test :refer :all]
            [bowling.core :refer :all]))

(deftest strike?-test
  (testing "check if next frame in rolls is a strike"
    (is (strike? (concat [10] (repeat 18 1))))))

(deftest spare?-test
  (testing "check if next frame in rolls is a spare"
    (is (spare? (concat [5 5] (repeat 18 1))))))

(deftest skip-frame-test
  (testing "skip simple frame"
    (is (= '(1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0)
           (skip-frame [2 2 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0]))))

  (testing "skip spare frame"
    (is (= '(1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0)
           (skip-frame [5 5 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0]))))

  (testing "skip strike frame"
    (is (= '(1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0)
           (skip-frame [10 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0])))))

(deftest take-next-frame-test
  (testing "take next simple frame"
    (is (= '(1 1) (take-next-frame (repeat 20 1)))))

  (testing "take next spare frame"
    (is (= '(5 5 1) (take-next-frame (concat [5 5] (repeat 18 1))))))

  (testing "take next strike frame"
    (is (= '(10 1 1) (take-next-frame (cons 10 (repeat 18 1)))))))

(deftest group-frames-test
  (testing "group frames for simple game"
    (is (= '((1 0) (1 0) (1 0) (1 0) (1 0) (1 0) (1 0) (1 0) (1 0) (1 0))
           (group-frames [1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0]))))

  (testing "group frames for one spare game"
    (is (= '((5 5 1) (1 0) (1 0) (1 0) (1 0) (1 0) (1 0) (1 0) (1 0) (1 0))
           (group-frames [5 5 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0]))))

  (testing "group frames for one strike game"
    (is (= '((10 1 0) (1 0) (1 0) (1 0) (1 0) (1 0) (1 0) (1 0) (1 0) (1 0))
           (group-frames [10 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0])))))

(deftest frame-score-test
  (testing "calc simple frame score"
    (is (= 3 (frame-score [1 2]))))

  (testing "calc spare frame score"
    (is (= 12 (frame-score [5 5 2]))))

  (testing "calc strike frame score"
    (is (= 12 (frame-score [10 1 1])))))

(deftest score-test
  (testing "zero score game"
    (is (= 0 (score (repeat 20 0)))))

  (testing "score for simple game"
    (is (= 20 (score (repeat 20 1)))))

  (testing "score for one spare game"
    (is (= 14 (score (concat [5 5 2] (repeat 17 0))))))

  (testing "score for one strike game"
    (is (= 14 (score (concat [10 1 1] (repeat 16 0))))))

  (testing "Random game"
    (is (= 145 (score [1 9 2 4 10 10 10 7 1 2 8 7 0 0 0 10 1 9])))))
