package com.cdac.androidroomdemo;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static int CREATE_NEW_NOTE_CODE = 1;
    private NoteAdapter noteAdapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getAllNotes();
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insert();
            }
        });
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        noteAdapter = new NoteAdapter();
        recyclerView.setAdapter(noteAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        NoteViewModel viewModel = ViewModelProviders.of(this).get(NoteViewModel.class);
        viewModel.getAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                noteAdapter.setNotes(notes);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void insert(){
        NoteRepository noteRepository = new NoteRepository(getApplicationContext());
        String title = "Movie List";
        String description = "Lot movies to watch";
        Note note = new Note();
        note.setTitle(title);
        note.setDescription(description);
        note.setCreatedDate(new Date(System.currentTimeMillis()));
        note.setModifiedDate(new Date(System.currentTimeMillis()));
        noteRepository.insert(note);
    }

    private void getAllNotes(){
        NoteRepository noteRepository = new NoteRepository(getApplicationContext());
        noteRepository.getAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(@Nullable List<Note> notes) {
                for(Note note : notes) {
                    System.out.println("-----------------------");
                    System.out.println(note.getId());
                    System.out.println(note.getTitle());
                    System.out.println(note.getDescription());
                    System.out.println(note.getCreatedDate());
                    System.out.println(note.getModifiedDate());
                }
            }
        });
    }
}