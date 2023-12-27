//in연산자
//프로퍼티 존재 여부 확인하기
var student = {
    name : '유관순',
    age  : 16,
    test : undefined,

};
console.log(student.name === undefined); // false - 존재
console.log(student.height === undefined); // true - 존재하지 않는다.
console.log(student.test === undefined); // true - 존재하지 않음으로 판단되는 문제가 발생함.

console.log("name" in student);
