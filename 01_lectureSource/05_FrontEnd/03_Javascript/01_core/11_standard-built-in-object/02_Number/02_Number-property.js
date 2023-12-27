/**Number-property */
//자바스크립트에서 표현할 수 있는 가장 큰 양수 값
console.log(Number.MAX_VALUE);// 1.7976931348623157e+308
console.log(Number.MAX_VALUE * Number.MAX_VALUE);// 
console.log(Infinity > Number.MAX_VALUE); // 무한대가 크다

console.log('---------------');
//자바스크립트에서 표현할 수 있는 가장 작은 양수 값
console.log(Number.MIN_VALUE); // 5e-324
console.log(Number.MIN_VALUE > 0); // 0보다 크다

console.log('----------------');
//자바스크립트에서 안전하게 표현할 수 있는 가장 큰 정수 값
console.log(Number.MAX_SAFE_INTEGER); // 9007199254740991
//자바스크립트에서 안전하게 표현할 수 있는 가장 작은 정수 값
console.log(Number.MIN_SAFE_INTEGER); // -9007199254740991

//양의 무한대를 나타내는 숫자값 Infinity와 같다
console.log(Number.POSITIVE_INFINITY); // Infinity
//음의 무한대를 나타내는 숫자값 -Infinity와 같다
console.log(Number.NEGATIVE_INFINITY); // -Infinity

//숫자가 아님을 나타내는 숫자값
console.log(Number.NaN); // NaN

console.log('------------------');
//Number.EPSILON : 부동 소수점으로 인해 발생하는 오차를 해결하기 위해 사용
console.log(Number.EPSILON);
console.log(0.1 + 0.2);
console.log(0.1 + 0.2 === 0.3) ;
console.log(isEqual(0.1+0.2, 0.3));

function isEqual(a,b){
    //a - b 의 절대 값ㅅ이 Number.EPSILON이 보다 작으면 작은수로 인정한다.
    return Math.abs(a - b) < Number.EPSILON;
}


