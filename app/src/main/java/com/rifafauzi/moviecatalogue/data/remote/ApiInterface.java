package com.rifafauzi.moviecatalogue.data.remote;

import com.rifafauzi.moviecatalogue.model.ResponseTvShow;
import com.rifafauzi.moviecatalogue.model.ResponseMovies;

import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("3/discover/movie")
    Call<ResponseMovies> getAllMovies(@Query("api_key") String api_key,
                                      @Query("language") String language,
                                      @Query("sort_by") String sort_by);

    @GET("3/discover/tv")
    Call<ResponseTvShow> getAllTvShow(@Query("api_key") String api_key,
                                      @Query("language") String language,
                                      @Query("sort_by") String sort_by);

}