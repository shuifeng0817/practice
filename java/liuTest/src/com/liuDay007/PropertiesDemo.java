package com.liuDay007;

import java.util.Properties;

public class PropertiesDemo {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("1","abc");
        properties.setProperty("2","cba");
        System.out.println(properties.getProperty("1"));
        System.out.println(properties.getProperty("2"));
        System.out.println(properties.getProperty("3"));

    }
}
