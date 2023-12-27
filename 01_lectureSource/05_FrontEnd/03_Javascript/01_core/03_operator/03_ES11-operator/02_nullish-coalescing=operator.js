/*
    null 병합 연산자
    ES11(ECMAScript2020)에서 도입된 연산자로 좌항의 피연산자가 null 또는 undefined인 경우
    우항의 피연산자를 반환하고, 그렇지 않으면 좌항의 피연산자를 반환한다.
    변수에 기본값을 설정할 때 유용하다.
*/
var test = null ?? '기본값';
console.log(test);

console.log('=================');
//null 병합 연산자 이전에는 논리연산자 ||를 사용한 단축평가로 변수에 기본값을 설정했다.

// var value = ''|| '기본값';
// console.log(value);

var value = '' ?? '기본값';
console.log(value);

