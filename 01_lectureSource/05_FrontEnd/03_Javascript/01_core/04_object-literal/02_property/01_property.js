/**
 *  property
 *  객체는 프로퍼티의 집합이며, 프로퍼티는 키와 값으로 구성된다.
 * 
 */

var student = {
    //프로퍼티 키는 name, 프로퍼티 값은 '이동락'
    name : '이동락',

    age : 16,
    //프로퍼티 나열은 쉼표로 구분하며 마지막 프로퍼티 뒤에 쉼표를 사용해도 된다.

}
console.log(student);
console.log('================')
var obj = {
    normal : 'normal value',
    "@ 안 녕 하 세 요@" : "space value",
    '' : '' ,       //빈 문자열 키는 오류 발생하지 않지만 권장X
    0 : 1,          //숫자 키는 내부적으로는 문자열로 변환한다.
    var : 'var'  ,   //예약어 키는 오류 발생하지는 않지만 권장X
    normal : 'new value', //이미존재하는 키를 중복선언하면 나중에 선언한 프로퍼티로 덮어씀
};
var key = 'test';
obj[key] = 'test value';

console.log(obj);