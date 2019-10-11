package com.cdac.androidroomdemo;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {Note.class}, version = 1, exportSchema = false)
@TypeConverters({TimestampConverter.class})
public abstract class NoteDatabase extends RoomDatabase {
    public abstract NoteDao daoAccess();

    private static volatile NoteDatabase INSTANCE;
    private static final String DB_NAME = "notes";

    static NoteDatabase getInstance(Context context){
        if(INSTANCE == null){
            synchronized (NoteDatabase.class){
                INSTANCE = Room.databaseBuilder(context,NoteDatabase.class,DB_NAME).build();
            }
        }
        return INSTANCE;
    }
}