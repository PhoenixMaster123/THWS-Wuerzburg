package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Game start:");
        String word = generateWord();

        // Start TCP server
        new Thread(() -> tcpServer(word)).start();

        char[] hiddenWord = new char[word.length()];
        Arrays.fill(hiddenWord, '_');
        System.out.println("You are word is: " + String.valueOf(hiddenWord));
        int versuchs = 15;
        int count = 1;
        /////////////////////////////// Short Variant with streams /////////////////////////
       // List<Character> words = word.chars().mapToObj(c -> (char) c).toList(); // = foreach + words.add()


        while (versuchs > 0 && !isTheWordGuessed(hiddenWord))
        {

            char letter = scanner.nextLine().charAt(0);
            // Send guess to TCP client
            String response = tcpClient(letter);
            if(response.equals("OK"))
            {
                System.out.print(count++ + ". " + "Versuch: ");
                updateTheWord(word, letter, hiddenWord);
            }
            else
            {
                System.out.println(count++ + ". " + "Versuch: " + String.valueOf(hiddenWord));
            }
            versuchs--;

            if(isTheWordGuessed(hiddenWord))
            {
                System.out.println("Das Wort ist erraten: " + word);
            }

        }
        if(!isTheWordGuessed(hiddenWord))
        {
            System.out.println("Das Wort wird nicht erraten: " + word);
        }

    }

    private static boolean isTheWordGuessed(char[] arr)
    {
        for (char c : arr)
        {
            if(c == '_')
            {
                return false;
            }
        }
        return true;
    }

    public static void updateTheWord(String word, char guess, char[] hiddenWord)
    {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess) {
                hiddenWord[i] = guess;
            }
        }
        System.out.println(String.valueOf(hiddenWord));
    }

    public static void tcpServer(String word)
    {
        try(ServerSocket serverSocket = new ServerSocket(12345))
        {
            System.out.println("Server started, waiting for client");
            while (true) {

                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    int charachter = in.read();
                    char guess = (char) charachter;
                    System.out.println("Server received: " + guess);
                    if (word.contains(String.valueOf(guess))) {
                        System.out.println("Client received: OK ");
                        out.println("OK");
                        //  out.flush();
                    } else {
                        System.out.println("Client received: Error ");
                        out.println("Error");
                        // out.flush();
                    }

                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
    public static String tcpClient(char guess)
    {
        try(Socket connectionToServer = new Socket("localhost", 12345);
            BufferedReader in = new BufferedReader(new InputStreamReader(connectionToServer.getInputStream()));
            PrintWriter out = new PrintWriter(connectionToServer.getOutputStream()))
        {

            out.println(guess);
            out.flush();
            return in.readLine(); // response

           //String line;

          /* while ((line = input.readLine()) != null)
           {
               out.println(line);
               out.flush();
               System.out.println("Server response: " + in.readLine());
           }
           */
        }
        catch (IOException e)
        {
            e.getStackTrace();
            return "Error";
        }
    }


    public static String generateWord()
    {
        ///////////////////////////////// Short Variant ////////////////////////
        List<String> words =
                Arrays.asList("Programmieren", "Netzwerk", "Geschwindigkeit",
                "Landschaft", "Sonnenuntergang", "Wanderung","Zusammensein", "Freiheit", "Hoffnung");
        Random random = new Random();
        return words.get(random.nextInt(words.size())).toLowerCase();

        ///////////////////////////////// Long Variant ////////////////////////
        /*
        List<String> words = new ArrayList<>();
        words.add("Programmieren");
        words.add("Netzwerk");
        words.add("Geschwindigkeit");
        words.add("Landschaft");
        words.add("Sonnenuntergang");
        words.add("Wanderung");
        words.add("Zusammensein");
        words.add("Freiheit");
        words.add("Hoffnung");
         */

    }
}