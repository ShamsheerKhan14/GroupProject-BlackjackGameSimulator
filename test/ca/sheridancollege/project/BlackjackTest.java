/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.HashSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * BlackjackTest class to text the BlackJack class and the methods used in it
 * @author Shamsheer Khan
 */
public class BlackjackTest {

    public BlackjackTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        //this will ren before all tests
        System.out.println("Beginning of Unit test\n");
    }

    @AfterClass
    public static void tearDownClass() {
        //this will run after all tests
        System.out.println("\nUnit test completed");
    }

    @Before
    public void setUp() {
        //before each test
        System.out.println("\nUnit test completed");
    }

    @After
    public void tearDown() {
        //after each test
        System.out.println("Hey");
    }

    
    /*This is a test method annotated with @Test. It creates a new Blackjack object and a BlackjackPlayer object and adds 
    the player to the game. It then calls the play() method on the game object. The test then verifies that each 
    player has exactly two cards, the deck has 52 cards after dealing, and all cards in each player's hand are unique. */
    @Test
    public void testPlay() {
        Blackjack game = new Blackjack();
        BlackjackPlayer player1 = new BlackjackPlayer("Player 1");
        game.addPlayer(player1); // add player to game
        game.play();

        // Verify that each player has exactly two cards
        for (BlackjackPlayer player : game.players) {
            assertEquals(2, player.getHand());
        }

        // Verify that the deck has 52 cards after dealing
        assertEquals(52, game.getDeck().getCards().size());

        // Verify that all cards in each player's hand are unique
        for (BlackjackPlayer player : game.players) {
            ArrayList<BlackjackCard> hand = player.getHand();
            HashSet<Card> uniqueCards = new HashSet<>(hand);
            assertEquals(hand.size(), uniqueCards.size());
        }

    }

    /*This is a test method annotated with @Test. It creates a new Blackjack object and two BlackjackPlayer objects and
    adds them to the game. It then adds two cards to each player's hand and calls the declareWinner() method on the game 
    object. The test is checking that the game declares the winner correctly. */
    @Test
    public void testDeclareWinner() {
        Blackjack game = new Blackjack();
        BlackjackPlayer player1 = new BlackjackPlayer("Player 1");
        BlackjackPlayer player2 = new BlackjackPlayer("Player 2");
        game.addPlayer(player1);
        game.addPlayer(player2);
        player1.addCard(new BlackjackCard(10, "Hearts"));
        player1.addCard(new BlackjackCard(10, "Diamonds"));
        player2.addCard(new BlackjackCard(9, "Clubs"));
        player2.addCard(new BlackjackCard(8, "Spades"));
        game.declareWinner();

    }

}
