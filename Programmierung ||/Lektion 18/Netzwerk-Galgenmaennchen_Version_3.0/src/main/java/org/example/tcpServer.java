package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class tcpServer {
    public static void main(String[] args) {
        System.out.println("Server started, waiting for client...");

        try (ServerSocket serverSocket = new ServerSocket(12345);
             Socket clientSocket = serverSocket.accept();
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream())))
                     //PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true))
             {

              String game = in.readLine();
              Game gm = null;
              if(game.equals("Hangman"))
              {
                  System.out.println("Server received: " + game);

                  gm = new Galgamaennchen();

              }else if (game.equals("SchereSteinPapier")){
                  // muss Game-Interface implementieren
                  // gm = new SchereSteinPapier();
              }

              out.write(gm.welcome());
              out.newLine();
              out.flush();

              while(gm.isRunning()){
                  String vomClient = in.readLine();
                  String response = gm.processUserInput(vomClient);
                  out.write(response);
                  out.newLine();
                  out.flush();
              }
                /*
                 if(gm.getWord().contains(String.valueOf(game)))
                 {
                     System.out.println("Client received: OK");
                     //out.write("OK");
                 }
                 else
                 {
                     System.out.println("Client received: Incorrect");
                     //out.write("Incorrect");
                 }
                 */

             }
          catch(IOException e) {
            e.getStackTrace();
        }
    }
}
