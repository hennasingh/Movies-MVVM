package com.artist.web.movies_mvvm.favorite;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.artist.web.movies_mvvm.MovieFactoryViewModel;
import com.artist.web.movies_mvvm.R;
import com.artist.web.movies_mvvm.helpers.Utils;

public class FavoriteActivity extends AppCompatActivity {

    private FavMovieViewModel mFavViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

    }
}
