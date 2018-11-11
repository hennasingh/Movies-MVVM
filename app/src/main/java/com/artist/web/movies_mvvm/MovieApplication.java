package com.artist.web.movies_mvvm;

import android.app.Application;

import com.artist.web.movies_mvvm.network.ApiManager;

public class MovieApplication extends Application {

    public static ApiManager sApiManager;

    public void onCreate() {
        super.onCreate();
        sApiManager = ApiManager.getInstance();
    }


}
