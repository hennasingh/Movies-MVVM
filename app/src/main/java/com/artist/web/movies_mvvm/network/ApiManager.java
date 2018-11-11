package com.artist.web.movies_mvvm.network;

import com.artist.web.movies_mvvm.model.MovieApiResponse;
import com.artist.web.movies_mvvm.model.MovieDetails;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.artist.web.movies_mvvm.helpers.Utils.BASE_URL;

public class ApiManager {

    private static ApiManager sApiManager;
    private static MoviesApi sMoviesApi;

    private ApiManager(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        sMoviesApi = retrofit.create(MoviesApi.class);
    }

    public static ApiManager getInstance(){
        if(sApiManager==null){
            sApiManager = new ApiManager();
        }
        return sApiManager;
    }

    public void getMoviesList(String preference, String apiKey, Callback<MovieApiResponse> callback){
        Call<MovieApiResponse> moviesCall = sMoviesApi.getMoviesList(preference,apiKey);
        moviesCall.enqueue(callback);
    }

    public void getMovieDetails(int id, String apiKey, String appendValues, Callback<MovieDetails> callback){
        Call<MovieDetails> detailsCall = sMoviesApi.getMovieDetails(id,apiKey,appendValues);
        detailsCall.enqueue(callback);
    }
}
