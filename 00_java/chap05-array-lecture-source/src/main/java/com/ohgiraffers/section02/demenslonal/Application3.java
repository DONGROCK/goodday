package com.ohgiraffers.section02.demenslonal;

public class Application3 {
    public static void main(String[] args) {

        /*2차원 가변배열을 선언 및 할당하여 사용
        *
        * 가변 배열의 경우 각 인덱스별 배열을 따로 할당을 해야만 한다.
        * 선언과 동시에 모든 배열을 할당할 수 없으며, 할당할 배열의 갯수만 지정하고
        * 각 인덱스에 서로 다른길이의 배열을 따로 할당해야한다.
        * 자료형[][] 변수명 = new 자료형[할당할 배열의 갯수][]
        * 변수명[배열 인덱스] = new 자료형[배열의 길이]
        * */

        int[][] iarr = new int[3][]; // 각 인덱스에는 즉 iarr[0], iarr[1], iarr[2] 에는 null 값

        iarr[0] = new int[3];
//        iarr[1] = new char[2]; // 자료형이 다른 배열은 하나로 묶어서 관리할 수 없다.
        iarr[1] = new int[2];

        int[] arr= new int[5];
        iarr[2] = arr; // 미리 할당해둔 배열을 이용해서도 활용할 수 있다.

        iarr[0][0] = 1;
        iarr[0][1] = 2;
        iarr[0][2] = 3;
//        iarr[0][4] = 4; // ArrayIndexOutOfBoundsException 발생 왜냐 존재하지 않은 인덱스를 접근했기 때문

        iarr[1][0] = 4;
        iarr[1][1] = 5;

//        iarr[2][0] = 5; 만약 내가 iarr[2]와 배열의
        System.out.print(iarr[0][0]);
        System.out.print(iarr[0][1]);
        System.out.print(iarr[0][2]);
        System.out.print(iarr[1][0]);
        System.out.print(iarr[1][1]);

        int value = 0;
        for (int i = 0; i < iarr.length; i++){
            for (int j = 0; j < iarr[i].length;j++){
                iarr[i][j] = ++value;

                System.out.println(iarr[i][j]);
            }


        }
        for (int i = 0; i < iarr.length ; i++){
            for (int j = 0; j < iarr[i].length;j++){
                System.out.println(iarr[i][j]);
            }
            System.out.println();
        }
    }
}
