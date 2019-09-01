package com.rifafauzi.moviecatalogue.helper.remote;

import androidx.annotation.NonNull;

import com.rifafauzi.moviecatalogue.adapter.Contract;
import com.rifafauzi.moviecatalogue.model.ResponseMovies;
import com.rifafauzi.moviecatalogue.model.ResponseTvShow;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RemoteDataSource {

    private static RemoteDataSource INSTANCE;
    private ApiInterface apiInterface;

    private RemoteDataSource(ApiInterface apiInterface) {
        this.apiInterface = apiInterface;
    }

    public static RemoteDataSource getInstance(ApiInterface apiInterface) {
        if (INSTANCE == null) {
            INSTANCE = new RemoteDataSource(apiInterface);
        }
        return INSTANCE;
    }

    public void getListMovies(GetMoviesCallback getMoviesCallback) {
        Call<ResponseMovies> call = apiInterface.getAllMovies(Contract.API_KEY, Contract.LANG, Contract.SORT_BY);
        call.enqueue(new Callback<ResponseMovies>() {
            @Override
            public void onResponse(@NonNull Call<ResponseMovies> call, @NonNull Response<ResponseMovies> response) {
                getMoviesCallback.onMoviesLoaded(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<ResponseMovies> call, @NonNull Throwable t) {
                getMoviesCallback.onDataNotAvailable(t.toString());
            }
        });
    }

    public void getListTvShow(GetTvShowCallback getTvShowCallback) {
        Call<ResponseTvShow> call = apiInterface.getAllTvShow(Contract.API_KEY, Contract.LANG, Contract.SORT_BY);
        call.enqueue(new Callback<ResponseTvShow>() {
            @Override
            public void onResponse(@NonNull Call<ResponseTvShow> call, @NonNull Response<ResponseTvShow> response) {
                getTvShowCallback.onTvShowLoaded(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<ResponseTvShow> call, @NonNull Throwable t) {
                getTvShowCallback.onDataNotAvailable(t.toString());
            }
        });
    }

    public interface GetMoviesCallback {
        void onMoviesLoaded(ResponseMovies responseMovies);
        void onDataNotAvailable(String errorMessage);
    }

    public interface GetTvShowCallback {
        void onTvShowLoaded(ResponseTvShow responseTvShow);
        void onDataNotAvailable(String errorMessage);
    }
}