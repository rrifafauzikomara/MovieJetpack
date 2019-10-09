package com.rifafauzi.moviecatalogue.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.rifafauzi.moviecatalogue.helper.local.entity.MoviesEntity;
import com.rifafauzi.moviecatalogue.helper.repository.Repository;
import com.rifafauzi.moviecatalogue.helper.vo.Resource;

import java.util.List;

public class MovieViewModel extends ViewModel {

    private Repository repository;

    private MutableLiveData<String> mLogin = new MutableLiveData<>();
    private MutableLiveData<Integer> movieId = new MutableLiveData<>();


    public MovieViewModel(Repository repository) {
        this.repository = repository;
    }

    public LiveData<Resource<List<MoviesEntity>>> movies = Transformations.switchMap(mLogin,
            data -> repository.getAllMovies());

    public LiveData<Resource<MoviesEntity>> detailMovies = Transformations.switchMap(movieId,
            movieId -> repository.getDetailMovies(movieId));

    public void setUsername(String username) {
        mLogin.setValue(username);
    }

    public void setMovieId(Integer movieId) {
        this.movieId.setValue(movieId);
    }

    // Favorite
    public void setFavorite() {
        if (detailMovies.getValue() != null) {
            MoviesEntity moviesEntity = detailMovies.getValue().data;

            if (moviesEntity != null) {
                // Kode di bawah menggunakan tanda seru (!),
                // karena akan mengganti status dari apakah sudah di bookmark atau tidak menjadi apakah sudah siap dibookmark atau tidak
                final boolean newState = !moviesEntity.isFavorite();
                repository.setMoviesFavorite(moviesEntity, newState);
            }
        }
    }

    LiveData<Resource<PagedList<MoviesEntity>>> getFavorite() {
        return repository.getFavoriteMoviesPaged();
    }

    void setBookmark(MoviesEntity moviesEntity) {
        final boolean newState = !moviesEntity.isFavorite();
        repository.setMoviesFavorite(moviesEntity, newState);
    }

}
