// 함수의 (디폴트 프로퍼티)프로토타입과 constructor프로퍼티


function Student(){
    //함수를 만들기만 해도 디폴트 프로퍼티인 prototype이 설정
    //Student.prototype = {constructor : Student}

    console.log(Student.prototype.constructor == Student);
    let student = new Student();//{constructor: Student}을 상속받음
    
    console.log(student.constructor == Student);//true ([[Prototype]]을 거쳐 접근)
    
    
}