import java.util.List;

public class Card implements Comparable<Card>
{
    String value;
    String suit;

    public Card(String value, String suit)
    {
        this.value = value;
        this.suit = suit;
    }

    public static boolean isCardInHand(List<Card> hand, Card card)
    {
        for (Card c : hand)
        {
            if(c.suit.equals(card.suit) && c.value.equals(card.value))
            {
                return true;
            }
        }
        return false;
    }

    public String toString()
    {
        return value + " of " + suit;
    }

    @Override
    public int compareTo(Card card)
    {
        if(this.value.equals("Bube") && card.value.equals("Bube"))
        {
            return getSuitOrder(this.suit) - getSuitOrder(card.suit);
        } else if (this.value.equals("Bube"))
        {
            return -1;
        } else if (card.value.equals("Bube"))
        {
            return 1;
        }
        else
        {
            int suitComparison = getSuitOrder(this.suit) - getSuitOrder(card.suit);
            if(suitComparison != 0)
            {
                return suitComparison;
            }
            return getSuitOrder(card.suit) - getSuitOrder(this.suit);
        }
    }
    private int getRankOrder(String rank)
    {
        return switch (rank) {
            case "Ass" -> 14;
            case "König" -> 13;
            case "Dame" -> 12;
            case "Bube" -> 11;
            case "10" -> 10;
            case "9" -> 9;
            case "8" -> 8;
            case "7" -> 7;
            default -> 0;
        };
    }
    private int getSuitOrder(String suit)
    {
        return switch (suit)
        {
            case "Kreuz" -> 1;
            case "Pik" -> 2;
            case "Herz" -> 3;
            case "Karo" -> 4;
            default -> 0;
        };
    }
}
