package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * /**
 *
 * The BlackjackPlayer class represents a player in the Blackjack game. It extends the Player class and adds additional
 * methods and properties specific to Blackjack. It maintains the player's hand as an ArrayList of BlackjackCards. It
 * implements the play method, which is currently empty and is expected to be overridden in subclasses
 *
 * @author Shamsheer Khan March 2023
 */
public class BlackjackPlayer extends Player {

    private ArrayList<BlackjackCard> hand;

    /**
     *
     * Constructor for the BlackjackPlayer class. It takes a String name as a parameter and calls the constructor of the
     * superclass to set the name property. It initializes the hand ArrayList.
     * @param name The name of the player.
     */
    public BlackjackPlayer(String name) {
        super(name);
        hand = new ArrayList<>();
    }

    @Override
    public void play() {

    }

    /**
     *
     * Adds a BlackjackCard to the player's hand.
     * @param card The card to be added to the player's hand.
     */
    public void addCard(BlackjackCard card) {
        hand.add(card);
    }

    /**
     *
     * Calculates the value of the player's hand. Aces can be counted as 1 or 11, depending on which value gives the
     * player a better hand.
     * @return The value of the player's hand.
     */
    public int getHandValue() {
        int value = 0;
        int aces = 0;

        for (BlackjackCard card : hand) {
            if (card.isAce()) {
                aces++;
            }
            value += card.getValue();
        }

        while (value > 21 && aces > 0) {
            value -= 10;
            aces--;
        }

        return value;
    }

    /**
     *
     * Returns the score of the player, which is the value of their hand.
     * @return The score of the player.
     */
    public int getScore() {
        return getHandValue();
    }

    /**
     *
     * Determines whether the player wants to hit (take another card) or not. This method is currently empty and is
     * expected to be overridden in subclasses.
     * @return true if the player wants to hit, false otherwise.
     */
    public boolean wantToHit() {
        // Implement logic to determine if player wants to hit
        return false;
    }

    /**
     *
     * Returns the player's hand as an ArrayList of BlackjackCards.
     * @return The player's hand.
     */
    public ArrayList<BlackjackCard> getHand() {
        return hand;
    }
}
