package com.zjx;

public class LinkTest {
    LinkTest pre;
    LinkTest next;
    Object data;

    public static void main(String[] args) {
        LinkTest l0 = new LinkTest();
        LinkTest l1 = new LinkTest();
        LinkTest l2 = new LinkTest();

        l0.pre =null;
        l0.next =l1;
        l0.data ="a";

        l1.pre =l0;
        l1.next=l2;
        l1.data ="b";

        l2.pre =l1;
        l2.next=null;
        l2.data="c";

        System.out.println(l0.next.next.data);

    }
}

