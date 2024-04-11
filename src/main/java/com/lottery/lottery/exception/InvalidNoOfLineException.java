package com.lottery.lottery.exception;

public class InvalidNoOfLineException extends RuntimeException{

    private String message;
    public InvalidNoOfLineException(String message) {
        super(message);
        this.message = message;
    }
    public InvalidNoOfLineException() {
    }
}
