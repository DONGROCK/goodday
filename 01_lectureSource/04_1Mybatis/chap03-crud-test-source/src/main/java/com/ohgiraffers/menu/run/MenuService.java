package com.ohgiraffers.menu.run;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.menu.common.Template.getSqlSession;

public class MenuService {

    private MenuMapper mapper;
    public List<MenuDTO> showAllMenu() {

        SqlSession sqlSession = getSqlSession();
//        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        mapper = sqlSession.getMapper(MenuMapper.class);

    List<MenuDTO> menuList = mapper.showAllMenu();

    sqlSession.close();

    return menuList;
    }

    public MenuDTO selectMenuByCode(int code) {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(MenuMapper.class);

        MenuDTO menu = mapper.selectMenu(code);

        sqlSession.close();
        return menu;
    }

    public MenuDTO selectMenuByCategoryCode(int categoryCode) {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(MenuMapper.class);

        MenuDTO menu = mapper.selectCategoryCode(categoryCode);

        sqlSession.close();

        return menu;

    }

    public boolean newMenu(MenuDTO menu) {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(MenuMapper.class);

        int result = mapper.newMenu(menu);

        if(result > 0){
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result > 0? true:false;
    }

    public boolean updateMenu(MenuDTO menu) {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(MenuMapper.class);

        int result = mapper.updateMenu(menu);

        if(result > 0){
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();

            return result > 0? true:false;
    }


    public boolean killMenu(int code) {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(MenuMapper.class);

        int result = mapper.deleteMenu(code);

        if(result > 0){
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }
        sqlSession.close();

        return result > 0? true:false;
    }
}
