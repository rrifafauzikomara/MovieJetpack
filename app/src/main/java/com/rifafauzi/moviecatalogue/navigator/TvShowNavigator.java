package com.rifafauzi.moviecatalogue.navigator;

import com.rifafauzi.moviecatalogue.model.TvShow;

import java.util.List;


public interface TvShowNavigator {

    void showProgress();
    void hideProgress();
    void loadListTvShow(List<TvShow> tvShowList);
    void errorLoadListTvShow(String message);

}
