package com.rifafauzi.moviecatalogue.di

import com.rifafauzi.moviecatalogue.helper.remote.ApiClient
import com.rifafauzi.moviecatalogue.helper.remote.ApiInterface
import com.rifafauzi.moviecatalogue.helper.repository.Repository
import com.rifafauzi.moviecatalogue.helper.remote.RemoteDataSource

object Injection {

    fun repository(): Repository? {
        val remoteDataSource = RemoteDataSource.getInstance(ApiClient.client.create(ApiInterface::class.java))
        return Repository.getInstance(remoteDataSource)
    }

}
