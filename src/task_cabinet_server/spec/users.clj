(ns task-cabinet-server.spec.users
  (:require [clojure.spec.alpha :as s]))

;;;;;; regex ;;;;;;
(def user-name-regex
  ;; This SQL escape is excessive. because I use parametrized_SQL_statement
  ;; https://rosettacode.org/wiki/Parametrized_SQL_statement
  ;; this escape is because, To found a man who want to do SQL injection.
  ;; We will report the request which was failed this assertion.
  ;;
  ;; condition
  ;; >>> - be not contain & @ ^ ( ) [ ] { } . ? + * | \ ' "
  ;; #"[0-9a-zA-Zぁ-んァ-ヶ一-龠々ー]*$"
  #"^[^&@\^\(\)\[\]\{\}.\?\+\*\|\\\'\"]*$")

(def password-regex
  ;; condition
  ;; >>> - less 1 number
  ;; >>> - less 1 small alphabet
  ;; >>> - less 1 big alphabet
  #"^(?=.*\d+)(?=.*[a-z])(?=.*[A-Z])[A-Za-z\d+]*$")


(def num-big-little-char
  (map char (concat
              (range 97 123)
              (range 65 91)
              (range 48 58))))

(def num-big-little-char-len
  (count num-big-little-char))

(defn random-char []
  (nth num-big-little-char (rand num-big-little-char-len)))

(defn random-token
  ([]
   (random-token 127))
  ([length]

   (apply str (take length (repeatedly random-char)))))





;; get user-tokens
;; user id
;; tokens
;; apply and map = generated token tokens
