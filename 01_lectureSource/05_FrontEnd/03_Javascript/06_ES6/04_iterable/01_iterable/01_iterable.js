// 01 iterable and array-lik (이터러블과 유사배열)

/**
 * 이터러블(iterable) : 메서드 Symbol.iterator가 구현된 객체
 * 유사배열(array-like) : 인덱스와 length 프로퍼티가 있어서 배열처럼 보이는 객체
 * 이터러블이면서 유사배열일 수 있고 이터버블 객체라고 해서 유사 배열 객체는 아니며 유사배열 객체라고 해서
 * 이터러블 객체인 것도 아니다. ==> 별도의 개념
 * 
 * 이터러블과 유사배열은 배열 메서드를 사용할 수 없어 불편할 때가 있는데
 *  Array.from을 이용해서 배열로 변경할 수 있따.
 * 
 * ES6이전에 순회 가능한 데이터 컬렉션 배열, 문자열, 유사배열객체, DOM 컬랙션 --> for문, for..in문, forEach
 * 
 */

let arrayLike = {
    0: "배열인듯",
    1: "배열아닌",
    2: "배열같은너",
    length: 3,
};

// console.log(arrayLike.pop());
//Array.from()은 넘겨 받은 인수가 이터러블이나 유사배열인 경우, 새로운 배열을 만들고 객체의 모든 요소를 새롭게 만든 배열로 복사한다.
let arr = Array.from(arrayLike); // 배열로 만들어버리기

console.log(arrayLike);
console.log(arr.pop());

//이터러블(iterable)은 메서드 Symbol.iterator 가 구현된 객체이다.
let range = {
    from: 1,
    to: 5,
};

//for.if 최초 호출시, Symbol.iterator가 호출된다.
range[Symbol.iterator] = function(){
    
    //Symbol.iterator가 호출된다.
    return{
        current: this.from,
        last: this.to,
        // for..of 반복문에 의해 반복마다 next()가 호출된다.
        next(){
            if(this.current <= this.last){
                return{ done: false, value: this.current++};
            } else{
                return{done: true};
            }
            
        },
    };
};

let arr2 = Array.from(range);
console.log(arr2);
console.log(arr2.pop());

//Array.from()에는 매핑(mapping) 함수를 선택적으로 넘겨줄 수 있다.
let arr3 = Array.from(range, (num) => num*num);
console.log(arr3);

for(let num of range){
    console.log(num);
    
}