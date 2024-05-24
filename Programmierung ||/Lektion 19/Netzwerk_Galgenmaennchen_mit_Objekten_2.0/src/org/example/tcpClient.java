package org.example;

import java.io.*;
import java.net.Socket;

public class tcpClient
{
    public static void main(String[] args)
    {
        try (Socket connectionToServer = new Socket("localhost", 12345);
             ObjectOutputStream out = new ObjectOutputStream(connectionToServer.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(connectionToServer.getInputStream());
             BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in)))
        {
            out.writeObject("Hangman");
            out.flush();

            while (true)
            {
                Response vomServer = (Response) in.readObject();
                System.out.println(vomServer);

                if (vomServer.message.contains("The word is guessed") ||
                        vomServer.message.contains("No more attempts left.")){
                    break;
                }

                Guess zumServer = new Guess(consoleReader.readLine().charAt(0));
                out.writeObject(zumServer);
                out.flush();
            }
        }
        catch (IOException | ClassNotFoundException ex)
        {
            throw new RuntimeException(ex);
        }
    }
}
