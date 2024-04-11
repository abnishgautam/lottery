package com.lottery.lottery.service;

import com.lottery.lottery.exception.TicketNotFoundException;
import com.lottery.lottery.pojo.TicketResponse;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LotteryService {

    /*This method takes number of lines to be generated
    * as input and returns the unique ticket id*/
    public String createLottery(int numberOfLines);

    /*This method get all the ticket*/
    public List<TicketResponse> getAllTickets();

    /*This method get the ticket based on ticketId*/
    TicketResponse getTicket(String id) throws TicketNotFoundException;

    /*This method update the lottery with
    * the additional no lines*/
    TicketResponse updateLottery(int noOfLines, String ticketId) throws TicketNotFoundException;

    /*This method is used to check the status and then update the status
    * so that this lottery could not be updated */
    Boolean getStatus(String id) throws  TicketNotFoundException;

}
