package com.artist.web.movies_mvvm.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface MovieDao {

    @Insert
    void insertMovie(FavMovie favMovie);

    @Query("SELECT * FROM movies")
    LiveData<List<FavMovie>> getAllMovies();

    @Delete
    void deleteAll(FavMovie... favMovies);

    @Query("DELETE FROM movies WHERE movie_id =:movie_id")
    void deleteMovie(int movie_id);

    @Query("SELECT movie_id FROM movies WHERE movie_id=:movie_id")
    int getBook(int movie_id);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateMovie(FavMovie movie);

}
