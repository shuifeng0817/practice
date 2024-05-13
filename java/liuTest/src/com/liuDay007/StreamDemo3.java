package com.liuDay007;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo3 {
    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("java",69.8,8000));
        orders.add(new Order("c",120.3,800));
        orders.add(new Order("C++",567.3,8880));
        Stream<Order> stream = orders.stream();
        DoubleSummaryStatistics result =stream.filter((ele)->ele.getName().toLowerCase().contains("java")).mapToDouble((orderObject)->orderObject.getPrice() * orderObject.getAmount()).summaryStatistics();
        System.out.println(result.getAverage());
        System.out.println(result.getMax());
        System.out.println(result.getMin());
        System.out.println(result.getSum());
    }
}
