package com.ohgiraffers.section04.sort;

public class Application1 {

    public static void main(String[] args) {

        int num1 = 10;
        int num2 = 20;
        System.out.println("변경전 num1 : " + num1);
        System.out.println("변경전 num2 : " + num2);
        /*두변수의 값을 바꾸기 위해서 다른 변수 한개가 더 필요*/
        int temp;
        temp = num1;
        num1 = num2;
        num2 = temp;
        System.out.println("변경 후 num1 : " + num1);
        System.out.println("변경 후 num2 : " + num2);

        int[] arr = {2, 1, 3};

        int temp2;
        temp2 = arr[0];
        arr[0] = arr[1];
        arr[1] = temp2;

        for (int i = 0 ; i < arr.length; i++){
            System.out.print(arr[i] + "");
        }
    }
}
