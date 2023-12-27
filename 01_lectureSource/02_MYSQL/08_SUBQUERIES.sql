/* SUBQUERY(서브쿼리) */
-- 서브쿼리 : 쿼리문 안에서 사용된 쿼리문
-- 민트 미역국의 카테고리 번호조회
SELECT
	category_code
    
FROM
	tbl_menu
WHERE
	menu_name = "민트미역국"; -- 4

-- 메인쿼리
-- 다중열 결과 조회
SELECT
	menu_code,
    menu_name,
    menu_price,
    category_code,
    orderable_status
FROM
	tbl_menu;
    
-- 민트미역국과 같은 카테고리 메뉴를 조회하고 싶다.

SELECT
	menu_code,
    menu_name,
    menu_price,
    category_code,
    orderable_status
FROM
	tbl_menu
WHERE
	category_code = (SELECT
						category_code
					FROM
						tbl_menu
					WHERE
						menu_name = '민트미역국');


-- 메뉴테이블에 있는 메뉴가 각각 몇개인지 구하고싶다.
SELECT
	COUNT(*) as count
FROM
	tbl_menu
group by
	category_code;
-- 가장 많은 메뉴가 포함된 카테고리 조회    
-- FROM절에 쓰인 서브쿼리(derived table, 파생테이블)는 반드시 자신의 별칭이 있어야한다.
SELECT
		MAX(count)
FROM
	(SELECT
		COUNT(*) as 'count'
	FROM
		tbl_menu
	group by
		category_code) as countmenu;
        
SELECT * FROM tbl_menu;
SELECT * FROM tbl_category; 

SELECT
	*
FROM
	tbl_menu a
join tbl_category b ON a.category_code = b.category_code;

/* 상관 서브쿼리 */
-- 메인쿼리가 서브쿼리의 결과에 영향을 주는 경우 상관 서브쿼리 라고 한다.
-- 서브쿼리
SELECT
	AVG(menu_price)
FROM
	tbl_menu
WHERE
	category_code = 4;-- 카테고리 4번의 메뉴 평균 값 얼마냐

-- 카테고리별 평균 가격보다 높은 가격의 메뉴 조회
SELECT
	a.menu_code,
    a.menu_name,
    a.menu_price,
    a.category_code,
    a.orderable_status
FROM
	tbl_menu a
WHERE
	menu_price > (SELECT
					avg(menu_price)
				FROM 
					tbl_menu
                where 
					category_code = a.category_code);

/*EXISTS*/
-- 조회 결과 있을 때 true 아니면 false
SELECT
	category_name
FROM
	tbl_category a
WHERE
	EXISTS(
		select
			1 -- true
		FROM
			tbl_menu b
		WHERE
			b.category_code = a.category_code
    );
    
    -- 파생 테이블과 비슷한 개념이며 코드의 가독성과 재사용성을 위해 파생 테이플 대신 사용하게 된다.
    -- FROM절에서만 사용이 된다.(JOIN 일시 JOIN 구문에서도 가능)
WITH menucate as(
SELECT
	menu_name,
    category_name
FROM
	tbl_menu a
join tbl_category b ON a.category_code = b.category_code)
SELECT
	*
from
	menucate
order by
	menu_name;