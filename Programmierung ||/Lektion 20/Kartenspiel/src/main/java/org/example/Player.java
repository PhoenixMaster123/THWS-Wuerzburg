package org.example;

import java.util.*;

public class Player
{
    static List<String> suit = Arrays.asList("hearts", "diamonds", "clubs", "spades");
    static List<String> cards = Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A");
    static Map<String,String> map = new HashMap<>();

    Set<String> set = new HashSet<>();

    public void add(String name)
    {
        map.put(name, generateDeck());
    }

    public void printPlayers() {
        for (String listPlayer : map.keySet()) {
            String deck = map.get(listPlayer);
            System.out.println(listPlayer + ": " + deck);
        }
    }
    public String pickRandomCard()
    {
        List<String> allCards = addAllCards();
        Random random = new Random();
        while (true)
        {
            String card = allCards.get(random.nextInt(allCards.size()));
            if(!set.contains(card))
            {
                set.add(card);
                return card;
            }
        }
    }

    private String generateDeck() {

        List<String> cardsCopy = addAllCards();

        Set<String> pickedCards = new HashSet<>();

        Random random = new Random();

        while (pickedCards.size() < 5 && !cardsCopy.isEmpty()) {
            String pickedCard = cardsCopy.get((random.nextInt(cardsCopy.size())));

            if(set.contains(pickedCard))
            {
                continue;
            }
            else
            {
                pickedCards.add(pickedCard);
                set.add(pickedCard);
            }

        }
        return pickedCards.toString();
    }
    private List<String> addAllCards()
    {
        List<String> cardsCopy = new ArrayList<>();
        for (String cards : cards) {
            for (String suit : suit) {
                String combine = cards + " of " + suit;
                cardsCopy.add(combine);
            }
        }
        return cardsCopy;
    }

    //////////////////////////////// Variant 2 //////////////////////////////
    // -> Generate all cards and after that when given card is selected you need to remove it.
    // -> This method only generate all cards with all suits in sorted way

   /* public static TreeMap<String, String> generateDeck() {
        TreeMap<String, String> cards2 = new TreeMap<>();
        for (String card : cards) {
            for (String suit : suit) {
                String cardName = card + " of " + suit;
                cards2.put(cardName, suit);
            }
        }
        return cards2;
    }
    */
}
