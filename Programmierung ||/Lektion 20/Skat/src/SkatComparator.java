import java.util.Comparator;

class SkatComparator implements Comparator<Card> {
    /////////////////// The order is wrong but the logic correct ///////////////
    @Override
    public int compare(Card card1, Card card2) {
        // Suit order (Spades > Clubs > Hearts > Diamonds)
        int suitComparison = compareSuits(card1.suit, card2.suit);
        if (suitComparison != 0) {
            return suitComparison;
        }

        // Value order within the same suit (Jack > Queen > King > Ace > 10 > 9 > 8 > 7)
        return compareValues(card1.value);
    }

    private int compareSuits(String suit1, String suit2) {
        // Map suit names to order values (Spades = 1, Clubs = 2, Hearts = 3, Diamonds = 4)
        int order1 = switch (suit1) {
            case "spades" -> 1;
            case "clubs" -> 2;
            case "hearts" -> 3;
            case "diamonds" -> 4;
            default -> 0;
        };
        int order2 = switch (suit2) {
            case "spades" -> 1;
            case "clubs" -> 2;
            case "hearts" -> 3;
            case "diamonds" -> 4;
            default -> 0;
        };
        return order1 - order2;
    }

    private int compareValues(String value1) {
        // Map face card values and numeric values
        int order1 = switch (value1) {
            case "J" -> 11;
            case "Q" -> 12;
            case "K" -> 13;
            case "A" -> 14;
            default -> Integer.parseInt(value1);
        };
        return order1;
    }
}
