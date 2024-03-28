(ns decimals.core
  (:require [decimals.binaries :as bins])
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (str "Nivel de bateria 1: " (bins/decimal-to-binary 3.752)))
  (println (str "Nivel de bateria 2: " (bins/decimal-to-binary 12.488)))
  (println (str "Nivel de bateria 3: " (bins/decimal-to-binary 114.915)))
  )