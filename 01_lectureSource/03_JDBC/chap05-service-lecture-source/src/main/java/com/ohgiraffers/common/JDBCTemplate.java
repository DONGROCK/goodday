package com.ohgiraffers.common;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class
JDBCTemplate {

    public static Connection getConnection() {

        Connection con = null;
        Properties prop = new Properties();

        try {
            prop.load(new FileReader("src/main/java/com/ohgiraffers/config/connection-info.properties"));

            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");

            Class.forName(driver);

            con = DriverManager.getConnection(url, prop);

             con.setAutoCommit(false);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void close(Connection con){

        try {
            if(con != null && !con.isClosed())
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Statement stmt){ //업캐스팅 --> 자식 --> 부모, 다운캐스팅 부모 -> 자식

        try {
            if(stmt != null && !stmt.isClosed()) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*이전에는 AutoCommit이 설정되어 있어서 수동으로 처리를 하지 않아서 없어도 사용하는데 문제가 되지않았지만
    * 이제는 AutoCommit에 대한 설정을 변경하였기 때문에 commit, rollback에 관련된 메소드를 작성해서 우리가
    * 원하는 시점에 사용하도록 준비를 해놓는다.
    * */
    public static void commit(Connection con){

        try {
            if(con != null && !con.isClosed()){
                con.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void rollback(Connection con){

        try {
            if(con != null && !con.isClosed()){
                con.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close(ResultSet rset){

        try {
            if(rset != null && !rset.isClosed())
                rset.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
