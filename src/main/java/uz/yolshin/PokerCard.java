package uz.yolshin;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class PokerCard implements Comparable<PokerCard>  {

    private static final List<String> suits = List.of("S", "H", "D", "C");
    private static final List<String>  ranks = List.of("2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A");
    private int suit;
    private int rank;

    PokerCard(String card) {
        rank = ranks.indexOf(card.split("")[0].toUpperCase());
        suit = suits.indexOf(card.split("")[1].toUpperCase());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PokerCard pokerCard = (PokerCard) o;
        return suit == pokerCard.suit && rank == pokerCard.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, rank);
    }

    @Override
    public int compareTo(PokerCard o) {
        return o.rank - rank;
    }

    @Override
    public String toString() {
        return ranks.get(rank) + suits.get(suit);
    }

    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }
}
