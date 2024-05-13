package com.liuDay004;

import java.lang.reflect.Method;

public class FileTestDemo {
    public static void main(String[] args) throws Exception {
        FileTest fileTest = new FileTest();
        Class<?> clazz = fileTest.loadData("com.atguigu.sort.InsertSort");
        Object o = clazz.getDeclaredConstructor().newInstance();
        Method methods = clazz.getMethod("insertSort", int[].class);
//        System.out.println(methods.invoke(o,"nihao"));
        int[] array = {5, 2, 8, 3, 1};
        methods.invoke(o, array);
    }
}
