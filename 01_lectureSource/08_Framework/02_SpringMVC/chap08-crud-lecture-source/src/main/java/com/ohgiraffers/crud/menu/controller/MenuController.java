package com.ohgiraffers.crud.menu.controller;

import com.ohgiraffers.crud.menu.model.dto.CategoryDTO;
import com.ohgiraffers.crud.menu.model.dto.MenuDTO;
import com.ohgiraffers.crud.menu.model.service.MenuService;
import com.ohgiraffers.crud.menu.model.service.MenuServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/menu")
@Slf4j
public class MenuController {


    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/list")
    public String findMenuList(Model model) {

        List<MenuDTO> menuList = menuService.findAllMenu();
        log.info("menuList =======================> {}", menuList);

        model.addAttribute("menuList", menuList);
        return "menu/list";
    }

    @GetMapping("regist")
    public void registPage(){}

    @GetMapping(value="category", produces = "application/json; charset=utf-8")
    @ResponseBody
    public List<CategoryDTO> findCategoryList() {

        return menuService.findAllCategory();
    }

    @PostMapping("regist")
    public String registMenu(MenuDTO newMenu, RedirectAttributes rttr) {

        System.out.println("newMenu = " + newMenu);
        menuService.registNewMenu(newMenu);
        rttr.addFlashAttribute("successMessage", "신규 메뉴 등록에 성공하셨습니다.");
        return "redirect:/menu/list";
    }
}
