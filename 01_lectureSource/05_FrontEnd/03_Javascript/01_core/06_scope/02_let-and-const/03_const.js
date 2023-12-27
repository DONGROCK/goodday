/*03_const

const키워드는 상수(constant)를 선언하기 위해 사용한다.
let 키워드와 마찬가지로 블록 레벨 스코를 가지며 벼누 호이스팅이 발생하지 않는 것처럼 동작한다
*/

//const키워드로 선언한 변수는 반드시 선언과 동시에 초기화 해야한다.
const x = 1;

const DISCOUNT_RATE= 0.15;
let price = 15000;

let discountPrice = price * (1 - DISCOUNT_RATE);
console.log(discountPrice);

/* const키워드로 선언된 변수에 객체를 할당한 경우 값을 변경할 수 있따.*/
const student = {
    name: '홍길동',
    age: 20,
};

student.name = '유관순';
console.log(student);