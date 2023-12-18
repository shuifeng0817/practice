package cn.dfxy.repor5;

import java.util.ArrayList;

public class ThreadTest implements Runnable {
    static int i;

    public static void main(String[] args) {
        ArrayList<Thread> threadList = new ArrayList<>();
        for (int j = 0; j < 10; j++) {
            ThreadTest thread = new ThreadTest();
            Thread t = new Thread(thread); // 将当前的ThreadTest对象传入新创建的线程中
            threadList.add(t); // 将新创建的线程添加到列表中
            t.start(); // 启动新创建的线程
        }
        // 等待所有线程执行完毕
        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("i = " + i);
    }

    public void run() {
        for (int j = 0; j < 100000; j++) {
            i++;
        }
    }
}
