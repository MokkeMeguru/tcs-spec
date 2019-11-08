# push-message
 これは webpush のためのメッセージ情報などです。

# 構造
- vapid
    - vapid-public 

        string 32 文字以上
    - vapid-private

        string 32 文字以上

- message 
    - titile

        string 4 文字以上 32 文字未満
    - body 

        string 2 文字以上 128 文字未満

- subject

    string 

    `#(clojure.string/start-swith % "mailto:")` も加えてください。

- http-protocol

    "HTTP" or "HTTPS"

    ;; `(s/def ::http-protocol #{"HTTP" "HTTPS"})` で出来ます。

- response-status

    `#{201}`


