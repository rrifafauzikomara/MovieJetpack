package com.rifafauzi.moviecatalogue.viewmodel;

import androidx.lifecycle.ViewModel;

import com.rifafauzi.moviecatalogue.data.DataSource;
import com.rifafauzi.moviecatalogue.data.Repository;
import com.rifafauzi.moviecatalogue.model.ResponseTvShow;
import com.rifafauzi.moviecatalogue.navigator.TvShowNavigator;


public class TvShowViewModel extends ViewModel {

    private Repository repository;
    private TvShowNavigator tvShowNavigator;

    public TvShowViewModel(Repository repository) {
        this.repository = repository;
    }

    public void setTvShowNavigator(TvShowNavigator navigator) {
        tvShowNavigator = navigator;
    }

    //    public TvShow getTvShowModel(String tvShowId) {
//        for (int i = 0; i < DataDummy.generateDummyMovies().size(); i++) {
//            TvShow tvShow = DataDummy.generateDummyTvShow().get(i);
//            if (tvShow.getTvShowId().equals(tvShowId)) {
//                mTvShow = tvShow;
//            }
//        }
//        return mTvShow;
//    }

    public void getListTvShow() {
        tvShowNavigator.showProgress();
        repository.getListTvShow(new DataSource.GetTvShowCallback() {
            @Override
            public void onTvShowLoaded(ResponseTvShow responseTvShow) {
                tvShowNavigator.hideProgress();
                tvShowNavigator.loadListTvShow(responseTvShow.getTvShows());
            }

            @Override
            public void onDataNotAvailable(String errorMessage) {
                tvShowNavigator.hideProgress();
                tvShowNavigator.errorLoadListTvShow(errorMessage);
            }
        });
    }

}