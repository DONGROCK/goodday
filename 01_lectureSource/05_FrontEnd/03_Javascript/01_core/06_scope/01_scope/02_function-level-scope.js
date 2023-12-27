
// 함수 밖에서 var키워드로 선언된 변수는 전역변수이다.
var i = 0;
console.log(i);

//for 코드 블럭 내부에서 i라는 변수를 선언했따.
//이는 전역변수로 이미 선언된 전역변수가 i가 있어서 중복 선언이 된다.
for(var i = 0 ; i< 10; i++){
    console.log(i);
}
console.log(i);

