select * from tbl_category;
select * from tbl_menu;
select * from tbl_order;
select * from tbl_order_menu;
select * from tbl_payment;
select * from tbl_payment_order;


/*SELECT문을 사용해서 단일 열 데이터 검색*/
SELECT menu_name FROM tbl_menu;

/*SELECT문을 사용해서 여러 열의 데이터 검색*/
SELECT
		menu_code,
        menu_name,
        menu_price
  FROM	
		tbl_menu;
        
        /*SELECT 문을 사용하여 모든 열에서 데이터 검색*/
SELECT 
		menu_code, -- 넘버코드
        menu_name, -- 메뉴이름
        menu_price,
        category_code,
        orderable_status
  FROM 
		tbl_menu;
        
        
SELECT 
		*
  FROM 
		tbl_menu;
        
-- 연산자
SELECT 6 + 3;
SELECT 6 * 3;
SELECT 6 / 3;
SELECT 6 % 3;

-- 내장함수
SELECT NOW();
SELECT concat("리오넬 " , '메', '시');

-- 컬럼별칭
SELECT CONCAT('칼.', '든' , "강도")AS name; -- 가상의 컬럼상태 name
SELECT CONCAT('칼.', '든' , "강도")AS 'full name'; -- 풀네임