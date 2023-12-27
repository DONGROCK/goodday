/**Function, String, Number을 비롯한 내장 객체들 역시 프로토타입에 메서드를 저장한다. */
const num = new Number(100);

console.log(num.__proto__ === Number.prototype);
console.log(num.__proto__.__proto__ === Object.prototype);
console.log(num.__proto__.__proto__ .__proto__);

/**
 * Object.prototype에도 toString 메서드가 있따.
 * 만약 중복 메서드가 있을 때는 체인상에서 가까운 곳에 있는 메서드가 사용된다.
 */
console.log(num);
console.log(num.toString);

//참고
//문자열과 숫자, 불린 처럼 원시 타입 값의 프로퍼티에 접근하려고 하면
//내장 생성자 String, Number, Boolean 을 사용하는 임시 레퍼(Wrapper)객체가 생성되고 임시래퍼객체는 메서드를 제공하고 난 후에 사라진다.
//undefinde와 null에 대응하는 래퍼객체는 없다.

//내장 프로토타입은 수정 가능하다.
String.prototype.hello = function(){
    console.log(`hello, ${this}`);
    
}
"JavaScript".hello();

const obj = {
    0: "HELLO",
    1: "JAVASCRIPT",
    length: 2,
}

obj.join = Array.prototype.join;

console.log(obj.join(','));
