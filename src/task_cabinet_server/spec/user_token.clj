(ns task-cabinet-server.spec.user-token
  (:require [clojure.spec.alpha :as s]))

(s/def :x/name string?)
(s/def ::x (s/keys :req-un [:x/name]))

(s/conform ::x {:name "hoge"})
