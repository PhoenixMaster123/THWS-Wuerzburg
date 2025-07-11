package summary.Threads.ThreadWithTCPServerAndClient;

import java.io.*;
import java.net.*;

class ClientHandler implements Runnable {
    private final Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try (
                BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            String message;
            System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

            while ((message = input.readLine()) != null) {
                System.out.println("Received: " + message);
                if (message.equalsIgnoreCase("bye")) {
                    output.println("Goodbye!");
                    break;
                }
                output.println("Server: " + message.toUpperCase());
            }

            System.out.println("Client disconnected: " + clientSocket.getInetAddress().getHostAddress());
        } catch (IOException e) {
            System.err.println("Error handling client: " + e.getMessage());
        }
    }
}