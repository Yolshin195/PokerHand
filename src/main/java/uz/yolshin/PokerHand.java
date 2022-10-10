package uz.yolshin;

import java.util.*;
import java.util.stream.Collectors;

/*
*   ToDo: Реализовать определение комбинации
*   ToDo: Распарсить строку в удобный вид для сортировки
* */
public class PokerHand implements Comparable<PokerHand> {
    private String hand;
    private final List<PokerCard> pokerCardList;
    private HandValues handValues;
    private Map<Integer, Integer> duplicate;

    PokerHand(String hand) {
        this.pokerCardList = Arrays.stream(hand.split(" "))
                .map(PokerCard::new)
                .collect(Collectors.toList());

        System.out.println(pokerCardList);
        Collections.sort(pokerCardList);
        System.out.println(pokerCardList);

        this.hand = hand;
        this.handValues = getHandValues();
    }

    public HandValues getHandValues() {
        boolean flush = isFlush();
        boolean straight = isStraight();

        findDuplicate();

        if (flush && straight) {
            return HandValues.STRAIGHT_FLUSH;
        }

        if (duplicate.values().contains(4)) {
            return HandValues.FOUR_OF_KING;
        }

        if (duplicate.values().contains(3) && duplicate.values().contains(2)) {
            return HandValues.FULL_HOUSE;
        }

        if (flush) {
            System.out.println("Flush");
            return HandValues.FLUSH;
        }

        if (straight) {
            System.out.println("Straight");
            return HandValues.STRAIGHT;
        }

        if (duplicate.values().contains(3)) {
            return HandValues.THREE_OF_KING;
        }

        if (duplicate.values().stream().filter(it -> it == 2).count() == 2) {
            return HandValues.TWO_PAIRS;
        }

        if (duplicate.values().contains(2)) {
            return HandValues.PAIR;
        }

        return HandValues.HIGH_CARD;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PokerHand pokerHand = (PokerHand) o;
        return hand.equals(pokerHand.hand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hand);
    }

    @Override
    public int compareTo(PokerHand o) {
        int rang2 = pokerCardList.stream().mapToInt(PokerCard::getRank).sum();
        int rang3 = o.pokerCardList.stream().mapToInt(PokerCard::getRank).sum();

        int rang = (rang3 + o.handValues.getValue() * 100) - (rang2 + handValues.getValue() * 100);
        return rang;
    }

    @Override
    public String toString() {
        return hand;
    }

    public boolean isFlush() {
        return pokerCardList.stream()
                .skip(1)
                .allMatch(pokerCard -> pokerCard.getSuit() == pokerCardList.get(0).getSuit());
    }

    public boolean isStraight() {
        int firstValue = pokerCardList.get(0).getRank();
        for (int i = 1; i < 5; i++) {
            if (i != (firstValue - pokerCardList.get(i).getRank())) {
                return false;
            }
        }
        return true;
    }

    public void findDuplicate() {
        duplicate = new HashMap<>();
        for (PokerCard card : pokerCardList) {
            if (duplicate.containsKey(card.getRank())) {
                duplicate.put(card.getRank(), duplicate.get(card.getRank()) + 1);
            } else {
                duplicate.put(card.getRank(), 1);
            }
        }
        System.out.println(duplicate);
    }
}
