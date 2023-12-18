package com.itheima;

import java.util.Random;

public class Test1yanzheng {
    public static void main(String[] args) {
        //1.大写字母和小写字母都放到数组当中
        char[] chs =new char[52];
        for (int i = 0; i < chs.length; i++) {
            if(i<=25) {
                chs[i] = (char) (97 + i);
            }
            else{
                chs[i]=(char)(65+i-26);
            }
        }
        //定义一个字符串的变量,记录最终结果
        String result ="";
        //2.随机抽取4次
        //随机抽取数组中的索引
        Random r=new Random();
        for (int i = 0; i < 4; i++) {
            int randomIndex=r.nextInt(chs.length);
            //利用随机索引获取对应元素
            result=result+chs[randomIndex];
        }
        //3.随机抽取一个数字
        int number=r.nextInt(10);
        result=result+number;
        System.out.print(result);
    }

}
