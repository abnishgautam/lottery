package com.lottery.lottery.controller;

import com.lottery.lottery.Entity.Ticket;
import com.lottery.lottery.pojo.LotteryCreateRequest;
import com.lottery.lottery.pojo.TicketResponse;
import com.lottery.lottery.service.LotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
public class LotteryController {

    @Autowired
    private LotteryService lottery;

    @PostMapping("/ticket")
    public ResponseEntity<Integer> createTicket(@RequestBody LotteryCreateRequest lotteryCreateRequest){
        return new ResponseEntity<>(lottery.createLottery(lotteryCreateRequest.getNoOfLines()), HttpStatus.CREATED);
    }

    @GetMapping("/ticket")
    public ResponseEntity<List<TicketResponse>> getAllTicket(){
      return new ResponseEntity<>(lottery.getAllTickets(),HttpStatus.OK);
    }

/*    @GetMapping("/ticket/{id}")
    public Ticket getTicket(){
        Ticket ticket = new Ticket();
        return ticket;
    }

    @PutMapping("/ticket/{id}")
    public Ticket updateTicket(){
        Ticket ticket = new Ticket();
        return ticket;
    }

    @PutMapping("/status/{id}")
    public Ticket updateStatus(){
        Ticket ticket = new Ticket();
        return ticket;
    }*/
}
