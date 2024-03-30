(ns decimals.core
  (:require [decimals.binaries :as bins]
            [decimals.hexadecimal :as hex])
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [nivel1-bin (bins/decimal-to-binary 3.752)
        nivel2-bin (bins/decimal-to-binary 12.488)
        nivel3-bin (bins/decimal-to-binary 114.915)
        nivel1-hex (hex/bin-to-hexa nivel1-bin)
        nivel2-hex (hex/bin-to-hexa nivel2-bin)
        nivel3-hex (hex/bin-to-hexa nivel3-bin)]
   
  (println (str "Nivel de bateria 1: " "\n" nivel1-hex "\n" nivel1-bin))
  (println (str "Nivel de bateria 2: " "\n" nivel2-hex "\n" nivel2-bin))
  (println (str "Nivel de bateria 3: " "\n" nivel3-hex "\n" nivel3-bin))))