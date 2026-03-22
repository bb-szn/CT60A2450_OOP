package com.example.week10;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//this class holds all the important methods dealing with the implementation of Recylcerview

    public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MainViewHolder> {

        private List<Movie> movies;

        // Constructor
        public MovieAdapter(List<Movie> examList) {
            this.movies = examList;
        }


        @NonNull //we need to override 3 important methods for the recycler to work
        @Override
        public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.movie_item, parent, false);
            return new MainViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
            Movie movieOne = movies.get(position);

            holder.title.setText(movieOne.getTitle());
            holder.year.setText(movieOne.getYear());
            holder.genre.setText(movieOne.getGenre());
            holder.poster.setText(movieOne.getPosterResource());

        }

        @Override
        public int getItemCount() {
            return movies.size();
        }

        static class MainViewHolder extends RecyclerView.ViewHolder {
            TextView title, year, genre, poster;

            public MainViewHolder(@NonNull View itemView) {

                super(itemView);

                title = itemView.findViewById(R.id.movieTitleTextOut);
                year = itemView.findViewById(R.id.movieYearTextOut);
                genre = itemView.findViewById(R.id.movieGenreTextOut);
                poster = itemView.findViewById(R.id.moviePoster);
            }
        }

    }