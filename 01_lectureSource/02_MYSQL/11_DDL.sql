/*DDL(Data DEfiniton Language)*/

/*CREATE*/
-- 테이블 생성을 위한 구문
-- IF NOT EXISTS를 적용하면 기존에 존재하는 테이블이라도 에러가 발생하지 않는다.

-- 테이블의 컬럼 설정
-- column_name_data_type(length)[NOT NULL] [DEFAULT value] [AUTOINCREMENT] column_constraint 이컬럼에는 널값이 들어갈 수 없다.
create table if not exists tb(
	pk INT PRIMARY KEY,
    fk int,
    col1 varchar(255), -- 디폴드값으로 255그냥 많이쓴다함.
	CHECK(col1 IN ('Y','N'))
    
) ENGINE = INNODB;
-- 테이블 구조확인
DESCRIBE tb;
INSERT INTO tb VALUES (1, 10, 'Y');
SELECT * FROM tb;

/*AUTO INCREMENT */
-- INSERT 시 PRIMARY키에 해당하는 컬럼에 자동으로 번호를 발생(중복되지 않게)시켜 저장할 수 있따.

CREATE TABLE IF NOT EXISTS tb1 (
	pk INT AUTO_INCREMENT PRIMARY KEY,
    fk int,
    col1 VARCHAR(255),
    CHECK(col1 IN('Y','N'))
    
) ENGINE = INNODB;
DESC tb1;
INSERT INTO tb1 VALUES (null, 10, 'Y');
INSERT INTO tb1 VALUES (null, 20, 'N');
select * from tb1;


-- 열 제약 조건 추가 및 삭제
alter table tb1
	DROP PRIMARY KEY;
    
-- AUTO_INCREMENT 가 걸려있는 컬럼은 PRIMARY KEY 제거가 안되므로
-- AUTO_INCREMENT 를 MODIFY 명령어로 제거한다.
ALTER table tb1
	modify pk INT;
    
DESC tb1;

-- PRIMARY KEY 제약조건 추가
alter table tb1
	ADD primary key(pk);
    
-- 다시 PRIMARY KEY 제약조건 제거
ALTER table tb1
	drop primary key;
    
-- 컬럼 여러개 추가하기 (가독성을 위해 PK는 맨 위에 작성)
-- ALTER TABLE table_name
-- 	ADD new column column_definition
-- [FIRST | AFTER column_name],
--  ADD new_column column_definition
-- [FIRST | AFTER column_name],
-- ...;
ALTER TABLE tb1
	ADD col2 DATE NOT NULL, -- 1292 에러 발생
    ADD col3 TINYINT NOT NULL;
    
-- sql_mode를 통해 시스템의 모드를 조회해서 확인 그러면 ONLY_FULL...이런 값이 들어가있는것 확인가능    
SELECT @@GLOBAL.sql_mode;

-- sql_mode를 통해 시스템에 대해 비워주고 다시 Workbench를 껏다가 키면 추가를 시킬 수 있따.(단 root 계정으로 할 것)
SET GLOBAL sql_mode = '';

/*DROP*/
-- 테이블을 삭제하기 위한 구문
-- IF EXISTS를 적용하면 존재하지 않는 테이블 삭제 구문이라도 에러가 발생하지 않는다.

-- DROP [TEMPORARY] TABLE [IF EXISTS] table_name [table_name]...
-- [RESTRICT | CASCADE]

-- tb3
CREATE TABLE IF NOT EXISTS tb3 (
	PK INT auto_increment primary key,
	fk INT,
	col1 varchar(255),
	CHECK(col1 IN('Y','N'))
)ENGINE=INNODB;

DROP TABLE IF EXISTS tb3;

-- 한번에 여러개의 테이블 삭제
CREATE TABLE IF NOT EXISTS tb4 (
	PK INT auto_increment primary key,
	fk INT,
	col1 varchar(255),
	CHECK(col1 IN('Y','N'))
)ENGINE=INNODB;
CREATE TABLE IF NOT EXISTS tb5 (
	PK INT auto_increment primary key,
	fk INT,
	col1 varchar(255),
	CHECK(col1 IN('Y','N'))
)ENGINE=INNODB;

-- 한번에 여러개의 테이블 삭제
DROP TABLE IF EXISTS tb4, tb5;

-- 테이블 드랍하면 롤백해도 못가져온다.
rollback;

/*TRUNCATE*/
-- TRUNCATE [table] table_name;

-- 논리적으로 WHERE 절이 없는 DELETE 구문과 큰차이가 없어보인다.
-- 하지만 어차피 데이터를 다 삭제할 경우 행마다 하나씩 지워지는 DELETE보다
-- DROP이후 바로 테이블을 재생성해주는 TRUNCATE가 훨씬 효율적으로 한번에 테입르을 초기화 시켜준다.
-- 또한 AUTO_INCREMENT컬럼이 있는 경우 시작값도 0으로 초기화된다.

CREATE TABLE IF NOT EXISTS tb6 (
	PK INT auto_increment primary key,
	fk INT,
	col1 varchar(255),
	CHECK(col1 IN('Y','N'))
)ENGINE=INNODB;
INSERT INTO tb6 values(null, 10, 'Y');
INSERT INTO tb6 values(null, 20, 'Y');
INSERT INTO tb6 values(null, 30, 'Y');
INSERT INTO tb6 values(null, 40, 'Y');
SELECT * FROM tb6;

-- 테이블 초기화
truncate table tb6; 
truncate tb6; -- 테이블 안써도 초기화 가능.