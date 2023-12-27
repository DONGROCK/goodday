package com.ohgiraffers.section02.service.run;

import com.ohgiraffers.section02.service.model.service.MenuService;

public class Application {
    public static void main(String[] args) {

        /*
        * Service 역할
        * 1. Connection 생성
        * 2. DAO 메소드 호출
        * 3. 트랜잭션 제어
        * 4. Connection 닫기
        * */
        MenuService menuService = new MenuService();
        menuService.registMewMenu(); // 재사용할꺼다

//        new MenuService().registNewMenu(); // 재사용안한다
    }
}
