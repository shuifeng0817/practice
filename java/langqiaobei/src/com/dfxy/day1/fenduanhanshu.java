package com.dfxy.day1;

import java.util.Scanner;

public class fenduanhanshu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x=scanner.nextInt();
        int y=0;
        if(x<1){
            y=x;
        } else if (x >= 1 && x < 10) {
            y=2*x-1;
        } else if (x >= 10) {
            y=3*x-11;
        }
        System.out.println(y);
        scanner.close();
    }

}
