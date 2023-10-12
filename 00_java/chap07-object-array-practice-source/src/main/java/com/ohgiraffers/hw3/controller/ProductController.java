package com.ohgiraffers.hw3.controller;

import com.ohgiraffers.hw3.model.vo.ProductDTO;

import java.util.Scanner;

public class ProductController {
    Scanner sc = new Scanner(System.in);
    ProductDTO[] pro = new ProductDTO[10];
    int count = 0;

    public void mainManu(){
        do {
            System.out.println("===제품관리메뉴===");
            System.out.println("1. 제품 정보 추가");
            System.out.println("2. 제품 전체 조회");
            System.out.println("9. 프로그램 종료");
            System.out.println();
            System.out.print("원하는 메뉴 번호를 입력 : ");

            int num = sc.nextInt();
            sc.nextLine();

        }while (num != 9);



    }if(){

    }

    public void productput(){
        Scanner sc = new Scanner(System.in);
        System.out.print("제품번호 입력 : ");
        int pid = sc.nextInt();
        System.out.println("제품명 입력 : ");
        String pName = sc.next();
        System.out.println("제품 가격 입력 : ");
        int price = sc.nextInt();
        System.out.println("제품 세금 입력 : ");
        double tax = sc.nextDouble();
        pro [count] = new ProductDTO(pid,pName,price,tax);
        count++;
    }

    public void productPrint(){
        System.out.println("===입력된 제품 정보===");

    }

}
