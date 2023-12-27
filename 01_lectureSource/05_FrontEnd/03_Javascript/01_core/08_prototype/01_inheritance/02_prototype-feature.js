/**prototype feature */
const user = {
    id: 'user',
    login: function(){
        console.log(`${this.id}님 로그인 되었어요.`);
        
    }
};

const student = {
    __proto__:user
};

//프로토타입은 프로퍼티를 읽을 때만 사용하며 프로퍼티를 추가, 수정, 삭제하는 연산은 객체에 직접 한다..
student.id = 'user01';
console.log(student);

//login 메소드 내의 this는 프로토 타입에 영향받지 않으며
//메서드를 객체에서 호출해든 프로토타입에서호출했든 상관없이 this는 항상 .앞에 있는 객체이다.
student.login();
// => 메서드는 공유되지만 객체의 상태는 공유되지 않는다.

for(let prop in student){
    //for in 반복문은 상속 프로퍼티도 순회 대상에 포함시킨다.
    console.log(prop);
    //key에 대응하는 프로퍼티가 상속 프로퍼티가 아니고 obj에 직접 구현되어 있는 프로퍼티 일 때만 true를 반환
    let isOwn = student.hasOwnProperty(prop);

    if(isOwn){
        console.log(`객체 자신의 프로퍼티 ${prop}`);
    } else{
        console.log(`상속 프로퍼티 ${prop}`);
    }
}