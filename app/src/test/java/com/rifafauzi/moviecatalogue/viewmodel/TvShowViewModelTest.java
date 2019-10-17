package com.rifafauzi.moviecatalogue.viewmodel;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;

import com.rifafauzi.moviecatalogue.helper.local.entity.TvShowEntity;
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

public class TvShowViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private TvShowViewModel viewModel;
    private Repository repository = mock(Repository.class);
    private TvShowEntity dummyTvShow = FakeData.generateDummyLocalTvShow().get(0);
    private int tvShowId = dummyTvShow.getId();

    @Before
    public void setUp() {
        viewModel = new TvShowViewModel(repository);
        viewModel.setTvShowId(tvShowId);
        viewModel.setFavorite();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getListTvShow() {
        Resource<List<TvShowEntity>> resource = Resource.success(FakeData.generateDummyLocalTvShow());
        MutableLiveData<Resource<List<TvShowEntity>>> dummyCourses = new MutableLiveData<>();
        dummyCourses.setValue(resource);

        when(repository.getAllTvShow()).thenReturn(dummyCourses);

        Observer<Resource<List<TvShowEntity>>> observer = mock(Observer.class);

        String username = "Dicoding";
        viewModel.setUsername(username);

        viewModel.tvShow.observeForever(observer);

        verify(observer).onChanged(resource);
    }

    @Test
    public void getDetailTvShow() {
        Resource<TvShowEntity> resource = Resource.success(FakeData.getTvShowsDetail(dummyTvShow, true));
        MutableLiveData<Resource<TvShowEntity>> courseEntities = new MutableLiveData<>();
        courseEntities.setValue(resource);

        when(repository.getDetailTvShow(tvShowId)).thenReturn(courseEntities);

        Observer<Resource<TvShowEntity>> observer = mock(Observer.class);
        viewModel.detailTvShow.observeForever(observer);

        verify(observer).onChanged(resource);
    }

    @Test
    public void getFavorite() {
        MutableLiveData<Resource<PagedList<TvShowEntity>>> dummyCourse = new MutableLiveData<>();
        PagedList<TvShowEntity> pagedList = mock(PagedList.class);

        dummyCourse.setValue(Resource.success(pagedList));

        when(repository.getFavoriteTvShowPaged()).thenReturn(dummyCourse);

        Observer<Resource<PagedList<TvShowEntity>>> observer = mock(Observer.class);

        viewModel.getFavorite().observeForever(observer);

        verify(observer).onChanged(Resource.success(pagedList));
    }
}