package com.cdac.androidroomdemo;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class NoteViewModel extends AndroidViewModel {

    private NoteRepository noteRepository;
    private LiveData<List<Note>> allNotes;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        noteRepository = new NoteRepository(application.getApplicationContext());
        allNotes = noteRepository.getAllNotes();
    }

    public LiveData<List<Note>> getAllNotes(){
        return allNotes;
    }

    public void insert(Note note){
        noteRepository.insert(note);
    }
}