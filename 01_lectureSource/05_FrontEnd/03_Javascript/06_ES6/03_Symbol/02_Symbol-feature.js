//Symbol feature
//Symbol을 이용하면 외부코드에서 접근이 불가능하고 값도 덮어쓸 수 없는 숨긴 프로퍼티를 만들 수 있따.

let student = {
    name: '홍길동',
};

let id = Symbol('id');
student[id] = 1;

//student 객체의 키 값, 프로퍼티 이름 등에 name만 나타나고 id는 나타나지 않는다.
console.log(Object.keys(student));
console.log(Object.getOwnPropertyNames(student));

console.log(student[id]);

//객체 리터럴 안에서 사용할 경우 대괄호를 사용해서 심볼형 키를 만드어야한다.
let student2 = {
    name: '유관순',
    age: 16,
    [id]: 2
};

for(let key in student2) console.log(key);

console.log(Object.getOwnPropertySymbols(student));
console.log(Object.getOwnPropertySymbols(student2));

// Symbol은 중복 되지 않는 상수값을 생성하는 것은 물론이고
// 기존에 작성된 코드에 영향을 주지 않고 새로운 프로퍼티를 추가하기 위해,
// 즉 하위 호환성을 보장하기 위해 도입되었다고 할 수 있다.
//https://tc39.es/ecma262/#sec-well-known-symbols
