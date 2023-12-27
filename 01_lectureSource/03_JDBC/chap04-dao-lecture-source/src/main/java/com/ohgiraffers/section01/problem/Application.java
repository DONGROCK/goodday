package com.ohgiraffers.section01.problem;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application {

    public static void main(String[] args) {

        Connection con = getConnection();

        /*3개의 쿼리문*/
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        PreparedStatement pstmt3 = null;

        ResultSet rset1 = null;
        ResultSet rset2 = null;

        int result = 0;
        int maxMenuCode = 0; // 현재 메뉴번호중 가장 큰 번호의 값을 저장할 변수
        Properties prop = new Properties();


        List<Map<Integer, String>> categoryList = null; // 카테고리 코드= 인티저, 카테고리네임= 스트링

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/menu-puery.xml"));

            String query1 = prop.getProperty("selectLastMenuCode"); //MAX
            String query2 = prop.getProperty("selectAllCategoryList");
            String query3 = prop.getProperty("insertMenu");

            pstmt1 = con.prepareStatement(query1);
            pstmt2 = con.prepareStatement(query2);
            pstmt3 = con.prepareStatement(query3);


            rset1 = pstmt1.executeQuery();
            if (rset1.next()) {
                maxMenuCode = rset1.getInt("MAX(A.MENU_CODE)");
            }
            System.out.println("maxMenuCode = " + maxMenuCode); // 가장큰 메뉴코드가 나온다.

            rset2 = pstmt2.executeQuery();

            categoryList = new ArrayList<>();
            while (rset2.next()) {
                Map<Integer, String> category = new HashMap<>();// 2개를 넣어야되니까 인트형 스트링형
                category.put(rset2.getInt("CATEGORY_CODE"), rset2.getString("CATEGORY_NAME"));
                categoryList.add(category); // 출력을 해보면 널값이 나옴. ArrayList를 만들어주자.

                Scanner sc = new Scanner(System.in);
                System.out.print("등록할 메뉴의 이름을 입력 : ");
                String menuName = sc.nextLine();
                System.out.print("신규 메뉴의 가격을 입력해요 : ");
                int menuPrice = sc.nextInt();
                System.out.println("카테고리를 선택해주세요(식사, 음료, 디저트, 한식, 중식) : "); // (1, 2, 3, 4, 5)
                sc.nextLine();
                String categoryName = sc.nextLine();
                System.out.println("바로 판매 메뉴에 적용하시겠습니까? (예 / 아니요) : ");
                String answer = sc.nextLine();

                int categoryCode = 0;
                switch (categoryName){
                    case "식사" : categoryCode =1; break;
                    case "음료" : categoryCode =2; break;
                    case "디저트" : categoryCode =3; break;
                    case "한식" : categoryCode =4; break;
                    case "중식" : categoryCode =5; break;
                }

                String orderableStatus = "";
                switch (answer){
                    case "예" : orderableStatus = "Y"; break;
                    case "아니오" : orderableStatus = "N"; break;
                }

                pstmt3.setInt(1, maxMenuCode + 1);
                pstmt3.setString(2, menuName);
                pstmt3.setInt(3, menuPrice);
                pstmt3.setInt(4, categoryCode);
                pstmt3.setString(5, orderableStatus);

                result = pstmt3.executeUpdate();
            }


            System.out.println("categoryList = " + categoryList);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset1);
            close(rset2);
            close(pstmt1);
            close(pstmt2);
            close(pstmt3);
            close(con);
        }
        if(result > 0){
            System.out.println("메뉴등록성공!");
        } else {
            System.out.println("메뉴등록실패..");
        }
    }
}
