package com.lottery.lottery.exception;

public class TicketNotFound extends Exception {
    public TicketNotFound(String s)
    {
        // Call constructor of parent Exception
        super(s);
    }
}