/* =============================================================

Author : Nikell Reed
Class : ITN262
Class Section : 4C1
Date : 3/21/2022
Assignment : Card Game

================================================================*/

package com.example.warcardgame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.Collections;

public class WarGameController {

    // Setting up all the stacks with linked nodes:
    private java.util.Stack<Integer> originalDeck = new java.util.Stack<>();
    private LinkedNode p1won = new LinkedNode();
    private LinkedNode p2won = new LinkedNode();
    private LinkedNode p1cards = new LinkedNode();
    private LinkedNode p2cards = new LinkedNode();
    private LinkedNode p1wonCards = new LinkedNode();
    private LinkedNode p2wonCards = new LinkedNode();

    @FXML
    private Button button;

    @FXML
    private AnchorPane deck;

    @FXML
    private ImageView p1imageView;

    @FXML
    private ImageView p2imageView;

    @FXML
    private Text playerOneWins;

    @FXML
    private Text playerTwoWins;

    @FXML
    private Text whoWon;

    @FXML
    private Text winNums;


    // highest to lowest: spades, hearts, diamonds, clubs
    private String[] cardFileNames = {
            "2_of_clubs.png",
            "2_of_diamonds.png",
            "2_of_hearts.png",
            "2_of_spades.png",
            "3_of_clubs.png",
            "3_of_diamonds.png",
            "3_of_hearts.png",
            "3_of_spades.png",
            "4_of_clubs.png",
            "4_of_diamonds.png",
            "4_of_hearts.png",
            "4_of_spades.png",
            "5_of_clubs.png",
            "5_of_diamonds.png",
            "5_of_hearts.png",
            "5_of_spades.png",
            "6_of_clubs.png",
            "6_of_diamonds.png",
            "6_of_hearts.png",
            "6_of_spades.png",
            "7_of_clubs.png",
            "7_of_diamonds.png",
            "7_of_hearts.png",
            "7_of_spades.png",
            "8_of_clubs.png",
            "8_of_diamonds.png",
            "8_of_hearts.png",
            "8_of_spades.png",
            "9_of_clubs.png",
            "9_of_diamonds.png",
            "9_of_hearts.png",
            "9_of_spades.png",
            "10_of_clubs.png",
            "10_of_diamonds.png",
            "10_of_hearts.png",
            "10_of_spades.png",
            "ace_of_clubs.png",
            "ace_of_diamonds.png",
            "ace_of_hearts.png",
            "ace_of_spades.png",
            "jack_of_clubs.png",
            "jack_of_diamonds.png",
            "jack_of_hearts.png",
            "jack_of_spades.png",
            "king_of_clubs.png",
            "king_of_diamonds.png",
            "king_of_hearts.png",
            "king_of_spades.png",
            "queen_of_clubs.png",
            "queen_of_diamonds.png",
            "queen_of_hearts.png",
            "queen_of_spades.png",
            "red_joker.png",
    };

    @FXML
    public void initialize() {
        // fill the original deck with integers 0 - 51
        // give out those cards to p1 and p2 cards randomly (26 each)

        fillOriginalDeck();
        dealCards();
        playGame();

    }

    void viewCard(int cardNum, int playerID) {

        String cardPathRoot = "images/cardImages/";
        URL path = getClass().getResource(cardPathRoot+cardFileNames[cardNum]);
        Image cardImage = new Image(path.toExternalForm());

        ImageView cardImageView;
        if (playerID == 0) {
            // player 1
            cardImageView = p1imageView;

        } else {
            // player 2
            cardImageView = p2imageView;

        }
        cardImageView.setImage(cardImage);
    }

    void fillOriginalDeck() {
        // Filling the deck
        for (int i = 0; i < 50; i++) {
            originalDeck.push(i);
        }
        Collections.shuffle(originalDeck);
    }

    void dealCards() {
        // Dealing the cards

        while(!originalDeck.isEmpty()) {
            p1cards.push(originalDeck.pop());
            p2cards.push(originalDeck.pop());
        }
    }

    void checkPlayerCards() {
        int p1Wins = 0; // Counting P1 wins
        int p2Wins = 0; // Counting P2 wins
        if (p1cards.peek() > p2cards.peek()) {
            p1Wins++; // Adding to the counter
            p1won.push(p1Wins); // Pushing the counter to the win stack
            p1wonCards.push(p1cards.peek());
        }

        if (p2cards.peek() > p1cards.peek()) {
            p2Wins++;
            p2won.push(p2Wins);
            p2wonCards.push(p2cards.peek());
        }

        // Setting the text depending on who wins:
        playerOneWins.setText(String.valueOf(p1won.length()));
        playerTwoWins.setText(String.valueOf(p2won.length()));

        // Once a player reaches 26 wins text will pop up on the GUI stating that said player won:
        if (p1won.length() == 26) {
            button.setDisable(true);
            whoWon.setText("Player 1 Has Won The Game With 26 Cards!");
            winNums.setText(p1wonCards.toString());

        }
        else if (p2won.length() == 26) {
            button.setDisable(true);
            whoWon.setText("Player 2 Has Won The Game With 26 Cards!");
            winNums.setText(p2wonCards.toString());
        }

        // Viewing the cards:
        viewCard(p1cards.peek(), 0);
        viewCard(p2cards.peek(), 1);
    }

    public void playGame() {
        checkPlayerCards();

        // during each round, compare the top card on each player's stack
        // whoever has the higher number wins that round
        // the winner places both cards of that round into their "won" stack
    }


    @FXML
    void buttonPressed(ActionEvent event) {
        initialize(); // A new round will play when button is pressed
    }

}
