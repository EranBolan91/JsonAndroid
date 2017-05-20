package com.world.bolandian.jsonandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MovieDataSource.OnDataArrivedListener {
    ArrayList<Movie> movies = new ArrayList<>();
    TextView tvMovies;
    RecyclerView rvMovies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rvMovies = (RecyclerView)findViewById(R.id.rvMovie);

        //first get the movies. after it got all the movies, with the listener
        //it active the method on data arrived and then update all the movies to the adapter
        //with the method runOnUiThread
        //this method fire the whole thing
        MovieDataSource.getMovies(this);



        //tvMovies = (TextView) findViewById(R.id.tvMovies);
        //MovieDataSource.getMovies(this);


      //  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDataArrived(final ArrayList<Movie> Arraymovies,final Exception e) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(e == null){
                    movies = Arraymovies;
                    MovieAdapter adapter = new MovieAdapter(MainActivity.this,movies);
                    rvMovies.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    rvMovies.setAdapter(adapter);
                }else{
                    Toast.makeText(MainActivity.this, e + "", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
