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

public class MovieListViewModel extends ViewModel {

    MutableLiveData<String> mMoviePreference = new MutableLiveData<>();


    public MovieListViewModel(String preference) {
        mMoviePreference.setValue(preference);

    }
    public LiveData<List<MovieResult>> mMovieList = Transformations.switchMap(mMoviePreference,
            new Function<String, LiveData<List<MovieResult>>>() {
                @Override
                public LiveData<List<MovieResult>> apply(String input) {
                    return WebRepository.getInstance().getMovieList(input);
                }
            });

    public void setmMoviePreference(String preference){
        mMoviePreference.setValue(preference);
    }

}
