package com.ohgiraffers.parameter;

public class Application {

    public static void main(String[] args) {

        /*
        * 메소드의 파라미터에 대한 이해
        * --> 메소드의 파라미터 선언부에는 다양한 종류의 값을 인자로 전달해서 호출할 수 있다.
        *
        * 매개변수(parameter)로 사용 가능한 자료형
        * 1. 기본자료형
        * 2. 기본자료형 배열
        * 3. 클래스자료형
        * 4. 클래스자료형 배열
        * 5. 가변인자
        * */
        ParameterTest pt = new ParameterTest();

        /*1. 기본자료형을 매개변수로 전달받는 메소드*/
        /*기본자료형 8가지 모두 가능하다.*/
        int num = 20;

        pt.testPrimaryTypeParameter(num);
        /*2. 기본자료형 배열을 매개변수로 전달받는 메소드*/
        int[] iarr = {1,2,3,4,5};

        System.out.println("인자로 전달하는 값 : " + iarr);

        pt.testPrimaryArrayParameter(iarr);

        System.out.print("변경 후 원본배열의 값 출력 : ");
        for (int i = 0; i < iarr.length; i++) {
            System.out.print(iarr[i] + " ");
        }
        System.out.println();

        /*3. 클래스 자료형*/
        RectAngle r1 = new RectAngle(12.5, 22.5);

        System.out.println("인자로 전달하는 값 : " + r1);
        pt.testClassTypeParameter(r1);

        System.out.println("변경 후 사각형의 넓이와 둘레==========");
        r1.calcArea();
        r1.calcRound();

        /*4. 클래스 자료형 배열은 뒤에서*/

        /*5. 가변인자
        *    인자로 전달하는 값의 갯수가 정해지지 않는 경우에 가변배열을 활용할 수 있다.
        * */
//        pt.testVariableLengthArrayParameter(); // 에러남 // 인자가 아무것도 없는 경우 에러발생
        pt.testVariableLengthArrayParameter("홍동길"); //가변인자는 전달하지 않아도 된다.
        pt.testVariableLengthArrayParameter("이순신","대포쏘기");
        pt.testVariableLengthArrayParameter("유관순", "산책", "만세","강아지산책");
        pt.testVariableLengthArrayParameter("신사임당");
    }



}
