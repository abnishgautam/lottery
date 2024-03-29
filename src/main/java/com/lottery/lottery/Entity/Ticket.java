package com.lottery.lottery.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Data
@ToString
public class Ticket {

    private boolean statusChecked;

    private List<String> lines;

    public boolean isStatusChecked() {
        return statusChecked;
    }

    public Ticket(List<String> lines) {
        this.lines = lines;
        this.statusChecked = false;
    }

    public List<LineOutcome> getSortedOutcomes() {
        List<LineOutcome> outcomes = new ArrayList<>();
        for (String line : lines) {
            outcomes.add(new LineOutcome(Integer.valueOf(line), calculateOutcome(Collections.singletonList(Integer.valueOf(line)))));
        }
        return outcomes;
    }

    private int calculateOutcome(List<Integer> line) {
        int sum = line.stream().mapToInt(Integer::intValue).sum();
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

    public void checkStatus() {
        //lines.sort(Comparator.comparingInt(this::calculateOutcome).reversed());
    }


    public void addLines(int additionalLines) {
       // lines.addAll(additionalLines);
    }
}
