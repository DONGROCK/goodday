/**
 * flag종류
 * i(ignore case) : 대소문자를 구별하지 않고 패턴검색
 * g(Global) : 대상 문자열내에서 패턴과 일치하는 모든 문자열을 전역검색
 * m(Multi line) : 문자열의 행이 바뀌더라도 패턴 검색을 계속
 */

let target = 'Java JavaScript';

console.log(target.match(/VA/));
console.log(target.match(/VA/i));
console.log(target.match(/VA/ig));

/*pattern
    패턴은 특별한 의미를 가지는 메타문자 또는 기호로 표현할 수 있따.
    */

// . : 임의의문자열; 자리수를 차지한다.
target = 'abcdefg';
console.log(target.match(/../g)); // 두자리씩 끊어서 매칭되는 부분을 찾는다.
console.log('-----------');

//{m, n} : 최소 m번, 최대 n번 반복되는 문자열(반복검색)
target = 'a aa aaa b bb bbb ab aab abb';
console.log(target.match(/a{2,3}/g)); //a를 최소 2번 ~ 최대 3번 반복
console.log(target.match(/b{2}/g));     // b를 2개 쓰는 전역검색
console.log(target.match(/b{3,}/g)); //b를 3개 이상쓰는 전역검색 

// + : 앞선 패턴이 최소 한 번 이상 반복되는 문자열(반복검색)
// +는 {1, }과 같다.
console.log(target.match(/b+/g)); //b가 최소 1번나오는 것 다나와!

console.log('---------------');

// ? : 앞선 패턴이 최대 한번(0번포함)이상 반복되는 문자열(반복검색)
// ?는 {0,1}과 같다

target = 'soul seoul'
// s다음 e가 최대 한번(0번포함) 이상 반복되고 oul이 이어지는 문자열 전역검색
console.log(target.match(/se?oul/g));
// console.log(target.match(/se{0, 1}oul/g)); ?? 다시보자.

// | : or
target = 'aa bb cc dd 123 456 _@';
console.log(target.match(/a|b/g));
//분해되지 않은 단어레벨로 검색하기 위해 +함께 사용
console.log(target.match(/a+|b+/g));
//[] 내의 문자는 or로 동작한다.
console.log(target.match(/[ab]+/g));// a가반복되는 b가 반복되는

console.log(target.match(/[a-z]+/g)); // a~z까지

console.log(target.match(/[A-Za-z]+/g)); // A~Z a~z까지

console.log(target.match(/[0-9]+/g));
/**
\d : 숫자
\D : 숫자가 아닌 문자
\w : 알파벳, 숫자, 언더스코어
\W : \w의 반대
*/

console.log(target.match(/\d+/g));// 숫자 다찾아
console.log(target.match(/\D+/g));// 숫자빼고 다찾아

console.log(target.match(/\w+/g)); //알파벳 숫자 언더스코어
console.log(target.match(/\W+/g)); //알파벳 숫자 언더스코어 빼고 찾아

//[...]내의 ^ : not
console.log(target.match(/[^0-9]+/g));//숫자가 아닌것 not숫자라는 뜻
console.log(target.match(/[^a-z]+/g));//문자가 아닌것 not문자라는 뜻

//[...]밖의 ^ : 시작위치검색
// $ : 마지막 위치 검색
target = 'http://www.google.com';
console.log(/^http/.test(target)); // http로 시작하니? 예
console.log(/^https/.test(target)); // https로 시작하니? 아니오
console.log(/com$/.test(target)); // com으로 끝나니? 예




