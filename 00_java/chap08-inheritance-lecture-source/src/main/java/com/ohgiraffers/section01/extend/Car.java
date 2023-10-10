package com.ohgiraffers.section01.extend;

public class Car {
//모든클래스는 Object를 상속받는다.. !! 놀랍다!!

    /*자동차가 달리는상태를 확인할수 있는 코드*/

    private boolean runningStatus;

    /*기본생성자*/
    public Car(){

        System.out.println("Car 클래스의 기본 생성자 호출됨..");
    }

    public void run(){  //주행
        runningStatus = true;
        System.out.println("자덩차가 달립니다.");
    }

    public void soundHorn(){    //경적
        if (isRunning()){
            System.out.println("빵!빵!");
        }else {
            System.out.println("주행중이 아닌 상태에서는 빵 ㄴㄴ.");
        }
    }

    protected boolean isRunning() {   //달리고 있니??
    //프로텍티드는 상속
        return runningStatus;
    }

    public void stop(){    //멈춤
        runningStatus = false;
        System.out.println("자동차가멈춥니다..");
    }

}
