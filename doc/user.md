# user
opt : optional な値

## 構造
- user
    - name
    string 2 文字以上 30 文字以下
        
    - password
    string 5 文字以上 30 文字以下

    - created_at
    integer 1572566400000 より大きい (2019/11/1)
    
    - updated-at [opt]
    created-at と同じ
    
    - is-deleted [opt]
    boolean
