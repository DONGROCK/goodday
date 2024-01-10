//객체 구조 분해 할당
//구조 분해 할당을 사용하면 배열이나 객체를 변수로 '분해'하여 연결할 수 있다.

//상품명과 색상, 가격을 프로퍼티로 가지는 객체

let pants = {
    prductName: "배기팬츠",
    color: '검정',
    price: 30000,
};

let{prductName, color, price} = pants;

console.log(prductName);
console.log(color);
console.log(price);

console.log('===============');

//각 변수의 서술 순서는 무관하며 {객체 프로퍼티 : 목표변수} 형식으로도 작성할 수 있다.
let {color: co, price: pr, prductName:pn} = pants;
console.log(co);
console.log(pr);
console.log(pn);
