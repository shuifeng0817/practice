package com.zjx;

import java.math.BigInteger;
class MyThread implements  Runnable{
    private int a;
    private BigInteger fac5;

    public MyThread() {
    }

    public MyThread(int a, BigInteger fac5) {
        this.a = a;
        this.fac5 = fac5;
    }

    public void  run(){
        int tmp =a%4;//计算不是4的倍数的部分
        for (int i =1;i<=tmp ;i++){
            fac5 =fac5.multiply(BigInteger.valueOf(a));
            a--;
        }
    }

    /**
     * 获取
     * @return a
     */
    public int getA() {
        return a;
    }

    /**
     * 设置
     * @param a
     */
    public void setA(int a) {
        this.a = a;
    }

    /**
     * 获取
     * @return fac5
     */
    public BigInteger getFac5() {
        return fac5;
    }

    /**
     * 设置
     * @param fac5
     */
    public void setFac5(BigInteger fac5) {
        this.fac5 = fac5;
    }

    public String toString() {
        return "MyThread{a = " + a + ", fac5 = " + fac5 + "}";
    }
}

public class For {

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

    public static BigInteger factorial(int a) {
        BigInteger fac = BigInteger.ONE;
        for (int i = 1; i <= a; i++) {
            fac = fac.multiply(BigInteger.valueOf(i));
        }
        return fac;
    }

    public static BigInteger factorial2(int a) {
        BigInteger fac0 = BigInteger.ONE;
        BigInteger fac1 = BigInteger.ONE;
        BigInteger fac2 = BigInteger.ONE;
        BigInteger fac3 = BigInteger.ONE;
        int t=1;
        if (a>4){
            for (int i = 1; i <= a/4; i ++) {
                fac0 = fac0.multiply(BigInteger.valueOf(t));
                fac1 = fac1.multiply(BigInteger.valueOf(t + 1));
                fac2 = fac2.multiply(BigInteger.valueOf(t + 2));
                fac3 = fac3.multiply(BigInteger.valueOf(t + 3));
                t+=4;
            }
        }
        int tmp =a%4;//计算不是4的倍数的部分
        BigInteger fac4=fac0.multiply(fac1).multiply(fac2).multiply(fac3);
        for (int i =1;i<=tmp ;i++){
            fac4 =fac4.multiply(BigInteger.valueOf(a));
            a--;
        }
        return fac4;

    }
    public static BigInteger factorial3(int a) {
        BigInteger fact = BigInteger.ONE;
        BigInteger fac0 = BigInteger.ONE;
        BigInteger fac1 = BigInteger.ONE;
        BigInteger fac2 = BigInteger.ONE;
        BigInteger fac3 = BigInteger.ONE;
        BigInteger fac4 = BigInteger.ONE;
        BigInteger fac5 = BigInteger.ONE;
        BigInteger fac6 = BigInteger.ONE;
        BigInteger fac7 = BigInteger.ONE;
        BigInteger fac8 = BigInteger.ONE;
        BigInteger fac9 = BigInteger.ONE;
        BigInteger fac10 = BigInteger.ONE;
        BigInteger fac11 = BigInteger.ONE;
        BigInteger fac12 = BigInteger.ONE;
        BigInteger fac13 = BigInteger.ONE;
        BigInteger fac14 = BigInteger.ONE;
        BigInteger fac15 = BigInteger.ONE;
        int t=1;
        if (a>16){
            for (int i = 1; i <= a/16; i ++) {
                fac0 = fac0.multiply(BigInteger.valueOf(t));
                fac1 = fac1.multiply(BigInteger.valueOf(t + 1));
                fac2 = fac2.multiply(BigInteger.valueOf(t + 2));
                fac3 = fac3.multiply(BigInteger.valueOf(t + 3));
                fac4 = fac4.multiply(BigInteger.valueOf(t + 4));
                fac5 = fac5.multiply(BigInteger.valueOf(t + 5));
                fac6 = fac6.multiply(BigInteger.valueOf(t + 6));
                fac7 = fac7.multiply(BigInteger.valueOf(t + 7));
                fac8 = fac8.multiply(BigInteger.valueOf(t + 8));
                fac9 = fac9.multiply(BigInteger.valueOf(t + 9));
                fac10 = fac10.multiply(BigInteger.valueOf(t + 10));
                fac11 = fac11.multiply(BigInteger.valueOf(t + 11));
                fac12 = fac12.multiply(BigInteger.valueOf(t + 12));
                fac13 = fac13.multiply(BigInteger.valueOf(t + 13));
                fac14 = fac14.multiply(BigInteger.valueOf(t + 14));
                fac15 = fac15.multiply(BigInteger.valueOf(t + 15));
                t+=16;
            }
        }
        MyThread myThread = new MyThread();
        myThread.setA(a);
        myThread.setFac5(fact);
        Thread thread = new Thread(myThread);
        thread.start();
        BigInteger fac16=fac0.multiply(fac1).multiply(fac2).multiply(fac3).multiply(fac4).multiply(fac5).multiply(fac6).multiply(fac7).multiply(fac8).multiply(fac9).multiply(fac10).multiply(fac11).multiply(fac12).multiply(fac13).multiply(fac14).multiply(fac15).multiply(fact);
        return fac16;
    }


    public static void main(String[] args) {
        int n = 10000;
        long startMs = System.currentTimeMillis(); //获取开始时间
        BigInteger result = factorial(n);
        System.out.println(n + "! = " + result);
        long endMs = System.currentTimeMillis();//获取结束时间
        System.out.println("Time elapsed1:" + ms2DHMS(startMs, endMs));
        long startMs2 = System.currentTimeMillis(); //获取开始时间
        BigInteger result2 = factorial2(n);
        System.out.println(n + "! = " + result2);
        long endMs2 = System.currentTimeMillis();//获取结束时间
        System.out.println("Time elapsed1:" + ms2DHMS(startMs2, endMs2));
        long startMs3 = System.currentTimeMillis(); //获取开始时间
        BigInteger result3 = factorial3(n);
        System.out.println(n + "! = " + result3);
        long endMs3 = System.currentTimeMillis();//获取结束时间
        System.out.println("Time elapsed1:" + ms2DHMS(startMs3, endMs3));
    }
}