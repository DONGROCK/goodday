/*
    arrow-function

    ES6에서 도입된 화살표함수는 function 키워드 대신 화살표를 사용해 좀더 간량한 방법으로 함수를 선언할 수 있다.
    화살표 함수는 항상 익명 함수로 정의한다. 본문이 한줄인 함수를 작성할 떄 유용하다.

*/

let message;

message = function () {
    return 'Hello World';
};

console.log(message());


//function 키워드 생략 가능
message = () => {
    return 'Arrow Function';
};

console.log(message());

//명령문이 하나만 있는 경우 중괄호 생략 가능
//이 때 함수 몸체 내부의 문이 값으로 평가될 수 있는 표현식인 문이라면 암묵적으로 반환 된다.(return 키워드 생략 가능)
message = () => 'Arrow Function are Simple';

console.log(message());

//매개변수가 있을 경우
message = (val1,val2) => 'Arrow' + val1 + val2;
console.log("-----------매개변수가 있을 경우)");

console.log(message('Function', '!'));

//매개변수가 하나면 소괄호 생략가능
//매개변수가 없거나 여러 개일 경우 생략 불가하다.
message = (val) => 'Arrow ' + val;
console.log(message('Function ar GOOD!!'));

const createUser = (id, name) => (
    {id, name}
    );

console.log(createUser(1, '원펀맨'));

const createUser2 = (id, name) =>{
   return {id, name};
};

console.log(createUser2(2, '투펀맨'));


console.log([1,2,3,4,5].map(function (value){
    return value * 10;
}));

console.log([1,2,3,4,5].map((value) => value * 10));

