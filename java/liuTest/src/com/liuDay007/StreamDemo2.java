package com.liuDay007;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo2 {
    public static void main(String[] args) {
        List<String> data = new ArrayList<>();
        Collections.addAll(data, "Java", "JavaScript", "Python", "Ruby", "Go", "C", "C++", "SQL");
        Stream<String> stream = data.stream();
        List<String> list =stream.skip(2).limit(4).filter((ele)->ele.toLowerCase().matches("(.*j.*)|(.*c.*)")).collect(Collectors.toList());
        System.out.println(list);
    }
}
