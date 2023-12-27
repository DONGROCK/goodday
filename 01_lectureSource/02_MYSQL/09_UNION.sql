 /*SET OPERATORS*/
 
 /* UNION */
 SELECT
	menu_code,
    menu_name,
    menu_price,
    category_code,
    orderable_status
FROM
	tbl_menu
WHERE
	category_code = 10 -- 카테고리코드가 10 인거
    union  -- 두개 서로다른 값의
 SELECT
	menu_code,
    menu_name,
    menu_price,
    category_code,
    orderable_status
FROM
	tbl_menu
WHERE
	menu_price < 9000; -- 메뉴 가격이 9000원 이하인거

/* INTERSECT */
-- MYSQL은 INTERSECT를 제공하지 않는다. 하지만 INNER JOIN 또는 IN을 활용해서 구현하는 것은 가능하다.