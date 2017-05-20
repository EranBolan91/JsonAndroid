package com.world.bolandian.jsonandroid;

import java.util.ArrayList;

/**
 * Created by Bolandian on 16/05/2017.
 */

public class Movie {

    private final String title;
    private final String image;
    private final double rating;
    private final int releaseYear;
    private final ArrayList<String> genre;

    public Movie(String title, String image, double rating, int releaseYear, ArrayList<String> genre) {
        this.title = title;
        this.image = image;
        this.rating = rating;
        this.releaseYear = releaseYear;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public double getRating() {
        return rating;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public ArrayList<String> getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", rating=" + rating +
                ", releaseYear=" + releaseYear +
                ", genre=" + genre +
                '}';
    }
}
