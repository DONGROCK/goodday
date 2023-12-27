package com.ohgiraffers.section04.wrapper;

public class Application1 {
    public static void main(String[] args) {

        /*
        * 기본타입      레퍼클래스
        * byte          Byte
        * short         Short
        * int           Integer
        * long          Long
        * float         Float
        * double        Double
        * char          Character
        * boolean       Boolean
        * */

        /*
        * 박싱(Boxing)과 언박싱(Unboxing)
        * 기본타입을 래퍼클래스의 인스턴스로 인스턴스화 하는 것을 박싱(Boxing)이라고하며
        * 래퍼클래스 타입의 인스턴스를 기본 타입으로 변경하는 것을 언박싱(Unboxing)이라고한다.
        * */

        int intValue = 20;
        Integer boxingNumber1 = new Integer(intValue); //인스턴스화 : 생성자를 이용해서
        Integer boxingNumber2 = Integer.valueOf(intValue); // static 메소드 이용 (박싱)

        int unBoxingNumber1 = boxingNumber1.intValue(); // 언박싱 : intValue()이용

        /*
        * 오토박싱(AutoBoxing) 과 오토 언박싱(AutoUnboxing)
        * JDK 1.5부터는 박싱과 언박싱이 필요한 상황에서 자바 컴파일러가 이를 자동으로 처리를 해준다.
        * */

        Integer boxingNumber3 = intValue;  //이게 오토박싱 이다! intValue가 int 형이기에
        int unBoxingNumber2 = boxingNumber3; //이게 오토언박싱이다!

        int inum = 20;
        Integer integerNum1 = new Integer(20); // 박싱
        Integer integerNum2 = new Integer(20);
        Integer integerNum3 = 20;                   // 오토박싱
        Integer integerNum4 = 20;
        /*기본타입과 래퍼클래스 타입은 == 연산으로 비교 가능하다.*/
        System.out.println("int 와 Integer 비교 : " + (inum == integerNum1));
        System.out.println("int 와 Integer 비교 : " + (inum == integerNum3));
        /*
        * 생성자를 이용해 생성한 이스턴스의 경우 == 비교 못하지만
        * 단 오토박싱을 이용해서 생성한 값은 == 로 비교가가능하다.
        * */
        System.out.println("integer와 integer 비교 : " + (integerNum1 == integerNum2));// 박싱은 주소값으로 비교
        System.out.println("integer와 integer 비교 : " + (integerNum1 == integerNum3));// 박싱은 주소값으로 비교
        System.out.println("integer와 integer equals로 비교 " + (integerNum1.equals(integerNum2)));// 다운캐스팅으로 값을 비교
        System.out.println("integer와 integer equals로 비교 " + (integerNum1.equals(integerNum3)));// 다운캐스팅해서 값으로 비교
        System.out.println("integer와 integer equals로 비교 " + (integerNum3.equals(integerNum4)));// 다운캐스팅해서 값으로 비교
        System.out.println("integer와 integer 비교 : " + (integerNum3 == integerNum4));//오토박싱은 값으로 비교

    /*
    * Integer.valueOf()를 이용해서 인스턴스를 생성하는 것을 더 권장한다.
    * valueOf()는 동일한 값이 동일한 인스턴스임을 보장한다.
    * */
        System.out.println("valueOf() : " + (Integer.valueOf(123) == Integer.valueOf(123)));
    }
}
