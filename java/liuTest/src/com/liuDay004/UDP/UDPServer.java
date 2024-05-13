package com.liuDay004.UDP;

import java.io.IOException;
import java.net.*;

public class UDPServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket server = new DatagramSocket(8000);
        String message = "Hello World";
        DatagramPacket packet = new DatagramPacket(message.getBytes(),0, message.length(), InetAddress.getByName("localhost"),9999);
        server.send(packet);
        System.out.println("Server sent message: " + message);
        server.close();
    }
}
