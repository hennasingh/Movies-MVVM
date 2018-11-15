package com.artist.web.movies_mvvm.repository;

import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;

import com.artist.web.movies_mvvm.database.FavMovie;
import com.artist.web.movies_mvvm.database.MovieDao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FavoriteRepository {

    private static final String TAG = FavoriteRepository.class.getSimpleName();
    private static volatile FavoriteRepository sFavRepo;
    private final MovieDao mMovieDao;
    private ExecutorService mExecutor = Executors.newFixedThreadPool(5);

    private MutableLiveData<Integer> mMovieId = new MutableLiveData<>();

    public LiveData<Boolean> mIsFav = Transformations.map(mMovieId, new Function<Integer, Boolean>() {
        @Override
        public Boolean apply(Integer input) {
            int i = mMovieDao.getBook(input);
            if (i > 0) {
                return true;
            } else {
                return false;
            }
        }
    });

    private FavoriteRepository(MovieDao movieDao) {
        mMovieDao = movieDao;
    }

    public void setMovieId(int movieId) {
        mMovieId.setValue(movieId);
    }

    public static FavoriteRepository getInstance(MovieDao movieDao) {
        if (sFavRepo == null) {
            sFavRepo = new FavoriteRepository(movieDao);
        }
        return sFavRepo;
    }

    public void insertMovie(final FavMovie favMovie) {

        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mMovieDao.insertMovie(favMovie);
            }
        });
    }

    public void deleteMovie(final int movieId) {
        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mMovieDao.deleteMovie(movieId);
            }
        });
    }

}
