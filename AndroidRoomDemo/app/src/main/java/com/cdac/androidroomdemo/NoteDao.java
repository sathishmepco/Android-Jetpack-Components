package com.cdac.androidroomdemo;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface NoteDao {

    @Insert
    Long insertNote(Note note);

    @Query("select * from Note order by created_date desc")
    LiveData<List<Note>> getAllNotes();

    @Query("select * from Note where id = :id")
    LiveData<Note> getNote(int id);

    @Update
    void updateNote(Note note);

    @Delete
    void deleteNote(Note note);
}