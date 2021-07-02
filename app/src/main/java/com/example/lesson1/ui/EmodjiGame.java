package com.example.lesson1.ui;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.lesson1.data.Card;
import com.example.lesson1.data.Game;

import java.util.List;

public class EmodjiGame {

    private final Game<String> game;

    public EmodjiGame() {

        List<String> contents = List.of("\uD83D\uDE09", "\uD83D\uDE03", "\uD83D\uDE4A", "\uD83D\uDE02");
        game = new Game<>(contents);


    }
    public void choose(Card<String> card){
        game.choose(card);

    }
    public List<Card<String>> getCards(){
        return game.getCards();
    }

    public Game<String> getGame() {
        return game;
    }
}
