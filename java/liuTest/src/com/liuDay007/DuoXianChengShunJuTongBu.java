package com.liuDay007;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class DuoXianChengShunJuTongBu {
    public static AtomicInteger money = new AtomicInteger(0);

    public static void main(String[] args) {
        int[] data = {100, 200, 300};
        for (int x = 0; x < data.length; x++) {
            final int temp = x;
            new Thread(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                money.addAndGet(data[temp]);
                System.out.println("Thread " + temp + " added money: " + data[temp]);
            }).start();
        }
    }
}
