package com.dfxy.day1;

import java.util.Scanner;

public class Sanjiaoxingmianji {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float a =scanner.nextFloat();
        float b =scanner.nextFloat();
        float c =scanner.nextFloat();
        float s=(a+b+c)/2;
        float mj= (float) Math.sqrt(s*(s-a)*(s-b)*(s-c));
        System.out.printf("%.2f",mj);
    }
}
