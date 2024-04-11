package com.lottery.lottery.service;

import com.lottery.lottery.service.impl.LotteryServiceImpl;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class OutcomeCalculatorTest {

    @Mock
    private LotteryService lotteryService;

    @ParameterizedTest
    @ValueSource(strings = {"011","110","101","002","200","020"})
    public void test10CalculateOutcome(String value) {
        LotteryServiceImpl lotteryService1 = new LotteryServiceImpl();
        assertEquals(10, lotteryService1.calculateOutcome(String.valueOf(value)));
    }

    @ParameterizedTest
    @ValueSource(strings = {"111","000","222"})
    public void test5CalculateOutcome(String value) {
        LotteryServiceImpl lotteryService1 = new LotteryServiceImpl();
        assertEquals(5, lotteryService1.calculateOutcome(String.valueOf(value)));
    }

    @ParameterizedTest
    @ValueSource(strings = {"012","102","201","201","211","122"})
    public void test1CalculateOutcome(String value) {
        LotteryServiceImpl lotteryService1 = new LotteryServiceImpl();
        assertEquals(1, lotteryService1.calculateOutcome(String.valueOf(value)));
    }

    @ParameterizedTest
    @ValueSource(strings = {"001"})
    public void test0CalculateOutcome(String value) {
        LotteryServiceImpl lotteryService1 = new LotteryServiceImpl();
        assertEquals(0, lotteryService1.calculateOutcome(String.valueOf(value)));
    }
}
