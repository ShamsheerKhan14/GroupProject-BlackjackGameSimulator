package ca.sheridancollege.project;

/**
 * This class represents a card in the game of Blackjack, which extends the Card class and adds a value and a suit to
 * it. The value of the card is determined by its rank, with face cards (J, Q, K) valued at 10, and aces valued at 1 or
 * 11, depending on the player's choice. The suit of the card can be one of four possible values: hearts, diamonds,
 * clubs, or spades.
 *
 * @author Shamsheer Khan March 2023
 */
public class BlackjackCard extends Card {

    private int value;
    private String suit;

    /**
     *
     * Constructs a BlackjackCard object with the given value and suit.
     * @param value The value of the card (2-10, J, Q, K, A)
     * @param suit The suit of the card (hearts, diamonds, clubs, spades)
     */
    public BlackjackCard(int value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    /**
     *
     * Returns a string representation of the card.
     * @return The string representation of the card (e.g. "Ace of spades")
     */
    @Override
    public String toString() {
        String face = "";
        switch (value) {
            case 11:
                face = "Jack";
                break;
            case 12:
                face = "Queen";
                break;
            case 13:
                face = "King";
                break;
            case 14:
                face = "Ace";
                break;
            default:
                face = Integer.toString(value);
        }
        return face + " of " + suit;
    }

    /**
     *
     * Returns the value of the card, with face cards valued at 10 and aces valued at 1 or 11.
     * @return The value of the card
     */
    public int getValue() {
        if (value > 10) {
            return 10;
        } else {
            return value;
        }
    }

    /**
     *
     * Returns whether the card is an ace or not.
     * @return True if the card is an ace, false otherwise
     */
    public boolean isAce() {
        return value == 14;
    }
}
