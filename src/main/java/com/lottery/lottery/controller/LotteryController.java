package com.lottery.lottery.controller;

import com.lottery.lottery.Entity.Ticket;
import com.lottery.lottery.pojo.LotteryCreateRequest;
import com.lottery.lottery.service.LotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController("v1")
public class LotteryController {

    @Autowired
    private LotteryService lottery;

    @PostMapping("/ticket")
    public void createTicket(@RequestBody LotteryCreateRequest lotteryCreateRequest){
        lottery.createLottery(10);
    }

    @GetMapping("/ticket")
    public List<Ticket> getAllTicket(){
        List<Ticket> tickets = new ArrayList<>();
        return tickets;
    }

    @GetMapping("/ticket/{id}")
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
    }
}
