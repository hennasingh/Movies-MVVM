package com.artist.web.movies_mvvm;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.artist.web.movies_mvvm.movielist.MovieListViewModel;
import com.artist.web.movies_mvvm.repository.WebRepository;

public class MovieFactoryViewModel implements ViewModelProvider.Factory {

    private WebRepository mWebRepo;

    public MovieFactoryViewModel(WebRepository webRepo) {
        mWebRepo = webRepo;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MovieListViewModel.class)) {
            return (T) new MovieListViewModel(mWebRepo);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
