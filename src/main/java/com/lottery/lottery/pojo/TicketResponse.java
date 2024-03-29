package com.lottery.lottery.pojo;

import com.lottery.lottery.Entity.Ticket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TicketResponse {

    private int TicketId;
    private List<String> noOfLines;
    private boolean statusChecked;
}
