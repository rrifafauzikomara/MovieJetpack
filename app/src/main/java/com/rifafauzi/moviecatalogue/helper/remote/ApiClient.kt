package com.rifafauzi.moviecatalogue.helper.remote

import com.google.gson.GsonBuilder
import com.rifafauzi.moviecatalogue.adapter.Contract

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    // set your desired log level
    // add logging as last interceptor
    // <-- this is the important line!
    // start converter json
    val client: Retrofit
        get() {

            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor(logging)
            val gson = GsonBuilder().setLenient().create()

            return Retrofit.Builder().baseUrl(Contract.BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).client(httpClient.build()).build()
        }

}