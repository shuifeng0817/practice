package com.itheima;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        int day =0;
        Scanner sc=new Scanner (System.in);
        System.out.println("请输入要判断的星期数");
        day =sc.nextInt();
       if(day<=5 &&day>=0){
           System.out.println("工作日");
       }
       else if(day>5&& day>=8){
           System.out.println("休息日");
       }
       else{
           System.out.println("输入错误请重新输入");
       }
    }
}
