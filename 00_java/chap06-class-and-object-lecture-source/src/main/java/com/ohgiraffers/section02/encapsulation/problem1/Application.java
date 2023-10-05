package com.ohgiraffers.section02.encapsulation.problem1;

public class Application {
    public static void main(String[] args) {

        /*1번 몬스터 생성*/
        Monster montser1 = new Monster();
        montser1.name ="두치";
        montser1.hp = 200;

        System.out.println("montser1.name = " + montser1.name);
        System.out.println("montser1.hp = " + montser1.hp);
        
        /*2번 몬스터 생성*/
        Monster monster2 = new Monster();
        monster2.name ="뿌꾸";
        monster2.hp = -200;

        System.out.println("monster2.name = " + monster2.name);
        System.out.println("monster2.hp = " + monster2.hp);
        
        Monster monster3 = new Monster();
        monster3.name ="드라큘라";
        monster3.setHp(300);

        System.out.println("monster3.name = " + monster3.name);
        System.out.println("monster3 = " + monster3.hp);
        
        Monster monster4 = new Monster();
        monster4.name = "드라큘라";
        monster4.setHp(-1000);

        System.out.println("monster4.name = " + monster4.name);
        System.out.println("monster4.hp = " + monster4.hp);
        
    }
}
