(ns decimals.core 
  (:gen-class))

(defn split-decimal 
  "Converts a float to a map of integer and decimal part" 
  [n]
  (let [integer-part (int n)
        decimal-part (- n integer-part)]
    {:integer integer-part :decimal decimal-part}))


(defn int-to-binary
  "Converts an integer value to a binary one"
  [n binarr]
  (if (= n 1)
    (cons n binarr)
    (recur (quot n 2) (cons (rem n 2) binarr))))


(defn fraction-to-binary
  "Converts a decimal value (zero dot) form to a binary"
  [n binarr]
  (if (or (== n 1.0) (== n 0.0))   
    (reverse binarr)
    (let [split (split-decimal (* n 2))]
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

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (str "Nivel de bateria 1: " (decimal-to-binary 3.752)))
  (println (str "Nivel de bateria 2: " (decimal-to-binary 12.488)))
  (println (str "Nivel de bateria 3: " (decimal-to-binary 114.915)))
  )