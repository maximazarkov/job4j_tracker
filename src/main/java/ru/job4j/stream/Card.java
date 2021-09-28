package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {
        Suit[] suits = Suit.values();
        Value[] values = Value.values();

        for (Suit suit : suits) {
            for (Value value : values) {
                List<Card> cards = new ArrayList<>();
                cards.add(new Card(suit, value));
            }
        }

        List<Card> cards = Stream.of(Suit.values())
                .flatMap(s -> Stream.of(Value.values())
                        .map(v -> new Card(s, v)))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return suit + "-" + value;
    }
}
