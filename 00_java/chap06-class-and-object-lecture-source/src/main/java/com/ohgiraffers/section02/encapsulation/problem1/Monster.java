package com.ohgiraffers.section02.encapsulation.problem1;

public class Monster {
    String name; //몬스터 이름
    int hp;     //몬스터 체력
    //전역변수
    public void setHp(int hp){
                //set 대부분의 수정
                //get 대부분 뭘 가져온다
        if(hp > 0 ){
            /*this는 인스턴스가 생성되었을 때 자신의 주소를 저장하는 레퍼런스 변수이다.
            * 지역변수와 전역변수의 이름이 동일한 경우 지역변수를 우선적으로 접근하기 때문에
            * 전역변수에 접근하기 위해서는 this.울 명시해야한다.*/
            System.out.println("양수값이 입력되어 몬스터와 체력을 입력한 값으로 변경합니다.");
            this.hp = hp;
        } else {
            System.out.println("0보다 작거나 같은 값이 입력되어 몬스터의 체력을 0으로 변경합니다.");
            this.hp = 0;
        }
    }
}
