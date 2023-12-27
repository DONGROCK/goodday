package com.ohgiraffers.section02.reflection;

import lombok.RequiredArgsConstructor;

//@RequiredArgsConstructor
public class Account {

    private String bankCode;
    private String accNo;

    private String accPwd;

    private int balance;

    public Account() {
    }

    public Account(String bankCode, String accNo, String accPwd) {
        this.bankCode = bankCode;
        this.accNo = accNo;
        this.accPwd = accPwd;
    }

    public Account(String bankCode, String accNo, String accPwd, int balance) {
        this.bankCode = bankCode;
        this.accNo = accNo;
        this.accPwd = accPwd;
        this.balance = balance;
    }

    /**
     * 현재 잔액을 출력하는 메소드
     * @return 잔액
     */
    public String getBalance() {
        return this.accNo + " 계좌의 현재 잔액은 " + this.balance + "원 입니다.";
    }

    /**
     * 잔액을 증가 시켜주는 메소드
     * @param money 금액
     * @return 잔액 + 금액의 합산값
     */
    public String deposit(int money) {

        String str = "";

        if(money >= 0) {
            this.balance += money;
            str = money + "원이 입금되었습니다.";
        } else {
            str = "금액을 잘못입력하셨습니다.";
        }

        return str;
    }

    /**
     * 잔액을 감소(출금) 시켜주는 메소드
     * @param money 금액
     * @return 잔액 - 금액의 값
     */
    public String withDraw(int money) {

        String str = "";

        if(this.balance >= money) {
            this.balance -= money;
            str = money + "원이 출금되었습니다.";
        } else {
            str = "잔액이 부족합니다. 잔액을 확인해주세요";
        }

        return str;
    }
}
