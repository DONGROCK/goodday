/*화살표 함수 표현식*/

// ES6에서 도입된 화살표 함수는 function키워드 대신 화살표를 사용해
// 좀더 간략한 방법으로 함수를 선언할 수 있따.
// 화살표함수는 항상 익명 함수로 정의한다. 본문이 한줄인 함수를 작성할 떄  유용하다.

var message;

//기존 function 정의
message = function() {
    return "Hello World";
};

console.log(message());

message = () =>{
    return "Arrow Function";

};
console.log(message());

//명령문이 하나만 있는 경우 중괄호 생략가능
//이때 함수 몸체 내부의 문이 값으로 평가될 수 있는 문이라면 암묵적으로 반환한다.
//return 키워드 생략가능
message = () => "Arrow Functions are Simple";

console.log(message());
message = (val1, val2) => "Arrow" + val1 + val2;

console.log(message('Function', '!'));

//매개변수가 하나면 소괄호 생략가능
//매개변수가 없거나 여러 개일 경우는 생략 불가하다.
message = val => "Arrow" + val;
console.log(message('Functions ar GOOD!?!?!'));
