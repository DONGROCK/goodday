//Rest parameter(나머지 매개변수)
function merge(msg1, msg2){
    return msg1 + msg2;
}

console.log(merge('안녕하쇼'));
console.log(merge('안녕하세요','반가워요'));
console.log(merge("안녕하세요",'반갑습니다','나는길동이다'));

/*
    함수에 정의 된 인수는 2개이고 정해진 인수보다 적게 전달되면 undefined,
     정해진 인수보다 많이 전달 되면 해당 인수를 무시하고 기능이 동작한다.
     --> 이때 나머지 매개변수(...)를 사용하면 매개변수를 한데 모아 배열에 담을 수 있따.

*/

function mergeAll(...args){
    let message = '';

    for(let arg of args) message += arg;

    return message;
}

console.log(mergeAll('아령하세요'));
console.log(mergeAll('아령하세요','아령또하세요'));
console.log(mergeAll('아령하세요','아령또하세요','제이름은 아령 입니다.'));

/*
    나머지 매개변수는 항상 마지막에 있어야한다.
    function func(arg1, ...args, arg2){} X
    function func(arg1, arg2, ...args){} O

*/

