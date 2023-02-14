package interfaces;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

interface Card extends Comparable<Card> {
    public enum Suit {
        DIAMOND (1, "Diamond"),
        CLUBS (2, "Clubs"),
        HEARTS (3, "Hearts"),
        SPADES (4, "Spades");

        private final int value;
        private final String text;
        Suit(int value, String text) {
            this.value = value;
            this.text = text;
        }
        public int value() { return value; }
        public String text() { return text; }
    }

    public enum Rank {
        DEUCE (2, "Two"),
        THREE (3, "Three"),
        FOUR (4, "Four"),
        FIVE (5, "Five"),
        SIX (6, "Six"),
        SEVEN (7, "Seven"),
        EIGHT (8, "Eight"),
        NINE (9, "Nine"),
        TEN (10, "Ten"),
        JACK (11, "Jack"),
        QUEEN (12, "Queen"),
        KING (13, "King"),
        ACE (14, "Ace");

        private final int value;
        private final String text;
        Rank(int value, String text) {
            this.value = value;
            this.text = text;
        }

        public int value() { return value; }
        public String text() { return text; }
    }

    public Card.Suit getSuit();
    public Card.Rank getRank();
}

interface Deck {
    List<Card> getCards();
    Deck deckFactory();
    int size();
    void addCard(Card card);
    void addCards(List<Card> cards);
    void addDeck(Deck deck);
    void shuffle();
    void sort();
    void sort(Comparator<Card> c);
    String deckToString();

    Map<Integer, Deck> deal(int players, int numbersOfCards) throws IllegalArgumentException;
}

public class InterfaceDemo {
    public static void main(String[] args) {
        
    }
}
