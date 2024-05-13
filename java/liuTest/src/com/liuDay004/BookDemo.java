package com.liuDay004;

public class BookDemo {
    public static void main(String[] args) throws Exception {
        ClassLoader classes = Book.class.getClassLoader();
        while (classes != null) {
            System.out.println(classes);
            classes = classes.getParent();
        }
    }
}
