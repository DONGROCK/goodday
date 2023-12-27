/* DML */

-- INSERT, UPDATE, DELETE, SELECT (DQL)
-- 데이터 조작언어, 테이블에 값을 삽입하거나, 수정하거나, 삭제하거나, 조회하는 언어

/* INSERT */
-- 새로운 행을 추가하는 구문
-- 테이블의 수가 증가한다.
INSERT INTO tbl_menu VALUES (null, '바나나맛해장국', 8500, 4, 'Y');  -- 테이블메뉴에 추가할거다 values(순서대로 넣어야할것 삽입)

/* NULL 허용 가능한(NULLABLE)컬럼이나 AUTO_INCREMENT 가 있는 컬럼은 제외하고
	INSERT하고 싶은 데이터 컬럼을 지정해서 INSERT 가능하다.*/
INSERT INTO tbl_menu(menu_name, menu_price, category_code, orderable_status)
values('초콜릿죽', 6500, 7, 'Y'); -- menu_code는 AUTO_INCREMENT라 제외하고 값을 넣어도 자동으로 삽입이 된다.

-- 컬럼을 명시하면 INSERT 시 데이터의 순서를 바꾸는 것도 가능하다.
INSERT INTO tbl_menu(orderable_status, menu_price, menu_name, category_code)
VALUES('Y', 5500, '파인애플전골' , 4);

-- MULTI INSERT
INSERT INTO
	tbl_menu
VALUES
	(null, '참치맛아이스크림', 1700, 12, 'Y'),
	(null, '멸치맛아이스크림', 1500, 11, 'Y'),
	(null, '소시지맛커피', 25000, 8, 'Y');
-- INSERTO INTO 테이블명    VALUES(값, 값, 값,.)

/* UPDATE */
-- 테이블에 기록된 컬럼의 값을 수정하는 구문이다.
-- 테이블의 전체 행 갯수는 변화가 없다.ALTER
SELECT
	menu_code,
	category_code
FROM
	tbl_menu
WHERE
	menu_name = '파인애플전골';
    
UPDATE tbl_menu
SET 
category_code = 7,
menu_name = '까스활명수비빔밥'
WHERE
	menu_code = 24;


select * from  tbl_menu WHERE menu_code = 24;
select * from  tbl_menu;
-- SUBQUERY를 활용할 수 있따.
-- 다만 Mysql은 Oracle과 달리 update나 delete시 자기 자신 테이블의 데이터를 사용할 시 1093에러가 발생한다.
UPDATE tbl_menu
SET
	category_code = 6
WHERE
	menu_code = (SELECT
					menu_code
				FROM
					tbl_menu
				WHERE
						menu_name = '파인애플전골');
		-- 이때 SUBQUERY를 하나 더 사용하여 임시테이블로 사용하게 되면 해결할 수 있따.
UPDATE tbl_menu
SET
	category_code = 6
WHERE
	menu_code = (SELECT
					menu_code
				FROM
					(SELECT
						menu_code
					FROM
						tbl_menu
					WHERE
						menu_name = '까스활명수비빔밥'
                        ) tmp
                    );

/*DELETE*/
-- 테이블의 행을 삭제하는 구문이다.
-- 테이블의 행의 갯수가 줄어든다.
select
	*
FROM
	tbl_menu;

-- LIMIT를 활용한 행 삭제(offset 지정은 안됨)
DELETE FROM
		tbl_menu
ORDER BY
	menu_price
LIMIT 2;

-- WHERE절을 활용한 단일 행 삭제
delete
FROM
	tbl_menu
WHERE
	menu_code = 27;
    
-- 테이블 전체 행 삭제
DELETE FROM
		tbl_menu;
rollback;

/* REPLACE */
-- insert 시 primary key (기본키) 또는 UNIQUE KEY가 충돌이 발생할 수 있다면
-- REPLACE를 통해 중복된 데이터를 덮어쓸 수 있다.
SELECT * FROM
	tbl_menu
WHERE
	menu_code = 17;
    
INSERT INTO tbl_menu VALUES (17,'까나리소주', 5000, 10, 'Y'); -- 기본키는 중복이 될수 없다.
REPLACE INTO tbl_menu VALUES (17,'까나리소주', 5000, 10, 'Y'); --  replace 이거는 중복이 되지않게 원래있던 값에 새로운 값을 덮어 씌우는 것.
REPLACE tbl_menu VALUES (17,'까나리소주', 5000, 10, 'Y'); -- replace는 INTO가 없어도 가능