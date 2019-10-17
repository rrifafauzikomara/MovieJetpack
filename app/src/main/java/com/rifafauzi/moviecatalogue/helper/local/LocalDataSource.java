package com.rifafauzi.moviecatalogue.helper.local;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;

import com.rifafauzi.moviecatalogue.helper.local.entity.MoviesEntity;
import com.rifafauzi.moviecatalogue.helper.local.entity.TvShowEntity;
import com.rifafauzi.moviecatalogue.helper.local.room.MoviesDao;

import java.util.List;

public class LocalDataSource {

    private final MoviesDao moviesDao;
    private static LocalDataSource INSTANCE;

    public LocalDataSource(MoviesDao moviesDao) {
        this.moviesDao = moviesDao;
    }

    public static LocalDataSource getInstance(MoviesDao moviesDao) {
        if (INSTANCE == null) {
            INSTANCE = new LocalDataSource(moviesDao);
        }
        return INSTANCE;
    }

    public LiveData<List<MoviesEntity>> getAllMovies() {
        return moviesDao.getMovies();
    }

    public void insertMovies(List<MoviesEntity> movies) {
        moviesDao.insertMovies(movies);
    }

    public LiveData<MoviesEntity> getDetailMovies(int id) {
        return moviesDao.getDetailMovies(id);
    }

    public DataSource.Factory<Integer, MoviesEntity> getFavoriteMoviesAsPaged() {
        return moviesDao.getFavoritedMoviesAsPaged();
    }

    public void setMoviesFavorite(MoviesEntity movies, boolean newState) {
        movies.setFavorite(newState);
        moviesDao.updateMovies(movies);
    }


    public LiveData<List<TvShowEntity>> getAllTvShow() {
        return moviesDao.getTvShow();
    }

    public void insertTvShow(List<TvShowEntity> tvShow) {
        moviesDao.insertTvShow(tvShow);
    }

    public LiveData<TvShowEntity> getDetailTvShow(int id) {
        return moviesDao.getDetailTvShow(id);
    }

    public DataSource.Factory<Integer, TvShowEntity> getFavoriteTvShowAsPaged() {
        return moviesDao.getFavoritedTvShowAsPaged();
    }

    public void setTvShowFavorite(TvShowEntity tvShow, boolean newState) {
        tvShow.setFavorite(newState);
        moviesDao.updateTvShow(tvShow);
    }

}
