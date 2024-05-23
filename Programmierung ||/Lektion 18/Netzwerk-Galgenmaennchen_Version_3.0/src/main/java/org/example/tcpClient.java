package org.example;

import java.io.*;
import java.net.Socket;

public class tcpClient
{
    public static void main(String[] args)
    {
        try(Socket connectionToServer = new Socket("localhost",12345);
            BufferedReader in = new BufferedReader(new InputStreamReader(connectionToServer.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(connectionToServer.getOutputStream()));
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in)))
        {
            out.write("Hangman");
            out.newLine();
            out.flush();

            while(true){
                String vomServer = in.readLine();
                System.out.println(vomServer);

                if (vomServer.contains("The word is guessed") ||
                    vomServer.contains("No more attempts left.")){
                    break;
                }

                String zumServer = consoleReader.readLine();
                out.write(zumServer);
                out.newLine();
                out.flush();
            }
        }
        catch (IOException e)
        {
            e.getStackTrace();
        }
    }
}
