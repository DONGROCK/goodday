/**
 * 암묵적 타입변환
 * 타입 변환 된 결과를 예측할 수 있어야한다.
 */
console.log('=======문자열 타입으로 변환==========');
//문자열 연결 연산자로 동작
console.log(10+'20');
//템플릿 리터럴 표현식 삽입은 표현식의 결과를 문자열 타입으로 암묵적으로 변환
console.log(`10 + 20 : ${10 + 20}`);

//문자열 타입이 아닌 값을 문자열 타입으로 암묵적으로 변환하는 결과
console.log((1+''));        //1
console.log(NaN + '');      //'NaN'
console.log(Infinity + ''); //'Infinity'
console.log(true + ''); //'true'
console.log(undefined + ''); //'undefined'
// console.log(Symbol() + ''); //TypeError: Cannot convert a Symbol value to a string
console.log({}+'');//[object Object]
console.log([]+'');// ''
console.log(function(){} +'');// 'function(){}'
