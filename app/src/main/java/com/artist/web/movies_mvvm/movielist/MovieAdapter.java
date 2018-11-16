package com.artist.web.movies_mvvm.movielist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.artist.web.movies_mvvm.R;
import com.artist.web.movies_mvvm.model.MovieResult;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private List<MovieResult> movieList;


    public MovieAdapter(){
     }

      public void setMovies(List<MovieResult> movies){
        movieList = movies;
        notifyDataSetChanged();
      }
      @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_item_view,viewGroup,
                false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder movieViewHolder, int position) {
          MovieResult movie = movieList.get(position);
          MovieViewHolder.bindTo(movie);

    }

    @Override
    public int getItemCount() {
        if(movieList==null)return 0;
        return movieList.size();
    }

    static class MovieViewHolder extends RecyclerView.ViewHolder {

        private static TextView mMovieName;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            mMovieName = itemView.findViewById(R.id.movie_name);

        }

        public static void bindTo(MovieResult movie) {
            String name = movie.getTitle();
            mMovieName.setText(name);
        }
    }
}
