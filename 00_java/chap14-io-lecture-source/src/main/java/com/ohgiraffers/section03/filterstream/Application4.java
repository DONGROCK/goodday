package com.ohgiraffers.section03.filterstream;

import com.ohgiraffers.section03.filterstream.dto.MemberDTO;

import java.io.*;


public class Application4 {
    public static void main(String[] args) {

        MemberDTO[] outputMembers = {
                new MemberDTO("user01", "pwd01", "짱구", "jang@gmail.com", 5, '남', 1600.8),
                new MemberDTO("user02", "pwd02", "장그래", "sin@gmail.com", 25, '여', 3214.8),
                new MemberDTO("user03", "pwd03", "스눕독", "gang@gmail.com", 45, '남', 9600.6)
        };

        ObjectOutputStream objOut = null;

        try {
//            objOut = new ObjectOutputStream(new BufferedOutputStream
//                    (new FileOutputStream("src/main/java/com/ohgiraffers/section03/filterstream/testObjectStream.txt"/*,true*/)));
            if (new File("src/main/java/com/ohgiraffers/section03/filterstream/testObjectStream.txt").exists()){
                //파일이 있는 경우
                objOut = new MyOutputStream //직렬화 헤더를 저장하지 않을꺼다
                        (new BufferedOutputStream
                                (new FileOutputStream("src/main/java/com/ohgiraffers/section03/filterstream/testObjectStream.txt"/*,true*/)));
            }else {
                //파일이 없는 경우 (처음)
                objOut = new MyOutputStream
                        (new BufferedOutputStream
                    (new FileOutputStream("src/main/java/com/ohgiraffers/section03/filterstream/testObjectStream.txt"/*,true*/)));
            } // 파일이 있냐?

            for (int i = 0; i < outputMembers.length; i++) {
                objOut.writeObject(outputMembers[i]);
            }

            objOut.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                objOut.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /*
            NotSerializableException?
        * java.io.NotSerializableException DTO에 직렬화 처리를 하지 않았을 때 나는 예외이다.

        Serializable : 직렬화
        자바 시스템 내부에서 사용되는 객체 또는 데이터를 외부에서도 사용할 수 있도록 바이트(byte)형태로 데이터를 변환하는 기술을 말한다.
        반대로 바이트로 변환된 데이터를 다시 객체로 변환하는 기술을 역직렬화 라고 한다.
        */

        MemberDTO[] inputMembers = new MemberDTO[3];

        ObjectInputStream objIn = null;
        try {
            objIn = new ObjectInputStream
                    (new BufferedInputStream
                    (new FileInputStream("src/main/java/com/ohgiraffers/section03/filterstream/testObjectStream.txt")));

        while (true){
            System.out.println((MemberDTO) objIn.readObject());
        }

        } catch (EOFException e) {
            e.printStackTrace();
        } catch (IOException e) {
        e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } finally {
            if(objIn != null){
                try {
                    objIn.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
