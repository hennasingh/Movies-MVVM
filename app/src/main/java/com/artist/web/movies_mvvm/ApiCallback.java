package com.artist.web.movies_mvvm;

public interface ApiCallback {

    int LOADING = 0, ERROR =1;

   void setError(String msg, int code);
   void setState(int state);
}
