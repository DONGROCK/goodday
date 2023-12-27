package com.ohgiraffers.section01.list.comparator;

import com.ohgiraffers.section01.list.dto.BookDto;

import java.util.Comparator;

public class AscendingPrice implements Comparator<BookDto> {//가격기준 오름차순 하겠다!
    /*
    * 비겨 대상 두 인스턴스의 가격이 오름차순이 되기 위해서는
    * 앞의 가격이 더 적은 가격이여야 한다.
    *
    * 만약 뒤의 가격이 더 적은 경우에는 두 인스턴스의 순서를 바꿔야 한다..
    * - -> 두 값을 바꾸라는 신호로 양수를 보내주게되면 정렬 시 순서를 바꿔라라는 조건으로 사용
    * 같으면 아무것도 안한다.*/

    @Override
    public int compare(BookDto o1, BookDto o2) {
        //오름차순 하겠다.
        int result = 0;

        if (o1.getPrice() > o2.getPrice()){
            return 1;
        } else if (o1.getPrice() < o2.getPrice()) {
            result = -1;
        }else {
            result = 0;
        }

        return result;
    }


}
