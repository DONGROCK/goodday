-- user_grade 테이블 생성과 데이터 삽입
DROP TABLE IF EXISTS user_grade;
CREATE TABLE IF NOT EXISTS user_grade(
	grade_code INT NOT NULL UNIQUE,
    grade_name VARCHAR(255) NOT NULL
) ENGINE = INNODB;

INSERT INTO user_grade VALUES (10, '일반회원'), (20, '우수회원'), (30, '특별회원');

-- user_foreignkey1 테이블 생성 (외래 키 제약 조건 비활성화)
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
    foreign key(grade_code) references user_grade(grade_code)
) ENGINE = INNODB;

-- 데이터 삽입
INSERT INTO user_foreignkey1
VALUES
	(1, 'user01', 'pass01' , '이집네', '남' , '010-3222-1313', '222123@naver.com',10),
	(2, 'user02', 'pass02' , '이집잘하네', '남' , '010-2222-1313', '222223@naver.com',20);