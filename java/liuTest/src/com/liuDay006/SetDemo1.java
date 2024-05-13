package com.liuDay006;

import java.util.Set;

public class SetDemo1 {
    public static void main(String[] args) {
        Set<String> strings = Set.of("456789", "567890");
//        System.out.println(strings);
        strings.forEach(System.out::println);

    }
}
