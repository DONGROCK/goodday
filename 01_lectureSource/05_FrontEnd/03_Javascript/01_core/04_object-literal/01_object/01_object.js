/*객체 리터럴*/

var student = {

//키 - 값 쌍으로 구성된 프로퍼티
//프로퍼티 : 객체의 상태를 나타내는값
name : '이동락',
age  : 16,
//메서드: 프로퍼티(상태 데이터)를 참조하고 조작할 수 있는 동작(behavior)
getInfo: function(){
    return `${this.name}(은)는 ${this.age}세입니다.`
}

}

console.log(typeof student);
console.log(student);
console.log(student.getInfo());
console.log('-------------')
var student2 = {}; //빈객체
console.log(typeof student2);
console.log(student2);
