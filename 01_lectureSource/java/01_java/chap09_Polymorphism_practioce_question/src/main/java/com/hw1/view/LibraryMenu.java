package com.hw1.view;

import java.util.Scanner;

public class LibraryMenu {

    public void mainMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.print("회원명 입력: ");
        String name = sc.next();
        System.out.print("회원나이 입력: ");
        int age = sc.nextInt();
        System.out.println("회원성별 입력: ");
        char gender = sc.next().charAt(1);

    }
    public void selectAll(){

    }
    public void searchBook(){

    }
    public void rentBook(){

    }
}
