package com.rifafauzi.moviecatalogue.viewmodel;

import androidx.lifecycle.ViewModel;

import com.rifafauzi.moviecatalogue.data.DataDummy;
import com.rifafauzi.moviecatalogue.model.TvShowModel;

import java.util.List;

public class TvShowViewModel extends ViewModel {

    private TvShowModel mTvShow;
    private String tvShowId;

    public TvShowModel getTvShowModel() {
        for (int i = 0; i < DataDummy.generateDummyTvShow().size(); i++) {
            TvShowModel tvShowModel = DataDummy.generateDummyTvShow().get(i);
            if (tvShowModel.getTvShowId().equals(tvShowId)) {
                mTvShow = tvShowModel;
            }
        }
        return mTvShow;
    }

    public List<TvShowModel> getTvShow() {
        return DataDummy.generateDummyTvShow();
    }

    public String getTvShowId() {
        return tvShowId;
    }

    public void setTvShowId(String tvShowId) {
        this.tvShowId = tvShowId;
    }
}