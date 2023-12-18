package com.dfxy.day1;

public class Test4 {
    public static void main(String[] args) {
        String a ="China";
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < a.length(); i++) {
            char b = (char)(a.charAt(i)+4);
            stringBuffer.append(b);
        }
        System.out.println(stringBuffer);
    }
}
