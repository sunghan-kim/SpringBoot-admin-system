-- java test 코드를 통한 데이터 생성

-- test.java.com.example.study.sample 패키지 하위에 있는 자바 파일 각각 실행

-- 순서 : CategorySample -> PartnerSample -> ItemSample -> UserSample -> OrderDetailsample

-- 1. CategorySample : createSample() 메서드 실행
SELECT *
  FROM CATEGORY
;

-- 2. PartnerSample : sampleCreate() 메서드 실행
SELECT *
  FROM PARTNER
;

-- 3. ItemSample : createAll() 메서드 실행
SELECT *
  FROM ITEM
;

-- 4. UserSample : sampleCreate() 메서드 실행
SELECT *
  FROM USER
;

-- 5. OrderDetailsample : createOrder() 메서드 실행
SELECT *
  FROM ORDER_DETAIL
;

SELECT *
  FROM ORDER_GROUP
;