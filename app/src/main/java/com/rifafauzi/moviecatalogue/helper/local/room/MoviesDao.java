package com.rifafauzi.moviecatalogue.helper.local.room;

import androidx.annotation.WorkerThread;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.rifafauzi.moviecatalogue.helper.local.entity.MoviesEntity;
import com.rifafauzi.moviecatalogue.helper.local.entity.TvShowEntity;
import com.rifafauzi.moviecatalogue.model.Movies;
import com.rifafauzi.moviecatalogue.model.TvShow;

import java.util.List;

@Dao
public interface MoviesDao {

    //movies
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertMovies(List<Movies> movies);

    @WorkerThread
    @Query("SELECT * FROM movies")
    LiveData<List<MoviesEntity>> getMoviesFav();


    //tv show
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertTvShow(List<TvShow> tvShows);

    @WorkerThread
    @Query("SELECT * FROM tvshow")
    LiveData<List<TvShowEntity>> getTvShowFav();

}
