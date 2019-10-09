package com.rifafauzi.moviecatalogue.helper.repository;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;

import com.rifafauzi.moviecatalogue.helper.local.LocalDataSource;
import com.rifafauzi.moviecatalogue.helper.local.entity.MoviesEntity;
import com.rifafauzi.moviecatalogue.helper.local.entity.TvShowEntity;
import com.rifafauzi.moviecatalogue.helper.remote.RemoteDataSource;
import com.rifafauzi.moviecatalogue.helper.vo.Resource;
import com.rifafauzi.moviecatalogue.model.Movies;
import com.rifafauzi.moviecatalogue.utils.FakeData;
import com.rifafauzi.moviecatalogue.utils.InstantAppExecutors;
import com.rifafauzi.moviecatalogue.utils.LiveDataTestUtil;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RepositoryTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private LocalDataSource local = mock(LocalDataSource.class);
    private RemoteDataSource remote = mock(RemoteDataSource.class);
    private InstantAppExecutors instantAppExecutors = mock(InstantAppExecutors.class);
    private FakeRepository fakeRepository = new FakeRepository(remote, local, instantAppExecutors);

    private List<Movies> moviesResponses = FakeData.generateDummyApiMovies();
    private List<MoviesEntity> moviesEntities = FakeData.generateDummyLocalMovies();
    private int moviesId = moviesResponses.get(0).getId();

    private List<Movies> tvShowResponses = FakeData.generateDummyApiTvShow();
    private List<TvShowEntity> tvShowEntities = FakeData.generateDummyLocalTvShow();
    private int tvShowId = tvShowResponses.get(0).getId();

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void getAllMovies() {
        MutableLiveData<List<MoviesEntity>> listMutableLiveData = new MutableLiveData<>();
        listMutableLiveData.setValue(moviesEntities);

        when(local.getAllMovies()).thenReturn(listMutableLiveData);

        Resource<List<MoviesEntity>> result = LiveDataTestUtil.getValue(fakeRepository.getAllMovies());

        verify(local).getAllMovies();
        assertNotNull(result.data);
        assertEquals(moviesResponses.size(), result.data.size());
    }

    @Test
    public void getDetailMovies() {
        MutableLiveData<MoviesEntity> dummyEntity = new MutableLiveData<>();
        dummyEntity.setValue(FakeData.getMovieDetail(FakeData.generateDummyLocalMovies().get(0), false));

        when(local.getDetailMovies(moviesId)).thenReturn(dummyEntity);

        Resource<MoviesEntity> result = LiveDataTestUtil.getValue(fakeRepository.getDetailMovies(moviesId));

        verify(local).getDetailMovies(moviesId);
        assertNotNull(result.data);
        assertNotNull(result.data.getTitle());
        assertEquals(moviesResponses.get(0).getTitle(), result.data.getTitle());
    }



    @Test
    public void getAllTvShow() {
        MutableLiveData<List<TvShowEntity>> listMutableLiveData = new MutableLiveData<>();
        listMutableLiveData.setValue(tvShowEntities);

        when(local.getAllTvShow()).thenReturn(listMutableLiveData);

        Resource<List<TvShowEntity>> result = LiveDataTestUtil.getValue(fakeRepository.getAllTvShow());

        verify(local).getAllTvShow();
        assertNotNull(result.data);
        assertEquals(tvShowResponses.size(), result.data.size());
    }

    @Test
    public void getDetailTvShow() {
        MutableLiveData<TvShowEntity> dummyEntity = new MutableLiveData<>();
        dummyEntity.setValue(FakeData.getTvShowsDetail(FakeData.generateDummyLocalTvShow().get(0), false));

        when(local.getDetailTvShow(tvShowId)).thenReturn(dummyEntity);

        Resource<TvShowEntity> result = LiveDataTestUtil.getValue(fakeRepository.getDetailTvShow(tvShowId));

        verify(local).getDetailTvShow(tvShowId);
        assertNotNull(result.data);
        assertNotNull(result.data.getName());
        assertEquals(tvShowResponses.get(0).getName(), result.data.getName());
    }

}