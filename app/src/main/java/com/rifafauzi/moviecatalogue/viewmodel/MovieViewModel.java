package com.rifafauzi.moviecatalogue.viewmodel;

import androidx.lifecycle.ViewModel;

import com.rifafauzi.moviecatalogue.data.DataDummy;
import com.rifafauzi.moviecatalogue.model.MovieModel;

import java.util.List;

public class MovieViewModel extends ViewModel {

    public MovieModel mMovie;
    private String movieId;

    public MovieModel getMovieModel() {
        for (int i = 0; i < DataDummy.generateDummyMovies().size(); i++) {
            MovieModel movieModel = DataDummy.generateDummyMovies().get(i);
            if (movieModel.getMovieId().equals(movieId)) {
                mMovie = movieModel;
            }
        }
        return mMovie;
    }

    public List<MovieModel> getMovie() {
        return DataDummy.generateDummyMovies();
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }
}
