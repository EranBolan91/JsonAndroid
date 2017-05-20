package com.world.bolandian.jsonandroid;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by Bolandian on 16/05/2017.
 */

public class MyThread extends Thread {
    @Override
    public void run() {
        try {
            String json = StreamIO.readWebSite("http://api.androidhive.info/json/movies.json");
            Log.d("ness",json);
            try {
                JSONArray moviesArray = new JSONArray(json);
                for (int i = 0; i < moviesArray.length() ; i++) {
                    JSONObject movieObject = moviesArray.getJSONObject(i);
                    String title = movieObject.getString("title");
                    Log.d("type",title);
                    String image = movieObject.getString("image");
                    Log.d("type",image);
                    double rating = movieObject.getDouble("rating");
                    Log.d("type",rating +"");
                    int releaseYear = movieObject.getInt("releaseYear");
                    Log.d("type",releaseYear +"");
                    JSONArray genresArray = movieObject.getJSONArray("genre");
                    for (int j = 0; j < genresArray.length() ; j++) {
                        String genre = genresArray.getString(j);
                        Log.d("type",genre);
                    }

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
