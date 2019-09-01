package com.rifafauzi.moviecatalogue.helper.remote;

import com.rifafauzi.moviecatalogue.model.Movies;
import com.rifafauzi.moviecatalogue.model.ResponseTvShow;
import com.rifafauzi.moviecatalogue.model.ResponseMovies;
import com.rifafauzi.moviecatalogue.model.TvShow;

import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.http.Path;
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

    @GET("3/movie/{movie_id}")
    Call<Movies> getDetailMovie(@Path("movie_id") int movie_id,
                                @Query("api_key") String api_key,
                                @Query("language") String language);

    @GET("3/tv/{tv_id}")
    Call<TvShow> getDetailTvShow(@Path("tv_id") int tv_id,
                                        @Query("api_key") String api_key,
                                        @Query("language") String language);

}