package org.example;

import java.io.*;
import java.net.Socket;

public class tcpClient
{
    public static void main(String[] args)
    {
        try (Socket connectionToServer = new Socket("localhost", 12345);
             BufferedReader inServer = new BufferedReader(new InputStreamReader(connectionToServer.getInputStream()));
             PrintWriter out = new PrintWriter(connectionToServer.getOutputStream(), true);
             BufferedReader inConsole = new BufferedReader(new InputStreamReader(System.in)))
        {
            String serverResponse;
            while ((serverResponse = inServer.readLine()) != null) {
                System.out.println("Server: " + serverResponse);

                if (serverResponse.contains("Game over")) {
                    break;
                }

                String userInput = inConsole.readLine();
                if (userInput == null || userInput.isEmpty()) {
                    continue;
                }

                out.println(userInput);

                if (userInput.equalsIgnoreCase("disconnect")) {
                    break;
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
