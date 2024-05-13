package com.liuDay004.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket client = new DatagramSocket(9999);
        byte[] data = new byte[1024];
        DatagramPacket packet = new DatagramPacket(data, data.length);
        System.out.println("UDPClient等待服务端发送信息");
        client.receive(packet);
        System.out.println("UDPClient接受到消息，内容为："+new String(data,0,packet.getLength()));
        client.close();

    }
}
