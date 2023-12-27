/*매개변수와 인수*/

//함수 선언문

function hello(name){
    //매개변수는 함수 몸체 내부에서만 참조할 수있따.
    console.log(name);
    
    //모든 인수는 암묵적으로 arguments 객체의 프로퍼티로 보관한다.
    console.log(arguments); //가변인자 함수 구현시 유용하게 사용
    // console.log(arguments[1]);
    return `${name}님 안녕하세요!`;

}

//매개변수는 함수 몸체 내부에서만 참조할 수 있다.
// console.log(name);

// 함수
var result = hello('홍기르또옹');
console.log(result);

//함수는 매개변수의 갯수와 인수의 갯수가 이맃하는지 체크하지 않는다.
//인수가 부족해서 할당되지 않은 매개변수의 값은 undefined이다.
result = hello();
console.log(result);

result = hello('이동락','2동락');
console.log(result);
console.log(arguments[0]);

function hi(name = '외로운날이여 이제는'){
    
    if(arguments.length !==1 || typeof name !== 'string' || name.length === 0){
        throw new TypeError('인수는 1개여야하고 문자열 값이며 빈 문자열을 허용되지 않습니다.');
    }
    return `${name} 안녕~`;
}
//typeError발생확인
// result = hi('홍길동', '유관순');
// result = hi(1);
// result = hi();


console.log(result);
