package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WarGame {
    private static void displayGameRules() {
            System.out.println("Game Rules:");
            System.out.println("- The deck is shuffled and divided evenly between two players.");
            System.out.println("- Each player draws a card from the top of their deck.");
            System.out.println("- The player with the higher card value wins the round and takes both cards.");
            System.out.println("- In case of a tie, each player draws three more cards and the fourth card is compared.");
            System.out.println("- The game continues until one player has all the cards and is declared the winner.");
        }

    public static void main(String[] args) {

        displayGameRules();

        Scanner input = new Scanner(System.in);
        
        do {
            System.out.println("Enter the number of matches you want to play:");
            int numMatches = Integer.parseInt(input.nextLine());

            System.out.println("How many continues ties do want to be allowed before going to the next match?");
            int maxTies = input.nextInt();
            input.nextLine();
            for (int j = 0; j < numMatches; j++) {
                Deck deck = new Deck();

            // shuffle the deck before dealing the cards
            deck.shuffle();

            List<Card> player1Cards = new ArrayList<>();
            List<Card> player2Cards = new ArrayList<>();

            // deal the cards to players
            deck.dealCards(player1Cards, player2Cards);

            // create the players
            Player player1 = new Player("Player 1", player1Cards);
            Player player2 = new Player("Player 2", player2Cards);

            // play the game
            int round = 1;
            int numTies = 0;

            while (!player1.getCards().isEmpty() && !player2.getCards().isEmpty()) {
                System.out.println("Match: " + (j + 1));
                System.out.println("\nRound " + round + ":");
                System.out.println(player1);
                System.out.println(player2);

                int result = player1.playCard().compareTo(player2.playCard());

                if (result > 0) {
                    player1.win();
                    player2.lose();
                    System.out.println("Player 1 wins the round.");
                    numTies=0;
                } else if (result < 0) {
                    player2.win();
                    player1.lose();
                    System.out.println("Player 2 wins the round.");
                    numTies=0;
                } else {
                    System.out.println("It's a tie!");
                    numTies++;
                }

                round++;
                input.nextLine();
                if (numTies >= maxTies){
                    System.out.println("There were a lot of continuous Ties. \nGoing to next Game.");
                    break;
                }
            }

            if (player1.getCards().isEmpty()) {
                System.out.println("Player 2 wins the game!");
            } else {
                System.out.println("Player 1 wins the game!");
            }
        }
        
            
            System.out.println("Do you want to play again? (Y/N)");
        } while (input.nextLine().equalsIgnoreCase("Y"));

        input.close();
    
    }
}