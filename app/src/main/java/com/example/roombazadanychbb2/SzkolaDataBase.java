package com.example.roombazadanychbb2;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Nauczyciel.class}, version = 1)
public abstract class SzkolaDataBase extends RoomDatabase {
    public abstract NauczycielDAO getNauczycielDao();
}
