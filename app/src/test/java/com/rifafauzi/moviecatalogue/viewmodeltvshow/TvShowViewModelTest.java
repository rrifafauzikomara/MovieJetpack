package com.rifafauzi.moviecatalogue.viewmodeltvshow;

import com.rifafauzi.moviecatalogue.model.TvShowModel;
import com.rifafauzi.moviecatalogue.viewmodel.TvShowViewModel;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TvShowViewModelTest {

    private TvShowViewModel tvShowViewModel;
    private TvShowModel dataDummyTvShow;

    @Before
    public void setUp() {
        tvShowViewModel = new TvShowViewModel();
        dataDummyTvShow = new TvShowModel(
                "tv1",
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "tvshow_arrow",
                "October 10, 2012",
                "https://youtu.be/hTv13EjlLNg");
    }

    @Test
    public void getTvShow() {
        List<TvShowModel> tvShowModels = tvShowViewModel.getTvShow();
        assertNotNull(tvShowModels);
        assertEquals(10, tvShowModels.size());
    }

    @Test
    public void getDetailTvShow() {
        TvShowModel tvShowModel = tvShowViewModel.getTvShowModel("tv1");
        assertNotNull(tvShowModel);
        assertEquals(dataDummyTvShow.getTvShowId(), tvShowViewModel.getTvShowModel("tv1").getTvShowId());
        assertEquals(dataDummyTvShow.getTitle(), tvShowViewModel.getTvShowModel("tv1").getTitle());
        assertEquals(dataDummyTvShow.getDescription(), tvShowViewModel.getTvShowModel("tv1").getDescription());
        assertEquals(dataDummyTvShow.getImagePath(), tvShowViewModel.getTvShowModel("tv1").getImagePath());
        assertEquals(dataDummyTvShow.getRelease(), tvShowViewModel.getTvShowModel("tv1").getRelease());
        assertEquals(dataDummyTvShow.getYoutube(), tvShowViewModel.getTvShowModel("tv1").getYoutube());
    }

}