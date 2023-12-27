package com.ohgiraffers.section01.insert;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application1 {
    public static void main(String[] args) {
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        //ResultSet -인서트는 ㄴㄴ
        int result = 0; //이게 정수형인 이유가 입력성공한 행의 갯수를 나타내기 위해 이다.
        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/menu-query.xml"));
            String query = prop.getProperty("insertMenu");
            System.out.println("query = " + query);

            pstmt = con.prepareStatement(query);

            pstmt.setString(1, "봉골레청국장"); //이제 순서대로 ?에 값을 넣는 것
            pstmt.setInt(2, 50000); //이제 순서대로 ?에 값을 넣는 것
            pstmt.setInt(3, 1); //이제 순서대로 ?에 값을 넣는 것
            pstmt.setString(4, "Y");    //이제 순서대로 ?에 값을 넣는 것

            //이제 여기서 요청하는 메소드가 달라지는데
            // select 일 경우 : executeQuery()를 사용
            // insert, update, delete 일 경우 : executeUpdate()사용

            result = pstmt.executeUpdate(); // 인서트 해달라 성공한 행의 갯수를 반환


        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(pstmt);
            close(con);
        }
            System.out.println("result : " + result);

    }

}
