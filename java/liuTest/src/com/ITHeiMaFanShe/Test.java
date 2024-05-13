package com.ITHeiMaFanShe;

import java.sql.SQLOutput;

public class Test {
    public static void main(String[] args) {

        BigStar bigStar = new BigStar("鸡哥");
        Star proxy = ProxyUtil.createProxy(bigStar);

        String result = proxy.sing("123423413");
        System.out.println(result);

        proxy.dance();
    }
}
