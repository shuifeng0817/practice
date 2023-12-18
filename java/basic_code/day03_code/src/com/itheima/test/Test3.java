package com.itheima.test;

public class Test3 {
    public static void main(String[] args) {
        int number1 = 10;
        int number2 = 20;

       /* int max = number1 > number2 ? number1 : number2;
        System.out.println(max);*/

        /*Scanner sc=new Scanner(System.in);
        System.out.println("请输入第一只老虎的体重");
        int weight1=sc.nextInt();
        System.out.println("请输入第二只老虎的体重");
        int weight2=sc.nextInt();
        String result=weight1==weight2?"相同":"不同";
        System.out.println(result);*/

        int height1 = 150;
        int height2 = 210;
        int height3 = 165;

        int temp = height1 > height2 ? height1 : height2;
        int max = temp > height3 ? temp : height3;
        System.out.println(max);

    }
}
