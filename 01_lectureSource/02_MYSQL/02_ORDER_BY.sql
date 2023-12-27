/*ORDER BY*/

-- ORDER BY 절을 사용하여 결과 집합을 하나의 열로 정렬
SELECT	
		menu_code,
        menu_name,
        menu_price
FROM
		tbl_menu
ORDER BY	-- ORDER BY 의 기본값은 오름차순이다.
		-- menu_price ASC; -- ASD 오름차순  
        menu_name;
        
SELECT
		menu_code,
        menu_name,
        menu_price
FROM
		tbl_menu
ORDER BY
		menu_price DESC; -- DESC 내림차순
        



-- ORDER BY 절을 사용해서 결고 ㅏ집합을 여러 열로 정렬
select
		menu_code,
        menu_name,
        menu_price
from
		tbl_menu
ORDER BY
		menu_price DESC,
        menu_name ASC;
        
-- ORDER BY 절을 사용하여 연산 결과로 결과 집합 정렬
SELECT
		menu_code,
        menu_price,
        menu_code * menu_price
FROM
		tbl_menu
ORDER BY
		menu_code * menu_price DESC;
        
        
        
SELECT
		menu_code,
        menu_price,
        menu_code * menu_price AS 연산결과
FROM
		tbl_menu
ORDER BY
		연산결과 DESC;
        
-- ORDER BY 절을 사용하여 사용자 지정 목록을 사용하여 데이터 정렬
-- FIELD('찾을 문자열' , 문자열1, 문자열2, 문자열3)
SELECT FIELD('A', 'A', 'B', 'C');
SELECT FIELD('C', 'A', 'B', 'C');

SELECT
		orderable_status
	FROM tbl_menu;
    
SELECT
		field(orderable_status, 'N','Y')
	FROM tbl_menu;

SElECT
		menu_name,
        orderable_status
FROM
		tbl_menu
ORDER BY FIELD(orderable_status, 'N','Y'); -- FIELD()를 ORDER BY에 적어주면 정렬의 순위를 지정한다.alter

-- NULL
-- 오름차순 시 NULL 처음으로
SELECT
		category_code,
        category_name,
        ref_category_code
        
	FROM 	tbl_category

ORDER BY 
		-- ref_category_code ASC;
        ref_category_code;
        
-- 오름차순 시 NULL 마지막으로(IS NULL ASC)
SELECT
		category_code,
        category_name,
        ref_category_code
FROM
		tbl_category
ORDER BY
		-- ref_category_code IS NULL ASC;
        ref_category_code IS NULL; -- ASC생략가능
        
-- 내림차순 시 NULL 마지막으로
SELECT
		category_code,
        category_name,
        ref_category_code
FROM
		tbl_category
ORDER BY
		ref_category_code DESC;
        
-- 내림차순 시 NULL 처음으로(IS NULL DESC)
SELECT
		category_code,
        category_name,
        ref_category_code
FROM
		tbl_category
ORDER BY
		ref_category_code IS NULL DESC; -- DESC 생략불가능
