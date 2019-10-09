package com.rifafauzi.moviecatalogue.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.rifafauzi.moviecatalogue.helper.local.entity.MoviesEntity;
import com.rifafauzi.moviecatalogue.helper.local.entity.TvShowEntity;
import com.rifafauzi.moviecatalogue.helper.repository.Repository;
import com.rifafauzi.moviecatalogue.helper.vo.Resource;

import java.util.List;

public class TvShowViewModel extends ViewModel {

    private Repository repository;

    private MutableLiveData<String> mLogin = new MutableLiveData<>();
    private MutableLiveData<Integer> tvShowId = new MutableLiveData<>();

    public TvShowViewModel(Repository repository) {
        this.repository = repository;
    }

    public LiveData<Resource<List<TvShowEntity>>> tvShow = Transformations.switchMap(mLogin,
            data -> repository.getAllTvShow());

    public void setUsername(String username) {
        mLogin.setValue(username);
    }

    public LiveData<Resource<TvShowEntity>> detailTvShow = Transformations.switchMap(tvShowId,
            tvShowId -> repository.getDetailTvShow(tvShowId));

    public void setTvShowId(Integer tvShowId) {
        this.tvShowId.setValue(tvShowId);
    }

    // Favorite
    public void setFavorite() {
        if (detailTvShow.getValue() != null) {
            TvShowEntity tvShowEntity = detailTvShow.getValue().data;

            if (tvShowEntity != null) {
                // Kode di bawah menggunakan tanda seru (!),
                // karena akan mengganti status dari apakah sudah di bookmark atau tidak menjadi apakah sudah siap dibookmark atau tidak
                final boolean newState = !tvShowEntity.isFavorite();
                repository.setTvShowFavorite(tvShowEntity, newState);
            }
        }
    }

    public LiveData<Resource<PagedList<TvShowEntity>>> getFavorite() {
        return repository.getFavoriteTvShowPaged();
    }

    public void setBookmark(TvShowEntity tvShowEntity) {
        final boolean newState = !tvShowEntity.isFavorite();
        repository.setTvShowFavorite(tvShowEntity, newState);
    }
}
