package com.liuDay003;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FanSheDemo1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        FanSheBookDome book = new FanSheBookDome();
        book.read();
        System.out.println(book.getClass().getName());
        System.out.println(book.getClass().getSimpleName()  );
        System.out.println(book.getClass().getTypeName());
        System.out.println(book.getClass());
        System.out.println(FanSheBookDome.class);
        Class<?> aClass = Class.forName("com.liuDay003.FanSheBookDome");
        System.out.println(aClass);

        //实例化
        Class<?> aClass1 = Class.forName("com.liuDay003.FanSheBookDome");
        Object o = aClass1.getDeclaredConstructor().newInstance();
        FanSheBookDome book1= (FanSheBookDome) o;
        book1.read();



        //工厂实例化
        IBook bookA = Factory.getInstance("com.liuDay003.MathBook");
        bookA.read();
        IBook bookB = Factory.getInstance("com.liuDay003.ProgramBook");
        bookB.read();

        //原来的方法
        IBook bookA1 =new MathBook();


        for (int x = 0; x < 10; x++) {
            new Thread(()->{
                Singleton singleton =Singleton.getInstance();
                System.out.println(singleton);
            },"单例操作线程"+x).start();
        }


        Class<?> aClass2 = Class.forName("com.liuDay003.BookDemo1");
        Constructor<?> declaredConstructor = aClass2.getDeclaredConstructor(String.class, String.class, double.class);
        BookDemo1 o1 =(BookDemo1) declaredConstructor.newInstance("java", "####", 1234.234);
        System.out.println(o1.toString());

        Method method[] = aClass2.getMethods();
        for (Method method1 : method) {
            System.out.println(method1);
        }

    }
}
