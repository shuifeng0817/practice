package cn.dfxy.shiyan;

import java.util.concurrent.atomic.AtomicInteger;

public class test2 {
        /*private static int count = 0;

        public static void main(String[] args) throws InterruptedException {
            Thread[] threads = new Thread[10];

            for (int i = 0; i < 10; i++) {
                threads[i] = new Thread(() -> {
                    for (int j = 0; j < 100000; j++) {
                        count++;
                    }
                });
                threads[i].start();
            }

            for (Thread t : threads) {
                t.join(); // 等待所有线程执行结束
            }

            System.out.println("最终的值为：" + count);
        }*/

    private static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100000; j++) {
                    count.getAndIncrement();
                }
            });
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join(); // 等待所有线程执行结束
        }

        System.out.println("最终的值为：" + count);
    }
    }


