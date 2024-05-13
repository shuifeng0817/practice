package com.TreeSetPaiXuDemo;

import java.util.TreeSet;

public class TreeSetPaiXuDemo {
    public static void main(String[] args) {
        TreeSet<Book> o = new TreeSet<>();
        o.add(new Book("干货间","法国灰",123));
        o.add(new Book("干货","法国灰",114));
        o.add(new Book("干货间weq","法国灰",3243));
//        o.forEach(System.out::println);
        for (Book book : o) {
            System.out.println(book);
        }
    }
}
