package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class tcpServer {
    public static void main(String[] args) {
        System.out.println("Server started, waiting for client...");

        try (ServerSocket serverSocket = new ServerSocket(12345);
             Socket clientSocket = serverSocket.accept();
             ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream()))
        {

            String game = (String) in.readObject();
            Game gm = null;
            if(game.equals("Hangman"))
            {
                System.out.println("Server received: " + game);

                gm = new Galgamaennchen();

            }
            out.writeObject(new Response(gm.welcome()));
            out.flush();

            while(gm.isRunning()){
                Guess vomClient = (Guess) in.readObject();
                Response response = new Response(gm.processUserInput(String.valueOf(vomClient.guess)));
                out.writeObject(response);
                out.flush();
            }

        }
        catch(IOException | ClassNotFoundException e) {
            e.getStackTrace();
        }
    }
}