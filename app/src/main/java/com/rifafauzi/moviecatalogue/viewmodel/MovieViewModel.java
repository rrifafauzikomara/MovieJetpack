package com.rifafauzi.moviecatalogue.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.rifafauzi.moviecatalogue.helper.repository.Repository;
import com.rifafauzi.moviecatalogue.model.Movies;

import java.util.List;


public class MovieViewModel extends ViewModel {

    private Repository repository;

    MovieViewModel(Repository repository) {
        this.repository = repository;
    }

    public LiveData<List<Movies>> getListMovies() {
        return repository.getMovieList();
    }

    public LiveData<Movies> getDetailMovie(String movieId) {
        return repository.getMovieDetail(movieId);
    }
}
