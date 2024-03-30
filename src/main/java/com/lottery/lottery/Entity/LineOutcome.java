package com.lottery.lottery.Entity;

import lombok.Data;
import lombok.ToString;

import java.util.List;
@Data
@ToString
public class LineOutcome {
    private String line;
    private int outcome;

    public LineOutcome(String line, int outcome) {
        this.line = line;
        this.outcome = outcome;
    }

    public String getLine() {
        return line;
    }

    public int getOutcome() {
        return outcome;
    }
}
