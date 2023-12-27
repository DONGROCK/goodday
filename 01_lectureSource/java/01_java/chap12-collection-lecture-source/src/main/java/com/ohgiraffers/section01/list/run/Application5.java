package com.ohgiraffers.section01.list.run;

import java.util.LinkedList;
import java.util.Queue;

public class Application5 {
    public static void main(String[] args) {

        /*
        * Queue
        * Queue는 선형 메모리 공간에 데이터를 저장하는
        * 선입선출(FiFo - First Input First Out) 방식의 자료구조이다.
        *
        * Queue 인터페이스를 상속받는 하위 인터페이스들은
        * Deque, BlockingQueue, BlockingDeque, TransferQueue 등 다양하지만
        * 대부분의 큐는 lickedList를 이용한다.
        * */

        //Queue자체로는 인터페이스 이기떄문에 인스턴스 생성이 불가능하다.
//        Queue<String > que = new Queue<>();

        Queue<String> que = new LinkedList<>();

        /*큐에 데이터를 넣을 때는 offer() 메소드를 이용*/
        que.offer("First");
        que.offer("second");
        que.offer("third");
        que.offer("fourth");
        que.offer("fifth");

        System.out.println(que);

        /*
        * peek() : 해당 큐의 가장 앞에 있는 요소(먼저 들어온 요소)를 반환
        * poll() : 해당 큐의 가장 앞에 있는 요소(먼저 들어온 요소)를 반환하고 제거한다.
        * */
        System.out.println("que.peek() : " + que.peek()); // 제거하지 않기에 2번을 해도 같은 값
        System.out.println("que.peek() : " + que.peek());
        System.out.println(que);

        System.out.println("que.poll() : " + que.poll());// 제거를 하기에 first 다음엔 second
        System.out.println("que.poll() : " + que.poll());
        System.out.println(que);



    }
}
