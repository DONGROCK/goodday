package com.ohgiraffers.crud.menu.model.service;

import com.ohgiraffers.crud.menu.model.dao.MenuMapper;
import com.ohgiraffers.crud.menu.model.dto.CategoryDTO;
import com.ohgiraffers.crud.menu.model.dto.MenuDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    private final MenuMapper menuMapper;

    public MenuServiceImpl(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }

    public List<MenuDTO> findAllMenu() {

        return menuMapper.findAllMenu();
    }

    @Override
    public List<CategoryDTO> findAllCategory() {

        return menuMapper.findAllCategory();
    }

    @Transactional  // 성공하면 commit, 실패하면 rollback처리
    @Override
    public void registNewMenu(MenuDTO newMenu) {

        menuMapper.registNewMenu(newMenu);
    }
}
