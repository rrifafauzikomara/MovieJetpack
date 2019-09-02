package com.rifafauzi.moviecatalogue.helper.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import com.rifafauzi.moviecatalogue.helper.data.DataSource
import com.rifafauzi.moviecatalogue.helper.remote.RemoteDataSource
import com.rifafauzi.moviecatalogue.model.Movies
import com.rifafauzi.moviecatalogue.model.TvShow

class Repository private constructor(private val remoteDataSource: RemoteDataSource) : DataSource {

    override fun getMovieList(): LiveData<List<Movies>> {
        val listMovies = MutableLiveData<List<Movies>>()
        remoteDataSource.getListMovies(object : RemoteDataSource.GetMoviesCallback {
            override fun onMoviesLoaded(responseMovies: List<Movies>) {
                listMovies.postValue(responseMovies)
            }

            override fun onDataNotAvailable(errorMessage: String) {

            }
        })
        return listMovies
    }

    override fun getMovieDetail(movieId: String): LiveData<Movies> {
        val moviesDetail = MutableLiveData<Movies>()
        remoteDataSource.getMoviesDetail(movieId, object : RemoteDataSource.GetMoviesDetailCallback {
            override fun onMoviesDetailLoaded(responseMovies: Movies) {
                moviesDetail.postValue(responseMovies)
            }

            override fun onDataNotAvailable(errorMessage: String) {

            }
        })
        return moviesDetail
    }

    override fun getTvShowsList(): LiveData<List<TvShow>> {
        val listTvShow = MutableLiveData<List<TvShow>>()
        remoteDataSource.getListTvShow(object : RemoteDataSource.GetTvShowCallback {
            override fun onTvShowLoaded(responseTvShow: List<TvShow>) {
                listTvShow.postValue(responseTvShow)
            }

            override fun onDataNotAvailable(errorMessage: String) {

            }
        })
        return listTvShow
    }

    override fun getTvShowsDetail(tvId: String): LiveData<TvShow> {
        val tvShowDetail = MutableLiveData<TvShow>()
        remoteDataSource.getTvShowDetail(tvId, object : RemoteDataSource.GetTvShowDetailCallback {
            override fun onTvShowDetailLoaded(responseTvShow: TvShow) {
                tvShowDetail.postValue(responseTvShow)
            }

            override fun onDataNotAvailable(errorMessage: String) {

            }
        })
        return tvShowDetail
    }

    companion object {

        @Volatile
        private var INSTANCE: Repository? = null

        fun getInstance(remoteDataSource: RemoteDataSource): Repository? {
            if (INSTANCE == null) {
                synchronized(Repository::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Repository(remoteDataSource)
                    }
                }
            }
            return INSTANCE
        }
    }
}