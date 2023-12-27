package com.ohgiraffers.section01.autowired.subsection02.constructor;

import com.ohgiraffers.section01.common.BookDAO;
import com.ohgiraffers.section01.common.BookDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookServiceConstructor")
//@RequiredArgsConstructor
public class BookService {

    private  BookDAO bookDAO;

    /* BookDAO 타입의 빈 객체를 생성자에 자동으로 주입해준다. */

//    public BookService() {
//    }

    @Autowired
    public BookService(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public List<BookDTO> selectAllBooks(){
        return bookDAO.selectBookList();
    }

    public BookDTO searchBookBySequence(int sequence) {

        return bookDAO.selectOneBook(sequence);
    }

}

/*
* Spring 4.3버전 이후로는 생성자가 한 개뿐이라면 @Autowired 어노테이션을 생략해도 자동으로 생성자 주입이 동작한다.
* 단, 생성자가 1개 이상일 경우에는 명시적으로 작성을 해주어야 한다.
* */

/*
* 생성자 주입의 '장점'
* - 객체가 생성 될 때 모든 의존성이 주입되므로 의존성을 보장할 수 있다.
*   - 순환참조에 대해 필드 주입/세터 주입은 메소드 실행 시점에 오류가 발생한다.
*   - 생성자 주입은 애플리케이션 실행 시점에 오류가 발생한다.
* - 객체의 불변성을 보장할 수 있다.
*   - 필드에 final 사용가능하고 객체 생성 이후 의존성을 변경할 수 없어 안정성이 보장된다.
* - 코드 가독성이 좋다.
*   -> 해당 객체가 어떤 의존성을 가지고 있는지 명확히 알 수 있다.
* - DI컨테이너와의 결합도가 낮기 때문에 테스트하기 좋다.
*   - 스프링 컨테이너 없이 테스트를 할 수 있다.
*
*
*
*
*
*
* */