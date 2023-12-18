package com.itheima;

import java.util.Scanner;

public class forDemo3 {
    public static void main(String[] args) {
        int min = 0;
        int max = 0;
        int count = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入范围的最小值");
        min = sc.nextInt();
        System.out.println("请输入范围的最大值");
        max = sc.nextInt();
        for (min = min; min <= max; min++) {
            if (min % 3 == 0 && min % 5 == 0) {
                count++;
            }
        }
        System.out.println("一共有"+count+"个");
    }
}
