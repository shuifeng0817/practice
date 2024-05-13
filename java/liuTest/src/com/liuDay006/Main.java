package com.liuDay006;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(3);
        System.out.println(circle.area());
        Circular circular = new Circular(circle, 3);
        System.out.println(circular.TiJi());

    }
}
