package com.liuday002;

public class SwitchTest {
    public static void main(String[] args) {
        int x = 5;
        switch (x) {
            case 1:
            case 2:
            case 3:
                System.out.println("一季度");
                break;
            case 4:
            case 5:
            case 6:
                System.out.println("二季度");
            case 7:
            case 8:
            case 9:
                System.out.println("三季度");
                break;
            case 10:
            case 11:
            case 12:
                System.out.println("四季度");
                break;
            default:
                System.out.println("不是有效的月份");
        }
    }
}
