/*DISTINCT*/

-- 단일 열 DISTINCT

select
		category_code
FROM
		tbl_menu
ORDER BY
		category_code;
        
select
		distinct category_code
FROM
		tbl_menu
ORDER BY
		category_code;
        -- NULL값을 포함한 열의 DISTINCT
select
		ref_category_code
FROM
		tbl_category;
        
select
		distinct ref_category_code
FROM
		tbl_category;
        
-- 열이 여러개인 DISTINCT
SELECT
		category_code,
        orderable_status
FROM
		tbl_menu;
        
SELECT DISTINCT -- distinct는 항상 맨 앞에 붙여라
		category_code,
        orderable_status
FROM
		tbl_menu;