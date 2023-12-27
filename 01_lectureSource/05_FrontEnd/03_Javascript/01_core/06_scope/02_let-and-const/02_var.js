/**
 * 01_var
 * ES5까지 변수를 선언할 수 있는 유일한 방법은 var 키워드를 사용하는 것이었는데
 * 이는 아래와 같은 몇가지 문제를 야기한다.
 */

//1. 변수 중복 선언 허용
var msg = '안녕하세요';
console.log(msg);

// var키워드로 선언된 변수는 같은 스코프 내에서 중복선언이 허용된다.
// 초기화 문이 있는 변수 선언문은 자바스크립트 엔진에 의해 var키워드가 없는 것처럼 동작한다.

var msg = '안녕히 가셈';
console.log(msg);

//초기화 문이 없는 변수 선언문은 무시된다.,
var msg;
console.log(msg);

//2. 함수레벨스코프
// 함수 외부에서 var키워드로 선언한 변수는 코드블럭 내에서 선언해도 모두 전역변수가 된다.
var i = 0;

for(var i = 0 ; i < 10; i++) {

}
console.log(i);

//3. 변수 호이스팅
console.log(test);
test = '반갑다 친구야';
console.log(test);
var test; //변수 선언은 런타임 이전에 암묵적 실행된다.