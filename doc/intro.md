# Clojure Tutorial
Clojure は Lisp で書けるJavaです。

Lispとは逆ポーランド記法と "()" が特徴の(純粋ではない)関数型言語です。

純粋ではない、というのは、オブジェクト指向を柔軟に取り入れてきた言語であるというLispの背景によります。

最も有名なLispであるかもしれない Common lisp では、 CLOS (Common Lisp Object System) というオブジェクト指向についての規約があります。

それはそれとして、Clojureではオブジェクトを作ることはあまりしません。オブジェクトの殆どは辞書構造で代用します。

例えば、人間というオブジェクトのインスタンスはClojureでは次のように辞書構造で表されます。

```clojure
(def people-instance
  {::name "meguru"
   ::age 21
   ::weight 46
   ::height 172})
```

この辞書構造を生成したければ、例えば関数を用いる方法が考えられます。

```clojure
(defn gen-people [name age weight height]
  {:name name
   :age age
   :weight weight
   :height height})
```

ここでいわゆる”一般の”オブジェクト指向に比べてClojureが劣っていると思われる点が思いつくでしょう。

それは制約がない、ということです。例えば age に数字ではなく文字を入れることが出来てしまいますし、name に空の文字列を入れることが出来てしまいます。これは嬉しくありません。

そこでClojureが提案する手法の一つは、 **Spec** という手法です。

# Clojure Spec でデータ形式を定義する

それでは Spec を用いて先程の構造に対してデータ形式を定義します。

```clojure
(ns user
 (:require [clojure.spec.alpha :as s]))

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
```


"s/def" というのは spec を定義する、という意味です。
`(s/def :people/name string?)` というのは、`string?` という式でデータ形式をチェックする spec `:people/name` を定義する、という意味です。

なので、`"Meguru"` は `:people/name` としては正しいですが、 `100` は数値ですから正しくない、ということになります。

`(s/conform <spec> <data>)` で spec を通るかどうかを評価できます。(上の例をやってみてください) 

`(s/explain <spec> <data>)` で spec を行った際の結果についての詳細情報が得られます。

# VSCode での使い方
- docker-compose.yml を開いて docker remote を立ち上げてください。
- 適当なファイルを開いて 下のバーの nREPL をクリックしてください。
- 選択肢に start project のようなものが出てくるので、それをクリックしてください。
- ファイル `.clj` を開いて、式 `(ns ...)` or `(def...)` or `(s/def ...)`　を書いたら Ctrl + Alt + c -> Ctrl + Alt + e で評価します。式を書いたら **必ず** 評価してください。

# 次に見るもの

tasks.md へ進んでください。
