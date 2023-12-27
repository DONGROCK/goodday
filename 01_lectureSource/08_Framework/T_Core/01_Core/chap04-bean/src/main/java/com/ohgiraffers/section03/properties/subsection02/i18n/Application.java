package com.ohgiraffers.section03.properties.subsection02.i18n;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;
import java.util.Locale;

public class Application {

    public static void main(String[] args) {

        /*
         * i18n 소프트웨어의 국제화(Interationalization에서 첫글자인 I와 마지막글자인 N 사이 알파벳 갯수가18개)
         * (국제화 말고 현재화도 있다.(Localization:현지화))
         * 소프트웨어를 국제화 하기 위해서는 처리해야 할 작업이 많이 있다.
         * 1. 언어, 지역별 번역
         * 2. OS/플랫폼 인코딩
         * 3. 문자열 치환 방법 : 서버쪽, 클라이언트쪽 치환 중 서버쪽에서 하는 것이 좋다.(경우에 따라 다르지만).
         *                    사용자 디바이스에 리소스 및 렌더링 성능 이슈 발생
         * 4. 국제화 UI(문자열 크기 변화, 폰트, 아이콘 등)
         * 5. 쓰기 방향의 차이
         * 6. 숫자, 공백, 화폐, 날짜, 주소, 측정 단위 등
         * 7. 타임존, 섬머타임 등 시각
         * 8. 문자열 정렬방법
         * */
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        String error404MessageKR = context.getMessage("error.404", null, Locale.KOREA);
        String error500MessageKR = context.getMessage("error.500", new Object[]{"여러분", new Date()}, Locale.KOREA);

        System.out.println("I18N error.404 메세지 : " + error404MessageKR);
        System.out.println("I18N error.500 메세지 : " + error500MessageKR);

        String error404MessageUS = context.getMessage("error.404", null, Locale.US);
        String error500MessageUS = context.getMessage("error.500", new Object[]{"you", new Date()}, Locale.US);

        System.out.println("I18N error.404 메세지 : " + error404MessageUS);
        System.out.println("I18N error.500 메세지 : " + error500MessageUS);

    }
}
