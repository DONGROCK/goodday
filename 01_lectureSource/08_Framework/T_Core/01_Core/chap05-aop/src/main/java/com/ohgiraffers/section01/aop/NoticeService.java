package com.ohgiraffers.section01.aop;

import org.springframework.stereotype.Service;

@Service
public class NoticeService {

    public void test1(){
        System.out.println("출력 시간을 측정해줘");
    }
}
