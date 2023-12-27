package com.ohgiraffers.mybatisspring.section01.factorybean;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class FindMenusTests {


    @Autowired
    private MenuService menuService;


    @Test
    @DisplayName("메뉴 전체 조회 테스트")
    void testFindAllMenus(){

        Assertions.assertDoesNotThrow(
                () -> {
                    List<MenuDTO> menus = menuService.findAllMenus();
                    menus.forEach(System.out::println);
                }
        );
    }
}
