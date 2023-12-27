/**반환문 */
function hello(name){

    //반환문
    return `${name}님 안녕하신가요 ㅋㅋ`;
    //반환문 이후의 문은 실행되지 않고 무시된다.
    console.log(name);
}

console.log(hello('동락'));

function func(){
    console.log('함수가 호출되었습니다.')
    //반환값을 명시적으로 지정하지 않으면 undefined가 반환된다.
    return; // 반환문은 생략할 수도 있다. 이때 암묵적으로 undefined가 반환된다
}

console.log(func()); 
