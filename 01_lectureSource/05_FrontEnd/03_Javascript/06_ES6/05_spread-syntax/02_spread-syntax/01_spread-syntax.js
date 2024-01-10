/* spread-syntax(스프레드 문법, 전개 문법)

    rest parameter처럼 매개변수 목록을 배열로 가져오는 것과는 반대로 배열을 통째로 매개변수에 넘겨주는 기능이다.

    하나로 뭉쳐 있는 여러 값들의 집합을 전개해서 개별적인 값들의 목록으로 만든다.
    사용 대상은 for..of문으로 순회할 수 있는 이터러블에 한정된다.

*/

console.log(`가장 큰 값 : ${Math.max(10,30,20)}`);

let arr = [10,30,20];
//배열로 들어가서 값이 출력안댐
console.log(`가장 큰 갑: ${Math.max(arr)}`);

/*
    Math.max()는 배열이 아닌 숫자 목록을 인수로 
    받기 때문에 배열의 경우 원하는 대로 동작하지 않는다.
    이와 같은 경우 스프레드 문법을 사용할 수 있다.
    함수를 호출할 때 ...arr을 사용하면 arr이 인수 목록으로 확장된다.
    */

    console.log(`가장 큰 값 : ${Math.max(...arr)}`);
    
let arr1 = [12,20,3];
let arr2 = [12, 31, 8];

//배열 객체 여러 개 전달 가능
console.log(`가장 작은 값 : ${Math.min(...arr1, ...arr2)}`);

// 일반 값 과 혼합해서 사용 가능
console.log(`가장 작은 값 : ${Math.min(...arr1, 2, ...arr2, 3)}`);

let merged = [0, ...arr1, ...arr2];
console.log(merged);

let str = 'Javascript';

console.log([...str]);// 문자열을 배열로 변환
console.log(Array.from(str));
//Array.from()도 동일하게 가능하지만 Array.from()은 이터러블 객체 뿐만 아니라
//  유사 객체배열에서 사용할 수 있어서 보편적으로 사용한다.

