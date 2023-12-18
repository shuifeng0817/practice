package com.itheima;

public class arrayTest2 {
    public static void main(String[] args) {
        char c='c'+1;
        int[] arr1 = {1, 3, 6, 5, 7, 4, 2, 64, 63, 8, 65};
        for (int j = 0; j < arr1.length; j++) {
            for (int i = 0; i < arr1.length - 1 - j; i++) {
                if (arr1[i] > arr1[i + 1]) {
                    int tmp=arr1[i];
                    arr1[i] = arr1[i+1];
                    arr1[i+1]=tmp;
                }
            }
        }
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }
    }

}
