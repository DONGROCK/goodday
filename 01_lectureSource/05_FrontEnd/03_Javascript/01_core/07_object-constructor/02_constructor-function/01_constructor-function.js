/**생성자 함수 */

const student1 = {
    name: '동락도락이다',
    age: 15,
    getInfo: function(){
        return `${this.name}(은)는 ${this.age}세 입니다.`
    }
};
const student2 = {
    name: '이동락',
    age: 15,
    getInfo: function(){
        return `${this.name}(은)는 ${this.age}세 입니다.`
    }
};

//생성자 함수에 의한 객체 생성
//객체를 생성하기 위한 템플릿 처럼 생성자 함수를 사용하여 프로퍼티 구조가
//동일한 객체 여러개를 간편하게 생성할 수 있다.

function Student(name, age){
    //생성자 함수 내부의 this는 생성자 함수가 생성할 인스턴스를 가리킨다.
    this.name = name;
    this.age = age;
    this.getInfo = function(){
        return `${this.name}(은)는 ${this.age}세 입니다.`
    }
}

//인스턴스 생성
const student3 = new Student('킹',13);
const student4 = new Student('잭',11);
const student5 = new Student('퀸',12);

console.log(student2.getInfo);
console.log(student3.getInfo);
console.log(student4.getInfo);
console.log(student5);
