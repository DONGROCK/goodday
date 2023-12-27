/**01_ Object 생성자 함수
 * 
 * new 연산자와 함께 Object 생성자 함수를 호출하면 빈 객체를 생성하여 반환한다.
 * 객체생성 이후 프로퍼티 또는 메서드를 추가하여 객체를 완성할 수 있다.
 */

//빈객체 생성
const student = new Object();
console.log(student);

//프로퍼티 추가
student.name = '이동락';
student.age = 15;
student.number = '1'

console.log(student);
