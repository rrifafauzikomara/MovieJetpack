package com.rifafauzi.moviecatalogue.helper.repository;

import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.rifafauzi.moviecatalogue.helper.data.DataSource;
import com.rifafauzi.moviecatalogue.helper.data.NetworkBoundResource;
import com.rifafauzi.moviecatalogue.helper.local.LocalDataSource;
import com.rifafauzi.moviecatalogue.helper.local.entity.MoviesEntity;
import com.rifafauzi.moviecatalogue.helper.local.entity.TvShowEntity;
import com.rifafauzi.moviecatalogue.helper.remote.ApiResponse;
import com.rifafauzi.moviecatalogue.helper.remote.RemoteDataSource;
import com.rifafauzi.moviecatalogue.helper.vo.Resource;
import com.rifafauzi.moviecatalogue.model.Movies;
import com.rifafauzi.moviecatalogue.utils.AppExecutors;

import java.util.ArrayList;
import java.util.List;

public class Repository implements DataSource {

    private final RemoteDataSource remoteDataSource;
    private final LocalDataSource localDataSource;
    private final AppExecutors appExecutors;
    private volatile static Repository INSTANCE = null;

    public Repository(RemoteDataSource remoteDataSource, LocalDataSource localDataSource, AppExecutors appExecutors) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
        this.appExecutors = appExecutors;
    }


    public static Repository getInstance(RemoteDataSource remoteDataSource, LocalDataSource localDataSource, AppExecutors appExecutors) {
        if (INSTANCE == null) {
            synchronized (Repository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Repository(remoteDataSource, localDataSource, appExecutors);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public LiveData<Resource<List<MoviesEntity>>> getAllMovies() {
        return new NetworkBoundResource<List<MoviesEntity>, List<Movies>>(appExecutors) {
            @Override
            protected LiveData<List<MoviesEntity>> loadFromDB() {
                return localDataSource.getAllMovies();
            }

            @Override
            protected Boolean shouldFetch(List<MoviesEntity> data) {
                return (data == null) || (data.size() == 0);
            }

            @Override
            protected LiveData<ApiResponse<List<Movies>>> createCall() {
                return remoteDataSource.getListMovies();
            }

            @Override
            protected void saveCallResult(List<Movies> data) {
                List<MoviesEntity> moviesEntities = new ArrayList<>();
                for (Movies movies : data) {
                    moviesEntities.add(new MoviesEntity(
                            movies.getId(),
                            movies.getTitle(),
                            movies.getOverview(),
                            movies.getReleaseDate(),
                            null,
                            movies.getPosterPath()));
                }
                localDataSource.insertMovies(moviesEntities);
            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<MoviesEntity>> getDetailMovies(int moviesId) {
        return new NetworkBoundResource<MoviesEntity, List<Movies>>(appExecutors) {

            @Override
            protected LiveData<MoviesEntity> loadFromDB() {
                return localDataSource.getDetailMovies(moviesId);
            }

            @Override
            protected Boolean shouldFetch(MoviesEntity data) {
                return (data == null);
            }

            @Override
            protected LiveData<ApiResponse<List<Movies>>> createCall() {
                return remoteDataSource.getListMovies();
            }

            @Override
            protected void saveCallResult(List<Movies> data) {

            }
        }.asLiveData();
    }

    @Override
    public void setMoviesFavorite(MoviesEntity moviesEntity, boolean state) {
        Runnable runnable = () -> localDataSource.setMoviesFavorite(moviesEntity, state);
        appExecutors.diskIO().execute(runnable);
    }

    @Override
    public LiveData<Resource<PagedList<MoviesEntity>>> getFavoriteMoviesPaged() {
        return new NetworkBoundResource<PagedList<MoviesEntity>, List<Movies>>(appExecutors) {

            @Override
            protected LiveData<PagedList<MoviesEntity>> loadFromDB() {
                return new LivePagedListBuilder<>(localDataSource.getFavoriteMoviesAsPaged(),20).build();
            }

            @Override
            protected Boolean shouldFetch(PagedList<MoviesEntity> data) {
                return false;
            }

            @Override
            protected LiveData<ApiResponse<List<Movies>>> createCall() {
                return null;
            }

            @Override
            protected void saveCallResult(List<Movies> data) {

            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<List<TvShowEntity>>> getAllTvShow() {
        return new NetworkBoundResource<List<TvShowEntity>, List<Movies>>(appExecutors) {

            @Override
            protected LiveData<List<TvShowEntity>> loadFromDB() {
                return localDataSource.getAllTvShow();
            }

            @Override
            protected Boolean shouldFetch(List<TvShowEntity> data) {
                return (data == null) || (data.size() == 0);
            }

            @Override
            protected LiveData<ApiResponse<List<Movies>>> createCall() {
                return remoteDataSource.getListTvShow();
            }

            @Override
            protected void saveCallResult(List<Movies> data) {
                List<TvShowEntity> tvShowEntities = new ArrayList<>();
                for (Movies movies : data) {

                    tvShowEntities.add(new TvShowEntity(
                            movies.getId(),
                            movies.getName(),
                            movies.getOverview(),
                            movies.getFirstAirDate(),
                            null,
                            movies.getPosterPath()));
                }

                localDataSource.insertTvShow(tvShowEntities);

            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<TvShowEntity>> getDetailTvShow(int tvShowId) {
        return new NetworkBoundResource<TvShowEntity, List<Movies>>(appExecutors) {

            @Override
            protected LiveData<TvShowEntity> loadFromDB() {
                return localDataSource.getDetailTvShow(tvShowId);
            }

            @Override
            protected Boolean shouldFetch(TvShowEntity data) {
                return (data == null);
            }

            @Override
            protected LiveData<ApiResponse<List<Movies>>> createCall() {
                return remoteDataSource.getListMovies();
            }

            @Override
            protected void saveCallResult(List<Movies> data) {

            }
        }.asLiveData();
    }

    @Override
    public void setTvShowFavorite(TvShowEntity tvShowEntity, boolean state) {
        Runnable runnable = () -> localDataSource.setTvShowFavorite(tvShowEntity, state);
        appExecutors.diskIO().execute(runnable);
    }

    @Override
    public LiveData<Resource<PagedList<TvShowEntity>>> getFavoriteTvShowPaged() {
        return new NetworkBoundResource<PagedList<TvShowEntity>, List<Movies>>(appExecutors) {
            @Override
            protected LiveData<PagedList<TvShowEntity>> loadFromDB() {
                return new LivePagedListBuilder<>(localDataSource.getFavoriteTvShowAsPaged(),20).build();
            }

            @Override
            protected Boolean shouldFetch(PagedList<TvShowEntity> data) {
                return false;
            }

            @Override
            protected LiveData<ApiResponse<List<Movies>>> createCall() {
                return null;
            }

            @Override
            protected void saveCallResult(List<Movies> data) {

            }
        }.asLiveData();
    }
}