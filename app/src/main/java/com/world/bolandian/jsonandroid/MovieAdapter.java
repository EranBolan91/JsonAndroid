package com.world.bolandian.jsonandroid;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

/**
 * Created by Bolandian on 18/05/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private LayoutInflater inflater;
    private Context context;
    private List<Movie> movieList;
    public static final String MOVIE = "movie";


    public MovieAdapter(Context context, List<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.movie_layout,parent,false);
        return new MovieViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.title.setText(movie.getTitle());
        holder.rating.setText(String.valueOf(movie.getRating()));
        holder.releaseYear.setText(String.valueOf(movie.getReleaseYear()));
        holder.genre.setText(String.valueOf(movie.getGenre()));
       // holder.image.setImageDrawable(LoadImageFromWebOperations(movie.getImage()));
      //  holder.image.setImageURI(Uri.parse((movie.getImage())));
        Picasso.with(context).load(movie.getImage()).resize(180,200).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }


    public class MovieViewHolder extends RecyclerView.ViewHolder{
            TextView title,rating,releaseYear,genre;
            ImageView image;

        public MovieViewHolder(View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.tvTitleMovie);
            rating = (TextView)itemView.findViewById(R.id.tvRating);
            releaseYear = (TextView)itemView.findViewById(R.id.tvRelease);
            genre = (TextView)itemView.findViewById(R.id.tvGenre);
            image = (ImageView)itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Movie movie = movieList.get(position);

                    Intent i = new Intent(context,MovieDisplay.class);
                    i.putExtra(MOVIE,movie);

                    context.startActivity(i);

                }
            });
        }

    }

    public static Drawable LoadImageFromWebOperations(String url) {
        try {
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable d = Drawable.createFromStream(is, "src name");
            return d;
        } catch (Exception e) {
            return null;
        }
    }
}
