package com.world.bolandian.jsonandroid;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Bolandian on 16/05/2017.
 */

public class MovieDataSource {

    public interface OnDataArrivedListener{
        void onDataArrived(ArrayList<Movie> movies, Exception e);
    }

    public static void getMovies(final OnDataArrivedListener listener){
        Thread movieThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String json = StreamIO.readWebSite("http://api.androidhive.info/json/movies.json");
                    ArrayList<Movie> movies = parse(json);
                    listener.onDataArrived(movies, null);
                } catch (Exception e) {
                    listener.onDataArrived(null, e);
                }
            }
        });
        movieThread.start();
    }


    private static ArrayList<Movie> parse(String json) throws Exception{

        ArrayList<Movie> movies = new ArrayList<>();
        JSONArray moviesArray = new JSONArray(json);

        for (int i = 0; i < moviesArray.length(); i++) {
            ArrayList<String> genres = new ArrayList<>();
            JSONObject movieObject = moviesArray.getJSONObject(i);
            String title = movieObject.getString("title");
            String image = movieObject.getString("image");
            double rating = movieObject.getDouble("rating");
            int releaseYear = movieObject.getInt("releaseYear");
            JSONArray genresArray = movieObject.getJSONArray("genre");
            for (int j = 0; j < genresArray.length(); j++) {
                String genre = genresArray.getString(j);
                genres.add((genre));
            }
            Movie m = new Movie(title, image, rating, releaseYear, genres);
            movies.add(m);
        }
        return movies;
    }
}

