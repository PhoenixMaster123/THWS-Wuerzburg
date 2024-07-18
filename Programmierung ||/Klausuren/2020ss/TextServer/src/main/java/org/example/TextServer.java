package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TextServer
{
    GameGalgenmaennchen g;
    GameVierGewinnt v;
    GameTicTacToe t;
    Game gm = null;
    public TextServer(GameGalgenmaennchen g, GameVierGewinnt v, GameTicTacToe t)
    {
        this.g = g; //starts new Game
        g.reset();
        this.v = v;
        v.reset();
        this.t = t;
        t.reset();
    }
    public void start() throws IOException
    {
        try (ServerSocket ss = new ServerSocket(5000))
        {
            try(Socket connection = ss.accept())
            {
                handleConnection(connection);
            }
        }
        catch (IOException e)
        {
            System.err.println("I/O error: " + e.getMessage());
        }
    }
    private void handleConnection(Socket connection) throws IOException
    {
        try(BufferedReader fromClient = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            BufferedWriter toClient = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));)
        {
            String line = fromClient.readLine();
            if(line.equals("Tic-Tac-Toe"))
            {
                gm = t;
                writeToClient(toClient, t.welcomeString());
                play(fromClient,toClient);
            }
            else if (line.equals("Vier Gewinnt"))
            {
                gm = v;
                writeToClient(toClient, v.welcomeString());
                play(fromClient, toClient);
            }
            if (line.equals(g.initGameString()))
            {
                gm = g;
                writeToClient(toClient, g.welcomeString());
                play(fromClient, toClient);
            }
        }
        catch (IOException e)
        {
            System.err.println("I/O error: " + e.getMessage());
        }
    }
    protected void play(BufferedReader fromClient, BufferedWriter toClient)  throws IOException
    {
        do {
            String line = fromClient.readLine();
            if (line == null) break;
            writeToClient(toClient, gm.handleInput(line));
        }
        while (gm.running());
    }
    protected static void writeToClient(BufferedWriter toClient, String s) throws IOException
    {
        toClient.write(s);
        toClient.newLine();
        toClient.flush();
    }

    public static void main(String[] args) throws IOException
    {
        TextServer server = new TextServer(new GameGalgenmaennchen(), new GameVierGewinnt(), new GameTicTacToe());
        server.start();
    }
}
