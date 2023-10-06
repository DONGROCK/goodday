package com.greedy.level02.normal.book.run;

import com.greedy.level02.normal.book.model.dto.BookDTO;

public class Application {
    public static void main(String[] args) {
        BookDTO book1 = new BookDTO();
        System.out.println(book1.printInfomation());

        BookDTO book2 = new BookDTO("자바의 정석","도우출판","남궁성");
        System.out.println(book2.printInfomation());

        BookDTO book3 = new BookDTO("홍길동전", "활빈당", "허균",5000000, 0.5);
        System.out.println(book3.printInfomation());
    }
}
