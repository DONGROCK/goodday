package com.ohgiraffers.section01.list.run;

import java.util.*;

public class Application1 {
    public static void main(String[] args) {

        /*
        * 컬랙션 프레임워크(Collection Framework)
        * 자바에서 컬렉션 프레임워크는 여러 개의 다양한 데이터들을 쉽고 효과적으로 처리할 수 있도록 표준화된 방법을 제공하는
        * 클래스들의 집합을 의미한다.
        * 즉, 데이터는 효울적으로 저장하는 자료구조와 데이터를 처리하는 알고리즘을 미리 구현해놓은 클래스를 말한다.
        * */

        /*
        * List계열 : List인터페이스를 구현한 모든 클래스는 요소의 저장 순서가 유지되며 중복 저장을 허용한다.
        *
        * ArrayList
        * 가장많이 사용되는 컬렉션 클래스이다.
        * JDK 1.2부터 제공된다,
        * -> 내부적으로 배열을 이용하여 요소를 관리하며, 인덱스를 이용해 배열 요소에 빠르게 접근할수있다.
        *
        * */
                //주소값
        ArrayList alist = new ArrayList();

        List list = new ArrayList();

        Collection clist = new ArrayList();

        alist.add("apple");
        alist.add(123);  // autoBoxing(값  - - > 객체)
        alist.add(45.67);
        alist.add(new Date());
        System.out.println("alist" + alist);

        /*
        * Array의 크기는 size()메소드로 확인
        * 단, size()메소드는 배열의 크기가 아닌 요소의 갯수를 반환한다.
        * */
        System.out.println("alist의 size : " + alist.size());
        for (int i = 0; i < alist.size();i++){
            /*get()메소드 : 인덱스에 해당하는 값을 가져올 때 사용*/
            System.out.println(i + " : " + alist.get(i));
        }
        /*
        * ArrayList는 데이터의 중복 저장을 허용*/

        alist.add("apple");
        System.out.println("alist : " + alist);
        alist.add(1, "banana");
        System.out.println("alist : " + alist);

        alist.remove(2);
        System.out.println("alist : " + alist);

        //1번인덱스 불린타입 true로 바뀌어라
        alist.set(1,Boolean.valueOf(true));
        System.out.println("alist : " + alist);

        List<String> stringList = new ArrayList<>();
        stringList.add("apple");
//        stringList.add(2); //제네릭을 String으로 해서 인트값 ㄴㄴ

        stringList.add("banana");
        stringList.add("orange");
        stringList.add("mango");
        stringList.add("grape");

        System.out.println("stringList : " + stringList);//[apple, banana, orange, mango, grape]

        Collections.sort(stringList); //오름차순??

        /*sort메소드를 사용하면 list가 오름차순 정렬 처리된 후 정렬 상태가 유지된다.*/
        System.out.println("stringList : " + stringList);//[apple, banana, grape, mango, orange]

        /*내리마순은 제공되는 메소드가 없고 다른 코드를 작성해서 사용해야 한다.*/

        stringList = new LinkedList<>(stringList); // arrayList - > LinkdList 변환

        /*
        * Iterator란
        * Collection 인터페이스의 iterator() 메소드를 이용해서 인스턴스를 생성할 수 있다.
        * 컬렉션에서 값을 읽어오는 방식을 통일된 방식으로 제공하기 위해 사용한다.
        * 반복자라고 불리우며, 반복문을 이용해서 목록을 하나씩 꺼내는 방식으로 사용하기 위함이다.
        *
        * 인덱스로 관리되는 컬렉션이 아닌경우에는 반복문을 사용해서 요소에 하나씩 접근할 수 없기 때문에
        * 인덱스를 사용하지 않고도 반복문을 사용하기 위한 목록을 만들어주는 역할이라고 보면 된다.
        * hasNext() : 다음 요소를 가지고 있는 경우 true, 더이상 요소가 없는 경우 false를 반환
        * next() : 다음 요소를 반환
        * */

        //오름차순 : ASC
        //내림차순 : DESC
        Iterator<String> dIter = ((LinkedList<String>)stringList).descendingIterator();

//        while (dIter.hasNext()){
//            System.out.println(dIter.next());
//        }
//        //위에서 한번 꺼내면 여기서는 더이상 꺼내올 것이없다.
//        while (dIter.hasNext()){
//            System.out.println(dIter.next());
//        }

        List<String> descList = new ArrayList<>();

        while (dIter.hasNext()){
            descList.add(dIter.next());
        }
        System.out.println("descList = " + descList);

    }
}
