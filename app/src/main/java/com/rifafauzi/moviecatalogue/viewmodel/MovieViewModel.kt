package com.rifafauzi.moviecatalogue.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

import com.rifafauzi.moviecatalogue.helper.repository.Repository
import com.rifafauzi.moviecatalogue.model.Movies


class MovieViewModel internal constructor(private val repository: Repository) : ViewModel() {

    val listMovies: LiveData<List<Movies>>
        get() = repository.getMovieList()

    fun getDetailMovie(movieId: String): LiveData<Movies> {
        return repository.getMovieDetail(movieId)
    }
}
