package com.itheima;

import java.util.Random;
import java.util.Scanner;

public class game1 {
    public static void main(String[] args) {
        //生成随机数
        Random r = new Random();
        int number1 = r.nextInt(100) + 1;
        //猜数字
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要猜的数字（1——100）");
        for (; ; ) {
            int guessNumber = sc.nextInt();
            if (guessNumber == number1) {
                System.out.println("猜对了");
                break;
            } else if (guessNumber < 1 || guessNumber > 100) {
                System.out.println("超出范围，请重新输入");
            }
            else if(guessNumber>number1){
                System.out.println("猜大了，请继续");
            }
            else if(guessNumber<number1){
                System.out.println("猜小了，请继续");
            }
        }
    }
}
