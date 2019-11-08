# Tips 

ref. https://clojure.org/guides/spec

## or / and

```clojure
(s/and <expression> <expression>)
(s/or <expression> <expression>)
```

## contain
ある集合のどれかの値であったほしいときには次のようにします。

```clojure
(s/def ::<key> #{<val_1> <val_2> <val_3>})
```

## stats-with
特定の文字列で始まってほしいときには次のようにします。(例: "mailto:" で始まってほしいとき)


```clojure
(clojure.string/starts-with <val> "mailto:")
```

## string の trim
文字列の先頭、背後の空白文字列を削除するには、次のようにします。

```clojure
(clojure.string/trim <val>)
```
## pos-int?

```clojure
(pos-int? -1) ;;=> false
(pos-int? 1) ;; => true
```
