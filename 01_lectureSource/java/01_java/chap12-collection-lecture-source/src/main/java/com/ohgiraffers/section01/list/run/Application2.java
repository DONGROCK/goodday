package com.ohgiraffers.section01.list.run;

import com.ohgiraffers.section01.list.comparator.AscendingPrice;
import com.ohgiraffers.section01.list.dto.BookDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Application2 {
    public static void main(String[] args) {

        List<BookDto> bookList = new ArrayList<>();

        bookList.add(new BookDto(1, "헝기르동전", "헝균", 50000));
        bookList.add(new BookDto(2, "목민심서", "정약용", 30000));
        bookList.add(new BookDto(3, "동의보감", "허준", 60000));
        bookList.add(new BookDto(4, "흥부와놀비", "놀부", 90000));
        bookList.add(new BookDto(5, "까치와참새", "비둘기", 66666));

        System.out.println("bookList = " + bookList);

        /*sort()메소드는 Comparable 타입을 가지고 있는 경우에만 사용이 가능하다.(제네릭의 타입제한에 의해)
         * */

//        Collections.sort(bookList);

        bookList.sort(new AscendingPrice()); //가격 오름차순
        System.out.println("가격 오름차순 정렬ㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹ");
        for (BookDto book : bookList) { //리스트를 BookDto book 에 넘기는건가?
            System.out.println(book);
        }
        bookList.sort(new Comparator<BookDto>() {//제목 오름차순
            @Override
            public int compare(BookDto o1, BookDto o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });

        bookList.sort(new Comparator<BookDto>() { //익명 클래스라고 한다. 다른곳에서 재사용 불가 오직 이 클래스 이소스에서만 실행이 가능 하다.
            @Override
            public int compare(BookDto o1, BookDto o2) {
                return o1.getPrice() >= o2.getPrice() ? -1 : 1;
            }
        });
        System.out.println("가격 내림차순 정렬ㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹ");
        for (BookDto book : bookList) {
            System.out.println(book);
        }


        System.out.println("제목 오름차순 정렬ㄹㄹㄹㄹㄹㄹㄹㄹ");
        for (BookDto book : bookList) {
            System.out.println(book);
        }
    }


}


        /*람다식*/
//        bookList.sort((BookDto b1, BookDto b2) -> b2.getTitle().compareTo(b1.getTitle()));


