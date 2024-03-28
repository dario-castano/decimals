(ns decimals.hexadecimal
  (:require [decimals.binaries :as bins]))


(defn group-to-hexa 
  "Returns a hexadecimal code from a group of 4 binaries" 
  [word]
  (let [hexa ["0" "1" "2" "3"
              "4" "5" "6" "7" 
              "8" "9" "A" "B" 
              "C" "D" "E" "F"]
        group [8 4 2 1]
        values (map int (seq word))
        bins (map #(- % 48) values)
        code (reduce + (map (fn [x y] (* x y)) bins group))]
    (get hexa code)))