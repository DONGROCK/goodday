//빌트인 전역 함수

/**isFinite 
 * 
 * 전달 받은 인수가 정상적인 유한수인지 검사하여 유한수이면 
 * true를 반환하고, 무한수이면 false를 반환한다.
 * 
 * 전달 받은 인수가 숫자가 아닌 경우 숫자로 타입 변환 후 
 * 검사를 수행하며, NaN으로 평가되는 값이면 false를 반환한다.

*/

console.log(isFinite(10)); // true
console.log(isFinite('10')); // true
console.log(isFinite(null)); // true
console.log(isFinite(Infinity)); // false
console.log(isFinite(-Infinity)); // false
console.log(isFinite(NaN)); // false
console.log(isFinite('abc')); // false

/**isNaN 
 * 
 * 전달 받은 인수가 NaN(Not a Number)인지 검사하여 그 검사 결과를 불리언 타입으로 반환한다.
 * 전달 받은 인수가 숫자가 아닌 경우 숫자로 타입 변환 후 검사를 수행한다.
    숫자로 표현 할 수 없어서
    Number: 숫자형태로 만들기 위한함수
    인자로 들어가 있는 값에 문자가 하나라도
     또는 숫자로 표현하지 못하는 경우에는 무조건 NaN반환


     */
console.log('--------------------');

console.log(isNaN(NaN)); // true
console.log(isNaN(10)); // false
console.log(isNaN('abc')); // true 숫자로 표현 할 수 없어서 
console.log(isNaN('10')); // false
console.log(isNaN('')); // false ('' => 0)
console.log(isNaN(true)); // false (true => 1)
console.log(isNaN(false)); // false (false => 0)
console.log(isNaN(undefined)); // true
console.log(isNaN({})); // true

console.log('--------------------');
// 숫자변환함수
// parseFloat
// parseInt

console.log(parseFloat('10.01')); // 10.01
console.log(parseFloat('10')); // 10
// 공백으로 구분 된 문자열은 첫 번째 문자열만 변환
console.log(parseFloat('10 20 30')); // 10  10이후를 버림
// 숫자가 아닌 문자열은 제외하고 변환
console.log(parseFloat('10cm')); // 10  cm를 표현하지 못하기에 10까지만 표현
// 첫 번째 문자열을 숫자로 변환할 수 없다면 변환 불가
console.log(parseFloat('GS25')); // NaN 
// 앞뒤 공백은 무시
console.log(parseFloat(' 1004 ')); // 1004 //자동트림
console.log(parseInt('10')); // 10
console.log(parseInt('10.01')); // 10 //인트로 표현하기에 .뒤를 버림

console.log(parseFloat('---------------'));

//URI 인터넷에 있는 자원을 나타내는 유일한 주소
/**encodeURI
 * URI(인터넷에 있는 자원을 나타내는 유일한 주소)를 문자열로 전달받아
 *  이스케이프 처리를 위해 인코딩한다.
 * 네트워크를 통해 정보를 공유할 때 어떤 시스템에서도
 *  읽을 수 있는 아스키 문자 셋으로 변환한다 */

/*?name=홍길동&job=student 쿼리스트링(from : action. method)
    get.  post. 방식이 있다.*/
    const uri = 'http://greedy.com?name=홍길동&job=student';
    const enc = encodeURI(uri);
    console.log(enc); // http://greedy.com?name=%ED%99%8D%EA%B8%B8%EB%8F%99&job=student
    const dec = decodeURI(enc);
    console.log(dec); // http://greedy.com?name=홍길동&job=student


//decodeURI
/**인코딩 된 URI를 인수로 전달 받아 이스케이프 처리 이전으로 디코딩한다 */
/*encodeURIComponent & decodeURIComponent */
const uriComp = 'name=홍길동&job=student';
const encComp = encodeURIComponent(uriComp);
console.log(encComp); // name%3D%ED%99%8D%EA%B8%B8%EB%8F%99%26job%3Dstudent
const decComp = decodeURIComponent(encComp);
console.log(decComp); // name=홍길동&job=student


