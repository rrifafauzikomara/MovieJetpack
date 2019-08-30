package com.rifafauzi.moviecatalogue.helper.repository;

import com.rifafauzi.moviecatalogue.helper.data.DataSource;
import com.rifafauzi.moviecatalogue.helper.remote.RemoteDataSource;
import com.rifafauzi.moviecatalogue.model.ResponseMovies;
import com.rifafauzi.moviecatalogue.model.ResponseTvShow;

public class Repository implements DataSource {

    private RemoteDataSource remoteDataSource;

    public Repository(RemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public void getListMovies(GetMoviesCallback getMoviesCallback) {
        remoteDataSource.getListMovies(new GetMoviesCallback() {
            @Override
            public void onMoviesLoaded(ResponseMovies responseMovies) {
                getMoviesCallback.onMoviesLoaded(responseMovies);
            }

            @Override
            public void onDataNotAvailable(String errorMessage) {
                getMoviesCallback.onDataNotAvailable(errorMessage);
            }
        });
    }

    @Override
    public void getListTvShow(GetTvShowCallback getTvShowCallback) {
        remoteDataSource.getListTvShow(new GetTvShowCallback() {
            @Override
            public void onTvShowLoaded(ResponseTvShow responseTvShow) {
                getTvShowCallback.onTvShowLoaded(responseTvShow);
            }

            @Override
            public void onDataNotAvailable(String errorMessage) {
                getTvShowCallback.onDataNotAvailable(errorMessage);
            }
        });
    }
}