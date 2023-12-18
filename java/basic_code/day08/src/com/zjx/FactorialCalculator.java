package com.zjx;import java.math.BigInteger;

public class FactorialCalculator implements Runnable {
    private static String ms2DHMS(long startMs, long endMs) {
        String retval = null;
        long secondCount = (endMs - startMs) / 1000;
        String ms = (endMs - startMs) % 1000 + "ms";

        long days = secondCount / (60 * 60 * 24);
        long hours = (secondCount % (60 * 60 * 24)) / (60 * 60);
        long minutes = (secondCount % (60 * 60)) / 60;
        long seconds = secondCount % 60;

        if (days > 0) {
            retval = days + "d" + hours + "h" + minutes + "m" + seconds + "s";
        } else if (hours > 0) {
            retval = hours + "h" + minutes + "m" + seconds + "s";
        } else if (minutes > 0) {
            retval = minutes + "m" + seconds + "s";
        } else if(seconds > 0) {
            retval = seconds + "s";
        }else {
            return ms;
        }

        return retval + ms;
    }
    private int start;
    private int end;
    private BigInteger result;

    public FactorialCalculator(int start, int end) {
        this.start = start;
        this.end = end;
        this.result = BigInteger.ONE;
    }

    public BigInteger getResult() {
        return result;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
    }

    public static BigInteger factorial2(int a) {
        if (a <= 0) {
            return BigInteger.ZERO;
        }

        int threadCount = 4; // 设置线程数
        int chunkSize = a / threadCount;
        Thread[] threads = new Thread[threadCount];
        FactorialCalculator[] calculators = new FactorialCalculator[threadCount];

        int start = 1;
        int end = chunkSize;

        for (int i = 0; i < threadCount; i++) {
            if (i == threadCount - 1) {
                end = a;
            }

            calculators[i] = new FactorialCalculator(start, end);
            threads[i] = new Thread(calculators[i]);
            threads[i].start();

            start = end + 1;
            end += chunkSize;
        }

        BigInteger result = BigInteger.ONE;

        try {
            for (int i = 0; i < threadCount; i++) {
                threads[i].join();
                result = result.multiply(calculators[i].getResult());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 10000;
        long startMs2 = System.currentTimeMillis(); //获取开始时间
        BigInteger factorial = factorial2(n);
        System.out.println("Factorial of " + n + " is: " + factorial);
        long endMs2 = System.currentTimeMillis();//获取结束时间
        System.out.println("Time elapsed1:" + ms2DHMS(startMs2, endMs2));
    }
}

