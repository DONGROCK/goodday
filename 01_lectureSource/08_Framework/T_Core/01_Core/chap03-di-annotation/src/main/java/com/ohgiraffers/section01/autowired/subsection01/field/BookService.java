package com.ohgiraffers.section01.autowired.subsection01.field;

import com.ohgiraffers.section01.common.BookDAO;
import com.ohgiraffers.section01.common.BookDAOImpl;
import com.ohgiraffers.section01.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/* @Service : @Component의 세분화 어노테이션의 한 종류로 Service계층에서 사용한다. */
/*
* @Service어노테이션을 선언하고 이름을 붙이지 않으면 클래스의 첫 대문자를 소문자로한 이름을 아이디로 사용
* */
@Service("bookServiceField")
public class BookService {

    // 필드주입
    @Autowired
    private BookDAO bookDAO;

    /**
     * 도서 목록 전체 조회
     * @return 도서 전체 목록
     */
    public List<BookDTO> selectAllBooks() {

        return bookDAO.selectBookList();
    }

    /**
     * 도서번호로 도서 조회
     * @param sequence 도서번호
     * @return 조회된 도서정보
     */
    public BookDTO searchBookBySequence(int sequence){

        return bookDAO.selectOneBook(sequence);
    }
}
