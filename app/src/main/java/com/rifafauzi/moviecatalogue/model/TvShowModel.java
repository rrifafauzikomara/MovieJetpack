package com.rifafauzi.moviecatalogue.model;

public class TvShowModel {

    private String tvShowId;
    private String title;
    private String description;
    private String imagePath;
    private String release;

    public TvShowModel(String tvShowId, String title, String description, String imagePath, String release) {
        this.tvShowId = tvShowId;
        this.title = title;
        this.description = description;
        this.imagePath = imagePath;
        this.release = release;
    }

    public String getTvShowId() {
        return tvShowId;
    }

    public void setTvShowId(String tvShowId) {
        this.tvShowId = tvShowId;
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
}
