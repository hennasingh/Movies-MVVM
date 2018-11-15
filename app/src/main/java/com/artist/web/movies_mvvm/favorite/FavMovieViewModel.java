package com.artist.web.movies_mvvm.favorite;

import android.arch.lifecycle.ViewModel;

import com.artist.web.movies_mvvm.repository.FavoriteRepository;

public class FavMovieViewModel extends ViewModel {

    private FavoriteRepository mFavRepo;

    public FavMovieViewModel(FavoriteRepository favRepo) {
        mFavRepo = favRepo;
    }
}
