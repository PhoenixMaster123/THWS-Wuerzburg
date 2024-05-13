package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;

public class Server
{
    public static void main(String[] args)
    {
        final int PORT = 5000;

        try(ServerSocket ss = new ServerSocket(PORT);
            Socket connection = ss.accept();
            InputStream is = connection.getInputStream();
            GZIPInputStream gzip = new GZIPInputStream(is))
        {
            byte[] got = gzip.readAllBytes();
            String message = new String(got, StandardCharsets.UTF_8);
            System.out.println(message);
        }
        catch (IOException e)
        {
            e.getStackTrace();
        }
    }
}
