package com.cdac.androidroomdemo;

import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;

public class NoteRepository {

    private NoteDao noteDao;
    private NoteDatabase noteDatabase;
    private LiveData<List<Note>> allNotes;

    public NoteRepository(Context context){
        noteDatabase = NoteDatabase.getInstance(context);
        noteDao = noteDatabase.daoAccess();
        allNotes = noteDatabase.daoAccess().getAllNotes();
    }

    public void insert(final Note note){
        new InsertAsyncTask(noteDao).execute(note);
    }

    public void update(final Note note){
        new UpdateAsyncTask(noteDao).execute(note);
    }

    public LiveData<List<Note>> getAllNotes(){
        return noteDatabase.daoAccess().getAllNotes();
    }


    private static class InsertAsyncTask extends AsyncTask<Note,Void,Void>{
        NoteDao noteDao;
        public InsertAsyncTask(NoteDao noteDao){
            this.noteDao = noteDao;
        }
        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.insertNote(notes[0]);
            return null;
        }
    }

    private static class UpdateAsyncTask extends AsyncTask<Note,Void,Void>{

        NoteDao noteDao;
        public UpdateAsyncTask(NoteDao noteDao){
            this.noteDao = noteDao;
        }
        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.updateNote(notes[0]);
            return null;
        }
    }
}