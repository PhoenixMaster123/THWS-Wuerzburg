package org.example;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

public class Client
{
    private Socket socket;
    public static final String HOST = "localhost";
    public static final int PORT = 12345;

    public static void main(String[] args)
    {
        new Client().sentNumbers();
    }

    public void sentNumbers()
    {
        List<Long> numbers = Arrays.asList(2l, 3l, 4l, 5l, 16l, 17l, 18l, 19l, 20l, 191l, 361l, 9999999929l, 99988869l);


        try (Socket socket = new Socket(HOST, PORT);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream()))
        {
            Thread.sleep(1000);
            out.writeObject(numbers);
            out.flush();

            for (Long number : numbers)
            {
                boolean isPrime = (Boolean) in.readObject();
                System.out.println(number + (isPrime ? " is prime" : " is not prime"));
                Thread.sleep(1000);
            }
        }
        catch (IOException | ClassNotFoundException  | InterruptedException e) {
            e.getStackTrace();
        }
    }
}
