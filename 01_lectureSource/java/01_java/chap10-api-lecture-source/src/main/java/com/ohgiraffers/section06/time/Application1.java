package com.ohgiraffers.section06.time;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Application1 {
    public static void main(String[] args) {
            /*time 패지는 JDK 1.8에서 추가된 기능이다.
Date, Calendar가 가지고 있는 단점을 해소하기 위해서 탄생되었다.
time 패키지의 하위 패키지
java.time
 ㄴjava.time.chrono : ISO-8601에 정의된 달력 시스템을 위한 클래스들을 제공한다.
 ㄴjava.time.format : 날짜와 시간 파싱과 형식에 대한 클래스 제공
 ㄴjava.time.temporal : 날짜와 시간 필드와 단위 관련 클래스 제공
 ㄴjava.time.zone : 시간대에 관련된 기능 제공
 LocalTime, LocalDate, LocalDateTime, ZonedDateTime 클래스들이 있다.
 */  //hh 12시간  HH24시간 이랍니다.

        LocalTime  timeNow = LocalTime.now();
        LocalTime timeOf = LocalTime.of(18, 30, 11);

        System.out.println("timeNow = " + timeNow);
        System.out.println("timeOf = " + timeOf);

        LocalDate dateNow = LocalDate.now();
        LocalDate dateOf = LocalDate.of(2040,4,14);
        
        System.out.println("dateNow = " + dateNow);
        System.out.println("dateOf = " + dateOf);

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        ZonedDateTime zonedDateTimeOf = ZonedDateTime.of(dateOf, timeOf , ZoneId.of("Asia/Seoul"));
        System.out.println("zonedDateTime = " + zonedDateTime);
        System.out.println("zonedDateTimeOf = " + zonedDateTimeOf);
        
    }


}
