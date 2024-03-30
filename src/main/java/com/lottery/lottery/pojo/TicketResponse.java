package com.lottery.lottery.pojo;

import com.lottery.lottery.Entity.LineOutcome;
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
    private boolean statusChecked;
    private List<LineOutcome> outcomes;
}
