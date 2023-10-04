package com.ohgiraffers.section01.array;

public class Application3 {
    public static void main(String[] args) {

        /*배열에 초기화되는 자료형별 기본값 이해
        *
        * 기억!
        * 기본적으로 배열을 선언하고 할당하게되면
        * 배열의 각 인덱스에는 자바에서 지정한 기본값으로 초기화된 상태이다.
        * -> heap영역은 값이 없는 빈 공간이 존재할 수 없다.
        * */

        /*값의 형태 별 기본값
        * 정수 : 0
        * 실수 : 0.0
        * 논리 : false
        * 문자 : \u0000
        * 참조 : null*/

        int[] iarr = new int[5];
        System.out.println("iarr[0] : " + iarr[0]);
        System.out.println("iarr[0] : " + iarr[1]);
        System.out.println("iarr[0] : " + iarr[2]);
        System.out.println("iarr[0] : " + iarr[3]);
        System.out.println("iarr[0] : " + iarr[4]);

        for (int i = 0 ; i < iarr.length; i++) {
            System.out.println("iarr[" + i + "]의 값 : " + iarr[i]);
        }

    /*자바에서 지정한 기본값 외의 값으로 초기화를 하고싶은 경우 블럭을 이용한다.
    * 블럭을 사용하는 경우에는 new 를 사용하지 않아도 되며, 값의 갯수만큼 자동으로 크기가 설정된다.*/

        int[] iarr2 = {11,22,33,44,55};

        //이러한 형식으로도 가능
        int[] iarr3 = new int[]{1,2,3,4,5};

        System.out.println("iarr2 의 길이 : " + iarr2.length);
        System.out.println("iarr3 의 길이 : " + iarr3.length);

        for (int i = 0; i < iarr2.length; i++){
            System.out.println("iarr2[" + i + "] : " + iarr2[i]);
        }

        /*문자열도 배열로 사용할 수 있다.*/
        //String[] sarr = new String[5];

        //System.out.println(sarr[0].length());
        String[] sarr = {"apple", "banana", "grape", "orange"};
        System.out.println("sarr의 길이 : " + sarr.length);
        System.out.println("sarr[0] : " + sarr[0]);
        System.out.println("sarr[0].length : " + sarr[0].length());
    }
}
