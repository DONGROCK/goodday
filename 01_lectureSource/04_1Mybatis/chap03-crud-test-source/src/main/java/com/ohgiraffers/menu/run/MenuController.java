package com.ohgiraffers.menu.run;


import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class MenuController {
private final PrintResult printResult;
private final MenuService menuService;
    public MenuController() {
        printResult = new PrintResult();
        menuService = new MenuService();
    }
    public void showAllMenu() { // 전체출력
        List<MenuDTO> menuList = menuService.showAllMenu();

        if(menuList != null){
            printResult.printMenuList(menuList);
        } else{
            printResult.printErrorMessage("showAllMenu");
        }


    }

    public void selectMenuByCode(Map<String, String> parameter) { //메뉴코드로 메뉴출력
        int code = Integer.parseInt(parameter.get("code"));

        MenuDTO menu = menuService.selectMenuByCode(code);

        if (menu != null){
            printResult.printSelectMenu(menu);
        } else {
            printResult.printErrorMessage("selectMenu");
        }
    }

    public void selectMenuByCategoryCode(Map<String, String> parameter) { //카테고리로 메뉴출력
        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));

        MenuDTO menu = menuService.selectMenuByCategoryCode(categoryCode);
        if (menu != null){
            printResult.printSelectMenu(menu);
        } else {
            printResult.printErrorMessage("selectCategoryCode");
        }
    }

    public void newMenu(Map<String, String> parameter) { //추가 컨트롤

        String name = parameter.get("name");
        int price = Integer.parseInt(parameter.get("price"));
        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));

        MenuDTO menu = new MenuDTO();

        menu.setName(name);
        menu.setPrice(price);
        menu.setCategoryCode(categoryCode);

        System.out.println("menu" + menu);

        if (menuService.newMenu(menu)){
            printResult.printSuccessMessage("newMenu");

        } else {
            printResult.printErrorMessage("newMenu");
        }

    }
    public void changeMenu(Map<String, String> parameter) { //수정 컨트롤
        int code = Integer.parseInt(parameter.get("code"));
        String name = parameter.get("name");
        int price = Integer.parseInt(parameter.get("price"));
        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));

        MenuDTO menu = new MenuDTO();

        menu.setCode(code);
        menu.setName(name);
        menu.setPrice(price);
        menu.setCategoryCode(categoryCode);

        System.out.println("menu" + menu);

        if(menuService.updateMenu(menu)){
            printResult.printSuccessMessage("updateMenu");
        } else {
            printResult.printErrorMessage("updateMenu");
        }



    }

    public void killMenu(Map<String, String> parameter) {
        int code = Integer.parseInt(parameter.get("code"));

        if(menuService.killMenu(code)){
            printResult.printSuccessMessage("deleteMenu");
        } else {
            printResult.printErrorMessage("deleteMenu");
        }

    }
}
