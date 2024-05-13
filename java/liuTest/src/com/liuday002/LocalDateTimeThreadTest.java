package com.liuday002;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class LocalDateTimeThreadTest {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss");
        ZoneId zoneId =ZoneId.systemDefault();
        for (int x = 0; x < 10; x++) {
            new Thread(()->{
                LocalDateTime localDateTime=LocalDateTime.parse("1999-01-13 20:12:13",formatter);
                Instant instant=localDateTime.atZone(zoneId).toInstant();
                Date date=Date.from(instant);
                System.out.println("["+Thread.currentThread().getName()+"]"+date);
            },"线程"+x).start();
        }
    }


}
