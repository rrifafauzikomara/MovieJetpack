package com.rifafauzi.moviecatalogue.helper.data;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

import com.rifafauzi.moviecatalogue.helper.local.entity.MoviesEntity;
import com.rifafauzi.moviecatalogue.helper.local.entity.TvShowEntity;
import com.rifafauzi.moviecatalogue.helper.vo.Resource;

import java.util.List;

public interface DataSource {

    LiveData<Resource<List<MoviesEntity>>> getAllMovies();

    LiveData<Resource<MoviesEntity>> getDetailMovies(int moviesId);

    void setMoviesFavorite(MoviesEntity moviesEntity, boolean state);

    LiveData<Resource<PagedList<MoviesEntity>>> getFavoriteMoviesPaged();

    LiveData<Resource<List<TvShowEntity>>> getAllTvShow();

    LiveData<Resource<TvShowEntity>> getDetailTvShow(int tvShowId);

    void setTvShowFavorite(TvShowEntity tvShowEntity, boolean state);

    LiveData<Resource<PagedList<TvShowEntity>>> getFavoriteTvShowPaged();

}
