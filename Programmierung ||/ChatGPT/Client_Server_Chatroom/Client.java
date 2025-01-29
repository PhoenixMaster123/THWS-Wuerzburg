package ChatGPT.Client_Server_Chatroom;

import java.io.*;
import java.net.Socket;

public class Client {
    private static final String HOST = "localhost";
    private static final int PORT = 12345;

    public static void main(String[] args) {
        System.out.println("Client started");

        try (Socket socket = new Socket(HOST, PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Mit dem Chat-Server verbunden.");
            System.out.println("Nachrichten senden mit ENTER, beenden mit 'exit'.");

            // Thread für eingehende Nachrichten
            Thread messageReader = new Thread(() -> {
                try {
                    String serverMessage;
                    while ((serverMessage = in.readLine()) != null) {
                        System.out.println(serverMessage);
                    }
                } catch (IOException e) {
                    System.err.println("Verbindung zum Server verloren.");
                }
            });
            messageReader.start();

            // Nachrichten senden
            String userMessage;
            while ((userMessage = userInput.readLine()) != null) {
                bw.write(userMessage);
                bw.newLine();
                bw.newLine();
                if ("exit".equalsIgnoreCase(userMessage.trim())) {
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Fehler im Client: " + e.getMessage());
        }
    }
}

