package com.ohgiraffers.section03.copy;

import java.util.Arrays;

public class Application3 {
    public static void main(String[] args){

        /*깊은 복사
        *
        *깊은 복사는 heap에 생성된 배열이 가지고 있는 값을 또다른 배열에 복사를 해 놓은 것이다,
        * 서로 같은 값을 가지고 있지만, 두 배열은 서로 다른 배열이기에 하나의 배열에 변경을 하더라도
        * 다른 배열에는 영향을 주지 않는다
        *
        * 깊은복사를 하는 방법은 4가지
        * for문을 이용한 동일한 인덱스의 값 복사
        * Object의 clone()을 이용한 복사
        * System의 arraycopy()를 이용한 복사
        * Array의 copyOf()를 이용한 복사
        *
        * 이중에 가장 높은 성능을 보이는 것은 순수 배열의 복사를 위해 만들어진 arraycopy()메소드이며
        * 가장많이 사용되는 방식은 좀더 유연한 방식인 copyOf()메소드이다
        *
        * clone()은 이전배열과 같은 배열밖에 만들수 없다는 특징을 가지고 그 외 3가지 방법은 복사하는 배열의 길이를 마음대로 조절할 수 있다는 특징을 가지고 있따.*/

        int[] originArr = new int[] {1,2,3,4,5};

        print(originArr);

        /*1, for문을 이용한 동일한 인덱스 값 복사*/
        int[] copyArr1 = new int[10];

        for (int i = 0 ; i < originArr.length;i++){
            copyArr1[i] = originArr[i];
        }
        print(copyArr1);

        /*2. Object의 clone()을 이용한 복사*/
        int[] copyArr2 = originArr.clone();

        print(copyArr2);//동일한 길이, 도일한 값을 가지는 배열이 생성되어 복사되며, 다른 주소를 가지고 있다.

        /*3. System의 arraycopy()를 이용한 복사.*/
        int[] copyArr3 = new int[10];
        /*매개변수의 값 순서는 원본배열, 복사를 시작할 인덱스, 복사본 배열, 복사를 시작할 인덱스, 복사할 길이 의미를 가진다.*/
        System.arraycopy(originArr, 0, copyArr3, 3, originArr.length);

        print(copyArr3);

        /*Arrays의 copyOf()를 이용한 복사
        * 시작 인덱스부터 원하는 길이만큼만 복사해서 사용가능하다.*/

        int[] copyArr4 = Arrays.copyOf(originArr, 7);

        print(copyArr4);
    }

    public static void print(int[] iarr){
        System.out.println("iarr의 hashcode : " + iarr.hashCode());

        for (int i = 0; i < iarr.length; i++){
            System.out.print(iarr[i] + " ");
        }
        System.out.println();

    }
}
