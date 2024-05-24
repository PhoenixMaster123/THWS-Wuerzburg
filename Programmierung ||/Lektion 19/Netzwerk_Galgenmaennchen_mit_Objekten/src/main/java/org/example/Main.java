package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Game start:");
        String word = generateWord();

        // Start TCP server
        new Thread(() -> tcpServer(word)).start();

        char[] hiddenWord = new char[word.length()];
        Arrays.fill(hiddenWord, '_');
        System.out.println("You are word is: " + String.valueOf(hiddenWord));
        int count = 1;
        int versuchs = 15;
        char letter = scanner.nextLine().charAt(0);
        Guess guess = new Guess(letter);

        while (versuchs > 0) {
            // Send guess to TCP client
            Response response = tcpClient(guess);
            if (response.message.equals("OK")) {
                System.out.print(count++ + ". " + "Versuch: ");
                updateTheWord(word, letter, hiddenWord);
            } else {
                System.out.println(count++ + ". " + "Versuch: " + String.valueOf(hiddenWord));
            }

            if (isTheWordGuessed(hiddenWord)) {
                System.out.println("Das Wort ist erraten: " + word);
                break;
            }
            versuchs--;

            letter = scanner.nextLine().charAt(0);
            guess = new Guess(letter);
        }
        if (!isTheWordGuessed(hiddenWord)) {
            System.out.println("Das Wort wird nicht erraten: " + word);
        }
    }

    private static boolean isTheWordGuessed(char[] arr) {
        for (char c : arr) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }

    public static void updateTheWord(String word, char guess, char[] hiddenWord) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess) {
                hiddenWord[i] = guess;
            }
        }
        System.out.println(String.valueOf(hiddenWord));
    }

    public static void tcpServer(String word) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server started, waiting for client");
            while (true) {

                try (Socket clientSocket = serverSocket.accept();
                     ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                     ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream())) {

                    Guess guess = (Guess) in.readObject(); // The objects that are in the server are only serializable


                    boolean isCorrectGuess = word.contains(String.valueOf(guess));

                    Response response = new Response(isCorrectGuess ? "OK" : "Error");
                    out.writeObject(response);
                    out.flush();

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static Response tcpClient(Guess guess) {
        try (Socket connectionToServer = new Socket("localhost", 12345);
             ObjectOutputStream out = new ObjectOutputStream(connectionToServer.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(connectionToServer.getInputStream())) {

            out.writeObject(guess); // Send Guess object
            out.flush();
            return (Response) in.readObject(); // Receive Response object
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


        public static String generateWord()
        {
            ///////////////////////////////// Short Variant ////////////////////////
            List<String> words =
                    Arrays.asList("Programmieren", "Netzwerk", "Geschwindigkeit",
                            "Landschaft", "Sonnenuntergang", "Wanderung", "Zusammensein", "Freiheit", "Hoffnung");
            Random random = new Random();
            return words.get(random.nextInt(words.size())).toLowerCase();
        }
    }

