package com.liuDay005.TCP;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 9999);
        Scanner scanner = new Scanner(client.getInputStream());
        if(scanner.hasNext()){
            System.out.println("Client"+scanner.next());
        }
        client.shutdownInput();
        client.close();
    }
}
