package com.rifafauzi.moviecatalogue.di;

import android.app.Application;

import com.rifafauzi.moviecatalogue.helper.local.LocalDataSource;
import com.rifafauzi.moviecatalogue.helper.local.room.MoviesDatabase;
import com.rifafauzi.moviecatalogue.helper.remote.ApiClient;
import com.rifafauzi.moviecatalogue.helper.remote.ApiInterface;
import com.rifafauzi.moviecatalogue.helper.remote.RemoteDataSource;
import com.rifafauzi.moviecatalogue.helper.repository.Repository;
import com.rifafauzi.moviecatalogue.utils.AppExecutors;

public class Injection {

    public static Repository repository(Application application) {

        MoviesDatabase database = MoviesDatabase.getInstance(application);

        RemoteDataSource remoteRepository = RemoteDataSource.getInstance(ApiClient.getClient().create(ApiInterface.class));
        LocalDataSource localRepository = LocalDataSource.getInstance(database.moviesDao());
        AppExecutors appExecutors = new AppExecutors();

        return Repository.getInstance(remoteRepository, localRepository, appExecutors);
    }

}