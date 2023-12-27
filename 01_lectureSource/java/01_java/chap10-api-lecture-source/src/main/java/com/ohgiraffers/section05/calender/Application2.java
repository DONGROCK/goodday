package com.ohgiraffers.section05.calender;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Application2 {

    public static void main(String[] args) {

        /*
         * Calendar클래스를 이용한 인스턴스 생성 방법
         * 1, getInstance() static메소드를 이용해서 인스턴스를 반환받는 방법
         * 2. 후손클래스인 GregorianCalendar 클래스를 이용해서 인스턴스를 생성하는 방법
         * */

        Calendar calendar = Calendar.getInstance();
        System.out.println("calender = " + calendar);
        Calendar gregoriancalendar = new GregorianCalendar(); //다형성
        System.out.println(gregoriancalendar);

        /*2013 9월 18일 16:42:00*/
        int year = 2013;
        int month = 12;
        int dayOfMonth = 18;
        int hour = 16;
        int min = 42;
        int second = 0;

        Calendar birthDay = new GregorianCalendar(year,month,dayOfMonth,hour,min,second);
        System.out.println(birthDay);

        System.out.println(birthDay.getTimeInMillis());

        Date date = new Date(birthDay.getTimeInMillis());
        System.out.println("date : " + date );

        int birthYear = birthDay.get(1);
        int birthMonth = birthDay.get(2);
        int birthDayOfMonth = birthDay.get(5);
        System.out.println(birthYear);
        System.out.println(birthMonth);
        System.out.println(birthDayOfMonth);

        System.out.println(Calendar.YEAR);
        System.out.println(Calendar.MONTH);
        System.out.println(Calendar.DATE);

        System.out.println("year : " + birthDay.get(Calendar.YEAR)); // 이거써라 그냥
        System.out.println("month : " + birthDay.get(Calendar.MONTH));
        System.out.println("dayOfMonth : " + birthDay.get(Calendar.DATE));
        /*일요일이 1 토요일이 7이다.*/
        System.out.println("dayOfWeek : " + birthDay.get(Calendar.DAY_OF_WEEK));

        String day = "";

        switch (birthDay.get(Calendar.DAY_OF_WEEK)){
            case Calendar.SUNDAY: day = "일";break;
            case Calendar.MONDAY: day = "월";break;
            case Calendar.TUESDAY: day = "화";break;
            case Calendar.WEDNESDAY: day = "수";break;
            case Calendar.THURSDAY: day = "목";break;
            case Calendar.FRIDAY: day = "금";break;
            case Calendar.SATURDAY: day = "토";break;
        }
        System.out.println("요일 : " + day);

        System.out.println("ampm : " + birthDay.get(Calendar.AM_PM));//0은 오전, 1은 오후

        System.out.println("hourOfDay : " + birthDay.get(Calendar.HOUR_OF_DAY));//24시간 체계
        System.out.println("hour : " + birthDay.get(Calendar.HOUR)); //12시간 체계

        System.out.println("min : " + birthDay.get(Calendar.MINUTE));
        System.out.println("second : " + birthDay.get(Calendar.SECOND));

    }
}
