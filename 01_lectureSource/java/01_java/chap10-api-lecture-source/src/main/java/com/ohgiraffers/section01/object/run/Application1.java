package com.ohgiraffers.section01.object.run;

import com.ohgiraffers.section01.object.book.Book;

public class Application1 {
    public static void main(String[] args) {

        Book book1 = new Book(1, "홍길동전","허균", 50000);
        Book book2 = new Book(2, "목민심서","정약용", 30000);
        Book book3 = new Book(2, "목민심서","정약용", 30000);

        /*toString()의 원래기능은 풀클래스명 + @ + 16진수 해쉬코드 출력해준다.*/
        System.out.println("book1.toString() : " + book1.toString());
        System.out.println("book2.toString() : " + book2.toString());
        System.out.println("book3.toString() : " + book3.toString());

        System.out.println("book1 : " + book1);
        System.out.println("book2 : " + book2);
        System.out.println("book3 : " + book3);
    }

}
