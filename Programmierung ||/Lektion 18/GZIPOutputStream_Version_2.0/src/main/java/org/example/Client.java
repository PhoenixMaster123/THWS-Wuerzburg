package org.example;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPOutputStream;

public class Client {
    public static void main(String[] args)
    {
        final int PORT  = 5000;
        final String HOST = "localhost";

        byte[] bytesToTransfer = "Hallo Welt".getBytes(StandardCharsets.UTF_8);

        try(Socket connectionToHost = new Socket(HOST,PORT);
            OutputStream os = connectionToHost.getOutputStream();
            GZIPOutputStream gzip = new GZIPOutputStream(os))
        {
            gzip.write(bytesToTransfer,0,bytesToTransfer.length);
        }
        catch (IOException e)
        {
            e.getStackTrace();
        }
    }
}