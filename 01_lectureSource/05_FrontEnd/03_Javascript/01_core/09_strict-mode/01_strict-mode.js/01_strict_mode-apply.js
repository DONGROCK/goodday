/**엄격모드 전용
 *  전역의 선두 또는 함수 몸체의 선두에 'use strict'; 를추가한다.
 * 
 * 전역의 선두에 추가하면 스크립트 전체에 strict moder가 적용된다.
 * 
*/
// 'use strict';

function test (){
    // 'use strict';
    x = 10;
    //코드의 선두에 위치시키지 안으면 strict mode가 제대로 동작하지 않는다.
    //'use strict';
}
    test();

    console.log(x);
    /**
     * 전역에 strict mode를 적용하면 스크립트 단위로 적용되어 strict mode 와 non-strict mode의
     * 혼용으로 인한 오류가 발생할 수 있으니 유의하다.
     * 
     * <script>
     *  'use strict';
     * </script>
     * <script>
     *  x = 10; // 에러가 발새앟지 않는다.
     * </script>
     */

    /**
     * 서드파티 라이브러리가 non-strict mode인 경우 즉기 실행함수로
     * 스크립트 전체를 감싸서 스코프를 구분하고 즉시 실행함수의 선두에 strict mode를 적용한다.
     *
     */
    