package com.dfxy.day1;

import java.util.Scanner;

public class chengjipinding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a=scanner.nextInt();
        if(a>=90){
            System.out.println("A");
        } else if (a >= 80) {
            System.out.println("B");
        }else if(a>=70){
            System.out.println("C");
        } else if (a >= 60) {
            System.out.println("D");
        } else if (a >= 0) {
            System.out.println("E");
        }
        scanner.close();
    }
}
