package com.liuday001;


public class YootkDemo {
    public static void main(String[] args) {
        LotteryTicket lotteryTicket = new LotteryTicket();
        lotteryTicket.create();
        for (int datum : lotteryTicket.getData()) {
            System.out.print(datum+" ");
        }
    }
}
