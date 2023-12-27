package com.ohgiraffers.section01.polymorphism;

import javax.swing.event.AncestorListener;

public class Application1 {

    /*다형성
    * 다형성이란 하나의 인스턴스가 여러 가지 타입을 가질 수 있는 것을 의미
    * 그렇기 떄문에 하나의 타입으로 여러 타입의 인스턴스를 처리할 수 있기도 하고,
    * 하나의 메소드 호출로 객체별로 각기 다른 방법으로 동작하게 할 수도 있다.
    *
    *
    * 다형성은 객체지향 프로그래밍의 3대 특징(캡슐화, 상속, 다형성) 중 하나이며,
    * 객체지향 프로그래밍의 꽃이라고 불리울 정도로 활용성이 높고 장점이 많다.
    * 하지만 학습하기 어렵다는 단점을 가지고 있따..*/

    /*Car라는 클래스 : 부모클래스
    * FireCar, RacingCar : 자식클래스
    *
    * FireCar, RacingCar를 두개를 각각 인스턴스로 생성했다고 해보자.
    *
    * FireCar의 타입은 FireCar이면서 Car라는 타입이기도 하다.
    * RacingCar의 타입은 RacingCar이면서 Car라는 티입이가도 하지.
    * */

    public static void main(String[] args) {
        System.out.println("----------Animal 생성 !!---------");
        Animal animal = new Animal();
        animal.eat();
        animal.run();
        animal.cry();

        System.out.println("----------Rabbit 생성 !!---------");
        Rabbit rabbit = new Rabbit();
        rabbit.eat();
        rabbit.run();
        rabbit.cry();
        rabbit.jump();

        System.out.println("----------Tiger 생성 !!---------");
        Tiger tiger = new Tiger();
        tiger.eat();
        tiger.run();
        tiger.cry();
        tiger.bite();

        /*부모 타입으로 자식 인스턴스 주소값 저장*/
        Animal a1 = new Rabbit();
        Animal a2 = new Tiger();

        /*하지만 반대로 Animal은 Animal이며 Tiger, Rabit이 아니다.*/
//        Rabbit r = new Animal();
//        Tiger t = new Animal();

        /*동적바인딩
        * 컴파일 당시에는 해당 타입의 메소드와 연결되어 있다가,
        * 런타임 당시 실체 객체가 가진 오버라이딩 된 메서드로 바인딩되어 바뀌어서 동작하는 것을 의미*/
        System.out.println("--------동적 바인딩---------");
        a1.cry();
        a2.cry();
        System.out.println("Tiger hashcode : " + tiger.hashCode());
        System.out.println("a2 hashcode : " + a2.hashCode());
        System.out.println("Animal hashcode : " + animal.hashCode());
//        a1.jump(); a1, a2의 레퍼런스 타입은 Animal 타입이다.
//        a2.bite();

        /*객체별로 고유한 기능을 동작시키기 위해서는 레퍼런스 변수를 혀변환하여 Rabbit과 Tiger로 변경해야
        * 메소드 호출이 가능하다.
        * class type casting : 클래스 형변환
        * 타입 형변환 시 실제 인스턴스와 타입이 일치하지 않는 경우 ClassCastExcption발생할수도있다.
        * */
        System.out.println("클래스타입 형변환 확인 =========");
        ((Rabbit) a1).jump();//부모클래스에서 자식클래스로 형변환하는게 다운캐스팅
        ((Tiger) a2).bite();

            /*
            * 타입형변환을 잘못하는 경우
            * 컴파일시 문제가 되지는 않지만 런타임시 ClassCastExcption
            * */
//        ((Tiger) a1).bite();//이거는 a1 토끼에는 깨물기가 없기에 에러.

        /*instacneof 연산자
        * 레퍼런스변수가 참조하는 실제 인스턴스가 원하는 타입과 같은지 비교하는 연산자*/

        System.out.println("instancmeof 확인 ===========");
        System.out.println("a1이 Tiger 타입인지 확인 : " + (a1 instanceof Tiger));
        System.out.println("a1이 Rabbit 타입인지 확인 : " + (a1 instanceof Rabbit));

        System.out.println("a1이 Animal 타입이야? : " + (a1 instanceof Animal));
        System.out.println("a1이 Object 타입이야? : " + (a1 instanceof Object));

        System.out.println("=====if=======");
        if (a1 instanceof Rabbit){
            ((Rabbit) a1).jump();
        }

        if (a1 instanceof Tiger){
            ((Tiger) a1).bite();
        }else {
            System.out.println("응아냐");
        }


//        if (a1 instanceof Object){  //항상 true 이기 때문 에러발생
//            ((Tiger) a1).bite();
//        }

        /*클래스의 업캐스팅 다운캐스팅
        * 클래스 형변환은 업캐스팅과 다운캐스팅으로 구분
        * 업캐스팅 : 상위타입으로 형변환 ( 자식 -> 부모 )
        * 다운캐스팅 : 하위타입으로 형변환( 부모 -> 자식 )
        * */

        Animal animal1 = (Animal) new Rabbit(); // 명시적 형변환 (업캐스팅)
        Animal animal2 = new Rabbit(); //묵시적 형변환 (업캐스팅)

        Rabbit rabbit1 = (Rabbit) animal1; // 명시적 형변환 (다운캐스팅)

//        Rabbit rabbit2 = animal1; //  다운캐스팅에서는 묵시적 형변환이 안됌


    }
}
