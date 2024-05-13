package com.atguigu.sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};
        selectSort(arr);

    }

    public static void selectSort(int[] arr) {
        int minIndex = 0;
        int min = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }

        System.out.println("选择排序");
        System.out.println(Arrays.toString(arr));

    }
}
