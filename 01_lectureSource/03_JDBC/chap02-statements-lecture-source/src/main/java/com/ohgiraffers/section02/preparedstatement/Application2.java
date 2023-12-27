package com.ohgiraffers.section02.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application2 {
    public static void main(String[] args) {

        Connection con = getConnection();
        PreparedStatement pstmt = null; //statement? 쿼리문을 자바에서 작성해서 데이터베이스가 알게 할 수 있는 기능이야.
                                        // 데이터 베이스에 쿼리문을 보내면 데이터 베이스가 뭘 보내? 쿼리문을 보냈어 쿼리문의 조건에 부합하는 데이터를 반환하겠지.
        ResultSet rset = null;          // statement를 통해서 보낸 쿼리문의 결과를 받아주기 위한 메서드인거야.

        String empId = "202";

        try { //statement의 쿼리문은 select * from tbl_menu where menu_code;
              // preparedstatement의 쿼리문은 select * from tbl_menu where = ?;
            pstmt = con.prepareStatement("SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE EMP_ID = ?");// ? 위치홀더 // 쿼리문이 미완성인 상태
            pstmt.setString(1, empId); // 쿼리를 실행하는데 필요한 데이터 값을 추가 한 것.
                                                    // setString()과 같은 메소드의 첫번째 인자의 값은 1부터 위치를 잡는다.

            rset = pstmt.executeQuery();// 여기서 완성시킨 쿼리문을 보낸다. 와 동시에 받는다.
            if (rset.next()){
                System.out.println(rset.getString("EMP_ID") +" : "+ rset.getString("EMP_NAME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
            close(con);
        }


    }
}
