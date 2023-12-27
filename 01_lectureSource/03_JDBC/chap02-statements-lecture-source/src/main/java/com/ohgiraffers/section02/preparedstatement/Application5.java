package com.ohgiraffers.section02.preparedstatement;

import com.ohgiraffers.model.dto.EmployeeDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application5 {
    public static void main(String[] args) {
        Connection con = getConnection();

        PreparedStatement pstmt = null;

        ResultSet rset = null;

        EmployeeDTO row = null;
        List<EmployeeDTO> empList = null;
        Scanner sc = new Scanner(System.in);
        System.out.print("조회할 이름의 성을 입력하세여 : ");
        String empName = sc.nextLine();
        String query = "SELECT * FROM EMPLOYEE WHERE EMP_NAME LIKE CONCAT(?, '%')";
        try {
            pstmt = con.prepareStatement(query);
        //    System.out.println("pstmt1 = " + pstmt);
            pstmt.setString(1, empName);
        //    System.out.println("pstmt2 = " + pstmt);
//            System.out.println("pstmt = " + pstmt);
            rset = pstmt.executeQuery();

            //조회된 여러 행을 담아놓는 ArrayList 객체를 생성
            empList = new ArrayList<>();
            while (rset.next()){
                row = new EmployeeDTO();

                row.setEmpId(rset.getString("EMP_ID"));
                row.setEmpName(rset.getString("EMP_NAME"));
                row.setEmpNo(rset.getString("EMP_NO"));
                row.setEmail(rset.getString("EMAIL"));
                row.setPhone(rset.getString("PHONE"));
                row.setDeptCode(rset.getString("DEPT_CODE"));
                row.setJobCode(rset.getString("JOB_CODE"));
                row.setSalLevel(rset.getString("SAL_LEVEL"));
                row.setSalary(rset.getInt("SALARY"));
                row.setBonus(rset.getDouble("BONUS"));
                row.setManagerId(rset.getString("MANAGER_ID"));
                row.setHireDate(rset.getDate("HIRE_DATE"));
                row.setEndDate(rset.getDate("ENT_DATE"));
                row.setEntYn(rset.getString("ENT_YN"));

                empList.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(rset);
            close(pstmt);
            close(con);
        }
        for (EmployeeDTO emp : empList){
            System.out.println(emp);
        }
    }
}
