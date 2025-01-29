package Klausurvorberaitung.ss2020.Aufgabe2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class TextServer {

    // c)
    Game g;
    public TextServer(Game g) {
        this.g = g;
        g.reset(); //starts new Game
    }
    public void start() throws IOException
    {
        try (ServerSocket ss = new ServerSocket(5000);)
        {
            // b)
            while (true) {
                try {
                    Socket connection = ss.accept();
                    handleConnection(connection);
                } catch (IOException e) {
                    System.err.println("Fehler bei der Verarbeitung einer Verbindung: " + e.getMessage());
                }
            }
        }
    }
    private void handleConnection(Socket connection) throws IOException
    {
        try(BufferedReader fromClient = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
            BufferedWriter toClient = new BufferedWriter(
                    new OutputStreamWriter(connection.getOutputStream()));)
        {
            String line = fromClient.readLine();
            if (line.equals(g.initGameString()))
            {
                writeToClient(toClient, g.welcomeString());
                play(fromClient, toClient);
            }
        }
    }
    protected void play(BufferedReader fromClient, BufferedWriter toClient)
            throws IOException {
        do {
            String line = fromClient.readLine();
            if (line == null) break;
            writeToClient(toClient, g.handleInput(line));
        }
        while (g.running());
    }
    protected static void writeToClient(BufferedWriter toClient, String s) throws IOException {
        // a)
        toClient.write(s);
        toClient.newLine();
        toClient.flush();
    }
    public static void main(String[] args) throws IOException
    {
        TextServer server = new TextServer(new GameGalgenmaennchen());
        server.start();
    }
}
