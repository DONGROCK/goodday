package com.ohgiraffers.section01.array;

public class Application5 {

    public static void main(String[] args) {

        /*랜덤한 카드를 한장 뽑아서 출력.*/
        String[] shape = {"SPADE", "CLOVER", "HEART", "DIAMOND"};
        String[] cardNumbers = {"2","3","4","5","6", "7", "8", "9" ,"10","J","Q","K","A"};

        int randomShapeIndex = (int) (Math.random() * shape.length);
        int randomCardNumberIndex = (int) (Math.random() * cardNumbers.length);

        System.out.println("당신이 뽑은 카드는 : " + shape[randomShapeIndex] + " " + cardNumbers[randomCardNumberIndex] + " 카드입니다.");

    }
}
