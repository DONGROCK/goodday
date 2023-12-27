package com.ohgiraffers.section02.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.*;

import static com.ohgiraffers.common.JDBCTemplate.close;

public class MenuDAO {

    /*
    * DAO(Database Access Object) : 데이터베이스 접근용 객체
    *  ==> CRUD연산을 담당하는 메소드들의 집합으로 이루어진 클래스
    * */
    private Properties prop = new Properties();

    public MenuDAO(){

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/menu-puery.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int selectLastMenuCode(Connection con){

        PreparedStatement pstmt = null;
        ResultSet rset = null;

        int maxMenuCode = 0; // 현재 메뉴번호중 가장 큰 번호의 값을 저장할 변수
        String query1 = prop.getProperty("selectLastMenuCode"); //MAX

        try {
            pstmt = con.prepareStatement(query1);
            rset = pstmt.executeQuery();
            if (rset.next()){

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(rset);
            close(pstmt);
        }
        return maxMenuCode;
    }

    public List<Map<Integer, String>> selectAllCategory(Connection con) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        String query = prop.getProperty("selectAllCategoryList");

        List<Map<Integer, String>> categoryList = null;

        try {
            pstmt = con.prepareStatement(query);
            rset = pstmt.executeQuery();

            categoryList = new ArrayList<>();

            while (rset.next()){
                Map<Integer, String> category = new HashMap<>();// 2개를 넣어야되니까 인트형 스트링형
                category.put(rset.getInt("CATEGORY_CODE"), rset.getString("CATEGORY_NAME"));
                categoryList.add(category); // 출력을 해보면 널값이 나옴. ArrayList를 만들어주자.
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categoryList;
    }

    public int insertNewMenu(Connection con, MenuDTO newMenu){

        PreparedStatement pstmt = null;
        int result = 0;
        String query = prop.getProperty("insertMenu");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, newMenu.getCode());
            pstmt.setString(2, newMenu.getName());
            pstmt.setInt(3, newMenu.getPrice());
            pstmt.setInt(4, newMenu.getCategoryCode());
            pstmt.setString(5, newMenu.getOrderableStatus());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;

    }
}
