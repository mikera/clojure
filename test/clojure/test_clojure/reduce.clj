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
(defn times2 [x] (* 2 x))

(deftest test-nil-reduce
  ; reduce on nil does nothing
  (is (= 1 (reduce times2 1 nil)))
  
  ; reduce on empty collections do nothing
  (is (= 1 (reduce times2 1 [])))
  (is (= 1 (reduce times2 1 {})))
  (is (= 1 (reduce times2 1 '())))
  (is (= 1 (reduce times2 1 #{}))))

(deftest test-map-reductions
  ;reduce over a large map
  (let [ms (zipmap (range 100) (range 100))]
    (is (= 4950 (reduce (fn [acc [k v]] (+ acc v)) 0 ms)))))