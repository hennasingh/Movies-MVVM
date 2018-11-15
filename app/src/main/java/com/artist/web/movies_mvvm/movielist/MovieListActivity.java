package com.artist.web.movies_mvvm.movielist;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.artist.web.movies_mvvm.MovieFactoryViewModel;
import com.artist.web.movies_mvvm.R;
import com.artist.web.movies_mvvm.helpers.Utils;
import com.artist.web.movies_mvvm.model.MovieResult;

import java.util.List;

public class MovieListActivity extends AppCompatActivity {

    private static final String TAG = MovieListActivity.class.getSimpleName();
    RecyclerView mRecyclerView;
    private MovieListViewModel mMovieListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        MovieFactoryViewModel movieFactoryViewModel = Utils.provideMovieFactory();
        mMovieListViewModel = ViewModelProviders.of(this, movieFactoryViewModel)
                .get(MovieListViewModel.class);

        mMovieListViewModel.getMovieList().observe(this, new Observer<List<MovieResult>>() {
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
        mMovieListViewModel.setMoviePreference(preference);
        return true;
    }


}
