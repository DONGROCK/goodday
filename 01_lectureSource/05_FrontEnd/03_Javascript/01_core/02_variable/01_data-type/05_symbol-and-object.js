/*symbol and object*/


/*Symbol 타입
    심볼은 ES6에서 추가된 7번째 타입으로, 변경불가능한 원시타입의 값이다.
    
    다른 값과 중복되지 않는 유일무이한 값으로 이름 충돌할 위험이 없는 객체의 유일한
    프로퍼티 키를 만들기 위해 사용한다.

    심볼 이외의 원시 값은 리터럴을 통해 생성하지만 심볼은 Symbol함수를 통해 호출해 생성한다.

*/
var key = Symbol('key');
console.log(typeof key);

//객체생성
var obj = {};
console.log(typeof obj);

obj[key] = 'value';
console.log(obj[key]);

/**
 * 객체타입
 * 자바스크립트의 데이터 타입은 크게 원시타입과 객체타입으로 분류한다.
 * 자바스크립트는 객체기반의 언어이며, 자바스크립트를 이루고 있는 거의 모든 것이 객체이다.
 * 
 * number, string, boolean, undefined, null, symbol 6가지 데이터 타입 이외의 값은 모두 객체 타입이다.
 * 
*/