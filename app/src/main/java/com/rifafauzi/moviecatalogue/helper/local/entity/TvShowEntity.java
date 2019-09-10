package com.rifafauzi.moviecatalogue.helper.local.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tvshow")
public class TvShowEntity {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "tvShowId")
    private String tvShowId;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "release")
    private String release;

    @ColumnInfo(name = "favorite")
    private boolean favorite = false;

    @ColumnInfo(name = "imagePath")
    private String imagePath;

    public TvShowEntity(@NonNull String tvShowId, String title, String description, String release, boolean favorite, String imagePath) {
        this.tvShowId = tvShowId;
        this.title = title;
        this.description = description;
        this.release = release;
        this.favorite = favorite;
        this.imagePath = imagePath;
    }

    @NonNull
    public String getTvShowId() {
        return tvShowId;
    }

    public void setTvShowId(@NonNull String tvShowId) {
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

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
