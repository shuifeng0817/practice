package com.liuDay005.TCP;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端启动监听");
        Socket client = serverSocket.accept();
        PrintWriter printWriter = new PrintWriter(client.getOutputStream());
        printWriter.println("w12");
        client.shutdownOutput();
        serverSocket.close();

    }
}
