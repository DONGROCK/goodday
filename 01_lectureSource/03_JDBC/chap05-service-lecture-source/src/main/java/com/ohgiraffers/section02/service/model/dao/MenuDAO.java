package com.ohgiraffers.section02.service.model.dao;

import com.ohgiraffers.section02.service.model.dto.CategoryDTO;
import com.ohgiraffers.section02.service.model.dto.MenuDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import static com.ohgiraffers.common.JDBCTemplate.close;

public class MenuDAO {
    private Properties prop = new Properties();

    public MenuDAO(){

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/menu-query.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public int insertNewCategory(Connection con, CategoryDTO newCategory) {

        PreparedStatement pstmt = null;

        int result = 0;

        String query = prop.getProperty("insertCategory");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, newCategory.getName());
            pstmt.setObject(2, newCategory.getReCategoryCode());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }
        return result;
    }

    public int selectLastCategoryCode(Connection con) {
    PreparedStatement pstmt = null;
        ResultSet rset = null;
        int result = 0;
        int newCategoryCode = 0;

        String query = prop.getProperty("getCurrentSequence");
        try {
            pstmt = con.prepareStatement(query);

            rset = pstmt.executeQuery();

            if(rset.next()){
                newCategoryCode = rset.getInt("CURRVAL");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(rset);
            close(pstmt);
        }
        return newCategoryCode;
    }

    public int insertNewMenu(Connection con, MenuDTO newMenu) {

        PreparedStatement pstmt = null;

        int result = 0;

        String query = prop.getProperty("insertMenu");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, newMenu.getName());
            pstmt.setInt(2, newMenu.getPrice());
            pstmt.setInt(3, newMenu.getCategoryCode());
            pstmt.setString(4, newMenu.getOrderableStatus());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }
        return result;
    }
    }

