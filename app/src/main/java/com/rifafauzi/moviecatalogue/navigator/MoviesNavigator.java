package com.rifafauzi.moviecatalogue.navigator;

import com.rifafauzi.moviecatalogue.model.Movies;

import java.util.List;


public interface MoviesNavigator {

    void showProgress();
    void hideProgress();
    void loadListMovies(List<Movies> moviesList);
    void errorLoadListMovies(String message);

}
