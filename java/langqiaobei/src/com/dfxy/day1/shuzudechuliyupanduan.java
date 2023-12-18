package com.dfxy.day1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class shuzudechuliyupanduan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Object> objects = new Stack<>();
        int a=scanner.nextInt();
        int b=0;
        int count =0;
        while (a!=0){
            int t= a%10;
            a/=10;
            b=b*10+t;
            count++;
            objects.push(t);
        }
        System.out.println(count);
        int s =objects.size();
        for (int i = 0; i < s; i++) {
            int t= (int) objects.pop();
            System.out.printf("%d",t);
            if(i<count) {
                System.out.printf(" ");
            }
        }
        System.out.println();
        System.out.println(b);
        scanner.close();
    }
}
