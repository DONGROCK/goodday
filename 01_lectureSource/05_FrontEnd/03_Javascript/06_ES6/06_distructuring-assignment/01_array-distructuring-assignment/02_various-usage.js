//다양한 사용법

//할당 연산자 우측엔 이터러블이 올 수 있고 할당 연산자 좌측엔 뭐든지 올 수 있따. 객체 프로퍼티도 가능하다.

let user = {};

[user.firstName, user.lastName, user.age] = 'Gwansoon Yu 16'.split(' ');
console.log(user.firstName);
console.log(user.lastName);
console.log(user.age);

//Object.entries()와 구조 분해를 조합하면
for(let[key, value] of Object.entries(user)){
    console.log(`${key}: ${value}`);
    
}

let student = '유관순';
let teacher = '홍길동';

[student, teacher] = [teacher, student]; //학생과 선생을 바꾸고 싶을 때

console.log(`학생 : ${student}, 교사 : ${teacher}`);

console.log("=========================");

let [sign1, sign2, ...rest] = ['양자리', '황소자리','쌍둥이자리','게자리','사자자리'];
console.log(sign1);
console.log(sign2);
console.log(rest);

console.log("=========================");
//기본 값을 설정하고 사용할 수 도 있다.
let[firstName4 = '아무개', lastName4 = '김'] = ['길동'];//['박사','홍']

console.log(firstName4); //배열에서 받아온 값
console.log(lastName4); //기본값

console.log("=========================");

