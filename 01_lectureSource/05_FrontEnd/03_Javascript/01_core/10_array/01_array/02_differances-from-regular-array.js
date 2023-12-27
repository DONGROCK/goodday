//인덱스를 나타내는 문자열을 프로퍼티 키로 가지며, length프로퍼티를 갖는 특수한 객체이다.

/**
 * 프로퍼티 플래그
객체 프로퍼티는 값(value) 과 함께 플래그(flag)라 불리는 특별한 속성 세 가지를 가짐
writable – true이면 값을 수정할 수 있다. 그렇지 않다면 읽기만 가능하다.
enumerable – true이면 반복문을 사용해 나열할 수 있다. 그렇지 않다면 반복문을 사용해 나열할 수 없다.
configurable – true이면 프로퍼티 삭제나 플래그 수정이 가능하다. 
그렇지 않다면 프로퍼티 삭제와 플래그 수정이 불가능하다. 
*/
console.log(Object.getOwnPropertyDescriptors([1,2,3]));

const arr = [
    '동락',
    15,
    true,
    null,
    undefined,
    NaN,
    Infinity,
    [],
    {},
    function(){},
]

console.log(arr);
