package com.lottery.lottery.service.impl;

import com.lottery.lottery.service.LotteryService;

import java.text.DecimalFormat;
import java.util.Random;

public class LotteryServieImpl implements LotteryService {

    public static void main(String[] args) {
        LotteryServieImpl lotteryServie = new LotteryServieImpl();
        lotteryServie.createLottery(10);
    }
    @Override
    public void createLottery(int numberOfLines) {

        for (int i = 0; i < 10; i++) {
            System.out.println(getUnique(3));
        }

    }


    public static int getUnique(int ndigits) {
        if (ndigits < 1 || ndigits > 10) {
            throw new IllegalArgumentException(
                    "Number of digits must be between 1 and 10 inclusive");
        }
        String digits = "0123";
        int num = 0;
        for (int i = 0; i < ndigits; i++) {
            int d = (int) (Math.random() * digits.length());
            // convert character to an int and "append" to the num.
            num = num * 10 + digits.charAt(d) - '0';

            // effectively delete the just used digit from the string.
            digits = digits.substring(0, d) + digits.substring(d + 1);
        }
        if(num>=10 && num <100){
            String formatted = String.format("%03d", num);
            System.out.println("Formated String" +formatted);
            num= Integer.parseInt((formatted));
            System.out.println("Formated Integer" +num);
        }
        if(num>=0 && num <10){
            String formatted = String.format("%03d", num);
            System.out.println("Formated String" +formatted);
            num= Integer.parseInt((formatted));
            System.out.println("Formated Integer" +num);
        }
        return num;
    }
}
