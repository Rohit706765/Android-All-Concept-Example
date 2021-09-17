package com.example.androidconcept.RoomDataBase.Excersize2;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Book.class},version = 1)
public abstract class MyDataBase extends RoomDatabase {
    public abstract BookDao bookDao();
    public static MyDataBase instance;

    public static synchronized MyDataBase  getInstance(Context context)
    {
        if (instance==null)
        {
            instance = Room.databaseBuilder(context.getApplicationContext(), MyDataBase.class,"BookDataBase").fallbackToDestructiveMigration()
                .build();
        }
        return instance;
    }
}
