package com.rifafauzi.moviecatalogue.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

import com.rifafauzi.moviecatalogue.helper.repository.Repository
import com.rifafauzi.moviecatalogue.model.TvShow


class TvShowViewModel internal constructor(private val repository: Repository) : ViewModel() {

    val listTvShow: LiveData<List<TvShow>>
        get() = repository.getTvShowsList()

    fun getDetailTvShow(tvId: String): LiveData<TvShow> {
        return repository.getTvShowsDetail(tvId)
    }

}