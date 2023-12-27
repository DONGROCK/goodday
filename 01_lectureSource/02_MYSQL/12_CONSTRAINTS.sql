/* CONSTRAINTS */

-- 제약조건
-- 테이블 작성 시 각 컬럼에 값 기록에 대한 제약조건을 설정할 수 있따.
-- 데이터 무결성 보장을 목적으로 한다.
-- 입력/수정하는 데이터에 문제가 없는지 자동으로 검사해 주게 하기 위한 목적
-- PRIMARY KEY, NOT NULL, UNIQUE, CHECK, FOREGN KEY ...

/* NOT NULL */
-- NULL 값 허용하지 않는다.

DROP TABLE IF EXISTS user_notnull;
CREATE TABLE IF NOT EXISTS user_notnull(
	user_no INT NOT NULL,
    user_id varchar(255) NOT NULL,
    user_pwd varchar(255) NOT NULL,
    user_name varchar(255) NOT NULL,
    gender varchar(3),
    phone varchar(255) NOT NULL,
    email varchar(255)
    
)ENGINE=INNODB;

INSERT INTO user_notnull
(user_no, user_id, user_pwd, user_name, gender, phone, email)
VALUES
	(1, 'user01', 'pass01', '홍길동', '남', '010-4444-1111', 'hong123@naver.com'),
	(2, 'user02', 'pass02', '유관순', '여', '010-2222-3333', 'you123@naver.com'),
	(3, 'user03', 'pass03', '흥칫부', '여', '010-5555-8888', 'y23@naver.com'),
	(4, 'user04', 'pass04', '놀부네', '남', '010-7777-6666', 'you3@naver.com');
    
select * from user_notnull;

INSERT INTO user_notnull
(user_no, user_id, user_pwd, user_name, gender, phone, email)
VALUES
	(1, 'user01', 'pass05' , '이집잘하네', null , '010-2222-1111', '222223@naver.com');
DESC user_notnull;
update user_notnull SET user_no = 5 where user_name = '이집잘하네';

/* UNIQUE */ -- 기본키 특징 중복 없이 null 값이 드렁올수없음 notnull과 unique가 합쳐진게 pk
DROP TABLE IF EXISTS user_unique;
CREATE TABLE IF NOT EXISTS user_unique(
	user_no INT NOT NULL unique, -- 컬럼레벨
    user_id varchar(255) NOT NULL,
    user_pwd varchar(255) NOT NULL,
    user_name varchar(255) NOT NULL,
    gender varchar(3),
    phone varchar(255) NOT NULL,
    email varchar(255),
    UNIQUE (phone)  -- 테이블 레벨
)ENGINE=INNODB;

INSERT INTO user_unique
(user_no, user_id, user_pwd, user_name, gender, phone, email)
VALUES
	(1, 'user01', 'pass01', '홍길동', '남', '010-4444-1111', 'hong123@naver.com'),
	(2, 'user02', 'pass02', '유관순', '여', '010-2222-3333', 'you123@naver.com'),
	(3, 'user03', 'pass03', '흥칫부', '여', '010-5555-8888', 'y23@naver.com'),
	(4, 'user04', 'pass04', '놀부네', '남', '010-7777-6666', 'you3@naver.com');

DESC user_unique;
select * from user_unique;

INSERT INTO user_unique
(user_no, user_id, user_pwd, user_name, gender, phone, email)
VALUES
	(6, 'user05', 'pass05' , '이집잘하네', '남' , '010-2222-1313', '222223@naver.com');
    
/* PRIMARY KEY */
-- 테이블에서 한 행의 정보를 찾기 위해 사용할 컬럼을 의미한다.
-- 테이블에 대한 식별자 역할을 한다.(한 행씩 구분하는 역할을 한다)
-- NOT NULL + UNIQUE 제약조건의 의미
-- 한 테이블당 한 개만 설정할 수 있따.
-- 컬럼레벨, 테이블레벨 둘 다 설정가능하다.
-- 한 개 컬럼에 설정할 수도 있고, 여러 개의 컬럼을 묶어서 설정할 수도 있다.(복합키)
DROP TABLE IF EXISTS user_primarykey;
CREATE TABLE IF NOT EXISTS user_primarykey(
	user_no INT , -- 컬럼레벨
    user_id varchar(255) NOT NULL,
    user_pwd varchar(255) NOT NULL,
    user_name varchar(255) NOT NULL,
    gender varchar(3),
    phone varchar(255) NOT NULL,
    email varchar(255),
    UNIQUE (phone),  -- 테이블 레벨
    PRIMARY KEY (user_no)
)ENGINE=INNODB;

INSERT INTO user_primarykey
(user_no, user_id, user_pwd, user_name, gender, phone, email)
VALUES
	(1, 'user01', 'pass01' , '이집잘하네', '남' , '010-2222-1313', '222223@naver.com');

DESC user_primarykey;
select * from user_primarykey;
Drop table user_primarykey;

-- 제약조건 에러발생 (null값 적용) -- AUTO INCREMENT 가 있으면 널값을 넣어도 자동으로 1씩증가된 값을 넣음
INSERT INTO user_primarykey 
(user_no, user_id, user_pwd, user_name, gender, phone, email)
VALUES
	(null, 'user02', 'pass02' , '이집잘하네', '남' , '010-2222-1313', '222223@naver.com');
    
-- primary key 제약조건 에러발생(중복값 적용)
INSERT INTO user_primarykey
(user_no, user_id, user_pwd, user_name, gender, phone, email)
VALUES
	(1, 'user02', 'pass02' , '이집잘하네', '남' , '010-2222-1313', '222223@naver.com');
    
/* FOREIGN KEY */-- 참조키
-- 참조(REFERENCE)된 다른 테이블에서 제공하는 값만 사용할 수 있다.
-- 참조 무결성을 위배하지 않기 위해 사용
-- FOREIGN KEY 제약조건에 의해서 테이블 간의 관계(RELATIONSHIP)가 형성된다.
-- 제공되는 값 외에는 NULL을 사용할 수 있따.
DROP TABLE IF EXISTS user_grade;
CREATE TABLE IF NOT EXISTS user_grade(
	grade_code INT NOT NULL UNIQUE,
    grade_name VARCHAR(255) NOT NULL
)ENGINE = INNODB;
select * from user_grade;

INSERT INTO user_grade values (10, '일반회원'),(20, '우수회원'),(30, '특별회원');

DROP TABLE IF EXISTS user_foreignkey1;
CREATE TABLE IF NOT EXISTS user_foreignkey1(
	user_no INT primary key,
     user_id varchar(255) NOT NULL,
    user_pwd varchar(255) NOT NULL,
    user_name varchar(255) NOT NULL,
    gender varchar(3),
    phone varchar(255) NOT NULL,
    email varchar(255),
    grade_code int,
    foreign key(grade_code)
		references user_grade(grade_code)
)ENGINE = INNODB;

INSERT INTO user_foreignkey1
VALUES
	(1, 'user01', 'pass01' , '이집네', '남' , '010-3222-1313', '222123@naver.com',10),
	(2, 'user02', 'pass02' , '이집잘하네', '남' , '010-2222-1313', '222223@naver.com',20);
    select * from user_foreignkey1;
    
    SELECT * FROM user_foreignkey1 a join user_grade b on a.grade_code = b.grade_code;
    
    DROP TABLE IF EXISTS user_foreignkey2;
CREATE TABLE IF NOT EXISTS user_foreignkey2(
	user_no INT primary key,
     user_id varchar(255) NOT NULL,
    user_pwd varchar(255) NOT NULL,
    user_name varchar(255) NOT NULL,
    gender varchar(3),
    phone varchar(255) NOT NULL,
    email varchar(255),
    grade_code int,
    foreign key(grade_code)
		references user_grade(grade_code)
        ON UPDATE SET NULL
        ON delete SET NULL
)ENGINE = INNODB;

INSERT INTO user_foreignkey2
VALUES
	(1, 'user01', 'pass01' , '이집네', '남' , '010-3222-1313', '222123@naver.com',10),
	(2, 'user02', 'pass02' , '이집잘하네', '남' , '010-2222-1313', '222223@naver.com',20);
    select * from user_foreignkey2;
    
    -- 1) 부모테이블의 grade_code 수정
	-- user_foreignkey1 테이블에는 foreignkey에 대한 삭제, 수정의 제약조건이 없기때문에 그냥 실행하면 에러
    -- > user_foreignkey1 테이블을 drop하고 테스트
    DROP TABLE IF EXISTS user_foreignkey1;
    
    UPDATE user_grade
    SET grade_code = null
    WHERE grade_code = 10;
    
    -- 2) 부모테이블의 행 삭제
    DELETE FROM user_grade
    WHERE grade_code = 20;
    
    /* CHECK */
    -- check 제약조건 위반 시 허용하지 않는다.
    
    DROP TABLE IF EXISTS user_check;
    CREATE TABLE IF NOT EXISTS user_check(
    user_no INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(255) NOT null,
    gender VARCHAR(3) CHECK(gender IN('남','여')),
    age INT CHECK(age>=19)
    )ENGINE = INNODB;
    
    INSERT INTO user_check
    values(null, '자르반', '남', 20),(null,'카사딘', '남', 56);
    
    select * from user_check;
    
    -- gender컬럼 check제약조건 에러발생
    INSERT INTO user_check
      values(null, '자르반', '남성', 20);
      
          -- age컬럼 check제약조건 에러발생
    INSERT INTO user_check
      values(null, '자르반', '남성', 17);
      
      /*DEFAULT*/
      -- 컬럼에 null 대신 기본값 적용
      -- 컬럼타입이 DATE 일 시 current_date만 가능
      -- 컬럼타입이 DATETIME일 시 current_time과 current_timestamp, now() 모두 사용가능
      DROP TABLE IF EXISTS tbl_country;
      CREATE TABLE IF NOT EXISTS tbl_country(
			country_code INT auto_increment primary key,
            country_name VARCHAR(255) default'한국',
			population VARCHAR(255) default'0명',
            add_day DATE default(current_date),
            add_time datetime default(now())
      ) ENGINE = INNODB;
      
      select * from tbl_country;
      
      INSERT INTO tbl_country values(null, default, default, default, default);
      
      DROP TABLE tbl_country;
    
    
    
    
    
    
    
    
    
    -- SELECT * FROM user_foreignkey2 a join user_grade b on a.grade_code = b.grade_code;