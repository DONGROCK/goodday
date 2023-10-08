package com.ohgiraffers.section01.level02.normal;

import java.util.Arrays;
import java.util.Random;

public class Application4 {

    public static void main(String[] args) {

        int[] lotto = new int[6];
        for (int i = 0; i < 6; i++){
            lotto[i] = (int) (Math.random() * 45) + 1;

        for (int j = 0; j < i; j++){
            if (lotto[i] == lotto[j]){
                i--;
                break;
            }
        }
        }
        for (int i = 0; i < lotto.length ; i++){
            Arrays.sort(lotto); // 배열 오름차순
            System.out.print(lotto[i] + " ");
        }



     /*
		  로또 번호 자동 생성기 프로그램을 작성하세요.
		  단, 중복 값 없이 오름차순으로 정렬하여 출력하세요.

		  Random 클래스 사용 혹은 Math.random() 메소드를 사용
	   */
    }
}
