package com.dfxy.day1;

import java.util.Scanner;

public class wenduzhuanhuan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float f = scanner.nextFloat();
        float c = 5*(f-32)/9;
        System.out.printf("%.2f",c);
        scanner.close();
    }
}
