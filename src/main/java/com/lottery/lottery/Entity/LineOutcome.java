package com.lottery.lottery.Entity;

import java.util.List;

class LineOutcome {
    private Integer line;
    private int outcome;

    public LineOutcome(Integer line, int outcome) {
        this.line = line;
        this.outcome = outcome;
    }

    public Integer getLine() {
        return line;
    }

    public int getOutcome() {
        return outcome;
    }
}
