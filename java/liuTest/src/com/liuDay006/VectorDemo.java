package com.liuDay006;

import java.util.List;
import java.util.Vector;

public class VectorDemo {
    public static void main(String[] args) throws Exception {
        List<String> v1 = new Vector<>();
        v1.add("1234567890");
        v1.add("地方规划局快乐地方规划局快乐阿是地方规划局快乐");
        v1.add("sdfghjklwertyuiop");
        for (String s : v1) {
            System.out.println(s);
        }
    }
}
