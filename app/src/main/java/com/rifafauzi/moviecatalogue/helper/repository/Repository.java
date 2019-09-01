package com.rifafauzi.moviecatalogue.helper.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.rifafauzi.moviecatalogue.helper.data.DataSource;
import com.rifafauzi.moviecatalogue.helper.remote.RemoteDataSource;
import com.rifafauzi.moviecatalogue.model.Movies;
import com.rifafauzi.moviecatalogue.model.ResponseMovies;
import com.rifafauzi.moviecatalogue.model.ResponseTvShow;
import com.rifafauzi.moviecatalogue.model.TvShow;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Repository implements DataSource {

    private RemoteDataSource remoteDataSource;

    private volatile static Repository INSTANCE = null;

    private Repository(RemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    public static Repository getInstance(RemoteDataSource remoteDataSource) {
        if (INSTANCE == null) {
            synchronized (Repository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Repository(remoteDataSource);
                }
            }
        }
        return INSTANCE;
    }

    @NotNull
    @Override
    public LiveData<List<Movies>> getMovieList() {
        MutableLiveData<List<Movies>> listMovies = new MutableLiveData<>();
        remoteDataSource.getListMovies(new RemoteDataSource.GetMoviesCallback() {
            @Override
            public void onMoviesLoaded(ResponseMovies responseMovies) {
                listMovies.postValue(responseMovies.getMovies());
            }

            @Override
            public void onDataNotAvailable(String errorMessage) {

            }
        });
        return listMovies;
    }

    @NotNull
    @Override
    public LiveData<Movies> getMovieDetail(int movieId) {
        MutableLiveData<Movies> moviesDetail = new MutableLiveData<>();
        remoteDataSource.getMoviesDetail(movieId, new RemoteDataSource.GetMoviesDetailCallback() {
            @Override
            public void onMoviesDetailLoaded(Movies responseMovies) {
                moviesDetail.postValue(responseMovies);
            }

            @Override
            public void onDataNotAvailable(String errorMessage) {

            }
        });
        return moviesDetail;
    }

    @NotNull
    @Override
    public LiveData<List<TvShow>> getTvShowsList() {
        MutableLiveData<List<TvShow>> listTvShow = new MutableLiveData<>();
        remoteDataSource.getListTvShow(new RemoteDataSource.GetTvShowCallback() {
            @Override
            public void onTvShowLoaded(ResponseTvShow responseTvShow) {
                listTvShow.postValue(responseTvShow.getTvShows());
            }

            @Override
            public void onDataNotAvailable(String errorMessage) {

            }
        });
        return listTvShow;
    }

    @NotNull
    @Override
    public LiveData<TvShow> getTvShowsDetail(int tvId) {
        MutableLiveData<TvShow> tvShowDetail = new MutableLiveData<>();
        remoteDataSource.getTvShowDetail(tvId, new RemoteDataSource.GetTvShowDetailCallback() {
            @Override
            public void onTvShowDetailLoaded(TvShow responseTvShow) {
                tvShowDetail.postValue(responseTvShow);
            }

            @Override
            public void onDataNotAvailable(String errorMessage) {

            }
        });
        return tvShowDetail;
    }
}