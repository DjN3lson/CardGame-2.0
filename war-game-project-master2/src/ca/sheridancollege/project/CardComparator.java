package ca.sheridancollege.project;

import java.util.Comparator;

public class CardComparator implements Comparator<Card> {

    @Override
    public int compare(Card card1, Card card2) {
        return card2.getRank().getRankValue() - card1.getRank().getRankValue();
    }
}