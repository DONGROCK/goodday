package com.ohgiraffers.section06.time;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Application3 {
    public static void main(String[] args) {
        //불변의 특징을 확인할수있다.
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime = " + localDateTime);
        System.out.println(localDateTime.hashCode());

        LocalDateTime localDateTime2 = localDateTime.plusMinutes(30);
        System.out.println("localDateTime2 = " + localDateTime2);
        System.out.println(localDateTime2.hashCode());

        System.out.println(localDateTime == localDateTime2);

    }
}
