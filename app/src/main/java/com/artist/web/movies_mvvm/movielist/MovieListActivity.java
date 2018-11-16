package com.artist.web.movies_mvvm.movielist;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.artist.web.movies_mvvm.R;
import com.artist.web.movies_mvvm.model.MovieResult;

import java.util.List;

public class MovieListActivity extends AppCompatActivity {

    private static final String TAG = MovieListActivity.class.getSimpleName();
    private static final String MOVIE_PREFERENCE = "movie_preference";

    RecyclerView mRecyclerView;
    private MovieListViewModel mMovieListViewModel;
    SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        SharedPreferences sharedPref =getSharedPreferences(getString(R.string.preference_file), Context.MODE_PRIVATE);
         mEditor = sharedPref.edit();

         mMovieListViewModel = ViewModelProviders.of(this).get(MovieListViewModel.class);

        mMovieListViewModel.mMovieList.observe(this, new Observer<List<MovieResult>>() {
            @Override
            public void onChanged(@Nullable List<MovieResult> movieResults) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.category_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String preference;
        switch (item.getItemId()){
            case R.id.top_rated:
                preference = "top_rated";
                break;
            case R.id.now_playing:
                preference = "now_playing";
                break;
            case R.id.popular:
                preference ="popular";
                break;
            case R.id.upcoming:
                preference ="upcoming";
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
            mEditor.putString(getString(R.string.preference_key),preference);
            mEditor.apply();
        return true;
    }


}
