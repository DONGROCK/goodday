package com.ohgiraffers.section01.exception;

public class ExceptionTest {
    public void CheckEnoughMoney(int price, int money) throws Exception {

        System.out.println("돈 :" + money);

        if(money >= price){
            System.out.println("상품을 구입하기 위한 금액이 충분하다.");
        }else {
            /*강제로 예외발생*/
            throw new Exception();
        }

        System.out.println("즐거운 쇼핑하세요");
    }
}
