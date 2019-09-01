package com.rifafauzi.moviecatalogue.helper.data

import androidx.lifecycle.LiveData
import com.rifafauzi.moviecatalogue.model.Movies
import com.rifafauzi.moviecatalogue.model.TvShow

interface DataSource {
    fun getMovieList(): LiveData<List<Movies>>
    fun getTvShowsList(): LiveData<List<TvShow>>
}