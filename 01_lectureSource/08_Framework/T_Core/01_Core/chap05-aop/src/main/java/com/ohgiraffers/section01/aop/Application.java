package com.ohgiraffers.section01.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("com.ohgiraffers.section01.aop");

        String[] beanNames = context.getBeanDefinitionNames();
        for(String beanName : beanNames) {
            System.out.println(beanName);
        }


        MemberService memberService = context.getBean("memberService", MemberService.class);
        System.out.println("======================== selectMembers ================================");
        System.out.println(memberService.selectMembers());
        System.out.println("======================== selectMember ================================");
        System.out.println(memberService.selectMember(3L));

        System.out.println("===============================================");
        NoticeService noticeService = context.getBean("noticeService", NoticeService.class);
        noticeService.test1();
    }
}
