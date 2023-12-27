package com.ohgiraffers.model.service;

import com.ohgiraffers.model.dao.OrderDAO;
import com.ohgiraffers.model.dto.CategoryDTO;
import com.ohgiraffers.model.dto.MenuDTO;
import com.ohgiraffers.model.dto.OrderDTO;
import com.ohgiraffers.model.dto.OrderMenuDTO;

import java.sql.Connection;
import java.util.List;

import static com.ohgiraffers.common.JDBCTemplate.*;

public class OrderService {
    /*
    * 1. Connection 생성
    * 2, DAO 메소드 요청(비지니스로직.)
    * 3. 트랜잭션 처리
    * 4. 연결객체 종료
    * */
    private OrderDAO orderDAO = new OrderDAO();

    public List<CategoryDTO> selectAllCategory() {

        Connection con = getConnection();

        List<CategoryDTO> categoryList = orderDAO.selectAllCategory(con);

        close(con);

        return categoryList;
    }

    public List<MenuDTO> selectMenuBy(int categoryCode) {
        Connection con = getConnection();

        List<MenuDTO> menuList = orderDAO.selectMenuBy(con, categoryCode);

        close(con);

        return menuList;
    }


    public int registOrder(OrderDTO order) {
        Connection con = getConnection();

        int result = 0;
        int orderResult = orderDAO.insertOrder(con, order);

        int ordercode = orderDAO.selectLastorderCode(con);

        List<OrderMenuDTO> orderMenuList = order.getOrderMenuList();
        for(int i = 0; i < orderMenuList.size(); i++ ){
            OrderMenuDTO orderMenu = orderMenuList.get(i);
            orderMenu.setCode(ordercode);
        }

        /*order_menu 테이블에 insert*/
        int orderMenuResult = 0; //insert하는 갯수를 체크하기 위한 변수
        for (int i = 0; i < orderMenuList.size();i++){
            OrderMenuDTO orderMenu = orderMenuList.get(i);
            orderMenuResult += orderDAO.insertOrderMenu(con, orderMenu);
        }

        /*성공여부판단 후 트랜잭션 처리*/
        if(orderResult > 0 && orderMenuResult == orderMenuList.size()){
            commit(con);
            result = 1;
        } else {
            rollback(con);
        }
        /*Connection 닫기*/
        close(con);
    }
}
