package com.liuday002;

public class TimeTest {
    public static void main(String[] args) {
        String message = "asdfghjkl";
        long start =System.currentTimeMillis();
        for (int x = 0; x < 99999; x++) {
            message+=x;
        }
        long end =System.currentTimeMillis();
        System.out.println(end-start);
    }
}
