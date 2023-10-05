package com.ohgiraffers.section02.encapsulation.problem2;

public class Application {
    public static void main(String[] args) {

        /*필드의 이름이나 자료형을 변경할 떄 사용한 쪽 모두 코드를 수정해야 하는 경우가 생긴다.*/

//        Monster monster1 = new Monster();
//        monster1.name = "드라큘라";
//        monster1.hp = 200;
//
//        Monster monster2 = new Monster();
//        monster2.name = "원슈타인";
//        monster2.hp = 300;
//
//        Monster monster3 = new Monster();
//        monster3.name = "로켓단";
//        monster3.hp = 3000;
//
//        System.out.println("monster1.name = " + monster1.name);
//        System.out.println("monster1.hp = " + monster1.hp);

        /*단순히 Monster 클래스의 필드 name을 kinds로 바꿨을 뿐인데
        * Apptilcation클래스에서 직접 name필드에 접근하는 코드는 전부 컴파일 에러를 발생시킨다.
        *
        * 즉, Monster클래스의 일부를 수정한 것인데 사용하는곳에서는 전부 함께 수정을 해야하는 부담이 생긴다.
        * 이것은 유지보수에 악영향을 끼침..*/


    }
}
