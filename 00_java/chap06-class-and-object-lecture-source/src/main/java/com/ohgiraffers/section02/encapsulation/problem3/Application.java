package com.ohgiraffers.section02.encapsulation.problem3;

public class Application {
    public static void main(String[] args) {
        
        Monster monster1 = new Monster();
        monster1.setInfo("뜨라큘라");
        monster1.setHp(200);

        Monster monster2 = new Monster();
        monster2.setInfo("팬돌이");
        monster2.setHp(400);

        Monster monster3 = new Monster();
        monster3.setInfo("슈렉");
        monster3.setHp(30);

        System.out.println("monster1.getInfo() = " + monster1.getInfo());
        System.out.println("monster2.getInfo() = " + monster2.getInfo());
        System.out.println("monster3.getInfo() = " + monster3.getInfo());
        
        monster3.kinds = "뚜치";
        monster3.hp = -500;

        System.out.println("monster3.kinds = " + monster3.kinds);
        System.out.println("monster3.hp = " + monster3.hp);
    }
}
