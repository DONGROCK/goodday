package com.ohgiraffers.section01.insert;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application2 {
    public static void main(String[] args) {
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        //ResultSet -인서트는 ㄴㄴ
        int result = 0; //이게 정수형인 이유가 입력성공한 행의 갯수를 나타내기 위해 이다.
        Properties prop = new Properties();
        Scanner sc = new Scanner(System.in);

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/menu-query.xml"));
            String query = prop.getProperty("insertMenu");
            System.out.println("query = " + query);

            System.out.print("메뉴의 이름을 입력해요 : ");        // 사용자가 입력하는 화면
            String menuName = sc.nextLine();                    //
            System.out.print("메뉴의 가격을 입력해요 : ");        //
            int menuPrice = sc.nextInt();                       //
            System.out.print(" 메뉴의 카테고리 코드를 입력해요 : "); //
            int categoryCode = sc.nextInt();                     //
            System.out.print("판매 여부를 결정해주세요(Y/N) : ");  //
            sc.nextLine();                                          //
            String orderableStatus = sc.nextLine().toUpperCase();    //


            pstmt = con.prepareStatement(query);
            pstmt.setString(1, menuName); //이제 순서대로 ?에 값을 넣는 것
            pstmt.setInt(2, menuPrice); //이제 순서대로 ?에 값을 넣는 것
            pstmt.setInt(3, categoryCode); //이제 순서대로 ?에 값을 넣는 것
            pstmt.setString(4, orderableStatus);    //이제 순서대로 ?에 값을 넣는 것

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

        if (result > 0){// 메뉴 추가에 성공 했을 경우 입니다.
            System.out.println("메뉴 등록 성공입니다!");
        }else { //메뉴추가에 실패 했을 경우임니다.
            System.out.println("메뉴 등록 실패입니다...");

        }

    }

}
