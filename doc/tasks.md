# 今日の課題
 Spec をできるだけ沢山定義してください。
 困ったらSlack の僕  (江畑) 宛に聞いてください。

0. このフォルダ下の仕様を見て下さい。

```markdown:user.md
# user

## 構造
- user
    - name
        string 0 文字以上 30 文字以下
    - age
        integer 0 以上 120 以下
    - names
        - first name
        - last name
```

1. `src/task-cabinet/spec/<data>.clj` というファイルを作成してください。


```clojure
(ns task-cabinet-server.spec.<data>
  (:require [clojure.spec.alpha :as s]))
```
と先頭行に追加してください。

Ctrl+Alt+c -> Ctrl+Alt+e をして式を評価します。

2. example のデータを書いてください。
    できれば 正しいケースと正しくないケースの example をそこそこに書いて下さい。

```clojure
(def <example_name>_1
 {:<example_name>/<name> <value>})
```
3. spec を書いてください。

```clojure
(s/def :<example_name>/<name> 
  (s/and <expression_1> 
         <expression_2>))
```

```clojure
(s/def ::<example_name>
  (s/keys :req [:<example_name>/<name>]
          :opt [:<example_name>/<opt_name>])
)
```

# tips
tips.md は補助的な情報が含まれています。

# チームメンバーへのメモ
データ構造は、Databaseのそれと、常識に従って変えて頂いて構いません。