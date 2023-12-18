package com.itheima;

public class MethodDemo2 {
    public static void printArr(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        int [] arr={11,3,3,5,6,7};
        printArr(arr);

    }
}
