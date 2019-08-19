package com.rifafauzi.moviecatalogue.viewmodel;

import androidx.lifecycle.ViewModel;

import com.rifafauzi.moviecatalogue.data.DataDummy;
import com.rifafauzi.moviecatalogue.model.MovieModel;

import java.util.List;

public class MovieViewModel extends ViewModel {

    public List<MovieModel> getMovie() {
        return DataDummy.generateDummyMovies();
    }
}
