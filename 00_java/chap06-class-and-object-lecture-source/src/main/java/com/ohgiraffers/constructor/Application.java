package com.ohgiraffers.constructor;

public class Application {
    public static void main(String[] args) {

        /*
        * 자료형 변수명
        * int i;
        * Mamber member
        * 클래스 레퍼런스 변수 = new 클래스명();
        *
        * --> 클래스 레퍼런스 변수 = new 생성자();
        *
        * ()--> 메소드 new 뒤에 클래스명은 사실상 생성자(Constructor)라 불리는 메소드를 호출하는 구문이다.
        *
        * 생성자란?
        * 인스턴스를 생성할 때 초기 수행할 명령이 있는 경우 미리 작성해두고, 인스턴스를 생성할 때 호출된다.
        * 생성자 함주에 매개변수가 없는 생성자를 기본생성자(default constructor)라고 하며,
        *
        * 기본생성자는 comfiler에 의해 자동으로 추가되기 때문에 지금까지 명시적으로 작성하지 않고 사용할 수 있었다.
        *
        *
        * 기본생성자를 이용해서 인스턴스를 생성하게 되면 자바에서는 자료형별 초기값을 이용해서 필드를 초기화
        * 필드 초기값 사용자가 원하는대로 설정하고 싶은 경우 생성자의 호출 시 인자로 값을 전달해서 호출할 수 있다.
        * 이러한 인자를 받아 필드를 초기화 할 목적의 생성자를 매개변수 없는 생성자라고 한다.
        *
        *
        * 하지만 매개변수 있는 생성자가 한 개라도 존재하는 경우 comfiler는 기본생성자를 자동으로 추가해주지 않으니
        * 사용 시 주의해야한다.
        * */

        User user1 = new User();// 객체 생성
        System.out.println(user1.getInformation());

        User user2 = new User("user01", "pass01", "홍길동");
        System.out.println(user2.getInformation());

        User user3 = new User("user02", "pass02","홍길돈",new java.util.Date());
        System.out.println(user3.getInformation());

        User user4 = new User(user3);
        System.out.println(user4.getInformation());
    }

}
