package com.liuDay008;

import java.util.concurrent.atomic.AtomicLong;

public class CompareAndSet {
    public static void main(String[] args) {
        AtomicLong atomicLong = new AtomicLong(100L);
        System.out.println(atomicLong.compareAndSet(100L,300L));
        System.out.println(atomicLong.get());
    }
}
