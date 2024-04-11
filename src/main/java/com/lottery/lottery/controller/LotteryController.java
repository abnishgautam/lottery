package com.lottery.lottery.controller;

import com.lottery.lottery.exception.InvalidNoOfLineException;
import com.lottery.lottery.exception.TicketNotFoundException;
import com.lottery.lottery.pojo.LotteryCreateRequest;
import com.lottery.lottery.pojo.TicketResponse;
import com.lottery.lottery.service.LotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class LotteryController {

    @Autowired
    private LotteryService lottery;

    @PostMapping("/ticket")
    public ResponseEntity<String> createTicket(@RequestBody LotteryCreateRequest lotteryCreateRequest){
        if(lotteryCreateRequest.getNoOfLines() <= 0){
            throw new InvalidNoOfLineException("Number of lines should be greater than 0");
        }
        return new ResponseEntity<>(lottery.createLottery(lotteryCreateRequest.getNoOfLines()), HttpStatus.CREATED);
    }

    @GetMapping("/ticket")
    public ResponseEntity<List<TicketResponse>> getAllTicket(){
      return new ResponseEntity<>(lottery.getAllTickets(),HttpStatus.OK);
    }

    @GetMapping("/ticket/{id}")
    public ResponseEntity<TicketResponse> getTicket(@PathVariable String id) throws TicketNotFoundException {
        return new ResponseEntity<>(lottery.getTicket(id),HttpStatus.OK);
    }

    @PutMapping("/ticket/{id}")
    public ResponseEntity<TicketResponse> updateTicket(@PathVariable String id,
            @RequestBody LotteryCreateRequest lotteryCreateRequest) throws TicketNotFoundException {
        return new ResponseEntity<>(lottery.updateLottery(lotteryCreateRequest.getNoOfLines(), id), HttpStatus.CREATED);
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<Boolean> updateStatus(@PathVariable String id) throws TicketNotFoundException {
        return new ResponseEntity<>(lottery.getStatus(id), HttpStatus.CREATED);
    }
}
