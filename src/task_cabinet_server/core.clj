(ns task-cabinet-server.core
  (:gen-class)
  (:require [clojure.spec.alpha :as s]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))


(s/def :people/name
  (s/and string?
         #(> 30 (count %) 0)))

(s/def :people/age
  pos-int?)

(s/def :people/weight
  (s/and integer?
         #(> 200 % 0)))

(s/def :people/height
  (s/and integer?
         #(> 250 % 50)))

(s/def :people/nickname
  (s/and string?
         #(> 30 (count %) 0)))

(s/def ::people
  (s/keys :req [:people/name
                :people/age
                :people/weight
                :people/height]
          :opt [:people/nickname]))

(def people1
  {:people/name "Meguru"
   :people/age 21
   :people/weight 46
   :people/height 171})

(def people2
  {:people/name "Emacs"
   :people/age 20
   :people/weight 51
   :people/height "unknown"})

(def people3
  {:people/name "Santa Claus"
   :people/age 1000
   :people/weight 100
   :people/height 192
   :people/nickname "Santa"})


(s/conform ::people people1) 
;; => {:people/age 21, :people/height 171, :people/name "Meguru", :people/weight 46}

(s/conform ::people people2)
;; clojure.spec.alpha/invalid

(s/explain ::people people2)
;; "unknown" - failed: integer? in: [:people/height] at: [:people/height] spec: :people/height

(s/conform ::people people3)
;; => {:people/age 1000, :people/height 192, 
;;     :people/name "Santa Claus", :people/nickname "Santa", :people/weight 100}
