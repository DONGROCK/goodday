/*모던메소드 - 프로토타입 접근 시 사용*/
const user = {
    activate: true,

};

// Object.create(proto): [[Prototype]]이 proto를 참조하는 빈 객체를 만든다.
// 프로토타입이 user인 새로운 객체를 생성
const student = Object.create(user);
console.log(student.activate);


// Object.getPrototypeOf(obj) - obj의 [[Prototype]]을 반환
console.log(Object.getPrototypeOf(student) === user);


//Object.setPrototypeOf(obj, proto) = obj의 [[Prototype]]이 proto가 되도록 설정
Object.setPrototypeOf(student,{});
console.log(Object.getPrototypeOf(student) === user);

// __ptoto__를 getter, setter로 직접 사용하면 키가 "__proto__"일때 에러가 발생하는 의도하지 않은 결과가 나올수있다.
const obj = {};
let key = "__proto__";
obj[key] = "값 설정";
console.log(obj[key]);
obj[key]= {test: "새로운 객체 덮어쓰기"};
console.log(obj[key]);

