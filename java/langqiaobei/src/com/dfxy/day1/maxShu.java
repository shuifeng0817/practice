package com.dfxy.day1;

import java.util.Scanner;

public class maxShu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[3];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j + 1] = t;
                }
            }
        }
        System.out.println(arr[0]);
scanner.close();
    }
}
