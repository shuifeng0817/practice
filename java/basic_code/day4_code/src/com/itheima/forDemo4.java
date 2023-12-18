package com.itheima;

public class forDemo4 {
    public static void main(String[] args) {
        int number1 = 121;
        int number2 = 0;
        int temp=number1;
        while (temp != 0) {
            int gewei = 0;
            gewei = temp % 10;
            temp = temp / 10;
            number2 = number2 * 10 + gewei;
        }
        if (number1 == number2) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
