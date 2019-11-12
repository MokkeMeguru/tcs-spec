# user_device
 これは webpush のためのデバイス情報です。
## 構造
- user_device
    - id  
    integer serial primary なキー  

    - user_id
    ref. [./users.md](./users.md)
    
    - created_at  
    PostgreSQL の current\_timestamp を利用 (外部からの書き込み不可)  
    サーバサイドで完結される値  
    - endpoint  

        string 100 文字以上 512 文字未満

        例: "https://fcm.googleapis.com/fcm/send/f8ZrPSJxQVk:APA91bF2DMtsF8Wyhogehogehoge0gAU5b2GcdUOzO1eR8jyX3UbpfmYC-oFqZE0VBr658gJ0MvMBUKoBmp3h00VWO2a2E2dBH8aD3QcbYAgrEaJN914jPPwWCFKjzCGjMe8PNbarbarU"
        
    - keys
        - auth

            string 20 文字以上 256 文字未満

            例： "cfoobarjl529A_X-bw"

        - p256dh

            string 20 文字以上 256 文字未満

            例: "BPT8zHapyg8fbcGJqzNlKXj0gTdSmKOcVn4V7rwaceFwf2h_ZXqiQtLHya7KeMPd3YXTrPoSt39AqtCTrzWX45o"
## endpoint の whitelist
"android.googleapis.com"
"fcm.googleapis.com"
"updates.push.services.mozilla.com"
"updates-autopush.stage.mozaws.net"
"updates-autopush.dev.mozaws.net"
".notify.windows.com"
