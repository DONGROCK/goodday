package com.ohgiraffers.section02.service.model.service;

import com.ohgiraffers.section02.service.model.dao.MenuDAO;
import com.ohgiraffers.section02.service.model.dto.CategoryDTO;
import com.ohgiraffers.section02.service.model.dto.MenuDTO;

import java.sql.Connection;

import static com.ohgiraffers.common.JDBCTemplate.*;

public class MenuService {

    public void registMewMenu() {
        /*1. Connection 생성*/
        Connection con = getConnection();

        /*2. DAO 메소드 호출*/
        MenuDAO menuDAO = new MenuDAO();

        /*2-1. 카테고리등록*/
        CategoryDTO newCategory = new CategoryDTO();
        newCategory.setName("기타");
        newCategory.setReCategoryCode(null); //

        int reseult1 = menuDAO.insertNewCategory(con, newCategory);

        int newCategoryCode = menuDAO.selectLastCategoryCode(con);
         // 새롭게 생성하 카테고리 코드를 신규 메뉴 등록할때 들어가는
        /*2-2. 메뉴 등록*/
        MenuDTO newMenu = new MenuDTO();
        newMenu.setName("메롱스튜");
        newMenu.setPrice(40000);
        newMenu.setCategoryCode(newCategoryCode);
        newMenu.setOrderableStatus("Y");

        int result2 = menuDAO.insertNewMenu(con, newMenu);

        /*3. 트랜잭션 제어*/

        if(reseult1 > 0 && result2 > 0){
            System.out.println("신규 카테고리와 메뉴를 추가하였습니다.");
            commit(con);
        }else{
            System.out.println("신규 카테고리와 메뉴를 추가하지 모했스빈다.");
            rollback(con);
        }
        close(con);
    }
}
