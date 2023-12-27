package com.ohgiraffers.section01.common;

import org.springframework.stereotype.Repository;

import java.util.*;

/* @Repository 는 @Component의 세분화된 어노테이션의 한종류이고 데이터베이스 관련된 처리에 특화되어있다.*/
@Repository("bookDAO")
public class BookDAOImpl implements BookDAO{

    private Map<Integer, BookDTO> bookList;

    public BookDAOImpl() {

        bookList = new HashMap<>();
        bookList.put(1, new BookDTO(1, 123345, "자바의 정석", "낭궁성", "도우출판", new Date()));
        bookList.put(2, new BookDTO(2, 582831, "칭찬은 고래도 춤추게 한다.", "고래", "고래출판", new Date()));
    }

    @Override
    public List<BookDTO> selectBookList() {
        return new ArrayList<>(bookList.values());
    }

    @Override
    public BookDTO selectOneBook(int sequence) {
        return bookList.get(sequence);
    }
}
