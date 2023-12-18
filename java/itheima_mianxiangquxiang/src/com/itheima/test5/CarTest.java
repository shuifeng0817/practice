package com.itheima.test5;

import java.sql.SQLOutput;
import java.util.Scanner;

public class CarTest {
    public static void main(String[] args) {
        Car[] arr =new Car[3];

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
        //创建汽车的对象
            Car c = new Car();
            System.out.println("请输入汽车的品牌");
            String brand =sc.next();
            c.setBrand(brand);
            System.out.println("请输入汽车价格");
            int price = sc.nextInt();
            c.setPrice(price);
            System.out.println("请输入汽车的颜色");
            String color =sc.next();
            c.setColor(color);
            arr[i]=c;

        }
        for (int i = 0; i < arr.length; i++) {
            Car car = arr[i];
            System.out.println(car.getBrand()+","+car.getPrice()+","+car.getColor());
        }
    }
}
