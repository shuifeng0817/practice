package com.liuDay006;

import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<Object> objects = new Stack<>();
        System.out.println("栈空"+objects.empty());
        objects.push("1234567890");
        objects.push("98655678");
        System.out.println(objects.empty());
        while(!objects.empty()){
            System.out.println(objects.pop());
        }
    }
}
