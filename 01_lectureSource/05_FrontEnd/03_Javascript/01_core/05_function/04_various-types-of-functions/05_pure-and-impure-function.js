/*순수함수 비순수 함수
    순수함수: 외부 상태에 의존하지 않고 변경하지도 않는 함수
    비순수함수: 외부 상태에 의존하거나 외부상태를 변경하는 함수
    */
   var cnt = 0;
   
   //순수 함수는 최소 하나 이상의 인수를 전달 받으며 인수의 불변성을 유지한다.
   function increase(n){
    return ++n;
   }

   //순수함수가 반환한 결과값을 변수에 재할당해서 상태를 변경
   cnt = increase(cnt);
   console.log(cnt);

   // 비순수함수
   function decrease(){
    return --cnt;
   }
   cnt = decrease();
   console.log(cnt);