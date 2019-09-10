package com.rifafauzi.moviecatalogue.helper.local.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.rifafauzi.moviecatalogue.helper.local.entity.MoviesEntity;
import com.rifafauzi.moviecatalogue.helper.local.entity.TvShowEntity;

@Database(entities = {MoviesEntity.class, TvShowEntity.class},
        version = 1,
        exportSchema = false)
public abstract class MoviesDatabase extends RoomDatabase {

    private static final Object sLock = new Object();
    private static MoviesDatabase INSTANCE;

    public static MoviesDatabase getInstance(Context context) {
        synchronized (sLock) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        MoviesDatabase.class, "Movies.db")
                        .build();
            }
            return INSTANCE;
        }
    }

    public abstract MoviesDao moviesDao();

}
