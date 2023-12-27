/*DATA TYPES*/
-- char(3) 3자리 고정길이, varchar(255) 3자리만 써도 알잘딱 가변길이이다.
-- SET 은 최대 64개를 준비한후 2개씩 세트로 데이터를 저장하는 방식을 사용시 활용되는 방식
-- DATE YYYY-MM-DD 형식
-- TIME HH:MM:SS 형식
-- DATE TIME YYYY-MM-DD-HH:MM:SS 형식
-- TIMESTAMP YYYY-MM-DD-HH:MM:SS 형식 UTC시간대 변환하여 저장

/*CAST FUNCTIONS*/
/*명시적 형변환(Explicit Conversion)*/
-- CAST( expression AS 데이터형식[(길이)])
-- CONVERT(expression, 데이터형식[(길이)])
-- 데이터형식으로 가능한 것은 BINARY, CHAR, DATE, DATETIME, DECIMAL, JSON, SIGNAL, INTEGER, TIME, USIGNED INTEGER 등이 있다.

select avg(menu_price) FROM tbl_menu;
select cast(avg(menu_price) as signed integer) as '평균 메뉴 가격' FROM tbl_menu; -- 소수점 빠짐.
select convert(avg(menu_price), signed integer) as '평균 메뉴 가격' fROm tbl_menu;

select cast('2023$5$30' as date);
select cast('2023/5/30' as date);
select cast('2023#5#30' as date); -- 구분자는 뭘 쓰든 구분함 .

-- 카테고리별 메뉴 가격 합계 구하기
select concat(cast(menu_price as char(5)), '원') from tbl_menu; -- 메뉴가격(숫자)을 최대길이가 5인 문자형식으로 바꾼다.

-- 카테고리별 메뉴 가격 합계 구하기
select
	category_code,
    concat(cast( SUM(menu_price) as char (10)), ' 원') 
FROM
	tbl_menu
group by
	category_code;

-- 암시적 형변환(Implicit Conversion)
select '1' + '2'; -- 각문자가 정수로 변환이 된다. (신기하다)
select concat(menu_price, '원') from tbl_menu; -- menu_price가 문자로 된다.
select 3 > 'MAY' ; -- 문자는 0 으로 변환을 시킨다.
select 5 > '6MAY' ; -- 문자에서 첫번째로 나온숫자는 정수로 전환된다.
select 5 > 'MA6Y' ; -- 숫자가 뒤에 나오면 문자로 인식되어 0으로 변환된다.
select '2023-10-23'; -- 날짜형으로 바뀔 수 있는 문자는 DATE 형으로 변환