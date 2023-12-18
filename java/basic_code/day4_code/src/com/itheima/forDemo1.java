package com.itheima;

import java.util.Scanner;

public class forDemo1 {
    public static void main(String[] args) {
        int sum =0;
        int number =0;
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入要计算1到多少的和");
        int end = sc.nextInt();
        for(number =1;number<=end;number++){
            sum =sum+number;
        }
            System.out.println("结果为"+sum);
    }
}
