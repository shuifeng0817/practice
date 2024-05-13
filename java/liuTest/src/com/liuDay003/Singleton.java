package com.liuDay003;

public class Singleton {
    private static volatile Singleton instance;
    private Singleton(){
        System.out.println("["+Thread.currentThread().getName()+"]实例化Singleton类的对象");
    }
    public String toString(){
        return "1234567890";
    }
    public static Singleton getInstance(){
        if(instance==null){
            synchronized (Singleton.class){
                if(instance==null){
                    instance=new Singleton();
                }
            }
        }
        return instance;
    }
}
