package com.itheima;

import java.util.Scanner;

public class Test3jiemi {
    public static void main(String[] args) {
        //1.把数字逐位存入数组
        System.out.println("请输入解密数字");
        Scanner sc=new Scanner(System.in);
        int number1=sc.nextInt();
        int temp1=number1;
        int count=0;
        while (temp1!=0){
            temp1=temp1/10;
            count++;
        }
        int[] arr=new int[count];
        int index=count-1;
        while(number1!=0){
            arr[index]=number1%10;
            index--;
            number1=number1/10;
        }
        //2.把数字翻转
        for (int i = 0,j=arr.length-1; i < j; i++,j--) {
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }


        //3.还原取模10
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>=0 && arr[i]<=4){
                arr[i]=arr[i]+10;
            }
        }
        //4.数据减5
        for (int i = 0; i < arr.length; i++) {
            arr[i]=arr[i]-5;
        }
        //5.输出结果
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }

    }
}
