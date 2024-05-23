package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class tcpServer
{
    public static void main(String[] args)
    {
        boolean stop = false;

        System.out.println("Server started, waiting for client");
        while (!stop) {

            try (ServerSocket serverSocket = new ServerSocket(12345);
                 Socket connection = serverSocket.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                 PrintWriter out = new PrintWriter(connection.getOutputStream(), true))
            {
                System.out.println("New Connection:");
                System.out.println(connection.getLocalAddress().getHostName() + " (" + connection.getLocalAddress().getHostAddress() + ")");
                System.out.println();

                Galgamaennchen gm = new Galgamaennchen();

                out.println(gm.welcome());

                while (gm.isRunning()) {
                    String userInput = in.readLine();
                    if (userInput == null || userInput.equalsIgnoreCase("disconnect")) {
                        break;
                    }

                    String response = gm.processUserInput(userInput);
                    out.println(response);
                }

                if (!gm.isRunning()) {
                    out.println("Game over. The word was: " + gm.getWord());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
