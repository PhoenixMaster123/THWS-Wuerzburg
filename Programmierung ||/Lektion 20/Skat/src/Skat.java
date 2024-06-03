import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Skat 
{
    ArrayList<Card> deck;
    Random random = new Random();

    ArrayList<Card> playerHand;
    public Skat()
    {
        startGame();
    }

    public void startGame()
    {
        buildDeck();
        shuffleDeck();

        // Player hand

        playerHand = new ArrayList<>();

        for (int i = 0; i < 10; i++)
        {
            Card card = deck.removeLast();
            playerHand.add(card);
        }

        sortCards(playerHand);
    }

    private void sortCards(ArrayList<Card> playerHand)
    {
        Collections.sort(playerHand, new SkatComparator());
        System.out.println(playerHand);
    }

    private void shuffleDeck()
    {
        // Short version
        Collections.shuffle(deck);
        //System.out.println(deck);

        /*for (int i = 0; i < deck.size(); i++)
        {
            int j = random.nextInt(deck.size());
            Card currentCard = deck.get(i);
            Card randomCard = deck.get(j);
            deck.set(i, randomCard);
            deck.set(j, currentCard);
        }
         */
    }

    private void buildDeck()
    {
        deck = new ArrayList<>();

        String[] values = {"7", "8", "9", "10", "J", "Q","K", "A"};
        String[] suits = {"spades", "clubs", "hearts", "diamonds"};

        for (String suit : suits) {
            for (String value : values) {
                Card card = new Card(value, suit);
                deck.add(card);
            }
        }

       // System.out.println(deck);
    }
}
