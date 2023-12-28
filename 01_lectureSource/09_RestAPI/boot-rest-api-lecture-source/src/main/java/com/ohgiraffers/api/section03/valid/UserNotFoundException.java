package com.ohgiraffers.api.section03.valid;

//Throwable
public class UserNotFoundException extends Exception {
    public UserNotFoundException(String msg) {
        super(msg);
    }
}
