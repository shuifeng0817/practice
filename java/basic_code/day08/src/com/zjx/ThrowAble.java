package com.zjx;


public class ThrowAble {
    public static void main(String[] args) {
        div4();
    }

    public static void div4()  {
        try {
            div3();
        } catch (Throwable e) {
            System.out.println(e.getMessage());
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }
    public static void div3() throws Throwable{
        //throw new Exception("");
        Throwable throwAble =  new Throwable("模拟问题");



    }

}
