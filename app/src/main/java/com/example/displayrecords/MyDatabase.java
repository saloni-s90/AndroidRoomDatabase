package com.example.displayrecords;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {UserModel.class, InfoModel.class}, version = 1)

public abstract class MyDatabase extends RoomDatabase {

    public abstract AllDao getMyDao();

    public static MyDatabase myDatabase;

    public static MyDatabase getMyDatabase(Context context)
    {
        if(myDatabase == null){
            myDatabase = Room.databaseBuilder(context,MyDatabase.class,"myDataBase")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return myDatabase;
    }
}
