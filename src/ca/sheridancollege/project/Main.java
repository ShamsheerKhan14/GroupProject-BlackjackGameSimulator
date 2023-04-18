package ca.sheridancollege.project;

/**
 * This class represents the main entry point for the program and contains the main method. It creates a new Blackjack
 * game object and a new BlackjackPlayer object named "Player 1". It then adds "Player 1" to the game and calls the play
 * method to start the game. After the game is over, it calls the declareWinner method to determine the winner of the
 * game.
 *
 * @author Shamsheer Khan March 2023
 */
public class Main {

    public static void main(String[] args) {
        Blackjack game = new Blackjack();
        BlackjackPlayer player1 = new BlackjackPlayer("Player 1");
        game.players.add(player1); // add player to game
        game.play();
        game.declareWinner();
    }
}
