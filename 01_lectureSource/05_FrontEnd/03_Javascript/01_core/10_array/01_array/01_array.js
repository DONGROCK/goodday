/*01_array
배열은 여러 개의 값은 순차적으로 나열한 자료구조이다.
*/

//1. 배열 리터럴을 통해 배열 생성
// 배열이 가직 ㅗ있는 값을 요소라 부르며 자바스크립트의 모든 값은 배열의 요소가 될 수 있따.
const arr = ['바나나','복숭아','키위','수박'];
console.log(arr);

// 2. 배열 생성자 함수
const arr2 = new Array();
console.log(arr2);

//전달된 인수가 1개이고 숫자인 경우 length프로퍼티 값이 인수인 배열을 생성
const arr3 = new Array(11);
console.log(arr3);
const arr4 = new Array(1,2,3);
console.log(arr4);

//3. Array.of 메소드
//전달된 인수를 요소로 갖는 배열을 생성
console.log(Array.of(10));
console.log(Array.of(1, 2, 3));
console.log(Array.of('hello','js'));

console.log(arr[0]);
console.log(arr[1]);
//배열은 요소의 갯수, 즉 배열의 길이를 나타내는 length프로퍼티를 갖는다.
console.log(arr.length);

for(let i = 0; i < arr.length; i++){
    console.log(arr[i]);
}

console.log(typeof arr);
/*
일반객체와 배열은 값의 순서와 length프로퍼티 유무에서 차이가 있따.
인덱스로 표현되는 값의 순서와 length 프로퍼티를 갖는 배열은 반복문을 통해
순차적으로 값에 접근하기 적합한 자료구조이다.
배열의 장점은 청므부터 순차적으로 요소에 접근할수도 있고,
마지막부터 역순으로 요소에 접근할 수도 있으므로 특정 위치부터 순차적으로 요소에 접근할 수도 있다는 것이다.

*/
