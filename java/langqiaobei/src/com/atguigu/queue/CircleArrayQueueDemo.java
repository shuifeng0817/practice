package com.atguigu.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        System.out.println("环形队列");
        CircleArray circleArray = new CircleArray(4);
        char key = ' ';//接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头的数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    circleArray.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    circleArray.addQueue(value);
                    break;
                case 'g'://取出数据
                    try {
                        int res = circleArray.getQueue();
                        System.out.println("取出的数据是" + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h'://查看队列头的数据
                    try {
                        int res = circleArray.headQueue();
                        System.out.println("队列头的数据是" + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    System.out.println("程序退出");
                    break;
                default:
                    break;
            }

        }
    }

}
class CircleArray{
    private int maxSize;//表示数组的最大容量
    private int front;//
    private int rear;//
    private int[] arr;//存放数据
    public CircleArray(int arrMaxSize){
        maxSize =arrMaxSize;
        arr =new int [maxSize];
    }
    //判断队列是否满
    public boolean isFull() {
        return  (rear+1)%maxSize==front;
    }

    //判断是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据
    public void addQueue(int n){
        if (isFull()){
            System.out.println("队列满，不能加入数据");
            return;
        }
        arr[rear]=n;
        rear=(rear+1)%maxSize;
    }
    //取出数据
    public int getQueue(){
//判读是否为空
        if (isEmpty()) {
            //通过抛出异常处理
            throw new RuntimeException("队列空不能处理");
        }
        int value =arr[front];
        front=(front+1)%maxSize;
        return  value;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = front; i < front+size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }
    public int size(){
        return (rear + maxSize -front)%maxSize;
    }
    //显示队列的头数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空的，没有数据");
        }
        return arr[front];
    }

}
