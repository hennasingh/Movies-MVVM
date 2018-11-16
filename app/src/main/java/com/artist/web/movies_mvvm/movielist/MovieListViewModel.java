package com.artist.web.movies_mvvm.movielist;

import android.app.Application;
import android.arch.core.util.Function;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.artist.web.movies_mvvm.model.MovieResult;
import com.artist.web.movies_mvvm.repository.WebRepository;

import java.util.List;

public class MovieListViewModel extends AndroidViewModel {

    private WebRepository mWebRepo;

    public LiveData<List<MovieResult>> mMovieList = Transformations.switchMap(mWebRepo.getMoviePreference(),
            new Function<String, LiveData<List<MovieResult>>>() {
                @Override
                public LiveData<List<MovieResult>> apply(String input) {
                    return mWebRepo.getMovieList(input);
                }
            });

    public MovieListViewModel(@NonNull Application application) {
        super(application);
        mWebRepo = WebRepository.getInstance(application.getApplicationContext());
    }


}
