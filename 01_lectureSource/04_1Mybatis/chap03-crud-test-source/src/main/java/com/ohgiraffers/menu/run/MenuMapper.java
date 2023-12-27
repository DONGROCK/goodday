package com.ohgiraffers.menu.run;

import java.util.List;

public interface MenuMapper {
    List<MenuDTO> showAllMenu();

    MenuDTO selectMenu(int code);

    MenuDTO selectCategoryCode(int categoryCode);

    int newMenu(MenuDTO menu);

    int updateMenu(MenuDTO menu);

    int deleteMenu(int code);
}
