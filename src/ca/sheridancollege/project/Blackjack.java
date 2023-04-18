package ca.sheridancollege.project;

/**
 * This class represents the game of Blackjack and extends the Game abstract class. It contains a deck of cards and an
 * ArrayList of Blackjack players.
 *
 * @author Shamsheer Khan March 2023
 */
import java.util.ArrayList;

public class Blackjack extends Game {

    private GroupOfCards deck;
    ArrayList<BlackjackPlayer> players;

    /**
     * Constructor to initialize the Blackjack game.
     */
    public Blackjack() {
        super("Blackjack");
        deck = new GroupOfCards(52);
        players = new ArrayList<>();
    }

    /**
     * Getter method to return the deck of cards.
     */
    public GroupOfCards getDeck() {
        return deck;
    }

    /**
     * Method to add a player to the list of players.
     */
    public void addPlayer(BlackjackPlayer player) {
        players.add(player);
    }

    /**
     * Method to play the game of Blackjack. It initializes the deck, shuffles it, deals two cards to each player, and
     * allows players to hit or stay.
     */
    @Override
    public void play() {
        // Initialize the deck
        for (int i = 2; i <= 14; i++) {
            deck.getCards().add(new BlackjackCard(i, "Hearts"));
            deck.getCards().add(new BlackjackCard(i, "Diamonds"));
            deck.getCards().add(new BlackjackCard(i, "Clubs"));
            deck.getCards().add(new BlackjackCard(i, "Spades"));
        }

        // Shuffle the deck and deal two cards to each player
        deck.shuffle();
        for (BlackjackPlayer player : players) {
            player.addCard((BlackjackCard) deck.draw());
            player.addCard((BlackjackCard) deck.draw());
        }

        // Players take turns hitting or staying until they bust or decide to stay
        for (BlackjackPlayer player : players) {
            while (player.getScore() < 21 && player.wantToHit()) {
                Card card = deck.draw();
                BlackjackCard blackjackCard = (BlackjackCard) card;
                player.addCard(blackjackCard);
            }
        }
    }

    /**
     * Method to declare the winner of the game of Blackjack. It checks for busts, blackjacks, and compares scores to
     * determine the winner.
     */
    @Override
    public void declareWinner() {
        for (BlackjackPlayer player : players) {
            if (player.getScore() > 21) {
                System.out.println(player.getName() + " busts with a score of " + player.getScore());
            } else if (player.getScore() == 21) {
                System.out.println(player.getName() + " has blackjack!");
            } else {
                int dealerScore = ((BlackjackPlayer) players.get(0)).getScore();
                if (dealerScore > 21 || player.getScore() > dealerScore) {
                    System.out.println(player.getName() + " wins with a score of " + player.getScore());
                } else if (dealerScore == player.getScore()) {
                    System.out.println(player.getName() + " ties with the dealer with a score of " + player.getScore());
                } else {
                    System.out.println(player.getName() + " loses with a score of " + player.getScore());
                }
            }
        }
    }
}
