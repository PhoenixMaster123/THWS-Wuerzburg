package ChatGPT.Client_Server_Chatroom;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static final int PORT = 12345;
    // add a new client to the set
    private static final Set<ClientHandler> clients = ConcurrentHashMap.newKeySet();
    public void main(String[] args) {
        System.out.println("Chat-Server wird gestartet...");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started");
            while (true) {
                Socket clientSocket  = serverSocket.accept();
                System.out.println("Client connected");
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clients.add(clientHandler);
                new Thread(clientHandler).start();
                // Thread thread = new Thread(new ClientHandler(clientSocket));
                // thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
