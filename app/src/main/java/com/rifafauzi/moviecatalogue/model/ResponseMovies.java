package com.rifafauzi.moviecatalogue.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseMovies {

    @SerializedName("results")
    @Expose
    private List<Movies> movies;

    public ResponseMovies(List<Movies> movies) {
        this.movies = movies;
    }

    public List<Movies> getMovies() {
        return movies;
    }

}