package com.fastcampus.investment.exception;

public class IllegalUserException extends RuntimeException {

    private static final String message = "유효하지 않은 사용자입니다.";

    public IllegalUserException(){
        super(message);
    }
}
