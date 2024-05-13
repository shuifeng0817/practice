package com.liuDay008;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionExample {
    private String name;
    public int age;

    public ReflectionExample(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void sayHello() {
        System.out.println("Hello, I'm " + name);
    }

    public static void main(String[] args) throws Exception {
        // 获取ReflectionExample类的Class对象
        Class<?> reflectionClass = ReflectionExample.class;

        // 获取类的字段信息
        System.out.println("Fields:");
        Field[] fields = reflectionClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName() + " - " + field.getType());
        }

        // 获取类的方法信息
        System.out.println("Methods:");
        Method[] methods = reflectionClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName() + " - " + method.getReturnType());
        }

        // 使用反射创建对象并调用方法
        System.out.println("Object creation and method invocation:");
        ReflectionExample example = (ReflectionExample) reflectionClass.getDeclaredConstructor(String.class, int.class).newInstance("John", 25);
        Method sayHelloMethod = reflectionClass.getDeclaredMethod("sayHello");
        sayHelloMethod.invoke(example);
    }
}
