/*논리연산자
||(OR), &&(AND), !(NOT)의 논리연산자는 피연산자를 논리 연산한다.
*/

/*
    단축평가
    표현식을 평가하는 도중 평가 결과가 확정된 경우 나머지 평가 과정을 생략하는 것
*/
//OR, AND 연산자 표현식의 결과가 때로는 boolean값이 아닐 수도 있따.

//OR의 경우 'apple' 이 이미 Truty 값이여서 true로 평가되고
//논리연산의 결과를 결정한 첫 번째 피연산자 apple을 그대로 반환.
console.log('apple' || 'banana'); 
console.log('banana' || 'apple');
console.log(false || 'banana');
console.log('apple' || false);

console.log('===============')
console.log('apple' && 'banana');
console.log(false && 'banana');
console.log('apple' && false);

// 단축평가를 사용하면 if문을 대체할 수 있따.
var num = 1;

if(num % 2 == 0){
    console.log('짝수');
} else{
    console.log('홀수')
}

num % 2 == 0 && console.log('짝수');
num % 2 == 0 || console.log('홀수');

// 객체를 가리키기를 기대하는 변수가 null 또는 nudefined 가 아닌지 확인하고 프로퍼티를 참조할 떄
// 단축평가를 유용하게 사용할 수 있다.

var obj = null;
// var val = obj.value;

var val = obj && obj.value;