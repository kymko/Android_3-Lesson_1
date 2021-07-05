package com.example.lesson1.ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lesson1.R;
import com.example.lesson1.data.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static java.lang.Math.random;

public class EmojiCardAdapter extends RecyclerView.Adapter<EmojiCardAdapter.EmojiCardVH> {

    private final EmodjiGame game = new EmodjiGame();


    @NonNull
    @Override
    public EmojiCardVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new EmojiCardVH(view, game);
    }

    @Override
    public void onBindViewHolder(@NonNull EmojiCardVH holder, int position) {

        holder.onBind(game.getCards().get(position));
    }

    @Override
    public int getItemCount() {
        return game.getCards().size();
    }

    public class EmojiCardVH extends RecyclerView.ViewHolder {

        private TextView tvCard;
        private EmodjiGame game;

        public EmojiCardVH(@NonNull View itemView, EmodjiGame game) {
            super(itemView);
            this.game = game;
            tvCard = itemView.findViewById(R.id.itemCard);
        }

        public void onBind(Card<String> card) {
            if (card.isFaceUp()) {
                tvCard.setText(card.getContent());
                tvCard.setBackgroundColor(Color.WHITE);
            } else {
                tvCard.setText("");
                tvCard.setBackgroundColor(Color.BLACK);
            }
            if (card.isMatch()){
                tvCard.setBackgroundColor(Color.BLUE);

            }
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    game.choose(card);
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
