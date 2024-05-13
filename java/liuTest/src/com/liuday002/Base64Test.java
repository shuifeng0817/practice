package com.liuday002;

import java.sql.SQLOutput;
import java.util.Base64;
import java.util.UUID;

public class Base64Test {
    public static void main(String[] args) {
        String message="Hi好";
       Base64.Encoder encoder= Base64.getEncoder();
       byte[] encodeData= encoder.encode(message.getBytes());
        System.out.println(new String(encodeData));
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decodeData =decoder.decode(encodeData);
        System.out.println(new String(decodeData));

        /*String id = UUID.randomUUID().toString();
        System.out.println(id);
        int num[] =new int[10];
        for (int i = 0; i < num.length; i++) {
            System.out.println();
        }*/
    }
}
