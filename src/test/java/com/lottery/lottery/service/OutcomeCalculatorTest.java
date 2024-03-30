package com.lottery.lottery.service;

import com.lottery.lottery.service.impl.LotteryServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class OutcomeCalculatorTest {

    @Test
    public void testCalculateOutcome() {
        LotteryServiceImpl calculator = new LotteryServiceImpl();
        assertEquals(10, calculator.calculateOutcome("200"));
        assertEquals(5, calculator.calculateOutcome("111"));
        assertEquals(1, calculator.calculateOutcome("123"));
        //Check this condition
        assertEquals(1, calculator.calculateOutcome("122"));
        assertEquals(0, calculator.calculateOutcome("121"));
    }
}
