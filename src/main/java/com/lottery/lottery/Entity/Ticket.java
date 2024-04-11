package com.lottery.lottery.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


//Implement your own hashcode
@Data
@ToString
public class Ticket {

    private boolean statusChecked;

    private List<String> lines;


    public Ticket(List<String> lines,boolean statusChecked) {
        this.lines = lines;
        this.statusChecked = statusChecked;
    }


    public void addLines(List<String> additionalLines) {
        lines.addAll(additionalLines);
    }
}
