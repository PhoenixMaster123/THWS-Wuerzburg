package summary.Sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    private static final int port = 12345;

    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(port);
            Socket socket = serverSocket.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            System.out.println("Server is running on port " + port);

            String message = br.readLine();
            System.out.println("Client message: " + message);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
