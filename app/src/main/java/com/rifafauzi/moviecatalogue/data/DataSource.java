package com.rifafauzi.moviecatalogue.data;

import com.rifafauzi.moviecatalogue.model.ResponseMovies;
import com.rifafauzi.moviecatalogue.model.ResponseTvShow;

public interface DataSource {

    void getListMovies(GetMoviesCallback getMoviesCallback);
    void getListTvShow(GetTvShowCallback getTvShowCallback);


    interface GetMoviesCallback {
        void onMoviesLoaded(ResponseMovies responseMovies);
        void onDataNotAvailable(String errorMessage);
    }

    interface GetTvShowCallback {
        void onTvShowLoaded(ResponseTvShow responseTvShow);
        void onDataNotAvailable(String errorMessage);
    }

}
