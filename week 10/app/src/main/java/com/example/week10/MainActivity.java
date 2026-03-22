package com.example.week10;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        MovieAdapter movieAdapter;



        RecyclerView movieRecyclerView = findViewById(R.id.recyclerViewOut);

        //get data from json data
        List<Movie> movies =  JsonUtils.loadMoviesFromJson(this);

        if (movies != null) {
            movieAdapter = new MovieAdapter(movies);
            movieRecyclerView.setAdapter(movieAdapter);
        } else {
            Log.e("MainActivity", "Failed to load movies from JSON.");
        }












        movieRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        MovieAdapter adapter = new MovieAdapter(movies);
        movieRecyclerView.setAdapter(adapter);
    }
}