package com.liuday002;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalTimeTest {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalTime now1 = LocalTime.now();
        LocalDateTime now2 = LocalDateTime.now();
        System.out.println(now.toString());
        System.out.println(now1.toString());
        System.out.println(now2.toString());
        LocalDate parse = LocalDate.parse("2024-09-15");
        System.out.println(parse.isLeapYear());
        System.out.println(parse.getDayOfMonth());
        System.out.println(parse.getDayOfYear());
        System.out.println(parse.getDayOfWeek());
    }
}
