package com.rifafauzi.moviecatalogue.helper.local.room;

import androidx.annotation.WorkerThread;
import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.rifafauzi.moviecatalogue.helper.local.entity.MoviesEntity;
import com.rifafauzi.moviecatalogue.helper.local.entity.TvShowEntity;

import java.util.List;

@Dao
public interface MoviesDao {

    //movies
    @WorkerThread
    @Query("SELECT * FROM movies")
    LiveData<List<MoviesEntity>> getMovies();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertMovies(List<MoviesEntity> moviesEntities);

    @WorkerThread
    @Query("SELECT * FROM movies where favorite = 1")
    DataSource.Factory<Integer, MoviesEntity> getFavoritedMoviesAsPaged();

    @Update(onConflict = OnConflictStrategy.FAIL)
    int updateMovies(MoviesEntity moviesEntity);

    @Query("SELECT * FROM movies WHERE id = :id")
    LiveData<MoviesEntity> getDetailMovies(int id);


    //tv show
    @WorkerThread
    @Query("SELECT * FROM tvshow")
    LiveData<List<TvShowEntity>> getTvShow();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertTvShow(List<TvShowEntity> tvShowEntities);

    @WorkerThread
    @Query("SELECT * FROM tvshow where favorite = 1")
    DataSource.Factory<Integer, TvShowEntity> getFavoritedTvShowAsPaged();

    @Update(onConflict = OnConflictStrategy.FAIL)
    int updateTvShow(TvShowEntity tvShowEntity);

    @Query("SELECT * FROM tvshow WHERE id = :id")
    LiveData<TvShowEntity> getDetailTvShow(int id);


}
