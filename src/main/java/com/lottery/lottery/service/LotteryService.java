package com.lottery.lottery.service;

import com.lottery.lottery.exception.TicketNotFound;
import com.lottery.lottery.pojo.TicketResponse;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LotteryService {

    public Integer createLottery(int numberOfLines);

    public List<TicketResponse> getAllTickets();

    TicketResponse getTicket(int id);

    TicketResponse updateLottery(int noOfLines, int ticketId) throws TicketNotFound;

    Boolean getStatus(int id) throws TicketNotFound;
}
