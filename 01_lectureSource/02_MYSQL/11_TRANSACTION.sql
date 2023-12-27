/*TRANSACTION*/
-- db에서 한번에 수행되는 작업의 단위
-- 맨마지막 커밋 시점으로 간다.
-- mysql은 기본적으로 commit이 자동으로 되므로 수동을 조절하고 싶다면 autocommit설정을 바꿔 주어여한다.
-- autocommit 활성화
SET autocommit = 1;
-- 또는
SET autocommit = on;

-- autocommit 비활성화
SET autocommit = 0;
-- 또는
SET autocommit = OFF;

START TRANSACTION;

select * FROM tbl_menu;
INSERT INTO tbl_menu values (null, '멜론빵',8500, 4, 'Y');

UPDATE tbl_menu SET menu_name = '카레바게트' WHERE menu_code = 1;
DELETE FROM tbl_menu WHERE menu_code = 7;

ROLLBACK;

