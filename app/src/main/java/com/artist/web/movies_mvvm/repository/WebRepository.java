package com.artist.web.movies_mvvm.repository;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.artist.web.movies_mvvm.MovieApplication;
import com.artist.web.movies_mvvm.helpers.ResultDisplay;
import com.artist.web.movies_mvvm.helpers.Utils;
import com.artist.web.movies_mvvm.model.MovieApiResponse;
import com.artist.web.movies_mvvm.model.MovieResult;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WebRepository {

    private static volatile WebRepository sWebRepository;
    private static final String TAG = WebRepository.class.getSimpleName();

    private MutableLiveData<ResultDisplay<List<MovieResult>>> mListLiveData = new MutableLiveData<>();
    private WebRepository(){

    }

    public WebRepository getInstance(){
        if(sWebRepository == null){
            sWebRepository = new WebRepository();
        }
        return sWebRepository;
    }

    public void getMovieList(String preference){

        mListLiveData.postValue(ResultDisplay.loading(Collections.<MovieResult>emptyList()));
        MovieApplication.sApiManager.getMoviesList(preference, Utils.API_KEY, new Callback<MovieApiResponse>() {
            @Override
            public void onResponse(Call<MovieApiResponse> call, Response<MovieApiResponse> response) {
                if(response.isSuccessful()){
                    mListLiveData.postValue(ResultDisplay.success(response.body().getMovieList()));
                }else{
                    mListLiveData.postValue(ResultDisplay.error(response.message(),Collections.<MovieResult>emptyList()));
                    Log.d(TAG, "Error getting successful result");
                }
            }

            @Override
            public void onFailure(Call<MovieApiResponse> call, Throwable t) {
                mListLiveData.setValue(ResultDisplay.error(t.getMessage(),Collections.<MovieResult>emptyList()));
                Log.d(TAG, "Failure getting http response");
            }
        });
    }

    public MutableLiveData<ResultDisplay<List<MovieResult>>> getMovieData(){
        return mListLiveData;
    }

}
