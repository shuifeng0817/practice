package com.itheima;

import java.util.Scanner;

public class ifDemo3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请录入一个票号");
        int i = 0;
        for (i = 1; i < +10; i++) {
            int ticket = sc.nextInt();
            if (ticket < 100 && ticket % 2 == 1) {
                System.out.println("坐左边");

            } else if (ticket < 100 && ticket % 2 == 0) {
                System.out.println("左右边");
            } else {
                System.out.println("假票");
            }
        }
    }
}
