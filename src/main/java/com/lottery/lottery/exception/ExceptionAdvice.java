package com.lottery.lottery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(value = InvalidNoOfLineException.class)
    public ResponseEntity invalidNoOfLinesException(InvalidNoOfLineException invalidNoOfLineException) {
        return new ResponseEntity(invalidNoOfLineException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = TicketNotFoundException.class)
    public ResponseEntity ticketNotFoundException(TicketNotFoundException ticketNotFoundException) {
        return new ResponseEntity(ticketNotFoundException.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
