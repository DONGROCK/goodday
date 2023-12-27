package com.ohgiraffers.menu.run;

import java.util.List;

public class PrintResult {
    public void printMenuList(List<MenuDTO> menuList) { //전체조회
        for(MenuDTO menu : menuList){
            System.out.println(menu);
        }
    }

    public void printErrorMessage(String errorCode) {
        String errorMessage = "";
        switch (errorCode){
            case "showAllMenu" : errorMessage = "전체메뉴 조회 실패."; break;
            case "selectMenu" : errorMessage = "메뉴코드로 메뉴조회 실패."; break;
            case "selectCategoryCode" : errorMessage = "카테고리로 메뉴조회 실패"; break;
            case "updateMenu" : errorMessage = "메뉴수정 실패"; break;
            case "deleteMenu" : errorMessage = "메뉴삭제 실패"; break;
        }
        System.out.println(errorMessage);
    }

    public void printSelectMenu(MenuDTO menu) {
        System.out.println(menu);

    }

    public void printSuccessMessage(String successCode) {
        String successMessage = "";
        switch (successCode){
            case "newMenu" : successMessage = "메뉴 등록 성공"; break;
            case "updateMenu" : successMessage = "메뉴 수정 성공"; break;
            case "deleteMenu" : successMessage = "메뉴 삭제 성공"; break;
        }
        System.out.println(successMessage);
    }
}
