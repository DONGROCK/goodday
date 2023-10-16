package com.ohgiraffers.section03.filterstream;

import java.io.*;

public class Application3 {
    public static void main(String[] args) {

        /*
         * 외부 데이터로부터 읽어오는 데이터를 바이트형 정수, 문자, 문자열로만 읽어오면
         * 여러 데이터  타입을 취급하는 경우 별도로 처리를 해주어야 한다.
         * 예) 정수 입력받아 처리하려면 parsing을 해줘야 한다.
         * */

        DataOutputStream dout = null;

        try {
            dout = new DataOutputStream(new FileOutputStream("src/main/java/com/ohgiraffers/section03/filterstream/score.txt"));

            /*파일에 자료형별로 기록*/
            dout.writeUTF("배고파");
            dout.writeInt(95);
            dout.writeChar('A');

            dout.writeUTF("신짱구");
            dout.writeInt(85);
            dout.writeChar('B');

            dout.writeUTF("고조사토루");
            dout.writeInt(73);
            dout.writeChar('C');
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dout != null) {
                try {
                    dout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        DataInputStream din = null;
        try {
            din = new DataInputStream(new FileInputStream("src/main/java/com/ohgiraffers/section03/filterstream/score.txt"));

            while (true) {

                System.out.println(din.readUTF() + din.readInt() + din.readChar());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();

            /*현재 상태로 읽어들이게 되면 더이상 읽을 것이 없을 경우에는 EOFException을 발생시킨다.*/
        } catch (EOFException e) {
            System.out.println("파일 다읽었엉");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (din != null) {
                try {
                    din.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
