package com.ohgiraffers.section06.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class Application4 {
    public static void main(String[] args) {

        /*
        * isBefore() : 인자보다 과거일때 true
        * isAfter() : 인자보다 미래일 때 true
        * isEqual() : 인자와 같은 날짜일 때 true
        * */

        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.now();

        LocalDate past = LocalDate.of(2020,11,11);
        LocalDateTime future= LocalDateTime.of(2024, 12, 24, 8, 0,0);
        ZonedDateTime now = ZonedDateTime.now();

        System.out.println(localDate.isAfter(past)); //past 지금보다 과거이기에true
        System.out.println(localDateTime.isBefore(future)); //futrue 지금보다 미래라서 true
        System.out.println(zonedDateTime.isEqual(now));


    }
}
