/**
 * 02_let
 * var 키워드의 단점을 보완하기 위해 ES6에서는 새로운 변수 선언 키워드인 let, const를 도입했따.
 */

//1. 변수 중복 선언금지
let msg = '안녕하세여';
// let 이나 const키워드로 선언된 변수는 같은 스코프 내에서 중복 선언을 허용하지 않는다.
// let msg '안녕하세요';

/**2. 블럭 레벨 스코프
 * let 키워드로 선언한 변수는 모든 코드 블록(함수, if문, for문, while문, try,catch문)을 지역 스코프로 인정한다.
 * 
 */
let i = 0;
for(let i = 0; i < 10 ; i++){
    console.log(`지역변수 i : ${i}`);
    
}
console.log(`전역변수 i : ${i}`);

let x;

let y = 1;
if(true){
    //변수 호이스팅으로 아래의 지역변수 y선언이 먼저 일어났기 때문에 전역변수 y를 참조하지 않고 오류가 발생한다.
    console.log(y);
    let y = 2;
}

