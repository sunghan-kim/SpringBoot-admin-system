-- sql 이용 페이징 처리

# 0 -> 1 button -> 0 page
SELECT *
  FROM USER
 WHERE 1 = 1
   LIMIT 0, 10 -- 0번째부터 10개
;

# 10 -> 2 button -> 1 page
SELECT *
  FROM USER
 WHERE 1 = 1
   LIMIT 10, 10 -- 10번째부터 10개
;

# 20 -> 3 button -> 2 page
SELECT *
  FROM USER
 WHERE 1 = 1
   LIMIT 20, 10 -- 20번째부터 10개
;