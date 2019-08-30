package com.rifafauzi.moviecatalogue.viewmodel;

import androidx.lifecycle.ViewModel;

import com.rifafauzi.moviecatalogue.helper.data.DataSource;
import com.rifafauzi.moviecatalogue.helper.repository.Repository;
import com.rifafauzi.moviecatalogue.model.ResponseMovies;
import com.rifafauzi.moviecatalogue.navigator.MoviesNavigator;


public class MovieViewModel extends ViewModel {

    private Repository repository;
    private MoviesNavigator moviesNavigator;

    public MovieViewModel(Repository repository) {
        this.repository = repository;
    }

    public void setMoviesNavigator(MoviesNavigator navigator) {
        moviesNavigator = navigator;
    }

//    public Movies getMovieModel(String movieId) {
//        for (int i = 0; i < DataDummy.generateDummyMovies().size(); i++) {
//            Movies movies = DataDummy.generateDummyMovies().get(i);
//            if (movies.getMovieId().equals(movieId)) {
//                mMovie = movies;
//            }
//        }
//        return mMovie;
//    }

    public void getListMovies() {
        moviesNavigator.showProgress();
        repository.getListMovies(new DataSource.GetMoviesCallback() {
            @Override
            public void onMoviesLoaded(ResponseMovies responseMovies) {
                moviesNavigator.hideProgress();
                moviesNavigator.loadListMovies(responseMovies.getMovies());
            }

            @Override
            public void onDataNotAvailable(String errorMessage) {
                moviesNavigator.hideProgress();
                moviesNavigator.errorLoadListMovies(errorMessage);
            }
        });
    }
}
