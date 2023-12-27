// new 연산자와 함께 호출하여 String 인스턴스를 생성
const obj = new String();
console.log(obj); // 인수 전달하지 않으면 빈 문자열을 할당한 객체 생성
const obj2 = new String('홍길동');
console.log(obj2); // 인수로 문자열 전달 시 전달 받은 문자열 할당
// length 프로퍼티(문자열의 문자 개수)
// 인덱스를 나타내는 숫자 형식의 문자열 - 프로퍼티 키, 각 문자 - 프로퍼티 값
console.log(obj2.length);
console.log(obj2[0]);
// 단, 문자열은 원시 값이므로 변경 불가
obj2[0] = '김'; // 에러는 발생하지 않음
console.log(obj2);
// 문자열이 아닌 값을 인수로 전달했을 경우 문자열로 강제 변환
const obj3 = new String(100); 
const obj4 = new String(null);
console.log(obj3[0]);
console.log(obj4[0]);