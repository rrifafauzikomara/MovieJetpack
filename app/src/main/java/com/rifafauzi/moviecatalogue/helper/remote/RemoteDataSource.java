package com.rifafauzi.moviecatalogue.helper.remote;

import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.rifafauzi.moviecatalogue.adapter.Contract;
import com.rifafauzi.moviecatalogue.model.Movies;
import com.rifafauzi.moviecatalogue.model.ResponseMovies;
import com.rifafauzi.moviecatalogue.utils.EspressoIdlingResource;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RemoteDataSource {

    private static RemoteDataSource INSTANCE;
    private ApiInterface apiInterface;
    private final long SERVICE_LATENCY_IN_MILLIS = 2000;

    private RemoteDataSource(ApiInterface apiInterface) {
        this.apiInterface = apiInterface;
    }

    public static RemoteDataSource getInstance(ApiInterface apiInterface) {
        if (INSTANCE == null) {
            INSTANCE = new RemoteDataSource(apiInterface);
        }
        return INSTANCE;
    }

    public LiveData<ApiResponse<List<Movies>>> getListMovies() {
        EspressoIdlingResource.increment();
        MutableLiveData<ApiResponse<List<Movies>>> resultMovies = new MutableLiveData<>();

        Handler handler = new Handler();
        handler.postDelayed(() -> {
            Call<ResponseMovies> call = apiInterface.getAllMovies(Contract.API_KEY, Contract.LANG, Contract.SORT_BY);
            call.enqueue(new Callback<ResponseMovies>() {
                @Override
                public void onResponse(Call<ResponseMovies> call, Response<ResponseMovies> response) {
                    resultMovies.setValue(ApiResponse.success(response.body().getMovies()));
                    if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow()) {
                        EspressoIdlingResource.decrement();
                    }
                }

                @Override
                public void onFailure(Call<ResponseMovies> call, Throwable t) {

                }
            });
        }, SERVICE_LATENCY_IN_MILLIS);

        return resultMovies;

    }

    public void getMoviesDetail(String movieId, GetMoviesDetailCallback getMoviesDetailCallback) {
        EspressoIdlingResource.increment();
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            Call<Movies> call = apiInterface.getDetailMovie(movieId, Contract.API_KEY, Contract.LANG);
            call.enqueue(new Callback<Movies>() {
                @Override
                public void onResponse(@NonNull Call<Movies> call, @NonNull Response<Movies> response) {
                    getMoviesDetailCallback.onMoviesDetailLoaded(response.body());
                    if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow()) {
                        EspressoIdlingResource.decrement();
                    }
                }

                @Override
                public void onFailure(@NonNull Call<Movies> call, @NonNull Throwable t) {
                    getMoviesDetailCallback.onDataNotAvailable(t.toString());
                }
            });
        }, SERVICE_LATENCY_IN_MILLIS);
    }

    public LiveData<ApiResponse<List<Movies>>> getListTvShow() {
        EspressoIdlingResource.increment();
        MutableLiveData<ApiResponse<List<Movies>>> resultTvShow = new MutableLiveData<>();

        Handler handler = new Handler();
        handler.postDelayed(() -> {
            Call<ResponseMovies> call = apiInterface.getAllTvShow(Contract.API_KEY, Contract.LANG, Contract.SORT_BY);
            call.enqueue(new Callback<ResponseMovies>() {
                @Override
                public void onResponse(Call<ResponseMovies> call, Response<ResponseMovies> response) {
                    resultTvShow.setValue(ApiResponse.success(response.body().getMovies()));
                    if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow()) {
                        EspressoIdlingResource.decrement();
                    }
                }

                @Override
                public void onFailure(Call<ResponseMovies> call, Throwable t) {

                }
            });
        }, SERVICE_LATENCY_IN_MILLIS);

        return resultTvShow;

    }

    public void getTvShowDetail(String tv_id, GetTvShowDetailCallback getTvShowDetailCallback) {
        EspressoIdlingResource.increment();
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            Call<Movies> call = apiInterface.getDetailTvShow(tv_id, Contract.API_KEY, Contract.LANG);
            call.enqueue(new Callback<Movies>() {
                @Override
                public void onResponse(@NonNull Call<Movies> call, @NonNull Response<Movies> response) {
                    getTvShowDetailCallback.onTvShowDetailLoaded(response.body());
                    if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow()) {
                        EspressoIdlingResource.decrement();
                    }
                }

                @Override
                public void onFailure(@NonNull Call<Movies> call, @NonNull Throwable t) {
                    getTvShowDetailCallback.onDataNotAvailable(t.toString());
                }
            });
        }, SERVICE_LATENCY_IN_MILLIS);
    }

    public interface GetMoviesCallback {
        void onMoviesLoaded(List<Movies> responseMovies);

        void onDataNotAvailable(String errorMessage);
    }

    public interface GetTvShowCallback {
        void onTvShowLoaded(List<Movies> responseTvShow);

        void onDataNotAvailable(String errorMessage);
    }

    public interface GetMoviesDetailCallback {
        void onMoviesDetailLoaded(Movies responseMovies);

        void onDataNotAvailable(String errorMessage);
    }

    public interface GetTvShowDetailCallback {
        void onTvShowDetailLoaded(Movies responseTvShow);

        void onDataNotAvailable(String errorMessage);
    }
}