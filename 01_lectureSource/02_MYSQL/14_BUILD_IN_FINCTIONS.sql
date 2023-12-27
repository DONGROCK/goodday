/*BUILD IN FINCTIONS*/
/*문자열 관련 함수*/
-- ASCII(아스키코드), CHAR(숫자)
-- ASCII : 아스키코드값 추출
-- CHAR: 아스키 코드로 문자 추출
SELECT ascii('A'), char(65);

-- BIT_LENGTH(문자열), CHAR_lnegth(문자열), length(문자열)
-- bit_length : 할당된 비트 크기 반환
-- char_length : 문자열의 길이 반환
-- length : 할당된 byte 크기 반환
select bit_length('pie'), char_length('pie'), length('pie');
select bit_length('하이'), char_length('하위'), length('하이');

select menu_name, bit_length(menu_name), char_length(menu_name), length(menu_name) from tbl_menu;

-- CONCAT(문자열1, 문자열2, ...), CONCAT_WS(구분자, 문자열1, 문자열2, ...)
-- CONCAT : 문자열을 이어 붙임
-- CONCAT_WS : 구분자와 함께 문자열을 이어붙임
SELECT concat('호랑이','기린','캥거루');
select concat_ws(',' , '호랑이', '캥거루', '기린');
select concat_ws('-', '2023','12','30');

-- ELT(위치, 문자열1, 문자열2,...) FIELD(찾을 문자여르 문자열1, 문자열2, ...)
-- FIND_IN_SET(찾을 문자열, 문자열리스트), instr(기준문자열, 부분문자열),
-- LOCATE(부분문자열, 기준문자열)
-- ELT : 해당 위치를 문자열 반환
-- FIELD : 찾을 문자열 위치 반환
-- FIND_IN_SET : 찾을 문자열의 위치 반환
-- INSTR : 기준 문장열에서 부분문자열의 시작 위치 반환
-- LOCATE : INSTR과 동일하고 순서는 반대
select elt(2, '사과','딸기','바나나'),  /*2번째 있는 문자열이 뭐냐 라는*/
 field('딸기', '사과','딸기','바나나'),/*딸기의 위치*/ 
find_in_set('바나나', '사과,딸기,바나나'),
instr('사과딸기바나나','딸기'), /*locate와 순서만 반대며 같다.*/
locate('딸기','사과딸기바나나');

-- FORMAT(숫자, 소수점 자릿수)
-- FORMAT : 1000단위마다 콤마(,) 표시를 해주며 소수점 아래 자리수 (반올림) 까지 표현한다.
select format(223123312.31215134, 4); -- 뒤에오는 숫자는 소수점자리수

-- bin(숫자), oct(숫자), hex(숫자)
-- bin : 2진수 표현
-- oct : 8진수 표현
-- hex : 16진수 표현
select bin(65), oct(65), hex(65);

-- insert(기존문자열, 위치, 길이, 삽입할 문자열)
-- insert : 기존문자열의 위치부터 길이만큼을 지우고 삽입할 문자열을 끼워 넣는다.
select insert('내이름은 이동락입니다.', 7, 2,'갈비');

-- left(문자열, 길이), right(문자열, 길이)
-- left: 왼쪽에서 문자열의 길이만큼을 반환
-- right : 오른쪽에서 문자열의 길이만큼을 반환
select left('HELLO WORLD!' , 3);
select right('HELLO WORLD!' , 3);

-- upper(문자열), lower(문자열)
-- upper: 소문자 -> 대문자
-- lower: 대문자 -> 소문자

select lower('HELLOWORLD'), upper('helloworld');

-- lpad(문자열, 길이, 체율문자열), rpad(문자열, 길이, 채울문자열)
-- lpad : 문자열의 길이만큼 왼쪽으로 늘린 후에 빈곳을 문자열로 채운다.
-- rpad : 문자열의 길이만큼 오른쪽으로 늘린 후에 빈곳을 문자열로 채운다.

SELECT LPAD('왼쪽', 6, '뚜두');/*문자열의 길이가 6이 될때 까지 뚜두를 넣어라*/ 
SELECT RPAD('오른쪽', 6, '빱');

-- LTRIM(문자열), RTRIM(문자열)
-- LTRIM : 왼쪽 공백 제거
-- RTRIM : 오른쪽 공백 제거
select ltrim('                         왼쪽'), rtrim('오릉쪽                            '); 
-- TRIM(문자열), TRIM(방향 자를_문자열 FROM 문자열)
-- trim은 기본적으로 앞뒤 공백을 제거한다.alter
-- 방향(LENDING(앞), BOTH(양쪽다), TRAILING(뒤))이 있으면 해당 방향에 지정한 문자열을 제거할 수 있따.
select trim('   mysql   '),
 trim(both '@' from '@@@@@@@@@@mysql@@@@@@@@@@@'),/*특정한 문자를 지정해서 지울수있다.*/
 trim(TRAILING '@' from '@@@@안녕@@@@'); 

-- repeat(문자열, 횟수)
-- repeat : 문자열을 횟수만큼 반복
select repeat('나쁘지않아' , 3);

-- replace(문자열, 찾을 문자열, 바꿀문자열)
-- replace: 문자열에서 문자열을 찾아 치환
select replace('mysql', 'my', "마이");

-- reverse(문자열)
-- reverse : 문자열의 순서를 거꾸로 뒤집는다.
select reverse('안녕하세요');

-- space(길이)
-- space : 길이 만큼의 공백을 반환
select concat('내 이름은', space(5), '이고 나이는' ,space(3), '세입니다.');

-- substring(문자열, 시작위치, 길이)
-- substring : 시작 위치부터 길이만큼의 문자를 반환(길이를 생략하면 시작 위치부터 끝까지 반환)
select substring('안녕하세요ㅗ반갑습니다.', 7, 2), substring('안녕하세요ㅗ반갑습니다.',7);

-- substring_index(문자열, 구분자, 횟수)
-- substring_index : 구분자가 왼쪽부터 횟수 번째 나오면 그 이후의 오른쪽은 버린다.
-- 횟수가 음수일 경우 오른쪽부터 세고 왼쪽을 버린다.
select SUBSTRING_INDEX('hong.test@gmail.com', '.', 2),
 SUBSTRING_INDEX('hong.test@gmail.com', '.', -2); -- 음수를 넣으면 뒤에서부터 카운트하고 이후 왼쪽을 버린다.
 
 /*수학 관련 함수*/
 -- abs(숫자)
 -- abs : 절대값 반환
 select abs(-12391295);
 
 -- ceiling(숫자), floor(숫자), round(숫자)
 -- ceiling : 올림
 -- floor : 버림값 반환
 -- round : 반올림값 반환
 select ceiling(1234.06), floor(1234.56), round(1234.56);
 
-- conv(숫자, 원래진수, 변환할 진수)
-- conv : 원래 진수에서 변환하고자 하는 진수로 변환
select conv('A', 16, 10), conv('A', 16, 2), conv(1010,2, 8); 

-- MOD(숫자1, 숫자2) 또는 숫자1 % 숫자2 또는 숫자1 MOD 숫자2
-- MOD : 숫자 1을 숫자2로 나눈 나머지 추출

select mod(75, 10), 75 % 10, 74 MOD 10;

-- pow(숫자1,숫자2), sqrt(숫자)
-- pow : 거듭제곱값 추출
-- sqrt : 제곱근을 추출
select pow(2, 4), sqrt(16);

-- rand()
-- rand : 0이상 1미만의 실수를 구한다.
-- 1부터 10 까지 난수 발생
-- floor(rand() * (10) + 1)
select rand(), floor(rand() * (10)+1);

-- sign(숫자)
-- sing : 양수면 1, 0이면 0, 음수면 -1을 반환
select sign(10.1), sign(0), sign(-10.1);

-- truncate(숫자, 정수)
-- truncate : 소수점을 기준으로 정수 위치까지 구하고 나머지는 버림
select truncate(123456.12345, 2), truncate(123456.12345, -2); 

/*날짜 및 시간 관련 함수*/
-- adddate(날짜, 차이), subdate(날짜, 차이)
-- adddate : 날짜를 기준으로 차이를 더한다.
-- subdate : 날짜를 기준으로 날짜를 뺀다.
select adddate('2023-10-31', interval 30 day)/*날짜에서 30일 추가*/,
adddate('2023-10-31', interval 4 month);
select subdate('2023-10-31', interval 30 day)/*날짜에서 30일 빼기*/,
subdate('2023-10-31', interval 2 month); 

-- addtime(날짜/시간, 시간), subtime(날짜/시간, 시간)
-- addtime : 날짜 또는 시간을 기준으로 시간을 더한다.
-- subtime : 날짜 또는 시간을 기준으로 시간을 뺀다.
select addtime('2023-10-23 12:42:13', '1:0:1'),
subtime('2023-10-23 13:42:14', '1:0:1');

-- curdate(), curtime(), now(), sysdate()
-- curdate : 현재 연-월-일 추출
-- curtime : 현재 시-분-초 추출
-- now() 또는 sysdate() : 현재 연-월-일 시:분:초 추출
select curdate(), curtime(), now(), sysdate();

-- curdate(), current_date(), current_date는 동일
select curdate(),current_date(),current_date; -- 배고픈부분

-- curtime(), current_time, current_time은 동일
select curtime(), current_time(),current_time; 

-- now(), localtime, localtime(), localtimestamp, localtimestamp()는 동일
select now(), localtime, localtime(), localtimestamp, localtimestamp();

-- year(날짜) , month(날짜), day(날짜),
-- hour(시간) , minute(시간) , second(시간), microsecond(시간)-- 1000분의 1초
select year(curdate()), month(curdate()), dayofmonth(curdate());
select hour(curtime()), minute(curtime()), second(current_time()),microsecond(current_time());

-- date(), time()
-- date : 연-월-일만 추출
-- time : 시:분:초만 추출
select date(now()), time(now());

-- datediff(날짜1, 날짜2), timediff(날짜1 또는 시간1, 날짜1 또는 시간2)
-- datediff : 날짜 - 날짜2의 일수를 반환
-- timediff : 시간1 - 시간2의 결과를 구한다.
select datediff('2023-09-19', now()), timediff('17:04:11', '13:03:');

-- dayofweek(날짜), monthname(), dayofyear(날짜)alter
-- dayofweek : 요일 반환(1일 일요일)
-- monthname : 해당 달의 이름 반환
-- dayofyear : 해당 년도에서 몇일이 흘렀는지 반환
select dayofweek(curdate()), monthname(curdate()), dayofyear(curdate()); -- 일요일부터 1~ 토요일 7

-- last_day(날짜)
-- last_day : 해당 날짜의 달에서 마지막 날의 날짜를 구한다.
select last_day('20200223');

-- makedate(연도, 정수)
-- makedate : 해당 연도의 정수만큼 지난 날짜를 구한다.
select makedate(2023,60);

-- maketime(시, 분, 초)
-- maketime : 시, 분, 초를 이용해서 '시:분:초' 의 time형식을 만든다.
select maketime(13, 11, 8);

-- period_add(연월, 개월수), period_diff(연월1, 연월2)
-- period_add : 연월에서 개월 수 이후의 연월 구한다.(연월은 YYYY 또는 YYYYMM형식을 사용한다.)
-- period_diff : 연월1 - 연월2의 개월 수를 구한다.
select period_add(202310, 5), period_diff(202310, 202402);

-- quarter(날짜)
--  quarter : 해당 날짜의 분기를 구한다.
select quarter('2023-10-23');

-- time_to_sec(시간)
-- time_to_sec : 시간을 초 단위로 구한다.
select time_to_sec('1:1:1')




