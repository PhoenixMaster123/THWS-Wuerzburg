package org.example;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        tcpServer server = new tcpServer(serverSocket);
        server.startServer();
    }
}