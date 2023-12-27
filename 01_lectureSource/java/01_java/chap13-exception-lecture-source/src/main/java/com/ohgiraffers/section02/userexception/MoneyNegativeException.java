package com.ohgiraffers.section02.userexception;

import com.ohgiraffers.section02.userexception.exception.NegativeException;

public class MoneyNegativeException extends NegativeException {
//    public NegativeException(String message){
//
//    }

    public MoneyNegativeException(String message) {
        super(message);
    }
}
