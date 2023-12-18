package com.itheima;

public class Test5 {
    public static void main(String[] args) {


    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < nums2.length; i++) {
            nums1[m+i]=nums2[i];
        }
        for (int i = 0; i < nums1.length-1; i++) {
            if(nums1[i]>nums1[i+1]){
                int tmp=nums1[i+1];
                nums1[i+1]=nums1[i];
                nums1[i]=tmp;
            }
        }



    }
}
