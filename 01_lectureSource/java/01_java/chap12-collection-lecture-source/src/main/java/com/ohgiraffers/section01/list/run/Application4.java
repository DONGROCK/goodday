package com.ohgiraffers.section01.list.run;

import java.util.Stack;

public class Application4 {
    public static void main(String[] args) {
        
        /*
        * stack
        * stack은 리스트 계열 클래스의 Vector 클래스를 상속받아 구현하였다.
        * 스택 메모리 구조는 선형 메모리 공간에 데이터를 저장하며
        * 후입선출(LIFO - Last Input First Out) 방식의 자료 구조라 불린다.
        * */
        
        Stack<Integer> integerStack = new Stack();
        
        /*
        * stack에 값을 넣을 때는 push()메소드를 이용
        * add()도 사용가능하지만 push()를 사용하는 것이 좋다.
        * */
        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(3);
        integerStack.push(4);
        integerStack.push(5);
        System.out.println("integerStack = " + integerStack);

        /*
        * 스택에서 요소를 찾을 때는 search()메소드를 이용할 수 있다.
        * -> 인덱스가 아닌 위에서부터 순번을 의미한다.
        * -> 가장 상단의 위치가 0이 아닌 1부터 시작한다.
        * */
        System.out.println("integerStack.search = " + integerStack.search(1));
        System.out.println("integerStack.search = " + integerStack.search(2));
        System.out.println("integerStack.search = " + integerStack.search(3));
        System.out.println("integerStack.search = " + integerStack.search(4));
        System.out.println("integerStack.search = " + integerStack.search(5));

        /*
        * stack에서 값을 꺼내는 메소드
        * peek() : 해당 스택의 가장 마지막에 있는 (상단에 있는) 요소 반환
        * pop() : 해당 스택의 마지막에 있는 (상단에 있는) 요소 반환 후 제거
        * */

        System.out.println("peek() : " + integerStack.peek()); //5
        System.out.println("integerStack = " + integerStack);// 1, 2, 3, 4, 5
        System.out.println("pop() : " + integerStack.pop());//5
        System.out.println("pop() : " + integerStack.pop());//4
        System.out.println("pop() : " + integerStack.pop());//3
        System.out.println("pop() : " + integerStack.pop());//2
        System.out.println("pop() : " + integerStack.pop());//1
//        System.out.println("pop() : " + integerStack.pop());// EmptyStackException 발생
        System.out.println(integerStack);// 1, 2, 3, 4
    }
}
