package summary.Sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerObject {
    public void main(String[] args) {
        int port = 12345;
        try(ServerSocket serverSocket = new ServerSocket(port);
            Socket socket = serverSocket.accept();
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) {
            System.out.println("Server is running on port " + port);

            Person person = (Person) ois.readObject();
            System.out.println("Client message: " + person);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
