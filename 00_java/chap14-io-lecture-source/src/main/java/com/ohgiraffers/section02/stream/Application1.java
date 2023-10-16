package com.ohgiraffers.section02.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Application1 {
    public static void main(String[] args) {

        /*
        * 입출력 스트림 개요
        * 우리는 프로그래밍을 할 때 많은 종류의 데이터를 다룬다.
        * 하지만 데이터는 프로그램 내부에 있을 수도 있지만,
        * 프로그램 외부의 데이터를 가져와서 사용해야 할 수도 있다.
        * 또한 프로그램에서 생성한 데이터를 외부로 출력할 수 도 있다.
        *
        * 외부 데이터 프로그램 외부에 존재하는 모든 데이터를 의미한다.
        * 외부데이터는 하드디스크 상의 파일이 될 수도 있고,
        * 네트워크 상에 존재하는 자원이 될 수도 있다.
        * 외부 데이터를 대상으로 작업할 때 가장 먼저 해야할 일은
        *  자바 프로그램과 외부 데이터를 연결하는 것이다.
        *
        * 프로그램과 외부 데이터가 연결된 길을 스트림(stream)이라고 한다.
        * 스트림은 단방향이기 때문에 데이터를 읽어오기 위한길은 입력스트림, (메모리)내가 읽어온다 / reader문자기반 읽어온다.
        * 데이터를 출력하기 위한 길은출력 스트림이라 부른다.
        * */

        /*InputStream과 Reader는 데이터를 읽어오는 입력 스트림이고,
        * OutputStream과 Writer는 데이터를 내보내는 출력스트림이다.
        *
        * 또한 InputStream과 OutputStream은 데이터를 1바이트 단위로 입/출력하고
        * Reader와 Writer계열은 글자(2바이트 혹은 3바이트)단위로 작업한다.
        * 참고로 MS949 인코딩에서는 한글 한글자를 2바이트로 취급하지만,
        *  UTF-8에서는 한글 한 글자를 3바이트로 취급한다.
        * */

        FileInputStream fin = null; // fin변수에 생성되어서 담긴 파일의 객체주소를 기반으로 finally부분에서 close()를 사용하기 위해서

        try {
            fin = new FileInputStream("src/main/java/com/ohgiraffers/section02/stream/testInputStream.txt");

            int value;

//            while ((value = fin.read()) != -1){
//                System.out.println(value);
//
//                System.out.println((char)value);
//            }

            System.out.println("파일의 길이 : " + new File("src/main/java/com/ohgiraffers/" +
                    "section02/stream/testInputStream.txt").length());

            int filesize = (int)new File("src/main/java/com/ohgiraffers/" +
                    "section02/stream/testInputStream.txt").length();

            byte[] barr = new byte[filesize];

            fin.read(barr);

            for (int i = 0; i < barr.length; i++){
                System.out.print((char)barr[i]);
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fin != null){
                try {

                    /*
                    * 자원반납을 해야 하는 이유
                    * 1. 장기간 실행중인 프로그램에서 스트림을 닫지 않는 경우 다양한 리소스에서 누수(leak)가 발생한다.
                    * 2. 뒤에서 배우는 버퍼를 이용하는 경우 마지막에 flush()로 버퍼에 있는 데이터를 강제로 전송해야 한다.
                    *    만약 잔류 데이터가 남은 상황에서 추가로 스트림을 사용한다면 데드락(deadlock)상태가 된다.
                    *    판단하기 어렵고 의도하지 않는 상황에서도 이런 현상이 발생할 수 있기 때문에,
                    *    마지막에는 flush()를 무조건 실행해주는 것이 좋다.
                    *    close() 메소드는 자원을 반납하면 flush()를 해주기 때문에 close만 제대로 해줘도 된다.
                    *    따라서 close()메소드는 외부 자원을 사용하는 경우 반드시 마지막에 호출 해줘야 한다.
                    */

                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
