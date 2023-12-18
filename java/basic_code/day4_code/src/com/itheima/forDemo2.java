package com.itheima;

import java.util.Scanner;

public class forDemo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要计算的数");
        int end = sc.nextInt();
        int sum = 0;
        for (int number = 1; number <= end; number++) {
            if (number % 2 == 0) {
                sum = sum + number;
            }
        }
        System.out.println("结果为" + sum);

    }
}
