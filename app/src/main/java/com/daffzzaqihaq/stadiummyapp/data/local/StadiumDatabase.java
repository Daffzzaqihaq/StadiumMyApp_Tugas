package com.daffzzaqihaq.stadiummyapp.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.daffzzaqihaq.stadiummyapp.model.StadiumItems;

@Database(entities = StadiumItems.class, version = 1)
public abstract class StadiumDatabase extends RoomDatabase {

    public abstract StadiumDAO stadiumDAO();

    private static StadiumDatabase stadiumDatabase;

    public static StadiumDatabase getStadiumDatabase(Context context) {
        synchronized (StadiumDatabase.class){
            if (stadiumDatabase == null){
                stadiumDatabase = Room.databaseBuilder(context, StadiumDatabase.class, "db_stadium").allowMainThreadQueries().build();

            }
        }return stadiumDatabase;

    }
}

