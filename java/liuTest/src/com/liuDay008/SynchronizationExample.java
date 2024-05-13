package com.liuDay008;

public class SynchronizationExample {
    private int count = 0; // 共享资源

    public synchronized void increment() {
        count++; // 对共享资源进行操作
    }

    public void performTask() {
        // 创建多个线程并启动
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                increment(); // 调用同步方法，对共享资源进行累加操作
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                increment(); // 调用同步方法，对共享资源进行累加操作
            }
        });

        thread1.start();
        thread2.start();

        // 等待线程执行完成
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Count: " + count); // 输出最终的结果
    }

    public static void main(String[] args) {
        SynchronizationExample example = new SynchronizationExample();
        example.performTask();
    }
}
