package com.artist.web.movies_mvvm.repository;

import android.arch.lifecycle.MutableLiveData;

import com.artist.web.movies_mvvm.database.FavMovie;
import com.artist.web.movies_mvvm.database.MovieDao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FavoriteRepository {

    private static final String TAG = FavoriteRepository.class.getSimpleName();
    private static volatile FavoriteRepository sFavRepo;
    private final MovieDao mMovieDao;
    private ExecutorService mExecutor = Executors.newFixedThreadPool(5);
    private MutableLiveData<Boolean> mIsFav = new MutableLiveData<>();

    private FavoriteRepository(MovieDao movieDao) {
        mMovieDao = movieDao;

    }

    public static FavoriteRepository getInstance(MovieDao movieDao) {
        if (sFavRepo == null) {
            sFavRepo = new FavoriteRepository(movieDao);
        }
        return sFavRepo;
    }

    public void insertMovie(FavMovie favMovie) {

    }


}
