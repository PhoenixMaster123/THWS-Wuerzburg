package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Client {
    // Klausur Aufgabe m
    public static void main(String[] args) {

        new Thread(Client::Server).start();

        try(Socket connectionToHost = new Socket("localhost", 5555);
            GZIPOutputStream os = new GZIPOutputStream(connectionToHost.getOutputStream()))
        {
            byte[] bytesToTransfer = "Hallo Welt\n".getBytes();
            os.write(bytesToTransfer);
            os.flush();
        }
        catch (IOException e)
        {
            e.getStackTrace();
        }
    }
    public static void Server()
    {
        try(ServerSocket serverSocket = new ServerSocket(5555))
        {

            while (true)
            {
                try(Socket clientSocket = serverSocket.accept();
                    GZIPInputStream out = new GZIPInputStream(clientSocket.getInputStream());
                    BufferedReader in = new BufferedReader(new InputStreamReader(out)))
                {
                    String line;
                    while((line = in.readLine()) != null)
                    {
                        System.out.println(line);
                    }
                }
            }
        }
        catch (IOException e)
        {
            e.getStackTrace();
        }
    }
}