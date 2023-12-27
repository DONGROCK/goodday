package com.ohgiraffers.section03.uses;

import java.io.*;
import java.nio.Buffer;

public class Application1 {
    public static void main(String[] args) {

        /*예외처리를 가장 많이 활용하는 것이 io(input/output) 패키지이다.*/
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader("text.dat"));

            String s;

            while ((s = in.readLine()) != null) {
                System.out.println(s);
            }
        } catch (FileNotFoundException | EOFException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null){
                    in.close();
            }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
