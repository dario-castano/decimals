(ns decimals.binaries
  (:require [clojure.string :as str]))

(defn split-decimal
  "Converts a float to a map of integer and decimal part"
  [n]
  (let [integer-part (int n)
        decimal-part (- n integer-part)]
    {:integer integer-part :decimal decimal-part}))


(defn int-to-binary
  "Converts an integer value to a binary one"
  [n binarr]
  (println (str "Int N: " n " cociente: " (quot n 2) " resto: " (rem n 2)))
  (if (or (= n 1) (= n 0))
    (cons n binarr)
    (recur (quot n 2) (cons (rem n 2) binarr))))


(defn fraction-to-binary
  "Converts a decimal value (zero dot) form to a binary"
  [n binarr]
  (if (or (== n 1.0) (== n 0.0))
    (reverse binarr)
    (let [split (split-decimal (* n 2))]
      (println (str "Frac N: " n " " split))
      (recur (:decimal split) (cons (:integer split) binarr)))))

(defn decimal-to-binary
  "Converts a full decimal value to a binary"
  [n]
  (let [splitted (split-decimal n)
        intval (:integer splitted)
        decval (:decimal splitted)]
    (str
     (reduce str (int-to-binary intval []))
     "."
     (reduce str (fraction-to-binary decval [])))))

(defn split-binary 
  "Splits a string representation of a binary number" 
  [binary]
  (let [splitted (str/split binary #"\.")]
    {:integer (first splitted) :decimal (second splitted) }))

(defn extend-left 
  "Fill zeros to the left to complete spaces in products of 4" 
  [binary-str]
  (let [len (count binary-str)]
    (if (= (mod len 4) 0)
      binary-str 
      (recur (str/join "" (flatten ["0" binary-str]))))))

(defn extend-right
  "Fill zeros to the right to complete spaces in products of 4" 
  [binary-str]
  (let [len (count binary-str)]
    (if (= (mod len 4) 0)
      binary-str
      (recur (str/join "" (flatten [(seq binary-str) \0]))))))