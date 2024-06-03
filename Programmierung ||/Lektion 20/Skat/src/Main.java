import java.util.*;

public class Main {
    public static void main(String[] args)
    {
       // Skat skat = new Skat();

        List<Card> hand = new ArrayList<>();
        Random random = new Random();
        String[] suits = {"Kreuz", "Pik", "Herz", "Karo"};
        String[] cards = {"Ass", "König", "Dame", "Bube", "10", "9", "8", "7"};

        while (hand.size() < 10)
        {
            String suit = suits[random.nextInt(suits.length)];
            String rank = cards[random.nextInt(cards.length)];
            Card card = new Card(suit,rank);

            if(!Card.isCardInHand(hand,card))
            {
                hand.add(card);
            }
        }
        Collections.sort(hand);
        System.out.println(hand);
    }
}