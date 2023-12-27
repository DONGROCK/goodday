package com.ohgiraffers.section02.set.run;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
//import java.util.Set;

public class Application1 {

    /*
    Set 인터페이스를 구현한 Set컬랙션 클래스의 특징
    * 1. 요소의 저장 순서를 유지하지 않는다.
    * 2. 같은 요소의 중복 저장을 허용하지 않는다.(null값도 중복하지 않게 하나의 null만 저장한다.)
    * */

    /*
    * HashSet 클래스
    * Set 컬랙션 클래스에서 가장 많이 사용되는 클래스 중 하나이다.
    * JDK 1.2 부터 제공하고 있으며 해시 알고리즘을 사용하여 검색 속도가 빠르다는 장점을 가진다.
    * */

    public static void main(String[] args) {
        HashSet<String> hset = new HashSet<>();

        /*다형성을 적용해서 상위 인터페이스를 타입으로 사용가능*/
        Set hset2 = new HashSet();
        Collection hset3 = new HashSet();

        hset.add(new String("java"));
        hset.add(new String("oracle"));
        hset.add(new String("jdbc"));
        hset.add(new String("html"));
        hset.add(new String("css"));

        /*저장 순서 유지 않음*/
        System.out.println("hset : " + hset);

        hset.add(new String("java"));

        System.out.println("hset = " + hset);
        System.out.println("저장된 객채수 : " + hset.size());
        System.out.println("포함확인 : " + hset.contains(new String("oracle")));

        /*
        * 저장된 객체를 하나씩 꺼내는 기능은 없다.
        *
        * 반복문을 이용한 연속처리하는 방법
        * */
        /* 1. toArray()배열로 바꾸고 for loop 사용 */
        Object[] arr = hset.toArray();
        for (int i = 0; i < arr.length ; i++){
            System.out.println(i + " : " + arr[i]);
        }

        /* 2. iterator()로 목록 만들어 연속처리*/
        Iterator<String> iter = hset.iterator();

        while (iter.hasNext()){
            System.out.println(iter.next());
        }

        hset3.clear();
        System.out.println("epmty : " + hset.isEmpty()); //뭐가 있냐
    }
}
