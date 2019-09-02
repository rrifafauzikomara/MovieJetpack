package com.rifafauzi.moviecatalogue.di;

import com.rifafauzi.moviecatalogue.helper.remote.ApiClient;
import com.rifafauzi.moviecatalogue.helper.remote.ApiInterface;
import com.rifafauzi.moviecatalogue.helper.repository.Repository;
import com.rifafauzi.moviecatalogue.helper.remote.RemoteDataSource;

public class Injection {

    public static Repository repository() {
        RemoteDataSource remoteDataSource = RemoteDataSource.getInstance(ApiClient.getClient().create(ApiInterface.class));
        return Repository.getInstance(remoteDataSource);
    }

}