/*GROUP BY*/

-- 메뉴가 존재하는 카테고리 그룹 조회
select
		category_code
FROM
		tbl_menu
group by category_code;

-- COUNT 함수 활용
-- 카테고리별 메뉴 개수
SELECT
		 category_code,
        COUNT(*)
FROM
		tbl_menu
GROUP BY category_code;  -- 카운트의 기준을 잡아줌

-- SUM함수 활용
-- 카테고리별 메뉴 가격평균
select
		category_code,
        SUM(menu_price)
FROM
		tbl_menu
group by category_code;

-- AVG함수 활용
-- 카테고리별 메뉴 가격 평균
SELECT
		category_code,
        AVG(menu_price)
FROM
		tbl_menu
group by category_code;

-- 2개 이상의 그룹 생성
select
		menu_price,
        category_code
FROM
		tbl_menu
GROUP BY
		menu_price,
        category_code;
        
/* HAVING */
SELECT
		category_code
FROM
		tbl_menu
group by category_code
HAVING category_code BETWEEN 5 and 8;

/* ROLLUP */
-- 컬럼 한개를 활용한 ROLLUP(카테고리별 총합)
SELECT
		category_code,
        SUM(menu_price)
FROM
		tbl_menu
GROUP BY
		category_code
WITH ROLLUP;
-- 컬럼 두개를 활용한 ROLLUP(같은 메뉴 가격별 총합 및 해당 메뉴 가격별 같은 카테고리의 총합)
-- ROLLUP을 통해 먼저 나온 컬럼의 총합을 구하고 이후 나오는 컬럼의 총합도 구히는 방식.
SELECT
		menu_price,
        category_code,
        SUM(menu_price)
FROM
		tbl_menu
group by
		menu_price,
        category_code
with rollup;
        

        