package com.rifafauzi.moviecatalogue.helper.remote

import com.rifafauzi.moviecatalogue.model.Movies
import com.rifafauzi.moviecatalogue.model.ResponseMovies

import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @GET("3/discover/movie")
    fun getAllMovies(@Query("api_key") api_key: String,
                     @Query("language") language: String,
                     @Query("sort_by") sort_by: String): Call<ResponseMovies>

    @GET("3/discover/tv")
    fun getAllTvShow(@Query("api_key") api_key: String,
                     @Query("language") language: String,
                     @Query("sort_by") sort_by: String): Call<ResponseMovies>

    @GET("3/movie/{movie_id}")
    fun getDetailMovie(@Path("movie_id") movie_id: String,
                       @Query("api_key") api_key: String,
                       @Query("language") language: String): Call<Movies>

    @GET("3/tv/{tv_id}")
    fun getDetailTvShow(@Path("tv_id") tv_id: String,
                        @Query("api_key") api_key: String,
                        @Query("language") language: String): Call<Movies>

}