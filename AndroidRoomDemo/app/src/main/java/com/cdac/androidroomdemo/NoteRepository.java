package com.cdac.androidroomdemo;

import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

public class NoteRepository {

    private String DB_NAME = "notes";
    private NoteDatabase noteDatabase;
    private LiveData<List<Note>> allNotes;
    https://codelabs.developers.google.com/codelabs/android-room-with-a-view/#15

    public NoteRepository(Context context){
        noteDatabase = Room.databaseBuilder(context,NoteDatabase.class,DB_NAME).build();
        allNotes = noteDatabase.daoAccess().getAllNotes();
    }

    public void insert(final Note note){
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                noteDatabase.daoAccess().insertNote(note);
                return null;
            }
        }.execute();
    }

    public void update(final Note note){
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                noteDatabase.daoAccess().updateNote(note);
                return null;
            }
        }.execute();
    }

    public LiveData<List<Note>> getAllNotes(){
        return noteDatabase.daoAccess().getAllNotes();
    }


}