package com.artist.web.movies_mvvm;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.artist.web.movies_mvvm.favorite.FavMovieViewModel;
import com.artist.web.movies_mvvm.movielist.MovieListViewModel;
import com.artist.web.movies_mvvm.repository.FavoriteRepository;
import com.artist.web.movies_mvvm.repository.WebRepository;

public class MovieFactoryViewModel implements ViewModelProvider.Factory {

    private WebRepository mWebRepo;
    private FavoriteRepository mFavRepo;

    public MovieFactoryViewModel(WebRepository webRepo) {
        mWebRepo = webRepo;
    }

    public MovieFactoryViewModel(FavoriteRepository favRepo) {
        mFavRepo = favRepo;
    }


    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MovieListViewModel.class)) {
            return (T) new MovieListViewModel(mWebRepo);
        } else if (modelClass.isAssignableFrom(FavMovieViewModel.class)) {
            return (T) new FavMovieViewModel(mFavRepo);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
