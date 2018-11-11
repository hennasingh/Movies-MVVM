package com.artist.web.movies_mvvm.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieApiResponse {

    @SerializedName("page")
    private Integer mPage;

    @SerializedName("total_results")
    private Integer mTotalResults;

    @SerializedName("total_pages")
    private Integer mTotalPages;

    @SerializedName("results")
    private List<MovieResult> mMovieList;

    public Integer getPage() {
        return mPage;
    }

    public void setPage(Integer page) {
        mPage = page;
    }

    public Integer getTotalResults() {
        return mTotalResults;
    }

    public void setTotalResults(Integer totalResults) {
        mTotalResults = totalResults;
    }

    public Integer getTotalPages() {
        return mTotalPages;
    }

    public void setTotalPages(Integer totalPages) {
        mTotalPages = totalPages;
    }

    public List<MovieResult> getMovieList() {
        return mMovieList;
    }

    public void setMovieList(List<MovieResult> movieList) {
        mMovieList = movieList;
    }
}

