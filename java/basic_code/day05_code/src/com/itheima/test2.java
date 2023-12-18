package com.itheima;

import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        int number1 = 0;
        int i = 0;
        Scanner sc = new Scanner(System.in);
        number1 = sc.nextInt();
        for (i = 2; i < Math.sqrt(number1); i++) {
            if (number1 % i == 0) {
                System.out.println("不是质数");
                break;
            }
        }
        if (i > Math.sqrt(number1)) {
            System.out.println("是质数");
        }
    }
}
