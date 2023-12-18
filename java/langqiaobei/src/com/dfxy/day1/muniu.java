package com.dfxy.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class muniu {
    static int cow1 =1;
    public static void main(String[] args) {
        List list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        while (!(a==0)) {
           // cowCount(a, list);
           cowCount2(a);
           list.add(cow1);
           cow1=1;
            a= scanner.nextInt();
        }
        for (Object o : list) {
            System.out.println(o);
        }


    }
    public static void cowCount(int a, List list){
        int zongShu =1;//奶牛总数
        int count = 1;//奶牛是否成年
        int count1 =0;//计数器
        int chengNianCow =1;//成年奶牛个数

        while (true){

            if(count==4){
                chengNianCow++;
                count=0;
            }
            if(count1==0){
                count1=1;
                continue;
            }else {
                zongShu = zongShu += chengNianCow;
                count1++;
            }
            count++;
            if(count1==a){
                break;
            }
        }
        list.add(zongShu);

    }
    public static void cowCount2(int a){
        int count=1;

        while (true) {
            if (count %4==0) {
                a-=4;
                cowCount2(a);
                count-=3;
            }
            cow1++;

            if(count==a){
                break;
            }
            count++;
        }
    }
}
