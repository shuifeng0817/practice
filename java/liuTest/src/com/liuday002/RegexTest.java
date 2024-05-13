package com.liuday002;

import java.util.Arrays;

public class RegexTest {
    public static void main(String[] args) {
        String str ="ertyuiDFGHJKRTYUI@#$%^&";
        String re="[^a-z]";
        String result = Arrays.toString(str.split(re));
        System.out.println(result);
        System.out.println(str.replaceAll(re,""));

        String str1="23456fg134hjk4234lasd";
        String re1="\\d+";
        String result1 = Arrays.toString(str1.split(re1));
        System.out.println(result1);

        String str2="123456789";
        if(str2.matches(re1)){
            int a =Integer.parseInt(str2);
            System.out.println(a);
        }else {
            System.out.println("不合规定");
        }

        String str3="sdfg.sdfdfghj@ghjkl.com";
        String reEmail="[a-zA-Z_][a-zA-Z0-9\\-\\_\\.]+@[a-zA-z0-9\\-]+";

    }
}
