package com.ohgiraffers.section02.userexception;

import com.ohgiraffers.section02.userexception.exception.PriceNegativeException;

public class Application3 {
    public static void main(String[] args) {

        /*
        * multi-catch블럭
        * 동일한 레벨의 다른 타입의 예외를 하나의 catch블럭으로 처리
        * JDK 1.7에서 추가된 구문
        * */

        ExceptionTest et = new ExceptionTest();
        try {
            et.checkEnoughMoney(20000, 10000);
        } catch (PriceNegativeException | MoneyNegativeException e) {
            /*
            * 예외클래스명, 예외발생 위치, 예외메세지 등을 stack 호출 역순으로
            * 빨간색 글씨를 이용해서 로그 형태로 출력해주는 기능
            * */
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println(e.getCause()); // 발생한 예외클래스의 이름을 알 수 있다.
        }
         catch (NotEnoughMoneyException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("finally 블럭의 내용이 동작함");
        }
    }
}
