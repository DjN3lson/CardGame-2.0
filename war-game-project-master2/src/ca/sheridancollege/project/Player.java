package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {

    private final String name;
    private final List<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public int getNumCards() {
        return hand.size();
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public abstract Card playCard();

    public abstract void win();

    public abstract void lose();

    public abstract int compareHands(Player otherPlayer);

    public String getCards() {
        return null;
    }

}