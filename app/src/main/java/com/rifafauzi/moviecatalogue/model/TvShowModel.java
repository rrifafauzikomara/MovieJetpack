package com.rifafauzi.moviecatalogue.model;

public class TvShowModel {

    private String tvShowId;
    private String title;
    private String description;
    private String imagePath;
    private String release;
    private String youtube;

    public TvShowModel(String tvShowId, String title, String description, String imagePath, String release, String youtube) {
        this.tvShowId = tvShowId;
        this.title = title;
        this.description = description;
        this.imagePath = imagePath;
        this.release = release;
        this.youtube = youtube;
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

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }
}
