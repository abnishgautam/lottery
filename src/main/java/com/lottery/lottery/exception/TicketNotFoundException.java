package com.lottery.lottery.exception;

public class TicketNotFoundException extends Exception {
    private String message;
    public TicketNotFoundException(String message) {
        super(message);
        this.message = message;
    }
    public TicketNotFoundException() {
    }
}