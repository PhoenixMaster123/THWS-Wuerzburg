package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class KartenSpiel
{
    public KartenSpiel()
    {
        gameStart();
    }

    ArrayList<Card> deck;
    Random random = new Random();
   // Player player = new Player();

    // Player hand
    ArrayList<Card> playerHand;
    Map<String, ArrayList<Card>> players;

    public void gameStart()
    {
        buildDeck();
        shuffleDeck();

        //player hand

        playerHand = new ArrayList<>();
        players = new HashMap<>();

        for (int i = 0; i < Player.namesPlayers.size(); i++)
        {
            String newPlayer = Player.namesPlayers.get(i);
            for (int j = 0; j < 5; j++)
            {
                Card card = deck.removeLast();
                playerHand.add(card);
            }
            players.put(newPlayer, playerHand);
            playerHand = new ArrayList<>();
        }
        for (String p : players.keySet()) {
            ArrayList<Card> hand = players.get(p);  // Get player's hand
            System.out.println(p + ": " + hand);
        }
    }


    public void buildDeck()
    {
        deck = new ArrayList<>();
        String[] values = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
        String[] suits = {"spades","clubs","hearts","diamonds"};

        for (String suit : suits) {
            for (String value : values) {
                Card card = new Card(value, suit);
                deck.add(card);
            }
        }
    }
    public void shuffleDeck()
    {
        for(int i = 0; i < deck.size(); i++)
        {
            int j = random.nextInt(deck.size());
            Card currentCard = deck.get(i);
            Card randomCard = deck.get(j);
            deck.set(i, randomCard);
            deck.set(j, currentCard);
        }
    }
}
