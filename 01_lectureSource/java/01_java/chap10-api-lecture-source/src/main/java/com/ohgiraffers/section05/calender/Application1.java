package com.ohgiraffers.section05.calender;

import java.util.Date;

public class Application1 {
    public static void main(String[] args) {

        /*
        * Date 클래스
        * JDK1.0 부터 날짜를 취급하기 위해 사용되던 Date클래스를
        * 생성자를 비롯하여 대부분의 메소드가 Deprecated되어있다.
        *
        * Deprecated란?
        * 향후 버전이 업데이트 되면서 사라지게 될 기능이니 가급적이면 사용을 권장하지 않는다는 의미.
        * 하지만 하위 버전의 호환성 때문에 한 번에 제거된 것은 아니고 남겨두었기에 사용은 가능하다.
        * */
        Date today = new Date();

        System.out.println("today : " + today);

        /*Date(Long date)
        * 1970년 1월 1일 0시 0분 0초 이후 지난 시간을 millisecond로 계산해서 long타입으로 반환
        *
        * 1초 : 1000밀리세컨드
        * 1분 : 1000 * 60
        * 1시간 : (1000 * 60) * 60
        * 24시간 : (1000 * 60) * 60 * 24
        * */
        System.out.println(today.getTime());

        Date time = new Date(1697097942273L);
        System.out.println(time);


    }
}
