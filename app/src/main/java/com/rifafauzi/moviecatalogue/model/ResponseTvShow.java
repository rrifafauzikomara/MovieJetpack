package com.rifafauzi.moviecatalogue.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseTvShow {

    @SerializedName("results")
    @Expose
    private List<TvShow> tvShows;

    public ResponseTvShow(List<TvShow> tvShows) {
        this.tvShows = tvShows;
    }

    public List<TvShow> getTvShows() {
        return tvShows;
    }

}
