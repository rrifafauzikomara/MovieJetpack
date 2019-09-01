package com.rifafauzi.moviecatalogue.helper.repository;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.rifafauzi.moviecatalogue.helper.remote.RemoteDataSource;
import com.rifafauzi.moviecatalogue.model.Movies;
import com.rifafauzi.moviecatalogue.model.TvShow;
import com.rifafauzi.moviecatalogue.utils.FakeData;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

public class RepositoryTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    private RemoteDataSource remote = Mockito.mock(RemoteDataSource.class);
    private FakeRepository fakeRepository = new FakeRepository(remote);

    private List<Movies> moviesList = FakeData.generateDummyMovies();
    private String movieId = String.valueOf(moviesList.get(0).getId());
    private List<TvShow> tvShowsList = FakeData.generateDummyTvShow();
    private String tvShowId = String.valueOf(tvShowsList.get(0).getId());
    private Movies movies;
    private TvShow tvShow;

    @Before
    public void setUp(){
        movies = new Movies(
                "/dzBtMocZuJbjLOXvrl4zGYigDzh.jpg",
                "Simba idolises his father, King Mufasa, and takes to heart his own royal destiny. But not everyone in the kingdom celebrates the new cub's arrival. Scar, Mufasa's brother—and former heir to the throne—has plans of his own. The battle for Pride Rock is ravaged with betrayal, tragedy and drama, ultimately resulting in Simba's exile. With help from a curious pair of newfound friends, Simba will have to figure out how to grow up and take back what is rightfully his.",
                "2019-07-12",
                420818,
                "The Lion King"
        );

        tvShow = new TvShow(
                "/b71BaRjp9TwxUZodLGgSRIlkfL8.jpg",
                "The dramatisation of one of the most notorious killing sprees in British history.",
                "",
                11634,
                ""
        );
    }

    @After
    public void tearDown(){

    }


    @Test
    public void getMovieList() {
    }

    @Test
    public void getMovieDetail() {
    }

    @Test
    public void getTvShowsList() {
    }

    @Test
    public void getTvShowsDetail() {
    }
}