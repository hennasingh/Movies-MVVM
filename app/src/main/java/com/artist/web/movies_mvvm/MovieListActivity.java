package com.artist.web.movies_mvvm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MovieListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
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
        displayResults(preference);
        return true;
    }

    private void displayResults(String preference) {
    }
}
