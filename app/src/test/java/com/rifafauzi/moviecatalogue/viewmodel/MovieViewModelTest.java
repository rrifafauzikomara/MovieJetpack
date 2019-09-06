package com.rifafauzi.moviecatalogue.viewmodel;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.rifafauzi.moviecatalogue.helper.repository.Repository;
import com.rifafauzi.moviecatalogue.model.Movies;
import com.rifafauzi.moviecatalogue.utils.FakeData;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MovieViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private MovieViewModel movieViewModel;
    private Repository repository = mock(Repository.class);
    private List<Movies> moviesList = FakeData.generateDummyMovies();
    private MutableLiveData<List<Movies>> moviesMutableList = new MutableLiveData<>();

    private Movies moviesDetail = FakeData.getMovieDetail();
    private String moviesId = String.valueOf(moviesDetail.getId());
    private MutableLiveData<Movies> moviesMutableDetail = new MutableLiveData<>();

    @Before
    public void setUp() {
        movieViewModel = new MovieViewModel(repository);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getListMovies() {
        moviesMutableList.setValue(moviesList);
        when(repository.getMovieList()).thenReturn(moviesMutableList);
        Observer<List<Movies>> observer = mock(Observer.class);
        movieViewModel.getListMovies().observeForever(observer);
        verify(observer).onChanged(moviesList);
    }

    @Test
    public void getDetailMovie() {
        moviesMutableDetail.setValue(moviesDetail);
        when(repository.getMovieDetail(moviesId)).thenReturn(moviesMutableDetail);
        Observer<Movies> observer = mock(Observer.class);
        movieViewModel.getDetailMovie(moviesId).observeForever(observer);
        verify(observer).onChanged(moviesDetail);
    }

}
