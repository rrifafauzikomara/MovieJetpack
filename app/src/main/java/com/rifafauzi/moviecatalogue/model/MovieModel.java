package com.rifafauzi.moviecatalogue.model;

public class MovieModel {

    private String movieId;
    private String title;
    private String description;
    private String imagePath;
    private String release;
    private String youtube;

    public MovieModel(String movieId, String title, String description, String imagePath, String release, String youtube) {
        this.movieId = movieId;
        this.title = title;
        this.description = description;
        this.imagePath = imagePath;
        this.release = release;
        this.youtube = youtube;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }
}
