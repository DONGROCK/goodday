/*VIEW*/
-- select 쿼리문을 저장한 객체로 가상테이블이라고 불린다.
-- 실질적인 데이터를 물리적으로 저장하고 있지 않다.
-- 테이블을 사용하는 것과 동일하게 사용할 수 있다.
select * from tbl_menu;

-- view 생성
create view hansik as
select menu_code, menu_name, menu_price, category_code, orderable_status
from tbl_menu
where category_code = 4;
select * from menudb.hansik;

-- 생성된 view 조회
select * from hansik;
-- 베이스 테이블의 정보가 변경되면 view의 결과도 같이 변경된다.
insert into tbl_menu values(null, '식혜냉면', 5500, 4, 'Y');

-- view 를 통한 DML
-- 1) view를 통한 insert(view는 auto_increment가 없으므로 pk칼럼의 값을 지정해 주어야 한다.)
insert into hansik values(null, '식혜냉면', 5500, 4, 'Y');
insert into hansik values(99, '송편떡국',5000,4,'Y');

-- 2) view를 통한 update
update hansik set menu_name = '버터맛국밥', menu_price = 5700 where menu_code = 99;
select * from hansik;
select * from tbl_menu;

-- 3) view를 통한 delete
delete from hansik where menu_code = 32;
select * from hansik;
select * from tbl_menu;

-- 사용된 subquery에 따라 dml명령어로 조작이 불가능한 경우
-- 1) 뷰 정의에 포함되지 않은 컬럼을 조작하는 경우 (카테고리 4?)
-- 2) 뷰에 포함되지 않은 컬럼 중에 베이스가 되는 컬럼이 not null 제약조건이 지정된 경우
-- 3) 산술표현식이 정의된 경우
-- 4) join을 이용해 여러 테이블을 연결한 경우
-- 5) distinct 를 포함한 경우 
-- 6) 그룹함수 group by절을 포함한 경우

-- view 삭제
drop view hansik; -- 테이블 드랍하듯 하면 된다. 

create view hansik as
select menu_name as '메뉴명', truncate(menu_price / 1000, 1) as '가격(천원)',
category_name as '카테고리명'
from
	tbl_menu a
join tbl_category b on a.category_code = b.category_code
where b.category_name = '한식';

insert into hansik values('김밥', 8.5, '한식');
select * from hansik;

-- or replace 옵션
-- 테이블을 drop 하지 않고 기존의 view