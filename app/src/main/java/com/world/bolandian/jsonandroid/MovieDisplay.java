package com.world.bolandian.jsonandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class MovieDisplay extends AppCompatActivity {
    private TextView tvTitleMD,tvYearMD,tvRatingMD,tvGenreMD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_display);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tvTitleMD = (TextView)findViewById(R.id.tvTitleMD);
        tvYearMD = (TextView)findViewById(R.id.tvYearMD);
        tvRatingMD = (TextView)findViewById(R.id.tvRatingMD);
        tvGenreMD = (TextView)findViewById(R.id.tvGenreMD);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setDataFromAdapter();

    }


    public void setDataFromAdapter(){
        Intent i  = getIntent();
        Movie movie = i.getParcelableExtra(MovieAdapter.MOVIE);

        tvTitleMD.setText(movie.getTitle());
        tvYearMD.setText("Relase year: " +String.valueOf(movie.getReleaseYear()));
        tvRatingMD.setText(String.valueOf(movie.getRating()));
        tvGenreMD.setText(String.valueOf(movie.getGenre()));


    }

}
