package com.ohgiraffers.section02.assignment;

public class Application1 {

    /*
     *  대입연산자와 산술 복합 대입 연산자
     *  '='  : 왼쪽의 피연산자에 오른쪽의 피연산자를 대입함
     *  '+=' : 왼쪽의 피연산자에 오른쪽의 피연산자를 더한 결과를 왼쪽의 피연산자에 대입함
     *  '-=' : 왼쪽의 피연산자에 오른쪽의 피연산자를 뺀 결과를 왼쪽의 피연산자에 대입함
     *  '*=' : 왼쪽의 피연산자에 오른쪽의 피연산자를 곱한 결과를 왼쪽의 피연산자에 대입함
     *  '/=' : 왼쪽의 피연산자에 오른쪽의 피연산자를 나눈 결과를 왼쪽의 피연산자에 대입함
     *  '%=' : 왼족의 피연산자에 오른쪽의 피연산자를 나눈 나머지 결과를 왼쪽의 피연산자에 대입함
     * */
    public static void main(String[] args) {
        int num = 10;
        System.out.println("num : " + num);
        //3증가 시
        num = num + 3;
        System.out.println("num : " + num);

        num += 3;
        System.out.println("num : " + num);

        num -= 5;
        System.out.println("num : " + num);

        num *= 2;
        System.out.println("num : " + num);

        num /= 2;
        System.out.println("num : " + num);

        /*주의사항
        * 산술 복합 대입연산자의 작성 순서에 주의해야한다.
        * */

        //num =- 5; 이거 쓸때 는 왼쪽에 써야 한다. 이렇게 쓸 시에는 num = -5 라고 한 것이다.
        //System.out.println("num : "+ num);

    }
}
