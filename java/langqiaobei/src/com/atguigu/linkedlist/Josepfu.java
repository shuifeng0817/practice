package com.atguigu.linkedlist;

public class Josepfu {
    public static void main(String[] args) {

        CircleSingLinkedList circleSingLinkedList = new CircleSingLinkedList();
        circleSingLinkedList.addBoy(5);//加入5个小孩节点
        circleSingLinkedList.showBoy();


        circleSingLinkedList.countBoy(1,2,5);
    }
}


//创建一个环形的单向链表
class CircleSingLinkedList {
    //创建一个first节点
    private Boy first = null;

    //添加小孩节点，构建成一个环形链表
    public void addBoy(int nums) {
        //对num做数据校验
        if (nums < 1) {
            System.out.println("nums的数值不正确");
            return;
        }
        Boy curBoy = null;//辅助指针，帮助构建环形链表
        for (int i = 1; i <= nums; i++) {
            //根据编号创建小孩节点
            Boy boy = new Boy(i);
            //第一个小孩
            if (i == 1) {
                first = boy;
                first.setNext(first);//构成环
                curBoy = first;//让curboy指向第一个小孩
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    //遍历当前的环形链表
    public void showBoy() {
        //判断链表是否为空
        if (first == null) {
            System.out.println("链表为空");
            return;
        }
        //因为first不能动，用辅助指针
        Boy curBoy = first;
        while (true) {
            System.out.println("小孩的编号" + curBoy.getNo());
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();//让curboy后移

        }
    }

//根据用户输入，计算出小孩出圈的顺序

    /***
     *
     * @param startNo 表示从第几个小孩开始数数
     * @param countNum 表示数几下
     * @param nums 表示最初有多少小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums) {
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误，请重新输入");
            return;
        }
        //创建辅助指针，帮助完成小孩出圈
        Boy helper = first;
        while (true) {
            if (helper.getNext() == first) {//说明Helper指向最后小孩节点
                break;
            }
            helper = helper.getNext();
        }
        for(int j =0;j<startNo-1;j++){
            first =first.getNext();
            helper =helper.getNext();
        }
        while (true){
            if(helper ==first){
                break;
            }
            for(int j =0;j<countNum -1;j++){
                first =first.getNext();
                helper =helper.getNext();
            }
            System.out.printf("小孩%d出圈\n",first.getNo());
            first =first.getNext();
            helper .setNext(first);
        }
        System.out.printf("最后留在圈中小孩编号%d\n",first.getNo());

    }
}


//创建一个boy类，表示一个节点
class Boy {
    private int no;
    private Boy next;//指向下一个节点

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}