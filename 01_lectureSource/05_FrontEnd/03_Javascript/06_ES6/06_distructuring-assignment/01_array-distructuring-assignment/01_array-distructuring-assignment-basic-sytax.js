/**
 * 배열 구조 분해 할당
 * 구조 분해 할당을 사용하면 배열이나 객체를 변수로 '분해' 하여 연결 할 수 있다.
 * 
 */

let nameArr = ["Killdong",'Hong'];
// let firstName = nameArr[0]
// let lastName = nameArr[1]
console.log(nameArr);

let [firstName, lastName] = nameArr;
console.log(firstName);
console.log(lastName);

console.log('=========================');

//
let [firstName2, lastName2] = 'Saimdang Shin'.split(' ');
console.log(firstName2);
console.log(lastName2);

console.log('=========================');

let [firstName3, ,lastName3] = ['firstName', 'middleName','lastName'];
console.log(firstName3);
console.log(lastName3);

