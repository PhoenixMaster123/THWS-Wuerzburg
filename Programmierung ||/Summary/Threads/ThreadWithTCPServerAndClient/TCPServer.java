package summary.Threads.ThreadWithTCPServerAndClient;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) {
        int port = 12345;
        System.out.println("Server is listening on port " + port);

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                // Accept incoming client connections
                Socket clientSocket = serverSocket.accept();
                // Handle each client in a new thread
                new ClientHandler(clientSocket).run();
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }
}
