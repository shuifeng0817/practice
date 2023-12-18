package com.zjx;

class Person2{
    private int age;

    public void setAge(int age){
        if(age>0){
            this.age=age;
        }else {
            System.out.println("输入错误");
        }
    }
    public int getAge(){
        return age;
    }

}

public class Test1 {
    public static void main(String[] args) {
        Person2 zhaojiaxuan= new Person2();
        zhaojiaxuan.setAge(-19);
        System.out.println(zhaojiaxuan.getAge());
    }
}
