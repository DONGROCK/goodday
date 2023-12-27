//Date.now

const now = Date.now();
console.log(now);
console.log(new Date(now));

console.log('---------');

//DATE.parse
console.log(Date.parse('Jan 1, 1970 09:00:00')); // 0
console.log(Date.parse('Jan 1, 1970 09:00:00 UTC')); // 32400000
console.log(Date.parse('1970/01/01/09:00:00')); // 0
console.log(Date.parse('1970/01/01/09:00:00 UTC')); // 32400000
console.log(Date.UTC(1970, 0, 1)); // 0

console.log('------------');


//년월일시분초
const date = new Date();
console.log(date.getFullYear()); // 년
console.log(date.getMonth()); // 월
console.log(date.getDate()); // 일
console.log(date.getDay()); // 요일 (일요일부터 월요일을 0~6으로 반환)
console.log(date.getHours()); // 시
console.log(date.getMinutes()); // 분
console.log(date.getSeconds()); // 초
console.log(date.getMilliseconds()); // 밀리세컨

console.log('------------');
const date2 = new Date();
date2.setFullYear(2020);
date2.setMonth(0);
date2.setDate(1);
date2.setHours(9);
date2.setMinutes(10);
date2.setSeconds(10);
date2.setMilliseconds(10);
console.log(date2); // 2020-01-01T00:10:10.010Z

console.log('---------');
const date3 = new Date();
console.log(date3.getTime());
date3.setTime(5 * 24 * 60 * 60 * 1000);
console.log(date3); // 1970-01-06T00:00:00.000Z
console.log('-------------');

// Date.prototype.getTimezoneOffset 나라별 시차
const today = new Date();
console.log(today.getTimezoneOffset()); // -540 9시간이라는 뜻
console.log(today.getTimezoneOffset() / 60); // -9

console.log('----------------');
// Date.prototype.to___String
//사람이 읽을 수 있는 형식의 문자열로 Date 객체의 날짜 반환한다
console.log(today.toString());
console.log(today.toDateString());
console.log(today.toTimeString());
console.log(today.toISOString());
console.log(today.toLocaleString());
console.log(today.toLocaleTimeString());



