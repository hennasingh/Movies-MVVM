package com.artist.web.movies_mvvm.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.artist.web.movies_mvvm.MovieApplication;
import com.artist.web.movies_mvvm.helpers.Utils;
import com.artist.web.movies_mvvm.model.MovieApiResponse;
import com.artist.web.movies_mvvm.model.MovieResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WebRepository {

    private static volatile WebRepository sWebRepository;
    private static final String TAG = WebRepository.class.getSimpleName();

    private MutableLiveData<List<MovieResult>> mListLiveData = new MutableLiveData<>();
    private WebRepository(){

    }

    public static WebRepository getInstance() {
    if(sWebRepository == null){
            sWebRepository = new WebRepository();
        }
        return sWebRepository;
    }

    public LiveData<List<MovieResult>> getMovieList(String preference) {

        MovieApplication.sApiManager.getMoviesList(preference, Utils.API_KEY, new Callback<MovieApiResponse>() {
            @Override
            public void onResponse(Call<MovieApiResponse> call, Response<MovieApiResponse> response) {
                if(response.isSuccessful()){
                    mListLiveData.postValue(response.body().getMovieList());
                }else{
                    Log.d(TAG, "Error getting successful result");
                }
            }

            @Override
            public void onFailure(Call<MovieApiResponse> call, Throwable t) {

                Log.d(TAG, "Failure getting http response");
                mListLiveData.postValue(null);

            }
        });
        return mListLiveData;
    }

}
