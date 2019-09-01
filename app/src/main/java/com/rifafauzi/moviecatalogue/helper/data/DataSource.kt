package com.rifafauzi.moviecatalogue.helper.data

import androidx.lifecycle.LiveData
import com.rifafauzi.moviecatalogue.model.Movies
import com.rifafauzi.moviecatalogue.model.TvShow

interface DataSource {
    fun getMovieList(): LiveData<List<Movies>>
    fun getMovieDetail(movieId : Int) : LiveData<Movies>
    fun getTvShowsList(): LiveData<List<TvShow>>
    fun getTvShowsDetail(tvId : Int) : LiveData<TvShow>
}