package uz.yolshin;

public enum HandValues {
    HIGH_CARD(1),
    PAIR(2),
    TWO_PAIRS(3),
    THREE_OF_KING(4),
    STRAIGHT(5),
    FLUSH(6),
    FULL_HOUSE(7),
    FOUR_OF_KING(8),
    STRAIGHT_FLUSH(9);

    private final Integer value;

    HandValues(Integer value) {
        this.value = value;
    }

    Integer getValue() {
        return value;
    }
}
