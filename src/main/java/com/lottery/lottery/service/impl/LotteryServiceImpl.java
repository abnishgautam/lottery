package com.lottery.lottery.service.impl;

import com.lottery.lottery.Entity.LineOutcome;
import com.lottery.lottery.Entity.Ticket;
import com.lottery.lottery.exception.TicketNotFoundException;
import com.lottery.lottery.pojo.TicketResponse;
import com.lottery.lottery.service.LotteryService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
@PropertySource("classpath:application.properties")
public class LotteryServiceImpl implements LotteryService {

    @Value("#{'${logic.read.listoF3DigitNumber}'.split(',')}")
    private List<String> listOf3DigitNumber;

    private Map<String, Ticket> ticketMap = new ConcurrentHashMap<>();

    @Override
    public List<TicketResponse> getAllTickets() {
        List<TicketResponse> ticketResponses = new ArrayList<>();
        for (Map.Entry<String, Ticket> entry : ticketMap.entrySet()){
            TicketResponse ticketResponse = new TicketResponse();
            List<LineOutcome> outcomes =  getSortedOutcomes(entry.getValue().getLines());
            outcomes.stream().sorted();
            ticketResponse.setTicketId(entry.getKey());
            ticketResponse.setOutcomes(outcomes);
            ticketResponse.setStatusChecked(entry.getValue().isStatusChecked());
            ticketResponses.add(ticketResponse);
        }
        ticketResponses.stream().forEach(System.out::println);
        return ticketResponses;
    }

    @Override
    public TicketResponse getTicket(String id) throws TicketNotFoundException {
        TicketResponse ticketResponse = new TicketResponse();

        ticketResponse.setTicketId(id);
        Ticket ticketValue = ticketMap.get(id);
        if(ObjectUtils.isEmpty(ticketValue)){
            throw new TicketNotFoundException("Provided Ticket Id Does Not Exist");
        }
        List<LineOutcome> outcomes =  getSortedOutcomes(ticketValue.getLines());
        outcomes.stream().sorted();
        ticketResponse.setOutcomes(outcomes);
        ticketResponse.setStatusChecked(ticketValue.isStatusChecked());

        return ticketResponse;
    }

    @Override
    public TicketResponse updateLottery(int noOfLines, String ticketId) throws TicketNotFoundException {
        List<String> listOfLines = createLotteryLines(noOfLines);
        Ticket ticketValue = ticketMap.get(ticketId);
        if(ObjectUtils.isEmpty(ticketValue)){
                throw new TicketNotFoundException("Provided Ticket Id Does Not Exist");
        }
        if(ticketValue.isStatusChecked()== true){
            throw new RuntimeException("Lottery is already checked so status cannot be updated");
        }
        ticketValue.addLines(listOfLines);
        return getTicket(ticketId);
    }

    @Override
    public Boolean getStatus(String id) throws TicketNotFoundException {
        Ticket ticketValue = ticketMap.get(id);
        if(ObjectUtils.isEmpty(ticketValue)){
            throw new TicketNotFoundException("Provided Ticket Id Does Not Exist");
        }
        Boolean returnValue = ticketValue.isStatusChecked();
        ticketValue.setStatusChecked(true);
        return returnValue;
    }

    public String createLottery(int numberOfLines){
        List<String> listOfLines = createLotteryLines(numberOfLines);
        Ticket ticket = new Ticket(listOfLines,false);
        String ticketId = UUID.randomUUID().toString();
        ticketMap.put(ticketId,ticket);
        return ticketId;
    }

    public List<String> createLotteryLines(int numberOfLines) {
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < numberOfLines; i++) {
            stringList.add(givenList_shouldReturnARandomElement());
        }
        stringList.stream().forEach(System.out::println);
        return stringList;
    }

    public String givenList_shouldReturnARandomElement() {
        List<String> givenList = listOf3DigitNumber;
        Random rand = new Random();
        String randomElement = givenList.get(rand.nextInt(givenList.size()));
        return  randomElement;
    }
/*    public static String getUnique(int ndigits) {
        if (ndigits < 1) {
            throw new IllegalArgumentException(
                    "Number of digits must be between 1 and 3 inclusive");
        }
        String digits = "012";
        int num = 0;
        for (int i = 0; i < ndigits; i++) {
            int d = (int) (Math.random() * digits.length());
            num = num * 10 + digits.charAt(d) - '0';
            digits = digits.substring(0, d) + digits.substring(d + 1);
        }
        String numString = String.valueOf(num);
        if(num>=10 && num <= 100){
            String formatted = String.format("%03d", num);
            numString = formatted;
        }
        if(num>=0 && num < 10){
            String formatted = String.format("%03d", num);
            numString = formatted;
        }
        return numString;
    }*/

    public List<LineOutcome> getSortedOutcomes(List<String> lines) {
        List<LineOutcome> outcomes = new ArrayList<>();
        for (String line : lines) {
            outcomes.add(new LineOutcome(line,calculateOutcome(line)));
        }
        return outcomes;
    }

    public int calculateOutcome(String value) {
        String[] digits = String.valueOf(value).split("");
        List<String> line = Arrays.stream(digits).toList();
        List<Integer> result = line.stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        int sum = result.stream().mapToInt(Integer::intValue).sum();
        if (sum == 2) {
            return 10;
        } else if (line.get(0).equals(line.get(1)) && line.get(1).equals(line.get(2))) {
            return 5;
        } else if (!line.get(0).equals(line.get(1)) && !line.get(0).equals(line.get(2))) {
            return 1;
        } else {
            return 0;
        }
    }
}
