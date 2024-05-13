package com.dfxy.day1;

import java.util.Scanner;

public class lirunjisuan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        double l = 0;//利率
        int t = 0;
        int bonus = 0;
        if (i <= 100000) {
            l = 0.1;
            bonus = (int) (l * i);

        } else if (i <= 200000 && i > 100000) {
            l = 0.075;
            bonus = (int) ((100000 * 0.1) + (i - 100000) * l);
        } else if (i <= 600000 && i > 200000) {
            bonus = (int) (100000 * 0.1 + 100000 * 0.075);
            l = 0.05;
            bonus = (int) ((i - 200000) * l + bonus);
        } else if (i <= 600000 && i > 400000) {
            bonus = (int) (100000 * 0.1 + 100000 * 0.075 + 200000 * 0.05);
            l = 0.03;
            bonus = (int) ((i - 400000) * l) + bonus;
        } else if (i <= 1000000 && i > 600000) {
            bonus = (int) (100000 * 0.1 + 100000 * 0.075 + 200000 * 0.05 + 200000 * 0.03);
            l = 0.015;
            bonus = (int) ((i - 600000) * l + bonus);
        } else if (i > 1000000) {
            bonus = (int) (100000 * 0.1 + 100000 * 0.075 + 200000 * 0.05 + 200000 * 0.03 + 400000 * 0.015);
            l = 0.01;
            bonus = (int) ((i - 1000000) * l + bonus);
        }
        System.out.println(bonus);
        scanner.close();
    }
}
