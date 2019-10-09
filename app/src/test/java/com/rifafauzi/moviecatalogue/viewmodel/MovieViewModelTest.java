package com.rifafauzi.moviecatalogue.viewmodel;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;

import com.rifafauzi.moviecatalogue.helper.local.entity.MoviesEntity;
import com.rifafauzi.moviecatalogue.helper.repository.Repository;
import com.rifafauzi.moviecatalogue.helper.vo.Resource;
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

    private MovieViewModel viewModel;
    private Repository repository = mock(Repository.class);
    private String USERNAME = "Dicoding";
    private MoviesEntity dummyMovies = FakeData.generateDummyLocalMovies().get(0);
    private int moviesId = dummyMovies.getId();

    @Before
    public void setUp() {
        viewModel = new MovieViewModel(repository);
        viewModel.setMovieId(moviesId);
        viewModel.setFavorite();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getListMovies() {
        Resource<List<MoviesEntity>> resource = Resource.success(FakeData.generateDummyLocalMovies());
        MutableLiveData<Resource<List<MoviesEntity>>> dummyCourses = new MutableLiveData<>();
        dummyCourses.setValue(resource);

        when(repository.getAllMovies()).thenReturn(dummyCourses);

        Observer<Resource<List<MoviesEntity>>> observer = mock(Observer.class);

        viewModel.setUsername(USERNAME);

        viewModel.movies.observeForever(observer);

        verify(observer).onChanged(resource);
    }

    @Test
    public void getDetailMovies() {
        Resource<MoviesEntity> resource = Resource.success(FakeData.getMovieDetail(dummyMovies, true));
        MutableLiveData<Resource<MoviesEntity>> courseEntities = new MutableLiveData<>();
        courseEntities.setValue(resource);

        when(repository.getDetailMovies(moviesId)).thenReturn(courseEntities);

        Observer<Resource<MoviesEntity>> observer = mock(Observer.class);
        viewModel.detailMovies.observeForever(observer);

        verify(observer).onChanged(resource);
    }

    @Test
    public void getFavorite() {
        MutableLiveData<Resource<PagedList<MoviesEntity>>> dummyCourse = new MutableLiveData<>();
        PagedList<MoviesEntity> pagedList = mock(PagedList.class);

        dummyCourse.setValue(Resource.success(pagedList));

        when(repository.getFavoriteMoviesPaged()).thenReturn(dummyCourse);

        Observer<Resource<PagedList<MoviesEntity>>> observer = mock(Observer.class);

        viewModel.getFavorite().observeForever(observer);

        verify(observer).onChanged(Resource.success(pagedList));
    }
}