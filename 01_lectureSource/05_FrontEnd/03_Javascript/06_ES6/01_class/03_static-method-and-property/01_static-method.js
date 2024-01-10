// 01. static method(정적 메소드)
// 정적 메소드는 특정 클래스 인스턴스가 아닌 클래스 '전체'에 필요한 기능을 만들 때 사용한다.

class Student {
    constructor(name, height){
        this.name = name;
        this.height = height;

        
    }

    //클래스 선언부 안에 위치하고 앞에 static이라는 키워드를 붙인다.
    static compare(studentA, studentB){ //정렬
        return studentA.height - studentB.height;
    }
}

let students = [
    new Student('최홍만', 202),
    new Student('야오밍', 222),
    new Student('즐라탄', 193)
];

console.log(students);
students.sort(Student.compare); // 신장 오름차순으로 배열을 정렬한다.
// Student.comapre는 학생들의 신장을 비교해주는 수단으로 하나의 학생마다 필요한
// 메서드가 아니라 클래스의 메서드여야 한다. --> 정적 메서드
console.log(students);

Student.staticMethod = function(){
    console.log('staticMethod는 메서드를 프로퍼티 형태로 직접 할당하는 것과 동일하다.');
    
};

Student.staticMethod();
// 조건에 맞게 Student를 만들어야 할 때 생성자도 사용가능하지만 클래스에 정적 메서드를 만들어 팩토리 메서드를 구현 할 수 있다.
class User{
    constructor(id, registDate){
        this.id = id;
        this.registDate = registDate;

    }

    static registUser(id){
        return new this(id, new Date());
    }
}

let user01 = new User('user01', new Date());

console.log(user01);

let user02 = User.registUser('user02');

console.log(user02);
