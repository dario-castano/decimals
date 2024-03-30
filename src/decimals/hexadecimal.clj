(ns decimals.hexadecimal
  (:require [decimals.binaries :as bins]
            [clojure.string :as str]))


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

(defn build-hex 
  "Build an hexadecimal from a 4-product length binary string" 
  [binary-str result]
  (if (empty? binary-str) 
    (str/join (reverse result))
    (let [[a b c d & tail] binary-str
          group (seq [a b c d])]
      (recur tail (cons (group-to-hexa group) result)))))

(defn bin-to-hexa 
  "Converts a binary decimal number to hexadecimal"
  [binary-str]
  (let [parts (bins/split-binary binary-str)
        int-part (bins/extend-left (:integer parts))
        dec-part (bins/extend-right (:decimal parts))]
    (str 
     (build-hex int-part []) 
     "." 
     (build-hex dec-part []))))