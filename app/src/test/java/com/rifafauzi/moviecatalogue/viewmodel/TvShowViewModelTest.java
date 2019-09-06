package com.rifafauzi.moviecatalogue.viewmodel;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.rifafauzi.moviecatalogue.helper.repository.Repository;
import com.rifafauzi.moviecatalogue.model.TvShow;
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

    private TvShowViewModel tvShowViewModel;
    private Repository repository = mock(Repository.class);
    private List<TvShow> tvShowList = FakeData.generateDummyTvShow();
    private MutableLiveData<List<TvShow>> tvShowMutableList = new MutableLiveData<>();

    private TvShow tvShowDetail = FakeData.getTvShowsDetail();
    private String tvShowId = String.valueOf(tvShowDetail.getId());
    private MutableLiveData<TvShow> tvShowMutableDetail = new MutableLiveData<>();

    @Before
    public void setUp() {
        tvShowViewModel = new TvShowViewModel(repository);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getListTvShow() {
        tvShowMutableList.setValue(tvShowList);
        when(repository.getTvShowsList()).thenReturn(tvShowMutableList);
        Observer<List<TvShow>> observer = mock(Observer.class);
        tvShowViewModel.getListTvShow().observeForever(observer);
        verify(observer).onChanged(tvShowList);
    }

    @Test
    public void getDetailTvShow() {
        tvShowMutableDetail.setValue(tvShowDetail);
        when(repository.getTvShowsDetail(tvShowId)).thenReturn(tvShowMutableDetail);
        Observer<TvShow> observer = mock(Observer.class);
        tvShowViewModel.getDetailTvShow(tvShowId).observeForever(observer);
        verify(observer).onChanged(tvShowDetail);
    }

}
