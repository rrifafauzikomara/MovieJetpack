package com.rifafauzi.moviecatalogue.viewmodel;

import androidx.lifecycle.ViewModel;

import com.rifafauzi.moviecatalogue.data.DataDummy;
import com.rifafauzi.moviecatalogue.model.TvShowModel;

import java.util.List;

public class TvShowViewModel extends ViewModel {

    public List<TvShowModel> getTvShow() {
        return DataDummy.generateDummyTvShow();
    }

}