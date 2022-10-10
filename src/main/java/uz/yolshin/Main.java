package uz.yolshin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<PokerHand> pokerHandList = new ArrayList<>();
        pokerHandList.add(new PokerHand("KS KH 5C JD TD"));
        pokerHandList.add(new PokerHand("KD QD 5D JD TD"));
        pokerHandList.add(new PokerHand("KD QD 9D JD TD"));
        pokerHandList.add(new PokerHand("KD KS KC JD TD"));
        pokerHandList.add(new PokerHand("KD KS TC JD TD"));

        Collections.sort(pokerHandList);

        System.out.println(pokerHandList);

//        ArrayList<PokerHand> hands = new ArrayList<PokerHand>();
//        hands.add(new PokerHand("KS 2H 5C JD TD"));
//        hands.add(new PokerHand("2C 3C AC 4C 5C"));
//
//        System.out.println(hands);
//        Collections.sort(hands);
//        System.out.println(hands);
    }
}