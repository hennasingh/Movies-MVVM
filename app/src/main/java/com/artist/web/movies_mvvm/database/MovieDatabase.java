package com.artist.web.movies_mvvm.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {FavMovie.class}, version = 1, exportSchema = false)
public abstract class MovieDatabase extends RoomDatabase {

    private static final Object LOCK = new Object();
    private static final String MOVIE_DB = "movies.db";
    private static MovieDatabase sMovieDatabase;

    public static MovieDatabase getInstance(Context context) {
        if (sMovieDatabase == null) {
            synchronized (LOCK) {
                sMovieDatabase = create(context);
            }
        }
        return sMovieDatabase;
    }

    private static MovieDatabase create(Context context) {
        RoomDatabase.Builder<MovieDatabase> databaseBuilder = Room.databaseBuilder(
                context.getApplicationContext(), MovieDatabase.class, MOVIE_DB);


        return databaseBuilder.fallbackToDestructiveMigration().build();
    }

    public abstract MovieDao getMovieDao();
}
