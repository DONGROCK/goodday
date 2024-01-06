package com.ohgiraffers.springdatajpa.menu.service;

import com.ohgiraffers.springdatajpa.menu.dto.MenuDTO;
import com.ohgiraffers.springdatajpa.menu.entity.Menu;
import com.ohgiraffers.springdatajpa.menu.repository.MenuRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

    private final MenuRepository menuRepository;

    private final ModelMapper modelMapper;


    public MenuService(MenuRepository menuRepository,
                       ModelMapper modelMapper) {
        this.menuRepository = menuRepository;
        this.modelMapper = modelMapper;
    }

    public MenuDTO findMenuByCode(int menuCode) {

        /*
        * findById 메소드는 이미 구현되어 있으므로 인터페이스에 따로 정의 할 필요가 없다.
        * findById 의 반환 값은 Optional 타입이다. Optional 타입은 NPE을 방지하기 위한
        * 다양한 기능이 존재한다.
        *
        * 해당 id로 조회되지 못 했을 경우 IllegalArgumentException을 발생시킨다.
        * */
        Menu menu = menuRepository.findById(menuCode).orElseThrow(IllegalArgumentException::new);
        System.out.println("menu = " + menu);
        return modelMapper.map(menu, MenuDTO.class);
    }
}
