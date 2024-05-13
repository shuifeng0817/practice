package com.liuDay008;

public class DuoXianChengTest1 {
    public class SummationExample {
        private static final int TARGET_NUMBER = 1000;
        private static int sum = 0;

        public static void main(String[] args) throws InterruptedException {
            Runnable task = () -> {
                for (int i = 1; i <= TARGET_NUMBER; i++) {
                    synchronized (SummationExample.class) {
                        sum += i;
                    }
                }
            };

            Thread thread1 = new Thread(task);
            Thread thread2 = new Thread(task);

            thread1.start();
            thread2.start();

            thread1.join();
            thread2.join();

            System.out.println("Sum: " + sum);
        }
    }

}
