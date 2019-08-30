package com.rifafauzi.moviecatalogue.data.remote;

import androidx.annotation.NonNull;

import com.rifafauzi.moviecatalogue.adapter.Contract;
import com.rifafauzi.moviecatalogue.data.DataSource;
import com.rifafauzi.moviecatalogue.model.ResponseMovies;
import com.rifafauzi.moviecatalogue.model.ResponseTvShow;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RemoteDataSource implements DataSource {

    private ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

    @Override
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

    @Override
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
}
