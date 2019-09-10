package com.rifafauzi.moviecatalogue.helper.local.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "movies")
public class MoviesEntity {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "moviesId")
    private String moviesId;

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

    public MoviesEntity(@NonNull String moviesId, String title, String description, String release, boolean favorite, String imagePath) {
        this.moviesId = moviesId;
        this.title = title;
        this.description = description;
        this.release = release;
        this.favorite = favorite;
        this.imagePath = imagePath;
    }

    @NonNull
    public String getMoviesId() {
        return moviesId;
    }

    public void setMoviesId(@NonNull String moviesId) {
        this.moviesId = moviesId;
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
