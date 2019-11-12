# users
opt : optional な値
特殊文字 :  (& @ ^ ( ) [ ] { } . ? + * | \ ' ")

## 構造
- user  
    - id  
    integer serial primary なキー  
    ユーザについて一意  
    TODO: uuid との比較検討
    
    - name  
    string 2 文字以上 30 文字以下  
    
    - password  
    string 5 文字以上 30 文字以下  

    - email  
    email の形式であること **UNIQUE**

    - created_at  
    PostgreSQL の current\_timestamp を利用 (外部からの書き込み不可)
    
    - updated_at [opt]  
    created\_at よりも大きい TIMESTAMP  
    サーバサイドで完結される値  
    
    - is-deleted [opt]  
    boolean  
    

## option
### user/name の制限
    | タイプ       | 許可 |
    |--------------|------|
    | 文頭文末空白 | 不可 |
    | 文中空白     | 可   |
    | 日本語文字等 | 可   |
    | 特殊文字     | 不可 |
    
### user/password の制限
    | タイプ     | 制限    |
    |            |         |
    |------------|---------|
    | 大文字英字 | 1字以上 |
    | 小文字英字 | 1字以上 |
    | 数字       | 1字以上 |
    
### user/email の制限
regex:  <pre>"^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$"</pre>
