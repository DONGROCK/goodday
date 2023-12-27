/**중첩함수
 * 
 * 함수 내부에 정의된 함수를 중첩 함수 또는 내부함수라고한다.
 * 중첩 함수를 포함하는 함수는 외부함수라고 한다.
 * 일반적으로 중첩함수는 자신을 포함하는 외부 함수를 돕는 헬퍼 함수의 역할을 한다.
 */

function outer() {
    var outerVal = '외부함수';

    function inner(){

        var innerVal = '내부함수';
        //외부 함수의 변수를 참조할 수 있따.
        console.log(outerVal, innerVal);
        

    }
    inner();
}
outer();
