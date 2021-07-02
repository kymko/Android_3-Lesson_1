package com.example.lesson1.ui;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.lesson1.R;

public class MainActivity extends AppCompatActivity {

    private final EmojiCardAdapter adapter = new EmojiCardAdapter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}



//        ДЗ / Дедлайн 2 - Июля (Пятница)

//        1. Добавить случайное распределение карточек

//        2. Исправить отображение одним списком. Сделать в два или три столбца

//        3. Добавить фунцию нахождения совпадения

//        4. (Дополнительно) Добавить удаление карточек если было совпадение
