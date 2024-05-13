package com.liuDay008;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class YuanZiLeiDemo1 {
    public static AtomicInteger money = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
        int [] data = new int[]{100, 200, 300};
        for (int i = 0; i < data.length; i++) {
            final int temp =i;
            new Thread(new Runnable() {
                public void run() {
                    money.addAndGet(data[temp]);
                }
            }).start();
        }
        TimeUnit.SECONDS.sleep(1);
        System.out.println(money.get());
    }
}
