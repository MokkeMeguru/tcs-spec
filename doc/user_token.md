# user-token
opt : optional な値


## 構造
- user-token  
  - id  
  integer serial primary な キー
  - user-id  
  ref. [./user.md](./user.md)
  - token  
  127 文字のトークン   
  英字大文字小文字＋数字で構成される  
  サーバから与えられる値
  - created_at  
  PostgreSQL の current\_timestamp を利用 (外部からの書き込み不可)  
  サーバサイドで完結される値  
  TODO: あるいはログイン情報としてユーザに知らせる可能性がある？

## 仕様についての補足
user-token は 1 ログインにつき一つ生成される。ログアウトで delete され、created_at から一定時間で無効化される。(TODO: スケジューリングによるによる削除)

この性質上、複数端末のログインが有効になっている。

DONE: すべての端末からのログアウト(endpoint)  
DONE: すべての端末からのログアウト(db)  
TODO: すべての端末からのログアウト(service)
