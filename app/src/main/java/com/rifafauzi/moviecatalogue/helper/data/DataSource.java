package com.rifafauzi.moviecatalogue.helper.data;

import com.rifafauzi.moviecatalogue.model.ResponseMovies;
import com.rifafauzi.moviecatalogue.model.ResponseTvShow;

public interface DataSource {

    void getListMovies(GetMoviesCallback getMoviesCallback);
//    void getDetailMovies(String movieId);
    void getListTvShow(GetTvShowCallback getTvShowCallback);
//    void getDetailTvShow(String tvShowId);


    interface GetMoviesCallback {
        void onMoviesLoaded(ResponseMovies responseMovies);
        void onDataNotAvailable(String errorMessage);
    }

    interface GetTvShowCallback {
        void onTvShowLoaded(ResponseTvShow responseTvShow);
        void onDataNotAvailable(String errorMessage);
    }

}
