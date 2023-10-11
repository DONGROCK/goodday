package com.ohgiraffers.hw2.run;

import com.ohgiraffers.hw2.model.dto.StudentDTO;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDTO[] student = new StudentDTO[10];
        int count = 0;

        while(true){
            System.out.print("학년 : ");
            int grade = sc.nextInt();
            System.out.print("반 : ");
            int classroom = sc.nextInt();
            System.out.print("이름 : ");
            String name = sc.next();
            System.out.print("국어점수 : ");
            int kor = sc.nextInt();
            System.out.print("영어점수 : ");
            int eng = sc.nextInt();
            System.out.print("수학점수 : ");
            int math = sc.nextInt();

            student[count] = new StudentDTO(grade, classroom, name, kor, eng, math);

            count++;

            System.out.print("더 추가 할까요? y/n");
            sc.nextLine();

            String str = sc.nextLine().toUpperCase(); //toUpperCase 이게 대소문자 상관없다 그런거..
            if (str.equals("N"))
                break;
        }
        for(StudentDTO s : student){ //여기를 모르겠음 잘
            if(s == null){
                break;
            }
            int sum = s.getKor() + s.getEng() + s.getMath();

            System.out.println(s.information() + ", 평균=" + sum / 3);
        }
    }
}
