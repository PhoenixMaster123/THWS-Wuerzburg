package summary.Sockets;

import java.io.*;
import java.net.Socket;

public class TCPClient {
    private static final String host = "localhost";
    private static final int port = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(host, port);
             BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             OutputStream os = socket.getOutputStream()) {
            System.out.println("Client is connected to the server on port " + port);
            os.write("Hello from the client!\n".getBytes());
            os.flush();
            String response = br.readLine();
            System.out.println("Server response: " + response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void connection() {
        try (Socket socket = new Socket(host, port);
             BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
            System.out.println("Client is connected to the server on port " + port);
            bw.write("Hello from the client!");
            bw.newLine();
            bw.flush();
            String response = br.readLine();
            System.out.println("Server response: " + response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
