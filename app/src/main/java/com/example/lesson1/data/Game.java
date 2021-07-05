package com.example.lesson1.data;

import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.example.lesson1.ui.EmodjiGame;
import com.example.lesson1.ui.EmojiCardAdapter;
import com.example.lesson1.ui.MainActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game<CardContent> {

    private final List<Card<CardContent>> cards = new ArrayList<>();

    public Game(List<CardContent> contents) {

        for (int i = 0; i < contents.size(); i++) { // Apple, Orange, Pineapple

            cards.add(new Card<>(i + 1, false, false, contents.get(i)));
            cards.add(new Card<>((i + 1) * 2, false, false, contents.get(i)));
        }
        Collections.shuffle(cards);
    }

    public void choose(Card<CardContent> card) {
        card.setFaceUp(!card.isFaceUp());
        findPairs(card);

    }

    private void findPairs(Card<CardContent> card) {
        for (Card<CardContent> searchCard : cards) {

            if (searchCard.isFaceUp()
                    && searchCard.getId() != card.getId()
                    && searchCard.getContent().equals(card.getContent())) {

                Log.e("tag", "match");
                card.setFaceUp(true);
                card.setMatch(true);

               // removeCards();

            }
        }
    }

    private void removeCards() {
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).isFaceUp() && cards.get(i).isMatch()) {
                cards.remove(i);
            }
        }
    }

    public List<Card<CardContent>> getCards() {
        return cards;
    }

}
