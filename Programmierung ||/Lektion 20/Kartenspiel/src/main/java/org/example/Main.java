package org.example;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Player player = new Player();
        player.add("Kevin");
        player.add("John");
        player.add("Maria");
        player.add("Simon");

        Map<String, String> players = Player.map;
        String randomCard = player.pickRandomCard();

        //gameStart(players, randomCard);
        player.printPlayers();
    }

   /* private static void gameStart(Map<String, String> players, String randomCard)
    {
        List<String> playerList = new ArrayList<>(players.keySet());
       // List<String> playerValues = new ArrayList<>(players.values());
        int currentPlayerIndex = 0;

        while (true) {
            String currentPlayer = playerList.get(currentPlayerIndex);
            System.out.println(currentPlayer + "'s turn!");
            // Your game logic for the current player goes here



            currentPlayerIndex++; // Move to the next player
            if (currentPlayerIndex == playerList.size()) {
                currentPlayerIndex = 0; // Wrap around to the first player
            }
        }
    }
    */

}