package com.world.bolandian.jsonandroid;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Bolandian on 16/05/2017.
 */

public class Movie implements Parcelable {

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

    protected Movie(Parcel in) {
        title = in.readString();
        image = in.readString();
        rating = in.readDouble();
        releaseYear = in.readInt();
        genre = in.createStringArrayList();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

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
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(image);
        dest.writeDouble(rating);
        dest.writeInt(releaseYear);
        dest.writeStringList(genre);
    }
}
