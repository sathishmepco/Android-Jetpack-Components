package com.cdac.androidroomdemo;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {Note.class}, version = 1, exportSchema = false)
@TypeConverters({TimestampConverter.class})
public abstract class NoteDatabase extends RoomDatabase {
    public abstract NoteDao daoAccess();
}