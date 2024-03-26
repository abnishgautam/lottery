package com.lottery.lottery.service;

import org.springframework.stereotype.Service;

@Service
public interface LotteryService {

    public void createLottery(int numberOfLines);
}
