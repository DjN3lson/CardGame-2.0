package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private final List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }
    public void shuffle(){
        Collections.shuffle(cards);
    }
    public List<Card> getCards() {
        return cards;
    }
    public void dealCards(List<Card> player1Cards, List<Card> player2Cards) {
    }
}

