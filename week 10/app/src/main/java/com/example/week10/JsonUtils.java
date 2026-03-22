package com.example.week10;

import android.content.Context;
import android.util.Log;

import com.example.week10.Movie;
import com.example.week10.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    //function to load movies from the JSON file
    public static List<Movie> loadMoviesFromJson(Context context) {
        List<Movie> movieList = new ArrayList<>();

        try {
            //open the JSON file from res/raw (we put it into raw so it doesnt interfere with other files)
            InputStream inputStream = context.getResources()
                    .openRawResource(R.raw.movies);

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(inputStream, StandardCharsets.UTF_8)
            );

            //convert json to string
            StringBuilder jsonText = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                jsonText.append(line);
            }
            reader.close();

            //convert string to json array
            JSONArray moviesJsonArray = new JSONArray(jsonText.toString());

            //loop trough each entry in the array
            for (int i = 0; i < moviesJsonArray.length(); i++) {

                JSONObject movieJson = moviesJsonArray.optJSONObject(i);

                //we skip if something went wrong
                if (movieJson == null) {
                    Log.w("JsonUtils", "Skipped a null movie object");
                    continue;
                }

                //get values safely, set defaults in case something happens
                String title = movieJson.optString("title", "Unknown Title");
                String year = movieJson.optString("year", "Unknown Year");
                String genre = movieJson.optString("genre", "Unknown Genre");
                String poster = movieJson.optString("poster", "defaultPoster");


                //create Movie object and add to the list
                Movie movie = new Movie(title, year, genre, poster);
                movieList.add(movie);
            }

        } catch (Exception e) {
            Log.e("JsonUtils", "Error reading JSON file", e);
            return null;
        }

        //return the list of movies at the end of iterating
        return movieList;
    }
}