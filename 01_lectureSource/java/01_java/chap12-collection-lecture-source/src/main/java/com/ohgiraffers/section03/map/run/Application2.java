package com.ohgiraffers.section03.map.run;

import javax.imageio.IIOException;
import java.io.*;
import java.util.Properties;

public class Application2 {
    public static void main(String[] args) {

        /*

        Properties란
        * HashMap을 구현하여 사용 용법이 거의 유사하지만 key와 value 모두 문자열만 사용할 수 있는 자료구조이다.
        * --> 설정 파일의 값을 읽어서 애플리케이션에 적용할 때 사용한다.
        * */

        Properties prop = new Properties();

        prop.setProperty("driver", "oracle.jdbc.driver.OracleDriver");
        prop.setProperty("url", "jdbc:oracle:thin:thin:@127.0.0.1:1521:xe");
        prop.setProperty("user" , "student");
        prop.setProperty("password", "student");

        System.out.println(prop);

        try {
            prop.store(new FileOutputStream("driver.dat"),"jdbc.driver");
            prop.store(new FileWriter("driver.txt"),"jdbc driver");
        }catch (IOException e){
            throw new RuntimeException(e);
        }

        Properties prop2= new Properties();

        try {
            prop2.load(new FileInputStream("driver.dat"));
            prop2.load(new FileReader("driver.txt"));

//            prop2.loadFromXML(new FileInputStream("driver.xml"));
            /*Properties 의 모든 키값 목록을 대상 스트림에 내보내기한다. (콘솔창에 출력해준다)*/
//            prop2.loadFromXML(new FileInputStream("driver.xml"));
            System.out.println("===============================");

            System.out.println(prop2.getProperty("driver"));
            System.out.println(prop2.getProperty("url"));
            System.out.println(prop2.getProperty("user"));
            System.out.println(prop2.getProperty("password"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
