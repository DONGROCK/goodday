package com.ohgiraffers.section02.userexception;

import com.ohgiraffers.section02.userexception.exception.PriceNegativeException;

import java.rmi.server.ExportException;

public class Application2 {

    public static void main(String[] args) {

        ExceptionTest et = new ExceptionTest();


        try {
            et.checkEnoughMoney(60000,-90000);
        } catch (PriceNegativeException e) {
            //가격이 음수
            throw new RuntimeException(e);
        } catch (MoneyNegativeException e) {
            //돈이 음수
            throw new RuntimeException(e);
        } catch (NotEnoughMoneyException e) {
//            throw new RuntimeException(e);
            //가진돈이 상품보다 적을 때
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("MotEnoughMoneyException 발생");
        } finally {
            System.out.println("finally 블럭의 내용이 동작함");
        }

        /*디테일한 예외 상황별로 처리 로직을 다르게 할수있다.
        * 이 때 주의해야할 점은 catch블럭은 위에서부터 아래로 자신의 타입과 맞는 경우 동작하기 때문에
        * 상위 타입이 위쪽으로 오게되는 겨우에는 하단에 작성한 코드는 절대 도달 할 수 없는 코드가 되므로 컴파일 에러를 발생시킨다.
        * */

    }
}
