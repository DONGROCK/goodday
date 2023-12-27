/**정규 표현식 */

//정규 표현식 생성
const target = "JavaScript"; //"JavaScript" 타겟

//정규표현식 리터럴 /패턴/플래그
let regexp = /j/i; // j는 패턴이고 i(플래그)란 대소문자구분없이 찾는다

//RegExp 생성자 함수 - new RegExp(pattern[,flag])
regexp = new RegExp('j','i');
regexp = new RegExp(/j/, 'i');
regexp = new RegExp(/j/i);

//test메서드 - target  문자열에 대해 정규표현식 regexp의 패턴을 검색하여 매칭 결과를 불리언으로 반환
console.log(regexp.test(target));

