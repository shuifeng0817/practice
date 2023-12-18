package com.itheima;

import java.util.Scanner;

public class Test2jiami {
    public static void main(String[] args) {
        //1.把整数里面的每一位放到数组当中
        System.out.println("请输入需要加密的数字:");
        Scanner sc=new Scanner(System.in);
        int number = sc.nextInt();
        int count = 0;
        int temp1 = number;
        while (temp1 != 0) {

            temp1 = temp1 / 10;
            count++;//去掉一位计数器增加一位
        }
        int index = count - 1;
        int[] arr = new int[count];
        while (number != 0) {
            int ge = number % 10;
            number = number / 10;
            arr[index] = ge;
            index--;
        }
        /*for (int i = 0, j=arr.length-1; i < j; i++,j--) {
            int temp2 =arr[i];
            arr[i]=arr[j];
            arr[j]=temp2;
        }*/
        //2.加密
        //每位数加上5
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] + 5;
        }
        //再对10取余
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] % 10;
        }
        //将所有数字反转
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        //3.把每一位数字拼接,变成加密后的结果
        int number2 = 0;
        for (int i = 0; i < arr.length; i++) {
            number2 = number2 * 10 + arr[i];
        }
        System.out.println(number2);

    }
}
