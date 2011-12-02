;   Copyright (c) Rich Hickey. All rights reserved.
;   The use and distribution terms for this software are covered by the
;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;   which can be found in the file epl-v10.html at the root of this distribution.
;   By using this software in any fashion, you are agreeing to be bound by
;   the terms of this license.
;   You must not remove this notice, or any other, from this software.

; Author: Mike Anderson


(ns clojure.test-clojure.reduce
  (:use clojure.test))

;; utility functions
(defn multiply [x y] (* x y))

(deftest test-nil-reduce
  ; reduce on nil does nothing
  (is (= 1 (reduce multiply 1 nil)))
  
  ; reduce on empty collections does nothing
  (is (= 1 (reduce multiply 1 [])))
  (is (= 1 (reduce multiply 1 {})))
  (is (= 1 (reduce multiply 1 '())))
  (is (= 1 (reduce multiply 1 #{})))
  (is (= 1 (reduce multiply 1 (char-array 0)))))

(deftest test-map-reductions
  ;reduce over a large map
  (let [ms (zipmap (range 100) (range 100))]
    (is (= 4950 (reduce (fn [acc [k v]] (+ acc v)) 0 ms)))))

(deftest test-one-element-reductions
  ; reduce on one-element collections produces unchanged value and does not all function
  (is (= 2 (reduce multiply [2])))
  (is (= 2 (reduce multiply '(2))))
  (is (= 2 (reduce multiply #{2}))))

(deftest test-one-element-reductions-initial-value
  ; reduce on one-element collections with initial value applies function once
  (is (= 6 (reduce multiply 3 [2])))
  (is (= 6 (reduce multiply 3 '(2))))
  (is (= 6 (reduce multiply 3 #{2}))))

(deftest test-two-element-reductions
  ; reduce on two-element collections applies function once
  (is (= 6 (reduce multiply [2 3])))
  (is (= 6 (reduce multiply '(2 3))))
  (is (= 6 (reduce multiply #{2 3}))))