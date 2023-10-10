package com.ohgiraffers.section01.extend;

public class FireCar extends Car {
    /*
    * Car클래스를 부모클래스로 FireCar를 자식클래스로 사용하면
    * 클래스 선어부에 extends Car를 추가해서 상속을 받는다.
    *
    * FireCar는 부모클래스인 Car가 가지고있는 몯느맴버를 상속받는다..
    * 단, 부모가 가지고 있는 private맴버, 생성자는 상속 받지 못함..*/
    public FireCar(){
        /* 모든 생성자에는 맨 첫줄에 super()를 컴파일러가 자동 추가한다.*/
        /* 부모의 기본생성자를 호출하는 구문이다...
         * 명시적, 묵시적 전부 사용 가능하다..*/
        super();
        //super(false); 부모클래스가 기본생성자가 없을 경우 호출방법,,
        //super(true);
        System.out.println("FireCar 클래스의 기본생성자 호출됨");
    }

    @Override
    public void soundHorn() {
//        super.soundHorn();여기서 super.은 부모의 인스턴스의 주소값
        if (isRunning()){//this. , super. 둘다 사용가능 그냥 쓰면 this.으로 컴파일러가 인식

            System.out.println("뿡뿌루빵빵뿌룩부룩방방북부룩");
        }else {
            System.out.println("소방자가 앞으로 갈 수 없습니다~ 비켜주세요~");
        }
    }

    public void sprayWater(){
        System.out.println("불난 곳을 발견했습니다. 물뿌립니다. <************");
    }
//상속받은 메서드재정의
    /*오버라이딩
    *
    * @ Override 어노테이션
    * JDK 1.5부터 추가된 문법으로 오버라이딩 성립요건을 체크하여 성립되지 않는 경우 컴파일 에러를 발생시킨다.
    * (오버라이딩이 정상적으로 작성된 것인지를 체크해주는기능)
    *
    * 오버라이딩 하는 메소드는 기본적으로 부모 메소드 선언 내용을 그대로 작성해야 한다.*/

}
