package com.liuday001;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayLIstTest {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("abcd1");
        strings.add("abcd2");
        strings.add("abcd3");
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }


    }
}
