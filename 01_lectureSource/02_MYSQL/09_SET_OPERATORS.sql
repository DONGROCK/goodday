SELECT
	a.*
FROM
	tbl_menu as a
    inner join 
    (select * from tbl_menu 
    where menu_price < 9000) b on a.menu_code = b.menu_code
WHERE
	a.category_code = 10;

-- 2) IN 연산자 활용
SELECT
	menu_code,
	menu_name,
    menu_price,
    category_code,
    orderable_status
FROM
	tbl_menu
WHERE
	category_code = 10 AND
    menu_code IN (SELECT
					menu_code
				FROM
					tbl_menu
				WHERE
					menu_price < 9000);
    
    /* MINUS */
    -- MYSQL은 MINUS를 제공하지 않는다. 하지만 LEFT JOIN을 활용해서 구현하는 것은 가능하다.
    SELECT
		a.*
	FROM
		tbl_menu a
			LEFT JOIN(SELECT
							menu_code,
                            menu_name,
                            menu_price,
                            category_code,
                            orderable_status
						FROM
							tbl_menu
						WHERE
							menu_price < 9000) b ON (a.menu_code = b.menu_code)
WHERE
	a.category_code = 10  AND
     b.menu_code IS NULL;
    