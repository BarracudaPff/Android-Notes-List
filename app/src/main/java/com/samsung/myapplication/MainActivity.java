package com.samsung.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.samsung.myapplication.models.Note;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Note> notes = new ArrayList<>();
        notes.add(new Note(
                "Новая записка",
                "djahs dhas jhda js",
                new Date(),
                false
        ));
        notes.add(new Note(
                "Еще одна",
                "djahs dhas jhda js",
                new Date(),
                false
        ));
        notes.add(new Note(
                "Интересная",
                new Date(),
                true
        ));
        notes.add(new Note(
                "Интересная",
                new Date(),
                true
        ));
        notes.add(new Note(
                "Интересная",
                new Date(),
                true
        ));
        notes.add(new Note(
                "Вот эта очень интересная",
                "djahs dhas jhda js фшоырвш фпыв фдыжв фы фы фывфывфы",
                new Date(),
                false
        ));

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        NoteAdapter noteAdapter = new NoteAdapter(notes);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setAdapter(noteAdapter);
        recyclerView.setLayoutManager(layoutManager);

        FloatingActionButton button = findViewById(R.id.floatingActionButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Note note = new Note(
                        UUID.randomUUID().toString(),
                        UUID.randomUUID().toString(),
                        new Date(),
                        new Random().nextInt() > 0
                );
                notes.add(note);
                noteAdapter.notifyDataSetChanged();
                recyclerView.smoothScrollToPosition(notes.size());
            }
        });
    }
}