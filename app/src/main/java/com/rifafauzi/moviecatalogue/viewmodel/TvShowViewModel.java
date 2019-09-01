package com.rifafauzi.moviecatalogue.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.rifafauzi.moviecatalogue.helper.repository.Repository;
import com.rifafauzi.moviecatalogue.model.TvShow;

import java.util.List;


public class TvShowViewModel extends ViewModel {

    private Repository repository;

    public TvShowViewModel(Repository repository) {
        this.repository = repository;
    }

    public LiveData<List<TvShow>> getListTvShow() {
        return repository.getTvShowsList();
    }

    public LiveData<TvShow> getDetailTvShow(int tvId) {
        return repository.getTvShowsDetail(tvId);
    }

}