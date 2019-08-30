package com.rifafauzi.moviecatalogue.di;

import com.rifafauzi.moviecatalogue.helper.repository.Repository;
import com.rifafauzi.moviecatalogue.helper.remote.RemoteDataSource;

public class Injection {

    public static Repository repository() {
        return new Repository(new RemoteDataSource());
    }

}
