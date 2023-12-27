/*
동적타입 (dynamic/weak type)

typeof 연산자 : 변수에 할당된 값의 데이터 타입을 반환한다.
*/

var test;
console.log(typeof test); 
//값이 할당되어 있지 않을 땐undefined

test = 1;
console.log(typeof test);//number

test = 'JavaScript';
console.log(typeof test);//string

test = true;
console.log(typeof test);//boolean

test = null;
console.log(typeof test);//object 널을 object로 인식

test = Symbol();
console.log(typeof test);//symbol

test = {}; //객체
console.log(typeof test); //object

test = []; //배열
console.log(typeof test); //배열도 object로 나옴

test = function(){};
console.log(typeof test); //function