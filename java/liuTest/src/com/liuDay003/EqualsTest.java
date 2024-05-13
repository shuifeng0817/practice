package com.liuDay003;

public class EqualsTest {
    public static void main(String[] args) {
        int[] arr1 = {1,2,1,3,1};
        int[] arr2 = {1,1,2,1,4};
        equals(arr1, arr2);
    }
    //例如当前传入的元素，arr1中的“1”的个数是3,arr2中的“1”的个数也是3，但执行完成后都为10

    public static void equals(int[] arr1, int[] arr2) {
        int count = 0;//arr2中与arr1中的元素相同个数
        int count1 = 0;//arr1中重复元素的总个数（不是一个数组中一共有多少相同的元素，是当程序运行完毕，循环相同次数，相同元素的增加量）
        int count2 = 0;//上同
        if (arr1.length != arr2.length) {
            System.out.println("两个数组是不相同的1");
            System.exit(0);
        }
        for (int i = 0; i < arr2.length; i++) {
            am:
            for (int j = 0; j < arr2.length; j++) {//从arr2中判断有没有元素和arr1的 当前 元素相同
                if (arr1[i] == arr2[j]) {//有一个相同元素就让count+1
                    count++;
                    //从此处开始时算法优化
                    //当两个数组中的元素完全相同时，两个数组中的相同元素个数也是相同的
                    //当做想同次数的循环时，相同元素的个数（count1 count2）也会同时增加相同数量
                    for (int i2 = 0; i2 < arr2.length; i2++) {//判断arr1的i号元素在arr1中有多少相同的
                        if (arr1[i] == arr1[i2]) {
                            count1++;
                        }
                    }
                    for (int j2 = 0; j2 < arr2.length; j2++) {//判断arr2的j号元素在arr2中有多少相同的
                        if (arr2[j] == arr2[j2]) {
                            count2++;
                        }
                    }
                    if (count1 != count2) {//只要同一个元素在同一个循环次数后，没有得到相同次数的增长，就会导致count1和count2不同
                                            //这就证明两个数组中的当前元素的重复个数不一致，即两数组不同
                        System.out.println("不同2");
                        System.out.println("arr1——count1："+count1);
                        System.out.println("arr2——count2："+count2);
                        System.exit(0);
                    }
                    break am;
                    //到这里优化结束
                }
            }
        }
        if (count == arr1.length) {
            System.out.println("相同1");
            System.out.println("arr1——count1："+count1);
            System.out.println("arr2——count2："+count2);
        } else {
            System.out.println("不同3");
            System.out.println("arr1——count1："+count1);
            System.out.println("arr2——count2："+count2);
        }

    }
}
