package com.itheima;

class Person{
    private Car car;
    public void setCar(Car car) {
        this.car = car;
    }

    public void drive(){
        car.throttle();
        car.brake();
        car.steeringWheel();
    }
}
abstract class Car{
    abstract void throttle();
    abstract void brake();
    abstract void steeringWheel();
}

class GreatWall extends Car {
    void throttle(){
        System.out.println("长城油门被踩下");
    }
    void brake(){
        System.out.println("长城刹车被踩下");
    }
    void steeringWheel(){
        System.out.println("长城方向盘被转动");
    }
}
class BYD extends Car{
    void throttle(){
        System.out.println("比亚迪油门被踩下");
    }
    void brake(){
        System.out.println("比亚迪刹车被踩下");
    }
    void steeringWheel(){
        System.out.println("比亚迪方向盘被转动");
    }
}

public class classTest1 {
    public static void main(String[] args) {
        Person person = new Person();
        BYD byd = new BYD();
        GreatWall greatWall = new GreatWall();
        person.setCar(byd); // 试驾BYD车
        person.drive();
        person.setCar(greatWall);//试驾长城车
        person.drive();
    }

}
