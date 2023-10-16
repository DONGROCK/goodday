package com.ohgiraffers.section02.stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Application3 {
    public static void main(String[] args) {

        FileOutputStream fout = null;

        try {
            /*내보내기하는 경우에는 파일이 없는 상태에서 실행을 해도 예외는 발생하지 않는다.
            * OutputStreamdml 경우 대상파일이 존재하지 않으면 파일을 자동으로 생성해준다.
            * */

            /*파일의 새로운 설정 인자가 없으면 덮어쓰기가 기본이다.*/
            /*flase는 이어쓰기가 아닌 덮어쓰기이 이고, 기본값은 false이다*/
            fout = new FileOutputStream("src/main/java/com/ohgiraffers/section02/stream/testOutputSteam.txt");
            fout.write(97);

            /*byte배열을 생성해서 값을 기록
            * 10 : 개행문자(엔터)
            * */
            byte[] barr = new byte[]{97,98,99,10,100,101,10,102,10};
            fout.write(barr);

            /*1번 인텍스부터 3의 길이만큼 파일에 내보내기*/
            fout.write(barr, 1 , 3);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fout != null){
                try {
                    fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
