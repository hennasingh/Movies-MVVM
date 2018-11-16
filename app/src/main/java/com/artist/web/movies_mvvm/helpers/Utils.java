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

}
