package com.ohgiraffers.section03.branching;

public class B_continue {

    public void testSimpleContinue(){
        /*continue는 모든 반복문을 건너뛰는 것이 아닌, 자신에게 가장 인접한 반복문 실행만 건너뛴다.*/
        for(int dan = 2; dan < 10; dan++){

            for(int su = 1; su < 10; su++){
                if(su % 2 == 0){
                    /*su가 짝수인 경우 해당 회차 반복 내용을 건너 뛰고 증감식으로 이동*/
                    continue;
                }
                System.out.println(dan + " * " + su + " = " + (dan * su));
            }
            System.out.println("");
        }
    }
    public void testJumpContinue(){
        label:
        for(int dan = 2; dan < 10; dan++){

            for(int su = 1; su < 10; su++){
                if(su % 2 == 0){
                    /*su가 짝수인 경우 해당 회차 반복 내용을 건너 뛰고 증감식으로 이동*/
                    continue label;
                }
                System.out.println(dan + " * " + su + " = " + (dan * su));
            }
            System.out.println();
        }
    }
    }

