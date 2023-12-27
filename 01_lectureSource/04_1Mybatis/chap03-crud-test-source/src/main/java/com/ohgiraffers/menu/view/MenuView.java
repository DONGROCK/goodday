package com.ohgiraffers.menu.view;

import com.ohgiraffers.menu.run.MenuController;
import com.ohgiraffers.menu.run.MenuMapper;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuView {


    //private MenuController menuController = new MenuController();
    public void displayView(){



        /*
        ============ 멤버 관리 ====================
        1. 메뉴 전체 조회
        2. (음식)메뉴코드로 조회
        3. (음식)카테고리코드로 음식조회
        4. 신규 (음식)메뉴 추가
        5. (음식)기존메뉴 수정
        6. (삭제)메뉴삭제 삭제
        ==========================================
        멤버의 조회 결과의 결럼
       */
        MenuController menuController = new MenuController();
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("==============================");
            System.out.println("1. 전체메뉴 조회");
            System.out.println("2. 메뉴코드로 메뉴조회");
            System.out.println("3. 카테고리코드로 메뉴조회");
            System.out.println("4. 신규메뉴 추가");
            System.out.println("5. 메뉴 수정");
            System.out.println("6. 메뉴 삭제");



            switch (sc.nextInt()){
                case 1: menuController.showAllMenu(); break;
                case 2: menuController.selectMenuByCode(inputMenuCode()); break;
                case 3: menuController.selectMenuByCategoryCode(inputCategoryCode()); break;
                case 4: menuController.newMenu(inputMenu()); break;
                case 5: menuController.changeMenu(updateMenu()); break;
                case 6: menuController.killMenu(inputMenuCode()); break;

            }
        }while (true);
    }

//    private Object deleteMenu() {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("삭제 할 메뉴코드를 입력해주세요 : ");
//        String code = sc.nextLine();
//
//    }

    private Map<String, String> updateMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("수정할 메뉴 코드를 입력해주세요 : ");
        String code = sc.nextLine();
        System.out.print("메뉴 이름을 수정해주세요 : ");
        String name = sc.nextLine();
        System.out.print("메뉴 가격을 수정해주세요 : ");
        String price = sc.nextLine();
        System.out.print("카테고리코드를 수정해주세요 : ");
        String categoryCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("code",code);
        parameter.put("name",name);
        parameter.put("price",price);
        parameter.put("categoryCode",categoryCode);

        return parameter;
    }

    private Map<String, String> inputMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("새로 등록할 메뉴를 입력해주세요 : ");
        String name = sc.nextLine();
        System.out.print("등록할 메뉴의 가격을 입력해주세요 : ");
        String price = sc.nextLine();
        System.out.print("카테고리코드를 입력해주세요 : ");
        String categoryCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("name", name);
        parameter.put("price", price);
        parameter.put("categoryCode",categoryCode);

        return parameter;
    }

    private Map<String, String> inputCategoryCode() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.식사, 2.음료, 3.디저트, 4.한식, 5.그외");
        System.out.print("원하시는 카테고리의 번호를 입력해주세요 : ");
        String categoryCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("categoryCode", categoryCode);

        return parameter;
    }

    private Map<String, String> inputMenuCode() {
        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴코드를 입력해주세요 : ");
        String code = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("code", code);

        return parameter;
    }
}
