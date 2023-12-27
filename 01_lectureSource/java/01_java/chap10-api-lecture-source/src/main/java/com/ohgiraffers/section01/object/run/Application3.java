package com.ohgiraffers.section01.object.run;

import com.ohgiraffers.section01.object.book.Book;

import java.util.HashMap;
import java.util.Map;

public class Application3 {

    /*hashcode() 메소드 오버라이딩 목적
    *
    * Object 클래스의 명세서에 작성된 일반 규약에 따르면
    * equals() 메소드를 재정의 하는 경우 반드시 hashcode() 메소드도 재정의 하도록 되어있다.
    * 만약 hashcode()를 재정의 하지 않으면 같은 갑을 가지는 동등객체는
    * 같은 해시코드값을 가져야하는 규약에 위반되게 된다.
    * (강제성은 없지만 규약대로 작성하는 것이 좋다.)
    * */
    public static void main(String[] args) {
        Book book1 = new Book(1, "홍길동전","허균", 50000);
        Book book2 = new Book(1, "홍길동전","허균", 50000);

//        동등객체: 주소가 다르더라도 필드값이 동일한 객체를 동등객체라고 한다
        System.out.println("book1의 hashcode() : " + book1.hashCode());
        System.out.println("book2의 hashcode() : " + book2.hashCode());

        /*-------------------------------------------------------------------------*/
        Map<Book, String> map = new HashMap();
        map.put(new Book(1, "홍길동전", "허균",50000),"selled");
        String str = map.get(new Book(1, "홍길동전", "허균",50000));
        System.out.println(str);
    }
}
