
/*01[[Prototype]]*/

const user = {
    activate: true,
    login: function(){
        console.log('로그인 되었습니다.');
        
    }
};

const student = {
    passion : true
};

//__proto__는[[Prototype]]의 getter, setter이다.
//요즘에는 잘 사용하진 않지만 호환을 위해 남아있으며 직관적인 이해를 돕기위해 여기서 사용한다.
// 함수 Object.getPrototypeOf 나 ObjectsetPrototypeOf를 써서 프로토타입을 get, set하는 것이 좋다.
student.__proto__ = user;

console.log(student.activate);
console.log(student.passion);
student.login();

//student의 프로토타입은 user이다. student는 user를 상속받는다.
//프로토타입에서 상속받은 프로퍼티를 '상속 프로퍼티' 라고한다.

//프로토타입 체인
const greedyStudent = {
    class: 9,
    __proto__: student
}
console.log(greedyStudent.activate); //user에서 상속
console.log(greedyStudent.passion); //student에서 상속

