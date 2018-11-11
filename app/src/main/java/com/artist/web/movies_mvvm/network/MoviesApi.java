package com.artist.web.movies_mvvm.network;

import com.artist.web.movies_mvvm.model.MovieApiResponse;
import com.artist.web.movies_mvvm.model.MovieDetails;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MoviesApi {

    @GET("movie/{preference}")
    Call<MovieApiResponse> getMoviesList(@Path("preference") String preference,
                                     @Query("api_key") String apiKey);


    @GET("movie/{id}")
    Call<MovieDetails> getMovieDetails(@Path("id") int id,
                                       @Query("api_key") String apiKey,
                                       @Query("append_to_response") String appendValues);
}
