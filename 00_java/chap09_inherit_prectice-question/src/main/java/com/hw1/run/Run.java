package com.hw1.run;

import com.hw1.model.dto.Employee;
import com.hw1.model.dto.Student;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[3];

        students[0] = new Student("홍길동", 20, 178.2, 70, 1, "정보시스템공학과");
        students[1] = new Student("김말똥", 21, 187.3, 80, 2, "경영학과");
        students[2] = new Student("강개순", 23, 167, 45, 4, "정보통신공학과");

        for (Student stu : students) {
            System.out.println(stu.information());
        }
        int count = 0;

        Employee[] employees = new Employee[10];

        while (true) {
            System.out.print("이름 입력 : ");
            String name = sc.next();
            System.out.print("나이 입력 : ");
            int age = sc.nextInt();
            System.out.println("키 입력 : ");
            double helght = sc.nextDouble();
            System.out.println("몸무게 입력 : ");
            double weight = sc.nextDouble();
            System.out.println("급여 입력 : ");
            int salary = sc.nextInt();
            System.out.println("부서 입력 : ");
            String dept = sc.next();

            employees[count] = new Employee(name, age, helght, weight, salary, dept);

            count++;

            System.out.println("더 추가하시겠습니까? y / n");
            sc.nextLine();

            String yn = sc.nextLine().toUpperCase();
            if (!yn.equals("Y")) {
                break;
            }

        }
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i].information());
        }

    }


}

