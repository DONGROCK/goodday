package com.ohgiraffers.section02.variable;

public class Application1 {
    public static void main(String[] args) {
        /*
        변수의 사용 목적

        1. 값에 의미를 부여하기 위해
        2. 한번 저장해둔 값을 재사용 하기 위해
        3. 시간에 따라 변하는 값을 저장하고 사용할 수 있다.(변하는 값을 저장하기 위한 공간이다)
         */

        int salary = 1000000;//변수 선언 및 할당
        int bonus = 200000;
        int point = 100;
        System.out.println("===값 의미 부여 테스트===");
        System.out.println("보너스를 포함한 급여:" + (1000000 + 200000)+"원");
        System.out.println("보너스를 포함한 급여:" + (salary + bonus)+"원");
        System.out.println("");
        System.out.println("===변수에 저장한 값 재사용 테스트===");
        System.out.println("1번 고객에게 포인트" + point + "포인트 지급됨");
        System.out.println("2번 고객에게 포인트" + point + "포인트 지급됨");
        System.out.println("3번 고객에게 포인트" + point + "포인트 지급됨");
        System.out.println("4번 고객에게 포인트" + point + "포인트 지급됨");
        System.out.println("");
        System.out.println("===변수에 저장된 값 변경 테스트===");
        int sum = 0;
        sum = sum + 10; //공간 = 0 + 10
        System.out.println("sum에 10을 더하면 현재 sum의 값은? " + sum);
        System.out.println("");
        sum = sum + 10; // 공간 = 10 + 10
        System.out.println("sum에 10이 생겼다 추가로 10을 더했다 sum의 값은? " + sum);

    }
}
