package com.artist.web.movies_mvvm.movielist;

import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;

import com.artist.web.movies_mvvm.model.MovieResult;
import com.artist.web.movies_mvvm.repository.WebRepository;

import java.util.List;

public class MovieListViewModel extends ViewModel {

    MutableLiveData<String> mMoviePreference = new MutableLiveData<>();
    private WebRepository mWebRepo;

    public MovieListViewModel(WebRepository webRepository) {
        mWebRepo = webRepository;
    }

    public LiveData<List<MovieResult>> getMovieList() {

        return Transformations.switchMap(mMoviePreference,
                new Function<String, LiveData<List<MovieResult>>>() {
                    @Override
                    public LiveData<List<MovieResult>> apply(String input) {
                        return mWebRepo.getMovieList(input);
                    }
                });
    }

    public void setMoviePreference(String preference) {

        mMoviePreference.setValue(preference);
    }
}
