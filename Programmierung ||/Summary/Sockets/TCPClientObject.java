package summary.Sockets;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TCPClientObject {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 12345;

        Person person = new Person("John Doe", 30, "Main Street 1");

        try(Socket socket = new Socket(host, port);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream())) {

            oos.writeObject(person);
            System.out.println("Client sent: " + person);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
