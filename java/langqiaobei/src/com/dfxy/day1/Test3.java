package com.dfxy.day1;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] a =new int[3];
        for (int i = 0; i < a.length; i++) {
            a[i]=scanner.nextInt();
        }
        int max =a[0];
        for (int i = 0; i < a.length-1; i++) {
            if(max<a[i+1]){
                max =a[i+1];
            }
        }
        System.out.println(max);

    }
}
