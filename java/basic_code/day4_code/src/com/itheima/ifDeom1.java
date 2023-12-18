package com.itheima;

import java.util.Scanner;

public class ifDeom1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入女婿的酒量");
        int wine = sc.nextInt();
        if (wine > 2) {
            System.out.println("不错");
        } else {
            System.out.println("不行啊");
        }
    }
}
