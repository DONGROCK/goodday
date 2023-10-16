package com.ohgiraffers.section03.filterstream;

import java.io.*;
import java.util.Enumeration;

public class Application1 {
    public static void main(String[] args) {

        /*
         java.io 패키지의 입출력 스트림은 기본스트림과 필터 스트림으로 분류할 수 있다.
         기본스트림은 외부 데이터에 직접연결되는 스트림이고
         필터스트림은 외부 데이터에 직접 연결하는 것이 아니라 기본 스트림에 추가로 사용할 수 있는 스트림이다.
         주로 성능을 향상시키는 목적으로 사용되며 생성자를 보면 구분이 가능하다.
         생성자쪽에서 매개변수로 다른 스트림을 이용하는 클래스는 필터스트림이라고 볼 수 있다.
         */

        /*
        * 버퍼를 이용해서 성능향상을 시키는 보조스트림
        * BufferedWriter / BufferedReader
        * */
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("src/main/java/com/ohgiraffers/section03/filterstream/testBuffered.txt"));
            bw.write("안녕하세요\n");
            bw.write("반갑습니다\n");
            bw.write("안녕하세요\n");
            bw.write("네 안녕하세요\n");

            /*버퍼를 이용하는 경우 버퍼가 가득 차면 자동으로 내보내기를 하지만
            * 버퍼가 가득 차있지 않는 상태에서는 강제로 내보내기를 해야하는데
            * close()를 하게 되면 내부적으로 flush()를 하고 종료를 하기 때문에 출력이되고
            * 이전에 사용하려고하면 flush()메소드를 이용해서 강제적으로 내보내기를 할 수있따.*/
            bw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        /*버퍼에 미리 일겅온 후 한줄 단위로 읽어들이는 기능을 제공*/
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("src/main/java/com/ohgiraffers/section03/filterstream/testBuffered.txt"));

            /*readLine()을 추가로 제공*/
//            br.read();
//            br.readLine()

            String temp;

            while ((temp = br.readLine()) != null){
                System.out.println(temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
