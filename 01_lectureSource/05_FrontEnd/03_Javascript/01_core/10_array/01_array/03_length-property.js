/**length property */

//length 프로퍼티는 요소의 갯수를 나타내는 0이상의 정수를 값으로 갖는다.
console.log([].length);
const arr = [1,2,3,4,5];
console.log(arr.length);

arr.push(6);
console.log(arr);
console.log(arr.length);

arr.pop();              //pop : 마지막 요소 제거
console.log(arr);
console.log(arr.length);

//length프로퍼티에 임의의 숫자값을 명시적으로 할당할 수도 있따.
//현재 length 프로퍼티보다 작은 숫자 값을 할당하면 배열의 길이가 줄어든다.
arr.length = 10;              //pop : 마지막 요소 제거
console.log(arr);
console.log(arr.length);
console.log(Object.getOwnPropertyDescriptors(arr));

const sparse = [,2,,4];
console.log(sparse);
console.log(sparse.length);
console.log(Object.getOwnPropertyDescriptors(sparse));

