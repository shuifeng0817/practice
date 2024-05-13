package com.liuday002;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigClassTest {
    public static void main(String[] args) {
        BigInteger bigInteger = new BigInteger("1234567890");
        BigInteger bigInteger1 = new BigInteger("987654321");
        System.out.println("加法"+bigInteger.add(bigInteger1));
        System.out.println("减法"+bigInteger.subtract(bigInteger1));
        System.out.println("乘法"+bigInteger.multiply(bigInteger1));
        System.out.println("除法"+bigInteger.divide(bigInteger1));
        BigDecimal bigDecimal = new BigDecimal(234567.34567);
        BigDecimal bigDecimal2 = new BigDecimal(678923.3245237);
        System.out.println("加法"+bigDecimal.add(bigDecimal2));
        System.out.println("减法"+bigDecimal.subtract(bigDecimal2));
        System.out.println("乘法"+bigDecimal.multiply(bigDecimal2));
        System.out.println("除法"+bigDecimal.divide(bigDecimal2));


    }
}
