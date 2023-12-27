package com.ohgiraffers.section06.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Application5 {

    public static void main(String[] args) {
        
        String timeNow = "14:05:10";
        String dateNow = "2023-10-13";

        LocalTime localTime = LocalTime.parse(timeNow);
        LocalDate localDate = LocalDate.parse(dateNow);
        LocalDateTime localDateTime = LocalDateTime.parse(dateNow + "T" + timeNow);


        System.out.println("localTime = " + localTime);
        System.out.println("localDate = " + localDate);
        System.out.println("localDateTime = " + localDateTime);

        String timeNow2 = "14-05-10";
        String dateNow2 = "231013";
        //입력하는 패턴을 정해주고 파싱하는 내용
        LocalTime localTime2 =LocalTime.parse(timeNow2, DateTimeFormatter.ofPattern("HH-mm-ss"));
        LocalDate localDate2 = LocalDate.parse(dateNow2, DateTimeFormatter.ofPattern("yyMMdd"));

        System.out.println("localTime2 = " + localTime2);
        System.out.println("localDate2 = " + localDate2);
        
        //출력에 대한 부분을 정해서 출력
        String dateFormat = localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String timeFormat = localTime.format(DateTimeFormatter.ofPattern("HH mm"));

        System.out.println("dateFormat = " + dateFormat);;
        System.out.println("timeFormat = " + timeFormat);
        
    }
}
