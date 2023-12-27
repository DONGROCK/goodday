CREATE USER 'mtvs'@'%' IDENTIFIED BY 'mtvs'; -- 생성
drop user 'mtvs'@'%'; -- 드랍
GRANT ALL PRIVILEGES ON menudb.* TO 'mtvs'@'%'; -- 권한부여


SHOW databases;
use mysql;
SELECT * FROM user;

CREATE DATABASE menudb;
GRANT ALL PRIVILEGES ON menudb.* TO 'mtvs'@'%';

SHOW GRANTS FOR 'mtvs'@'%';

CREATE USER '계정명'@'주소' IDENTIFIED BY '비밀번호';

GRANT ALL PRIVILEGES ON menudb.* TO 'mtvs'@'%' ;

SET GLOBAL sql_mode = '';

create database memberdb;
grant all privileges on memberdb.* to ohgiraffers@'%';