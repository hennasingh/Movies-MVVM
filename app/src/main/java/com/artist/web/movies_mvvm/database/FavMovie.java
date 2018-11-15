package com.artist.web.movies_mvvm.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "movies")
public class FavMovie {

    @ColumnInfo(name = "movie_name")
    private String mMovieName;

    @PrimaryKey
    @NonNull
    private int movie_id;

    private double movie_rating;

    private String movie_plot;

    @Ignore
    private String movie_poster;

    public FavMovie(String mMovieName, @NonNull int movie_id, double movie_rating, String movie_plot) {
        this.mMovieName = mMovieName;
        this.movie_id = movie_id;
        this.movie_rating = movie_rating;
        this.movie_plot = movie_plot;
    }

    public String getmMovieName() {
        return mMovieName;
    }

    public void setmMovieName(String mMovieName) {
        this.mMovieName = mMovieName;
    }

    @NonNull
    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(@NonNull int movie_id) {
        this.movie_id = movie_id;
    }

    public double getMovie_rating() {
        return movie_rating;
    }

    public void setMovie_rating(double movie_rating) {
        this.movie_rating = movie_rating;
    }

    public String getMovie_plot() {
        return movie_plot;
    }

    public void setMovie_plot(String movie_plot) {
        this.movie_plot = movie_plot;
    }
}
