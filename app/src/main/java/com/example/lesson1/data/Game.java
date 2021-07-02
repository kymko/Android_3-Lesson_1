package com.example.lesson1.data;

import java.util.ArrayList;
import java.util.List;

public class Game<CardContent> {

    private final List<Card<CardContent>> cards = new ArrayList<>();

    public Game(List<CardContent> contents) {

        for (int i = 0; i < contents.size(); i++) { // Apple, Orange, Pineapple

            cards.add(new Card<>(i + 1, false, false, contents.get(i)));
            cards.add(new Card<>((i + 1) * 2, false, false, contents.get(i)));
        }
    }

    public void choose(Card<CardContent> card) {
        card.setFaceUp(!card.isFaceUp());

    }

    public List<Card<CardContent>> getCards() {
        return cards;
    }

}
