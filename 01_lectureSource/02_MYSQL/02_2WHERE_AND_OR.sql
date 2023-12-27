/*WHERE*/
SELECT * FROM tbl_menu;

-- 1) 비교 연산자 예제와 함께 WHERE절 사용
SELECT 
		menu_name,
        menu_price,
        orderable_status
FROM
	tbl_menu
where
	orderable_status = 'N';
    
select
		menu_name,
        menu_price,
        orderable_status
from
		tbl_menu
where
		menu_price = 13000;
	
-- 같지않음( != , <> ) 연산자와 함께 where절 사용
SELECT
		menu_code,
        menu_name,
        orderable_status
FROM
		tbl_menu
WHERE
		-- orderable_status <> 'Y';
        orderable_status != 'N';
        
-- 대소 비교 연산자와 함께 where 절 사용
SELECT
		menu_code,
        menu_name,
        menu_price
	FROM
		tbl_menu
        
WHERE
		menu_price > 20000;
        
-- 2) AND 연산자와 함께 WHERE절 사용
SELECT 1 AND 1;
SELECT 1 AND 0, 0 AND 1, 0 AND 0 , 0 AND NULL;

SELECT 
		menu_name,
        menu_price,
        category_code,
        orderable_status
FROM
		tbl_menu
WHERE
		orderable_status = 'Y' AND  -- ㅁㅁ이면서 
        category_code = 10; -- ㅁㅁ인
        
SELECT
		menu_code,
        menu_name,
        menu_price,
        category_code,
        orderable_status
FROM
		tbl_menu
WHERE
		menu_price > 5000 AND
        category_code = 10 ;
        
-- 3) OR 연산자의 함께 WHERE절 사용
SELECT 1 OR 1;
select 1 or 0;
select 0 or 1;
select 0 or 0;
select 555 or 212;
select 1 or null;
select 0 or null;
select null or null;
SELECT
		menu_name,
        menu_price,
        category_code,
        orderable_status
FROM
		tbl_menu
WHERE
		orderable_status= 'Y' OR
        category_code = 10
        
ORDER BY
		category_code;
        
SELECT
		menu_code,
        menu_name,
        menu_price,
        category_code,
        orderable_status
FROM
		tbl_menu
WHERE
		menu_price > 5000 OR
        category_code = 10;
        
-- 우선순위
SELECT 1 OR 0 AND 0;
SELECT (1 OR 0) AND 0;

SELECT
		menu_code,
        menu_name,
        menu_price,
        category_code,
        orderable_status
FROM
		tbl_menu
WHERE
		category_code = 4 or
        menu_price = 9000 AND
        menu_code > 10;

-- 4) BETWEEN 연산자 예제와 함께 WHERE절 사용
select
		menu_name,
        menu_price,
        category_code
from
		tbl_menu
where	
		menu_price >= 10000 AND
        menu_price <= 25000
ORDER BY -- ORDERBY의 기본값 오름차순.
		menu_price;
        
select
		menu_name,
        menu_price,
        category_code
from
		tbl_menu
where	
		menu_price BETWEEN 10000 AND 25000
ORDER BY
		menu_price;
        
-- 부정표현
select
		menu_name,
        menu_price,
        category_code
from
		tbl_menu
where	
		menu_price NOT BETWEEN 10000 AND 25000
ORDER BY
		menu_price;
        
-- LIKE 연산자 예제와 함께 Mysql WHERE절 사용
SELECT
		menu_name,
		menu_price
FROM
		tbl_menu
WHERE
		menu_name LIKE '마늘'
       /* 
       '%밥%' 이거는 밥이라는 문자열이 들어간다면 호출 
       '%밥' 밥으로 끝나면 호출  
       '밥%' 밥으로 시작되면 
       */
order by
	menu_name;

select
		menu_name,
        menu_price
FROM
		tbl_menu
WHERE
		menu_price LIKE '%0000'
order by
		menu_name;

select
		menu_code,
        menu_name,
        menu_price,
        category_code,
        orderable_status
FROM
		tbl_menu
WHERE
		menu_price >5000 AND
        category_code = 10 AND
        menu_name LIKE'%갈치%' 
ORDER BY
		menu_name;
        
-- 부정표현
SELECT
		menu_name,
        menu_price
FROM
		tbl_menu
WHERE
		menu_name NOT LIKE '%마늘%' AND
        menu_name NOT LIKE '%피자%'
order by
		menu_name;
		
-- 6) IN 연산자 예제와 함께 WHERE 절 사용
SELECT
		menu_name,
        category_code
FROM
		tbl_menu
WHERE
		category_code = 4 or
        category_code = 5 or
        category_code = 6; 
        
SELECT
		menu_name,
        category_code
FROM
		tbl_menu
WHERE
		category_code IN (4,5,6); -- IN(ㅁ,ㅁ,ㅁ) ㅁor ㅁor ㅁ 와 같음
        
-- 부정표현
SELECT
		menu_name,
        category_code
FROM
		tbl_menu
WHERE
		category_code NOT IN (4,5,6); -- 카테고리코드가 4,5,6 이아닌
        
-- 7) IS NULL 연산자와 함께 WHERE 절 사용
SELECT
		category_code,
        category_name,
        ref_category_code
FROM
		tbl_category
WHERE
		ref_category_code IS NULL;
        
-- 부정표현
SELECT
		category_code,
        category_name,
        ref_category_code
FROM
		tbl_category
WHERE
		ref_category_code IS NOT NULL;
