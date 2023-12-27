/*JOIN*/

/*ALIAS : 컬럼의 별칭*/

SELECT
		menu_code AS 'menu code',  
        menu_name AS name, 
        menu_price 'menu price'
FROM
		tbl_menu
ORDER BY
		menu_price;
        
/*테이블 별칭*/
-- 테이블 별칭은 AS를 써도 되고 생략도 가능하다.
SELECT
		*
FROM
		tbl_menu AS a
ORDER BY
		category_code,
		menu_name;
        
SELECT
		a.category_code,
        a.menu_name,
        a.menu_price
FROM
		tbl_menu a
ORDER BY
		category_code,
        menu_name;
        
        
/*INNER JOIN*/ -- 교집합 느낌

-- INNER JOIN에서 INNER 키워드는 생략이 가능
SELECT
		a.menu_name,
        b.category_name
FROM
		tbl_menu a
-- INNER JOIN tbl_category b ON a.category_code = b.category_code; /*둘이 코드가 같은 애들끼리 묶어줘*/
	JOIN tbl_category b ON a.category_code = b.category_code;
		-- ON은 조인하려는 테이블의 컬럼명이 다른 경우에 보통사용이 되고
        -- USING은 조인하려는 테이블 컬럼명이 같은 경우에 선택적을 사용한다.
-- USEING
SELECT
		a.menu_name,
        b.category_name
FROM
		tbl_menu a
			inner join tbl_category b USING(category_code); -- 둘이 카테고리코드가 같은것을 묶어달라
            
-- LEFT JOIN
select
		a.category_name,
        b.menu_name
FROM
		tbl_category a 
        LEFT JOIN tbl_menu b ON a.category_code = b.category_code;

-- RIGHT JOIN
	select
		a.menu_name,
        b.category_name
FROM
		tbl_menu a 
        RIGHT JOIN tbl_category b ON a.category_code = b.category_code;
		
-- CROSS JOIN
select
		a.menu_name,
        b.category_name
FROM
		tbl_menu a
			CROSS JOIN tbl_category b; -- 두 테이블의 모든 경우의 수 값을 반환
            
-- SELF JOIN
SELECT
		a.category_name,
        b.category_name
FROM
		tbl_category a
			join tbl_category b ON a.ref_category_code = b.category_code;
-- WHERE a.ref_category_code IS NOT NULL; 널값제외하고 보여줘라.


/*
JOIN 알고리즘
NESTED LOOP JOIN
두개이상의 테이블에서 하나의 집합을 기준으로 순차적으로 상대방 Row를 결합하여 조합하는 방식.
*/
SELECT /* + NO_HASH_JOIN(a) */
		a.menu_name,
        b.category_name,
        a.category_code,
        b.category_code
FROM
		tbl_menu a
			JOIN tbl_category b ON a.category_code = b.category_code;
            
/* HASH JOIN */
SELECT /* + HASH_JOIN(a)  */
		a.menu_name,
        b.category_name
FROM
		tbl_menu a
			JOIN tbl_category b ON a.category_code = b.category_code;
            