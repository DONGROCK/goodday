package com.ohgiraffers.section01.transaction;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application3 {
    public static void main(String[] args) {

        Connection con = getConnection();
        try {
            System.out.println("autoCommit의 현재 설정 값 : " + con.getAutoCommit());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        PreparedStatement pstmt = null;

        int result = 0;

        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/menu-query.xml"));

            String query = prop.getProperty("insertMenu");

            pstmt = con.prepareStatement(query);
            pstmt.setString(1, "학꽁치엑기스");
            pstmt.setInt(2, 30000);
            pstmt.setInt(3, 2);
            pstmt.setString(4, "Y");

            result = pstmt.executeUpdate(); // 쿼리실행. 결과리턴
            if(result > 0){
                System.out.println("메뉴등록성공!");
                con.commit();
            } else {
                System.out.println("메뉴등록실패..");
                con.rollback();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(pstmt);
            close(con);
        }

//        if(result > 0){
//            System.out.println("메뉴 등록 성공");
//        } else {
//            System.out.println("메뉴 등록 실패");
//        }

    }
}
