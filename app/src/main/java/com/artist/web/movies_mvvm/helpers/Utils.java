package com.artist.web.movies_mvvm.helpers;

import android.content.Context;

import com.artist.web.movies_mvvm.BuildConfig;
import com.artist.web.movies_mvvm.MovieFactoryViewModel;
import com.artist.web.movies_mvvm.database.MovieDatabase;
import com.artist.web.movies_mvvm.repository.FavoriteRepository;
import com.artist.web.movies_mvvm.repository.WebRepository;

public class Utils {

    public static final String BASE_URL = "https://api.themoviedb.org/3/";
    public static final String API_KEY = BuildConfig.API_KEY;

    public static MovieFactoryViewModel provideMovieFactory() {
        return new MovieFactoryViewModel(WebRepository.getInstance());
    }

    public static MovieFactoryViewModel provideFavModelFactory(Context context) {
        MovieDatabase movieDatabase = MovieDatabase.getInstance(context);
        return new MovieFactoryViewModel(FavoriteRepository.getInstance(movieDatabase.getMovieDao()));
    }
}
