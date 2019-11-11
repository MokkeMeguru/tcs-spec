# user
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
    **password と合わせて** 一意な値
    
    | タイプ       | 許可 |
    |--------------|------|
    | 文頭文末空白 | 不可 |
    | 文中空白     | 可   |
    | 日本語文字等 | 可   |
    | 特殊文字     | 不可 |
    
    - password  
    string 5 文字以上 30 文字以下  
    
    | 大文字英字 | 1字以上 |
    | 小文字英字 | 1字以上 |
    | 数字       | 1字以上 |
    - email
    email の形式であること
    regex:  <pre>"^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$"</pre>

    - created_at  
    integer 1572566400000 より大きい (2019/11/1)
    
    - updated_at [opt]  
    created-at と同じ
    
    - is-deleted [opt]  
    boolean
    
