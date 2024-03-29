package com.lottery.lottery.service.impl;

import com.lottery.lottery.Entity.Ticket;
import com.lottery.lottery.pojo.TicketResponse;
import com.lottery.lottery.service.LotteryService;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.*;

@Service
public class LotteryServiceImpl implements LotteryService {

    private Map<Integer, Ticket> ticketMap = new HashMap<>();

    public static void main(String[] args) {
        LotteryServiceImpl lotteryService = new LotteryServiceImpl();
        lotteryService.createLotteryLines(10);
        LotteryServiceImpl lotteryService1 = new LotteryServiceImpl();
        lotteryService1.createLotteryLines(12);
        lotteryService1.getAllTickets();
    }

    public Integer createLottery(int numberOfLines){
        List<String> listOfLines = createLotteryLines(numberOfLines);
        Ticket ticket = new Ticket(listOfLines);
        Integer ticketId = ticket.hashCode();
        ticketMap.put(ticketId,ticket);
        return ticketId;
    }

    @Override
    public List<TicketResponse> getAllTickets() {
        List<TicketResponse> ticketResponses = new ArrayList<>();

        for (Map.Entry<Integer, Ticket> entry : ticketMap.entrySet()){
            TicketResponse ticketResponse = new TicketResponse();
            ticketResponse.setTicketId(entry.getKey());
            ticketResponse.setNoOfLines(entry.getValue().getLines());
            ticketResponses.add(ticketResponse);
        }
        System.out.println("TicketList");
        ticketResponses.stream().forEach(System.out::println);

        return ticketResponses;
    }

    @Override
    public TicketResponse getTicket(int id) {
        TicketResponse ticketResponse = new TicketResponse();

        ticketResponse.setTicketId(id);
        Ticket ticketValue = ticketMap.get(id);
        ticketResponse.setNoOfLines(ticketValue.getLines());
        ticketResponse.setStatusChecked(ticketValue.isStatusChecked());

        return ticketResponse;
    }

    public List<String> createLotteryLines(int numberOfLines) {
        List<String> integerList = new ArrayList<>();
        for (int i = 0; i <= numberOfLines; i++) {
            integerList.add(getUnique(3));
        }
        integerList.stream().forEach(System.out::println);
        return integerList;
    }


    public static String getUnique(int ndigits) {
        if (ndigits < 1 || ndigits > 10) {
            throw new IllegalArgumentException(
                    "Number of digits must be between 1 and 10 inclusive");
        }
        String digits = "012";
        int num = 0;
        for (int i = 0; i < ndigits; i++) {
            int d = (int) (Math.random() * digits.length());
            // convert character to an int and "append" to the num.
            num = num * 10 + digits.charAt(d) - '0';

            // effectively delete the just used digit from the string.
            digits = digits.substring(0, d) + digits.substring(d + 1);

        }
        String numString = String.valueOf(num);
        if(num>=10 && num <100){
            String formatted = String.format("%03d", num);
            numString = formatted;
        }
        if(num>=0 && num <10){
            String formatted = String.format("%03d", num);
            numString = formatted;
        }
        return numString;
    }
}
