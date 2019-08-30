package com.rifafauzi.moviecatalogue.viewmodelmovie;

import com.rifafauzi.moviecatalogue.model.Movies;
import com.rifafauzi.moviecatalogue.viewmodel.MovieViewModel;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MovieViewModelTest {

    private MovieViewModel movieViewModel;
    private Movies dataDummyMovie;

    @Before
    public void setUp() {
        movieViewModel = new MovieViewModel();
        dataDummyMovie = new Movies(
                "m1",
                "A Star Is Born",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "movie_a_start_is_born",
                "October 3, 2018",
                "https://youtu.be/nSbzyEJ8X9E");
    }

    @Test
    public void getMovie() {
        List<Movies> movies = movieViewModel.getMovie();
        assertNotNull(movies);
        assertEquals(10, movies.size());
    }

    @Test
    public void getDetailMovie() {
        Movies movieModels = movieViewModel.getMovieModel("m1");
        assertNotNull(movieModels);
        assertEquals(dataDummyMovie.getMovieId(), movieViewModel.getMovieModel("m1").getMovieId());
        assertEquals(dataDummyMovie.getTitle(), movieViewModel.getMovieModel("m1").getTitle());
        assertEquals(dataDummyMovie.getDescription(), movieViewModel.getMovieModel("m1").getDescription());
        assertEquals(dataDummyMovie.getImagePath(), movieViewModel.getMovieModel("m1").getImagePath());
        assertEquals(dataDummyMovie.getRelease(), movieViewModel.getMovieModel("m1").getRelease());
        assertEquals(dataDummyMovie.getYoutube(), movieViewModel.getMovieModel("m1").getYoutube());
    }

}