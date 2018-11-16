package com.artist.web.movies_mvvm.movielist;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.artist.web.movies_mvvm.MovieFactoryViewModel;
import com.artist.web.movies_mvvm.R;
import com.artist.web.movies_mvvm.model.MovieResult;

import java.util.List;

public class MovieListActivity extends AppCompatActivity {

    private static final String TAG = MovieListActivity.class.getSimpleName();
    private static final String DEFAULT_PREFERENCE = "top_rated";

    MovieAdapter movieAdapter;
    RecyclerView mRecyclerView;
    private MovieListViewModel mMovieListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        mRecyclerView = findViewById(R.id.rv_movies);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        movieAdapter = new MovieAdapter();
        mRecyclerView.setAdapter(movieAdapter);

        MovieFactoryViewModel movieFactory = new MovieFactoryViewModel(DEFAULT_PREFERENCE);

       mMovieListViewModel = ViewModelProviders.of(this,movieFactory).get(MovieListViewModel.class);

       mMovieListViewModel.mMovieList.observe(this, new Observer<List<MovieResult>>() {
           @Override
           public void onChanged(@Nullable List<MovieResult> movieResults) {
               movieAdapter.setMovies(movieResults);
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

        mMovieListViewModel.setmMoviePreference(preference);
        return true;
    }


}
