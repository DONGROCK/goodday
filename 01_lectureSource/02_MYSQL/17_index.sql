/*index*/

create table phone(
	phone_code INT PRIMARY KEY,
	phone_name VARCHAR(100),
	phone_price DECIMAL(10, 2)
)/*engine = innodb 있으나 없으나 상관없*/;

insert into phone(phone_code, phone_name, phone_price)
values(1, 'galaxyS23', 1200000),
		(2, 'iPhone14proMax', 1433000),
		(3, 'galaxyfold3', 1730000);
        
select * from phone;
select * from phone where phone_name = 'galaxyS23';
explain select * from phone where phone_name = 'galaxyS23';

-- 인덱스 생성
create index idx_name
on phone(phone_name);

-- 인덱스 확인
show index from phone;

-- 2개 이상의 컬럼을 한번에 하나의 인덱스로 설정해서 생성할 수 있다.
-- 복합인덱스 생성
create index idx_name_price
on phone(phone_name, phone_price);

show index from phone;

select * from phone where phone_name = 'iphone14proMax';

explain select * from phone where phone_name = 'iphone14proMax';

-- alter table 명령어를 사용해서 재구성
alter table phone drop index idx_name;
alter table phone add index idx_name(phone_name);

-- mysql의 innodb엔진을 사용하는 경우에는 optinize table 명령을 사용하여 테이블과 인덱스를 최적화 할 수 있따.
OPTIMIZE table phone;

-- 인덱스 삭제
drop index idx_name ON phone;
show index from phone;


