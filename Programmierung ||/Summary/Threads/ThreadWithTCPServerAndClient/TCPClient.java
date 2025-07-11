package summary.Threads.ThreadWithTCPServerAndClient;

import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 12345;

        try (Socket socket = new Socket(hostname, port);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Connected to the server.");
            System.out.println("Type your messages. Type 'bye' to exit.");

            String userInput;
            while (true) {
                System.out.print("Client: ");
                userInput = consoleInput.readLine();
                output.println(userInput); // Send message to the server

                if ("bye".equalsIgnoreCase(userInput)) {
                    break;
                }

                // Read and print the server's response
                String response = input.readLine();
                System.out.println(response);
            }
        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }
}

