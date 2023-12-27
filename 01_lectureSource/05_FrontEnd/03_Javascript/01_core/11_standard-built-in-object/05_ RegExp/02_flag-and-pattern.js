/**RegExp-method */
const target = 'Java JavaScript';

/*RegExp.prototype.exec
    인수로 전달받은 문자열에 대해 정규표현식의 패턴을 검색하여 매칭 결과를 배열로 반환
    */

console.log(/va/.exec(target)); //input 타겟에 대해
console.log(/va/g.exec(target)); //  /va/g. 전역에 대해
console.log(/hello/g.exec(target)); //  /hello/에 대한 값이 없어서 null로 표시

console.log(/va/.test(target)); // true 는 존재할시
console.log(/hello/.test(target)); // false 는 존재하지 않을시

//String.prototype.match
console.log(target.match(/va/)); // 배열형식으로 리턴
console.log(target.match(/va/g)); // 배열형식으로 리턴
console.log(target.match(/hello/g)); // null

