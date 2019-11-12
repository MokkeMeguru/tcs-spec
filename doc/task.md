# task
opt : opt : optional な値

## 構造
- task  
    - id  
    integer serial primary なキー  
    タスクについて一意  
    TODO: uuid との比較検討
    
    - name   
    string 1 文字以上 63 文字未満
    空白文字のみは不可
    
    - description [opt]  
    タスクの詳細情報  
    string 1 文字以上 511 文字未満  
    空白文字のみは不可
    
    - category [opt]  
    タスクのカテゴリ情報  
    string 1 文字以上 255 文字未満  
    TODO: スラッシュ区切りで階層構造を作る？

    - deadline  [opt]  
    現在時刻より大きい(global unix time)  
    クライアント<-> サーバでは global unix time (integer)  
    TODO: 本当にオプショナル？
    
    - estimate [opt]  
    integer 0 以上  
    TODO: 本当にオプショナル？
    
    - user_id
    integer 1 以上  
    ref. [./user.md](./user.md)
    
    - finished_at [opt]
    created\_at よりも大きい TIMESTAMP  
    サーバサイドで完結される値  
    
    - created_at
    PostgreSQL の current\_timestamp を利用 (外部からの書き込み不可)  
    サーバサイドで完結される値  
    
    - updated_at [opt]
    created\_at よりも大きい TIMESTAMP  
    サーバサイドで完結される値  
    
    - is_deleted
    削除 (完了ではない)  
    boolean  
